package com.ariat.Tests.Account.Countries.CreateAccount;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageNO;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.CreateAccountPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.OrderDetailsPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;


/**
 * Test create account by instantiating the browser, go to Home page, and calls
 * all the methods such as: create account, login, check order status for Norway
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class CreateAccountNOTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private CreateAccountPage createAccountPage;
	private HomePage homePage;
	private HomePageNO homePageNO;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private OrderDetailsPage orderDetailsPage;

	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomString(7);
	public static final String BIRTH_MONTH = "March";
	public static final String BIRTH_DAY = "02";

	public static final String EMAIL = GenerateRandomDataUtils.generateEmail(12);
	public static final String PASSWORD = GenerateRandomDataUtils.generateRandomString(10);

	public static final String ORDER_NO = GenerateRandomDataUtils.generateRandomNumber(8);
	public static final String BILLING_ZIP_CODE = GenerateRandomDataUtils.generateRandomNumber(6);

	public static final String ERROR_MESSAGE = "Sorry this order number or postcode does not match our records. Check your records and try again.";
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
    public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority = 0)
	public void createAccountTest() {
		logger.info("Starting create account test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageNO = (HomePageNO) homePage.chooseEULocation(euCountry.NO, euCountry.NO.getCurrencyISO());
		signInPage = homePageNO.returnSignInPage();
		createAccountPage = signInPage.returnCreateAccountPage();
		createAccountPage.createAccount(FIRST_NAME, LAST_NAME, BIRTH_MONTH, BIRTH_DAY, EMAIL, EMAIL, PASSWORD, PASSWORD);
		createAccountPage.createAccountClickWithoutScroll();
	    logger.info("Finishing create new account test...");
	}

	@Test(priority = 1)
	public void returningCustomerTest() {
		logger.info("Starting returning customer test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageNO = (HomePageNO) homePage.chooseEULocation(euCountry.NO, euCountry.NO.getCurrencyISO());
		signInPage = homePageNO.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		logger.info("Finishing returning customer test...");
	}

	@Test(priority = 2)
	public void checkInvalidOrderTest() {
		logger.info("Starting checking invalid order test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageNO = (HomePageNO) homePage.chooseEULocation(euCountry.NO, euCountry.NO.getCurrencyISO());
		signInPage = homePageNO.returnSignInPage();
		signInPage.checkOrder(ORDER_NO, EMAIL, BILLING_ZIP_CODE);
		signInPage.checkStatusClick();
		signInPage.assertErrorMessageInexistingOrderNo(ERROR_MESSAGE);
		logger.info("Finishing checking invalid order test...");
	}
	
	@Test(priority = 3)
	public void checkValidOrderTest() {
		logger.info("Starting checking valid order test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageNO = (HomePageNO) homePage.chooseEULocation(euCountry.NO, euCountry.NO.getCurrencyISO());
		signInPage = homePageNO.returnSignInPage();
		signInPage.checkOrder("10002432", "aila.bogasieru@ariat.com", "35435");
		orderDetailsPage = signInPage.returnOrderDetailsPage();
		logger.info("Finishing checking valid order test...");
	}
	
	
	@Test(priority = 4)
	public void forgotPasswordTest() {
		logger.info("Starting forgot password test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageNO = (HomePageNO) homePage.chooseEULocation(euCountry.NO, euCountry.NO.getCurrencyISO());
		signInPage = homePageNO.returnSignInPage();
		signInPage.forgotPasswordEmail(EMAIL);
		logger.info("Finishing forgot password test...");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageNO.quit();
		signInPage.quit();
		createAccountPage.quit();
		myAccountPage.quit();
		orderDetailsPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
