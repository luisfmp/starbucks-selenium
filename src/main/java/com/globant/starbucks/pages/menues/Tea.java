package com.globant.starbucks.pages.menues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.globant.starbucks.pages.MenuEntry;

public class Tea extends MenuEntry{
	
	private String filtersTogglePattern = ".desktopview .swatchRefineLink[title='%s']";

	public Tea(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Activa o desactiva un filtro haciendo click sobre el.
	 */
	/**
	 * @param title El nombre del filtro como aparece en la pagina Ej. "Tea Bags"
	 */
	public void toggleFilterByTitle(String title){
		By filterLocator = By.cssSelector(String.format(filtersTogglePattern, title));
		getDriver().findElement(filterLocator).click();
	}

}
