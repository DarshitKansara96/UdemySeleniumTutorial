package section11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Interview Question

public class GenericCalendar {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0 , 1000)");

		driver.findElement(By.cssSelector("input[id = 'form-field-travel_comp_date']")).click();
		
		while(!driver.findElement(By.xpath("//div[@class = 'flatpickr-current-month']")).getText().contains("September")) {
			driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
		}
		
		List<WebElement> dates = driver.findElements(By.cssSelector(".flatpickr-day"));
		for (int i = 0; i < dates.size(); i++) {
			String dateText = driver.findElements(By.cssSelector(".flatpickr-day")).get(i).getText();
			if (dateText.equals(26)) {
				driver.findElements(By.cssSelector(".flatpickr-day")).get(i).click();
			}
		}

	}

}
