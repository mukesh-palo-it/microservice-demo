package com.ntuc.income;

import com.ntuc.income.entity.Item;
import com.ntuc.income.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineStoreApp implements ApplicationRunner {

    @Autowired
    private ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(OnlineStoreApp.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        itemRepository.save(new Item("iPhone-8", 800, "Apple"));
        itemRepository.save(new Item("iPhone-8S", 850, "Apple"));
        itemRepository.save(new Item("note-10", 650, "Samsung"));
        itemRepository.save(new Item("galaxy-10", 650, "Samsung"));
    }
}
