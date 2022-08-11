package eCommerceDemo;

import java.util.ArrayList;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.concretes.GoogleLoginAdapter;
import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.dataAccess.concretes.AnyUserDao;
import eCommerceDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		//Database Simulation
		ArrayList<User> registeredUsers = new ArrayList<User>();
		User user1 = new User("Eren", "Memish", "erenmemish@hotmail.com", "Admin12");
		User user2 = new User("Alper", "Aldemir", "alperalde@hotmail.com", "alperAlde19");
		User user3 = new User("Kemal", "Ata", "atakemal.12@hotmail.com", "kemalkemal18");
		registeredUsers.add(user1);
		registeredUsers.add(user2);
		registeredUsers.add(user3);

		//User who wants to log in via Google.
		User googleUser1 = new User("Kaan", "Tekes", "kaanteker@gmail.com", "googleSecured");
		
		
		
		//Entered Datas -> Persons to be registered.
		//Unsuccessful Registration: Mail format is unacceptable.
		User newUser1 = new User("Tekin", "Kin", "tttekin.com", "teskoTekin0"); 
		//Unsuccessful Registration: Either Name or Surname property cannot be less than 2 characters.
		User newUser2 = new User("t", "m", "kkk@gmail.com", "kk4144"); 
		//Unsuccesful Registiration: Password cannot be less than 6 characters.
		User newUser3 = new User("Yusuf", "Kalayci", "yuusuffklyc@hotmail.com", "ysf11");
		//Unsuccessful Registration: Mail address used before.
		User newUser4 = new User("Kenan", "Maraz", "erenmemish@hotmail.com", "marazkenn007"); 
		//Succesful Registration
		User newUser5 = new User("Eren", "Demir", "erendemir@windowslive.com", "mylfHunt31");
		
		//APP Section
		
		UserService userService = new UserManager(new AnyUserDao() , new GoogleLoginAdapter());
			userService.logIn("erenmemish@hotmail.com", "Admin12", registeredUsers); //Successful Login
			userService.logIn("alperalde@hotmail.com", "alperAlde", registeredUsers); //Unsuccessful Login
			
			userService.externalLogIn(googleUser1);
			
			userService.register(newUser1, registeredUsers);
			userService.register(newUser2, registeredUsers);
			userService.register(newUser3, registeredUsers);
			userService.register(newUser4, registeredUsers);
			userService.register(newUser5, registeredUsers);
			
			//After registration
			for(User registeredUser : registeredUsers) {
				System.out.println(registeredUser.getName() + ", " +
									registeredUser.getSurname() + ", " +
									registeredUser.getMailAddress());
			}
			
			
		
		
	}

}
