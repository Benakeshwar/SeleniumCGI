package pack1;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC02 {

	public static void main(String[] args) {
		System.out.println("Java is working");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println("Title is:" + driver.getTitle());
		
		driver.navigate().to("https://www.yahoo.com/");
		System.out.println("Title is:" + driver.getTitle());
		
		driver.navigate().forward();
		System.out.println("After Forward the Title is:" + driver.getTitle());
		
		driver.navigate().back();
		System.out.println("After Backward the Title is:" + driver.getTitle());
	}
}