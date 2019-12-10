package com.ariat.Tests.Addresses.Countries.LoadMoreAddresses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageDE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.AddressesPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.GenerateRandomDataUtils;


/**
 * Load addresses test Deutschland
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class LoadMoreAddressDETest extends BaseTest {

	private HomePage homePage;
	private HomePageDE homePageDE;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private AddressesPage addressesPage;
	private Environments environment;
	private EUCountries euCountry;

	public static final String ADDRESS = GenerateRandomDataUtils.generateRandomString(5);
	public static final String CITY = GenerateRandomDataUtils.generateRandomString(5);
	public static final String POST_CODE = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String PHONE = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String ADDRESS_ID = GenerateRandomDataUtils.generateRandomAlphaNumeric(5);
	private static final String EMAIL = "aila.bogasieru@yahoo.com";
	private static final String PASSWORD = "Parola12345!";
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority = 0)
	public void loadMoreAddressesFromEditDETest() {
		logger.info("Starting load more addresses Deutschland test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		signInPage = homePageDE.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "Deutsch", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addressesPage = myAccountPage.returnAddressesPageMiddleNav();
		addressesPage.loadMoreAddessesDE();
		logger.info("Finishing load more addresses Deutschland test");
	}
	
	@Test(priority = 1)
	public void loadMoreAddressesLeftNavigationDETest() {
		logger.info("Starting load more addresses left navigation Deutschland test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		signInPage = homePageDE.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "Deutsch", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addressesPage = myAccountPage.returnAddressesPageLeftNavDE();
		addressesPage.loadMoreAddessesDE();
		logger.info("Finishing load more addresses lef navigation Deutschland test");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageDE.quit();
		homePageUK.quit();
		signInPage.quit();
		myAccountPage.quit();
		addressesPage.quit();
	}
}