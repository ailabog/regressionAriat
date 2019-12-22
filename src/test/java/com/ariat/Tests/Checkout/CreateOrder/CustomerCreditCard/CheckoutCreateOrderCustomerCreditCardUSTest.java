package com.ariat.Tests.Checkout.CreateOrder.CustomerCreditCard;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Enums.ListOfCreditCards;
import com.ariat.Pages.Header.SignInPage;
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
 * Checkout -> Create new order customer credit cards US
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class CheckoutCreateOrderCustomerCreditCardUSTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageUS homePageUS;
	private MyBagPage myBagPage;
	private BagsProductPage bagsProductPage;
	private SignInPage signInPage;
	private CheckoutPage checkoutPage;
	private CheckoutProcessPage checkoutProcessPage;
	private com.ariat.Pages.Main.MyAccountPage myAccountPage;
	private PaymentMethodsCheckoutPage paymentMethodsCheckoutPage;

	public static final String CARD_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String ADDRESS = "W. Adams St.";
	public static final String CITY = "Phoenix";
	public static final String STATE = "Arizona";
	public static final String ZIP_CODE = "85007";
	public static final String MOBILE = "(602) 364-2722";

	public static final String EMAILEXISTENT = "aila.bogasieru@yahoo.com";
	public static final String PASSWORDEXISTENT = "Parola12345!";
	private ListOfCreditCards typeCard;


	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
    public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
			
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
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		signInPage = homePageUS.returnSignInPage();
		signInPage.setLoginDetails(EMAILEXISTENT, "EnglishUS", PASSWORDEXISTENT);
		myAccountPage = signInPage.returnMyAccountPage();
		bagsProductPage = homePageUS.returnBagsProductPage();
		myBagPage = bagsProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.selectAddressUS();
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.useAddressAsItIs();
		paymentMethodsCheckoutPage.setSecurityCodePaymentMethodLogged(typeCard.MASTER_CARD.getCvs());
		paymentMethodsCheckoutPage.reviewOrderUS();
		paymentMethodsCheckoutPage.placeOrderUS();
		logger.info("Finishing checkout -> create new order without being logged credit card Master Card test.");
	}
    
    @Test(priority = 1)
   	public void checkoutCreateNewOrderBeingLoggedVisa() {
   		logger.info("Starting checkout -> create new order being logged credit card Visa test...");
   		homePage = new HomePage(new ChromeDriver());
   		homePage.load(environment.DEVELOPMENT.getURL());
   		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
   		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
   		signInPage = homePageUS.returnSignInPage();
   		signInPage.setLoginDetails(EMAILEXISTENT, "EnglishUS", PASSWORDEXISTENT);
   		myAccountPage = signInPage.returnMyAccountPage();
   		bagsProductPage = homePageUS.returnBagsProductPage();
   		myBagPage = bagsProductPage.returnMyBagPage();
   		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.selectAddressUS();
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.useAddressAsItIs();
		paymentMethodsCheckoutPage.setSecurityCodePaymentMethodLogged(typeCard.VISA.getCvs());
		paymentMethodsCheckoutPage.reviewOrderUS();
		paymentMethodsCheckoutPage.placeOrderUS();
		logger.info("Finishing checkout -> create new order without being logged credit card Visa test.");
   	}
    
    @Test(priority = 2)
   	public void checkoutCreateNewOrderBeingLoggedAmericanExpress() {
   		logger.info("Starting checkout -> create new order being logged credit card American Express test...");
   		homePage = new HomePage(new ChromeDriver());
   		homePage.load(environment.DEVELOPMENT.getURL());
   		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
   		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
   		signInPage = homePageUS.returnSignInPage();
   		signInPage.setLoginDetails(EMAILEXISTENT, "EnglishUS", PASSWORDEXISTENT);
   		myAccountPage = signInPage.returnMyAccountPage();
   		bagsProductPage = homePageUS.returnBagsProductPage();
   		myBagPage = bagsProductPage.returnMyBagPage();
   		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.selectAddressUS();
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.useAddressAsItIs();
		paymentMethodsCheckoutPage.setSecurityCodePaymentMethodLogged(typeCard.AMERICAN_EXPRESS.getCvs());
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
		paymentMethodsCheckoutPage.quit();
		checkoutPage.quit();
		bagsProductPage.quit();
		myAccountPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
