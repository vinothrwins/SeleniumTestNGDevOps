package com.vts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * HomePage class represents the Home screen of the VTech E-Commerce Demo App.
 * This version uses PageFactory with @FindBy annotations.
 * Code by Vinoth Rathinam - 05 Dec 2025
 */


// Initializing all elements with PageFactory
/*
 * ✔ What PageFactory does:
	- It scans the class (this)
	- Looks for all fields annotated with @FindBy
	- Creates lazy-loaded proxies for them
	- These proxies find the element only when you use it, e.g.:
 */

// "Initialize all the @FindBy elements inside THIS class using THIS driver."
// So PageFactory injects elements into your page class.



public class HomePage {

    WebDriver driver;

    /**
     * Constructor to initialize WebDriver and PageFactory elements.
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        // Initialize all @FindBy-annotated WebElement fields
        PageFactory.initElements(driver, this);
    }

    /**
     * Apple iPhone 15 Pro Max product image on the Home page.
     * Clicking this will navigate to the iPhone 15 Pro Max product details page.
     */
    @FindBy(xpath = "//img[@alt='Apple iPhone 15 Pro Max']")
    private WebElement iphone15ProMaxImage;

    /**
     * Clicks on the iPhone 15 Pro Max product on the Home page.
     */
    public void clickOniPhone15ProMax() {
        iphone15ProMaxImage.click();
    }
}
