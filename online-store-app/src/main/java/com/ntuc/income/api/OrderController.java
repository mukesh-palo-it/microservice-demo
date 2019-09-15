package com.ntuc.income.api;

import com.ntuc.income.entity.Order;
import com.ntuc.income.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public Long createOrder(@RequestBody OrderDto orderDto){
        return orderService.createOrder(orderDto.getItems());
    }

    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable Long orderId){
        return orderService.getOrder(orderId);
    }
}
