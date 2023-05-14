package pageObjectTechpandaAndJquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import techpandaAndJqueryPageUIs.AdminHomePageUI;
import techpandaAndJqueryPageUIs.HomePageUI;

public class AdminHomePageObject extends BasePage {
	private WebDriver driver;

	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopUp() {
		waitForElementClickable(driver, AdminHomePageUI.CLOSE_ICON_AT_POPUP);
		clickToElement(driver, AdminHomePageUI.CLOSE_ICON_AT_POPUP);
	}

	public void enterToTextboxByColumnName(String columnName, String valueToEnter) {
		// int colNumber = getElementSize(driver,
		// AdminHomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		sendkeyToElement(driver, AdminHomePageUI.TEXTBOX_BY_COLUMN_NAME, valueToEnter, columnName);
		pressEnter(driver);

	}

	public boolean isCustomerDisplayed(String emailAddress, String customerFullName) {
		return isElementDisplayed(driver, AdminHomePageUI.CUSTOMER_RECORD_BY_EMAIL_AND_FULLNAME, emailAddress,
				customerFullName);
	}

}
