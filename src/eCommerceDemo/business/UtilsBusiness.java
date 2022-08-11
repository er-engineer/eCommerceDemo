package eCommerceDemo.business;

import java.util.ArrayList;
import java.util.regex.Pattern;

import eCommerceDemo.entities.concretes.User;

public class UtilsBusiness {
	
	public boolean checkPasswordLength(User user) {
		if(user.getPassword().length() >= 6) {
			return true;
		}
		System.out.println("Password cannot be less than 6 characters.");
		return false;
	}
	
	public boolean checkName(User user) {
		if(user.getName().length() >= 2 
						&& user.getSurname().length() >= 2) {
			return true;
		}
		System.out.println("Name and surname cannot be less than 2 characters.");
		return false;			
	}
	
	public boolean checkMail(User user, ArrayList<User> registeredUsers) {
		//Regex Check
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*"
				+ "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
		boolean result = pattern.matcher(user.getMailAddress()).matches();	
		if(!result) {
			System.out.println("Mail format is incorrect.");
			return result;
		}
		
		//Availablity Check
		for(User registeredUser : registeredUsers) {
			if(registeredUser.getMailAddress().equals(user.getMailAddress()) && result) {
				System.out.println("This mail address is unable to use: " + user.getMailAddress());
				return false;
			}		
		}
		return result;
		
	}
}
