package com.smogorzhevskiy.controllers;

import com.smogorzhevskiy.forms.ArtistCreationForm;
import com.smogorzhevskiy.repository.ArtistRepository;
import com.smogorzhevskiy.service.ArtistService;
import com.smogorzhevskiy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
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
    ArtistService artistService;
    @Qualifier("artistFormValidator")  //валидация
    @Autowired
    Validator validator;


    @RequestMapping(value = "/artist", method = RequestMethod.GET)
    public String getModerRegForm(Model model, @RequestParam(value = "error", required = false) Boolean error) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        model.addAttribute("artist_form", new ArtistCreationForm());
        return "/artist_reg";
    }

    @RequestMapping(value = "/artist", method = RequestMethod.POST)
    public String registerModer(@ModelAttribute("moder_form") @Valid ArtistCreationForm form, BindingResult result) {
        validator.validate(form, result);
        if (result.hasErrors()) {
            return "/artist_reg";
        }
        artistService.createArtist(form);
        return "redirect:/login";
    }


//        @RequestMapping(value = "/worker", method = RequestMethod.GET)
//        public String getPublisherRegForm(Model model,@RequestParam(value = "error", required = false) Boolean error) {
//            if (Boolean.TRUE.equals(error)) {
//                model.addAttribute("error", error);
//            }
//            model.addAttribute("publ_form", new WorkerRegistrationForm());
//            return "/worker_rig";
//        }
//
//        @RequestMapping(value = "/worker", method = RequestMethod.POST)
//        public String registerPubl(@ModelAttribute("publ_form") @Valid WorkerRegistrationForm form,
//                                   BindingResult result) {
//            validator.validate(form, result);
//            if (result.hasErrors()) {
//                return "/publisher_registration";
//            }
//            workerService.createPublisher(form);
//            return "redirect:/login";
//        }
}
