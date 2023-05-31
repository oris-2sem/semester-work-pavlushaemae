package com.example.dragi.controllers.impl;

import com.example.dragi.controllers.ImageController;
import com.example.dragi.models.Image;
import com.example.dragi.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@RestController
@RequiredArgsConstructor
public class ImageControllerImpl implements ImageController {
    private final ImageService imageService;

    @Override
    public ResponseEntity<?> getImageById(Long id) throws FileNotFoundException {
        Image image = imageService.getImageById(id);
        String name = image.getName();
        File file = new File("C:\\Tomcat 10.0\\fileForImages\\Image\\" + name);
        return ResponseEntity.ok()
                .header("fileName", name)
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(file.length())
                .body(new InputStreamResource(new FileInputStream(file)));
    }


    private void downloadDefaultAvatar() {
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new URL("https://w7.pngwing.com/pngs/562/56/png-transparent-playstation-drawing-game-controllers-line-art-video-game-gamepad-game-angle-white.png").openStream());
            new File("..\\fileForImages\\Image").mkdirs();
            File file = new File("..\\fileForImages\\Image\\def.png");
            Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
