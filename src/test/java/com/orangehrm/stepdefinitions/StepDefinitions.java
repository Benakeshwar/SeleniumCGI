package com.orangehrm.stepdefinitions;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class StepDefinitions {
	
	WebDriver driver;
	
	@Given("Open the Browser")
	public void open_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
 
	@And("Navigate to the url")
	public void navigate_to_the_url() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(3000);
	}
	
	@Then("Close the browser")
	public void close_the_browser() {
	   driver.quit();
	}
 
 
 
	@Then("Enter the valid username and password")
	public void enter_the_valid_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("Admin");
				driver.findElement(By.name("password")).sendKeys("admin123");
				
	}
 
	@And("Click on Login")
	public void click_on_login() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
 
	@Then("Verify login success")
	public void verify_login_success() {
	  System.out.println("login success");
	}
 
	@Then("Enter the invalid username and password")
	public void enter_the_invalid_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("Admin12121");
		driver.findElement(By.name("password")).sendKeys("admin123rewerwe");
	}
 
	@Then("Verify login unsuccess")
	public void verify_login_unsuccess() {
	    System.out.println("login unsuccess");
	}
	
	
	
	
 
}