/**
 *
 */
package com.globant.starbucks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.starbucks.pages.menues.Coffee;
import com.globant.starbucks.pages.menues.Drinkware;
import com.globant.starbucks.pages.menues.Equipment;
import com.globant.starbucks.pages.menues.GiftsAndMore;
import com.globant.starbucks.pages.menues.Subscription;
import com.globant.starbucks.pages.menues.Tea;

/**
 * @author lu.martinez
 *
 */
public class HeaderAndFooter extends Selenium {

	@FindBy(id = "logo")
	private static WebElement logo;

	@FindBy(css = ".cartqty")
	private static WebElement carItems;

	@FindBy(css = ".cat.coffee")
	private static WebElement coffee;

	@FindBy(css = ".cat.tea")
	private static WebElement tea;

	@FindBy(css = ".cat.drinkware")
	private static WebElement drinkware;

	@FindBy(css = ".cat.equipment")
	private static WebElement equipment;

	@FindBy(css = ".cat.subscriptions")
	private static WebElement subscription;

	@FindBy(css = ".cat.more")
	private static WebElement giftsAndMore;

	@FindBy(id = "minicart")
	private static WebElement miniCart;

	private static final By viewBagLocator = By.cssSelector(".minicartcheckoutnow");

	private static final String menuCssLocatorPatterns = ".cat.%s";

	public HeaderAndFooter(WebDriver driver) {
		super(driver);
	}

	public void clickOnLogo() {
		logo.click();
	}

	public Coffee goToCoffeePage() {
		coffee.click();
		return PageFactory.initElements(getDriver(), Coffee.class);
	}

	public Tea goToTeaPage() {
		tea.click();
		return PageFactory.initElements(getDriver(), Tea.class);
	}

	public Drinkware goToDrinkwarePage() {
		drinkware.click();
		return PageFactory.initElements(getDriver(), Drinkware.class);
	}

	public Equipment goToEquipmentPage() {
		equipment.click();
		return PageFactory.initElements(getDriver(), Equipment.class);
	}

	public GiftsAndMore goToGiftsAndMore() {
		giftsAndMore.click();
		return PageFactory.initElements(getDriver(), GiftsAndMore.class);
	}

	public Subscription goToSubscriptionsPage() {
		subscription.click();
		return PageFactory.initElements(getDriver(), Subscription.class);
	}

	/**
	 * @param menu
	 *            Debe ser alguno de los siguientes valores: coffee, tea,
	 *            drinkware, equipment, subscriptions, more
	 * @param submenu
	 *            El valor textual del enlace, ej. "Verismo Pods"
	 * @return
	 */
	public void goToPageByPrincipalMenu(String menu, String submenu) {
		WebElement menuElement = getDriver().findElement(By.cssSelector(String.format(menuCssLocatorPatterns, menu)));
		Actions actions = new Actions(getDriver());
		actions.moveToElement(menuElement).perform();
		waitForElementVisible(By.linkText(submenu), 3);
		getDriver().findElement(By.linkText(submenu)).click();
	}

	/**
	 * @return El numero de articulos en el carrito de compras
	 */
	public int getItemsInCart() {
		return Integer.parseInt(carItems.findElement(By.cssSelector("span")).getText());
	}

	/**
	 * @return La pagina del detalle del carrito de compras
	 */
	public MyBag goToMyBag() {
		if (getItemsInCart() > 0) {
			if (!getDriver().findElement(viewBagLocator).isDisplayed()) {
				miniCart.click();
				waitForElementVisible(viewBagLocator);
			}
		}
		getDriver().findElement(viewBagLocator).click();
		return PageFactory.initElements(getDriver(), MyBag.class);
	}

}
