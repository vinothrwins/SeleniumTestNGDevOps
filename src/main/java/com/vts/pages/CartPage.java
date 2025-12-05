package com.vts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model for the Shopping Cart page.
 * This version uses PageFactory.
 */
public class CartPage {

    WebDriver driver;

    /**
     * Constructor to initialize WebDriver and PageFactory elements.
     */
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * "Proceed to Payment" button in the cart.
     */
    @FindBy(xpath = "(//a[normalize-space()='Proceed to Payment'])[1]")
    private WebElement proceedToPaymentButton;

    /**
     * Clicks on the 'Proceed to Payment' button.
     * Navigates user to the payment / checkout page.
     */
    public void clickProceedToPayment() {
        proceedToPaymentButton.click();
    }
}
