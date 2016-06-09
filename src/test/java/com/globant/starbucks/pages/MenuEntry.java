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

import com.globant.starbucks.pages.elements.ProductCard;

/**
 * @author lu.martinez
 *
 */
public class MenuEntry extends HeaderAndFooter {

	@FindBy(css = ".bannercontent.container > h1")
	private WebElement title;

	@FindBy(id = "sortrule")
	private WebElement sortSelect;

	By resultAreaLocator = By.cssSelector("div.productresultarea");
	By productCardLocator = By.cssSelector("div.product_card");

	private String productNameSelectorPattern = ".product_name[title='%s']";
	private String productCardParentPattern = "ancestor::div[@class='product_card']";

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
}
