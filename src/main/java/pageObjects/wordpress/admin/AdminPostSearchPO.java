package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostSearchPUI;

public class AdminPostSearchPO extends BasePage {
	WebDriver driver;

	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewOrUpdatePO clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPUI.ADD_NEW_BUTTON);
		return new AdminPostAddNewOrUpdatePO(driver);
	}

	public void enterToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchPUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminPostSearchPUI.SEARCH_TEXTBOX, postTitle);

	}

	public void clickToSearchPostButton() {
		waitForElementClickable(driver, AdminPostSearchPUI.SEARCH_BUTTON);
		clickToElement(driver, AdminPostSearchPUI.SEARCH_BUTTON);

	}

	public boolean isPostInfoDisplayByIdAndInfoValue(String id, String infoValue) {
		int col_Index = getListWebElement(driver, AdminPostSearchPUI.COLLUNM_INDEX_BY_ID, id).size() + 1;
		waitForElementVisible(driver, AdminPostSearchPUI.POST_INFO_BY_COL_INDEX_AND_INFO_VALUE,
				String.valueOf(col_Index), infoValue);
		return isElementDisplayed(driver, AdminPostSearchPUI.POST_INFO_BY_COL_INDEX_AND_INFO_VALUE,
				String.valueOf(col_Index), infoValue);
	}

	public AdminPostAddNewOrUpdatePO clickToPostTitle() {
		waitForElementClickable(driver, AdminPostSearchPUI.POST_TITLE_LINK);
		clickToElement(driver, AdminPostSearchPUI.POST_TITLE_LINK);
		return new AdminPostAddNewOrUpdatePO(driver);
	}

	public void clickToTrashLink() {
		hoverMouseToElement(driver, AdminPostSearchPUI.POST_TITLE_LINK);
		waitForElementClickable(driver, AdminPostSearchPUI.TRASH_LINK);
		clickToElement(driver, AdminPostSearchPUI.TRASH_LINK);
	}

	public boolean isPostMovedMessageDisplay(String message) {
		waitForElementVisible(driver, AdminPostSearchPUI.POST_MOVED_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPUI.POST_MOVED_MESSAGE, message);
	}

}
