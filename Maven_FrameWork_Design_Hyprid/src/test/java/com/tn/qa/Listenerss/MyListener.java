package com.tn.qa.Listenerss;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tn.qa.ExtentReportss.ExtentReporter;


public class MyListener implements ITestListener {
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	
	
	@Override
	public void onStart(ITestContext context) {
		try {
			extentReport = ExtentReporter.generateExtentReport();
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void onTestStart(ITestResult result) {
	String testName = result.getName();
	extentTest = extentReport.createTest(testName);
	extentTest.log(Status.INFO, testName + "-> started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.PASS, testName + "-> passed");	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		
		WebDriver driver = null;
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
	
			e.printStackTrace();
		}
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\test-output\\Screenshots\\" +testName+ ".png";
		
		try {
			FileHandler.copy(source, new File(destinationFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//I want to attach the screenshot info into the Extent Report
		extentTest.addScreenCaptureFromPath(destinationFile);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName + "-> failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName + "-> passed");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String testName = result.getName();
		System.out.println(testName + "with this much percentage");
		System.out.println(result.getThrowable());	
	}

	

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreport.html";
		File extentReportpath = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReportpath.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


