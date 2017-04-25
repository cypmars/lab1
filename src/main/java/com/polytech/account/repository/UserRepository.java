package com.polytech.account.repository;

import com.polytech.account.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by guzzi on 03/04/2017.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}