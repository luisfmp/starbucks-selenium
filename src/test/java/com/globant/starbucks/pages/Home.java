/**
 * 
 */
package com.globant.starbucks.pages;

import org.openqa.selenium.WebDriver;

/**
 * @author lu.martinez
 *
 */
public class Home extends HeaderAndFooter {

	public Home(WebDriver driver) {
		super(driver);
	}

	private static String HOME = "http://store.starbucks.com/";

	public void goHome() {
		super.getDriver().get(HOME);
	}
}
