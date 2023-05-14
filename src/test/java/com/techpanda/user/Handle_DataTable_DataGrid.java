package com.techpanda.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjectTechpandaAndJquery.AdminHomePageObject;
import pageObjectTechpandaAndJquery.AdminLoginPageObject;
import pageObjectTechpandaAndJquery.HomePageObject;
import pageObjectTechpandaAndJquery.LoginPageObject;
import pageObjectTechpandaAndJquery.MyDashboardPageObject;
import pageObjectTechpandaAndJquery.PageGeneratorManager;
import pageObjectTechpandaAndJquery.RegisterPageObject;

public class Handle_DataTable_DataGrid extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	AdminLoginPageObject adminLoginPage;
	AdminHomePageObject adminHomePage;

	String firstname, lastname, emailAddress, password, adminUserName, adminPassword;

	@Parameters({ "browserName", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		firstname = "Nguyen";
		lastname = "Hao";
		emailAddress = "bubu" + generatorFakeNumber() + "@gmail.com";
		password = "123123";
		adminUserName = "user01";
		adminPassword = "guru99com";

	}

	@Test
	public void TC_01_Register() {
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToAccountLinkHeader();
		loginPage = homePage.clickToMyAccountLinkHeader();
		registerPage = loginPage.clickToCreateAnAccountButton();
		registerPage.inputToFirstnameTextbox(firstname);
		registerPage.inputToLastnameTextbox(lastname);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		myDashboardPage = registerPage.clickToRegisterButton();
		Assert.assertEquals(myDashboardPage.getRegisterSuccessMessage(),
				"Thank you for registering with Main Website Store.");
		myDashboardPage.clickAccountLink();
		homePage = myDashboardPage.clickLogoutLink();

	}

	@Test
	public void TC_02_Handle_DataTable_At_Admin() {
		homePage.openPageUrl(driver, GlobalConstants.ADMIN_URL_TECHPANDA);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminHomePage = adminLoginPage.loginAsAdmin(adminUserName, adminPassword);
		adminHomePage.closePopUp();
		adminHomePage.enterToTextboxByColumnName("email", emailAddress);
		Assert.assertTrue(adminHomePage.isCustomerDisplayed(emailAddress, firstname + " " + lastname));

	}

//	public void TC_03_Login() {
//		myDashboardPage.clickAccountLink();
//		homePage = myDashboardPage.clickLogoutLink();
//		homePage.clickToAccountLinkHeader();
//		loginPage = homePage.clickToLoginLink();
//		loginPage.inputToEmailTextbox(emailAddress);
//		loginPage.inputToPasswordTextbox(password);
//		myDashboardPage = loginPage.clickToLoginButton();
//		Assert.assertTrue(myDashboardPage.isWellcomMessageContainText(firstname + " " + lastname));
//
//	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
