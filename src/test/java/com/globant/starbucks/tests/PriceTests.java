package com.globant.starbucks.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.globant.starbucks.pages.Home;
import com.globant.starbucks.pages.MyBag;
import com.globant.starbucks.pages.elements.ProductCard;
import com.globant.starbucks.pages.menues.coffee.StarbucksVerismoPods;

public class PriceTests extends BaseConfiguration {

	private Home home;

	@BeforeClass
	public void setUp() {
		setUpDriver();
		home = PageFactory.initElements(getDriver(), Home.class);
	}

	@AfterClass
	public void tearDown() {
		tearDownDriver();
	}

	@Test
	public void shouldBeSameEstimatedTotal() {
		String productName = "Starbucks® Espresso Roast Espresso Verismo® Pods";
		String estimatedTotal = "$83.07";
		home.goHome();
		home.goToPageByPrincipalMenu("coffee", "Verismo® Pods");
		StarbucksVerismoPods verismoPodsPage = PageFactory.initElements(getDriver(), StarbucksVerismoPods.class);
		ProductCard productCard = verismoPodsPage.findProductInListByName(productName);
		productCard.addToBag();
		MyBag myBag = verismoPodsPage.viewBag();
		Assert.assertEquals(myBag.getEstimatedTotal(), estimatedTotal, "El total estimado no es correcto");
	}
}
