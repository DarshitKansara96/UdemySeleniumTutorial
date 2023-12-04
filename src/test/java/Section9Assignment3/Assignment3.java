package Section9Assignment3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

// Sign in to the URL and add all the values to the cart and checkout. 
// Cover checkbox, radio button, drop down and explicit wait in the process.

public class Assignment3 {

	public static void Assignment3(WebDriver driver, WebDriverWait wait) {

		

		driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#password")).sendKeys("learning");
		driver.findElement(By.xpath("(//label[@class = 'customradio'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#okayBtn")));
		driver.findElement(By.cssSelector("#okayBtn")).click();
		WebElement selectDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select selectValue = new Select(selectDropdown);
		selectValue.selectByVisibleText("Consultant");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-group']")));
	List<WebElement> listItems =	driver.findElements(By.cssSelector("button[class = 'btn btn-info']"));
	for(int i=0 ; i<listItems.size(); i++) {
		listItems.get(i).click();
	}
	driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Assignment3(driver , wait);
	}

}
