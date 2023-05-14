package pageUIs.nopcommerce.user;

public class BasePageUI {
	public static final String CUSTOMER_INFO_LINK = "xpath=//a[text()='Customer info']";
	public static final String ADDRESS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String REWARD_POINTS_LINK = "xpath=//a[text()='Reward points']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//a[text()='My product reviews']";
	public static final String LOGOUT_LINK_AT_USER = "class=ico-logout";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static final String DYNAMIC_LINK_AT_MYACCOUNT = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
}
