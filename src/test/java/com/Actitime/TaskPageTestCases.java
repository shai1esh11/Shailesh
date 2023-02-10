package com.Actitime;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ActitimePages.LoginPage;
import com.ActitimePages.TaskPage;
import com.AgileCrmAutomation.MainClass;

public class TaskPageTestCases extends MainClass {

public 		TaskPage taskPage = new TaskPage();
	
	@BeforeMethod
	public void login()
	{
		launchBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.navigate().to("http://user-pc/login.do");
		LoginPage lp=new LoginPage();
		lp.login("sandip", "test");

	}
	@Test(priority=1)
	public void verifyAddNewCustomer() throws IOException
	{
		TaskPage taskPage = new TaskPage();
		taskPage.createNewCustomer("Cognizant");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		for(WebElement link:links)
		{
			System.out.println(link.getText());
			String urlLink=link.getAttribute("href");
			URL url = new URL(urlLink);
			HttpURLConnection httpConnection =(HttpURLConnection)url.openConnection();
			httpConnection.connect();
			int responseCode =httpConnection.getResponseCode();
			System.out.println(responseCode);
			if (responseCode>=400)
			{
				System.out.println("The link is broken"+urlLink );
			}
		}
		
		
	}
	@Test
	public void verifyFrames()
	{
		Random random = new Random();
		taskPage.createNewCustomer(""+random.ints(10));
		driver.switchTo().frame(1);
		System.out.println(driver.getTitle());
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
	}
}
