/**
 *
 */
package com.globant.starbucks.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author lu.martinez
 *
 */
public class QuickViewCard {

	private WebElement rootElement;

	private static final String imagePaginationPattern = ".owl-pagination > .owl-page";

	private static final By nextImageLocator = By.cssSelector(".owl-next");

	public QuickViewCard(WebElement rootElement) {
		this.rootElement = rootElement;
	}

	/**
	 * @return El numero de imagenes que contiene la vista rapida del producto
	 */
	public int getNumberOfImages(){
		return rootElement.findElements(By.cssSelector(imagePaginationPattern)).size();
	}

	/**
	 * Navega por el carrusel de imagenes del detalle del producto
	 */
	public void viewAllImages(){
		int images = getNumberOfImages();
		for (int i = 1; i < images; i++){
			rootElement.findElement(nextImageLocator).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
