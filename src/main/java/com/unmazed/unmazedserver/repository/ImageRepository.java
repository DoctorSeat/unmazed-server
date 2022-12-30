package com.unmazed.unmazedserver.repository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageRepository {
    public BufferedImage loadBufferedImage(String imgName) throws IOException {
        URL path = ImageRepository.class.getResource("/images/" + imgName + ".jpeg");
        return ImageIO.read(path);

    }

    public static void main(String[] args)  {
        ImageRepository repository = new ImageRepository();
        try {
            BufferedImage file = repository.loadBufferedImage("image1");
            System.out.println(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
