package com.smogorzhevskiy.controllers;

import com.smogorzhevskiy.forms.ArtistCreationForm;
import com.smogorzhevskiy.forms.ViewerRegistrationForm;
import com.smogorzhevskiy.repository.ArtistRepository;
import com.smogorzhevskiy.service.ArtistService;
import com.smogorzhevskiy.service.AdminService;
import com.smogorzhevskiy.service.ViewerService;
import com.smogorzhevskiy.utility.validators.ArtistFormValidator;
import org.jboss.logging.LoggingClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.event.LoggerListener;
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
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/registration")

public class RegistrationController {

    private static Logger logger = Logger.getLogger(RegistrationController.class.getName());

    @Autowired
    ArtistService artistService;
    @Autowired
    ViewerService viewerService;
    @Qualifier("artistFormValidator")  //валидация
    @Autowired
    Validator validator;


    @RequestMapping(value = "/artist", method = RequestMethod.GET)
    public String getArtistRegForm(Model model, @RequestParam(value = "error", required = false) Boolean error) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        logger.info("/reg/art: get");
        model.addAttribute("artist_form", new ArtistCreationForm());
        logger.info("/reg/art: form get");
        return "/artist_reg";
    }

    @RequestMapping(value = "/artist", method = RequestMethod.POST)
    public String registerArtist(@ModelAttribute("artist_form") @Valid ArtistCreationForm form, BindingResult result) {
//        logger.info("/reg/art: post");
        validator.validate(form, result);
        if (result.hasErrors()) {
            return "/artist_reg";
        }
        artistService.createArtist(form);
        return "redirect:/main#slide-6";
    }


    @RequestMapping(value = "/viewer", method = RequestMethod.GET)
    public String getViewerRegForm(Model model, @RequestParam(value = "error", required = false) Boolean error) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        logger.info("/reg/viewer: get");
        model.addAttribute("viewer_form", new ArtistCreationForm());
        logger.info("/reg/viewer: form get");
        return "/viewer_reg";
    }

    @RequestMapping(value = "/viewer", method = RequestMethod.POST)
    public String registerViewer(@ModelAttribute("viewer_form") @Valid ViewerRegistrationForm form, BindingResult result) {
//        logger.info("/reg/art: post");
//        validator.validate(form, result);
        if (result.hasErrors()) {
            return "/viewer_reg";
        }
        viewerService.createViewer(form);
        return "redirect:/main#slide-6";
    }


//        @RequestMapping(value = "/worker", method = RequestMethod.GET)
//        public String getWorkRegForm(Model model,@RequestParam(value = "error", required = false) Boolean error) {
//            if (Boolean.TRUE.equals(error)) {
//                model.addAttribute("error", error);
//            }
//            model.addAttribute("publ_form", new WorkerRegistrationForm());
//            return "/worker_rig";
//        }
//
//        @RequestMapping(value = "/worker", method = RequestMethod.POST)
//        public String registerWork(@ModelAttribute("work_form") @Valid WorkerRegistrationForm form,
//                                   BindingResult result) {
//            validator.validate(form, result);
//            if (result.hasErrors()) {
//                return "/publisher_registration";
//            }
//            workerService.createPublisher(form);
//            return "redirect:/login";
//        }
}
