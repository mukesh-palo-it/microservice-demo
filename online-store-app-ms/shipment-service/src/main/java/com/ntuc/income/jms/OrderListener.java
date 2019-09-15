package com.ntuc.income.jms;

import com.ntuc.income.entity.Shipment;
import com.ntuc.income.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @JmsListener(destination = "order_topic")
    public void receiveMessage(Long orderId){
        Shipment shipment = new Shipment(orderId, "ORDER_RECEIVED");
        shipmentRepository.save(shipment);
    }
}
