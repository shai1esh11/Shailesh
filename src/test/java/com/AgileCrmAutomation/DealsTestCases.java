package com.AgileCrmAutomation;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.agilcrm.pages.DealsPage;
import com.agilcrm.pages.LoginPage;

public class DealsTestCases extends BaseClass {
	
	@Test
	@Parameters("browser")
	public void loginAgileCrm (String browser) throws Exception
	{
		
		launchBrowser(browser);
		LoginPage.login("cst20@yopmail.com", "Test1234");
		click(By.id("dealsmenu"),"Click on Deals Menu");
		DealsPage dealsPage = new DealsPage();
		dealsPage.changeDealsStatus();
        
		
	}

}
