package com.example.dragi.repositories;

import com.example.dragi.dto.request.review.ReviewUpdateRequest;
import com.example.dragi.models.Product;
import com.example.dragi.models.Review;

import javax.transaction.Transactional;
import java.util.List;

public interface ReviewRepository {

    void update(Review review);

    List<Review> findAllByProductId(Long product);

    Review save(Review review);

    void deleteById(Long reviewId);

    List<Review> findAll();

    Review findById(Long id);
}
