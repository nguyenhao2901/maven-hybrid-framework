package pageObjects.facebook;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);

	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	public boolean isConfirmEmailTextboxDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void clickToCloseSignUpButton() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_SIGNUP_BUTTON);
		clickToElement(driver, LoginPageUI.CLOSE_SIGNUP_BUTTON);

	}

	public boolean isConfirmEmailTextboxUndisplayed() {
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);

	}
}
