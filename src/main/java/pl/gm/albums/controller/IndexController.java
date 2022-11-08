package pl.gm.albums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.gm.albums.service.AlbumService;

@Controller
public class IndexController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }


}
