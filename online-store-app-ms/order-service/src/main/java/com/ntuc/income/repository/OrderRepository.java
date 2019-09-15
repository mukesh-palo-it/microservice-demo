package com.ntuc.income.repository;

import com.ntuc.income.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
