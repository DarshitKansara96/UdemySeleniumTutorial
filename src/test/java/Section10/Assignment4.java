package Section10;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.cssSelector("a[href = '/windows/new']")).click();
		Set<String> window = driver.getWindowHandles();
		Iterator<String> t = window.iterator();
		String parentId = t.next();
		String childId = t.next();

		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.xpath("//div[@class = 'example']/h3")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.xpath("//div[@class = 'example']/h3")).getText());

	}
}