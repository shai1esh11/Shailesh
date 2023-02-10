package com.AgileCrmAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Sample extends BaseClass {
		
	@Test
	public void addNewContact() throws InterruptedException
	{
	
		launchBrowser("c");
		driver.manage().window().maximize();
		driver.get("https://www.digite.com/");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@id='kairon-client-container']/div[2]/button")).click();
		driver.findElement(By.xpath("//div[@id='kairon-client-container']//input")).sendKeys("Hello");
		driver.findElement(By.xpath("//div[@id='kairon-client-container']//input/following-sibling::button")).click();
		/*
		 * 1. verify when you visit site first time it ask you, Hi, how can I help you
		 * today? 2. verify after clicking on chatbot icon chat window should get
		 * opened, 3. verify you are able to send message 4. verify you should get right
		 * reply for your message, and links 5.Verify It should ask for feedback 6.
		 * verify user should be able to close feedback popup 7. verify user should be
		 * able to close chatbot window
		 */
	}	
	
	}
	
  