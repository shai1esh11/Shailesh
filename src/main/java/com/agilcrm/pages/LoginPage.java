package com.agilcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.AgileCrmAutomation.BaseClass;

public class LoginPage extends BaseClass {
	
	public static void login(String un,String pwd)
	{
		
		driver.get("https://way2automation.agilecrm.com/login");
		WebElement username = driver.findElement(By.name("email"));
		username.sendKeys(un);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(pwd);
		WebElement signin = driver.findElement(By.xpath("//input[@type='submit']"));
		signin.click();
		
		
		
	}

}
