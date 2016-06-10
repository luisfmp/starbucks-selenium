package com.globant.starbucks.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.globant.starbucks.pages.Home;
import com.globant.starbucks.pages.menues.Tea;

public class OrderingTest extends BaseConfiguration{

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
	public void shouldOrdenateCorrectly(){
		home.goHome();
		Tea tea = home.goToTeaPageThroughImage();
		tea.toggleFilterByTitle("Teavana");
		tea.sortByVisibleText("Price - Low To High");
		String lastProductName = tea.findLastProductInList().getProductName();
		tea.sortByVisibleText("Price - High To Low");
		String firstProductName = tea.findFirstProductInList().getProductName();
		Assert.assertEquals(lastProductName, firstProductName, "Los Nombres no son iguales");
	}
}
