package com.globant.starbucks.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.globant.starbucks.pages.Home;
import com.globant.starbucks.pages.menues.Tea;

public class OrderingTest extends BaseConfiguration {

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
	public void shouldOrdenateCorrectly() {
		home.goHome();
		Tea tea = home.goToTeaPageThroughImage();
		tea.toggleFilterByTitle("Teavana");
		tea.sortByVisibleText("Price - Low To High");
		String lastProductName = tea.findLastProductInList().getProductName();
		tea.sortByVisibleText("Price - High To Low");
		String firstProductName = tea.findFirstProductInList().getProductName();
		Assert.assertEquals(lastProductName, firstProductName, "Los Nombres no son iguales");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		System.out.println("===================================" + result.getTestName() + "---" + result.getStatus());
		if (result.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			String filePath = ".\\" + this.getClass().getName() + "ScreenShot.jpg";
			System.out.println("===================================" + filePath);
			FileUtils.copyFile(scrFile, new File(filePath));
		}
	}
}
