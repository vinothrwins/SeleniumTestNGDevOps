package com.vts.tests;

import com.vts.pages.HomePage;
import com.vts.pages.Iphone15ProMaxPage;
import com.vts.pages.CartPage;
import com.vts.pages.PaymentDetailsPage;
import com.vts.pages.ConfirmationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * End-to-end test to validate complete purchase flow:
 * 1) Open Home page
 * 2) Navigate to iPhone 15 Pro Max product
 * 3) Add product to cart
 * 4) Proceed to Payment
 * 5) Enter payment details & pay
 * 6) Verify order confirmation message
 * 7) Navigate back to Home
 */
public class E2EOrderFlowTest {

    private WebDriver driver;
    private HomePage homePage;
    private Iphone15ProMaxPage iphone15ProMaxPage;
    private CartPage cartPage;
    private PaymentDetailsPage paymentDetailsPage;
    private ConfirmationPage confirmationPage;

    // Actual URL
    private final String baseUrl = "https://vinothqaacademy.com/ecommerce-demo/home.html";

    @BeforeClass
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager (or configure your own path)
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Maximize browser and set a basic implicit wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
    }

    @Test
    public void verifyUserCanCompleteEndToEndPurchaseFlow() {
        // 1) Launch application Home page
        driver.get(baseUrl);

        // Initialize page objects (PageFactory inside constructors)
        homePage = new HomePage(driver);
        iphone15ProMaxPage = new Iphone15ProMaxPage(driver);
        cartPage = new CartPage(driver);
        paymentDetailsPage = new PaymentDetailsPage(driver);
        confirmationPage = new ConfirmationPage(driver);

        // 2) From Home → click on iPhone 15 Pro Max
        homePage.clickOniPhone15ProMax();

        // 3) Verify product page is for iPhone 15 Pro Max
        String productTitle = iphone15ProMaxPage.getProductTitle();
        Assert.assertTrue(
                productTitle.contains("iPhone 15 Pro Max"),
                "Product title mismatch. Actual: " + productTitle
        );

        // (Optional) Verify price is shown
        String price = iphone15ProMaxPage.getProductPrice();
        System.out.println("Product price displayed: " + price);

        // 4) Add product to cart with quantity = 1
        iphone15ProMaxPage.addProductToCart(1);

        // 5) On Cart page → click 'Proceed to Payment'
        cartPage.clickProceedToPayment();

        // 6) On Payment page → enter payment details and click Pay
        //    Use test / dummy data as this is a demo app
        String cardNumber = "4111 1111 1111 1111";
        String expiry = "12/30";
        String cvc = "123";
        String nameOnCard = "Vinoth Test";

        paymentDetailsPage.makePayment(cardNumber, expiry, cvc, nameOnCard);

        // 7) On Confirmation page → verify success message
        //    Update this expected text to match EXACT message in your app.
        String expectedSuccessMessage = "Thank you! Your order is confirmed. A confirmation email is on its way, and we’ll let you know as soon as it ships.";
        String actualSuccessMessage = confirmationPage.getSuccessMessage();

        System.out.println("Expected success message: " + expectedSuccessMessage);
        System.out.println("Actual success message  : " + actualSuccessMessage);

        Assert.assertTrue(
                confirmationPage.isOrderSuccessMessageDisplayed(expectedSuccessMessage),
                "Order success message did not match!"
        );

        // 8) Click 'Back to Home' and (optionally) verify we're back on Home page
        confirmationPage.clickBackToHome();

        // If you have a unique element on Home page, you can assert it here.
        // For example, re-click product to ensure we're really on the Home screen:
        // homePage.clickOniPhone15ProMax();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
