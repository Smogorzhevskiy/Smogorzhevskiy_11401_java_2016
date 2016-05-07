package com.smogorzhevskiy.controllers;

import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "")
    public String adminProfile(Model model) {
        Credential credential = (Credential) request.getSession().getAttribute("user");
        model.addAttribute("user", credential);
        model.addAttribute("admin", adminService.findOneByCredential(credential));
        return "/admin";
    }

}
