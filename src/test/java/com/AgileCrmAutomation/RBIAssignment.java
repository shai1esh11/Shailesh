package com.AgileCrmAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class RBIAssignment extends BaseClass{

	public static void main(String[] args) throws IOException {
		
				launchBrowser("chrome");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
				driver.manage().window().maximize();
				
				driver.get("https://www.rbi.org.in/");
				JavascriptExecutor js= (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,5000)");
				
				
				driver.findElement(By.xpath("//div[@class='grid_2 omega']/ul/li[3]/a")).click();
				WebElement ro=driver.findElement(By.xpath("//select[@id='drRegionalOffice']"));
				Select rigionalOffice=new Select(ro);
				rigionalOffice.selectByVisibleText("Mumbai");
				
				WebElement mo=driver.findElement(By.xpath("//select[@id='drMonth']"));
				Select month=new Select(mo);
		        month.selectByVisibleText("All Months");
		        driver.findElement(By.id("btnGo")).click();
		        
		         List<WebElement> event= driver.findElements(By.xpath("//div[@id='divHolDesc']/following-sibling::table//tr"));
		         int totalHolidays=event.size();
		            	 List<WebElement>
					  totalMonthts=driver.findElements(By.xpath("//td[@class='tableheader']/b"));

					  for(int j=0; j<totalMonthts.size();) {
						  String months =null ;
						  for (int i = 1;i<=totalHolidays;i++)
					         {
					  
					        	 WebElement holidays = driver.findElement(By.xpath("//div[@id='divHolDesc']/following-sibling::table//tr["+i+"]/td"));
					    
		        	 if (holidays.getAttribute("class").contains("tableheader"))
		        	 {
						 months=totalMonthts.get(j).getText();
						 	j++;
		        	 }
		        	 else
		        	 {
		        		 for (int k = 1;k<3;k++) {
			        	 WebElement holidaysDates = driver.findElement(By.xpath("//div[@id='divHolDesc']/following-sibling::table//tr["+i+"]/td["+k+"]"));
		        		 String date= holidaysDates.getText();
		        		 k=k+1;
			        	 WebElement holidaysDetails = driver.findElement(By.xpath("//div[@id='divHolDesc']/following-sibling::table//tr["+i+"]/td["+k+"]"));

		        		 String eventDetails= holidaysDetails.getText();
		        		 System.out.println(months+","+date+","+eventDetails);
		        		 String output = months+","+date+","+eventDetails;

		        		 }
		        	 }
					  }
		         }
							}

		
	}

