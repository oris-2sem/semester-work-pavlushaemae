package com.example.dragi.controllers.impl.rest;

import com.example.dragi.controllers.rest.ReviewRestController;
import com.example.dragi.dto.EntityId;
import com.example.dragi.dto.request.review.ReviewRequest;
import com.example.dragi.dto.request.review.ReviewUpdateRequest;
import com.example.dragi.dto.response.review.ReviewResponse;
import com.example.dragi.services.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ReviewRestControllerImpl implements ReviewRestController {

    private final ReviewService reviewService;

    @Override
    public ResponseEntity<List<ReviewResponse>> getAll() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @Override
    public ResponseEntity<List<ReviewResponse>> getAllOfProduct(Long id) {
        return ResponseEntity.ok(reviewService.getReviewsOfProduct(id));
    }

    @Override
    public ResponseEntity<ReviewResponse> create(ReviewRequest reviewRequest) {
        log.error(reviewRequest.toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reviewService.saveReview(reviewRequest));
    }

    @Override
    public ResponseEntity<ReviewResponse> update(ReviewUpdateRequest newRequest) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reviewService.update(newRequest));
    }

    @Override
    public void deleteById(EntityId entityId) {
        reviewService.deleteReviewById(entityId.getId());
    }

    @Override
    public ResponseEntity<ReviewResponse> findById(Long id) {
        return ResponseEntity.ok(reviewService.findById(id));
    }
}
