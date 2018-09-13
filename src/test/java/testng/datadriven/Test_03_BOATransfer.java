package testng.datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Test_03_BOATransfer {
	private WebDriver driver;
	
	
	@Test
	public void moneyTransferTest() {
		driver = webdriver.webDriverCollection.getChromeDriver();
		driver.navigate().to("http://www.bankofamerica.com");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs("Bank of America - Banking, Credit Cards, Home Loans and Auto Loans"));
		
		
		driver.findElement(By.xpath("//*[@id=\"onlineId1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"onlineId1\"]")).sendKeys("**********");;
				

		driver.findElement(By.xpath("//*[@id=\"passcode1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"passcode1\"]")).sendKeys("**********");;
		
		
		driver.findElement(By.xpath("//*[@id=\"signIn\"]")).submit();
	
		///html/body/div[2]/div[1]/div[1]/div[1]/div/div[2]/ul/li[3]/a
		
		
		try {
		wait.until(ExpectedConditions.titleIs("Bank of America | Online Banking | Accounts Overview"));
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[2]/ul/li[3]/a"))).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[2]/ul/li[3]/div/div[1]/div[2]/a[1]")));
		
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[2]/ul/li[3]/div/div[1]/div[2]/a[1]")).click();
		}
		
		
		catch (Exception e) {
			
			driver.findElement(By.xpath("//*[@id=\"olb-globals-header-container\"]/div[1]/div/div[1]/div[2]/ul/li[4]/a")).click();
			
			
			
		}
	
		
		
		
		
		
		
		
		
				
		driver.close();
				
		
	}
	
	
	
}
