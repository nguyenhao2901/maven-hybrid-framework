package pageObjectTechpandaAndJquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import techpandaAndJqueryPageUIs.JqueryDynamicDataGridPageUI;
import techpandaAndJqueryPageUIs.JqueryPageUI;

public class jqueryDynamicDataGridPageObject extends BasePage {
	private WebDriver driver;

	public jqueryDynamicDataGridPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToTextboxByRowIndexAndColunmName(String rowIndex, String colunmName, String textToEnter) {
		int colunmIndex = getElementSize(driver, JqueryDynamicDataGridPageUI.COLUNM_INDEX_BY_COLUNM_NAME, colunmName)
				+ 1;
		waitForElementVisible(driver, JqueryDynamicDataGridPageUI.TEXTBOX_BY_ROW_INDEX_AND_COLUNM_INDEX, rowIndex,
				String.valueOf(colunmIndex));
		sendkeyToElement(driver, JqueryDynamicDataGridPageUI.TEXTBOX_BY_ROW_INDEX_AND_COLUNM_INDEX, textToEnter,
				rowIndex, String.valueOf(colunmIndex));

	}

	public void selectCountryAtRowIndexAndCountryName(String rowIndex, String countryName) {
		waitForElementClickable(driver, JqueryDynamicDataGridPageUI.DROPDOWN_BY_ROW_INDEX_AND_COLUNM_NAME, rowIndex);
		selectItemInDefaultDropdown(driver, JqueryDynamicDataGridPageUI.DROPDOWN_BY_ROW_INDEX_AND_COLUNM_NAME,
				countryName, rowIndex);

	}

}
