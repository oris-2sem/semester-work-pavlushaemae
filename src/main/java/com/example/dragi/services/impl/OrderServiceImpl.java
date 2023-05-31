package com.example.dragi.services.impl;

import com.example.dragi.dto.request.order.OrderRequest;
import com.example.dragi.dto.response.order.OrderResponse;
import com.example.dragi.mapper.OrderMapper;
import com.example.dragi.models.Order;
import com.example.dragi.models.User;
import com.example.dragi.repositories.OrderRepository;
import com.example.dragi.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    @Override
    public List<OrderResponse> getListOfOrdersOfUser(User user) {
        return orderMapper.fromEntityToOrderResponseList(orderRepository.getAllByUser(user));
    }

    @Override
    public OrderResponse createNewOrder(OrderRequest orderRequest) {
        return orderMapper.fromEntityToOrderResponse(orderRepository.save(orderMapper.fromRequestToEntity(orderRequest)));
    }
}
