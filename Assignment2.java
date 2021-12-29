package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

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
				
				//Pay bill >> Add new Payee
				 
				driver.findElement(By.linkText("Pay Bills")).click(); // locator  ------ By link Text
				
				Thread.sleep(1000);
				
				driver.findElement(By.partialLinkText("Add New Pay")).click();   // locator  ------ By partial link Text
		
				Thread.sleep(1000);
				
				
				driver.findElement(By.xpath("//input[@id='np_new_payee_name']")).sendKeys("Pravina");   // locator  ------ By xpath
	
				driver.findElement(By.xpath("//textarea[contains(@id,'np_new_payee_address')]")).sendKeys("L&T Shivajinagar, Pune"); // locator  ------ By xpath with contains( )with attribute
	
				driver.findElement(By.xpath("//input[contains(@id,'np_new_payee_account')]")).sendKeys("12345678912332");
				
				driver.findElement(By.xpath("//input[contains(@id,'np_new_payee_details')]")).sendKeys("Employee");
				
				driver.findElement(By.xpath("//input[contains(@id,'add_new_payee')]")).click(); // locator  ------ By xpath with contains( )with attribute
				
				
				//driver.findElement(By.xpath("//a[contains(@class,'dropdown-toggle')][2]")).click();
				
				
	Thread.sleep(2000);
	
	
	//Close Browser
				
			driver.close();
				
	//quit driver
				
	         driver.quit();
	
	
	
	
	}

}
