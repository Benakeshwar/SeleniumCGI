package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6 {

    public static void main(String[] args) {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://tutorialsninja.com/demo/index.php?");
        
        //Comp - Monitors
        driver.findElement(By.linkText("Components")).click();
        driver.findElement(By.linkText("Monitors (2)")).click();

        WebElement dropDown = driver.findElement(By.id("input-limit"));
        Select limitSelect = new Select(dropDown);
        limitSelect.selectByVisibleText("25");


        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/div/div[2]/div[2]/button[1]")).click();		//Adding item to cart
        driver.findElements(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/div/div[2]/div[1]/h4/a")).get(0).click();


        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")).click();		//Adding to wishlist
        WebElement wishMsg = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]"));
        String wishText = wishMsg.getText();
        
        if (wishText.contains("must login")) {			//must login to add to wishlist
            System.out.println("Wishlist could not be updated (Login required).");
        } else {
            System.out.println("Wishlist successfully updated!");
        }

        
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));		//For Mobile
        searchBox.sendKeys("Mobile");
        driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
        driver.findElement(By.id("description")).click();
        driver.findElement(By.id("button-search")).click();


        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a")).click();	//Opening HTC prduct
        WebElement qtyBox = driver.findElement(By.id("input-quantity"));
        qtyBox.clear();
        qtyBox.sendKeys("3");


        driver.findElement(By.id("button-cart")).click();		//Adding to cart
        driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")).click();


        WebElement cartItem = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a"));	        // Verifying cart
        String cartText = cartItem.getText();
        
        if (cartText.equals("HTC Touch HD")) {
            System.out.println("Cart check successful: HTC Touch HD is present.");
        } else {
            System.out.println("Cart validation failed!");
        }

        // Flow of checkout
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();

        driver.quit();
    }
}
