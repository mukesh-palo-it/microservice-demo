package com.ntuc.income.api;

import com.ntuc.income.entity.Shipment;
import com.ntuc.income.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController {

    @Autowired
    private ShipmentRepository repository;

    @GetMapping("/shipments/{orderId}/statuses")
    public Shipment getShipment(@PathVariable Long orderId) {
        return repository.findByOrderId(orderId);
    }
}
