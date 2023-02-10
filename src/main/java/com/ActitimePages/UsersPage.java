package com.ActitimePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AgileCrmAutomation.MainClass;

public class UsersPage extends MainClass {
	public UsersPage()
	{
		PageFactory.initElements(driver,this );		
	}
	@FindBy(xpath="//div[text()='Users']")
	WebElement usersModule;
	@FindBy(id="createNewUserButtonDiv")
	WebElement createNewUserButton;

	@FindBy(name="username")
	WebElement usernameField;
	@FindBy(name="passwordText")
	WebElement passwordField;

	@FindBy(name="passwordTextRetype")
	WebElement passwordFieldRetype;

	@FindBy(name="firstName")
	WebElement firstName;
	@FindBy(name="lastName")
	WebElement lastName;
	@FindBy(xpath="//td[@class='formbuttonpane']/input[1]")
	WebElement submitButton;
	@FindBy(name="email")
	WebElement email;
	
	public void addUser(String un, String pwd,String firstName,String lastName,String email)
	{
		usersModule.click();
		createNewUserButton.click();
		usernameField.sendKeys(un);
		passwordField.sendKeys(pwd);
		passwordFieldRetype.sendKeys(pwd);
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.email.sendKeys(email);
		submitButton.click();
		
	}

}
