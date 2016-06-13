/**
 * 
 */
package com.globant.starbucks.pages.menues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.globant.starbucks.pages.MenuEntry;

/**
 * @author lu.martinez
 *
 */
public class GiftsAndMore extends MenuEntry {

	private String priceFilterSelectorPattern = ".refinement-link[title='%s']";

	public GiftsAndMore(WebDriver driver) {
		super(driver);
	}

	/**
	 * Activa o desactiva el filtro por precio
	 */
	/**
	 * @param option
	 *            El texto del filtro a des/activar Ej. "Under $25"
	 */
	public void togglePriceFilter(String option) {
		By priceFilterLocator = By.cssSelector(String.format(priceFilterSelectorPattern, option));
		WebElement priceFilterElement = getDriver().findElement(priceFilterLocator);
		priceFilterElement.click();
	}

}
