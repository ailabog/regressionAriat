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
import com.ariat.Pages.HomePagesCountries.HomePageBE;
import com.ariat.Pages.Main.CheckoutPage;
import com.ariat.Pages.Main.CheckoutProcessCompletePage;
import com.ariat.Pages.Main.CheckoutProcessPage;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Main.PaymentMethodsCheckoutPage;
import com.ariat.Pages.Products.GlovesProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;

/**
 * Checkout -> Create new order as customer credit card Belgium
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class CheckoutCreateOrderCustomerOtherPaymentMethodsBETest extends BaseTest {

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
		logger.info("Starting checkout -> Create new order customer Sofort test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		signInPage = homePageBE.returnSignInPage();
		signInPage.returningCustomer(EMAILEXISTENT, "EnglishUK");
		signInPage.returningPassword(PASSWORDEXISTENT);
		myAccountPage = signInPage.returnMyAccountPage();
		womenCategoryPage = homePageBE.returnWomenCategoryPage();
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
		checkoutProcessCompletePage.continueSofortBE();
		checkoutProcessCompletePage.enterValuesId("88888888", "1234");
		checkoutProcessCompletePage.continueSofortBE();
		checkoutProcessCompletePage.checkBankAccount();
		checkoutProcessCompletePage.scrollContinueSofort();
		checkoutProcessCompletePage.continueSofortBE();
		checkoutProcessCompletePage.enterTransactionId("12345");
		checkoutProcessCompletePage.continueSofortBE();
		logger.info("Finishing checkout -> Create new order customer Sofort test.");
	}

	@Test(priority = 1)
	public void checkoutCreateNewOrderCustomerIdeal() {
		logger.info("Starting checkout -> Create new order customer Ideal test....");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		signInPage = homePageBE.returnSignInPage();
		signInPage.returningCustomer(EMAILEXISTENT, "EnglishUK");
		signInPage.returningPassword(PASSWORDEXISTENT);
		myAccountPage = signInPage.returnMyAccountPage();
		womenCategoryPage = homePageBE.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.pressPaymentMethods("Ideal");
		paymentMethodsCheckoutPage.reviewOrder();
		checkoutProcessCompletePage = checkoutProcessPage.returnCheckoutProcessCompletePage();
		checkoutProcessCompletePage.clickIngICon();
		checkoutProcessCompletePage.chooseOpen();
		logger.info("Finishing checkout -> Create new order customer Ideal test.");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageBE.quit();
		signInPage.quit();
		myAccountPage.quit();
		womenCategoryPage.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesGlovesPage.quit();
		glovesProductPage.quit();
		myBagPage.quit();
		checkoutPage.quit();
		checkoutProcessPage.quit();
		paymentMethodsCheckoutPage.quit();
		checkoutProcessCompletePage.quit();
	}
}
