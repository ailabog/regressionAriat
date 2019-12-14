package com.ariat.Pages.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Utils.WebDriverUtils;

/**
 * Implements checkout process page with its locators and methods
 * 
 * @author aila.bogasieru@ariat.com
 */

public class CheckoutProcessPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(CheckoutProcessPage.class);

	private By editBagLink = By.xpath("//button[@class='el-button summary__edit el-button--text']");
	private By arrowCountry = By.xpath("//span[@class='el-input__suffix']");

	private By selectOption = By.xpath("//li//span[contains(text(), 'Austria')]");
	private By selectOptionBE = By.xpath("//li//span[contains(text(), 'Belgium')]");
	private By selectOptionDE = By.xpath("//li//span[contains(text(), 'Deutschland')]");
	private By selectOptionFR = By.xpath("//li//span[contains(text(), 'Belgique')]");
	private By firstName = By.name("firstName");
	private By lastName = By.name("lastName");
	private By address = By.name("address1");
	private By city = By.name("city");
	private By zipCode = By.name("zipcode");
	private By checkCheckBoxBilling = By.xpath("//input[@value='Use this address for Billing']");
	private By mobile = By.name("phone");
	private By email = By.name("email");
	private By addToAddressBoxCheck = By.xpath("//input[@vlaue='Add to Address Book']");
	private By stayInTouchCheck = By
			.xpath("//input[@value='Stay in touch. Learn about our new products and special offers first!']");
	private By continueCheckoutDE = By
			.xpath("//button[@class='el-button checkout_button el-button--primary']//span[text()='Fortsetzen']");
	private By continueCheckout1 = By.cssSelector(".el-button--primary:nth-child(1)");
	private By standardCheck = By.xpath("//input[@value='X-1']");
	private By expressCheck = By.xpath("//input[@value='U-1']");
	private By buyNowBtn = By.id("confirmpayment");
	private By checkoutCompleteText = By.xpath("//h1[text()='Checkout Complete']");
	private By giftCardTxtBox = By.xpath("//input[@placeholder=Gift Card Code']");
	private By pinTxtBox = By.xpath("//input[@placeholder='Pin']");
	private By applyGifCard = By.xpath("//button//span[text()='Apply']");
	private By promoCodeTxtBox = By.xpath("//input[@placeholder='Promo code']");
	private By expandGiftCard = By.xpath("//i[text()='Gift card']");
	private By expandPromoCode = By.xpath("//i[text()='Promo code']");
	private By selectState = By.xpath("//span[text()='Arizona']");
	private By checkoutBtn = By.xpath("//div[@data-funding-source='paypal']");
	private By nextPaymentButton = By.cssSelector(".el-button > span > span");
	private By useAddressAsItIsBtn = By.cssSelector(".ms-margin-bottom-10 > .el-button > span");
	private By closeWindowAddressBtn = By.xpath("//*[@id=\"app\"]/main/div/form/div[13]/div/div[1]/button");
	private By signInLink = By.xpath("//a[text()='Sign In']");
	private By emailTxtBoxPayPal = By.id("email");
	private By passwordTxtBoxPaypal = By.xpath("//div[@id='main']//input[@id='password']");
	private By confirmPayPal = By.id("confirmButtonTop");
	private By nextBtnPayPal = By.id("btnNext");
	private By loginPayPal = By.id("btnLogin");
	private By arrowAddress = By.xpath("//i[@class='el-select__caret el-input__icon el-icon-arrow-up']");
	private By addressLocator = By.xpath("//span[contains(text(), '1el1r - Basarabia Blvd, No 62')]");
	private By arrowSelectAddress = By.cssSelector(".el-icon-arrow-up");
	private By addressOption = By.xpath("//span[contains(text(), '0ndEy - Avenue, 5th')]");

	public void selectAddress() {
		WebDriverUtils.clickOnElementWithWait(driver, arrowAddress);
		WebDriverUtils.clickOnElementWithWait(driver, addressLocator);
	}

	public void selectAddressUS() {
		WebDriverUtils.clickOnElementWithWait(driver, arrowSelectAddress);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, addressOption);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public CheckoutProcessPage(WebDriver driver) {
		super(driver);
	}

	public void clickEditBag() {
		logger.info("Editing bag..");
		WebDriverUtils.clickOnElementWithWait(driver, editBagLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void clickCheckoutBtn() {
		WebDriverUtils.scrollLittDown(driver, checkoutBtn);
		WebDriverUtils.clickOnElementWithWait(driver, checkoutBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void selectArrow() {
		logger.info("Selecting country..");
		WebDriverUtils.clickOnElementWithWait(driver, arrowCountry);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void selectCountry(String optionCountry) {
		switch (optionCountry) {
		case "Belgium":
			WebDriverUtils.clickOnElementWithWait(driver, selectOptionBE);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;
		case "Deutschland":
			WebDriverUtils.clickOnElementWithWait(driver, selectOptionDE);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;
		case "France":
			WebDriverUtils.scroll500Down(driver, selectOptionFR);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;

		case "UK":
			WebDriverUtils.clickOnElementWithWait(driver, selectOption);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			break;
		default:
			throw new RuntimeException("Language" + optionCountry + "not supported");
		}
	}

	public void selectState() {
		logger.info("Selecting state..");
		WebDriverUtils.clickOnElementWithWait(driver, arrowCountry);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, selectState);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public void setInfoAccountSecureCheckoutBelgium(String nameValue, String lastValue, String addressValue, String cityValue, String zipCodeValue, String mobileValue, String emailValue) {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, firstName, nameValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, lastName, lastValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, address, addressValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, city, cityValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, arrowCountry);
		WebDriverUtils.clickOnElementWithWait(driver, selectOptionBE);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
		WebDriverUtils.enterTextBox(driver, zipCode, zipCodeValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, mobile, mobileValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, email, emailValue);
	}
	
	public void setInfoAccountSecureCheckoutUS(String nameValue, String lastValue, String addressValue, String cityValue, String zipCodeValue, String mobileValue, String emailValue) {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, firstName, nameValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, lastName, lastValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, address, addressValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, city, cityValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
		WebDriverUtils.enterTextBox(driver, zipCode, zipCodeValue);
		WebDriverUtils.clickOnElementWithWait(driver, arrowCountry);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, selectState);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, mobile, mobileValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, email, emailValue);
	}


	public void setInfoAccountSecureCheckoutDeutschland(String nameValue, String lastValue, String addressValue, String cityValue, String zipCodeValue, String mobileValue, String emailValue)
	{
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, firstName, nameValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, lastName, lastValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, address, addressValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, city, cityValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.clickOnElementWithWait(driver, arrowCountry);
	WebDriverUtils.clickOnElementWithWait(driver, selectOptionDE);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	WebDriverUtils.enterTextBox(driver, zipCode, zipCodeValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, mobile, mobileValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, email, emailValue);
}
	
	
	public void setInfoAccountSecureCheckoutFrance(String nameValue, String lastValue, String addressValue, String cityValue, String zipCodeValue, String mobileValue, String emailValue)
	 {
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, firstName, nameValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, lastName, lastValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, address, addressValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, city, cityValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.clickOnElementWithWait(driver, arrowCountry);
	WebDriverUtils.clickOnElementWithWait(driver, selectOptionFR);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	WebDriverUtils.enterTextBox(driver, zipCode, zipCodeValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, mobile, mobileValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, email, emailValue);
}
	
	public void setInfoAccountSecureCheckoutUK(String nameValue, String lastValue, String addressValue, String cityValue, String zipCodeValue, String mobileValue, String emailValue)
	 {
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, firstName, nameValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, lastName, lastValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, address, addressValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, city, cityValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.clickOnElementWithWait(driver, arrowCountry);
	WebDriverUtils.clickOnElementWithWait(driver, selectOption);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	WebDriverUtils.enterTextBox(driver, zipCode, zipCodeValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, mobile, mobileValue);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	WebDriverUtils.enterTextBox(driver, email, emailValue);
}
	
	
	public void closeWindowAddress() {
		WebDriverUtils.clickOnElementWithWait(driver, closeWindowAddressBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void useAddressAsItIs() {
		WebDriverUtils.clickOnElementWithWait(driver, useAddressAsItIsBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	public void checkBillingCheckBox() {
		logger.info("Checking billing address the same..");
		WebDriverUtils.clickOnElementWithWait(driver, checkCheckBoxBilling);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void checkAddToAddressBox() {
		logger.info("Checking add to address box..");
		WebDriverUtils.clickOnElementWithWait(driver, addToAddressBoxCheck);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void checkStayInTouch() {
		logger.info("Checking stay in touch checkbox..");
		WebDriverUtils.clickOnElementWithWait(driver, stayInTouchCheck);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void continueCheckoutDE() {
		logger.info("Continue checkout..");
		WebDriverUtils.clickOnElementWithWait(driver, continueCheckoutDE);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void continueCheckout1() {
		logger.info("Continue checkout..");
		WebDriverUtils.clickOnElementWithWait(driver, continueCheckout1);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void checkStandardDelivery() {
		logger.info("Checking standard delivey..");
		WebDriverUtils.clickOnElementWithWait(driver, standardCheck);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void checkExpressDelivery() {
		logger.info("Checking express delivery..");
		WebDriverUtils.clickOnElementWithWait(driver, expressCheck);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void expandPromoCode() {
		logger.info("Expanding promo code..");
		WebDriverUtils.clickOnElementWithWait(driver, expandPromoCode);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void expandGiftCard() {
		logger.info("Expanding gift card..");
		WebDriverUtils.clickOnElementWithWait(driver, expandGiftCard);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void apply() {
		logger.info("Apply..");
		WebDriverUtils.clickOnElementWithWait(driver, applyGifCard);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void enterGiftCard(String giftCardValue) {
		logger.info("Entering gift card..");
		WebDriverUtils.enterTextBox(driver, giftCardTxtBox, giftCardValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void clickSignIn() {
		WebDriverUtils.clickOnElementWithWait(driver, signInLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void enterPromoCode(String promoCodeValue) {
		logger.info("Entering promo code..");
		WebDriverUtils.enterTextBox(driver, promoCodeTxtBox, promoCodeValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void enterEmailPayPal(String emailValue) {
		logger.info("Entering email..");
		String winHandleBefore = driver.getWindowHandle();
		// Perform the click operation that opens new window
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// Perform the actions on new window
		// WebDriverUtils.findElement(driver, window);
		WebDriverUtils.enterTextBox(driver, emailTxtBoxPayPal, emailValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		// driver.close();
		// Switch back to original browser (first window)
		// driver.switchTo().window(winHandleBefore);
		// Continue with original browser (first window)
	}

	public void nextBtnPayPal() {
		WebDriverUtils.clickOnElementWithWait(driver, nextBtnPayPal);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void clickConfirmPayPal() {
		logger.info("Confirm paypal payment into PayPal Account..");
		String winHandleBefore = driver.getWindowHandle();
		// Perform the click operation that opens new window
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		WebDriverUtils.clickOnElementWithWait(driver, confirmPayPal);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
		// driver.close();
		// Switch back to original browser (first window)
		// driver.switchTo().window(winHandleBefore);
		// Continue with original browser (first window)
	}

	public void enterPasswordPayPal(String passwordValue) {
		logger.info("Entering password..");
		WebDriverUtils.enterTextBox(driver, passwordTxtBoxPaypal, passwordValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void clickLoginPayPal() {
		logger.info("Loging into PayPal Account..");
		WebDriverUtils.clickOnElementWithWait(driver, loginPayPal);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public PaymentMethodsCheckoutPage returnPaymentMethodsCheckoutPage() {
		WebDriverUtils.scroll500Down(driver, nextPaymentButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, nextPaymentButton);
		return new PaymentMethodsCheckoutPage(driver);
	}

	public CheckoutProcessCompletePage returnCheckoutProcessCompletePage() {
		WebDriverUtils.scroll500Down(driver, buyNowBtn);
		WebDriverUtils.clickOnElementWithWait(driver, buyNowBtn);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_6000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(checkoutCompleteText));
		return new CheckoutProcessCompletePage(driver);
	}
}
