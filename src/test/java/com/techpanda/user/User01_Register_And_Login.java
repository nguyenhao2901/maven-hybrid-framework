package com.techpanda.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.ContainerNetworkSettings;

import commons.BaseTest;
import pageObjectTechpandaAndJquery.HomePageObject;
import pageObjectTechpandaAndJquery.LoginPageObject;
import pageObjectTechpandaAndJquery.MyDashboardPageObject;
import pageObjectTechpandaAndJquery.PageGeneratorManager;
import pageObjectTechpandaAndJquery.RegisterPageObject;

public class User01_Register_And_Login extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;

	String firstname, lastname, emailAddress, password;

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("http://live.techpanda.org/");
		firstname = "Nguyen";
		lastname = "Hao";
		emailAddress = "bubu" + generatorFakeNumber() + "@gmail.com";
		password = "123123";

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

	}

	@Test
	public void TC_02_Login() {
		myDashboardPage.clickAccountLink();
		homePage = myDashboardPage.clickLogoutLink();
		homePage.clickToAccountLinkHeader();
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		myDashboardPage = loginPage.clickToLoginButton();
		Assert.assertTrue(myDashboardPage.isWellcomMessageContainText(firstname + " " + lastname));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
