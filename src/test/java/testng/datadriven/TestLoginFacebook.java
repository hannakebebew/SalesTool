package testng.datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.internal.PropertiesFile;

import webdriver.webDriverCollection;

public class TestLoginFacebook {
	
	private WebDriver driver;
	
	@Test(dataProvider="excelData", dataProviderClass = testng.datadriven.ExcelReader.class)
	public void loginFacebookTest(String username, String password) throws IOException {
		
		driver = webDriverCollection.getChromeDriver();
		driver.navigate().to("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
	
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
		
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"u_0_w\"]"))));
		driver.findElement(By.xpath("//*[@id=\"u_0_w\"]")).click();
		
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		
		wait.until(ExpectedConditions.urlToBe("https://www.facebook.com/login.php?login_attempt=1&lwv=111"));
		
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"pass\"]")));
		
		
		
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div")).getText());
		
		driver.close();
		
	}

}
