package com.AgileCrmAutomation;


//import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;

public class Demo extends BaseClass {
 
  public static void main(String[] args) {
	  launchBrowser("chrome22");

	  login("te1@yopmail.com","Test1234");
	  click(By.xpath("//li[@id='contactsmenu']/a"),"Clicked on Contact Menu");
	  fluentWait(By.xpath("//tbody[@id='contacts-list-view-model-list']/tr/td/div/div[2]/a"));
		List<WebElement> firstName=driver.findElements(By.xpath("//tbody[@id='contacts-list-view-model-list']/tr/td/div/div[2]/a"));
		List<WebElement>  emailAdress = driver.findElements(By.xpath("//tbody[@id='contacts-list-view-model-list']/tr/td/div//small"));
		System.out.println(firstName);
		
		System.out.println(emailAdress);
		for(int p=0;p<firstName.size();p++)
		{
		
			String dealName=firstName.get(p).getText();
			System.out.print(dealName+" ");
		
			if(p<emailAdress.size()) {
				System.out.print(" "+emailAdress.get(p).getText());
				}

		System.out.println();

		}
}
  public static void login(String un , String pwd)
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
