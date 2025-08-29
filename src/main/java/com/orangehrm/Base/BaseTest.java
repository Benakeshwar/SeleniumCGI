package com.orangehrm.Base;

import java.time.Duration;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BaseTest {
 
		protected WebDriver driver;
		protected ExtentReports extent;
		protected ExtentTest test;
		@BeforeSuite
		public void setupreport()
		{
		    extent = com.orangehrm.utilities.ExtentManager.getinstance(); 
		}
	
	  @BeforeMethod
	  public void setup() {
		
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  	  }
	  
	  @AfterMethod
	  public void teardown() {
		  driver.quit();
	  }
 
	  @AfterSuite
		public void flushreport()
		{
		  extent.flush(); 
		}
	
}