package com.ariat.Tests.MyAccount.Countries.EmailPreferences;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageFR;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.EmailPreferencePage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.KillChrome;
import com.ariat.Pages.Header.SignInPage;

/**
 * EmailPreferences France test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */


public class EmailPreferencesFRTest extends BaseTest {

	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageFR homePageFR;
	private Environments environment;
	private EUCountries euCountry;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private EmailPreferencePage emailPreferencesPage;
	

	private static final String EMAIL = "aila.bogasieru@ariat.com";
	private static final String PASSWORD = "Parola12345!";
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test
	public void updatePersonalInformationTest() {
		logger.info("Starting update personal information test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "Francais", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		emailPreferencesPage = myAccountPage.returnEmailPreferencePageLeftNavFR();
		emailPreferencesPage.ariatProductsCheck("FASHION");
		emailPreferencesPage.saveEditsClick();
		logger.info("Update personal information test ended...");
	}
	
	@AfterMethod
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageFR.quit();
		signInPage.quit();
		myAccountPage.quit();
		emailPreferencesPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
