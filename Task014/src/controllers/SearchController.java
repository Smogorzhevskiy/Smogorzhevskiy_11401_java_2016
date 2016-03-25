package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.SearchService;

@RestController
public class SearchController {
    @Autowired
    @Qualifier("searchServiceImpl")
    SearchService service;

    @RequestMapping(value = "/{address}/search", method = RequestMethod.GET)
    public String search(@PathVariable("{address}") String address, Model model) {
        String tempAddress = service.getSearchAddress(address);
        String tempParam = service.getSearchParam(address);
        model.addAttribute("address", tempAddress);
        model.addAttribute("param", tempParam);
        return "";
    }
}
