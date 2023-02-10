package com.AgileCrmAutomation;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestListener extends BaseClass implements ITestListener,ISuiteListener  {
	ExtentSparkReporter sparkReport;
	ExtentReports extentReport;
	String reportPath;
	
	public void onStart(ISuite suite) {
		
		LocalDateTime dateTime = LocalDateTime.now();
		String timeStamp=dateTime.format(DateTimeFormatter.ofPattern("dd_MM_yyyy_hh_mm"));
		String folderName = "Report_"+timeStamp;
		
		 reportPath=System.getProperty("user.dir")+"//ExcecutionResult//"+folderName;
		 File file = new File(reportPath);
		 if(!file.exists())
		 {
			 file.mkdir();
		 }
		 setExtentReportDetais(); 		
	  }
	private void  setExtentReportDetais()
	{
		sparkReport=new ExtentSparkReporter(reportPath);
		 

		 sparkReport.config().setDocumentTitle("AgileCrmAutomationReport");
		 
		 sparkReport.config().setReportName("Automation_Report");

		 
		 extentReport = new ExtentReports();
		 extentReport.attachReporter(sparkReport);
		 extentReport.setSystemInfo("browser", "chrome");
		 extentReport.setSystemInfo("Enviroment", "Test");
		 extentReport.setSystemInfo("User", "TE1");
		extentReport.attachReporter(sparkReport);
	}
	public void onFinish(ISuite suite) {
		 sparkReport.config().setReportName("Automation_Report");

	    System.out.println("This is onFinish method of ISuite");
	    driver.quit();
	    extentReport.flush();
	  }
	//--------
	public void onTestStart(ITestResult result) {
		
		String methodName=result.getName();
	    logger=extentReport.createTest(methodName);
	    
	    
	    
	}

		  
	public void onTestSuccess(ITestResult result) {
		
		logger.pass("Successfully Executed the Test"+result.getName());
	}
  
	public void onTestFailure(ITestResult result) {
	    System.out.println("This is onFailure method of ITest");

		TakesScreenshot screenshot =(TakesScreenshot)driver;
		File screenshotFile=screenshot.getScreenshotAs(OutputType.FILE);
		String fileName= result.getName();
		String outputFolder = reportPath+"//Screenshots";
		File file= new File(outputFolder);

		if(!file.exists())
		{
			file.mkdir();
		}

		String outputPath= outputFolder+"//"+fileName+".png";
		File outputFile= new File(outputPath);
				
		try {
			FileUtils.copyFile(screenshotFile, outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.fail("The Test ececution failed due to"+result.getThrowable());
		  }	
	  
		public void onTestSkipped(ITestResult result) {
		    System.out.println("This is onTestSkipped method of ITest");

	  
	  }

}