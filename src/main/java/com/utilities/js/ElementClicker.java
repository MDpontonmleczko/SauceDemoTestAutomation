package com.utilities.js;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementClicker {

    public static WebDriver driver;

    public static void clickElementJS(By locator) {
        WebElement element = driver.findElement(locator);
        String jsScript = "arguments[0].click();";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(jsScript, element);
    }
}
