package com.ariat.Tests.Checkout.CreateOrder.CustomerOtherPayments;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageIE;
import com.ariat.Pages.Main.CheckoutPage;
import com.ariat.Pages.Main.CheckoutProcessCompletePage;
import com.ariat.Pages.Main.CheckoutProcessPage;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Main.PaymentMethodsCheckoutPage;
import com.ariat.Pages.Products.GlovesProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;

/**
 * Checkout -> Create new order as customer credit card Germany
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class CheckoutCreateOrderCustomerOtherPaymentMethodsIETest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageIE homePageIE;
	private WomenCategoryPage womenCategoryPage;
	private MyBagPage myBagPage;
	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenAccessoriesGlovesPage womenAccessoriesGlovesPage;
	private GlovesProductPage glovesProductPage;
	private SignInPage signInPage;
	private CheckoutPage checkoutPage;
	private CheckoutProcessPage checkoutProcessPage;
	private com.ariat.Pages.Main.MyAccountPage myAccountPage;
	private CheckoutProcessCompletePage checkoutProcessCompletePage;
	private PaymentMethodsCheckoutPage paymentMethodsCheckoutPage;

	public static final String CARD_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String EMAILEXISTENT = "aila.bogasieru@ariat.com";
	public static final String PASSWORDEXISTENT = "Parola12345!";
	
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir") + RELATIV_PATH;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority = 0)
	public void checkoutCreateNewOrderCustomerSofort() {
		logger.info("Starting checkout -> create new order with payment method Sofort test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		signInPage = homePageIE.returnSignInPage();
		signInPage.setLoginDetails(EMAILEXISTENT, "EnglishUK", PASSWORDEXISTENT);
		myAccountPage = signInPage.returnMyAccountPage();
		womenCategoryPage = homePageIE.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.selectAddress();
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.pressPaymentMethods("Sofort");
		paymentMethodsCheckoutPage.reviewOrder();
		checkoutProcessCompletePage = checkoutProcessPage.returnCheckoutProcessCompletePage();
		checkoutProcessCompletePage.enterBankSofort("Demo");
		checkoutProcessCompletePage.continueSofort();
		checkoutProcessCompletePage.enterValuesId("88888888", "1234");
		checkoutProcessCompletePage.continueSofort();
		checkoutProcessCompletePage.checkBankAccount();
		checkoutProcessCompletePage.scrollContinueSofort();
		checkoutProcessCompletePage.continueSofort();
		checkoutProcessCompletePage.enterTransactionId("12345");
		checkoutProcessCompletePage.continueSofort();
		logger.info("Finishing checkout -> create new order with payment method Sofort test.");
	}

	@Test(priority = 1)
	public void checkoutCreateNewOrderCustomerGiropay() {
		logger.info("Starting checkout -> create new order with payment method Giropay test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		signInPage = homePageIE.returnSignInPage();
		signInPage.setLoginDetails(EMAILEXISTENT, "EnglishUK", PASSWORDEXISTENT);
		myAccountPage = signInPage.returnMyAccountPage();
		womenCategoryPage = homePageIE.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.selectAddress();
    	paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.pressPaymentMethods("Giropay");
		paymentMethodsCheckoutPage.enterBICGiropay("12345");
		paymentMethodsCheckoutPage.reviewOrder();
		checkoutProcessCompletePage = checkoutProcessPage.returnCheckoutProcessCompletePage();
		checkoutProcessCompletePage.enterbankGiropay("DE11520513735120710131");
		logger.info("Finishing checkout -> create new order with payment method Giropay test.");
	}
	
	@Test(priority = 2)
	public void checkoutCreateNewOrderCustomerKlarna() {
		logger.info("Starting checkout -> create new order with payment method Klarna test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		signInPage = homePageIE.returnSignInPage();
		signInPage.setLoginDetails(EMAILEXISTENT, "EnglishUK", PASSWORDEXISTENT);
		myAccountPage = signInPage.returnMyAccountPage();
		womenCategoryPage = homePageIE.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.selectAddress();
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.pressPaymentMethods("Klarna");
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
		homePageIE.quit();
		womenCategoryPage.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesGlovesPage.quit();
		myAccountPage.quit();
		myBagPage.quit();
		checkoutPage.quit();
		checkoutProcessPage.quit();
    	glovesProductPage.quit();
		paymentMethodsCheckoutPage.quit();
	}
}
