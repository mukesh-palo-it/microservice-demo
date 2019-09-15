package com.ntuc.income.repository;

import com.ntuc.income.entity.Shipment;
import org.springframework.data.repository.CrudRepository;

public interface ShipmentRepository extends CrudRepository<Shipment, Long> {
    Shipment findByOrderId(Long orderId);
}
