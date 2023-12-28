package com.example.mysql;

import org.springframework.data.repository.CrudRepository;
import com.example.mysql.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}
