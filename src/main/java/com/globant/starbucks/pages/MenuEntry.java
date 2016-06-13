/**
 * 
 */
package com.globant.starbucks.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.globant.starbucks.pages.elements.ProductCard;

/**
 * @author lu.martinez
 *
 */
public class MenuEntry extends HeaderAndFooter {

	@FindBy(css = ".bannercontent.container > h1")
	private static WebElement title;

	@FindBy(css = ".desktopview #sortrule")
	private static WebElement sortSelect;

	private static final By resultAreaLocator = By.cssSelector("div.productresultarea");
	private static final By productCardLocator = By.cssSelector("div.product_card");

	private static final String productNameSelectorPattern = ".product_name[title='%s']";
	private static final String productCardParentPattern = "ancestor::div[@class='product_card']";

	public MenuEntry(WebDriver driver) {
		super(driver);
	}

	public String getTitle() {
		return title.getText();
	}

	public ProductCard findProductInListByName(String name) {
		By productNameCssSelector = By.cssSelector(String.format(productNameSelectorPattern, name));
		WebElement product = null;
		ProductCard productCard = null;
		int scrolls = 1;
		while (product == null && scrolls < 20) {
			scrollDown();
			scrolls++;
			try {
				product = waitForElementVisible(productNameCssSelector, 3);
			} catch (TimeoutException te) {
				product = null;
			}
		}
		if (product != null) {
			productCard = new ProductCard(product.findElement(By.xpath(productCardParentPattern)), getDriver());
		}
		return productCard;
	}

	public ProductCard findProductByResultsPosition(int position) {
		WebElement rootElement = null;
		List<WebElement> productList = getDriver().findElement(resultAreaLocator).findElements(productCardLocator);
		if (productList.size() >= position) {
			rootElement = productList.get(position);
			return new ProductCard(rootElement, getDriver());
		} else {
			return null;
		}
	}

	public ProductCard findFirstProductInList() {
		return findProductByResultsPosition(0);
	}

	public ProductCard findLastProductInList() {
		List<WebElement> productList = getDriver().findElement(resultAreaLocator).findElements(productCardLocator);
		int last = productList.size() - 1;
		return new ProductCard(productList.get(last), getDriver());
	}

	public void sortByVisibleText(String option) {
		Select sort = new Select(sortSelect);
		sort.selectByVisibleText(option);
		waitForElementVisible(resultAreaLocator);
	}
}
