package Section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptExecutorDemo {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0 , 700)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		// Calculate the total amount from the table grid Amount column.
		
		int sum = 0;
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(int i=0 ; i<values.size(); i++) {
		sum = sum +	Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
		
		String totalAmount = driver.findElement(By.xpath("//div[@class = 'totalAmount']")).getText();
		String actualAmount = totalAmount.split(":")[1].trim();
		
		int totalSum = Integer.parseInt(actualAmount);
		Assert.assertEquals(sum, totalSum);
		
		
	}

}
