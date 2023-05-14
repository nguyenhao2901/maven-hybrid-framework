package pageObjectTechpandaAndJquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import techpandaAndJqueryPageUIs.JqueryPageUI;

public class jqueryPageObject extends BasePage {
	private WebDriver driver;

	public jqueryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void pagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, JqueryPageUI.PAGING_BY_PAGE_NUMBER, pageNumber);
		clickToElement(driver, JqueryPageUI.PAGING_BY_PAGE_NUMBER, pageNumber);

	}

	public void enterToTextboxByCloumnName(String columnName, String valueToEnter) {
		waitForElementVisible(driver, JqueryPageUI.TEXTBOX_BY_COLUMN_NAME, columnName);
		sendkeyToElement(driver, JqueryPageUI.TEXTBOX_BY_COLUMN_NAME, valueToEnter, columnName);
		pressEnter(driver);
		
	}

}
