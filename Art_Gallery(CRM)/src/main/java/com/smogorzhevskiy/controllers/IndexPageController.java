package com.smogorzhevskiy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by User on 06.05.16.
 */
@Controller

public class IndexPageController {


    @RequestMapping(value = "/main")
    public String indexPage(Model model){
        return "/main";
    }
}
