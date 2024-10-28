package com.utilities;

import com.utilities.drivers.ChromeDriverManager;
import com.utilities.drivers.EdgeDriverManager;
import com.utilities.js.ElementClicker;
import com.utilities.js.ElementScroller;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Utility {

    public static WebDriver getChromeDriver() {
        return ChromeDriverManager.getWebDriver();
    }

    public static WebDriver getEdgeDriver() {
        return EdgeDriverManager.getWebDriver();
    }

    public static void scrollToElement(By locator) {
        ElementScroller.scrollToElementJS(locator);
    }

    public static void clickElement(By locator) {
        ElementClicker.clickElementJS(locator);
    }
}
