package com.AgileCrmAutomation;

import java.time.Duration;
import java.util.Arrays;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver =null;
	public static ExtentTest logger;
      
	   public static void launchBrowser(String browser)
        {
        	
        switch(browser)
        {
        case("chrome"):
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Webdriver\\ChromeDriver\\chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        option.setHeadless(true);
		driver = new ChromeDriver();
		break;
        case("edge"):
        System.setProperty("webdriver.edge.driver", "D:\\Selenium Webdriver\\msedgedriver.exe");
		driver = new EdgeDriver();
		break;
        case("firefox"):
       // System.setProperty("webdriver.gecko.driver", "D:\\Selenium Webdriver\\geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		break;
        default:
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Webdriver\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		break;
        }
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        }
        public static void click(By by,String msg)
        {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	WebElement element=driver.findElement(by);
        	wait.until(ExpectedConditions.elementToBeClickable(element));
        	element.click();
        	System.out.println(msg);
        }

        public static void click(WebElement element,String msg)
        {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	wait.until(ExpectedConditions.elementToBeClickable(element));
        	element.click();
        	System.out.println(msg);
        }
        
        public static void waitForVisibility(WebElement element)
        {
        	WebDriverWait wdw = new WebDriverWait(driver,Duration.ofSeconds(10));
        	wdw.until(ExpectedConditions.visibilityOf(element));
        }
        public static void waitForElementToBeClickable(By by)
        {
        	WebDriverWait wdw = new WebDriverWait(driver,Duration.ofSeconds(10));
        	wdw.until(ExpectedConditions.elementToBeClickable(by));
        }
        public static void waitForElementToBeClickable(WebElement element)
        {
        	WebDriverWait wdw = new WebDriverWait(driver,Duration.ofSeconds(10));
        	wdw.until(ExpectedConditions.elementToBeClickable(element));
        }

        
        public static void fluentWait(final By by)
        {
        	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        			.withTimeout(Duration.ofSeconds(10))
        			.pollingEvery(Duration.ofSeconds(2))
        			.ignoring(Exception.class);
        	//wait.until(Function)
        	wait.until(new Function<WebDriver, WebElement>(){
        		public WebElement apply(WebDriver driver) {
        			System.out.println(" Waitin for Webelement");
        			return driver.findElement(by);}
        	});
        			
        		}
            public static void selectDropdownValByIndex(WebElement element, int index)
            {
            	Select select = new Select(element);
            	select.selectByIndex(index);
            	
            }
            public static void selectDropdownByText(WebElement element,String text)
            {
            	Select select = new Select(element);
            	select.selectByVisibleText(text);
            	
            }
        }

