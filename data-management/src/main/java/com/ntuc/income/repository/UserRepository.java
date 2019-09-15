package com.ntuc.income.repository;

import com.ntuc.income.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
