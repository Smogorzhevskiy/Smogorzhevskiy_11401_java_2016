package com.smogorzhevskiy.controllers;

import com.itextpdf.text.DocumentException;
import com.smogorzhevskiy.service.ContractService;
import com.smogorzhevskiy.service.CreatePdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by User on 07.05.16.
 */
@Controller
public class ContractController {
    @Autowired
    ContractService contractService;

    @Autowired
    CreatePdf createPdf;

    @RequestMapping(value = "/files/{artist}", method = RequestMethod.GET, produces = "application/pdf")
    @ResponseBody
    public FileSystemResource getFile(@PathVariable("artist") String artist) throws DocumentException, IOException {
        String filePath = createPdf.create(contractService.findContractByArtist(artist));
        return new FileSystemResource(filePath);
    }
}
