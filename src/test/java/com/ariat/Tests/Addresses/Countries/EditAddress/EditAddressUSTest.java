package com.ariat.Tests.Addresses.Countries.EditAddress;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageUS;
import com.ariat.Pages.Main.AddAddressesPage;
import com.ariat.Pages.Main.AddressesPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.GenerateRandomDataUtils;


/**
 * Edit address test United States
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class EditAddressUSTest extends BaseTest {

	private HomePage homePage;
	private HomePageUS homePageUS;
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
	public static final String ADDRESS_ID = GenerateRandomDataUtils.generateRandomAlphaNumeric(5);
	private static final String EMAIL = "aila.bogasieru@yahoo.com";
	private static final String PASSWORD = "Parola12345!";
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
    public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
			
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	/*@Test
	public void editAddressUSTest() {
		logger.info("Starting edit address US test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		signInPage = homePageUS.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addressesPage= myAccountPage.returnAddressesPageMiddleNav();
		addressesPage.editAddressCreated("AFA25");
		addAddressPage = addressesPage.returnAddressesEdit();
		addAddressPage.clearAddressId();
		addAddressPage.enterAddressId("AFA251");
		addressesPage = addAddressPage.returnAddressesSaveFromEditPage();
		//addressesPage.checkAddress("B1TGL1");
		logger.info("Finishing edit address US test");
	}*/
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUS.quit();
		homePageUK.quit();
		signInPage.quit();
		myAccountPage.quit();
		addAddressPage.quit();
		addressesPage.quit();
	}	
}