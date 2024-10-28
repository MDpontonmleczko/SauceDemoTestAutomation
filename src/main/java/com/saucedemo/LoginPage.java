package com.saucedemo;

import com.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By usernameFieldLocator = By.cssSelector("#user-name");
    private final By passwordFieldLocator = By.cssSelector("#password");
    private final By loginButtonLocator = By.cssSelector("#login-button");
    private final By loginErrorMessageLocator = By.cssSelector(".login-box h3");
    private String loginPageURL = "https://www.saucedemo.com/";

    public ProductsPage logIn(String username, String password){
        openLoginPageURL();
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }

    private void openLoginPageURL() {
        super.openURL(loginPageURL);
    }

    private void setUsername(String username) {
        super.sendText(usernameFieldLocator, username);
    }

    private void setPassword(String password) {
        super.sendText(passwordFieldLocator, password);
    }

    private ProductsPage clickLoginButton() {
        super.click(loginButtonLocator);
        return new ProductsPage();
    }

    public String getErrorMessage() {
        return super.readText(loginErrorMessageLocator);
    }
}
