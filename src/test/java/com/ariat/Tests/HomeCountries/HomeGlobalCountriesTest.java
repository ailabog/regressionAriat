package com.ariat.Tests.HomeCountries;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Enums.GlobalCountries;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageBE;
import com.ariat.Pages.HomePagesCountries.HomePageDE;
import com.ariat.Pages.HomePagesCountries.HomePageDK;
import com.ariat.Pages.HomePagesCountries.HomePageFI;
import com.ariat.Pages.HomePagesCountries.HomePageFR;
import com.ariat.Pages.HomePagesCountries.HomePageIE;
import com.ariat.Pages.HomePagesCountries.HomePageLU;
import com.ariat.Pages.HomePagesCountries.HomePageNL;
import com.ariat.Pages.HomePagesCountries.HomePageNO;
import com.ariat.Pages.HomePagesCountries.HomePageSE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageUS;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.KillChrome;


/**
 * Choose countries (EU Countries) selector tests for US page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class HomeGlobalCountriesTest extends BaseTest {

	private Environments environment;
	private HomePageUS homePageUS;
	private HomePageUK homePageUK;
	private HomePageIE homePageIE;
	private HomePageDK homePageDK;
	private HomePageFR homePageFR;
	private HomePageBE homePageBE;
	private HomePageDE homePageDE;
	private HomePageNO homePageNO;
	private HomePageFI homePageFI;
	private HomePageNL homePageNL;
	private HomePageLU homePageLU;
	private HomePageSE homePageSE;
	private HomePage homePage;
	private GlobalCountries country;
	private EUCountries euCountry;
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test
	public void EULocations() {
		logger.info(
				"Start choosing EU countries one by one from the list starting with United Kingdom & finishing with United States...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		homePageNO = (HomePageNO) homePage.chooseEULocation(euCountry.NO, euCountry.NO.getCurrencyISO());
		homePageFI = (HomePageFI) homePage.chooseEULocation(euCountry.FI, euCountry.FI.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		homePageDK = (HomePageDK) homePage.chooseEULocation(euCountry.DK, euCountry.DK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		homePageNL = (HomePageNL) homePage.chooseEULocation(euCountry.NL, euCountry.NL.getCurrencyISO());
		homePageLU = (HomePageLU) homePage.chooseEULocation(euCountry.LU, euCountry.LU.getCurrencyISO());
		homePageSE = (HomePageSE) homePage.chooseEULocation(euCountry.SE, euCountry.SE.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		logger.info(
				"Finish choosing EU countries one by one from the list starting with United Kingdom & finishing with United States.");
	}

		@AfterTest
	public void tearDown() {
		homePageUK.quit();
		homePageBE.quit();
		homePageDE.quit();
		homePageNO.quit();
		homePageFI.quit();
		homePageNL.quit();
		homePageSE.quit();
		homePageLU.quit();
		homePageUS.quit();
	   	homePageFR.quit();
		homePageIE.quit();
		homePageDK.quit();
		homePage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
