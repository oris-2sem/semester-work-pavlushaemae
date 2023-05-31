package com.example.dragi.dto.response.order;

import com.example.dragi.models.Product;
import com.example.dragi.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private User user;
    private List<Product> products;
    private String dateOfCreated;
}
