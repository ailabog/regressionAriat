package com.ariat.Tests.MyAccount.Countries.MyAccountLeftNavigation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageBE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;

/**
 * Include tests for My account left navigation Belgium
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MyAccountLeftNavigationBETest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageBE homePageBE;
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
	public void myAccountAccessPersonalInfoFITest() {
		logger.info("Starting personal info Belgium test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		signInPage = homePageBE.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnEditProfilePageLeftNav();
		myAccountPage.myAccountClick();
		myAccountPage.logoutMiddle();
		logger.info("Finishing personal info Belgium test...");
	}

	@Test(priority = 1)
	public void myAccountAccessEmailPrefFITest() {
		logger.info("Starting email preferences Belgium test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		signInPage = homePageBE.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnEmailPreferencePageLeftNav();
		myAccountPage.myAccountClick();
		myAccountPage.logoutMiddle();
		logger.info("Finishing email preferences Belgium test...");
	}

	@Test(priority = 2)
	public void myAccountAccessAddressesFITest() {
		logger.info("Starting addresses Belgium test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		signInPage = homePageBE.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnAddressesPageLeftNav();
		myAccountPage.myAccountClick();
		myAccountPage.logoutMiddle();
		logger.info("Finishing addresses Belgium test...");
	}

	@Test(priority = 3)
	public void myAccountAccessPaymentInfoFITest() {
		logger.info("Starting payment info Belgium test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		signInPage = homePageBE.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnPaymentInformationPageLeftNav();
		myAccountPage.myAccountClick();
		myAccountPage.returnAddACreditCardMiddleNav();
		myAccountPage.myAccountClick();
		myAccountPage.logoutMiddle();
		logger.info("Finishing payment info Belgium test...");
	}

	@Test(priority = 4)
	public void myAccountAccessOrdersFITest() {
		logger.info("Starting orders Belgium test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		signInPage = homePageBE.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnMyOrdersPageLeftNav();
		myAccountPage.myAccountClick();
		myAccountPage.logoutMiddle();
		logger.info("Finishing orders Belgium test...");
	}

	@Test(priority = 5)
	public void myAccountAccessWishListFITest() {
		logger.info("Starting wish list Belgium test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		signInPage = homePageBE.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnMyWishListPageLeftNav();
		myAccountPage.myAccountClick();
		myAccountPage.logoutMiddle();
		logger.info("Finishing wish list Belgium test...");
	} 

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageBE.quit();
		signInPage.quit();
		myAccountPage.quit();
	}
}
