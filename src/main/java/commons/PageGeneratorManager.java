package commons;

import org.openqa.selenium.WebDriver;

import pageObjectTechpandaAndJquery.UploadFileHomePageObject;
import pageObjectTechpandaAndJquery.jqueryDynamicDataGridPageObject;
import pageObjectTechpandaAndJquery.jqueryPageObject;
import pageObjects.nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserRewardPointsPageObject;

public class PageGeneratorManager {
	private WebDriver driver;

	public PageGeneratorManager(WebDriver driver) {
		this.driver = driver;
	}

	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserLoginPageObject getLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserCustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {

		return new UserCustomerInfoPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);

	}

	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);

	}
	public static UserAddressPageObject getAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
		
	}
	public static UserRewardPointsPageObject getRewardPointsPage(WebDriver driver) {
		return new UserRewardPointsPageObject(driver);
		
	}
	public static UserMyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
		
	}
	public static pageObjectTechpandaAndJquery.AdminLoginPageObject getAdminLoginPageTechPanda(WebDriver driver) {
		return new pageObjectTechpandaAndJquery.AdminLoginPageObject(driver);
		
	}
	public static jqueryPageObject getJqueryPage(WebDriver driver) {
		return new jqueryPageObject(driver);
		
	}
	public static jqueryDynamicDataGridPageObject getJqueryDynamicDataGridPage(WebDriver driver) {
		return new jqueryDynamicDataGridPageObject(driver);
		
	}
	public static UploadFileHomePageObject getUploadFileHomePage(WebDriver driver) {
		return new UploadFileHomePageObject(driver);
		
	}

	
}
