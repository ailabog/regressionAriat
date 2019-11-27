package com.ariat.Tests.Checkout.CreateOrder.GuestCreditCard;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Enums.ListOfCreditCards;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageDE;
import com.ariat.Pages.Main.CheckoutPage;
import com.ariat.Pages.Main.CheckoutProcessPage;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Main.PaymentMethodsCheckoutPage;
import com.ariat.Pages.Products.GlovesProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;

/**
 * Checkout -> Create new order
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class CheckoutCreateOrderGuestCreditCardDETest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageDE homePageDE;
	private WomenCategoryPage womenCategoryPage;
	private MyBagPage myBagPage;
	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenAccessoriesGlovesPage womenAccessoriesGlovesPage;
	private GlovesProductPage glovesProductPage;
	private CheckoutPage checkoutPage;
	private CheckoutProcessPage checkoutProcessPage;
	private PaymentMethodsCheckoutPage paymentMethodsCheckoutPage;

	public static final String CARD_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS = GenerateRandomDataUtils.generateRandomString(5);
	public static final String ADDRESS1 = GenerateRandomDataUtils.generateRandomString(5);
	public static final String CITY = "Frankfurt";
	public static final String ZIP_CODE = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String MOBILE = GenerateRandomDataUtils.generateRandomNumber(7);
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
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		womenCategoryPage = homePageDE.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPageDE();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPageDE();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.enterFName(FIRST_NAME);
		checkoutProcessPage.enterLName(LAST_NAME);
		checkoutProcessPage.enterAddress(ADDRESS);
		checkoutProcessPage.enterAddress1(ADDRESS1);
		checkoutProcessPage.selectArrow();
		checkoutProcessPage.selectCountry("Deutschland");
		checkoutProcessPage.enterCity(CITY);
		checkoutProcessPage.enterZipCode(ZIP_CODE);
		checkoutProcessPage.enterMobile(MOBILE);
		checkoutProcessPage.enterEmail(EMAIL);
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.enterCardNameNotlogged(CARD_NAME);
		paymentMethodsCheckoutPage.enterCardNo(typeCard.MASTER_CARD.getNumber());
		paymentMethodsCheckoutPage.selectExpirationMonthDE();
		paymentMethodsCheckoutPage.selectExpirationYear();
		paymentMethodsCheckoutPage.enterSecurityCode(typeCard.MASTER_CARD.getCvs());
		paymentMethodsCheckoutPage.reviewOrder();
		paymentMethodsCheckoutPage.reviewOrder();
		logger.info("Finishing checkout -> create new order without being logged cardc Master Card test.");
	} 
	
	@Test(priority = 1)
	public void checkoutCreateNewOrderNotBeingLoggedVisa() {
		logger.info("Starting checkout -> create new order without being logged credit card Visa test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		womenCategoryPage = homePageDE.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPageDE();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPageDE();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.enterFName(FIRST_NAME);
		checkoutProcessPage.enterLName(LAST_NAME);
		checkoutProcessPage.enterAddress(ADDRESS);
		checkoutProcessPage.enterAddress1(ADDRESS1);
		checkoutProcessPage.selectArrow();
		checkoutProcessPage.selectCountry("Deutschland");
		checkoutProcessPage.enterCity(CITY);
		checkoutProcessPage.enterZipCode(ZIP_CODE);
		checkoutProcessPage.enterMobile(MOBILE);
		checkoutProcessPage.enterEmail(EMAIL);
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.enterCardNameNotlogged(CARD_NAME);
		paymentMethodsCheckoutPage.enterCardNo(typeCard.MASTER_CARD.getNumber());
		paymentMethodsCheckoutPage.selectExpirationMonthDE();
		paymentMethodsCheckoutPage.selectExpirationYear();
		paymentMethodsCheckoutPage.enterSecurityCode(typeCard.MASTER_CARD.getCvs());
		paymentMethodsCheckoutPage.reviewOrder();
		paymentMethodsCheckoutPage.reviewOrder();
		logger.info("Finishing checkout -> create new order without being logged credit card Visa test.");
	} 
	
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageDE.quit();
		womenCategoryPage.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesGlovesPage.quit();
		myBagPage.quit();
		checkoutPage.quit();
		glovesProductPage.quit();
		checkoutProcessPage.quit();
		paymentMethodsCheckoutPage.quit();
	}
}
