package Section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {

	public static void main(String[] args) {
		
		
		
		WebDriver driver = new ChromeDriver();
		Actions a = new Actions(driver);
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class = 'demo-frame']")));
		WebElement source = driver.findElement(By.cssSelector("div[id = 'draggable']"));
		WebElement destination = driver.findElement(By.cssSelector("div[id = 'droppable']"));
		a.dragAndDrop(source, destination).build().perform();
		driver.switchTo().defaultContent();
		
	}
}
