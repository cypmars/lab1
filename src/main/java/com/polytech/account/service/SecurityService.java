package com.polytech.account.service;

/**
 * Created by guzzi on 03/04/2017.
 */
public interface SecurityService {
	String findLoggedInUsername();

	void autologin(String username, String password);
}
