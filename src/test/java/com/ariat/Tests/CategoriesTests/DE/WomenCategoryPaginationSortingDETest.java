package com.ariat.Tests.CategoriesTests.DE;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageDE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Tests.BaseTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Pagination and sorting for Women Category
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class WomenCategoryPaginationSortingDETest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageDE homePageDE;
	private WomenCategoryPage womenCategoryPage;
	
	
	@BeforeTest
	public void setUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test
	public void navigateWomenFootwearCategories() {
		logger.info("Starting sort and navigate pagination test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		womenCategoryPage = homePageDE.returnWomenCategoryPage();
		womenCategoryPage.clickSortUp();
		womenCategoryPage.sortProductWomenCategoryRecommended();
		womenCategoryPage.clickSortUp();
		womenCategoryPage.sortProductWomenCategoryBestSellers();
		womenCategoryPage.clickSortUp();
		womenCategoryPage.sortProductWomenCategoryPriceHighToLow();
		womenCategoryPage.show72ItemsUp();
		womenCategoryPage.show108ItemLinkUp();
		womenCategoryPage.show36ItemsUp();
		womenCategoryPage.nextPaginationUp();
		womenCategoryPage.prevPaginationButtonUp();
		womenCategoryPage.show72ItemsDown();
		womenCategoryPage.show108ItemLinkDown();
		womenCategoryPage.nextPaginationDown();
		womenCategoryPage.backToTopClick();
		logger.info("Finishing  sort and navigate pagination test.");
	}
		
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageDE.quit();
		womenCategoryPage.quit();
		
	}
}
