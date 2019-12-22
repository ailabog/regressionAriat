package com.ariat.Tests.Account.Countries.NegativeCreateAccount;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageUS;
import com.ariat.Pages.Main.CreateAccountPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;


/**
 * Test negative create account by instantiating the browser, go to Home page,
 * and calls all the methods such as: create account, login, check order status
 * for United States
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class NegativeCreateAccountUSTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private CreateAccountPage createAccountPage;
	private HomePage homePage;
	private HomePageUS homePageUS;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private String loggingMessage = "The email address is invalid.";
	private String missingLoggingValue = "This field is required.";

	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String BIRTH_MONTH = "March";
	public static final String BIRTH_DAY = "02";

	public static final String EMAIL = GenerateRandomDataUtils.generateRandomNumber(12);
	public static final String PASSWORD = GenerateRandomDataUtils.generateRandomString(10);

	public static final String FIRST_NAME1 = "@#$%^&*()";
	public static final String LAST_NAME1 = "@#$%^&*()";
	public static final String EMAIL1 = "@#$%^&*()";
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority = 0)
	public void negativeCreateAccountTest() {
		logger.info("Starting create negative account test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		signInPage = homePageUS.returnSignInPage();
		createAccountPage = signInPage.returnCreateAccountPage();
		createAccountPage.createAccount(FIRST_NAME, LAST_NAME, BIRTH_MONTH, BIRTH_DAY, EMAIL, EMAIL, PASSWORD, PASSWORD);
		createAccountPage.createAccountClick();
		createAccountPage.assertWrongNameCreateAccount(loggingMessage);
		logger.info("Finishing negative create account test...");
	}

	@Test(priority = 1)
	public void negativeCreateAccountTestWildcards() {
		logger.info("Starting create negative account test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		signInPage = homePageUS.returnSignInPage();
		createAccountPage = signInPage.returnCreateAccountPage();
		createAccountPage.createAccount(FIRST_NAME1, LAST_NAME1, BIRTH_MONTH, BIRTH_DAY, EMAIL1, EMAIL1, PASSWORD, PASSWORD);
		createAccountPage.createAccountClick();
		createAccountPage.assertWrongNameCreateAccount(loggingMessage);
		logger.info("Finishing negative create account test...");
	}

	@Test(priority = 2)
	public void negativeCreateAccountTestMissingValues() {
		logger.info("Starting create negative account test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		signInPage = homePageUS.returnSignInPage();
		createAccountPage = signInPage.returnCreateAccountPage();
		createAccountPage.createAccount(FIRST_NAME, LAST_NAME, null, null, null, null, null, null);
		createAccountPage.createAccountClick();
		createAccountPage.asserCreateAccountMissingValues(missingLoggingValue);
		logger.info("Finishing negative create account test...");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageUS.quit();
		signInPage.quit();
		myAccountPage.quit();
		createAccountPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
