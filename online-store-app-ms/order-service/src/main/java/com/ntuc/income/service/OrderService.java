package com.ntuc.income.service;

import com.ntuc.income.entity.Order;
import com.ntuc.income.entity.OrderItem;
import com.ntuc.income.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Long createOrder(List<Long> itemIds) {
        HttpEntity<List> request = new HttpEntity<>(itemIds);
        List<ItemDto> itemsList = restTemplate.exchange("http://localhost:8080/api/items", HttpMethod.POST, request, new ParameterizedTypeReference<List<ItemDto>>() {
        }).getBody();
        List<OrderItem> orderItemList = getOrderItems(itemsList);
        double totalPrice = orderItemList.stream().map(OrderItem::getPrice).reduce((totalValue, itemValue)->totalValue+itemValue).get();
        Order order = new Order(totalPrice, orderItemList);
        return orderRepository.save(order).getOrderId();
    }

    private List<OrderItem> getOrderItems(List<ItemDto> itemsList) {
        return itemsList.stream().map(itemDto ->
            new OrderItem(itemDto.getItemId(),
                    itemDto.getName(),
                    itemDto.getBrandName(),
                    itemDto.getPrice()
            )
        ).collect(Collectors.toList());
    }

}
