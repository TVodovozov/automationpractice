/*
 * Created by Timur Vodovozov
 * 29.02.2020
 * */

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.HomePage;
import pageObject.SignInForm;
import java.util.concurrent.TimeUnit;

public class LoginFormTest {
	private static WebDriver driver;
	private static HomePage homePage;
	private static SignInForm signIn;
	private static String VALID_EMAIL = "seleniumisgood@mail.com";
	private static String INVALID_EMAIL = "vodovozzz@inbox.ru";
	private static String VALID_PASSWORD = "123456";

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();

		homePage = new HomePage(driver);
		signIn = new SignInForm(driver);
		driver.manage().window().maximize();
	}

	@Test
	public void goLoginPage() {
		homePage.getSignInBtn().click();

		Assert.assertTrue(signIn.getSignInForm().isDisplayed());
		Assert.assertTrue(signIn.getSignInEmailField().isDisplayed());
		Assert.assertTrue(signIn.getSignInPasswordField().isDisplayed());
		Assert.assertTrue(signIn.getSignInBtn().isEnabled());
	}

	@Test
	public void successfulLogin() {
		signIn.setEmailField(VALID_EMAIL);
		signIn.setPasswordField(VALID_PASSWORD);
		signIn.getSignInBtn().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(signIn.successfullyCreatedAccount().isDisplayed());
		Assert.assertTrue(signIn.successfullyTitle().isDisplayed());
	}

	@Test
	public void loginWithoutCredentials() {
		signIn.setEmailField("");
		signIn.setPasswordField(VALID_PASSWORD);
		signIn.getSignInBtn().click();

		Assert.assertTrue(signIn.getErrorBlock().isDisplayed());
		Assert.assertTrue(signIn.getEmailRequiredError().isDisplayed());

		signIn.setEmailField(VALID_EMAIL);
		signIn.setPasswordField("");
		signIn.getSignInBtn().click();

		Assert.assertTrue(signIn.getSignInForm().isDisplayed());
		Assert.assertTrue(signIn.getPasswordRequiredError().isDisplayed());

		signIn.setEmailField("");
		signIn.setPasswordField("");
		signIn.getSignInBtn().click();

		Assert.assertTrue(signIn.getSignInForm().isDisplayed());
		Assert.assertTrue(signIn.getEmailRequiredError().isDisplayed());
	}

	@Test
	public void invalidCredentials() {
		signIn.setEmailField(INVALID_EMAIL);
		signIn.setPasswordField(VALID_PASSWORD);
		signIn.getSignInBtn().click();

		Assert.assertTrue(signIn.getAuthenticationFailedError().isDisplayed());
	}

	@AfterClass
	public static void closeAll() {
		driver.quit();
	}
}