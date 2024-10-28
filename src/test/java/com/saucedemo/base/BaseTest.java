package com.saucedemo.base;

import com.base.BasePage;
import com.saucedemo.LoginPage;
import com.utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver chromeDriver;
    protected BasePage basePage;
    protected LoginPage loginPage;


    @BeforeClass
    public void setUp() {
        chromeDriver = Utility.getChromeDriver();
        chromeDriver.manage().window().maximize();

        basePage = new BasePage();
        basePage.setDriver(chromeDriver);

        loginPage = new LoginPage();
    }

    @AfterClass
    public void tearDown(){
        chromeDriver.quit();
    }
}
