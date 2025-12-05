package com.vts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model for the Checkout / Payment page.
 * This version uses PageFactory with @FindBy annotations.
 */
public class PaymentDetailsPage {

    WebDriver driver;

    /**
     * Constructor to initialize WebDriver and PageFactory elements.
     */
    public PaymentDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Card Number input field.
     */
    @FindBy(xpath = "//input[@id='card']")
    private WebElement cardNumberInput;

    /**
     * Expiry Date input field.
     */
    @FindBy(xpath = "//input[@id='expiry']")
    private WebElement expiryInput;

    /**
     * CVC / CVV input field.
     */
    @FindBy(xpath = "//input[@id='cvc']")
    private WebElement cvcInput;

    /**
     * Name on Card input field.
     */
    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameOnCardInput;

    /**
     * Pay / Submit button on the payment form.
     */
    @FindBy(xpath = "//button[@id='submit-btn']")
    private WebElement payButton;

    /**
     * Enters card number.
     *
     * @param card card number e.g., "4111 1111 1111 1111"
     */
    public void enterCardNumber(String card) {
        cardNumberInput.clear();
        cardNumberInput.sendKeys(card);
    }

    /**
     * Enters expiry date.
     *
     * @param expiry expiry date in MM/YY or MM/YYYY format
     */
    public void enterExpiry(String expiry) {
        expiryInput.clear();
        expiryInput.sendKeys(expiry);
    }

    /**
     * Enters CVC / CVV.
     *
     * @param cvc card security code
     */
    public void enterCVC(String cvc) {
        cvcInput.clear();
        cvcInput.sendKeys(cvc);
    }

    /**
     * Enters the Name on Card.
     *
     * @param name card holder name
     */
    public void enterNameOnCard(String name) {
        nameOnCardInput.clear();
        nameOnCardInput.sendKeys(name);
    }

    /**
     * Clicks the Pay button to submit payment.
     */
    public void clickPay() {
        payButton.click();
    }

    /**
     * Single method to perform complete payment.
     *
     * @param card   card number
     * @param expiry expiry date
     * @param cvc    security code
     * @param name   name on card
     */
    public void makePayment(String card, String expiry, String cvc, String name) {
        enterCardNumber(card);
        enterExpiry(expiry);
        enterCVC(cvc);
        enterNameOnCard(name);
        clickPay();
    }
}
