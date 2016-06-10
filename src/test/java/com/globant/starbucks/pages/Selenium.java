/**
 * 
 */
package com.globant.starbucks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author lu.martinez
 *
 *         Contiene funciones generales para las demas paginas
 */

public class Selenium {

	private WebDriver driver;

	public Selenium(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Hace scroll hacia abajo por 500px
	 */
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
	}

	/**
	 * Hace scroll hacia arriba por 500px
	 */
	public void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)");
	}

	/**
	 * Hace scroll hacia la izquierda por 500px
	 */
	public void scrollLeft() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(-500,0)");
	}

	/**
	 * Hace scroll hacia la derecha por 500px
	 */
	public void scrollRight() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(500,0)");
	}

	/**
	 * Espera por un elemento hasta que aparece dentro del DOM
	 * 
	 * @param selector
	 *            El selector para encontrar el elmento
	 * @param timeout
	 *            Opcional. El tiempo m�ximo de espera, en segundos, por el
	 *            elemento, si no se asigna el default es 10
	 * @return
	 */
	public WebElement waitForElementPresent(By selector, Integer... timeout) {
		int to = timeout.length > 0 ? timeout[0] : 10;
		WebElement myDynamicElement = (new WebDriverWait(driver, to))
				.until(ExpectedConditions.presenceOfElementLocated(selector));
		return myDynamicElement;
	}

	/**
	 * Espera por un elemento hasta que aparece dentro del DOM
	 * 
	 * @param selector
	 *            El selector para encontrar el elmento
	 * @param timeout
	 *            Opcional. El tiempo m�ximo de espera, en segundos, por el
	 *            elemento, si no se asigna el default es 10
	 * @return
	 */
	public WebElement waitForElementVisible(By selector, Integer... timeout) {
		int to = timeout.length > 0 ? timeout[0] : 10;
		WebElement myDynamicElement = (new WebDriverWait(driver, to))
				.until(ExpectedConditions.visibilityOfElementLocated(selector));
		return myDynamicElement;
	}

	/**
	 * Espera por un elemento hasta que desaparece dentro del DOM
	 * 
	 * @param selector
	 *            El selector para encontrar el elmento
	 * @param timeout
	 *            Opcional. El tiempo m�ximo de espera, en segundos, por el
	 *            elemento, si no se asigna el default es 10
	 * @return
	 */
	public void waitForElementNotPresent(By selector, Integer... timeout) {
		int to = timeout.length > 0 ? timeout[0] : 10;
		(new WebDriverWait(driver, to)).until(ExpectedConditions
				.not(ExpectedConditions.presenceOfElementLocated(selector)));
	}
}
