package com.ariat.Tests.Checkout.CreateOrder.CustomerCreditCard;

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
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.CheckoutPage;
import com.ariat.Pages.Main.CheckoutProcessPage;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Main.PaymentMethodsCheckoutPage;
import com.ariat.Pages.Products.GlovesProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;

/**
 * Checkout -> Create new order customer credit cards UK
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class CheckoutCreateOrderCustomerCreditCardUKTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private WomenCategoryPage womenCategoryPage;
	private MyBagPage myBagPage;
	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenAccessoriesGlovesPage womenAccessoriesGlovesPage;
	private GlovesProductPage glovesProductPage;
	private SignInPage signInPage;
	private CheckoutPage checkoutPage;
	private CheckoutProcessPage checkoutProcessPage;
	private com.ariat.Pages.Main.MyAccountPage myAccountPage;
	private PaymentMethodsCheckoutPage paymentMethodsCheckoutPage;

	public static final String CARD_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String CITY = "London";
	public static final String COUNTRY = "United Kingdom";
	public static final String EMAILEXISTENT = "aila.bogasieru@ariat.com";
	public static final String PASSWORDEXISTENT = "Parola12345!";
	private ListOfCreditCards typeCard;

	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir") + RELATIV_PATH;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority = 0)
	public void checkoutCreateNewOrderBeingLoggedMasterCard() {
		logger.info("Starting checkout -> create new order being logged credit card Master Card test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		signInPage = homePageUK.returnSignInPage();
		signInPage.setLoginDetails(EMAILEXISTENT, "EnglishUK", PASSWORDEXISTENT);
		myAccountPage = signInPage.returnMyAccountPage();
		womenCategoryPage = myAccountPage.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.selectAddress();
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.setSecurityCodePaymentMethodLogged(typeCard.MASTER_CARD.getCvs());
		paymentMethodsCheckoutPage.reviewOrder();
		paymentMethodsCheckoutPage.reviewOrder();
		logger.info("Finishing checkout -> create new order being logged credit card Master Card test.");
	}

	@Test(priority = 1)
	public void checkoutCreateNewOrderBeingLoggedVisa() {
		logger.info("Starting checkout -> create new order being logged credit card Visa test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		signInPage = homePageUK.returnSignInPage();
		signInPage.setLoginDetails(EMAILEXISTENT, "EnglishUK", PASSWORDEXISTENT);
		myAccountPage = signInPage.returnMyAccountPage();
		womenCategoryPage = homePageUK.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.selectAddress();
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.setSecurityCodePaymentMethodLogged(typeCard.VISA.getCvs());
		paymentMethodsCheckoutPage.reviewOrder();
		paymentMethodsCheckoutPage.reviewOrder();
		logger.info("Finishing checkout -> create new order being logged credit card Visa test.");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		womenCategoryPage.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesGlovesPage.quit();
		myBagPage.quit();
		checkoutProcessPage.quit();
		paymentMethodsCheckoutPage.quit();
		checkoutPage.quit();
		glovesProductPage.quit();
		myAccountPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
