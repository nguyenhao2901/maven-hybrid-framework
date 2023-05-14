package commons;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Common_01_Register_End_User extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	private String firstname, lastname;
	public static String emailAddress;
	public static String password;

	@Parameters({"browserName","url"})
	@BeforeTest
	public void beforeTest(String browserName, String url) {
		driver= getBrowserDriver(browserName, url);
		firstname = "Nguyen";
		lastname = "Hao";
		emailAddress = "bubu" + generatorFakeNumber() + "@gmail.com";
		password = "123123";
		
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstnameTextbox(firstname);
		registerPage.inputToLastnameTextbox(lastname);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
