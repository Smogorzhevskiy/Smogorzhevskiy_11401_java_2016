package com.smogorzhevskiy.controllers;
import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "")
    public String adminDefault( RedirectAttributes redirectAttributes){
        Credential role = (Credential) request.getSession().getAttribute("user");
        redirectAttributes.addAttribute("login", role.getLogin());
        return "redirect:/admin/{login}";
    }

    @RequestMapping(value = "/{login}")
    public String adminIndex(Model model, @PathVariable Credential credentail){
        Credential role = (Credential) request.getSession().getAttribute("user");
        model.addAttribute("user", role);
        model.addAttribute("admin", adminService.findOneByCredential(credentail));
        return "/admin";
    }
}
