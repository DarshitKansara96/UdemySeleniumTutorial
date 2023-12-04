package Section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
		 driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("input[placeholder = 'Type to Select Countries']")).sendKeys("India");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder = 'Type to Select Countries']")).sendKeys(Keys.DOWN);
		driver.findElement(By.cssSelector("input[placeholder = 'Type to Select Countries']")).sendKeys(Keys.DOWN , Keys.ENTER);
		System.out.println(driver.findElement(By.cssSelector("input[placeholder = 'Type to Select Countries']")).getAttribute("value"));
	}

}
