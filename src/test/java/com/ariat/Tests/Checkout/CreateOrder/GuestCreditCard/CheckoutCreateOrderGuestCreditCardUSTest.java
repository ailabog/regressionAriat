package com.ariat.Tests.Checkout.CreateOrder.GuestCreditCard;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Enums.ListOfCreditCards;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageUS;
import com.ariat.Pages.Main.CheckoutPage;
import com.ariat.Pages.Main.CheckoutProcessPage;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Main.PaymentMethodsCheckoutPage;
import com.ariat.Pages.Products.BagsProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;

/**
 * Checkout -> Create new order
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class CheckoutCreateOrderGuestCreditCardUSTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageUS homePageUS;
	private MyBagPage myBagPage;
	private BagsProductPage bagsProductPage;
	private CheckoutPage checkoutPage;
	private CheckoutProcessPage checkoutProcessPage;
	private PaymentMethodsCheckoutPage paymentMethodsCheckoutPage;


	public static final String CARD_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS = "W. Adams St.";
	public static final String CITY = "Phoenix";
	public static final String STATE = "Arizona";
	public static final String ZIP_CODE = "85007";
	public static final String MOBILE = "(602) 364-2722";
	public static final String EMAIL = "aila.bogasieru@ariat.com";
	public static final String PASSWORD = GenerateRandomDataUtils.generateRandomString(10);
	private ListOfCreditCards typeCard;

	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
    public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
			
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority = 0)
	public void checkoutCreateNewOrderNotBeingLoggedMasterCard() {
		logger.info("Starting checkout -> create new order without being logged credit card Master Card test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		bagsProductPage = homePageUS.returnBagsProductPage();
		myBagPage = bagsProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.enterFName(FIRST_NAME);
		checkoutProcessPage.enterLName(LAST_NAME);
		checkoutProcessPage.enterAddress(ADDRESS);
		checkoutProcessPage.enterCity(CITY);
		checkoutProcessPage.enterZipCode(ZIP_CODE);
		checkoutProcessPage.selectState();
		checkoutProcessPage.enterMobile(MOBILE);
		checkoutProcessPage.enterEmail(EMAIL);
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.useAddressAsItIs();
		paymentMethodsCheckoutPage.enterCardNameNotlogged(CARD_NAME);
		paymentMethodsCheckoutPage.enterCardNoUS(typeCard.MASTER_CARD.getNumber());
		paymentMethodsCheckoutPage.selectExpirationMonthUS();
		paymentMethodsCheckoutPage.selectExpirationYearUS();
		paymentMethodsCheckoutPage.enterSecurityCode(typeCard.MASTER_CARD.getCvs());
		paymentMethodsCheckoutPage.reviewOrderUS();
		paymentMethodsCheckoutPage.placeOrderUS();
		logger.info("Finishing checkout -> create new order without being logged credit card Master Card test.");
	} 
	
	
	@Test(priority = 1)
	public void checkoutCreateNewOrderNotBeingLoggedVisa() {
		logger.info("Starting checkout -> create new order without being logged credit card Visa test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		bagsProductPage = homePageUS.returnBagsProductPage();
		myBagPage = bagsProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.enterFName(FIRST_NAME);
		checkoutProcessPage.enterLName(LAST_NAME);
		checkoutProcessPage.enterAddress(ADDRESS);
		checkoutProcessPage.enterCity(CITY);
		checkoutProcessPage.enterZipCode(ZIP_CODE);
		checkoutProcessPage.selectState();
		checkoutProcessPage.enterMobile(MOBILE);
		checkoutProcessPage.enterEmail(EMAIL);
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.useAddressAsItIs();
		paymentMethodsCheckoutPage.enterCardNameNotlogged(CARD_NAME);
		paymentMethodsCheckoutPage.enterCardNoUS(typeCard.VISA.getNumber());
		paymentMethodsCheckoutPage.selectExpirationMonthUS();
		paymentMethodsCheckoutPage.selectExpirationYearUS();
		paymentMethodsCheckoutPage.enterSecurityCode(typeCard.VISA.getCvs());
		paymentMethodsCheckoutPage.reviewOrderUS();
		paymentMethodsCheckoutPage.placeOrderUS();
		logger.info("Finishing checkout -> create new order without being logged credit card Visa test.");
	}
	
	@Test(priority = 2)
	public void checkoutCreateNewOrderNotBeingLoggedAmericanExpress() {
		logger.info("Starting checkout -> create new order without being logged credit card American Express test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		bagsProductPage = homePageUS.returnBagsProductPage();
		myBagPage = bagsProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.enterFName(FIRST_NAME);
		checkoutProcessPage.enterLName(LAST_NAME);
		checkoutProcessPage.enterAddress(ADDRESS);
		checkoutProcessPage.enterCity(CITY);
		checkoutProcessPage.enterZipCode(ZIP_CODE);
		checkoutProcessPage.selectState();
		checkoutProcessPage.enterMobile(MOBILE);
		checkoutProcessPage.enterEmail(EMAIL);
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.useAddressAsItIs();
		paymentMethodsCheckoutPage.enterCardNameNotlogged(CARD_NAME);
		paymentMethodsCheckoutPage.enterCardNoUS(typeCard.AMERICAN_EXPRESS.getNumber());
		paymentMethodsCheckoutPage.selectExpirationMonthUS();
		paymentMethodsCheckoutPage.selectExpirationYearUS();
		paymentMethodsCheckoutPage.enterSecurityCode(typeCard.AMERICAN_EXPRESS.getCvs());
		paymentMethodsCheckoutPage.reviewOrderUS();
		paymentMethodsCheckoutPage.placeOrderUS();
		logger.info("Finishing checkout -> create new order without being logged credit card American Express test.");
	} 
	
	@AfterTest
	public void clearBrowserSession() {
		homePage.quit();
		homePageUK.quit();
		homePageUS.quit();
		myBagPage.quit();
		checkoutProcessPage.quit();
		checkoutPage.quit();
    	bagsProductPage.quit();
    	KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
