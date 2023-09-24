package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
