/**
 * 
 */
package com.globant.starbucks.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Contiene la configuracion general de los tests
 * 
 * @author lu.martinez
 *
 */
public class BaseConfiguration {
	private WebDriver driver;
	
	
	
	public void setUpDriver() {
		setFirefoxDriver(); //Asigna el navegador a usar
		getDriver().manage().window().maximize();
	}

	public void tearDownDriver() {
		getDriver().close();
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void setFirefoxDriver(){
		this.driver = new FirefoxDriver();
	}
	
	public void setChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		this.driver = new ChromeDriver();
	}

}
