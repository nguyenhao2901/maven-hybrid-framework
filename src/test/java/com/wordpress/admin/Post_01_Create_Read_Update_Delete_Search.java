package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.admin.AdminDashboardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminPostAddNewOrUpdatePO;
import pageObjects.wordpress.admin.AdminPostSearchPO;
import pageObjects.wordpress.admin.PageGeneratorManager;
import pageObjects.wordpress.endUser.EuHomePO;
import pageObjects.wordpress.endUser.EuPostDetailPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	WebDriver driver;
	String endUserUrl;
	String adminUrl;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewOrUpdatePO adminPostAddnewOrUpdatePage;
	EuHomePO euHomePage;
	EuPostDetailPO euPostDetailPage;
	String adminUserName = "abubu_admin";
	String adminPassword = "abubu_admin";
	int randomNumber = generatorFakeNumber();
	String postTitle = "Hao Test Post Title " + randomNumber;
	String postBody = "Hao Test Post Body " + randomNumber;
	String postTitleUpdate = "Hao Update Test Post Title " + randomNumber;
	String postBodyUpdate = "Hao Update Test Post Body " + randomNumber;
	String searchPostUrl;
	String currentDate = getCurrentDate();

	@Parameters({ "browserName", "AdminUrl", "EndUserUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre - Condition - Step 01 - Open browser and open admin url");
		driver = getBrowserDriver(browserName, adminUrl);
		this.endUserUrl = endUserUrl;
		this.adminUrl = adminUrl;
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre - Condition - Step 02 - Login with account admin: " + adminUserName + "/" + adminPassword);
		adminDashboardPage = adminLoginPage.loginAsAdmin(driver, adminUserName, adminPassword);

		log.info("Pre - Condition - Step 03 - Verify login success");
		Assert.assertTrue(adminDashboardPage.isAccountNameDisplay(adminUserName));

	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create post - Step 01 - Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Create post - Step 02 - Click to 'Add new' button");
		// get searchPostUrl
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);
		adminPostAddnewOrUpdatePage = adminPostSearchPage.clickToAddNewButton();

		log.info("Create post - Step 03 - Enter to post title with value: " + postTitle);
		adminPostAddnewOrUpdatePage.enterToPostTitle(postTitle);

		log.info("Create post - Step 04 - Enter to post body with value: " + postBody);
		adminPostAddnewOrUpdatePage.enterToPostBody(postBody);

		log.info("Create post - Step 05 - Click to 'pre' - 'Publish' button");
		adminPostAddnewOrUpdatePage.clickToPrePublishButton();

		log.info("Create post - Step 06 - Click to 'Publish' button");
		adminPostAddnewOrUpdatePage.clickToPublishOrUpdateButton();

		log.info("Create post - Step 07 - Verify post published message is display");
		Assert.assertTrue(adminPostAddnewOrUpdatePage.isPostPublishOrUpdateMessageDisplay("Post published."));

	}

	@Test
	public void Post_02_Search_And_View_Post() {
		log.info("Search and view post - Step 01 - Open search post page");
		adminPostAddnewOrUpdatePage.openPageUrl(driver, searchPostUrl);
		adminPostSearchPage = PageGeneratorManager.getAdminPostSearchPage(driver);

		log.info("Search and view post - Step 02 - Enter to search textbox with value: " + postTitle);
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Search and view post - Step 03 - Click 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Search and view post - Step 04 - Verify post infor is display in result table");
		Assert.assertTrue(adminPostSearchPage.isPostInfoDisplayByIdAndInfoValue("title", postTitle));
		Assert.assertTrue(adminPostSearchPage.isPostInfoDisplayByIdAndInfoValue("author", adminUserName));

		log.info("Search and view post - Step 05 - Open home page at end user site");
		adminPostSearchPage.openPageUrl(driver, endUserUrl);
		euHomePage = PageGeneratorManager.getEuHomePage(driver);

		log.info("Search and view post - Step 06 - Enter to search textbox with value: " + postTitle);
		euHomePage.enterToSearchTextbox(postTitle);

		log.info("Search and view post - Step 07 - Click 'Search' button");
		euHomePage.clickToSearchButton();

		log.info("Search and view post - Step 08 - Verify post infor is display at home page");
		Assert.assertTrue(euHomePage.isPostTitleDisplay(postTitle));
		Assert.assertTrue(euHomePage.isPostBodyDisplay(postBody));
		Assert.assertTrue(euHomePage.isPostAuthorDisplay(adminUserName));
		Assert.assertTrue(euHomePage.isPostDateDisplay(currentDate));

		log.info("Search and view post - Step 09 - Click to post title link");
		euPostDetailPage = euHomePage.clickToPostTitle();

		log.info("Search and view post - Step 10 - Verify post infor is display at post detail page");
		Assert.assertTrue(euPostDetailPage.isPostTitleDisplay(postTitle));
		Assert.assertTrue(euPostDetailPage.isPostBodyDisplay(postBody));
		Assert.assertTrue(euPostDetailPage.isPostAuthorDisplay(adminUserName));
		Assert.assertTrue(euPostDetailPage.isPostDateDisplay(currentDate));

	}

	@Test
	public void Post_03_Edit_Post() {
		log.info("Edit_Post - Step 01 - Open admin site");
		euPostDetailPage.openPageUrl(driver, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Edit_Post - Step 02 - Login with account admin: " + adminUserName + "/" + adminPassword);
		adminDashboardPage = adminLoginPage.loginAsAdmin(driver, adminUserName, adminPassword);

		log.info("Edit_Post - Step 03 - Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Edit_Post - Step 04 - Enter to search textbox with value: " + postTitle);
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Edit_Post - Step 05 - Click 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Edit_Post - Step 06 - Click to post title link and navigate to edit page");
		adminPostAddnewOrUpdatePage = adminPostSearchPage.clickToPostTitle();

		log.info("Edit_Post - Step 07 - Enter to post title with update value: " + postTitleUpdate);
		adminPostAddnewOrUpdatePage.enterToPostTitle(postTitleUpdate);

		log.info("Edit_Post - Step 8 - Enter to post body with update value: " + postBodyUpdate);
		adminPostAddnewOrUpdatePage.editToPostBody(postBodyUpdate);

		log.info("Edit_Post - Step 9 - Click to 'Update' button");
		adminPostAddnewOrUpdatePage.clickToPublishOrUpdateButton();

		log.info("Edit_Post - Step 10 - Verify 'Post updated.' message is display");
		adminPostAddnewOrUpdatePage.isPostPublishOrUpdateMessageDisplay("Post updated.");

		log.info("Edit_Post - Step 11 - Open search post page");
		adminPostAddnewOrUpdatePage.openPageUrl(driver, searchPostUrl);
		adminPostSearchPage = PageGeneratorManager.getAdminPostSearchPage(driver);

		log.info("Edit_Post - Step 12 - Enter to search textbox with value: " + postTitleUpdate);
		adminPostSearchPage.enterToSearchTextbox(postTitleUpdate);

		log.info("Edit_Post - Step 13 - Click 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Edit_Post - Step 14 - Verify post infor is display in result table");
		Assert.assertTrue(adminPostSearchPage.isPostInfoDisplayByIdAndInfoValue("title", postTitleUpdate));
		Assert.assertTrue(adminPostSearchPage.isPostInfoDisplayByIdAndInfoValue("author", adminUserName));

		log.info("Edit_Post - Step 15 - Open home page at end user site");
		adminPostSearchPage.openPageUrl(driver, endUserUrl);
		euHomePage = PageGeneratorManager.getEuHomePage(driver);

		log.info("Edit_Post - Step 16 - Enter to search textbox with value: " + postTitleUpdate);
		euHomePage.enterToSearchTextbox(postTitleUpdate);

		log.info("Edit_Post - Step 17 - Click 'Search' button");
		euHomePage.clickToSearchButton();

		log.info("Edit_Post - Step 18 - Verify post infor is display at home page");
		Assert.assertTrue(euHomePage.isPostTitleDisplay(postTitleUpdate));
		Assert.assertTrue(euHomePage.isPostBodyDisplay(postBodyUpdate));
		Assert.assertTrue(euHomePage.isPostAuthorDisplay(adminUserName));
		Assert.assertTrue(euHomePage.isPostDateDisplay(currentDate));

		log.info("Edit_Post - Step 19 - Click to post title link");
		euPostDetailPage = euHomePage.clickToPostTitle();

		log.info("Edit_Post - Step 20 - Verify post infor is display at post detail page");
		Assert.assertTrue(euPostDetailPage.isPostTitleDisplay(postTitleUpdate));
		Assert.assertTrue(euPostDetailPage.isPostBodyDisplay(postBodyUpdate));
		Assert.assertTrue(euPostDetailPage.isPostAuthorDisplay(adminUserName));
		Assert.assertTrue(euPostDetailPage.isPostDateDisplay(currentDate));

	}

	@Test
	public void Post_04_Delete_Post() {
		log.info("Delete_Post - Step 01 - Open admin site");
		euPostDetailPage.openPageUrl(driver, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Delete_Post - Step 02 - Login with account admin: " + adminUserName + "/" + adminPassword);
		adminDashboardPage = adminLoginPage.loginAsAdmin(driver, adminUserName, adminPassword);

		log.info("Delete_Post - Step 03 - Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Delete_Post - Step 04 - Enter to search textbox with value: " + postTitleUpdate);
		adminPostSearchPage.enterToSearchTextbox(postTitleUpdate);

		log.info("Delete_Post - Step 05 - Click 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Delete_Post - Step 06 - Click to 'Trash' link");
		adminPostSearchPage.clickToTrashLink();

		log.info("Delete_Post - Step 07 - Verify post moved message is display");
		Assert.assertTrue(adminPostSearchPage.isPostMovedMessageDisplay("1 post moved to the Trash."));

		log.info("Delete_Post - Step 08 - Open home page at end user site");
		adminPostSearchPage.openPageUrl(driver, endUserUrl);
		euHomePage = PageGeneratorManager.getEuHomePage(driver);

		log.info("Delete_Post - Step 09 - Enter to search textbox with value: " + postTitleUpdate);
		euHomePage.enterToSearchTextbox(postTitleUpdate);

		log.info("Delete_Post - Step 10 - Click 'Search' button");
		euHomePage.clickToSearchButton();

		log.info("Delete_Post - Step 11 - Verify 'Nothing Found' message is display");
		euHomePage.isNothingFoundMessageDisplay("Nothing Found");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
