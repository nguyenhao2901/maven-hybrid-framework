package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectFactory.HomePageObjectFactory;
import pageObjectFactory.LoginPageObjectFactory;
import pageObjectFactory.RegisterPageObjectFactory;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Level_04_Login_Apply_Page_Factory {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObjectFactory homePage;
	RegisterPageObjectFactory registerPage;
	LoginPageObjectFactory loginPage;
	private String firstname, lastname, existEmailAddress, password, newEmailAddress;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		firstname = "Nguyen";
		lastname = "Hao";
		password = "123456";
		existEmailAddress = "bubu" + generateRandNumber() + "@gmail.com";
		newEmailAddress = "chichi" + generateRandNumber() + "@gmail.net";
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObjectFactory(driver);
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObjectFactory(driver);
		registerPage.inputToFirstnameTextbox(firstname);
		registerPage.inputToLastnameTextbox(lastname);
		registerPage.inputToEmailTextbox(existEmailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void TC_01_Login_Empty_Data() {
		homePage = new HomePageObjectFactory(driver);
		homePage.clickToLoginLink();
		loginPage = new LoginPageObjectFactory(driver);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		homePage = new HomePageObjectFactory(driver);
		homePage.clickToLoginLink();
		loginPage = new LoginPageObjectFactory(driver);
		loginPage.inputToEmailTextbox("123@#@$");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void TC_03_Login_New_Email() {
		homePage = new HomePageObjectFactory(driver);
		homePage.clickToLoginLink();
		loginPage = new LoginPageObjectFactory(driver);
		loginPage.inputToEmailTextbox(newEmailAddress);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_04_Login_Exist_Email_And_Empty_Password() {
		homePage = new HomePageObjectFactory(driver);
		homePage.clickToLoginLink();
		loginPage = new LoginPageObjectFactory(driver);
		loginPage.inputToEmailTextbox(existEmailAddress);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_05_Login_Exist_Email_And_Invalid_Password() {
		homePage = new HomePageObjectFactory(driver);
		homePage.clickToLoginLink();
		loginPage = new LoginPageObjectFactory(driver);
		loginPage.inputToEmailTextbox(existEmailAddress);
		loginPage.inputToPasswordTextbox("55555");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_Exist_Email_And_Valid_Password() {
		homePage = new HomePageObjectFactory(driver);
		homePage.clickToLoginLink();
		loginPage = new LoginPageObjectFactory(driver);
		loginPage.inputToEmailTextbox(existEmailAddress);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		homePage = new HomePageObjectFactory(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
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
