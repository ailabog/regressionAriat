package com.ariat.Tests.HeaderAndFooterCountriesTests.DE;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageDE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Tests.BaseTest;
import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Test Home Page instantiates the browser and access the ariat environment and
 * verifies all elements on Home Page UK
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class HeaderAndFooterDETest extends BaseTest{

	private Environments environment;
	private HomePageUK homePageUK;
	private HomePageDE homePageDE;
	private HomePage homePage;
	private EUCountries euCountry;


	@BeforeTest
	public void setUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test(priority=0)
	public void DEHeader() {
		logger.info("Starting the check for Header Deutschland elements:");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		homePageDE.checkElementsHeader();
		logger.info("Finishing the check for Header Deutschland elements:");
	}
	
	@Test(priority=1)
	public void DEFooter() {
		logger.info("Starting the check for Footer Deutschland elements:");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		homePageDE.checkElementsFooter();
		logger.info("Finishing the check for Footer Deutschland elements:");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageDE.quit();
	}
}