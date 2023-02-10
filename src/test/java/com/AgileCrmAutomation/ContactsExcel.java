package com.AgileCrmAutomation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ContactsExcel extends BaseClass{
  @Test
  public void dealsExcel() throws IOException {
		String filepath = "D:\\Shailesh\\Test.xlsx";
		ExcelUtil excelValues = new ExcelUtil();
		Workbook wb=excelValues.getWorkbook(filepath);
		Sheet sheet =wb.createSheet("ContactsImport");

		launchBrowser("chrome22");
	    login("te2@yopmail.com","Test1234");
	    click(By.xpath("//li[@id='contactsmenu']/a"),"Clicked on Contact Menu");
	    fluentWait(By.xpath("//tbody[@id='contacts-list-view-model-list']/tr/td/div/div[2]/a"));
		List<WebElement> firstName=driver.findElements(By.xpath("//tbody[@id='contacts-list-view-model-list']/tr/td/div/div[2]/a"));
		List<WebElement>  emailAdress = driver.findElements(By.xpath("//tbody[@id='contacts-list-view-model-list']/tr/td/div//small"));
		
		Row	header= sheet.createRow(0);
		Cell	uname = header.createCell(0);
		uname.setCellValue("First Name");
		Cell email = header.createCell(1);
		email.setCellValue("Email Id");

		for(int p=1;p<firstName.size();p++)
		{
			Row row;
			Cell cell;
						String names=firstName.get(p-1).getText();
			 row=sheet.createRow(p);
			 cell =row.createCell(0);
			cell.setCellValue(names);
			
			String mail=emailAdress.get(p-1).getText();
			row= sheet.getRow(p);
			cell = row.createCell(1);
			cell.setCellValue(mail);		
	}
		FileOutputStream output = new FileOutputStream(filepath);
		wb.write(output);
		wb.close();
		output.close();
	}  
  public void login(String un , String pwd)
  {
		driver.get("https://way2automation.agilecrm.com/login");
	WebElement username = driver.findElement(By.name("email"));
	username.sendKeys(un);
	WebElement password = driver.findElement(By.name("password"));
	password.sendKeys(pwd);
	WebElement signin = driver.findElement(By.xpath("//input[@type='submit']"));
	signin.click();
}
}

