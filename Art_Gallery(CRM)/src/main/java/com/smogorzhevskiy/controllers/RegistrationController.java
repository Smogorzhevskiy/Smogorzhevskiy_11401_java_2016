package com.smogorzhevskiy.controllers;

import com.smogorzhevskiy.forms.ArtistCreationForm;
import com.smogorzhevskiy.service.ArtistService;
import com.smogorzhevskiy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {
    @Autowired
    AdminService adminService;
    @Autowired
    ArtistService artistService;


    @RequestMapping(value = "/artist", method = RequestMethod.GET)
    public String getPublisherRegForm(Model model, @RequestParam(value = "error", required = false) Boolean error) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        model.addAttribute("publ_form", new ArtistCreationForm());
        return "/artist_reg";
    }

    @RequestMapping(value = "/artist", method = RequestMethod.POST)
    public String registerPubl(@ModelAttribute("artist_form") @Valid ArtistCreationForm form, BindingResult result,
                               RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addAttribute("error", true);
            return "redirect:/registration/artist";
        }
        artistService.addArtist(form);
        return "redirect:/login";
    }
}