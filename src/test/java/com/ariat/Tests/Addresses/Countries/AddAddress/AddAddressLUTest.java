package com.ariat.Tests.Addresses.Countries.AddAddress;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageLU;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.AddAddressesPage;
import com.ariat.Pages.Main.AddressesPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.GenerateRandomDataUtils;


/**
 * Adds a new address and checks the address was created for Denmark
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class AddAddressLUTest extends BaseTest {

	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageLU homePageLU;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private AddAddressesPage addAddressPage;
	private AddressesPage addressesPage;
	private EUCountries euCountry;
	private Environments environment;

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

	@Test
	public void addAddressLUTest() {
		logger.info("Starting add address Luxembourg test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageLU = (HomePageLU) homePage.chooseEULocation(euCountry.LU, euCountry.LU.getCurrencyISO());
		signInPage = homePageLU.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addAddressPage = myAccountPage.returnAddAddressesPageMiddleNav();
		addAddressPage.setDetailsAddress("A", "B", "Basarabia Blvd, No 62", CITY, "Belgium", POST_CODE, PHONE, ADDRESS_ID);
		addressesPage = addAddressPage.returnAddressesPageWithoutScroll();
		addressesPage.checkAddress(ADDRESS_ID);
		logger.info("Finishing add address Luxembourg test");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageLU.quit();
		signInPage.quit();
		myAccountPage.quit();
		addAddressPage.quit();
		addressesPage.quit();
	}
}