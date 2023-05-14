package pageObjects.wordpress.endUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.endUser.EuHomePageUI;

public class EuHomePO extends BasePage {
	WebDriver driver;

	public EuHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, EuHomePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, EuHomePageUI.SEARCH_TEXTBOX, postTitle);

	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, EuHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, EuHomePageUI.SEARCH_BUTTON);
		sleepInSecond(5);

	}

	public boolean isPostTitleDisplay(String postTitle) {
		waitForElementVisible(driver, EuHomePageUI.POST_TITLE_IN_SEARCH_RESULT, postTitle);
		boolean status = getTextElement(driver, EuHomePageUI.POST_TITLE_IN_SEARCH_RESULT, postTitle).equals(postTitle);
		return status;
	}

	public boolean isPostBodyDisplay(String postBody) {
		waitForElementVisible(driver, EuHomePageUI.POST_BODY_IN_SEARCH_RESULT, postBody);
		return isElementDisplayed(driver, EuHomePageUI.POST_BODY_IN_SEARCH_RESULT, postBody);
	}

	public boolean isPostAuthorDisplay(String adminUserName) {
		waitForElementVisible(driver, EuHomePageUI.AUTHOR_NAME_IN_SEARCH_RESULT, adminUserName);
		return isElementDisplayed(driver, EuHomePageUI.AUTHOR_NAME_IN_SEARCH_RESULT, adminUserName);
	}

	public EuPostDetailPO clickToPostTitle() {
		waitForElementClickable(driver, EuHomePageUI.POST_TITLE_IN_SEARCH_RESULT);
		clickToElement(driver, EuHomePageUI.POST_TITLE_IN_SEARCH_RESULT);
		return new EuPostDetailPO(driver);
	}

	public boolean isPostDateDisplay(String currentDate) {
		waitForElementVisible(driver, EuHomePageUI.POSTED_DATE_IN_SEARCH_RESULT, currentDate);
		return isElementDisplayed(driver, EuHomePageUI.POSTED_DATE_IN_SEARCH_RESULT, currentDate);
	}

	public boolean isNothingFoundMessageDisplay(String message) {
		waitForElementVisible(driver, EuHomePageUI.NOTHING_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, EuHomePageUI.NOTHING_FOUND_MESSAGE, message);

	}

}
