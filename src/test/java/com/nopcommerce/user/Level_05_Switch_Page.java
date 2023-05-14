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

public class Level_05_Switch_Page extends BaseTest {
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
	public void TC_01_Register() {
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

	@Test
	public void TC_02_Login() {
		loginPage = registerPage.clickToLoginLink(driver);
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void TC_03_Custom_Info_Switch_Page() {
		customerInfoPage = homePage.clickToMyAccountLink();
		addressPage = customerInfoPage.openAddressPage(driver);
		myProductReview = addressPage.openMyProductReviewPage(driver);
		rewardPointPage = myProductReview.openRewardPointsPage(driver);
		customerInfoPage =rewardPointPage.openCustomerInfoPage(driver);
		myProductReview =  customerInfoPage.openMyProductReviewPage(driver);
		

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
