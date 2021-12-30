package SeleniumBasics;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TwoWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		
		// Set System path for browser driver
				System.setProperty("webdriver.chrome.driver" , "C:\\SeleniumBrowserDrive\\chromedriver.exe");
				
				//Open Browser
				WebDriver driver = new ChromeDriver();
				
				driver.manage().window().maximize();
				
				//Open url
				driver.get("https://www.naukri.com/");
		
				String pHandle = driver.getWindowHandle();
				
				System.out.println("parent window ID is-----" + pHandle);
				
				Set<String> handles = driver.getWindowHandles();
				
				System.out.println(handles);
				
				for (String h : handles) {
					if(!pHandle.equalsIgnoreCase(h)) {
						driver.switchTo().window(h);
						System.out.println("Child windows are:"+driver.getTitle());
						Thread.sleep(1000);
						driver.close();
					}
				}
					
					driver.switchTo().window(pHandle);
				
				
					driver.close();
					driver.quit();
				
				
	}

}
