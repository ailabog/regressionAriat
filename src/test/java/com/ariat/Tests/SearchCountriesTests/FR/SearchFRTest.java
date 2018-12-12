package com.ariat.Tests.SearchCountriesTests.FR;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageFR;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Tests.BaseTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class SearchFRTest extends BaseTest {

	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageFR homePageFR;
	private EUCountries euCountry;
	private Environments environment;
	private final String OPTION = "boots";
	private final String MESSAGE = "Product results for: ";

	
	@BeforeTest
	public void setUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test
	public void editAddressTest() {
		logger.info("Starting search products France test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		homePageFR.search(OPTION);
	    homePageFR.assertProductDisplayed(MESSAGE+OPTION);
		homePageFR.seeAllproducts();
		logger.info("Finishing search products France test");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageFR.quit();
	}
}