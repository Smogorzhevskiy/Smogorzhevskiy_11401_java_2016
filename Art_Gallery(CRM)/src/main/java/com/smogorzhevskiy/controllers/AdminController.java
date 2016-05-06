package com.smogorzhevskiy.controllers;
import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.entities.enums.Role;
import com.smogorzhevskiy.forms.AdminRegistrationForm;
import com.smogorzhevskiy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AdminController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AdminService adminService;

    @Qualifier("adminRegFormValidator")
    @Autowired
    Validator validator;

    @RequestMapping(value = "/sysadmin", method = RequestMethod.GET)
    public String publAddBook(Model model){
        Credential credential = (Credential)request.getSession().getAttribute("user");
        model.addAttribute("user", credential);
        model.addAttribute("admin_form", new AdminRegistrationForm());
        model.addAttribute("admins", adminService.findAllByCredential_Role(Role.ROLE_ADMIN));
        return "/sysadmin";
    }

    @RequestMapping(value = "/sysadmin", method = RequestMethod.POST)
    public String indexSysadmin(@ModelAttribute("admin_form") @Valid AdminRegistrationForm form,
                                RedirectAttributes redirectAttributes, BindingResult result){
        validator.validate(form,result);
        if (result.hasErrors()) {
            redirectAttributes.addAttribute("error", true);
            return "redirect:/sysadmin";
        }
        adminService.createAdmin(form);
        return "redirect:/sysadmin";
    }
}
