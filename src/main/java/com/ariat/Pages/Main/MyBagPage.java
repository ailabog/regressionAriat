package com.ariat.Pages.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * This page is designed implement methods specific to My Bags Page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MyBagPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(MyBagPage.class);

	private By cancelFreeGift = By.xpath("(//button[@type='button'])[12]");
	private By confirmFreeGift = By.xpath("//button[@value='Select']");
	private By miniCart = By.xpath("//div[@id='header-main-content']/div/div[5]/div/div[2]/a/span");
	private By myBagText = By.xpath("//section[@id='app']/main/div/div/div/div/div/div/div/p");
	private By freeGiftSocks = By.xpath("//img[@title='AriatTEK Performance Socks']");
	private By checkoutButton = By.xpath("//a[text()='Checkout']");
	private By continueShoppingButton = By.xpath("//a[contains(text(),'Continue shopping')]");
	private By bonusDialog = By.id("bonus-product-dialog");
	private By closeMinicart = By.xpath("//span[@class='icon-close close-minicart']");
	private By checkoutBtn = By.xpath("//a[@class='checkout minicart-button button large']");
	private By checkoutBtnDE = By.xpath("//a[text()='Zur Kasse']");
	private By continueShoppingBtn = By.xpath("//a[text()='Continue shopping']");
	private By ariatLogo = By.className("global-nav-logo-svg");
	private By removeLink = By.linkText("Remove");

	public MyBagPage(WebDriver driver) {
		super(driver);
	}
	
	public void removeProduct() {
		WebDriverUtils.clickOnElementWithWait(driver, removeLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void cancelFreeGift() {
		if (WebDriverUtils.findElement(driver, bonusDialog) != null) {
			WebDriverUtils.clickOnElementWithWait(driver, cancelFreeGift);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		} else {
			logger.info("Dialog not able to be displayed");
		}
	}

	public void confirmFreeGift() {
		if (WebDriverUtils.findElement(driver, bonusDialog) != null) {
			WebDriverUtils.clickOnElementWithWait(driver, confirmFreeGift);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		} else {
			logger.info("Dialog not able to be displayed");
		}
	}

	public void checkMyBagFreeGift() {
		WebDriverUtils.moveToElement(driver, miniCart);
		if (WebDriverUtils.findElement(driver, myBagText) != null
				&& WebDriverUtils.findElement(driver, checkoutBtn) != null
				&& WebDriverUtils.findElement(driver, freeGiftSocks) != null
				&& WebDriverUtils.findElement(driver, continueShoppingButton) != null) {
			logger.info("My bag contains the right elements");
		} else {
			logger.info("My bag does not contain the right elements");
		}
	}

	public void checkMyBagNoFreeGift() {
		WebDriverUtils.moveToElement(driver, miniCart);
		if (WebDriverUtils.findElement(driver, myBagText) != null
				&& WebDriverUtils.findElement(driver, checkoutButton) != null
				&& WebDriverUtils.findElement(driver, continueShoppingButton) != null) {
			logger.info("My bag contains the right elements");
		} else {
			logger.info("My bag does not contain the right elements");
		}
	}

	public void closeMiniCart() {
		logger.info("Closing minicart..");
		WebDriverUtils.clickOnElementWithWait(driver, closeMinicart);
	}

	public void clickCheckout() {
		logger.info("Going to checkout process..");
		WebDriverUtils.scrollBottomPage(driver, checkoutBtn);
		WebDriverUtils.clickOnElementWithWait(driver, checkoutBtn);
	}

	public void clickContinueShopping() {
		logger.info("Continue shopping..");
		WebDriverUtils.clickOnElementWithWait(driver, continueShoppingBtn);
	}

	public CheckoutPage returnCheckoutPage() {
		WebDriverUtils.clickOnElementWithWait(driver, checkoutBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
		return new CheckoutPage(driver);
	}

	public CheckoutPage returnCheckoutPageDE() {
		WebDriverUtils.clickOnElementWithWait(driver, checkoutBtnDE);
		return new CheckoutPage(driver);
	}

	public HomePage returnHomePage() {
		WebDriverUtils.clickOnElementWithWait(driver, continueShoppingBtn);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(ariatLogo));
		return new HomePage(driver);
	}
}
