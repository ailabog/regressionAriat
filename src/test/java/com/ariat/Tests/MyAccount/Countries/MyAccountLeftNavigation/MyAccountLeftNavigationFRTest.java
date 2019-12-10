package com.ariat.Tests.MyAccount.Countries.MyAccountLeftNavigation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageFR;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;

/**
 * Include tests for My account left navigation France
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MyAccountLeftNavigationFRTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageFR homePageFR;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;

	public static final String EMAIL = "aila.bogasieru@gmail.com";
	public static final String PASSWORD = "Parola12345!";
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}


	@Test(priority = 0)
	public void myAccountAccessPersonalInfoFRTest() {
		logger.info("Starting personal info France test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "Francais", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnEditProfilePageLeftNavFR();
		myAccountPage.myAccountClick();
		myAccountPage.logoutMiddle();
		logger.info("Finishing personal info France test...");
	}

	@Test(priority = 1)
	public void myAccountAccessEmailPrefFRTest() {
		logger.info("Starting email preferences France test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "Francais", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnEmailPreferencePageLeftNavFR();
		myAccountPage.myAccountClick();
		myAccountPage.logoutMiddle();
		logger.info("Finishing email preferences France test...");
	}

	@Test(priority = 2)
	public void myAccountAccessAddressesFRTest() {
		logger.info("Starting addresses France test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "Francais", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnAddressesPageLeftNavFR();
		myAccountPage.myAccountClick();
		myAccountPage.logoutMiddle();
		logger.info("Finishing addresses France test...");
	}

	@Test(priority = 3)
	public void myAccountAccessPaymentInfoFRTest() {
		logger.info("Starting payment info France test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "Francais", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnPaymentInformationPageLeftNavFR();
		myAccountPage.myAccountClick();
		myAccountPage.returnAddACreditCardMiddleNavFR();
		myAccountPage.myAccountClick();
		myAccountPage.logoutMiddle();
		logger.info("Finishing payment info France test...");
	}

	@Test(priority = 4)
	public void myAccountAccessOrdersFRTest() {
		logger.info("Starting orders France test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "Francais", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnMyOrdersPageLeftNavFR();
		myAccountPage.myAccountClick();
		myAccountPage.logoutMiddle();
		logger.info("Finishing orders France test...");
	}

	@Test(priority = 5)
	public void myAccountAccessWishListFRTest() {
		logger.info("Starting wish list France test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "Francais", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnMyWishListPageLeftNavFR();
		myAccountPage.myAccountClick();
		myAccountPage.logoutMiddle();
		logger.info("Finishing wish list France test...");
	} 

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageFR.quit();
		signInPage.quit();
		myAccountPage.quit();
	}
}
