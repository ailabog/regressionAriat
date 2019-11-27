package com.ariat.Tests.Checkout.CreateOrder.GuestOtherPaymentMethods;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageDE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.CheckoutPage;
import com.ariat.Pages.Main.CheckoutProcessCompletePage;
import com.ariat.Pages.Main.CheckoutProcessPage;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Main.PaymentMethodsCheckoutPage;
import com.ariat.Pages.Products.GlovesProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;

/**
 * Checkout -> Create new order other payment methods: Klarna, Sofort, Giropay
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class CheckoutCreateOrderGuestOtherPaymentMethodsDETest extends BaseTest {

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
	private CheckoutProcessCompletePage checkoutProcessCompletePage;
	private PaymentMethodsCheckoutPage paymentMethodsCheckoutPage;

	public static final String CARD_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS = GenerateRandomDataUtils.generateRandomString(5);
	public static final String ADDRESS1 = GenerateRandomDataUtils.generateRandomString(5);
	public static final String CITY = "Frankfurt";
	public static final String COUNTRY = "Deutschland";
	public static final String ZIP_CODE = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String MOBILE = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String EMAIL = "aila.bogasieru@ariat.com";
	public static final String PASSWORD = GenerateRandomDataUtils.generateRandomString(10);

	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir") + RELATIV_PATH;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority = 0)
	public void checkoutCreateNewOrderGuestOtherPaymentMethodsSofort() {
		logger.info("Starting checkout -> create new order with payment method Sofort test...");
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
		paymentMethodsCheckoutPage = checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.pressPaymentMethods("Ideal");
		paymentMethodsCheckoutPage.reviewOrder();
		checkoutProcessCompletePage = checkoutProcessPage.returnCheckoutProcessCompletePage();
		checkoutProcessCompletePage.enterBankSofort("Demo");
		checkoutProcessCompletePage.continueSofort();
		checkoutProcessCompletePage.enterValuesId("88888888", "1234");
		checkoutProcessCompletePage.continueSofort();
		checkoutProcessCompletePage.checkBankAccount();
		checkoutProcessCompletePage.scrollContinueSofort();
		checkoutProcessCompletePage.continueSofort();
		checkoutProcessCompletePage.enterTransactionIdDE("12345");
		checkoutProcessCompletePage.continueSofort();
		logger.info("Finishing checkout -> create new order with payment method Sofort test.");
	}

	@Test(priority = 1)
	public void checkoutCreateNewOrderGuestOtherPaymentMethodsGiropay() {
		logger.info("Starting checkout -> create new order with payment method Giropay test...");
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
		paymentMethodsCheckoutPage = checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.pressPaymentMethods("Giropay");
		paymentMethodsCheckoutPage.enterBICGiropay("12345");
		paymentMethodsCheckoutPage.reviewOrder();
		checkoutProcessCompletePage = checkoutProcessPage.returnCheckoutProcessCompletePage();
		checkoutProcessCompletePage.enterbankGiropay("DE11520513735120710131");
		logger.info("Finishing checkout -> create new order with payment method Giropay test.");
	}

	@Test(priority = 2)
	public void checkoutCreateNewOrderGuestOtherPaymentMethodsKlarna() {
		logger.info("Starting checkout -> create new order with payment method Klarna test...");
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
		paymentMethodsCheckoutPage = checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.pressPaymentMethods("Klarna");
		paymentMethodsCheckoutPage.enterBICGiropay("12345");
		paymentMethodsCheckoutPage.reviewOrder();
		paymentMethodsCheckoutPage.dateofBirthKlarna("12012019");
		paymentMethodsCheckoutPage.continueKlarna();
		checkoutProcessCompletePage = checkoutProcessPage.returnCheckoutProcessCompletePage();
		logger.info("Finishing checkout -> create new order with payment method Klarna test.");
	} 

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageDE.quit();
		womenCategoryPage.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesGlovesPage.quit();
		glovesProductPage.quit();
		myBagPage.quit();
		checkoutPage.quit();
		checkoutProcessPage.quit();
		checkoutProcessCompletePage.quit();
		paymentMethodsCheckoutPage.quit();
	}
}
