package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObjectFactory extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObjectFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "FirstName")
	WebElement firstNameTextbox;
	@FindBy(id = "LastName")
	WebElement lastNameTextbox;
	@FindBy(id = "Email")
	WebElement emailTextbox;
	@FindBy(id = "Password")
	WebElement passwordTextbox;
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTextbox;
	@FindBy(id = "register-button")
	WebElement registerButton;
	@FindBy(id = "FirstName-error")
	WebElement firstNameErrorMessage;
	@FindBy(id = "LastName-error")
	WebElement lastNameErrorMessage;
	@FindBy(id = "Email-error")
	WebElement emailErrorMessage;
	@FindBy(id = "Password-error")
	WebElement passwordErrorMessage;
	@FindBy(id = "ConfirmPassword-error")
	WebElement confirmPasswordErrorMessage;
	@FindBy(xpath = "//div[@class='result']")
	WebElement registerSuccessMessage;
	@FindBy(xpath = "//div[contains(@class,'message-error')]//li")
	WebElement existEmailErrorMessage;
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutLink;

	public void clickToRegisterButton() {
		waitForElementVisible(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public void inputToFirstnameTextbox(String firstname) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstname);

	}

	public void inputToLastnameTextbox(String lastname) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastname);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public String getFirstnameErrorMessage() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getTextElement(driver, firstNameErrorMessage);
	}

	public String getLastnameErrorMessage() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getTextElement(driver, lastNameErrorMessage);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, emailErrorMessage);
		return getTextElement(driver, emailErrorMessage);
	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getTextElement(driver, passwordErrorMessage);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getTextElement(driver, confirmPasswordErrorMessage);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getTextElement(driver, registerSuccessMessage);
	}

	public String getExistEmailErrorMessage() {
		waitForElementVisible(driver, existEmailErrorMessage);
		return getTextElement(driver, existEmailErrorMessage);
	}

	public void clickToLogoutLink() {
		waitForElementVisible(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}

}
