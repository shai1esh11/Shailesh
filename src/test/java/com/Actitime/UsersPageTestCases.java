package com.Actitime;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.ActitimePages.LoginPage;
import com.ActitimePages.UsersPage;
import com.AgileCrmAutomation.MainClass;

public class UsersPageTestCases extends MainClass {
	@Test
	public void verifyAddNewUser()
	{
		launchBrowser("chrome");
		driver.navigate().to("http://user-pc/login.do");
		LoginPage lp=new LoginPage();
		lp.login("sandip", "test");
		UsersPage userPaage=new UsersPage();
		userPaage.addUser("sagar", "test", "sagar", "Gaike", "sagar@yopmail.com");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		for(WebElement link:links)
		{
			System.out.println(link.getText());
		}
	}
	@Test
	public void verifyLinks() throws AWTException, InterruptedException
	{
		launchBrowser("chrome");
		driver.navigate().to("http://user-pc/login.do");
		LoginPage lp=new LoginPage();
		lp.login("sandip", "test");
		WebElement createTask=driver.findElement(By.xpath("//a[text()='View Time-Track']"));
		Actions act = new Actions(driver);
		act.moveToElement(createTask).build().perform();
		act.contextClick().build().perform();
		Robot rb = new Robot();
		Thread.sleep(5000);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseWheel(700);
		
		
	}

}
 