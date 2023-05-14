package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import pageObjects.wordpress.endUser.EuHomePO;
import pageObjects.wordpress.endUser.EuPostDetailPO;

public class PageGeneratorManager {
	WebDriver driver;

	public PageGeneratorManager(WebDriver driver) {
		this.driver = driver;
	}

	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);

	}
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
		
	}

	public static AdminPostAddNewOrUpdatePO getAdminPostAddNewPage(WebDriver driver) {
		return new AdminPostAddNewOrUpdatePO(driver);

	}

	public static AdminPostCategoryPO getAdminPostCategoryPage(WebDriver driver) {
		return new AdminPostCategoryPO(driver);

	}

	public static AdminPostSearchPO getAdminPostSearchPage(WebDriver driver) {
		return new AdminPostSearchPO(driver);

	}

	public static AdminPostTagPO getAdminPostTagPage(WebDriver driver) {
		return new AdminPostTagPO(driver);

	}
	public static EuHomePO getEuHomePage(WebDriver driver) {
		return new EuHomePO(driver);
		
	}
	public static EuPostDetailPO getEuPostDetailPage(WebDriver driver) {
		return new EuPostDetailPO(driver);
		
	}

}
