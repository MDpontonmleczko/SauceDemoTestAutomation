package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static WebDriver driver;
    private final Duration timeout = Duration.ofSeconds(10);
    private final WebDriverWait wait = new WebDriverWait(driver, timeout);

    public WebElement find(By locator){
        waitUntilElementIsVisible(locator);
        return driver.findElement(locator);
    }

    public void click(By locator){
        waitUntilElementIsClickable(locator);
        find(locator).click();
    }

    private void waitUntilElementIsVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitUntilElementIsClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
