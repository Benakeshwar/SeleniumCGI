package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://tutorialsninja.com/demo/index.php?");

        if (driver.getTitle().equals("Your Store")) {
            System.out.println("Title Verified");
        } else {
            System.out.println("Title Mismatch , Found: " + driver.getTitle());
        }

        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();

        WebElement heading = driver.findElement(By.xpath("//h1[text()='Register Account']"));
        if (heading.isDisplayed()) {
            System.out.println("Register Acc Heading verified");
        }

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        WebElement warning = driver.findElement(By.xpath("/html/body/div[2]"));
        if (warning.getText().contains("Privacy Policy")) {
            System.out.println("Warning message Verified");
        }

        //P2
        
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        if (driver.findElements(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).size() > 0) {
            System.out.println("First Name validation working");
        }

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        if (driver.findElements(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).size() > 0) {
            System.out.println("Last Name validation working");
        }

        String uniqueEmail = "benakeshwar" + System.currentTimeMillis() + "@test.com";		//to generate a unique email every time we run the test
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys(uniqueEmail);

        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("12");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        if (driver.findElements(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).size() > 0) {
            System.out.println("Telephone validation working");
        }

        //P4 
        
        //invalid case
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("123");
        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
        confirmPassword.sendKeys("123");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        if (driver.findElements(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).size() > 0) {
            System.out.println("Password validation working");
        }

        // valid case
        password = driver.findElement(By.id("input-password"));
        confirmPassword = driver.findElement(By.id("input-confirm"));
        password.sendKeys("test123");
        confirmPassword.sendKeys("test123");

        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();  // newsletter yes
        driver.findElement(By.name("agree")).click();  // privacy policy
        driver.findElement(By.xpath("//input[@value='Continue']")).click(); // submit

     // Verify success page
        if (driver.findElements(By.xpath("//h1[text()='Your Account Has Been Created!']")).size() > 0) {
            System.out.println("Account creation successful");
        }

        // Final Continue
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Verify order history link
        if (driver.findElements(By.linkText("View your order history")).size() > 0) {
            System.out.println("Order history link available");
        }
        else {
            System.out.println("Order history link NOT found");
        }

        driver.quit();
    }
}
