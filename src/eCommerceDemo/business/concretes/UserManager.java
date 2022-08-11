package eCommerceDemo.business.concretes;

import java.util.ArrayList;

import eCommerceDemo.business.UtilsBusiness;
import eCommerceDemo.business.abstracts.ExternalLogInService;
import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.core.UtilsCore;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class UserManager implements UserService{
	private UserDao userDao;
	private ExternalLogInService externalLogInService;
	public UserManager(UserDao userDao, ExternalLogInService externalLogInService) {
		this.userDao = userDao;
		this.externalLogInService = externalLogInService;
	}
	
	@Override
	public void register(User user, ArrayList<User> registeredUsers) {
		UtilsBusiness utilsBusiness = new UtilsBusiness();
		if(utilsBusiness.checkMail(user, registeredUsers) && 
				utilsBusiness.checkName(user) && utilsBusiness.checkPasswordLength(user)) {
			UtilsCore utilsCore = new UtilsCore();
			utilsCore.sendMailVerification(user);
			if(utilsCore.checkMailVerification(user)) {
				userDao.add(user, registeredUsers);
			}
			else
				System.out.println("Verification failed.");

		}
		
	}

	@Override
	public void logIn(String mailAddress, String password, ArrayList<User> registeredUsers) {
		boolean isCorrect = false;
		for(User registeredUser : registeredUsers) {
			if(registeredUser.getMailAddress().equals(mailAddress) &&
					registeredUser.getPassword().equals(password)) {
				System.out.println("Logged in succesfully: " + registeredUser.getName() + 
						" " + registeredUser.getSurname());
				isCorrect = true;
				break;
			}	
		}
		if(!isCorrect)
			System.out.println("Mail address or password is incorrect.");
		
	}

	@Override
	public void externalLogIn(User user) {
		this.externalLogInService.logIn(user);
		
	}
	

	
}