package com.example.dragi.services.impl;

import com.example.dragi.models.Image;
import com.example.dragi.repositories.ImageRepository;
import com.example.dragi.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }
}
