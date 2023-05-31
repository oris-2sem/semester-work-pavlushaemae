package com.example.dragi.mapper;

import com.example.dragi.dto.request.order.OrderRequest;
import com.example.dragi.dto.request.review.ReviewRequest;
import com.example.dragi.dto.response.order.OrderResponse;
import com.example.dragi.dto.response.review.ReviewResponse;
import com.example.dragi.models.Order;
import com.example.dragi.models.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateOfCreated", ignore = true)
    Order fromRequestToEntity(OrderRequest request);

    @Mapping(source = "dateOfCreated", target = "dateOfCreated", dateFormat = "HH:mm dd.MM.yyyy")
    OrderResponse fromEntityToOrderResponse(Order order);

    @Mapping(source = "dateOfCreated", target = "dateOfCreated", dateFormat = "HH:mm dd.MM.yyyy")
    List<OrderResponse> fromEntityToOrderResponseList(List<Order> orderList);
}
