package com.AgileCrmAutomation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class AmazonApplianceSearch extends BaseClass implements ITestListener,ISuiteListener {
	/*
	 * @FindBy(id="twotabsearchtextbox") public static WebElement searchTextBox;
	 * 
	 * @FindBy(xpath="//div[@class='sg-row']/descendant::h2/a/span") public static
	 * WebElement applianceName;
	 */


	@Test
	//@Parameters("browser")
	public static void getAmazonProducts() throws IOException {
		
		PropertyHandling propertyHandling= new PropertyHandling();
    	String browser=propertyHandling.getValue("browser");
    	String agileUrl = propertyHandling.getValue("agileCrmUrl");

		launchBrowser(browser);
		driver.navigate().to(agileUrl);
		selectDropdownByText(driver.findElement(By.id("searchDropdownBox")), "Appliances");
		Assert.fail();
		//searchTextBox.sendKeys("Appliances");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Washing Machine");
		click(By.id("nav-search-submit-button"),"click on search button");
		List<WebElement> applianceName = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::h2/a/span"));
		List<WebElement> applianceprice = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-whole']"));
		
		for(int i=0;i<applianceName.size();i++)
		{
			WebElement nameElement=applianceName.get(i);
			WebElement priceElement = applianceprice.get(i);
			String nameText = nameElement.getText();
			String priceText = priceElement.getText();
			System.out.println(nameText+" Price : "+priceText);
		}
		
        
	}
	
	
	

}
