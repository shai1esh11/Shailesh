package com.AgileCrmAutomation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.agilcrm.pages.LoginPage;

public class DealsPagePractice extends BaseClass {
	

	public static void main(String[] args) {
		launchBrowser("chrome");
		LoginPage.login("cst20@yopmail.com", "Test1234");
		click(By.id("dealsmenu"),"Click on Deals Menu");
		

		 waitForElementToBeClickable(By.xpath("//div[@id='New-list-container']//ul/li[1]"));
		 
		 WebElement sss = driver.findElement(By.xpath("//div[@id='New-list-container']//ul/li[1]"));
		 
    	 WebElement proposal=driver.findElement(By.xpath("//ul[@milestone='Proposal']/li"));
    	 
    	WebElement container= driver.findElement(By.id("New-list-container"));
    	 
    	 
    	 Actions action = new Actions(driver);

    	 
    		// waitForElementToBeClickable(By.xpath("//div[@id='New-list-container']//ul/li[1]"));
    		 fluentWait(By.xpath("//ul[@milestone='New']/li"));
    		
    		 
    	 action.dragAndDrop(proposal, container).build().perform();
    	 action.moveToElement(sss);    		


	}

}
