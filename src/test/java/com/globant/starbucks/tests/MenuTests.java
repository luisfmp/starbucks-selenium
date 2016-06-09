/**
 * 
 */
package com.globant.starbucks.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.globant.starbucks.pages.Home;
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
public class MenuTests extends BaseConfiguration{

	private Home home;

	@BeforeClass
	public void setUp() {
		setUpDriver();
		home = PageFactory.initElements(getDriver(), Home.class);
	}
	
	@AfterClass
	public void tearDown(){
		tearDownDriver();
	}

	@Test
	public void shouldEnterCoffeeMenuEntry() {
		home.goHome();
		Coffee coffeePage = home.goToCoffeePage();
		Assert.assertEquals("Coffee", coffeePage.getTitle(), "The page is not coffee page");
	}

	@Test
	public void shouldEnterTeaMenuEntry() {
		home.goHome();
		Tea teaPage = home.goToTeaPage();
		Assert.assertEquals(teaPage.getTitle(), "Tea", "The page is not Tea page");
	}

	@Test
	public void shouldEnterDrinkwareMenuEntry() {
		home.goHome();
		Drinkware drinkwarePage = home.goToDrinkwarePage();
		Assert.assertEquals(drinkwarePage.getTitle(), "Drinkware", "The page is not Drinkware page");
	}

	@Test
	public void shouldEnterEquipmentMenuEntry() {
		home.goHome();
		Equipment equipmentPage = home.goToEquipmentPage();
		Assert.assertEquals(equipmentPage.getTitle(), "Equipment", "The page is not Equipment page");
	}

	@Test
	public void shouldEnterSubscriptionMenuEntry() {
		home.goHome();
		Subscription subscriptionPage = home.goToSubscriptionsPage();
		Assert.assertEquals(subscriptionPage.getTitle(), "Starbucks subscriptions".toUpperCase(),
				"The page is not Subscription page");
	}

	@Test
	public void shouldEnterGiftsAndMoreMenuEntry() {
		home.goHome();
		GiftsAndMore morePage = home.goToGiftsAndMore();
		Assert.assertEquals(morePage.getTitle(), "Gifts & More", "The page is not GiftsAndMore page");
	}
}
