package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObjectFactory extends BasePageFactory {
	private WebDriver driver;

	public HomePageObjectFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement registerLink;
	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement loginLink;
	@FindBy(xpath = "//a[@class='ico-account']")
	WebElement myAccountLink;

	public void clickToRegisterLink() {
		waitForElementVisible(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitForElementVisible(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}

}
