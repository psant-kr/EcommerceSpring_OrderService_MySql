package com.example.Orderservice.mapper;

import com.example.Orderservice.dto.CreateOrderResponseDTO;
import com.example.Orderservice.dto.OrderRequestDTO;
import com.example.Orderservice.entity.Order;
import com.example.Orderservice.enums.OrderStatus;

public class OrderMapper {

    public static Order toEntity(OrderRequestDTO dto){

        return Order.builder()
                .userId(dto.getUserId())
                .status(OrderStatus.PENDING)
                .build();
    }

    public static CreateOrderResponseDTO toCreateOrderResponseDTO(Order order){
        return CreateOrderResponseDTO.builder()
                .orderId(order.getId())
                .status(order.getStatus())
                .build();
    }
}
