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
import com.ariat.Pages.HomePagesCountries.HomePageBE;
import com.ariat.Pages.Main.CheckoutPage;
import com.ariat.Pages.Main.CheckoutProcessPage;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Main.PaymentMethodsCheckoutPage;
import com.ariat.Pages.Products.GlovesProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;

/**
 * Checkout -> Create new order
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class CheckoutCreateOrderGuestCreditCardBETest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageBE homePageBE;
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
	public static final String CITY = "Brussels";
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
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		womenCategoryPage = homePageBE.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.setInfoAccountSecureCheckoutBelgium(FIRST_NAME, LAST_NAME, ADDRESS, CITY, ZIP_CODE, MOBILE, EMAIL);
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.setPaymentDetailsSecureCheckout(CARD_NAME, typeCard.MASTER_CARD.getNumber(), typeCard.MASTER_CARD.getCvs());
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
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		womenCategoryPage = homePageBE.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.setInfoAccountSecureCheckoutBelgium(FIRST_NAME, LAST_NAME, ADDRESS, CITY, ZIP_CODE, MOBILE, EMAIL);
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.setPaymentDetailsSecureCheckout(CARD_NAME, typeCard.MASTER_CARD.getNumber(), typeCard.MASTER_CARD.getCvs());
		paymentMethodsCheckoutPage.reviewOrder();
		paymentMethodsCheckoutPage.reviewOrder();
		logger.info("Finishing checkout -> create new order without being logged credit card Visa test.");
	} 
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageBE.quit();
		womenCategoryPage.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesGlovesPage.quit();
		myBagPage.quit();
		checkoutProcessPage.quit();
		checkoutPage.quit();
		glovesProductPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
