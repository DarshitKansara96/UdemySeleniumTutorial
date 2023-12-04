package section11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//label[@for = 'benz']/input")).click();
		String value = driver.findElement(By.xpath("//label[@for = 'benz']")).getText();
		System.out.println(value);
		
		WebElement dropDown = driver.findElement(By.cssSelector("#dropdown-class-example"));
		Select dropDownValue = new Select(dropDown);
		dropDownValue.selectByVisibleText(value);
		
		driver.findElement(By.cssSelector("input[name = 'enter-name']")).sendKeys(value);
		driver.findElement(By.cssSelector("#alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		String actualText = alertText.split(",")[0].split(" ")[1];
		System.out.println(actualText);
		if(actualText.equals(value)) {
			System.out.println("The alert text matches with the checkbox value");
		}
		else {
			System.out.println("The value did not match");
		}
		driver.switchTo().alert().accept();
		

	}

}
