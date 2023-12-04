package dropdownsdemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownandOthertechniques {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// select static drop down
		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select s = new Select(staticdropdown);
		s.selectByIndex(3);
		// You can also use s.selectByVisibleText("USD");
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByVisibleText("AED");
		System.out.println(s.getFirstSelectedOption().getText());
		/*driver.findElement(By.xpath("//input[@placeholder = 'Type to Select']")).sendKeys("Ind");
		// Since it is an auto suggestive drop down hence user may have multiple options related to the text Ind so in this
		// case find elements needs to be used.
		List<WebElement> options = driver.findElements(By.cssSelector("li[class = 'ui-menu-item'] a"));
		//Since there will be multiple options and to find an option India we will have to iterate all the values.
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}*/
		List<WebElement> checkboxes =	driver.findElements(By.cssSelector("input[type = 'checkbox']"));
		int checkboxsize = checkboxes.size();
		System.out.println(checkboxsize);
		for(WebElement selectcheckbox : checkboxes) {
			((WebElement) checkboxes).click();
		}
		}
		
		
	}

