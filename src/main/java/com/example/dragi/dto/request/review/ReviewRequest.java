package com.example.dragi.dto.request.review;

import com.example.dragi.models.Product;
import com.example.dragi.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewRequest {
    private Long userId;
    private String text;
    private Long productId;
}
