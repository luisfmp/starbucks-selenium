/**
 * 
 */
package com.globant.starbucks.pages.menues;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.starbucks.pages.HeaderAndFooter;

/**
 * @author lu.martinez
 *
 */
public class Subscription extends HeaderAndFooter{

	@FindBy(css=".marquee-content > .content-h1 h1")
	private WebElement title;
	
	public Subscription(WebDriver driver) {
		super(driver);
	}

	public String getTitle(){
		return title.getText();
	}
}
