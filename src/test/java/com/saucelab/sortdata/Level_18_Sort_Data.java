package com.saucelab.sortdata;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.saucelab.LoginPageObject;
import pageObjects.saucelab.PageGeneratorManager;
import pageObjects.saucelab.ProductPageObject;

public class Level_18_Sort_Data extends BaseTest {
	WebDriver driver;
	String userName = "standard_user";
	String passWord = "secret_sauce";
	LoginPageObject loginPage;
	ProductPageObject productPage;

	@Parameters({ "browserName", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Pre - Condition - Step 01 - Open browser and open url");
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("Pre - Condition - Step 02 - Enter to 'User name' textbox with value: " + userName);
		loginPage.enterToUserNameTextbox(userName);

		log.info("Pre - Condition - Step 03 - Enter to 'Password' textbox with value: " + passWord);
		loginPage.enterToPasswordTextbox(passWord);

		log.info("Pre - Condition - Step 04 - Click to 'Login' button and navigate to product page");
		productPage = loginPage.clickToLoginButton();

	}

	@Test
	public void TC_01_Sort_ASC_By_Name() {
		log.info("Sort_Name_ASC - Step 01 - Click to product sort dropdown");
		productPage.clickToProductSortDropdown();

		log.info("Sort_Name_ASC - Step 02 - Click to 'Name (A to Z)' option");
		productPage.selectSortOptionByOptionText("Name (A to Z)");

		log.info("Sort_Name_ASC - Step 03 - Verify product is sorted ascending by name");
		Assert.assertTrue(productPage.isNameSortASC());

	}

	@Test
	public void TC_02_Sort_DESC_By_Name() {
		log.info("Sort_Name_DESC - Step 01 - Click to product sort dropdown");
		productPage.clickToProductSortDropdown();

		log.info("Sort_Name_DESC - Step 02 - Click to 'Name (Z to A)' option");
		productPage.selectSortOptionByOptionText("Name (Z to A)");

		log.info("Sort_Name_DESC - Step 03 - Verify product is sorted descending by name");
		Assert.assertTrue(productPage.isNameSortDESC());
	}

	@Test
	public void TC_03_Sort_ASC_By_Price() {
		log.info("Sort_Price_ASC - Step 01 - Click to product sort dropdown");
		productPage.clickToProductSortDropdown();

		log.info("Sort_Price_ASC - Step 02 - Click to 'Price (low to high)' option");
		productPage.selectSortOptionByOptionText("Price (low to high)");

		log.info("Sort_Price_ASC - Step 03 - Verify product is sorted ascending by price");
		Assert.assertTrue(productPage.isPriceSortASC());
	}

	@Test
	public void TC_04_Sort_DESC_By_Price() {
		log.info("Sort_Price_DESC - Step 01 - Click to product sort dropdown");
		productPage.clickToProductSortDropdown();

		log.info("Sort_Price_DESC - Step 02 - Click to 'Price (high to low)' option");
		productPage.selectSortOptionByOptionText("Price (high to low)");

		log.info("Sort_Price_DESC - Step 03 - Verify product is sorted descending by price");
		Assert.assertTrue(productPage.isPriceSortDESC());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
