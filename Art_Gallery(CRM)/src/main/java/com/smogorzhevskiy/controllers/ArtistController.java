package com.smogorzhevskiy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by User on 26.04.16.
 */
@Controller
public class ArtistController {
    @RequestMapping( value = "/artist")
    public String getArtist() {
        return "/artist";
    }
}
