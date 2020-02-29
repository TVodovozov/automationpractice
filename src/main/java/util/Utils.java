/*
 * Created by Timur Vodovozov
 * 29.02.2020
 * */
package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
		return (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
	}

	public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
		return (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
	}
}