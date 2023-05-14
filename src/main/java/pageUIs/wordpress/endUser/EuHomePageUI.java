package pageUIs.wordpress.endUser;

public class EuHomePageUI {
	public static final String SEARCH_TEXTBOX = "css=input.wp-block-search__input";
	public static final String SEARCH_BUTTON = "css=button.wp-block-search__button";
	public static final String POST_TITLE_IN_SEARCH_RESULT = "xpath=//article//h2/a";
	public static final String POST_BODY_IN_SEARCH_RESULT = "xpath=//div[@class='entry-summary']/p[text()='%s']";
	public static final String POSTED_DATE_IN_SEARCH_RESULT = "xpath=//span[@class='posted-on']//time[@class='entry-date published' and text()='%s']";
	public static final String AUTHOR_NAME_IN_SEARCH_RESULT = "xpath=//span[@class='author vcard']/a[text()='%s']";
	public static final String NOTHING_FOUND_MESSAGE = "xpath=//section[@class='no-results not-found']//h1[text()='%s']";

}
