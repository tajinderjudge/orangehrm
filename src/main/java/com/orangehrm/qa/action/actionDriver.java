package com.orangehrm.qa.action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class actionDriver {
	public void genClick(WebElement element) {
		element.click();
	}

	public void sendKeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void actionClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	public void jsClick(WebDriver driver,WebElement element) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", element);
	}

	public void ownSleep(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchDefaultFame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

}
