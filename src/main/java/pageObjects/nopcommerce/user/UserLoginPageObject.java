package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
		return new UserHomePageObject(driver);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver,LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	public String getUnsuccessfulErrorMessage() {
		waitForElementVisible(driver,LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
		return getTextElement(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
	}


	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver,LoginPageUI.EMAIL_TEXTBOX);	
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);	
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		clickToLoginButton();
		return new UserHomePageObject(driver);
	}
	public void clickCloseSuccessLoginNotify() {
		waitForElementClickable(driver, LoginPageUI.ICON_CLOSE_SUCCESS_LOGIN_NOTIFY);
		clickToElement(driver, LoginPageUI.ICON_CLOSE_SUCCESS_LOGIN_NOTIFY);
	}

	
	

}
