package pack1;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC03 {

	public static void main(String[] args) {
		System.out.println("Java is working");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("title is:"+driver.getTitle());
		System.out.println("url is:"+driver.getCurrentUrl());
		System.out.println("page source is:"+driver.getPageSource());
	}
}