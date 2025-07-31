package com.example.Orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="orderItems")

public class OrderItem extends BaseEntity {

    private long productId;

    private int quantity;

    private double pricePerUnit;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
