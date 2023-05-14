package pageObjectTechpandaAndJquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import techpandaAndJqueryPageUIs.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
	private WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
		return getTextElement(driver, MyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public void clickAccountLink() {
		waitForElementVisible(driver, MyDashboardPageUI.ACCOUNT_LINK_HEADER);
		clickToElement(driver, MyDashboardPageUI.ACCOUNT_LINK_HEADER);

	}

	public HomePageObject clickLogoutLink() {
		waitForElementVisible(driver, MyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_LINK);
		return new HomePageObject(driver);
	}

	public boolean isWellcomMessageContainText(String textValue) {
		waitForElementVisible(driver, MyDashboardPageUI.WELLCOM_MESSAGE);
		return getTextElement(driver, MyDashboardPageUI.WELLCOM_MESSAGE).contains(textValue);

	}

}
