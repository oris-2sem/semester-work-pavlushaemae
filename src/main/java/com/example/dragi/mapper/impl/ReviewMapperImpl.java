package com.example.dragi.mapper.impl;

import com.example.dragi.dto.request.review.ReviewRequest;
import com.example.dragi.dto.request.review.ReviewUpdateRequest;
import com.example.dragi.dto.response.review.ReviewResponse;
import com.example.dragi.mapper.ReviewMapper;
import com.example.dragi.models.Product;
import com.example.dragi.models.Review;
import com.example.dragi.models.User;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review fromRequestToEntity(ReviewRequest request) {
        if (request == null) {
            return null;
        }

        Review review = new Review();

        review.setUser(new User(request.getUserId()));
        review.setProduct(new Product(request.getProductId()));
        review.setText(request.getText());

        return review;
    }

    @Override
    public Review fromUpdateRequestToEntity(ReviewUpdateRequest request) {
        if (request == null) {
            return null;
        }

        Review review = new Review();

        review.setId(request.getId());
        review.setUser(new User(request.getUserId()));
        review.setProduct(new Product(request.getProductId()));
        review.setText(request.getText());

        return review;
    }

    @Override
    public List<ReviewResponse> fromEntityToReviewResponseList(List<Review> reviewList) {
        if (reviewList == null) {
            return null;
        }

        List<ReviewResponse> list = new ArrayList<>(reviewList.size());
        for (Review review : reviewList) {
            list.add(reviewToReviewResponse(review));
        }

        return list;
    }

    public ReviewResponse reviewToReviewResponse(Review review) {
        if (review == null) {
            return null;
        }

        ReviewResponse.ReviewResponseBuilder reviewResponse = ReviewResponse.builder();

        reviewResponse.id(review.getId());
        reviewResponse.userName(review.getUser().getNickname());
        reviewResponse.productId(review.getProduct().getId());
        reviewResponse.text(review.getText());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");
        reviewResponse.dateOfCreated(review.getDateOfCreated().format(formatter));

        return reviewResponse.build();
    }
}
