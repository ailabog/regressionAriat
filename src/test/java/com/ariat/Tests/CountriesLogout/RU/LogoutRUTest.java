package com.ariat.Tests.CountriesLogout.RU;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.Environments;
import com.ariat.Enums.GlobalCountries;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageRU;
import com.ariat.Pages.MyAccountPage;
import com.ariat.Pages.SignInPage;
import com.ariat.Tests.BaseTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class LogoutRUTest extends BaseTest {

	private Environments environment;
	private GlobalCountries country;
	private HomePage homePage;
	private HomePageRU homePageRU;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;

	private static final String EMAIL = "aila.bogasieru@gmail.com";
	private static final String PASSWORD = "Parola12345!";

	@BeforeTest
	public void setUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test
	public void logoutFromMyAccountMiddleRUTest() {
		logger.info("Starting the logout Russia test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageRU = (HomePageRU) homePage.chooseGlobalLocation(country.RU, country.RU.getCurrencyISO());
		signInPage = homePageRU.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "EnglishUS");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.logoutMiddle();
		logger.info("I was succesfully logged out from the application!");
	}
	
	@Test
	public void logoutFromMyAccountTopRUTest() {
		logger.info("Starting the logout Russia test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageRU = (HomePageRU) homePage.chooseGlobalLocation(country.RU, country.RU.getCurrencyISO());
		signInPage = homePageRU.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "EnglishUS");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.logoutTop("English");
		logger.info("I was succesfully logged out from the application!");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
		homePageRU.quit();
		signInPage.quit();
		myAccountPage.quit();
	}
}
