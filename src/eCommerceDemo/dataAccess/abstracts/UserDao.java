package eCommerceDemo.dataAccess.abstracts;

import java.util.ArrayList;

import eCommerceDemo.entities.concretes.User;

public interface UserDao {
	void add(User user, ArrayList<User> registeredUsers);
}
