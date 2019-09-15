package com.ntuc.income.entity;

import javax.persistence.*;

@Entity
@Table(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shipmentId;
    private Long orderId;
    private String status;

    Shipment(){

    }
    public Shipment(Long orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
