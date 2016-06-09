/**
 * 
 */
package com.globant.starbucks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author lu.martinez
 *
 */
public class MyBag extends HeaderAndFooter {

	@FindBy(css = ".ordertot > .value")
	private WebElement estimatedTotalValue;

	public MyBag(WebDriver driver) {
		super(driver);
	}

	/**
	 * @return The estimated total with dollar symbol ej. $83.07
	 */
	public String getEstimatedTotal() {
		return estimatedTotalValue.getText();
	}
}
