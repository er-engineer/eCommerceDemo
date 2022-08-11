package eCommerceDemo.business.abstracts;

import java.util.ArrayList;

import eCommerceDemo.entities.concretes.User;

public interface UserService {
	void register(User user, ArrayList<User> registeredUsers);
	void logIn(String mailAddress, String password, ArrayList<User> registeredUsers);
	void externalLogIn(User user);
}
