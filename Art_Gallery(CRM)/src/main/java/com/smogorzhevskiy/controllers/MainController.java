package com.smogorzhevskiy.controllers;

import com.smogorzhevskiy.entities.Artist;
import com.smogorzhevskiy.entities.Credential;
import com.smogorzhevskiy.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by User on 14.05.16.
 */
@Controller
@RequestMapping(value = "/main")
public class MainController {
    @Autowired
    ArtistService artistService;

    @Autowired
    private HttpServletRequest request;
//
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String indexPage(Model model){
//        Credential credential = (Credential)request.getSession().getAttribute("user");
//        model.addAttribute("user", credential);
//        return "/main";
//    }

    @RequestMapping(value = "/ajax/getAllArtists", method = RequestMethod.GET)
    public @ResponseBody
    List<Artist> getAllArtists(){
        return artistService.findAll();

    }


}
