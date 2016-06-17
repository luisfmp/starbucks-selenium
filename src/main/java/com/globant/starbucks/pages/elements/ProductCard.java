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
	private static final By productRateLocator = By
			.cssSelector(".product_info > .product_rating > .ratingstars");
	private static final By productNameLocator = By
			.cssSelector(".product_info > .name > .product_name");
	private static final By quickViewLocator = By
			.cssSelector("a.btn-quickview");
	private static final By paginationCssLocator = By.cssSelector(".owl-page");
	private static final By addToBagLocator = By.cssSelector("a.add2bag");
	private static final String lazyParentPattern = "ancestor::div[@class='lazyloaded']";
	private static final String qvDrawerSiblingPattern = "following-sibling::div[@class='product_qv_drawer']";

	public ProductCard(WebElement rootElement, WebDriver driver) {
		this.rootElement = rootElement;
		this.driver = driver;
	}

	public String getProductName() {
		WebElement productName = rootElement.findElement(productNameLocator);
		return productName.getText();
	}

	public String getProductRating() {
		WebElement productRating = rootElement.findElement(productRateLocator);
		return productRating.getAttribute("data-rating");
	}

	/**
	 * Muestra los detalles del producto en la tarjeta de vista rapida
	 * @return Objeto de tipo QuickViewCard con referencia a la tarjeta de datos del producto
	 */
	public QuickViewCard clickOnQuickview() {
		WebElement quickViewLink = rootElement.findElement(quickViewLocator);
		quickViewLink.click();
		WebElement lazyLoadedParent = rootElement.findElement(By
				.xpath(lazyParentPattern));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOfElementLocated(paginationCssLocator));
		WebElement quickViewCardRoot = lazyLoadedParent.findElement(By
				.xpath(qvDrawerSiblingPattern));
		return new QuickViewCard(quickViewCardRoot);
	}

	/**
	 * Agrega el producto seleccionado al carrito de compras
	 */
	public void addToBag() {
		rootElement.findElement(addToBagLocator).click();
		// Se agrega una pausa por la animacion que realiza siempre el agregar
		// un elemento a la bolsa
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
