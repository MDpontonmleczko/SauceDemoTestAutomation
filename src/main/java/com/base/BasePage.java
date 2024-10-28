package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private static WebDriver driver;
    private final Duration timeout = Duration.ofSeconds(10);
    private final WebDriverWait wait = new WebDriverWait(driver, timeout);

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public void openURL(String url) {
        driver.get(url);
    }

    public void click(By locator) {
        waitUntilElementIsClickable(locator);
        find(locator).click();
    }

    public void sendText(By locator, String text) {
        WebElement locatedField = find(locator);
        locatedField.clear();
        locatedField.sendKeys(text);
    }

    public String readText(By locator) {
        WebElement locatedField = find(locator);
        return locatedField.getText();
    }

    public boolean isElementDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    private WebElement find(By locator) {
        waitUntilElementIsVisible(locator);
        return driver.findElement(locator);
    }

    private void waitUntilElementIsVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitUntilElementIsClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private void waitUntilElementCanBeSelected(By locator) {
        wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

}
