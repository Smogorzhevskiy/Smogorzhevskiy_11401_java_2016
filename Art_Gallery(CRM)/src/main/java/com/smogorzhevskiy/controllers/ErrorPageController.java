package com.smogorzhevskiy.controllers;

import com.smogorzhevskiy.entities.Credential;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 03.05.16.
 */
@Controller
@RequestMapping("/403")
public class ErrorPageController {
    public String errorPage(Model model, HttpServletRequest request) {
        Credential credential = (Credential) request.getSession().getAttribute("user");
        model.addAttribute("user", credential);
        return "/403";
    }
}

