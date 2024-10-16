package com.utilities.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public abstract class EdgeDriverManager {

    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {

        if (webDriver == null) {
            webDriver = new EdgeDriver();
        }

        return webDriver;
    }
}
