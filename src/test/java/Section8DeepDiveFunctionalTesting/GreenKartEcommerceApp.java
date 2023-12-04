package Section8DeepDiveFunctionalTesting;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKartEcommerceApp {

	public static void main(String[] args) {

		// Check multiple items are available in the list and add them in the cart.

		String[] items = { "Cucumber", "Brocolli", "Tomato" };

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		addItems(driver, items, wait);

	}

	public static void addItems(WebDriver driver, String[] items , WebDriverWait wait) {
		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String[] productName = products.get(i).getText().split("-");
			// The above line will split the String but in the UI there is also space
			// available with the name so
			// to avoid the space we will trim the name such that all the spaces are
			// removed.

			String actualProductName = productName[0].trim();

			// You need to extract the items from the web page and compare with the arrays.
			// To achieve this easily let us convert the array into arraylist.

			List<String> arrayproductNames = Arrays.asList(items);

			// Suppose we have to iterate only 3 values but the loop will run for all the
			// values so in this case we can call an additional variable and we can check if
			// j==3 then we will perform break;

			if (arrayproductNames.contains(actualProductName)) {
				// click on add to cart
				driver.findElements(By.xpath("//div[@class = 'product-action']")).get(i).click();
				j++;
				if (j == 3) {
					break;
				}

			}

		}
		
		driver.findElement(By.cssSelector("a.cart-icon")).click();
		driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@class = 'promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		// explicit wait will be defined here.
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

	}

}
