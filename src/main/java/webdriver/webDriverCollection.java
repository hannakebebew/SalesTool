package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriverCollection {

	private static WebDriver driver;
	
	
	
	public static WebDriver getChromeDriver() {
		
		System.setProperty("webdriver.chrome.driver", "executableDriver/chromedriver.exe");
		driver = new ChromeDriver();	
		return driver;
		
		
	}
	
	
	
	
}
