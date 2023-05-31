package com.example.dragi.services.impl;

import com.example.dragi.dto.request.review.ReviewRequest;
import com.example.dragi.dto.request.review.ReviewUpdateRequest;
import com.example.dragi.dto.response.review.ReviewResponse;
import com.example.dragi.exceptions.NotFoundException;
import com.example.dragi.mapper.ReviewMapper;
import com.example.dragi.repositories.ReviewRepository;
import com.example.dragi.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewMapper mapper;

    @Override
    public ReviewResponse saveReview(ReviewRequest request) {
        return mapper.reviewToReviewResponse(reviewRepository.save(mapper.fromRequestToEntity(request)));
    }

    @Override
    public List<ReviewResponse> getReviewsOfProduct(Long product) {
        return mapper.fromEntityToReviewResponseList(reviewRepository.findAllByProductId(product));
    }

    @Override
    public List<ReviewResponse> getAllReviews() {
        return mapper.fromEntityToReviewResponseList(reviewRepository.findAll());
    }

    @Override
    public void deleteReviewById(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public ReviewResponse update(ReviewUpdateRequest newRequest) {
        try {
            reviewRepository.update(mapper.fromUpdateRequestToEntity(newRequest));
            return mapper.reviewToReviewResponse(reviewRepository.findById(newRequest.getId()));
        } catch (RuntimeException exception) {
            throw new NotFoundException("Отзыв c id = " + newRequest.getId() + " не найден");
        }
    }

    @Override
    public ReviewResponse findById(Long id) {
        try {
            return mapper.reviewToReviewResponse(reviewRepository.findById(id));
        } catch (RuntimeException exception) {
            throw new NotFoundException("Отзыв c id = " + id + " не найден");
        }

    }
}
