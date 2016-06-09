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
public class Equipment extends MenuEntry {

	private String typeFilterSelectorPattern = ".desktopview .swatchRefineLink[title='%s']";

	public Equipment(WebDriver driver) {
		super(driver);
	}

	public void setTypeFilter(String option) {
		By typeFilterCssSelector = By.cssSelector(String.format(typeFilterSelectorPattern, option));
		WebElement typeFilterElement = getDriver().findElement(typeFilterCssSelector);
		typeFilterElement.click();
	}

	

}