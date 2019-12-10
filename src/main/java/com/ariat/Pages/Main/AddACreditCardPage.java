package com.ariat.Pages.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ariat.Utils.WebDriverUtils;

/**
 * This contain specific locators and methods for Add a credit card page and
 * links to
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class AddACreditCardPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(AddACreditCardPage.class);

	private By cardNickNameTextBox = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_nickname");
	private By nameOnTheCardTextBox = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_owner");
	private By typeCardSelect = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_type");
	private By cardNoTextBox = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_number");
	private By cardNoTextBoxUS = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_owner");
	private By expirationMonthSelect = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_expiration_month");
	private By expirationYearSelect = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_expiration_year");
	private By securityCodeText = By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_cvn");
	private By applyButton = By.id("applyBtn");
	private By cancelButton = By.xpath("//button[text()='Cancel]");
	private By creditCardInfoText = By.xpath("//*contains[text(), 'Credit card information']");
	private By typeCardSelectUS = By.id("c-ct");
	private By cardNoUS = By.xpath("//input[@id='c-cardnumber']");

	public AddACreditCardPage(WebDriver driver) {
		super(driver);
	}
	
	public void setDetailsCreditCard(String cardId, String cardOwner, String typeCard, String number, String cvs, String month, String year) {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, cardNickNameTextBox, cardId);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, nameOnTheCardTextBox, cardOwner);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.selectDropDown(driver, typeCardSelect, typeCard);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, cardNoTextBox, number);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.scroll350Down(driver, securityCodeText);
		WebDriverUtils.enterTextBox(driver, securityCodeText, cvs);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.selectDropDown(driver, expirationMonthSelect, month);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.selectDropDown(driver, expirationYearSelect, year);
}
	
	public void setDetailsCreditCardUS(String cardId, String cardOwner, String number, String cvs, String month, String year) {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, cardNickNameTextBox, cardId);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, nameOnTheCardTextBox, cardOwner);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebElement iframeSwitch = driver.findElement(By.id("dieCommFrame"));
		driver.switchTo().frame(iframeSwitch);
		WebDriverUtils.scroll350Down(driver, cardNoUS);
		WebDriverUtils.enterTextBox(driver, cardNoUS, number);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		driver.switchTo().defaultContent();
		WebDriverUtils.scroll350Down(driver, securityCodeText);
		WebDriverUtils.enterTextBox(driver, securityCodeText, cvs);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.selectDropDown(driver, expirationMonthSelect, month);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.selectDropDown(driver, expirationYearSelect, year);
}
	
	public void selectTypeCardUS(String type) {
		logger.info("Selecting the type of the card...");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.selectDropDown(driver, typeCardSelectUS, type);
	}

	
	public void enterCardNoUS(String number) {
		logger.info("Selecting the type of the card...");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, cardNoTextBoxUS, number);
	}
	
	public void applyCardCreation() {
		logger.info("Creating new credit card");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.scroll350Down(driver, applyButton);
		WebDriverUtils.clickOnElementWithWait(driver, applyButton);
	}

	public void cancelCardCreation() {
		logger.info("Canceling the card creation");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, cancelButton);
	}
	
     public PaymentInformationPage returnPaymentInformationPage() {
    	 WebDriverUtils.scroll350Down(driver, applyButton);
		WebDriverUtils.clickOnElementWithWait(driver, applyButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(creditCardInfoText));
		return new PaymentInformationPage(driver);
	}
}
