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
	
	private String imagePaginationPattern = ".owl-pagination > .owl-page";
	
	private By nextImageLocator = By.cssSelector(".owl-next");

	public QuickViewCard(WebElement rootElement) {
		this.rootElement = rootElement;
	}

	public int getNumberOfImages(){
		return rootElement.findElements(By.cssSelector(imagePaginationPattern)).size();
	}
	
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
