package com.agilcrm.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.AgileCrmAutomation.BaseClass;

public class DealsPage extends BaseClass
{
	@FindBy(xpath = "//div[@id='New-list-container']//ul/li[1]") WebElement srcElement;
	@FindBy(xpath = "//div[@id='New-list-container']//ul/li[1]/descendant::a[1]") WebElement srcDeal;
	@FindBy(xpath = "//div[@id='Proposal-list-container']//ul/li[1]") WebElement destElement;
	@FindBy(xpath = "//div[@id='Proposal-list-container']//ul/li[1]/descendant::a[1]") WebElement dstDeal;
	@FindBy(xpath = "//div[contains(@class,'seperate-style-new-theme')]/div[2]/div[3]/span[1]") WebElement dealStatus;


	
     public void changeDealsStatus() throws Exception
     {   waitForElementToBeClickable(srcElement);
    	 String srcdealsName= srcDeal.getText();
    	 System.out.println(srcdealsName);
    	 Actions action = new Actions(driver);
    	 action.dragAndDrop(srcElement, destElement).build().perform();
    	 String dstDealName= dstDeal.getText();
    	 System.out.println(dstDealName);
     }
	
     public void verifyDealsStatus()
     {
    	 waitForElementToBeClickable(destElement);
    	 destElement.click();
    	driver.navigate().refresh();
    	 waitForVisibility(dealStatus);
    	 String actualStatus = dealStatus.getText();
    	 System.out.println(actualStatus);
    	 
    	 Assert.assertEquals(actualStatus, "Proposal");
    	    	 
     }
}
