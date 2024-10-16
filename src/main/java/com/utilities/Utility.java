package com.utilities;

import com.utilities.drivers.ChromeDriverManager;
import com.utilities.drivers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;

public class Utility {

    public static WebDriver getChromeDriver(){
        return ChromeDriverManager.getWebDriver();
    }

    public static WebDriver getEdgeDriver() {
        return EdgeDriverManager.getWebDriver();
    }
}
