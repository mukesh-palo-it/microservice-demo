package com.ntuc.income.api;

import com.ntuc.income.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public Long createOrder(@RequestBody OrderDto orderDto){
        return orderService.createOrder(orderDto.getItems());
    }

}
