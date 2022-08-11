package eCommerceDemo.external;

import java.util.Random;

public class GoogleLogIn {
	
	public boolean logIn() {
		//To simulate getting datas from Google's DB. 
		Random random = new Random(System.currentTimeMillis());
		boolean result = random.nextInt(2) == 1 ? true : false;
		return result;
	}
}
