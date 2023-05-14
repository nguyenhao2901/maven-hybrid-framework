package pageObjectTechpandaAndJquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import techpandaAndJqueryPageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAccountLinkHeader() {
		waitForElementVisible(driver, HomePageUI.ACCOUNT_LINK_HEADER);
		clickToElement(driver, HomePageUI.ACCOUNT_LINK_HEADER);
	}

	public LoginPageObject clickToMyAccountLinkHeader() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK_HEADER);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK_HEADER);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return new LoginPageObject(driver);

	}

}
