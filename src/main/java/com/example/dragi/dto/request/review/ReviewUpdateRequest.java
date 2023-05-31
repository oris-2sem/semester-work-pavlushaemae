package com.example.dragi.dto.request.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewUpdateRequest {
    private Long id;
    private Long userId;
    private String text;
    private Long productId;
}
