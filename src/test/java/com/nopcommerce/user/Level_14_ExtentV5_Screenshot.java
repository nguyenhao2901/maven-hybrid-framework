package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

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
import reportConfig.ExtentTestManager;

public class Level_14_ExtentV5_Screenshot extends BaseTest {
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
		driver = getBrowserDriver(browserName);
		firstname = "Nguyen";
		lastname = "Hao";
		password = "123456";
		emailAddress = "bubu" + generateRandNumber() + "@gmail.com";
		driver.get(GlobalConstants.USER_URL);

	}

	@Test
	public void TC_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_Register");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01 - Navigate to home page");
		homePage = PageGeneratorManager.getHomePage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02 - Click to register link");
		registerPage = homePage.clickToRegisterLink();

		ExtentTestManager.getTest().log(Status.INFO,
				"Register - Step 03 - Enter to firstname textbox with values: " + firstname);
		registerPage.inputToFirstnameTextbox(firstname);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register - Step 04 - Enter to lastname textbox with values: " + lastname);
		registerPage.inputToLastnameTextbox(lastname);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register - Step 05 - Enter to email textbox with values: " + emailAddress);
		registerPage.inputToEmailTextbox(emailAddress);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register - Step 06 - Enter to password textbox with values: " + password);
		registerPage.inputToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO,
				"Register - Step 07 - Enter to confirm password textbox with values: " + password);
		registerPage.inputToConfirmPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08 - Click to register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO,
				"Register - Step 09 - Verify success register message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");

	}

	@Test
	public void TC_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Login");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01 - Click to login link");
		loginPage = registerPage.clickToLoginLink(driver);

		ExtentTestManager.getTest().log(Status.INFO,
				"Login - Step 02 - Enter to email textbox with values: " + emailAddress);
		loginPage.inputToEmailTextbox(emailAddress);

		ExtentTestManager.getTest().log(Status.INFO,
				"Login - Step 03 - Enter to password textbox with values: " + password);
		loginPage.inputToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04 - Click to login button");
		loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05 - Init home page");
		homePage = PageGeneratorManager.getHomePage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06 - Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void TC_03_Custom_Info_Switch_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_03_Custom_Info_Switch_Page");
		ExtentTestManager.getTest().log(Status.INFO, "Switch page - Step 01 - Click to 'My Account' link");
		customerInfoPage = homePage.clickToMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "Switch page - Step 02 - Open Addresses page ");
		addressPage = (UserAddressPageObject) customerInfoPage.openDynamicLinkAtMyaccount(driver, "Addresses");

		ExtentTestManager.getTest().log(Status.INFO, "Switch page - Step 03 - Open My product reviews page ");
		myProductReview = (UserMyProductReviewPageObject) addressPage.openDynamicLinkAtMyaccount(driver,
				"My product reviews");

		ExtentTestManager.getTest().log(Status.INFO, "Switch page - Step 04 - Open Reward points page ");
		rewardPointPage = (UserRewardPointsPageObject) myProductReview.openDynamicLinkAtMyaccount(driver,
				"Reward points..");

		ExtentTestManager.getTest().log(Status.INFO, "Switch page - Step 05 - Open Customer info page ");
		customerInfoPage = (UserCustomerInfoPageObject) rewardPointPage.openDynamicLinkAtMyaccount(driver,
				"Customer info");

		ExtentTestManager.getTest().log(Status.INFO, "Switch page - Step 06 - Open My product reviews page ");
		myProductReview = (UserMyProductReviewPageObject) customerInfoPage.openDynamicLinkAtMyaccount(driver,
				"My product reviews");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateRandNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
