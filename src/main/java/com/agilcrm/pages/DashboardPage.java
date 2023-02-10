package com.agilcrm.pages;


import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AgileCrmAutomation.BaseClass;

public class DashboardPage extends BaseClass {
	
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="calendarmenu")
	public WebElement calenderMenu;
	@FindBy(id="title")
	public WebElement eventName;
	@FindBy(id="event-time-1")
	public WebElement startTime;
	@FindBy(id="event-time-2")
	public WebElement endTime;
	@FindBy(id="//div[@id='evernotemodal']/following-sibling::div/ul/li")
	public List<WebElement> timePick;
	@FindBy(id="task_event_validate")
	public WebElement validate;
	
	public void newEvent()
	{
		calenderMenu.click();
		List<WebElement>  totalWeeks= driver.findElements(By.xpath("//div[@id='calendar_event']/div//tbody/tr"));
		int totalRows = totalWeeks.size();
		for(int i= 1;i<=totalRows;i++) {

			for (int j=1;j<=7;j++)
			{
				String dayXpath= "//div[@id='calendar_event']/div//table//tr["+i+"]/td["+j+"]";
				WebElement weekDay = driver.findElement(By.xpath(dayXpath));
				
				
				if(!weekDay.getAttribute("class").equals("fc-other-month")) {
					WebElement weekDays=driver.findElement(By.xpath(dayXpath+"/div/div[1]"));
					String day=weekDays.getText();
					String currentDay=String.valueOf(LocalDateTime.now().getDayOfMonth());

					if(day.equals(currentDay))
					{
						System.out.println("selected"+day);
						weekDays.click();
						break;
					}
					
				}

			}
					}
		eventName.sendKeys("New Year");
		startTime.click();
		
		for(int i =0;i<timePick.size();i++)
		{
			WebElement element = timePick.get(i);
			String stime = element.getText();
			System.out.println(stime);
			if(stime.equals("01:00"))
			{
				element.click();
				break;
			}
		}
		for(int i =0;i<timePick.size();i++){

			WebElement element = timePick.get(i);
			String stime = element.getText();
			System.out.println(stime);
			if(stime.equals("08:00"))
			{
				element.click();
				break;
			}
		
		}

	}
	public void  event()
	{
		
	}

}
