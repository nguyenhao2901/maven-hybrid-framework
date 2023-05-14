package techpandaAndJqueryPageUIs;

public class AdminHomePageUI {
	public static final String CLOSE_ICON_AT_POPUP = "xpath=//div[@id='message-popup-window']//span[text()='close']";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//table[@id='customerGrid_table']//span[text()='%s']/ancestor::th/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_NAME = "xpath=//thead//tr//input[@name='%s']";
	public static final String CUSTOMER_RECORD_BY_EMAIL_AND_FULLNAME = "xpath=//tbody/tr//td[contains(text(),'%s')]/preceding-sibling::td[contains(text(),'%s')]";

}
