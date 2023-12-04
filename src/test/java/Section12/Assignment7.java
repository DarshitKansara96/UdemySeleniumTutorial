package Section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0 , 500)");
		
		List <WebElement> getRows = driver.findElements(By.cssSelector("table[class='table-display'] tr"));
		
		System.out.println(getRows.size());
		
		List <WebElement> getColumns = driver.findElements(By.cssSelector("table[class='table-display'] th"));
		System.out.println(getColumns.size());
		
		List <WebElement> getSecondRow = driver.findElements(By.xpath("//table[@class = 'table-display'] //tr[3] //td"));
		
		int j=0;
		for(int i=0 ; i<getSecondRow.size(); i++) {
			j++;
			System.out.println(getSecondRow.get(i).getText());
			if(i==j) {
				break;
			}
		}

	}
}
