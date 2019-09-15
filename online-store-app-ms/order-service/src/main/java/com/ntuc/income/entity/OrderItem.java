package com.ntuc.income.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long orderItemId;
    private Long itemId;
    private String name;
    private String brandName;
    private double price;
    @ManyToOne
    private Order order;

    OrderItem() {

    }

    public OrderItem(Long itemId, String name, String brandName, double price) {
        this.itemId = itemId;
        this.name = name;
        this.brandName = brandName;
        this.price = price;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}