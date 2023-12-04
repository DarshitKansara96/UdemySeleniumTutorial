package Section10;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionsclass {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		Actions a = new Actions(driver);
		// driver is passed in the actions class such that the object a has powerful
		// abilities in handling the page.
		WebElement move = driver.findElement(By.cssSelector("#nav-link-accountList"));
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
		.build().perform();
		a.moveToElement(move).build().perform();
		a.contextClick(move).build().perform();
		
	}

}
