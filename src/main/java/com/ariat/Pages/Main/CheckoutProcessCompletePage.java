package com.ariat.Pages.Main;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Utils.WebDriverUtils;

/**
 * Implements checkout process complete page with its locators and methods
 * 
 * @author aila.bogasieru@ariat.com
 */

public class CheckoutProcessCompletePage extends BasePage{
	
	private static final Logger logger = LoggerFactory.getLogger(CheckoutProcessCompletePage.class);
	
	private By subscribeToNewsletterCheck = By.xpath("//input[@value='Subscribe to our Newsletter']");
	private By submitBtn = By.xpath("//button[@class='el-button btn btn-primary submit-newsletter-btn el-button--primary']");
	private By createPassword = By.xpath("//input[@placeholder='Create a password']");
	private By createPasswordDE = By.xpath("//input[@placeholder='Passwort erstellen']");
	private By confirmPassword = By.xpath("//input[@placeholder='Confirm password']");
	private By confirmPasswordDE = By.xpath("//input[@placeholder='Passwort bestatigend']");
	private By createAccountBtn = By.xpath("/span[text()='Create an account']");
	private By createAccountBtnDE = By.xpath("//span[contains(text(), 'Konto erstellen')]");
	private By printThisPageLink = By.xpath("//span[text()='Print This Page']");
	private By itemText = By.xpath("//a[@title='FEI WC Bodymap Softshell Jkt']");
	private By myAccountText = By.xpath("//h1[text()='My account']");
	private By errorMsgPlaceOrder = By.xpath("//div[@class='opc-error-msg el-col el-col-12']");
	private By buyNowBtn = By.xpath("//*[@id=\"paymentbtncs\"]");
	private By pressPayPalCheckout = By.xpath("//iframe[@class='zoid-component-frame zoid-visible']");
	private By ibanSofortField = By.name("data[BankCode][search]");
	private By bankNameField = By.id("BankCodeSearch");
	private By continueSofortBtnDE = By.xpath("//button[text()='Weiter']");
	private By userIdSofortield = By.name("data[BackendForm][LOGINNAME__USER_ID]");
	private By pinSofortField = By.id("BackendFormUSERPIN");
	private By checkBankAccountSofort = By.name("data[MultipaysSession][sender_account_number_technical]");
	private By transactionSofortField = By.id("BackendFormTAN");
	private By transactionSofortFieldDE = By.id("BackendFormTan");
	private By bankNameGiropayFiled = By.id("tags");
	private By continueSofortBtn = By.xpath("//button[text()='Next']");
	private By ingIcon = By.xpath("//button[@class='grid-button-ideal-INGBNL2A']");
	private By openSelectionIdeal = By.xpath("//span[text()='Open']");
	private By IdealfinishBtn = By.xpath("//button[contains(text(),'Ga verder')]");
	

	protected CheckoutProcessCompletePage(WebDriver driver) {
		super(driver);
	}
	
	public void subscribeNewsletter() {
		logger.info("Subscribing to newsletter..");
		WebDriverUtils.clickOnElementWithWait(driver, subscribeToNewsletterCheck);
	}
	
	public void placeOrder() {
		WebDriverUtils.scroll350Down(driver, buyNowBtn);
		WebDriverUtils.clickOnElementWithWait(driver, buyNowBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public void submitingSubscription() {
		logger.info("Submiting subscription to newsletter..");
		WebDriverUtils.clickOnElementWithWait(driver, submitBtn);
	}
	
	public void enterPassword(String createPasswordValue) {
		logger.info("Entering password..");
		WebDriverUtils.enterTextBox(driver, createPassword, createPasswordValue);
	}
	
	public void enterPasswordDE(String createPasswordValue) {
		logger.info("Entering password..");
		WebDriverUtils.enterTextBox(driver, createPasswordDE, createPasswordValue);
	}
	
	public void confirmPassword(String createPasswordValue) {
		logger.info("Entering password..");
		WebDriverUtils.enterTextBox(driver, confirmPassword, createPasswordValue);
	}
	
	public void confirmPasswordDE(String createPasswordValue) {
		logger.info("Entering password..");
		WebDriverUtils.enterTextBox(driver, confirmPasswordDE, createPasswordValue);
	}
	
	public void createAccount() {
		logger.info("Create account..");
		WebDriverUtils.clickOnElementWithWait(driver, createAccountBtn);
	}
	
	public void createAccountDE() {
		logger.info("Create account..");
		WebDriverUtils.clickOnElementWithWait(driver, createAccountBtnDE);
	}
	
	public void printOrder() {
		logger.info("Print oder information..");
		WebDriverUtils.clickOnElementWithWait(driver, printThisPageLink);
	}
	
	public void checkItem() {
		logger.info("Check that item order is the right one..");
		WebDriverUtils.clickOnElementWithWait(driver, itemText);
	}
	
	public void pressPayPalCheckout() {
		WebDriverUtils.clickOnElementWithWait(driver, pressPayPalCheckout);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public void assertErrMsgOrderNotPlaced(String expectedErrorMsg) {
		logger.info("Check that error message is diplayed..");
		String errMsg = WebDriverUtils.getElementText(driver, errorMsgPlaceOrder);
		assertEquals(errMsg, expectedErrorMsg, "Error message with not being placed the order is displayed");
	}
	
	public void enterIbanSofort(String iban) {
		logger.info("Entering IBAN..");
		WebDriverUtils.enterTextBox(driver, ibanSofortField, iban);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	public void continueSofort() {
		WebDriverUtils.clickOnElementWithWait(driver, continueSofortBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public void continueSofortDE() {
		WebDriverUtils.clickOnElementWithWait(driver, continueSofortBtnDE);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public void enterBankSofort(String bankName) {
		WebDriverUtils.enterTextBox(driver, bankNameField, bankName);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	
	public void setDetailsSofort(String bankName, String userIdValue, String pinValue, String transactionId) {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	    WebDriverUtils.enterTextBox(driver, bankNameField, bankName);
	    WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	    WebDriverUtils.clickOnElementWithWait(driver, continueSofortBtn);
	    WebDriverUtils.enterTextBox(driver, userIdSofortield, userIdValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, pinSofortField, pinValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);	
		WebDriverUtils.clickOnElementWithWait(driver, checkBankAccountSofort);
		WebDriverUtils.scroll300(driver, continueSofortBtn);
		WebDriverUtils.clickOnElementWithWait(driver, continueSofortBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, continueSofortBtn);
		WebDriverUtils.enterTextBox(driver, transactionSofortField, transactionId);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, continueSofortBtn);
	}
	
	public void setDetailsSofortDE(String bankName, String userIdValue, String pinValue, String transactionId) {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	    WebDriverUtils.enterTextBox(driver, bankNameField, bankName);
	    WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	    WebDriverUtils.clickOnElementWithWait(driver, continueSofortBtn);
	    WebDriverUtils.enterTextBox(driver, userIdSofortield, userIdValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, pinSofortField, pinValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);	
		WebDriverUtils.clickOnElementWithWait(driver, checkBankAccountSofort);
		WebDriverUtils.scroll300(driver, continueSofortBtn);
		WebDriverUtils.clickOnElementWithWait(driver, continueSofortBtnDE);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, continueSofortBtnDE);
		WebDriverUtils.enterTextBox(driver, transactionSofortField, transactionId);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, continueSofortBtn);
	}
	
	public void enterValuesId(String userIdValue, String pinValue) {
		WebDriverUtils.enterTextBox(driver, userIdSofortield, userIdValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, pinSofortField, pinValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public void checkBankAccount() {
		WebDriverUtils.clickOnElementWithWait(driver, checkBankAccountSofort);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public void scrollContinueSofort() {
	WebDriverUtils.scroll300(driver, continueSofortBtn);
	WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public void enterTransactionId(String transactionId) {
		WebDriverUtils.enterTextBox(driver, transactionSofortField, transactionId);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	public void enterTransactionIdDE(String transactionId) {
		WebDriverUtils.enterTextBox(driver, transactionSofortFieldDE, transactionId);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	public void clickIngICon() {
		WebDriverUtils.scroll350Down(driver, ingIcon);
		WebDriverUtils.clickOnElementWithWait(driver, ingIcon);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public void chooseOpen() {
		WebDriverUtils.clickOnElementWithWait(driver, openSelectionIdeal);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, IdealfinishBtn);
	}
	
	public void enterbankGiropay(String bank) {
		WebDriverUtils.enterTextBox(driver, bankNameGiropayFiled, bank);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public MyAccountPage returnMyAccountPage() {
		WebDriverUtils.clickOnElementWithWait(driver, createAccountBtn);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myAccountText));
		return new MyAccountPage(driver);
	}
}
