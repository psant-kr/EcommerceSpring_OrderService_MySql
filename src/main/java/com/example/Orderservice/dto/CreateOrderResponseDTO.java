package com.example.Orderservice.dto;

import com.example.Orderservice.enums.OrderStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderResponseDTO {

    private Long orderId;
    private OrderStatus status;
}
