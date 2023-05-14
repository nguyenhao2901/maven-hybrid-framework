package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjectTechpandaAndJquery.jqueryDynamicDataGridPageObject;
import pageObjectTechpandaAndJquery.jqueryPageObject;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserRewardPointsPageObject;
import techpandaAndJqueryPageUIs.JqueryPageUI;

public class Level_08_Datatable_Datagrid extends BaseTest {
	WebDriver driver;
	jqueryPageObject jqueryPage;
	jqueryDynamicDataGridPageObject jqueryDynamicDataGridPage;

	@Parameters({ "browserName", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

	}

	@Test
	public void TC_01_Paging_Jquery() {
		jqueryPage = PageGeneratorManager.getJqueryPage(driver);
		jqueryPage.pagingByPageNumber("3");
		jqueryPage.pagingByPageNumber("5");
		jqueryPage.pagingByPageNumber("20");
		jqueryPage.pagingByPageNumber("18");
		jqueryPage.pagingByPageNumber("1");

	}

	@Test
	public void TC_02_Enter_to_Header_Jquery() {
		jqueryPage.enterToTextboxByCloumnName("Country", "Angola");
		jqueryPage.enterToTextboxByCloumnName("Females", "914");
		jqueryPage.enterToTextboxByCloumnName("Males", "959");
		jqueryPage.enterToTextboxByCloumnName("Total", "1873");
		
		BasePage.sleepInSecond(1);

	}
	@Test
	public void TC_03_Action_At_Any_Row_Jquery() {
		jqueryPage.openPageUrl(driver, GlobalConstants.JQUERY_DYNAMIC_DATA_GRID_URL);
		jqueryDynamicDataGridPage = PageGeneratorManager.getJqueryDynamicDataGridPage(driver);
		jqueryDynamicDataGridPage.enterToTextboxByRowIndexAndColunmName("1","Contact Person","Hao test");
		jqueryDynamicDataGridPage.enterToTextboxByRowIndexAndColunmName("2","Company","Hao test1");
		jqueryDynamicDataGridPage.enterToTextboxByRowIndexAndColunmName("2","Company","Hao test2");
		jqueryDynamicDataGridPage.enterToTextboxByRowIndexAndColunmName("2","Company","Hao test3");
		jqueryDynamicDataGridPage.selectCountryAtRowIndexAndCountryName("1","Germany");
		BasePage.sleepInSecond(3);

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
