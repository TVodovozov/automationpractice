/*
 * Created by Timur Vodovozov
 * 29.02.2020
 * */
package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Constants;
import util.Utils;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		driver.get(Constants.BASE_URL);
	}
	
	public WebElement getSignInBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(), \"Sign in\")]"), 30);
	}
}