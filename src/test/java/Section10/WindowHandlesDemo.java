package Section10;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("a[class = 'blinkingText']")).click();
		// the above line will open the another window which we can assume as a child
		// window but the focus of your driver is still in the parent window.
		
		// Below code is to check how to switch from the parent to the child window.
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
	String emailId =	driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
	driver.switchTo().window(parentid);
	driver.findElement(By.cssSelector("#username")).sendKeys(emailId);
	}

}
