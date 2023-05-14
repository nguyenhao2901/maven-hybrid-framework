package pageObjectTechpandaAndJquery;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.GlobalConstants;
import techpandaAndJqueryPageUIs.UploadFileHomePageUI;

public class UploadFileHomePageObject extends BasePage {
	private WebDriver driver;

	public UploadFileHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void uploadMultipleFiles(String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FILE_PATH;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + File.separator + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, UploadFileHomePageUI.UPLOAD_FILE).sendKeys(fullFileName);

	}

	public boolean isFileLoadedByName(String fileName) {
		return isElementDisplayed(driver, UploadFileHomePageUI.LOADED_FILE_BY_NAME, fileName);
	}

	public void uploadFileByStartButton() {

		List<WebElement> startButtons = getListWebElement(driver, UploadFileHomePageUI.START_BUTTONS);
		for (WebElement startButton : startButtons) {
			waitForElementClickable(driver, startButton);
			startButton.click();
			sleepInSecond(2);
		}

	}

	public boolean isUploadedLinkDisplayedByName(String fileName) {
		waitForElementVisible(driver, UploadFileHomePageUI.UPLOADED_LINK_BY_NAME, fileName);
		return isElementDisplayed(driver, UploadFileHomePageUI.UPLOADED_LINK_BY_NAME, fileName);
	}

	public boolean isImageUploadedByName(String fileName) {
		waitForElementVisible(driver, UploadFileHomePageUI.IMAGE_UPLOADED_BY_NAME, fileName);
		return isImageLoaded(driver, UploadFileHomePageUI.IMAGE_UPLOADED_BY_NAME, fileName);
	}

}
