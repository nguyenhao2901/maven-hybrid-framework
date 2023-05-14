package pageObjects.nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageUIs.nopcommerce.user.LoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver,LoginPageUI.EMAIL_TEXTBOX);	
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);	
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
		return new UserHomePageObject(driver);
	}
	public AdminDashboardPageObject loginAsAdmin(String emailAddress, String password) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		clickToLoginButton();
		return new AdminDashboardPageObject(driver);
	}
	
}
