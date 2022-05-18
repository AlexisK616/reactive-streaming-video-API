package com.cuevan.controller;

import com.cuevan.service.StremingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
public class StreamingVideoController {

    @Autowired
    StremingService stremingService;

    @GetMapping(value = "video/{title}" , produces="video/mp4")
    public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("range")String range){
        System.out.println(String.format("Range in bytes: %s",range));
        return stremingService.getVideo(title);
    }
}
