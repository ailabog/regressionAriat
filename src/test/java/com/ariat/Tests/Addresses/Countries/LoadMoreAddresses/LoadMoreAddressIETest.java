package com.ariat.Tests.Addresses.Countries.LoadMoreAddresses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageIE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.AddressesPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.GenerateRandomDataUtils;


/**
 * Load addresses test Ireland
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class LoadMoreAddressIETest extends BaseTest {

	private HomePage homePage;
	private HomePageIE homePageIE;
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
	public void loadMoreAddressesFromEditIETest() {
		logger.info("Starting load more addresses Ireland test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		signInPage = homePageIE.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addressesPage = myAccountPage.returnAddressesPageMiddleNav();
		addressesPage.loadMoreAddesses();
		logger.info("Finishing load more addresses Ireland test");
	}
	
	@Test(priority = 1)
	public void loadMoreAddressesLeftNavigationIETest() {
		logger.info("Starting load more addresses left navigation Ireland test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		signInPage = homePageIE.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addressesPage = myAccountPage.returnAddressesPageLeftNav();
		addressesPage.loadMoreAddesses();
		logger.info("Finishing load more addresses lef navigation Ireland test");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageIE.quit();
		homePageUK.quit();
		signInPage.quit();
		myAccountPage.quit();
		addressesPage.quit();
	}
}