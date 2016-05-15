package com.smogorzhevskiy.controllers;

import com.itextpdf.text.DocumentException;
import com.smogorzhevskiy.forms.ArtistCreationForm;
import com.smogorzhevskiy.forms.ContractCreationForm;
import com.smogorzhevskiy.forms.PictureCreationForm;
import com.smogorzhevskiy.service.ContractService;
import com.smogorzhevskiy.service.CreatePdf;
import com.smogorzhevskiy.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    ContractService contractService;

    @RequestMapping(value = "/add_picture", method = RequestMethod.GET)
    public String getAddPictureForm(Model model, @RequestParam(value = "error", required = false) Boolean error) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        model.addAttribute("picture_form", new PictureCreationForm());
        return "/add_picture";
    }

    @RequestMapping(value = "/add_picture", method = RequestMethod.POST)
    public String addPicture(@ModelAttribute("add_picture_form") @Valid PictureCreationForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/add_picture";
        }
        pictureService.createPicture(form);
        return "redirect:/main#slide-6";
    }

    @RequestMapping(value = "/add_contract", method = RequestMethod.GET)
    public String getAddContractForm(Model model, @RequestParam(value = "error", required = false) Boolean error) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        model.addAttribute("contract_form", new PictureCreationForm());
        return "/add_contract";
    }

    @RequestMapping(value = "/add_contract", method = RequestMethod.POST)
    public String addContract(@ModelAttribute("add_contract_form") @Valid ContractCreationForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/add_contract";
        }
        contractService.createContract(form);
        return "redirect:/main";
    }

    @Autowired
    CreatePdf createPdf;

    @RequestMapping(value = "/files/{id}", method = RequestMethod.GET, produces = "application/pdf")
    @ResponseBody
    public FileSystemResource getFile(@PathVariable("id") Integer id) throws DocumentException, IOException {
        String filePath = createPdf.create(contractService.findOneById(id));
        return new FileSystemResource(filePath);
    }
}
