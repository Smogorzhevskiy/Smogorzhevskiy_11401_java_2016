package com.smogorzhevskiy.controllers;

import com.smogorzhevskiy.entities.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 06.05.16.
 */
@Controller
public class AuthenticController {
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String def() {
        request.getSession().setAttribute("user", null);
        return "redirect:/main#slide-6";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "redirect:/main#slide-6";
    }

    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public String afterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            request.getSession().setAttribute("user",SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            return "redirect:/admin";
        } else if (request.isUserInRole("ROLE_ARTIST")) {
            request.getSession().setAttribute("user",SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            return "redirect:/artist";
        } else if (request.isUserInRole("ROLE_VIEWER")) {
            request.getSession().setAttribute("user",SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            return "redirect:/viewer";
        } else if (request.isUserInRole("ROLE_SYSADMIN")) {
            request.getSession().setAttribute("user",SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            return "redirect:/sysadmin";
        } else {
            request.getSession().setAttribute("user", null);
            return "/main";
        }
    }
}
