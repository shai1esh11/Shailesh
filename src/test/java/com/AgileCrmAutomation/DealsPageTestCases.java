package com.AgileCrmAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.agilcrm.pages.LoginPage;

public class DealsPageTestCases extends BaseClass {
	String srcStatus="New";
	String dstStatus="Proposal";
  
  @Test (dependsOnMethods = "main")
  
  
  public void changeDealsStatus() throws Exception
  {   waitForElementToBeClickable(By.xpath("//div[@id='"+srcStatus+"-list-container']//ul/li[1]"));
 	 WebElement srcElement = driver.findElement(By.xpath("//div[@id='"+srcStatus+"-list-container']//ul/li[1]"));
 	 //String dealsName= driver.findElement(By.xpath("//div[@id='"+srcStatus+"-list-container']//ul/li[1]/descendant::a[1]")).getText();
 	 WebElement destElement = driver.findElement(By.xpath("//div[@id='"+dstStatus+"-list-container']//ul/li[1]"));
 	 Actions action = new Actions(driver);
 	 action.dragAndDrop(srcElement, destElement).build().perform(); 	 
  }
	//@Test (dependsOnMethods = "changeDealsStatus")
  public void verifyDealsStatus(String expectedStatus, WebElement element) throws Exception
  {
	 	 WebElement dstName= driver.findElement(By.xpath("//div[@id='"+dstStatus+"-list-container']//ul/li[1]/descendant::a[1]"));
	 	//JavascriptExecutor js=(JavascriptExecutor)driver;
	 	driver.switchTo().alert().dismiss();

 	 waitForElementToBeClickable(dstName);
 	// fluentWait(By.xpath("//div[@id='Proposal-list-container']//ul/li[1]"));
 	dstName.click();
 	driver.navigate().refresh();
 	 fluentWait(By.xpath("//div[contains(@class,'seperate-style-new-theme')]/div[2]/div[3]/span[1]"));
 	 String actualStatus = driver.findElement(By.xpath("//div[contains(@class,'seperate-style-new-theme')]/div[2]/div[3]/span[1]")).getText();
 	 System.out.println(actualStatus);
 	 if(actualStatus.equals(expectedStatus))
 	 {
 		 System.out.println("Successfully Performed Drag and Drop Operation");
 	 }
 	 else
 	 {
 		 throw new Exception("Drag and Drop did not worked");
 	 }    	 
  }
	@Test
	public void main () throws Exception
	{
		
		launchBrowser("chrome");
		LoginPage.login("cst20@yopmail.com", "Test1234");
		click(By.id("dealsmenu"),"Click on Deals Menu");
		
		
	}



}
