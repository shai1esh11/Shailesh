package com.agilcrm.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AgileCrmAutomation.BaseClass;
public class CompanyPage extends BaseClass
{
	@FindBy(xpath = "//button[contains(text(),'Add Company')]") public WebElement addCompanyButton;
	@FindBy(id = "companiesmenu") public WebElement companiesMenu;
	@FindBy(id = "continue-company") public WebElement continueEditButton;
	@FindBy(xpath = "//div[contains(@class,'second')]/descendant::select[@name='email-select']") public WebElement emailDropdown;
	@FindBy(id = "country") public WebElement countryDropdown;
	@FindBy(id = "company-update") public WebElement companyUpdate;

	By emailField  = By.xpath("//div[contains(@class,'second')]/descendant::input[@id='email']"); 

	public CompanyPage()
	{
		PageFactory.initElements(driver,this );		
	}
	
	public void selectFromDropdown()
   {
	   launchBrowser("chrome22");
	   LoginPage.login("te2@yopmail.com", "Test1234");
	   //driver.findElement(By.id("companiesmenu"));

		new CompanyPage();

	   companiesMenu.click();
	   click(companiesMenu,"Click on Company Menu");
	   click(addCompanyButton,"click on add company button");
	   driver.findElement(By.id("company_name")).sendKeys("Yogesh XI");
	   click(continueEditButton,"Click on continue edit button");
	   fluentWait(emailField);
	   waitForVisibility(driver.findElement(emailField));
	   driver.findElement(emailField).sendKeys("ms07@yopmail.com");
	   Select select =new Select(emailDropdown);
       select.selectByIndex(1);
	   Select select2 =new Select(countryDropdown);
	   List<WebElement> countryList= select2.getOptions();
	   int count=0;
	   for(WebElement element2:countryList)
	   {   
		   String text2 = element2.getAttribute("value");
		  if( text2.equals("IN"))
		  {
			  select2.selectByIndex(count);
			  break;
		  }
		  count++;		    
	   }
	   companyUpdate.click();
   }
}