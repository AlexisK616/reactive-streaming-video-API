package com.cuevan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
public class StremingService {

    @Autowired
    ResourceLoader resourceLoader;

    private static String FORMATTITLE ="classpath:videos/%s.mp4";

    public Mono<Resource> getVideo(String title){
        return Mono.fromSupplier(()-> resourceLoader.getResource(String.format(FORMATTITLE,title)));
    }
}
