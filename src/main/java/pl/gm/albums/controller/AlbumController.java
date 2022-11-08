package pl.gm.albums.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.gm.albums.dto.AlbumDto;

import pl.gm.albums.model.Photo;
import pl.gm.albums.service.AlbumService;

import javax.validation.Valid;


@Controller
@RequestMapping("/album")
@RequiredArgsConstructor
public class AlbumController {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private AlbumService albumService;

    @ResponseBody
    @RequestMapping("/testing")
    public String responseTest() {
        log.info("Test");
        return new AlbumDto().toString();
    }

    @GetMapping("/add")
    public String albumForm(Model model) {
        model.addAttribute("albumDto", new AlbumDto());
        return "/album/add";
    }

    @PostMapping("/add")
    public String saveALbum(@Valid AlbumDto albumDto, BindingResult bindingResult, @RequestParam("imageFile") MultipartFile imageFile, Model model) {
        if (bindingResult.hasErrors()) {
            return "/album/add";
        } else if (imageFile.getOriginalFilename().isEmpty()) {
            model.addAttribute("emptyPhotoMessage", "Main photo album is needed.");
            return "/album/add";
        }

        return "index";
    }

}
