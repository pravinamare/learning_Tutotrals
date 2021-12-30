package SeleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		
		// Set System path for browser driver
		System.setProperty("webdriver.chrome.driver" , "C:\\SeleniumBrowserDrive\\chromedriver.exe");
		
		//Open Browser
		WebDriver driver = new ChromeDriver();
		
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

		Thread.sleep(1000);
		
		//Pay bill >> Purchase foreign currency >> Handle  Alert pop-UP
		 
		driver.findElement(By.linkText("Pay Bills")).click(); // locator  ------ By link Text
		
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Purchase Foreign Currency")).click();   // locator  ------By link Text

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[contains(@id,'purchase_cash')]")).click();
		
		Alert webAppSecurityAlert = driver.switchTo().alert();
		
		String alertText = webAppSecurityAlert.getText();
		
		System.out.println("the text on the webAppSecurityAlert is---" + "'"+ alertText + "'");
		
		Thread.sleep(2000);
		
		webAppSecurityAlert.accept();
		
	
		Thread.sleep(2000);
		
		//Close Browser
		
		driver.close();
			
		//quit driver
			
         driver.quit();


	}

}
