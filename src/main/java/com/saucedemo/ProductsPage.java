package com.saucedemo;

import com.base.BasePage;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage {
    private final By productsPageTitleLocator = By.cssSelector("#header_container span");
    private final String productsPageURL = "https://www.saucedemo.com/inventory.html";

    public boolean isProductsPageTitleDisplayed() {
        return super.isElementDisplayed(productsPageTitleLocator);
    }
}
