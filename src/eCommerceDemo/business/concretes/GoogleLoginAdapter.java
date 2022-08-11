package eCommerceDemo.business.concretes;

import java.util.ArrayList;

import eCommerceDemo.business.abstracts.ExternalLogInService;
import eCommerceDemo.entities.concretes.User;
import eCommerceDemo.external.GoogleLogIn;

public class GoogleLoginAdapter implements ExternalLogInService {
	
	@Override
	public boolean logIn(User user) {
		GoogleLogIn googleLogIn = new GoogleLogIn();
		if(googleLogIn.logIn()) {
			System.out.println("Externally logged in. (Google): " + user.getName() + " " + user.getSurname());
			return true;
		}
			
		else
			System.out.println("Something went wrong while logging in via Google: " + user.getName() + " " + user.getSurname());
		return false;
	
	}
	
}
