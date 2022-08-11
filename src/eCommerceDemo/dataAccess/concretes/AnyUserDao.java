package eCommerceDemo.dataAccess.concretes;

import java.util.ArrayList;

import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class AnyUserDao implements UserDao{

	@Override
	public void add(User user, ArrayList<User> registeredUsers) {
		registeredUsers.add(user);
		System.out.println("Succesfully registered.");
	}


}
