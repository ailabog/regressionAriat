package com.ariat.Tests.Checkout.NegativeCreateOrder;

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
import com.ariat.Pages.HomePagesCountries.HomePageFI;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.CheckoutPage;
import com.ariat.Pages.Main.CheckoutProcessCompletePage;
import com.ariat.Pages.Main.CheckoutProcessPage;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Main.PaymentMethodsCheckoutPage;
import com.ariat.Pages.Products.GlovesProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;

/**
 * Checkout -> Negative Create new order
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class NegativeCheckoutCreateOrderFITest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageFI homePageFI;
	private WomenCategoryPage womenCategoryPage;
	private MyBagPage myBagPage;
	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenAccessoriesGlovesPage womenAccessoriesGlovesPage;
	private GlovesProductPage glovesProductPage;
	private CheckoutPage checkoutPage;
	private CheckoutProcessPage checkoutProcessPage;
	private CheckoutProcessCompletePage checkoutProcessCompletePage;
	private com.ariat.Pages.Main.MyAccountPage myAccountPage;
	private PaymentMethodsCheckoutPage paymentMethodsCheckoutPage;

	public static final String CARD_NAME = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String ADDRESS = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String CITY = "24534543";
	public static final String COUNTRY = "United Kingdom";
	public static final String ZIP_CODE = GenerateRandomDataUtils.generateRandomString(5);
	public static final String MOBILE = GenerateRandomDataUtils.generateRandomString(7);
	public static final String EMAIL = GenerateRandomDataUtils.generateRandomNumber(12);
	public static final String PASSWORD = GenerateRandomDataUtils.generateRandomString(10);
	public static final String EMAILEXISTENT = "aila.bogasieru@ariat.com";
	public static final String PASSWORDEXISTENT = "Parola12345!";
	private ListOfCreditCards typeCard;
	private static final String YEAR = "2023";
	private static final String MONTH = "January";
	public static final String CARD_NAME1 = GenerateRandomDataUtils.generateRandomString(5);
	public static final String FIRST_NAME1 = GenerateRandomDataUtils.generateRandomString(5);
	public static final String LAST_NAME1 = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS1 = GenerateRandomDataUtils.generateRandomString(5);

	public static final String ZIP_CODE1 = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String MOBILE1 = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String ERROR_ORDER_NOT_PLACED ="We're sorry that your order could not be placed. This probably happened due to a high order volume or temporary connection errors. Please wait a few minutes and resubmit your order. We won't process your payment until you successfully place your order. If you have further questions, please contact us.";

	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority=0)
	public void checkoutNegativeCreateOrderInvalidShippingAddress() {
		logger.info("Starting checkout -> create negative order invalid shipping address...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFI = (HomePageFI) homePage.chooseEULocation(euCountry.FI, euCountry.FI.getCurrencyISO());
		womenCategoryPage = homePageFI.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.setInfoAccountSecureCheckoutUK(FIRST_NAME, LAST_NAME, ADDRESS, CITY, ZIP_CODE, MOBILE, EMAIL);
		logger.info("Finishing checkout -> create negative order invalid shipping address.");
	}

	@Test(priority = 1)
	public void checkoutNegativeCreateOrderInvalidPaymentsDetails() {
		logger.info("Starting checkout -> create negative order invalid payment details...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFI = (HomePageFI) homePage.chooseEULocation(euCountry.FI, euCountry.FI.getCurrencyISO());
		womenCategoryPage = homePageFI.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.setInfoAccountSecureCheckoutUK(FIRST_NAME1, LAST_NAME1, ADDRESS, CITY, ZIP_CODE, MOBILE1, EMAILEXISTENT);
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.enterCardNameNotlogged(CARD_NAME);
		paymentMethodsCheckoutPage.enterCardNo(typeCard.INVALID_CARD.getNumber());
		paymentMethodsCheckoutPage.selectTypeCardMasterCard();
		paymentMethodsCheckoutPage.selectExpirationMonth();
		paymentMethodsCheckoutPage.selectExpirationYear();
		paymentMethodsCheckoutPage.enterSecurityCode(typeCard.INVALID_CARD.getCvs());
		checkoutProcessCompletePage = checkoutProcessPage.returnCheckoutProcessCompletePage();
		checkoutProcessCompletePage.assertErrMsgOrderNotPlaced(ERROR_ORDER_NOT_PLACED);
		logger.info("Finishing checkout -> create negative order invalid payment details.");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageFI.quit();
		womenCategoryPage.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesGlovesPage.quit();
		myBagPage.quit();
		checkoutProcessPage.quit();
		checkoutPage.quit();
		checkoutProcessCompletePage.quit();
		glovesProductPage.quit();
		myAccountPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
