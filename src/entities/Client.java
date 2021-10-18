package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	
	//Attributes
	private String name;
	private String email;
	private Date birthDate;
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	//Constructor
	public Client(String name, String email, String birthDate) throws ParseException{
		this.name = name;
		this.email = email;
		this.birthDate = formato.parse(birthDate);
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) throws ParseException {
		this.birthDate = formato.parse(birthDate);
	}
	
	
	public String toString() {
		String print = "Client: " + name + " - " + email + "\nNascimento: " + formato.format(birthDate);
		return print;
	}
	

}
