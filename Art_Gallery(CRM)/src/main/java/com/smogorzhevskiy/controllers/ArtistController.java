package com.smogorzhevskiy.controllers;

import com.smogorzhevskiy.forms.ArtistCreationForm;
import com.smogorzhevskiy.forms.PictureCreationForm;
import com.smogorzhevskiy.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by User on 26.04.16.
 */
@Controller
@RequestMapping( value = "/artist")
public class ArtistController {
    @Autowired
    PictureService pictureService;

    public String getArtist() {
        return "/add_picture";
    }
    @RequestMapping(value = "/add_picture", method = RequestMethod.GET)
    public String getModerRegForm(Model model, @RequestParam(value = "error", required = false) Boolean error) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        model.addAttribute("picture_form", new PictureCreationForm());
        return "/add_picture";
    }

    @RequestMapping(value = "/add_picture", method = RequestMethod.POST)
    public String registerModer(@ModelAttribute("add_picture_form") @Valid PictureCreationForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/add_picture";
        }
        pictureService.createPicture(form);
        return "redirect:/main#slide-6";
    }
}
