package com.example.Orderservice.service;

import com.example.Orderservice.clients.ProductServiceClient;
import com.example.Orderservice.dto.CreateOrderResponseDTO;
import com.example.Orderservice.dto.OrderItemDTO;
import com.example.Orderservice.dto.OrderRequestDTO;
import com.example.Orderservice.dto.ProductDTO;
import com.example.Orderservice.entity.Order;
import com.example.Orderservice.entity.OrderItem;
import com.example.Orderservice.mapper.OrderItemMapper;
import com.example.Orderservice.mapper.OrderMapper;
import com.example.Orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    public  OrderService(OrderRepository orderRepository, ProductServiceClient productServiceClient) {
        this.orderRepository = orderRepository;
        this.productServiceClient = productServiceClient;
    }

    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO request) {

        // persist the order in the order table > OrderRequestDTO > Order Entity
        Order order = OrderMapper.toEntity(request);



        List<OrderItem> items = new ArrayList<>();

        for(OrderItemDTO itemDTO : request.getItems()) {
            // fetch the product details for every item

            ProductDTO product = productServiceClient.getProductById(itemDTO.getProductId());
            double pricePerUnit = product.getPrice();
            double totalPrice = pricePerUnit * itemDTO.getQuantity();

            OrderItem item = OrderItemMapper.OrderItemRequestDTOtoOrderItemEntity(
                    itemDTO,
                    order,
                    pricePerUnit,
                    totalPrice
            );
            items.add(item);

        }
        order.setItems(items);
        Order createdOrder = orderRepository.save(order);

        return OrderMapper.toCreateOrderResponseDTO(createdOrder);

    }
}
