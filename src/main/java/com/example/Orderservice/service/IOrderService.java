package com.example.Orderservice.service;

import com.example.Orderservice.dto.CreateOrderResponseDTO;
import com.example.Orderservice.dto.OrderRequestDTO;

public interface IOrderService {
    CreateOrderResponseDTO createOrder(OrderRequestDTO requestDTO);
}
