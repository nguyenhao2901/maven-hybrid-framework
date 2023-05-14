package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminLoginPUI;

public class AdminLoginPO extends BasePage {
	WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserNameTextbox(String adminUserName) {
		waitForElementVisible(driver, AdminLoginPUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPUI.USERNAME_TEXTBOX, adminUserName);

	}

	public void enterToPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPUI.PASSWORD_TEXTBOX, adminPassword);

	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPUI.LOGIN_BUTTON);

	}

	public AdminDashboardPO loginAsAdmin(WebDriver driver, String user, String pass) {
		enterToUserNameTextbox(user);
		enterToPasswordTextbox(pass);
		clickToLoginButton();
		return new AdminDashboardPO(driver);
	}

}
