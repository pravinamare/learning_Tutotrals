package SeleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		
		// Set System path for browser driver
				System.setProperty("webdriver.chrome.driver" , "C:\\SeleniumBrowserDrive\\chromedriver.exe");
				
				//Open Browser
				WebDriver driver = new ChromeDriver();
				
				driver.manage().window().maximize();
				
				//Open url
				driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
				
				WebElement iframe = driver.findElement(By.id("iframeResult"));
				driver.switchTo().frame(iframe);
				
				
				driver.findElement(By.xpath("//button[contains(@onclick,'myFunction()')]")).click();
				
				Alert confirmAlert = driver.switchTo().alert();
				
				String alertText = confirmAlert.getText();
				
				System.out.println("the text on the confirmAlert is---" + "'"+ alertText + "'");
		
		
				confirmAlert.accept();
		
				driver.close();
				driver.quit();
				
		

	}

}
