package pageObjectTechpandaAndJquery;

import org.openqa.selenium.WebDriver;



public class PageGeneratorManager {
	private WebDriver driver;

	public PageGeneratorManager(WebDriver driver) {
		this.driver = driver;
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
		
	}
	public static AdminHomePageObject getAdminHomePage(WebDriver driver) {
		return new AdminHomePageObject(driver);
		
	}
	

} 
