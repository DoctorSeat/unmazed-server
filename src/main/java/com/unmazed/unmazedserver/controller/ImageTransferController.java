package com.unmazed.unmazedserver.controller;

import com.unmazed.unmazedserver.service.ImageTransferService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
public class ImageTransferController {
    private static final Logger logger = LoggerFactory.getLogger(ImageTransferController.class);

    @Autowired
    private ImageTransferService imageTransferService;
    @GetMapping("/img/{imgName:.*}")
    public Response downloadImage(@PathVariable String imgName, HttpServletRequest request) {
        try {
            BufferedImage image = imageTransferService.loadImage(imgName);
        } catch(Exception e) {
            System.out.println("ERROR OCCURRED DURING IMAGE LOADING");
            e.printStackTrace();
        }
        return null;
    }

}
