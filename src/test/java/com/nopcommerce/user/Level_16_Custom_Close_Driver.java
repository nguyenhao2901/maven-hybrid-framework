package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserRewardPointsPageObject;

public class Level_16_Custom_Close_Driver extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserAddressPageObject addressPage;
	UserRewardPointsPageObject rewardPointPage;
	UserCustomerInfoPageObject customerInfoPage;
	UserMyProductReviewPageObject myProductReview;
	private String firstname, lastname, emailAddress, password;

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.USER_URL);
		firstname = "Nguyen";
		lastname = "Hao";
		password = "123456";
		emailAddress = "bubu" + generateRandNumber() + "@gmail.com";
		
		log.info("Register - Step 01 - Navigate to home page");
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("Register - Step 02 - Click to register link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 03 - Enter to firstname textbox with values: " + firstname);
		registerPage.inputToFirstnameTextbox(firstname);

		log.info("Register - Step 04 - Enter to lastname textbox with values: " + lastname);
		registerPage.inputToLastnameTextbox(lastname);

		log.info("Register - Step 05 - Enter to email textbox with values: " + emailAddress);
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Register - Step 06 - Enter to password textbox with values: " + password);
		registerPage.inputToPasswordTextbox(password);

		log.info("Register - Step 07 - Enter to confirm password textbox with values: " + password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register - Step 08 - Click to register button");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 09 - Verify success register message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

	}


	@Test
	public void TC_01_Login() {
		log.info("Login - Step 01 - Click to login link");
		loginPage = registerPage.clickToLoginLink(driver);

		log.info("Login - Step 02 - Enter to email textbox with values: " + emailAddress);
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Login - Step 03 - Enter to password textbox with values: " + password);
		loginPage.inputToPasswordTextbox(password);

		log.info("Login - Step 04 - Click to login button");
		loginPage.clickToLoginButton();

		log.info("Login - Step 05 - Init home page");
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("Login - Step 06 - Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	

	@AfterClass(alwaysRun=true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	public int generateRandNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
