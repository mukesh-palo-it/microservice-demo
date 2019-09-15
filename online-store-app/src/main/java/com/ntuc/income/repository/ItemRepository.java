package com.ntuc.income.repository;

import com.ntuc.income.entity.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findByBrandName(String brandName);
    List<Item> findByName(String name);
}
