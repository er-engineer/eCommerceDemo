package eCommerceDemo.business.abstracts;

import java.util.ArrayList;

import eCommerceDemo.entities.concretes.User;

public interface ExternalLogInService {
	boolean logIn(User user);
}
