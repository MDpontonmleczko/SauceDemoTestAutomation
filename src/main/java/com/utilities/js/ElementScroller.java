package com.utilities.js;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ElementScroller {

    public static WebDriver driver;

    public static void scrollToElementJS(By locator) {
        WebElement element = driver.findElement(locator);
        String jsScript = "arguments[0].scrollIntoView();";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(jsScript, element);
    }

}
