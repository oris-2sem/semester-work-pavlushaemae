package com.example.dragi.services;

import com.example.dragi.dto.request.order.OrderRequest;
import com.example.dragi.dto.response.order.OrderResponse;
import com.example.dragi.models.User;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getListOfOrdersOfUser(User user);

    OrderResponse createNewOrder(OrderRequest orderRequest);
}
