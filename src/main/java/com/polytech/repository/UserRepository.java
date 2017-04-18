package com.polytech.repository;

import com.polytech.business.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Cyprien on 18/04/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
