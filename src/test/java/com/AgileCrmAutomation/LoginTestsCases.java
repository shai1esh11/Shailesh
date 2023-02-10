package com.AgileCrmAutomation;

import org.testng.annotations.Test;

import com.agilcrm.pages.LoginPage;

import junit.framework.Assert;

public class LoginTestsCases extends BaseClass
{	@Test
	public static void loginWithValidDetails()
	{
		launchBrowser("firefox");
		LoginPage.login("te3@yopmail.com","Test1234");
		String expectedOutput="Agile CRM Dashboard";
		String actualOutput =driver.getTitle();
		System.out.println(expectedOutput);
		Assert.assertEquals(expectedOutput, actualOutput);
		
	      
		}
@Test
public static void loginWithInValidDetails()
{
	launchBrowser("chrome22");
	LoginPage.login("te3@yopmail.com","Test123488");
	String expectedOutput="Agile CRM Dashboard";
	String actualOutput =driver.getTitle();
	System.out.println(expectedOutput);
	Assert.assertEquals(expectedOutput, actualOutput);
	
      
	}
}
