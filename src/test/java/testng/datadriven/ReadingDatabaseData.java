package testng.datadriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.webDriverCollection;

public class ReadingDatabaseData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {

		ReadingDatabaseData rd = new ReadingDatabaseData();
		rd.databaseData();
	}

	public void databaseData() throws SQLException, ClassNotFoundException, InterruptedException {

		//
		// Host: sql9.freesqldatabase.com
		// Database name: sql9256021
		// Database user: sql9256021
		// Database password: eaLa2KTHR8
		// Port number: 3306



		// ResultSet rs=stmt.executeQuery("select * from emp");
		// stmt.executeUpdate("Insert into Test (Name,Address) values
		// ('Jeevan','Arlington')");
		// stmt.executeUpdate("Insert into Test (Name,Address) values ('Hello
		// World','World')");
		// stmt.executeUpdate("Insert into Test (Name,Address) values
		// ('Hellen','Keller')");
		//
		// System.out.println(stmt.getUpdateCount());
		//
		// System.out.println("Data Inserted in database");

		
		
		Connection con = DriverManager.getConnection("jdbc:mysql://sql9.freesqldatabase.com:3306/sql9256021",
		"sql9256021", "eaLa2KTHR8");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Test");
		WebDriver driver;

		while (rs.next()) {

			String username = rs.getString("Name");
			String password = rs.getString("Address");

			driver = webDriverCollection.getChromeDriver();
			driver.navigate().to("http://www.facebook.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebDriverWait wait = new WebDriverWait(driver, 20);

			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);

			driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);

			Thread.sleep(2000);

			String logInid = driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).getAttribute("for");

			System.out.println("This will be used to find element" + logInid);

			driver.findElement(By.id(logInid)).click();
			;

			
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

			try {
			wait.until(ExpectedConditions.urlToBe("https://www.facebook.com/login.php?login_attempt=1&lwv=111"));
			}
			catch (org.openqa.selenium.TimeoutException e) {
				System.out.println("Invalid Login Id");
			}
			
			driver.close();

		}

	}

}
