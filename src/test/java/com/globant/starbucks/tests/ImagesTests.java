package com.globant.starbucks.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.globant.starbucks.pages.Home;
import com.globant.starbucks.pages.elements.ProductCard;
import com.globant.starbucks.pages.elements.QuickViewCard;
import com.globant.starbucks.pages.menues.Equipment;

public class ImagesTests extends BaseConfiguration {
	
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
	public void validateNumberOfImages() {
		String productName = "ESPRO® Press, 18 fl oz";
		home.goHome();
		Equipment equipmentPage = home.goToEquipmentPage();
		equipmentPage.setTypeFilter("Manual");
		ProductCard productCard = equipmentPage.findProductInListByName(productName);
		Assert.assertEquals(productCard.getProductName(), productName, "El producto localizado no es el correcto");
		QuickViewCard qvCard = productCard.clickOnQuickview();
		qvCard.viewAllImages();
		Assert.assertEquals(qvCard.getNumberOfImages(), 3,
				"El numero de imagenes del producto no coincide con lo esperado");
	}
}
