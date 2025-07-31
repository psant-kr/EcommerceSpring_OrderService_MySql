package com.example.Orderservice.controllers;

import com.example.Orderservice.dto.CreateOrderResponseDTO;
import com.example.Orderservice.dto.OrderRequestDTO;
import com.example.Orderservice.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponseDTO> createOrder(@RequestBody OrderRequestDTO request){
        CreateOrderResponseDTO order = orderService.createOrder(request);
        return  ResponseEntity.ok(order);
    }

}
