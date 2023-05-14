package pageObjects.saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucelab.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToProductSortDropdown() {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_SORT_DROPDOWN);
		clickToElement(driver, ProductPageUI.PRODUCT_SORT_DROPDOWN);

	}

	public void selectSortOptionByOptionText(String itemText) {
		selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_SORT_DROPDOWN, itemText);

	}

	public boolean isNameSortASC() {
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);
		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> nameSort = new ArrayList<>();

		for (WebElement element : elements) {
			String productName = element.getText();
			names.add(productName);
			nameSort.add(productName);
		}

		Collections.sort(nameSort);
		return nameSort.equals(names);
	}

	public boolean isNameSortDESC() {
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);
		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> nameSort = new ArrayList<>();

		for (WebElement element : elements) {
			String productName = element.getText();
			names.add(productName);
			nameSort.add(productName);
		}

		Collections.sort(nameSort);
		Collections.reverse(nameSort);
		return nameSort.equals(names);
	}

	public boolean isPriceSortASC() {
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);
		ArrayList<Float> prices = new ArrayList<>();
		ArrayList<Float> priceSort = new ArrayList<>();

		for (WebElement element : elements) {
			String price = element.getText().replace("$", "");
			Float priceInFloat = Float.parseFloat(price);
			prices.add(priceInFloat);
			priceSort.add(priceInFloat);
		}

		Collections.sort(priceSort);
		return priceSort.equals(prices);

	}

	public boolean isPriceSortDESC() {
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);
		ArrayList<Float> prices = new ArrayList<>();
		ArrayList<Float> priceSort = new ArrayList<>();

		for (WebElement element : elements) {
			String price = element.getText().replace("$", "");
			Float priceInFloat = Float.parseFloat(price);
			prices.add(priceInFloat);
			priceSort.add(priceInFloat);
		}

		Collections.sort(priceSort);
		Collections.reverse(priceSort);
		return priceSort.equals(prices);
	}

}
