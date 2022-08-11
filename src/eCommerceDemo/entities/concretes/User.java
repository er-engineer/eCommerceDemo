package eCommerceDemo.entities.concretes;

import eCommerceDemo.entities.abstracts.Entity;

public class User implements Entity{
	private String name;
	private String surname; 
	private String mailAddress;
	private String password;
	
	public User(String name, String surname, String mailAddress, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.mailAddress = mailAddress;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
