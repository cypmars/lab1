package com.polytech.account.service;


import com.polytech.account.models.User;

/**
 * Created by guzzi on 03/04/2017.
 */
public interface UserService {
	void save(User user);

	User findByUsername(String username);
}
