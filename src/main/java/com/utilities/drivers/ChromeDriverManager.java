package com.utilities.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class ChromeDriverManager {

    private static WebDriver webDriver;

    public static WebDriver getWebDriver(){

        if (webDriver == null) {
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }
}
