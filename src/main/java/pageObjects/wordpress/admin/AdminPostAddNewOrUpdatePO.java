package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostAddNewOrUpdatePUI;

public class AdminPostAddNewOrUpdatePO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewOrUpdatePO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostAddNewOrUpdatePUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewOrUpdatePUI.TITLE_TEXTBOX, postTitle);
		
	}

	public void enterToPostBody(String postBody) {
		waitForElementClickable(driver, AdminPostAddNewOrUpdatePUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewOrUpdatePUI.BODY_BUTTON);
		sendkeyToElement(driver, AdminPostAddNewOrUpdatePUI.BODY_TEXTBOX, postBody);
		
	}
	public void editToPostBody(String editPostBody) {
		waitForElementClickable(driver, AdminPostAddNewOrUpdatePUI.BODY_TEXTBOX);
		clickToElement(driver, AdminPostAddNewOrUpdatePUI.BODY_TEXTBOX);
		clearDataInElementByPressKey(driver, AdminPostAddNewOrUpdatePUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewOrUpdatePUI.BODY_TEXTBOX, editPostBody);
		
	}

	public void clickToPrePublishButton() {
		waitForElementClickable(driver, AdminPostAddNewOrUpdatePUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewOrUpdatePUI.PRE_PUBLISH_BUTTON);
		
	}

	public void clickToPublishOrUpdateButton() {
		waitForElementClickable(driver, AdminPostAddNewOrUpdatePUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElementByJS(driver, AdminPostAddNewOrUpdatePUI.PUBLISH_OR_UPDATE_BUTTON);
		
	}

	public boolean isPostPublishOrUpdateMessageDisplay(String message) {
		waitForElementVisible(driver, AdminPostAddNewOrUpdatePUI.POST_PUBLISHED_MESSAGE);
		return getTextElement(driver, AdminPostAddNewOrUpdatePUI.POST_PUBLISHED_MESSAGE).contains(message);
	}

}
