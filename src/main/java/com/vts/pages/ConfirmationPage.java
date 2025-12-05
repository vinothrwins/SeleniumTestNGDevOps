package com.vts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model for the Order Success / Confirmation page.
 * Validates and displays the success message, and clicks Back to Home.
 * This version uses PageFactory.
 */
public class ConfirmationPage {

    WebDriver driver;

    /**
     * Constructor to initialize WebDriver and PageFactory elements.
     */
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Locator for success confirmation message text.
     */
    @FindBy(xpath = "//p[@class='text-lg mb-6']")
    private WebElement successMessage;

    /**
     * Locator for Back to Home button.
     */
    @FindBy(xpath = "//a[normalize-space()='Back to Home']")
    private WebElement backToHomeButton;

    /**
     * Returns the actual success message displayed on the confirmation page.
     *
     * @return trimmed confirmation text
     */
    public String getSuccessMessage() {
        return successMessage.getText().trim();
    }

    /**
     * Validates the success message text against an expected value.
     *
     * @param expectedMessage message that we expect to see
     * @return true if actual message matches expected, else false
     */
    public boolean isOrderSuccessMessageDisplayed(String expectedMessage) {
        String actual = getSuccessMessage();
        return actual.equals(expectedMessage);
    }

    /**
     * (Optional helper) Prints status of confirmation message validation.
     *
     * @param expectedMessage message that we expect to see
     */
    public void printConfirmationStatus(String expectedMessage) {
        String actual = getSuccessMessage();
        System.out.println("------------------------------------------------------");
        System.out.println("EXPECTED: " + expectedMessage);
        System.out.println("ACTUAL  : " + actual);
        if (actual.equals(expectedMessage)) {
            System.out.println("STATUS  : CONFIRMATION MESSAGE MATCHED ✔");
        } else {
            System.out.println("STATUS  : CONFIRMATION MESSAGE MISMATCH ✘");
        }
        System.out.println("------------------------------------------------------");
    }

    /**
     * Clicks the Back to Home button.
     */
    public void clickBackToHome() {
        backToHomeButton.click();
    }
}
