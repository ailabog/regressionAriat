package com.ariat.Pages.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements checkout page with its locators and methods
 * 
 * @author aila.bogasieru@ariat.com
 */

public class CheckoutPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(CheckoutPage.class);

	private By productImage = By.xpath("//img[@title='Insulated Pro Grip']");
	private By productNameLink = By.xpath("//a[@title='Insulated Pro Grip']");
	private By addToWishListLink = By.xpath(
			"//*[@id=\"app\"]/main/div/div[1]/div/div/div[1]/div[2]/div[2]/div/div[4]/div/span/div/div[1]/button/span");
	private By removeLink = By.xpath(
			"//*[@id=\"app\"]/main/div/div[1]/div/div/div[1]/div[2]/div[2]/div/div[4]/div/span/div/div[2]/button/span");
	private By increseQty = By.xpath("//i[@class='el-icon-plus']");
	private By decreaseQty = By.xpath("//i[@class='el-icon-minus']");
	private By promoCode = By.xpath("(//input[@type='text'])[4]");
	private By applyPromoCode = By
			.xpath("//section[@id='app']/main/div/div/div/div/div/div[3]/div/div/form/div[2]/div/button");
	private By payPalCheckoutBtn = By.xpath("//div[@id='paypal-animation-container']//div[@data-funding-source='paypal']");
	private By checkoutCheckoutBtn1 = By.cssSelector(".cart_button--black");
	private By checkoutCheckoutBtn = By.xpath("//a[text()='Checkout']");
	private By secureCheckoutBtn = By.xpath("//a[text()='Secure Checkout']");
	private By returnPolicyBtn = By.xpath("//a[text()='Return Policies']");
	private By continueShoppingCheckoutBtn = By.xpath("//a[text()='Continue Shopping']");
	private By ariatLogo = By.className("global-nav-logo-svg");
	private By emailAccount = By.xpath("//input[@placeholder='Email address']");
	private By shippingAddressText = By.id("el-collapse-head-3303");
	private By loginPayPalPageTitle = By.xpath("//section[@page-title='Log in to your PayPal account']");

	protected CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public void checkProductImage() {
		if (WebDriverUtils.findElement(driver, productImage) != null
				&& WebDriverUtils.findElement(driver, productNameLink) != null
				&& WebDriverUtils.findElement(driver, addToWishListLink) != null
				&& WebDriverUtils.findElement(driver, removeLink) != null) {
			logger.info("Product image, Product name link, add to wishlist link and remove link are displayed");
		} else {
			logger.info("Elements were not found, something went wrong!");
		}
	}

	public void increaseQtyProduct() {
		logger.info("Increasing qty for the product..");
		WebDriverUtils.clickOnElementWithWait(driver, increseQty);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void decreaseQtyProduct() {
		logger.info("Decreasing qty for the product..");
		WebDriverUtils.clickOnElementWithWait(driver, decreaseQty);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void setPtomoCode(String promoCodeValue) {
		logger.info("Entering promo code for the product..");
		WebDriverUtils.enterTextBox(driver, promoCode, promoCodeValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		logger.info("Applying promo code..");
		WebDriverUtils.clickOnElementWithWait(driver, applyPromoCode);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void clickPayPalCheckout() {
		logger.info("Going to paypal checkout..");
		WebDriverUtils.clickOnElementWithWait(driver, payPalCheckoutBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void clickCheckout() {
		logger.info("Going to checkout..");
		WebDriverUtils.clickOnElementWithWait(driver, checkoutCheckoutBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void clickSecuredCheckout() {
		logger.info("Secure checkout..");
		WebDriverUtils.clickOnElementWithWait(driver, secureCheckoutBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void clickReturnPolicy() {
		logger.info("Going to return policy..");
		WebDriverUtils.clickOnElementWithWait(driver, returnPolicyBtn);
	}

	public void goToContinueShopping() {
		logger.info("Continuing shopping..");
		WebDriverUtils.clickOnElementWithWait(driver, continueShoppingCheckoutBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public HomePage returnHomePage() {
		WebDriverUtils.clickOnElementWithWait(driver, checkoutCheckoutBtn);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(ariatLogo));
		return new HomePage(driver);
	}

	public MyAccountWishListPage returnMyAccountWishListPage() {
		WebDriverUtils.clickOnElementWithWait(driver, addToWishListLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(emailAccount));
		return new MyAccountWishListPage(driver);
	}

	public CheckoutProcessPage returnCheckoutProcessPage() {
		WebDriverUtils.scroll500Down(driver, checkoutCheckoutBtn1);
		WebDriverUtils.clickOnElementWithWait(driver, checkoutCheckoutBtn1);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(shippingAddressText));
		return new CheckoutProcessPage(driver);
	}
	
	public CheckoutProcessPage returnCheckoutProcessPayPalPage() {
		WebDriverUtils.scroll500Down(driver, By.xpath("//iframe[@class='zoid-component-frame zoid-visible']"));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='zoid-component-frame zoid-visible']")));
		WebDriverUtils.clickOnElementWithWait(driver, payPalCheckoutBtn);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_6000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(loginPayPalPageTitle));
		return new CheckoutProcessPage(driver);
	}
}
