package SeleniumBasics;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
	
		
		
				// Set System path for browser driver
				System.setProperty("webdriver.chrome.driver" , "C:\\SeleniumBrowserDrive\\chromedriver.exe");
				
				//Open Browser
				WebDriver driver = new ChromeDriver();
				
				//Implicit Wait
				
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				
				driver.manage().window().maximize();
				
				//Open url
				driver.get("http://zero.webappsecurity.com/");
				
				
				
				//Login
				driver.findElement(By.id("signin_button")).click();    //locator  ------ By Id
				
				driver.findElement(By.name("user_login")).sendKeys("username");  // locator  ------ By name
				
				driver.findElement(By.cssSelector("[type='password']")).sendKeys("password");  //locator------ CSS locator by attribute
				
				driver.findElement(By.name("submit")).click();
				driver.findElement(By.id("details-button")).click();
				driver.findElement(By.id("proceed-link")).click();

				//Thread.sleep(1000);
				
				//Pay bill >> Add new Payee
				 
				driver.findElement(By.linkText("Pay Bills")).click(); // locator  ------ By link Text
				
				
				//ExplicitWait
				
				
				WebDriverWait ewait1 = new WebDriverWait(driver, 10);
				
				ewait1.until(ExpectedConditions.urlMatches("http://zero.webappsecurity.com/bank/pay-bills.html"));
				
				driver.findElement(By.partialLinkText("Add New Pay")).click();   // locator  ------ By partial link Text
				
				
				WebDriverWait ewait2 = new WebDriverWait(driver, 10);
				
				ewait2.until(ExpectedConditions.textToBe(By.xpath("(//h2[contains(text(),'Who are you paying?')])"), "Who are you paying?"));
				
				
				driver.findElement(By.xpath("//input[@id='np_new_payee_name']")).sendKeys("Pravina");   // locator  ------ By xpath
	
				driver.findElement(By.xpath("//textarea[contains(@id,'np_new_payee_address')]")).sendKeys("L&T Shivajinagar, Pune"); // locator  ------ By xpath with contains( )with attribute
	
				driver.findElement(By.xpath("//input[contains(@id,'np_new_payee_account')]")).sendKeys("12345678912332");
				
				driver.findElement(By.xpath("//input[contains(@id,'np_new_payee_details')]")).sendKeys("Employee");
				
				driver.findElement(By.xpath("//input[contains(@id,'add_new_payee')]")).click(); // locator  ------ By xpath with contains( )with attribute
				
				
				//Logout
				driver.findElement(By.xpath("//i[@class='icon-user']")).click();
				driver.findElement(By.id("logout_link")).click();
				
				
	//Thread.sleep(2000);
	
	
				driver.close();
				driver.quit();
				
	
	
	
	
	}

}
