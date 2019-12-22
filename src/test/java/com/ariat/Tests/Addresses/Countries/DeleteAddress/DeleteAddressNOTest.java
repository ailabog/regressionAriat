package com.ariat.Tests.Addresses.Countries.DeleteAddress;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageNO;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.AddAddressesPage;
import com.ariat.Pages.Main.AddressesPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;


/**
 * Delete address test Norway
 * 
 * @author aila.bogasieru@ariat.com
 *
 */


public class DeleteAddressNOTest extends BaseTest {

	private HomePage homePage;
	private HomePageNO homePageNO;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private AddAddressesPage addAddressPage;
	private AddressesPage addressesPage;
	private Environments environment;
	private EUCountries euCountry;

	public static final String ADDRESS = GenerateRandomDataUtils.generateRandomString(5);
	public static final String CITY = GenerateRandomDataUtils.generateRandomString(5);
	public static final String POST_CODE = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String PHONE = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String ADDRESS_ID = GenerateRandomDataUtils.generateRandomAlphaNumeric(5);
	private static final String EMAIL = "aila.bogasieru@ariat.com";
	private static final String PASSWORD = "Parola12345!";
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority = 0)
	public void deleteAddressNOTest() {
		logger.info("Starting deleting address Norway test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageNO = (HomePageNO) homePage.chooseEULocation(euCountry.NO, euCountry.NO.getCurrencyISO());
		signInPage = homePageNO.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addressesPage = myAccountPage.returnAddressesPageMiddleNav();
		addressesPage.deleteAddressCreatedNo("nnn");
		addressesPage.deleteAddressCreatedYes("nn");
		addressesPage.checkAddress("nnn");
		logger.info("Finishing deleting address Norway test");
	}

	@Test(priority = 1)
	public void deleteAddressFromEditNOTest() {
		logger.info("Starting deleting address from Edit address Norway test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageNO = (HomePageNO) homePage.chooseEULocation(euCountry.NO, euCountry.NO.getCurrencyISO());
		signInPage = homePageNO.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addressesPage = myAccountPage.returnAddressesPageMiddleNav();
		addAddressPage = addressesPage.returnAddressesEdit();
		addressesPage = addAddressPage.returnAddressesFromEditDeletePage();
		addressesPage.checkAddress("ccc");
		logger.info("Finishing deleting address from Edit address Norway test");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageNO.quit();
		homePageUK.quit();
		signInPage.quit();
		myAccountPage.quit();
		addressesPage.quit();
		addAddressPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}