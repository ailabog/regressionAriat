package com.ariat.Pages.Header;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Pages.Main.CreateAccountPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.OrderDetailsPage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Page that contains all the elements for Sign In page and its methods:
 * returning customer, create account, forgot password & check order & links to
 * Create Account page
 * 
 * @author aila.bogasieru@ariat.com
 * 
 */

public class SignInPage extends BasePage {

	public static final Logger logger = LoggerFactory.getLogger(SignInPage.class);

	private By addressEmailTextBoxUS = By.xpath("//input[@placeholder='Email Address (Required)']");
	private By addressEmailTextBoxUK = By.xpath("//input[@placeholder='Email address']");
	private By emailAddressTextBoxDE = By.xpath("//input[@placeholder='E-Mail-Adresse (Erforderlich)']");
	private By emailAddressTextBoxFR = By.xpath("//input[@placeholder='Adresse courriel (Requis)']");
	// Search for Products
	private By passwordTextBox = By.id("dwfrm_login_password");
	private By checkRememberMe = By.id("dwfrm_login_rememberme");
	private By loginButton = By.name("dwfrm_login_login");
	private By forgotPassword = By.id("password-reset");
	private By emailAddressForgot = By.id("dwfrm_requestpassword_email");
	private By sendForgotButton = By.name("dwfrm_requestpassword_send");
	private By closeForgotButton = By.xpath("//*[@id=\"ext-gen44\"]/body/div[9]/div[1]/a/span");
	private By checkOrderTextBox = By.id("dwfrm_ordertrack_orderNumber");
	private By emailAddressCheckOrderTextBox = By.id("dwfrm_ordertrack_email");
	private By billingCheckOrderTextBoxTextBox = By.id("dwfrm_ordertrack_postalCode");
	private By checkStatusButton = By.name("dwfrm_ordertrack_findorder");
	private By errPassMsg = By.xpath("//*[@id=\"dwfrm_login\"]/div[1]");
	private By createAccountButton = By.name("dwfrm_login_register");
	private By createAccountTitle = By.xpath("//*id='main']/div/div/div/div[1]/h1");
	private By myAccountText = By.xpath("//*[contains(text(), 'My account']");
	private By errorMessageText = By.className("error-form");
	private By closeButton = By.className("close-button");
	private By orderDetailsText = By.xpath("//*[contains[text(),'Order Details']");

	public SignInPage(WebDriver driver) {
		super(driver);
	}

	public void setLoginDetails(String email, String language, String password) {
		switch (language) {
		case "EnglishUK":
			logger.info("Entering information for an existing customer: email address", email);
			WebDriverUtils.enterTextBox(driver, addressEmailTextBoxUK, email);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
			break;

		case "EnglishUS":
			logger.info("Entering information for an existing customer: email address", email);
			WebDriverUtils.enterTextBox(driver, addressEmailTextBoxUS, email);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
			break;
		case "Deutsch":
			logger.info("Entering information for an existing customer: email address", email);
			WebDriverUtils.enterTextBox(driver, emailAddressTextBoxDE, email);
			break;
		case "Francais":
			logger.info("Entering information for an existing customer: email address", email);
			WebDriverUtils.enterTextBox(driver, emailAddressTextBoxFR, email);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
			break;
		default:
			throw new RuntimeException("Language" + language + "not supported");
		}

		logger.info("Entering information for an existing customer: password", password);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, passwordTextBox, password);
		//WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		//WebDriverUtils.clickOnElementWithWait(driver, loginButton);
	}
	
	public void loginClick() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, loginButton);
	}

	public void returningCustomerRememberMe() {
		logger.info("Remeber me");
		WebDriverUtils.clickOnElement(driver, checkRememberMe);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void forgotPasswordClick() {
		logger.info("Forgot password");
		WebDriverUtils.clickOnElementWithWait(driver, forgotPassword);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void forgotPasswordEmail(String email) {
		logger.info("This is my email for which I forgot my passowrd:", email);
		WebDriverUtils.enterTextBox(driver, emailAddressForgot, email);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void ForgotPasswordSend() {
		logger.info("Sending my email so the password is reset");
		WebDriverUtils.clickOnElementWithWait(driver, sendForgotButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void closeForgotPassword() {
		logger.info("Closing the forgot password dialog");
		WebDriverUtils.clickOnElementWithWait(driver, closeButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void closeForgot() {
		logger.info("Closing the forgot password modal");
		WebDriverUtils.clickOnElementWithWait(driver, closeForgotButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void checkOrder(String orderNo, String email, String billing) {
		logger.info("Start entering information to check order", email, billing);
		WebDriverUtils.enterTextBox(driver, checkOrderTextBox, orderNo);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, emailAddressCheckOrderTextBox, email);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, billingCheckOrderTextBoxTextBox, billing);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void checkStatusClick() {
		WebDriverUtils.clickOnElementWithWait(driver, checkStatusButton);
		logger.info("Checking the order status");
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void assertErrorMessage(String messageExpectedLabel) {
		String message = WebDriverUtils.getElementText(driver, errorMessageText);
		assertEquals(message, messageExpectedLabel, "Error! Error message displayed is not correct");
	}

	public void assertMsg(String actualText, String messageExpected) {
		WebDriverUtils.findText(driver, actualText);
		assertEquals(actualText, messageExpected, "Message displayed is correct");
	}

	public void assertErrorMessageInexistingOrderNo(String messageExpectedLabel) {
		String message = WebDriverUtils.getElementText(driver, errorMessageText);
		assertEquals(message, messageExpectedLabel, "Message displayed is ok");
	}

	public void assertWrongPasswordMessage(String passwordExpectedMsg) {
		String passwordMsg = WebDriverUtils.getElementText(driver, errPassMsg);
		assertEquals(passwordMsg, passwordExpectedMsg, "Message displayed is ok");
	}

	public void assertWrongEmailMessage(String emailExpectedMsg) {
		String emailMsg = WebDriverUtils.getElementText(driver, errPassMsg);
		assertEquals(emailMsg, emailExpectedMsg, "Message displayed is ok");
	}

	public CreateAccountPage returnCreateAccountPage() {
		WebDriverUtils.scrollElementToPosition(driver, createAccountButton);
		WebDriverUtils.clickOnElementWithWait(driver, createAccountButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(createAccountTitle));
		return new CreateAccountPage(driver);
	}

	public MyAccountPage returnMyAccountPage() {
		WebDriverUtils.clickOnElementWithWait(driver, loginButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myAccountText));
		return new MyAccountPage(driver);
	}

	public OrderDetailsPage returnOrderDetailsPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, checkStatusButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(orderDetailsText));
		return new OrderDetailsPage(driver);
	}
}
