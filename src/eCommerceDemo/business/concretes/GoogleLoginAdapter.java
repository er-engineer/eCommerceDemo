package eCommerceDemo.business.concretes;

import java.util.ArrayList;

import eCommerceDemo.business.abstracts.ExternalLogInService;
import eCommerceDemo.entities.concretes.User;
import eCommerceDemo.external.GoogleLogIn;

public class GoogleLoginAdapter implements ExternalLogInService {
	
	@Override
	public boolean logIn(User user) {
		GoogleLogIn googleLogIn = new GoogleLogIn();
		System.out.println("Externally logged in. (Google): " + user.getName() + " " + user.getSurname());
		return googleLogIn.logIn();
		
	}
	
	
}
