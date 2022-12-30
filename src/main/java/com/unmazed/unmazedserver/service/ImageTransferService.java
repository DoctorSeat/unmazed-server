package com.unmazed.unmazedserver.service;

import com.unmazed.unmazedserver.repository.ImageRepository;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class ImageTransferService {
    private ImageRepository imageRepository;
    public BufferedImage loadImage(String imgName) throws IOException {
        return imageRepository.loadBufferedImage(imgName);
    }
}
