package com.ntuc.income.service;

import com.ntuc.income.entity.Item;
import com.ntuc.income.entity.Order;
import com.ntuc.income.repository.ItemRepository;
import com.ntuc.income.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Long createOrder(List<Long> itemIds) {
        Iterable<Item> itemsIterator = itemRepository.findAllById(itemIds);
        List<Item> itemsList = new LinkedList<>();
        itemsIterator.forEach(itemsList::add);
        double totalPrice = itemsList.stream().map(Item::getPrice).reduce((total, itemPrice) -> total + itemPrice).get();
        Order order = new Order(totalPrice, itemsList);
        return orderRepository.save(order).getOrderId();
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).get();
    }
}
