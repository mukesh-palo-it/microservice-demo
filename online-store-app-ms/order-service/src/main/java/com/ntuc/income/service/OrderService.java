package com.ntuc.income.service;

import com.ntuc.income.entity.Order;
import com.ntuc.income.entity.OrderItem;
import com.ntuc.income.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ItemServiceClient itemServiceClient;

    public Long createOrder(List<Long> itemIds) {
        List<ItemDto> itemsList = itemServiceClient.searchItems(itemIds);
        List<OrderItem> orderItemList = getOrderItems(itemsList);
        double totalPrice = orderItemList.stream().map(OrderItem::getPrice).reduce((totalValue, itemValue) -> totalValue + itemValue).get();
        Order order = orderRepository.save(new Order(totalPrice, orderItemList));
        jmsTemplate.convertAndSend("order_topic", order.getOrderId());
        return order.getOrderId();
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

    @FeignClient(name = "ITEM-SERVICE")
    private interface ItemServiceClient {

        @RequestMapping(method = RequestMethod.POST, value = "/api/items")
        List<ItemDto> searchItems(List<Long> itemIds);
    }

}
