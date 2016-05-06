package com.smogorzhevskiy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by User on 25.04.16.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String allArtists(Model model){
        return "login";
    }
}
