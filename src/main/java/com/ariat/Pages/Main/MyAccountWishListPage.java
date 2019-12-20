package com.ariat.Pages.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Pages.Main.CreateAccountPage;
import com.ariat.Pages.Main.MyWishListPage;
import com.ariat.Utils.WebDriverUtils;

/**
 * This page is designed implement methods specific to My Account WishList Page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */


public class MyAccountWishListPage extends BasePage {

	public static final Logger logger = LoggerFactory.getLogger(MyAccountWishListPage.class);

	
	private By passwordTextBox = By.id("dwfrm_login_password");
	private By loginButton = By.name("dwfrm_login_login");
	private By createAccountNowButton = By.name("dwfrm_login_register");
	private By createAccountTitle = By.xpath("//*id='main']/div/div/div/div[1]/h1");
	private By findFirstNameWishList = By.id("dwfrm_wishlist_search_firstname");
	private By findLastNameWishList = By.id("dwfrm_wishlist_search_lastname");
	private By findEmailWishList = By.id("dwfrm_wishlist_search_email");
	private By findWishListButton = By.name("dwfrm_wishlist_search_search");
	private By myWishListText = By.xpath("//*contains[text(), 'Wish list']");
	private By addressEmailTextBoxUK = By.xpath("//input[@placeholder='Email address']");
	private By emailAddressTextBoxDE = By.xpath("//input[@placeholder='E-Mail-Adresse (Erforderlich)']");
	private By emailAddressTextBoxFR = By.xpath("//input[@placeholder='Adresse courriel (Requis)']");
	private By addressEmailTextBoxUS = By.xpath("//input[@placeholder='Email Address']");
	
	public MyAccountWishListPage(WebDriver driver) {
		super(driver);

	}

	public void returningCustomer(String email, String language) {
		switch (language) {
		case "EnglishUK":
			logger.info("Entering information for an existing customer: email address", email);
			WebDriverUtils.enterTextBox(driver, addressEmailTextBoxUK, email);
		
			break;
			
		case "EnglishUS":
			logger.info("Entering information for an existing customer: email address", email);
			WebDriverUtils.enterTextBox(driver, addressEmailTextBoxUS, email);
		
			break;
		case "Deutsch":
			logger.info("Entering information for an existing customer: email address", email);
			WebDriverUtils.enterTextBox(driver, emailAddressTextBoxDE, email);
		
			break;
		case "Francais":
			logger.info("Entering information for an existing customer: email address", email);
			WebDriverUtils.enterTextBox(driver, emailAddressTextBoxFR, email);
		
			break;
		default:
			throw new RuntimeException("Language" + language + "not supported");
		}
	}

	public void returningPassword(String password) {
		logger.info("Entering information for an existing customer: password", password);
		WebDriverUtils.enterTextBox(driver, passwordTextBox, password);
	
	}

	public void loginClick() {
		logger.info("Logging into your account...");
		WebDriverUtils.clickOnElementWithWait(driver, loginButton);
	
	}
	
	public void createAccountNowClick() {
		WebDriverUtils.clickOnElementWithWait(driver, createAccountNowButton);
	
	}
	
	public void findWishListFName(String Fname) {
		WebDriverUtils.enterTextBox(driver, findFirstNameWishList, Fname);
	
	}
	
	public void findWishListLName(String Lname) {
		WebDriverUtils.enterTextBox(driver, findLastNameWishList, Lname);

	}
	
	public void findWishListEmail(String email) {
		WebDriverUtils.enterTextBox(driver, findEmailWishList, email);
	
	}
	
	public void findWishListClick() {
		WebDriverUtils.clickOnElementWithWait(driver, findWishListButton);
	
		
	}
	
	public MyWishListPage returnMyWishListPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, loginButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myWishListText));
		return new MyWishListPage(driver);
	}
	
	public CreateAccountPage returnCreateAccountPage() {
		WebDriverUtils.scrollLittDown(driver, createAccountNowButton);
		WebDriverUtils.clickOnElementWithWait(driver, createAccountNowButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(createAccountTitle));
		return new CreateAccountPage(driver);
	}
}
