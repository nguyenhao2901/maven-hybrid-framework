package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminDashboardPUI;

public class AdminDashboardPO extends BasePage {
	WebDriver driver;
	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isAccountNameDisplay(String accountName) {
		waitForElementVisible(driver, AdminDashboardPUI.ACCOUNT_NAME);
		return getTextElement(driver, AdminDashboardPUI.ACCOUNT_NAME).equals(accountName);
	}
	public AdminPostSearchPO clickToPostMenuLink() {
		waitForElementClickable(driver, AdminDashboardPUI.POST_MENU_LINK);
		clickToElement(driver, AdminDashboardPUI.POST_MENU_LINK);
		return new AdminPostSearchPO(driver);
	}


}
