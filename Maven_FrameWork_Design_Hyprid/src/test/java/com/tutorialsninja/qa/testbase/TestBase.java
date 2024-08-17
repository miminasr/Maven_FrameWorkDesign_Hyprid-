package com.tutorialsninja.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.hybridframework.pages.Utilss;

public class TestBase {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream ip;
	public Properties dataProp;
	public FileInputStream dataIp;
	public TestBase()  {
		 prop= new Properties();
		 try {
			ip= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\tutorialsninja\\qa\\config\\Config.properties");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e1) {
		
			e1.printStackTrace();
		}
		dataProp= new Properties();
		try {
			dataIp= new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\com\\tutorialsninja\\qa\\testData\\dataProp.properties");
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		try {
			dataProp.load(dataIp);
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}
	
	public WebDriver openApplication() {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.addArguments("headless");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
	
	
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilss.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilss.PAGELOAD_TIME));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utilss.SCRIPT_TIME));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
			}
}
