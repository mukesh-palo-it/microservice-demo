package com.ntuc.income.api;

import com.ntuc.income.entity.Item;
import com.ntuc.income.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/search/items/with/brand/{brandName}")
    public List<Item> searchWithBrand(@PathVariable String brandName) {
        return itemRepository.findByBrandName(brandName);
    }

    @GetMapping("/search/items/with/name/{name}")
    public List<Item> searchWithName(@PathVariable String name) {
        return itemRepository.findByName(name);
    }

    @PostMapping("/items")
    public List<Item> getItems(@RequestBody List<Long> itemIds) {
        Iterable<Item> itemIterable = itemRepository.findAllById(itemIds);
        List<Item> itemList = new LinkedList<>();
        itemIterable.forEach(itemList::add);
        return itemList;
    }
}
