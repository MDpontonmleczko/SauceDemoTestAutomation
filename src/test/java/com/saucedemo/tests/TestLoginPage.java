package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {

    @DataProvider
    private String[][] correctLogInCredentials() {
        return new String[][] {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }

    @DataProvider
    private String[][] lockedLoginCredentials() {
        return new String[][] {
                {"locked_out_user", "secret_sauce"}
        };
    }

    @DataProvider
    private String[][] wrongLoginCredentials(){
        return new String[][] {
                {"test", "secret_sauce"},
                {"standard_user", "test"},
                {"kom098", "kik29"},
                {"secret_sauce", "secret_sauce"},
                {"standard_user", "standard_user"},
                {"0", "-1"}
        };
    }

    @Test(dataProvider = "correctLogInCredentials")
    public void shouldLogInSuccessfullyWhenCorrectCredentialsSend(String username, String password) {
        Assert.assertTrue(super.loginPage.logIn(username, password).isProductsPageTitleDisplayed());
    }

    @Test(dataProvider = "lockedLoginCredentials")
    public void shouldReturnErrorMessageWhenLockedLoginCredentialsSend(String username, String password) {
        String expectedMessage = "Epic sadface: Sorry, this user has been locked out.";
        assertErrorMessage(username,password, expectedMessage);
    }

    @Test(dataProvider = "wrongLoginCredentials")
    public void shouldReturnErrorMessageWhenWrongLoginCredentialsSend(String username, String password) {
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        assertErrorMessage(username,password, expectedMessage);
    }

    @Test()
    public void shouldReturnErrorMessageWhenNoUsernameSend() {
        String expectedMessage = "Epic sadface: Username is required";
        assertErrorMessage("","secret_sauce", expectedMessage);
    }

    @Test()
    public void shouldReturnErrorMessageWhenNoPasswordSend() {
        String expectedMessage = "Epic sadface: Password is required";
        assertErrorMessage("standard_user","", expectedMessage);
    }

    @Test()
    public void shouldReturnErrorMessageWhenNoCredentialsSend() {
        String expectedMessage = "Epic sadface: Username is required";
        assertErrorMessage("","", expectedMessage);
    }

    private void assertErrorMessage(String username, String password, String expectedMessage) {
        loginPage.logIn(username, password);
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage,
                "Expected: '" + expectedMessage +  "' Instead got: '" + actualMessage + "'");
    }
}
