package com.AgileCrmAutomation;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class ContactPageTestCases extends BaseClass {
	  @Test (priority=1,groups = "regression")
  public void addContact() {
	   	click(By.xpath("//li[@id='contactsmenu']/a"),"Clicked on Contact Menu");
		fluentWait(By.xpath("//button[contains(text(),'Add Contact')]"));
		click(By.xpath("//button[contains(text(),'Add Contact')]"),"Clicked On add Contact");
		waitForVisibility(driver.findElement(By.id("fname")));
		driver.findElement(By.id("fname")).sendKeys("Rohit");
		driver.findElement(By.id("lname")).sendKeys("Sharma");
		driver.findElement(By.id("phone")).sendKeys("9654874500");
		driver.findElement(By.id("person_validate")).click();	
	  

  }
  @Test (priority=2,groups = "regression")
  public void searchContact()
	{   click(By.xpath("//header[@id='header']/div[2]/ul[1]/li[1]/div/button"),"Click onSearch Button");
		click(By.xpath("//ul[@name='fields_set']/li[1]/a"),"Click on select all");
		click(By.xpath("//ul[@name='fields_set']/li[2]/a"),"select Contact");
		driver.findElement(By.id("searchText")).sendKeys("shailesh");
		click(By.id("search-results"),"search for result");
		fluentWait(By.id("search-model-list"));
		click(By.id("search-model-list"),"Click on result");   
	}
  @Test (priority=3,groups = "regression")
  public void updateContact()
	{	click(By.xpath("//li[@id='contactsmenu']/a"),"Clicked on Contact Menu");
		fluentWait(By.xpath("//a[contains(text(),'Shailesh')]"));
		driver.findElement(By.xpath("//a[contains(text(),'Shailesh')]")).click();
		driver.findElement(By.xpath("//*[@id=\"contact-details-block\"]/div/div/div/div/div/div[1]/div/div/div[7]/a[1]")).click();
		WebElement lastName= driver.findElement(By.id("lname"));
		lastName.clear();
		lastName.sendKeys("Patil");
		driver.findElement(By.id("update")).click();
	}
  @Test (priority=4,groups = "regression")
  @Parameters("chrome")
	public void deleteContact()
	{	click(By.xpath("//li[@id='contactsmenu']/a"),"Clicked on Contact Menu");
	    fluentWait(By.xpath("//a[contains(text(),'Shailesh')]"));
	    driver.findElement(By.xpath("//a[contains(text(),'Shailesh')]")).click();
	    fluentWait(By.xpath("//div[@id=\"contact-details-block\"]/div/div/div/div/div/div[1]/div/div/div[7]/div/button"));
	    driver.findElement(By.xpath("//div[@id=\"contact-details-block\"]/div/div/div/div/div/div[1]/div/div/div[7]/div/button")).click();
	    driver.findElement(By.xpath("//*[@id=\"contact-actions-delete\"]")).click();
		click(By.id("success_callback"),"Click on Yes");
		
	}
  @BeforeClass (groups = {"regression","sanity"})
  @Parameters
  ( value= "browser") 
  
  public void login(String browser) {
	  launchBrowser("chrome");
	  driver.get("https://learnautomation.agilecrm.com/login");
		WebElement username = driver.findElement(By.name("email"));
		username.sendKeys("cst20@yopmail.com");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Test1234");
		WebElement signin = driver.findElement(By.xpath("//input[@type='submit']"));
		signin.click();

  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Logout from application");
	  
  }

}
