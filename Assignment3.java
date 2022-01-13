package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		
		// Set System path for browser driver
		System.setProperty("webdriver.chrome.driver" , "C:\\SeleniumBrowserDrive\\chromedriver.exe");
		
		//Open Browser
		WebDriver driver = new ChromeDriver();
		
		
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

		
		//Pay bill >> Purchase foreign currency >> Handle  Alert pop-UP
		 
		driver.findElement(By.linkText("Pay Bills")).click(); 
		
		//ExplicitWait
		WebDriverWait ewait1 = new WebDriverWait(driver, 10);
		
		ewait1.until(ExpectedConditions.urlMatches("http://zero.webappsecurity.com/bank/pay-bills.html"));
		
		driver.findElement(By.linkText("Purchase Foreign Currency")).click();  
		
		WebDriverWait ewait2 = new WebDriverWait(driver, 10);
		
		ewait2.until(ExpectedConditions.textToBe(By.xpath("(//h2[contains(text(),'Purchase foreign currency cash')])"), "Purchase foreign currency cash"));

	
		
		driver.findElement(By.xpath("//input[contains(@id,'purchase_cash')]")).click();
		
		Alert webAppSecurityAlert = driver.switchTo().alert();
		
		String alertText = webAppSecurityAlert.getText();
		
		System.out.println("the text on the webAppSecurityAlert is---" + "'"+ alertText + "'");
		
		Thread.sleep(2000);
		
		webAppSecurityAlert.accept();
		
	
		//Logout
		driver.findElement(By.xpath("//i[@class='icon-user']")).click();
		driver.findElement(By.id("logout_link")).click();
		
		
		//Close Browser
		
		driver.close();
			
		//quit driver
			
         driver.quit();


	}

}
