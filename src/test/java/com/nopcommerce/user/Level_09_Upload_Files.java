package com.nopcommerce.user;

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
import pageObjectTechpandaAndJquery.UploadFileHomePageObject;

public class Level_09_Upload_Files extends BaseTest {
	WebDriver driver;
	UploadFileHomePageObject uploadFileHomePage;
	String file1 = "picture1.jpg";
	String file2 = "picture2.jpg";
	String file3 = "picture3.jpg";

	String fileNames[] = { file1, file2, file3 };

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.JQUERY_UPLOAD_FILE_URL);
		uploadFileHomePage = PageGeneratorManager.getUploadFileHomePage(driver);

	}

	@Test
	public void TC_01_Upload_One_File_Per_Time() {
		uploadFileHomePage.uploadMultipleFiles(file1);
		Assert.assertTrue(uploadFileHomePage.isFileLoadedByName(file1));
		uploadFileHomePage.uploadFileByStartButton();
		Assert.assertTrue(uploadFileHomePage.isUploadedLinkDisplayedByName(file1));
		Assert.assertTrue(uploadFileHomePage.isImageUploadedByName(file1));
		BasePage.sleepInSecond(3);
	}
	@Test
	public void TC_02_Upload_Multiple_File_Per_Time() {
		uploadFileHomePage.refreshCurrentPage(driver);
		uploadFileHomePage.uploadMultipleFiles(fileNames);
		Assert.assertTrue(uploadFileHomePage.isFileLoadedByName(file1));
		Assert.assertTrue(uploadFileHomePage.isFileLoadedByName(file2));
		Assert.assertTrue(uploadFileHomePage.isFileLoadedByName(file3));
		
		uploadFileHomePage.uploadFileByStartButton();
		
		Assert.assertTrue(uploadFileHomePage.isUploadedLinkDisplayedByName(file1));
		Assert.assertTrue(uploadFileHomePage.isUploadedLinkDisplayedByName(file2));
		Assert.assertTrue(uploadFileHomePage.isUploadedLinkDisplayedByName(file3));
		
		Assert.assertTrue(uploadFileHomePage.isImageUploadedByName(file1));
		Assert.assertTrue(uploadFileHomePage.isImageUploadedByName(file2));
		Assert.assertTrue(uploadFileHomePage.isImageUploadedByName(file3));
		BasePage.sleepInSecond(3);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
