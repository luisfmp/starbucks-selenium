/**
 *
 */
package com.globant.starbucks.tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Contiene la configuracion general de los tests
 *
 * @author lu.martinez
 *
 */
public class BaseConfiguration {
	Properties prop = new Properties();

	private WebDriver driver;

	public void setUpDriver() {
		setFirefoxDriver();// Asigna el navegador a usar
		getDriver().manage().window().maximize();
	}

	public void tearDownDriver() {
		getDriver().close();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setFirefoxDriver() {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		this.driver = new FirefoxDriver(dc);
	}

	public void setChromeDriver() {
		loadProperties();
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver.path"));
		this.driver = new ChromeDriver();
	}

	public void setHtmlUnitDriver() {
		this.driver = new HtmlUnitDriver(true);
	}

	private void loadProperties() {
		InputStream file = BaseConfiguration.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
