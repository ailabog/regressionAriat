package com.ariat.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Pages.Main.AddACreditCardPage;
import com.ariat.Pages.Main.AddAddressesPage;
import com.ariat.Pages.Main.AddressesPage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Pages.Main.EmailPreferencePage;
import com.ariat.Pages.Main.LogoutPage;
import com.ariat.Pages.Main.MyOrdersPage;
import com.ariat.Pages.Main.MyWishListPage;
import com.ariat.Pages.Main.OrderDetailsPage;
import com.ariat.Pages.Main.PaymentInformationPage;
import com.ariat.Pages.Main.PersonalnformationPage;
import com.ariat.Utils.WebDriverUtils;

/**
 * This contains My Account page' locators, methods and links with pages:
 * EditProfilePage, EmailPreferencePage, AddressesPage, MyOrdersPage,
 * PaymentInformationPage, MyWishListPage, LogoutPage, AddAddressesPage,
 * AddACreditCardPage from My Account core page and from left navigation
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MyAccountPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(MyAccountPage.class);

	private By logout = By.xpath("//a[text()='Log out']");
	private By signIn = By.xpath("//a[text()= 'Sign In']");
	private By personalInfoLink = By.xpath("//a[text()= 'Personal Information']");
	private By personalInfoText = By.xpath("//*[contains(text(),'Personal Information']");
	private By emailPreferencesText = By.xpath("//*[contains(text(), Email Preferences']");
	private By emailPreferencesLink = By.xpath("//a[text()='Email Preferences']");
	private By addressesText = By.xpath("//*[contains(text(), 'Addresses']");
	private By addressesLink = By.xpath("//a[text()='Addresses']");
	private By paymentInformationLink = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div/ul/li[5]/a");
	private By paymentInformationText = By.className("//*contains[text(),'Credit card information']");
	private By myOrdersLink = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div/ul/li[6]/a");
	private By noOrdersText = By.className("//*contains[text(), We have no order records for this account.']");
	private By yesOrdersText = By.xpath("//*contains[text(),'My orders']");
	private By orderStatusLink = By.xpath("(//a[contains(text(),'Order Status')])[2]");
	private By orderDetailsMyOrderLink = By.xpath("//*[@id=\"order-items\"]/div[1]/div[3]/a");
	private By orderDetailsMyAccountLink = By.xpath("//div[@id='main']/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div/div[4]/a[2]");
  	private By orderDetailsText = By.xpath("//*contains[text(),'Order details']");
	private By myWishListLink = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div/ul/li[7]/a");
	private By myWishListText = By.xpath("//*contains[text(), 'Wish list']");
	private By myAccountLink = By.xpath("//a[text()='My account']");
	private By editPersonalInfoLink = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/a");
	private By changePasswordLink = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/a");
	private By editEmailPreferenceLink = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/a");
	private By editAddressesLink = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div[3]/div[1]/a");
	private By addAddressLink = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div[3]/div[2]/div[2]/a");
	private By editPaymentInfoLink = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div[4]/div[1]/a");
	private By addCardLink = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div[4]/div[2]/div[2]/a");
	private By viewAllOrdersLink = By.xpath("(//a[contains(text(),'View all')])[50]");
	private By viewAllWishListLink = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div[6]/div[1]/a");
	private By addressesTextfromAddAddresses = By.xpath("//*[contains(text(),'Addresses']");
	private By addCreditCardText = By.xpath("//*[contains(text(),'Add a credit card']");
	private By myEmailPrefText = By.xpath("//*[contains(text(),'Email preferences']");
	private By ordersTopNavLink = By.xpath("//a[text()='Orders']");
	private By accountInfoTopNabLink = By.xpath("//a[text()='Account Info']");
	private By wishListTopNavLink = By.xpath("//a[text()='Wishlist']");
	private By logoutTopNav = By.xpath("//*[@id=\"pg-container\"]/nav/div[1]/div[1]/div[3]/div/div[5]/ul/li[5]/a");

	protected MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public void logout() {
		logger.info("Logging out from the application:");
		WebDriverUtils.clickOnElementWithWait(driver, logout);
	}

	public void myAccountClick() {
		logger.info("Going to My Account page...");
		WebDriverUtils.clickOnElementWithWait(driver, myAccountLink);
	}

	// Links with pages from My account core

	public PersonalnformationPage returnPersonalInfoPageMiddleNav() {
		WebDriverUtils.clickOnElementWithWait(driver, editPersonalInfoLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(personalInfoText));
		return new PersonalnformationPage(driver);
	}

	public PersonalnformationPage returnPersonalInfoPageChangePassMiddleNav() {
		WebDriverUtils.clickOnElementWithWait(driver, changePasswordLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(personalInfoText));
		return new PersonalnformationPage(driver);
	}

	public EmailPreferencePage returnEmailPreferencePageMiddleNav() {
		WebDriverUtils.clickOnElementWithWait(driver, editEmailPreferenceLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myEmailPrefText));
		return new EmailPreferencePage(driver);
	}

	public AddressesPage returnAddressesPageMiddleNav() {
		WebDriverUtils.clickOnElementWithWait(driver, editAddressesLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addressesText));
		return new AddressesPage(driver);
	}

	public AddAddressesPage returnAddAddressesPageMiddleNav() {
		WebDriverUtils.clickOnElementWithWait(driver, addAddressLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addressesTextfromAddAddresses));
		return new AddAddressesPage(driver);
	}

	public PaymentInformationPage returnPaymentInformationPageMiddleNav() {
		WebDriverUtils.clickOnElementWithWait(driver, editPaymentInfoLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(paymentInformationText));
		return new PaymentInformationPage(driver);
	}

	public AddACreditCardPage returnAddACreditCardMiddleNav() {
		WebDriverUtils.clickOnElementWithWait(driver, addCardLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addCreditCardText));
		return new AddACreditCardPage(driver);
	}

	public MyOrdersPage returnMyOrdersPageViewAllMiddleNav() {
		WebDriverUtils.scrollElementToPosition(driver, viewAllOrdersLink);
		WebDriverUtils.clickOnElementWithWait(driver, viewAllOrdersLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(noOrdersText));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(yesOrdersText));
		return new MyOrdersPage(driver);
	}

	public MyOrdersPage returnMyOrdersPageOrderStatusMiddleNav() {
		WebDriverUtils.scrollElementToPosition(driver, orderStatusLink);
		WebDriverUtils.clickOnElementWithWait(driver, orderStatusLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(noOrdersText));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(yesOrdersText));
		return new MyOrdersPage(driver);
	}

	public OrderDetailsPage returnOrderDetailsMyOrdersPageMiddleNav() {
		WebDriverUtils.clickOnElementWithWait(driver, orderDetailsMyOrderLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(orderDetailsText));
		return new OrderDetailsPage(driver);
	}

	public OrderDetailsPage returnOrderDetailsMyAccountPageMiddleNav() {
		WebDriverUtils.scrollElementToPosition(driver, orderDetailsMyAccountLink);
		WebDriverUtils.clickOnElementWithWait(driver, orderDetailsMyAccountLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(orderDetailsText));
		return new OrderDetailsPage(driver);
	}

	public MyWishListPage returnMyWishListPageViewAllMiddleNav() {
		WebDriverUtils.scrolltoElement(driver, viewAllWishListLink);
		WebDriverUtils.clickOnElementWithWait(driver, viewAllWishListLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myWishListText));
		return new MyWishListPage(driver);
	}

//Links with pages from left navigation
	public PersonalnformationPage returnEditProfilePageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, personalInfoLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(personalInfoText));
		return new PersonalnformationPage(driver);
	}

	public EmailPreferencePage returnEmailPreferencePageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, emailPreferencesLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(emailPreferencesText));
		return new EmailPreferencePage(driver);
	}

	public AddressesPage returnAddressesPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, addressesLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addressesText));
		return new AddressesPage(driver);
	}

	public PaymentInformationPage returnPaymentInformationPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, paymentInformationLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(paymentInformationText));
		return new PaymentInformationPage(driver);
	}

	public MyOrdersPage returnMyOrdersPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, myOrdersLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(noOrdersText));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(yesOrdersText));
		return new MyOrdersPage(driver);
	}

	public MyWishListPage returnMyWishListPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, myWishListLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myWishListText));
		return new MyWishListPage(driver);
	}

	public LogoutPage returnLogoutPage() {
		WebDriverUtils.clickOnElementWithWait(driver, logout);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(signIn));
		return new LogoutPage(driver);
	}

//My account right top navigation

	public MyOrdersPage returnMyOrdersPageTopNav() {
		WebDriverUtils.moveToElement(driver, myAccountLink);
		WebDriverUtils.clickOnElementWithWait(driver, ordersTopNavLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(noOrdersText));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(yesOrdersText));
		return new MyOrdersPage(driver);
	}

	public PersonalnformationPage returnPersonalInformationPageTopNav() {
		WebDriverUtils.moveToElement(driver, myAccountLink);
		WebDriverUtils.clickOnElementWithWait(driver, accountInfoTopNabLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(personalInfoText));
		return new PersonalnformationPage(driver);
	}

	public MyWishListPage returnWishListPageTopNav() {
		WebDriverUtils.moveToElement(driver, myAccountLink);
		WebDriverUtils.clickOnElementWithWait(driver, wishListTopNavLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myWishListText));
		return new MyWishListPage(driver);
	}

	public LogoutPage returnLogoutFromMyAccountPageTopNav() {
		WebDriverUtils.moveToElement(driver, myAccountLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(logoutTopNav));
		return new LogoutPage(driver);
	}
}
