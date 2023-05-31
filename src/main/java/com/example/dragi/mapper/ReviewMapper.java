package com.example.dragi.mapper;

import com.example.dragi.dto.request.review.ReviewRequest;
import com.example.dragi.dto.request.review.ReviewUpdateRequest;
import com.example.dragi.dto.response.review.ReviewResponse;
import com.example.dragi.models.Review;

import java.util.List;

public interface ReviewMapper {

    Review fromRequestToEntity(ReviewRequest request);

    Review fromUpdateRequestToEntity(ReviewUpdateRequest request);

    List<ReviewResponse> fromEntityToReviewResponseList(List<Review> reviewList);

    ReviewResponse reviewToReviewResponse(Review review);
}
