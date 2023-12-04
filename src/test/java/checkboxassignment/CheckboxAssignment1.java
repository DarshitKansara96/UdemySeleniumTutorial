package checkboxassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxAssignment1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("(//input[@type = 'checkbox'])[2]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name = 'checkBoxOption2']")).isSelected());
		driver.findElement(By.xpath("(//input[@type = 'checkbox'])[2]")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@name = 'checkBoxOption2']")).isSelected());
		int checkboxsize = driver.findElements(By.xpath("(//input[@type = 'checkbox'])")).size();
		System.out.println(checkboxsize);

	}

}
