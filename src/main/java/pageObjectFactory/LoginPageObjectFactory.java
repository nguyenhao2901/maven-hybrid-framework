package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObjectFactory extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObjectFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	WebElement emailTextbox;
	@FindBy(id = "Password")
	WebElement passwordTextbox;
	@FindBy(id = "Email-error")
	WebElement emailErrorMessage;
	@FindBy(xpath = "//div[contains(@class,'message-error')]")
	WebElement unsuccessErrorMessage;
	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	WebElement loginButton;

	public void clickToLoginButton() {
		waitForElementVisible(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, emailErrorMessage);
		return getTextElement(driver, emailErrorMessage);
	}

	public String getUnsuccessfulErrorMessage() {
		waitForElementVisible(driver, unsuccessErrorMessage);
		return getTextElement(driver, unsuccessErrorMessage);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

}
