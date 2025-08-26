package pack1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC01_TestNG {
	WebDriver driver;
	  
  @Test(dataProvider = "LoginData")
  public void f(String userName, String password) {
	  
	  System.out.println("This is the test");
	  
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      WebElement uname = driver.findElement(By.name("username"));
      if(uname.isDisplayed()) {
          uname.sendKeys("Admin");
          System.out.println("Get placeholder: " + uname.getAttribute("placeholder"));
      } else {
          System.out.println("username is not displayed");
      }

      driver.findElement(By.name("password")).sendKeys("admin123");
      driver.findElement(By.name("username")).sendKeys(Keys.ENTER);
      
      WebElement dashboard= driver.findElement(By.xpath("//h6[text()='Dashboard']"));
	  if(dashboard.isDisplayed()) {
		  Assert.assertTrue(true);
	  }
	  else {
		  Assert.assertTrue(false);
	  	}
		}
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is before method");
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();

      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is the after method");
	  driver.quit();
  }


  @DataProvider
  public Object[][] LoginData() {
    return new Object[][] {
      new Object[] { "Maverick", "Topgun23" },
      new Object[] { "Goose", "Topgun12" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is the before class");
	  
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is the after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is the before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is the after class");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is the before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is the after suite");
  }

}
