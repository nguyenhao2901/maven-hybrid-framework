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

public class Level_17_Pattern_Object extends BaseTest {
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

	@Parameters({"browserName","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		firstname = "Nguyen";
		lastname = "Hao";
		password = "123456";
		emailAddress = "bubu" + generatorFakeNumber() + "@gmail.com";

	}

	@Test
	public void TC_01_Register() {
		log.info("Register - Step 01 - Navigate to home page");
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("Register - Step 02 - Click to register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 03 - Enter to firstname textbox with values: " + firstname);
		registerPage.enterToTextboxByID(driver,firstname,"FirstName");
		
		log.info("Register - Step 04 - Enter to lastname textbox with values: " + lastname);
		registerPage.enterToTextboxByID(driver,lastname,"LastName");

		log.info("Register - Step 05 - Enter to email textbox with values: " + emailAddress);
		registerPage.enterToTextboxByID(driver,emailAddress,"Email");

		log.info("Register - Step 06 - Enter to password textbox with values: " + password);
		registerPage.enterToTextboxByID(driver,password,"Password");

		log.info("Register - Step 07 - Enter to confirm password textbox with values: " + password);
		registerPage.enterToTextboxByID(driver,password,"ConfirmPassword");

		log.info("Register - Step 08 - Click to register button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register - Step 09 - Verify success register message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void TC_02_Login() {
		log.info("Login - Step 01 - Click to login link");
		loginPage = registerPage.clickToLoginLink(driver);

		log.info("Login - Step 02 - Enter to email textbox with values: " + emailAddress);
		loginPage.enterToTextboxByID(driver,emailAddress,"Email");

		log.info("Login - Step 03 - Enter to password textbox with values: " + password);
		loginPage.enterToTextboxByID(driver,password,"Password");

		log.info("Login - Step 04 - Click to login button");
		loginPage.clickToButtonByText(driver, "Log in");

		log.info("Login - Step 05 - Init home page");
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("Login - Step 06 - Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void TC_03_My_Account() {
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstname);
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);
	}

	

	@AfterClass(alwaysRun=true)
	public void afterClass() {
		closeBrowserAndDriver();
	}



}
