package com.nopcommerce.user;



import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.Common_02_Register_Get_Cookie;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserRewardPointsPageObject;

public class Level_15_Global_User_pass extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserAddressPageObject addressPage;
	UserRewardPointsPageObject rewardPointPage;
	UserCustomerInfoPageObject customerInfoPage;
	UserMyProductReviewPageObject myProductReview;
	

	@Parameters({"browserName","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.clickToLoginLink(driver);
		
		//use common variable to login
//		loginPage.inputToEmailTextbox(Common_02_Register_Get_Cookie.emailAddress);
//		loginPage.inputToPasswordTextbox(Common_02_Register_Get_Cookie.password);
//		loginPage.clickToLoginButton();
		
		//use cookie to login
		loginPage.setCookie(driver, Common_02_Register_Get_Cookie.loggedCookies);
		loginPage.refreshCurrentPage(driver);
		loginPage.sleepInSecond(2);
		loginPage.clickCloseSuccessLoginNotify();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void TC_01_Custom_Info_Switch_Page() {
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
