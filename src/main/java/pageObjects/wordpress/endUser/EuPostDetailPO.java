package pageObjects.wordpress.endUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.endUser.EuPostDetailPageUI;

public class EuPostDetailPO extends BasePage {
	WebDriver driver;
	public EuPostDetailPO (WebDriver driver) {
		this.driver = driver;
	}
	public boolean isPostTitleDisplay(String postTitle) {
		waitForElementVisible(driver, EuPostDetailPageUI.POST_TITLE, postTitle);
		return isElementDisplayed(driver, EuPostDetailPageUI.POST_TITLE, postTitle);
	}
	public boolean isPostBodyDisplay(String postBody) {
		waitForElementVisible(driver, EuPostDetailPageUI.POST_BODY, postBody);
		return isElementDisplayed(driver, EuPostDetailPageUI.POST_BODY, postBody);
	}
	public boolean isPostAuthorDisplay(String adminUserName) {
		waitForElementVisible(driver, EuPostDetailPageUI.AUTHOR_NAME, adminUserName);
		return isElementDisplayed(driver, EuPostDetailPageUI.AUTHOR_NAME, adminUserName);
	}
	public boolean isPostDateDisplay(String currentDate) {
		waitForElementVisible(driver, EuPostDetailPageUI.POSTED_DATE, currentDate);
		return isElementDisplayed(driver, EuPostDetailPageUI.POSTED_DATE, currentDate);
	}

}
