package com.ActitimePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AgileCrmAutomation.MainClass;

public class LoginPage extends MainClass {
	@FindBy(name="username")
	public WebElement username;
	@FindBy(name="pwd")
	public WebElement password;
	@FindBy(id="loginButton")
	public WebElement loginButton ;
	public LoginPage()
	{
		PageFactory.initElements(driver,this );		
	}
	public void login(String username,String password)
	{
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		click(loginButton, "Clicked On Login Button");
	}

}
