package com.Actitime;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ActitimePages.LoginPage;
import com.AgileCrmAutomation.MainClass;

public class LoginPageTestCases extends MainClass {

	
	@Test
	public void verifyLogin()
	{
		launchBrowser("chrome");
		driver.navigate().to("http://user-pc/login.do");
		LoginPage lp=new LoginPage();
		lp.login("sandip", "test");
		driver.findElement(By.xpath("//div[text()='Users']")).click();
		
	}
	

}
