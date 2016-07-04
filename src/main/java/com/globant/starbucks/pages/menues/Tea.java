package com.globant.starbucks.pages.menues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.globant.starbucks.pages.MenuEntry;

public class Tea extends MenuEntry{

	private static final String xpathToggleFilter = "//div[contains(@class,'desktopview')]//a[@title='%s']";

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
		By filterLocator = By.xpath(String.format(xpathToggleFilter, title));
		waitForElementVisible(filterLocator).click();
	}

}
