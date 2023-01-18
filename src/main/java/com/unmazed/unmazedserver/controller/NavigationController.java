package com.unmazed.unmazedserver.controller;

import com.unmazed.unmazedserver.service.ImageTransferService;
import com.unmazed.unmazedserver.service.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NavigationController {
    private static final Logger logger = LoggerFactory.getLogger(NavigationController.class);

    @Autowired
    private ImageTransferService imageTransferService;
    @Autowired
    private RouteService routeService;
    @GetMapping(value = "/img/{imgName:.*}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] downloadImage(@PathVariable String imgName) throws IOException {
        try {
            BufferedImage image = imageTransferService.loadImage(imgName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpeg", baos);
            return baos.toByteArray();
        } catch(Exception e) {
            System.out.println("ERROR OCCURRED DURING IMAGE LOADING");
            e.printStackTrace();
            BufferedImage image = imageTransferService.loadImage("imageError");
            ByteArrayOutputStream baosError = new ByteArrayOutputStream();
            ImageIO.write(image, "jpeg", baosError);
            return baosError.toByteArray();
        }
    }
    @RequestMapping(value = "/route/{pointA:.*}&{pointB:.*}", method = RequestMethod.GET)
    public @ResponseBody List<String> calculateRoute(@PathVariable String pointA, @PathVariable String pointB) {
        try {
            return routeService.getRoute(pointA, pointB);
        } catch (InvalidParameterException invalidParameterException) {
            System.out.println("WRONG PARAMTERS");
            return new ArrayList<>();
        }
    }
    @ExceptionHandler
    public void handleException() {}

}
