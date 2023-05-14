package com.facebook.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Element_Undisplayed extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.FACEBOOK_URL);
		loginPage = PageGeneratorManager.getLoginPage(driver);

	}

	@Test
	public void TC_01_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		loginPage.enterToEmailTextbox("hao@gmail.com");
		verifyTrue(loginPage.isConfirmEmailTextboxDisplayed());
		loginPage.sleepInSecond(2);
	}

	@Test
	public void TC_02_Element_Undisplayed_In_DOM() {
		loginPage.enterToEmailTextbox("");
		loginPage.sleepInSecond(1);
		verifyTrue(loginPage.isConfirmEmailTextboxUndisplayed());

	}

	@Test
	public void TC_03_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickToCloseSignUpButton();
		verifyTrue(loginPage.isConfirmEmailTextboxUndisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
