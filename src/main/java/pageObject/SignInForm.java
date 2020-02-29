/*
 * Created by Timur Vodovozov
 * 29.02.2020
 * */
package pageObject;

import util.Constants;
import util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInForm {

    private WebDriver driver;

    public SignInForm(WebDriver driver) {
        this.driver = driver;
        driver.get(Constants.SIGN_IN_URL);
    }

    public WebElement getSignInForm() {
        return Utils.waitForElementPresence(driver, By.id("login_form"), 30);
    }

    public WebElement getSignInEmailField() {
        return Utils.waitForElementPresence(driver, By.id("email"), 30);
    }

    public WebElement getErrorBlock() {
        return Utils.waitForElementPresence(driver, By.id("authentication"), 30);
    }

    public WebElement getSignInPasswordField() {
        return Utils.waitForElementPresence(driver, By.id("passwd"), 30);
    }

    public WebElement getSignInBtn() {
        return Utils.waitForElementPresence(driver, By.id("SubmitLogin"), 30);
    }

    public void setEmailField(String email) {
        WebElement emailElement = this.getSignInEmailField();
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void setPasswordField(String pass) {
        WebElement password = this.getSignInPasswordField();
        password.clear();
        password.sendKeys(pass);
    }

    public WebElement getEmailRequiredError() {
        return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"An email address required.\")]"), 30);
    }

    public WebElement getPasswordRequiredError() {
        return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Password is required.\")]"), 30);
    }

    public WebElement getAuthenticationFailedError() {
        return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Authentication failed.\")]"), 30);
    }

    public WebElement successfullyCreatedAccount() {
        return Utils.waitForElementPresence(driver, By.xpath("//p[contains(text(), \"Welcome to your account. Here you can manage all of your personal information and orders.\")]"), 30);
    }

    public WebElement successfullyTitle() {
        return Utils.waitForElementPresence(driver, By.xpath("//h1[contains(text(), \"My account\")]"), 100);
    }
}