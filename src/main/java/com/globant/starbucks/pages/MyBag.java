/**
 * 
 */
package com.globant.starbucks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author lu.martinez
 *
 */
public class MyBag extends HeaderAndFooter {

	@FindBy(css = ".ordertot > .value")
	private static WebElement estimatedTotalValue;
	
	@FindBy(css="div#itemscontainer > .cart")
	private static WebElement cartItemsContainer;
	
	private static final By removeButtonLocator = By.cssSelector("a.removeItemanchor");
	private static final By cartItemWrapperLocator = By.xpath("ancestor::div[@class='cartItemwrapper']");
	private static final By emptyCartNoticeLocator = By.cssSelector(".cartempty");

	private static final String prodNamePattern = "a.prodname[title='%s']";
	private static final String optionButtonPattern = "//button[contains(@class,'ui-state-default') and text()='%s']";
	
	public MyBag(WebDriver driver) {
		super(driver);
	}

	/**
	 * @return The estimated total with dollar symbol ej. $83.07
	 */
	public String getEstimatedTotal() {
		return estimatedTotalValue.getText();
	}
	
	public void deleteByProductName(String name){
		WebElement cartItemWrapper = getCartItemWrapperByName(name);
		cartItemWrapper.findElement(removeButtonLocator).click();
		getDriver().findElement(By.xpath(String.format(optionButtonPattern, "Yes"))).click();
	}
	
	public WebElement getCartItemWrapperByName(String name){
		WebElement nameElement = cartItemsContainer.findElement(By.cssSelector(String.format(prodNamePattern, name)));
		return getCartItemWrapper(nameElement);
	}
	
	public WebElement getCartItemWrapper(WebElement element){
		return element.findElement(cartItemWrapperLocator);
	}
	
	public boolean isCartEmpty(){
		return getDriver().findElement(emptyCartNoticeLocator).isDisplayed();
	}
}
