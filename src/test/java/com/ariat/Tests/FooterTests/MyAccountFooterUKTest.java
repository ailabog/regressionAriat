package com.ariat.Tests.FooterTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Tests.Base.BaseTest;

/**
 * Test Contact Us page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MyAccountFooterUKTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	
	public static final String EMAIL = "aila.bogasieru@ariat.com";
	public static final String PASSWORD = "Paroal12345!";

	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test()
	public void returningCustomerTest() {
		logger.info("Starting returning customer test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		signInPage = homePageUK.returnSignInPageFromFooter();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		signInPage.loginClick();
		logger.info("Finishing returning customer test...");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		signInPage.quit();
  }
}

