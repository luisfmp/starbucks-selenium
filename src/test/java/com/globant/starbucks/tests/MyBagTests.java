package com.globant.starbucks.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.globant.starbucks.pages.Home;
import com.globant.starbucks.pages.MyBag;
import com.globant.starbucks.pages.elements.ProductCard;
import com.globant.starbucks.pages.menues.gifts.Sale;

public class MyBagTests extends BaseConfiguration {

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
	public void shouldDeleteProduct() {
		home.goHome();
		home.goToPageByPrincipalMenu("more", "Sale");
		Sale salePage = PageFactory.initElements(getDriver(), Sale.class);
		salePage.togglePriceFilter("$25 to $50");
		ProductCard productCard = salePage.findProductByResultsPosition(0);
		String name = productCard.getProductName();
		productCard.addToBag();
		MyBag myBag = salePage.goToMyBag();
		myBag.delteByProductName(name);
		Assert.assertEquals(myBag.isCartEmpty(), true, "El carrito no está vacío");
	}

}
