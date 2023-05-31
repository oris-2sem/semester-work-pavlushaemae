package com.example.dragi.dto.request.order;

import com.example.dragi.models.Product;
import com.example.dragi.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private User user;
    private List<Product> products;
}
