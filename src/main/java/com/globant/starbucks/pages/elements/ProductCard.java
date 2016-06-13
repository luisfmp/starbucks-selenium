/**
 * 
 */
package com.globant.starbucks.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstraccion de las tarjetas de producto para una mejor manipulacion
 * 
 * @author lu.martinez
 *
 */
public class ProductCard {

	private WebElement rootElement;
	private WebDriver driver;
	private String lazyParentPattern = "ancestor::div[@class='lazyloaded']";
	private String qvDrawerSiblingPattern = "following-sibling::div[@class='product_qv_drawer']";
	private By paginationCssLocator = By.cssSelector(".owl-page");
	private By addToBagLocator = By.cssSelector("a.add2bag");

	public ProductCard(WebElement rootElement, WebDriver driver) {
		this.rootElement = rootElement;
		this.driver = driver;
	}

	public String getProductName() {
		WebElement productName = rootElement.findElement(By.cssSelector(".product_info > .name > .product_name"));
		return productName.getText();
	}

	public String getProductRating() {
		WebElement productRating = rootElement
				.findElement(By.cssSelector(".product_info > .product_rating > .ratingstars"));
		return productRating.getAttribute("data-rating");
	}

	public QuickViewCard clickOnQuickview() {
		WebElement quickViewLink = rootElement.findElement(By.cssSelector("a.btn-quickview"));
		quickViewLink.click();
		WebElement lazyLoadedParent = rootElement.findElement(By.xpath(lazyParentPattern));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(paginationCssLocator));
		WebElement quickViewCardRoot = lazyLoadedParent.findElement(By.xpath(qvDrawerSiblingPattern));
		return new QuickViewCard(quickViewCardRoot);
	}

	public void addToBag() {
		rootElement.findElement(addToBagLocator).click();
		//Se agrega una pausa por la animacion que realiza siempre el agregar un elemento a la bolsa
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
