package com.AgileCrmAutomation;

import java.time.Duration;

import org.testng.annotations.Test;

import com.agilcrm.pages.DashboardPage;
import com.agilcrm.pages.LoginPage;

public class DashboardPageTestCases extends BaseClass {
	
	
	@Test
	public void verifyEvent()
	{
		
		launchBrowser("vbvbvb");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage.login("te2@yopmail.com", "Test1234");
		DashboardPage dash = new DashboardPage();
		dash.newEvent();
	}

}
