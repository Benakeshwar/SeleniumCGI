package pack1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01 {

	public static void main(String[] args) {
		System.out.println("Java is working");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		/* OR driver.findElement(By.id("APjFqb")).sendKeys("Automation Testing Tools");   This method only searches , doesn't enter the search */
		System.out.println("Title is:" + driver.getTitle());
		WebElement search = driver.findElement(By.id("APjFqb"));
		search.sendKeys("Automation Tools");
		search.submit();
		
	}

}
