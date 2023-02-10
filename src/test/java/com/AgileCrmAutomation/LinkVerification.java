package com.AgileCrmAutomation;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LinkVerification extends BaseClass{

	public static void main(String[] args) 
	{
		launchBrowser("chrome");
		driver.navigate().to("https://www.amazon.in/");
		List<WebElement> elements=driver.findElements(By.tagName("a"));
		for(WebElement e :elements)
		{
        String link = e.getAttribute("href");
		
		if(link!=null && link.startsWith("https") )
		{
			URL url;
			try {
				url = new URL (link);
				URLConnection urlConnection = url.openConnection();
				HttpsURLConnection connection = (HttpsURLConnection)urlConnection;
				connection.connect();
				int statusCode = connection.getResponseCode();
				if(statusCode!=200)
				{
					System.out.println(statusCode+" Url : "+link);
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
		}
		
		}
	}

}
