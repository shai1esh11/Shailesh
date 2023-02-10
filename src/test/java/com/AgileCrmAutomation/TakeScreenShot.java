package com.AgileCrmAutomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TakeScreenShot extends BaseClass implements ITestListener,ISuiteListener  {
	
	public void onStart(ISuite suite) {
	    System.out.println("This is onStart method of ISuite");
	  }
	public void onFinish(ISuite suite) {
	    System.out.println("This is onFinish method of ISuite");
	  }
	//--------
	public void onTestStart(ITestResult result) {
		    // not implemented
		  }

		  
	public void onTestSuccess(ITestResult result) {
		    // not implemented
		  }

		  
	public void onTestFailure(ITestResult result) {
	    System.out.println("This is onFailure method of ISuite");

		TakesScreenshot screenshot =(TakesScreenshot)driver;
		File screenshotFile=screenshot.getScreenshotAs(OutputType.FILE);
		String fileName= result.getName();
		String outputPath=System.getProperty("user.dir")+"//ExcecutionResult//Screenshots"+fileName+".png";
		File outputFile= new File(outputPath);
		
		try {
			FileUtils.copyFile(screenshotFile, outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		  }

	
	
}
