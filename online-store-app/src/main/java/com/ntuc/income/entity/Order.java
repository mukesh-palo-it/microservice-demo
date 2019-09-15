package com.ntuc.income.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private double totalAmount;

    @ManyToMany
    @JoinTable(
            name = "order_item",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")}
    )
    private List<Item> items;

    Order() {

    }

    public Order(double totalAmount, List<Item> items) {
        this.totalAmount = totalAmount;
        this.items = items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
