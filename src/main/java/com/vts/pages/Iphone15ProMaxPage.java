package com.vts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model for the iPhone 15 Pro Max product details page.
 * This version uses PageFactory and @FindBy for element initialization.
 */
public class Iphone15ProMaxPage {

    WebDriver driver;

    /**
     * Constructor to initialize WebDriver and PageFactory elements.
     */
    public Iphone15ProMaxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Product title element for iPhone 15 Pro Max.
     * (Adjust xpath/css if your application uses a different locator.)
     */
    @FindBy(xpath = "(//h1[normalize-space()='Apple iPhone 15 Pro Max'])[1]")
    private WebElement productTitle;

    /**
     * Price label for iPhone 15 Pro Max.
     * (Adjust locator as per your actual DOM.)
     */
    @FindBy(xpath = "//p[@class='text-2xl text-green-600 font-semibold mb-4']")
    private WebElement productPrice;

    /**
     * Quantity input field for the product.
     */
    @FindBy(xpath = "//input[@id='qty']")
    private WebElement quantityInput;

    /**
     * Add to Cart button on the product details page.
     */
    @FindBy(xpath = "//button[normalize-space()='Add to Cart']")
    private WebElement addToCartButton;

    /**
     * Returns the product title text.
     */
    public String getProductTitle() {
        return productTitle.getText().trim();
    }

    /**
     * Returns the product price text.
     */
    public String getProductPrice() {
        return productPrice.getText().trim();
    }

    /**
     * Clears and enters the quantity in the quantity input field.
     *
     * @param qty quantity of product to be purchased
     */
    public void enterQuantity(int qty) {
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(qty));
    }

    /**
     * Clicks on Add to Cart button.
     */
    public void clickAddToCart() {
        addToCartButton.click();
    }

    /**
     * Combined action: Enter quantity + Add to Cart.
     *
     * @param qty quantity of product to be added to cart
     */
    public void addProductToCart(int qty) {
        enterQuantity(qty);
        clickAddToCart();
    }
}
