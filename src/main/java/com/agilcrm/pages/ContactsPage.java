package com.agilcrm.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.AgileCrmAutomation.BaseClass;

public class ContactsPage extends BaseClass {
	@FindBy(xpath = "//li[@id='contactsmenu']/a") WebElement contactsMenu;
	By addContactButton  = By.xpath("//button[contains(text(),'Add Contact')]"); 
	@FindBy(id = "fname") WebElement firstName;
	@FindBy(id = "lname") WebElement lastName;
	@FindBy(id = "phone") WebElement phoneNo;
	@FindBy(id = "person_validate") WebElement personValidate;
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void addNewContact() 
	{ 	click(contactsMenu,"Clicked on Contact Menu");
		fluentWait(addContactButton);
		click(addContactButton,"Clicked On add Contact");
		waitForVisibility(firstName);
		firstName.sendKeys("Rohit");
		lastName.sendKeys("Sharma");
		phoneNo.sendKeys("9654874500");
		personValidate.click();				
	}
	@FindBy(xpath = "//header[@id='header']/div[2]/ul[1]/li[1]/div/button") WebElement searchButton;
	@FindBy(xpath = "//ul[@name='fields_set']/li[1]/a") WebElement selctAllcheckBox;
	@FindBy(xpath = "//ul[@name='fields_set']/li[2]/a") WebElement ContactCheckBox;
	@FindBy(id = "searchText") WebElement searchField;
	@FindBy(id = "search-results") WebElement searchResult;
	By searchModelList =By.id("search-model-list");	
	
	
	public void searchContact()
	{  	click(searchButton,"Click onSearch Button");
		click(selctAllcheckBox,"Click on select all");
		click(ContactCheckBox,"select Contact");
		searchField.sendKeys("shailesh");
		click(searchResult,"search for result");
		fluentWait(searchModelList);
		click(searchModelList,"Click on result");   
	}   
	By contactList =By.xpath("//a[contains(text(),'Shailesh')]");
	@FindBy(xpath = "//*[@id='contact-details-block']/div/div/div/div/div/div[1]/div/div/div[7]/a[1]") WebElement editContactButton;
	@FindBy(id = "update") WebElement updateContact;
	@FindBy(name = "lname") WebElement updateLastName;

	public void updateContact()
	{	click(contactsMenu,"Clicked on Contact Menu");
		fluentWait(contactList);
		driver.findElement(contactList).click();
		editContactButton.click();
		waitForVisibility(updateLastName);
		updateLastName.clear();
		updateLastName.sendKeys("Patil");
		updateContact.click();
	}
	
	By moreOptions = By.xpath("//*[@id='contact-details-block']/div/div/div/div/div/div[1]/div/div/div[7]/a[1]");
	@FindBy(xpath = "//*[@id='contact-actions-delete']") WebElement deleteButton;
	@FindBy(id = "success_callback") WebElement confirmDelete;

	public void deleteContact()
	{	click(contactsMenu,"Clicked on Contact Menu");
	    fluentWait(contactList);
	    driver.findElement(contactList).click();
	    fluentWait(moreOptions);
	    driver.findElement(moreOptions).click();
	    deleteButton.click();
		click(confirmDelete,"Click on Yes");
		
	}
	
}