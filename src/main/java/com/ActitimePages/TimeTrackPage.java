package com.ActitimePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimeTrackPage {
	@FindBy(xpath="//div[contains(text(),'Time-Track')]")
	WebElement timeTrackPageButton;

}
