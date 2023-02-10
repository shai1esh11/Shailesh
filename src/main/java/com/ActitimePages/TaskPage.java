package com.ActitimePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AgileCrmAutomation.MainClass;

public class TaskPage extends MainClass{
	public TaskPage()
	{
		PageFactory.initElements(driver,this );		
	}

	@FindBy(xpath="//div[contains(text(),'Tasks')]")
	WebElement taskPageButton;
	
	@FindBy(linkText="Projects & Customers")
	WebElement projectAndCustomerModule;
	
	@FindBy(xpath="//form[@id='customersProjectsForm']/table//td[contains(text(),'Active Projects & Customers')]/following-sibling::td/input[1]")
	WebElement createNewCustomeButton;
	
	@FindBy(xpath="//form[@id='customersProjectsForm']/table//td[contains(text(),'Active Projects & Customers')]/following-sibling::td/input[2]")
	WebElement createNewProjectButton;

	@FindBy(name="name")
	WebElement customerNameField;
	
	@FindBy(name="createCustomerSubmit")
	WebElement createCustomerName;
	
	public void createNewCustomer(String custName)
	{
		taskPageButton.click();
		projectAndCustomerModule.click();
		createNewCustomeButton.click();
		customerNameField.sendKeys(custName);
		createCustomerName.click();
		String successMessage =driver.findElement(By.className("successmsg")).getText();
		System.out.println(successMessage);
		
	}
}
