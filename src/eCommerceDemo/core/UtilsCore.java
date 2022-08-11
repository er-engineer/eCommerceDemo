package eCommerceDemo.core;

import java.util.Random;

import eCommerceDemo.entities.concretes.User;

public class UtilsCore {
	public void sendMailVerification(User user) {
		System.out.println("Verification mail has been sent: " + user.getMailAddress());
	}
	
	public boolean checkMailVerification(User user) {
		Random random = new Random(System.currentTimeMillis());
		if(random.nextInt(2) == 1) {
			System.out.println("Succesfully verified: " + user.getMailAddress());
			return true;
		}	
		else {
			System.out.println("Something went wrong. Try again later.");
			return false;
		}
			
	}
	
}
