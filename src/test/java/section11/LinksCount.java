package section11;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCount {

	public static void main(String[] args) throws Exception {

		// Requirement 1: Try to get the links count on the page.
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());

		// Requirement 2: we need to find only those links which are present in the
		// footer.
		// To achieve this we need to limit our driver scope from the entire page to
		// only footer.
		WebElement footerdriver = driver.findElement(By.cssSelector("div[id = 'gf-BIG']"));
		// In the above line using the footerdriver we limited the scope to only footer.
		// Now using the footerdriver object we can check the links present in the
		// footer.
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		// Requirement 3: Find the number of links which are present in the 1st column
		// of the footer.
		// To achieve this now we will limit the footerdriver scope again to only the
		// 1st column.

		WebElement firstColumn = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(firstColumn.findElements(By.tagName("a")).size());

		// Requirement 4: Click on each link in the column and check if new page is
		// getting opened.

		for (int i = 1; i < firstColumn.findElements(By.tagName("a")).size(); i++) {
			String clickonLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			firstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
		} // this for loop will open all the tabs.

		// Requirement 5: Get the titles of all the tabs opened.

		Thread.sleep(5000);

		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
}
