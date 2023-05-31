package com.example.dragi.services;

import com.example.dragi.dto.request.review.ReviewRequest;
import com.example.dragi.dto.request.review.ReviewUpdateRequest;
import com.example.dragi.dto.response.review.ReviewResponse;
import com.example.dragi.models.Product;
import com.example.dragi.models.Review;
import com.example.dragi.models.User;

import java.util.List;

public interface ReviewService {
    ReviewResponse saveReview(ReviewRequest request);
    List<ReviewResponse> getReviewsOfProduct(Long product);

    List<ReviewResponse> getAllReviews();

    void deleteReviewById(Long reviewId);

    ReviewResponse update(ReviewUpdateRequest newRequest);

    ReviewResponse findById(Long id);
}
