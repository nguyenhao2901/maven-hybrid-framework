package pageUIs.wordpress.admin;

public class AdminPostSearchPUI {
public static final String ADD_NEW_BUTTON = "xpath=//div[@id='wpbody-content']//a[text()='Add New']";
public static final String SEARCH_TEXTBOX = "xpath=//input[@id='post-search-input']";
public static final String SEARCH_BUTTON = "xpath=//input[@id='search-submit']";
public static final String COLLUNM_INDEX_BY_ID = "xpath=//thead//th[@id='%s']//preceding-sibling::th";
public static final String POST_INFO_BY_COL_INDEX_AND_INFO_VALUE = "xpath=//tbody[@id='the-list']//td[%s]//a[text()='%s']";
public static final String POST_TITLE_LINK = "xpath=//table//tbody//a[@class='row-title']";
public static final String TRASH_LINK = "xpath=//tbody//div[@class='row-actions']//a[text()='Trash']";
public static final String POST_MOVED_MESSAGE = "xpath=//div[@class='updated notice is-dismissible']/p[contains(text(),'%s')]";
}
