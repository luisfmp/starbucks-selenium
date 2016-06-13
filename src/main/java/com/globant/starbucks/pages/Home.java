/**
 *
 */
package com.globant.starbucks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.starbucks.pages.menues.Tea;

/**
 * @author lu.martinez
 *
 */
public class Home extends HeaderAndFooter {

	@FindBy(css = ".hp-slot-imagecontainer img[alt='Tea']")
	private static WebElement teaImageLink;

	private static final String HOME = "http://store.starbucks.com/";

	public Home(WebDriver driver) {
		super(driver);
	}

	/**
	 * Abre la pagina principal
	 */
	public void goHome() {
		super.getDriver().get(HOME);
	}

	/**
	 * @return La pagina de tipo Tea, entrando desde la imagen de la pagina principal
	 */
	public Tea goToTeaPageThroughImage() {
		teaImageLink.click();
		return PageFactory.initElements(getDriver(), Tea.class);
	}
}
