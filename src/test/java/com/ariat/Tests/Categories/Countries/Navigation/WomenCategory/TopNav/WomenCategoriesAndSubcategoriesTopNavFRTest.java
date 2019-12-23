package com.ariat.Tests.Categories.Countries.Navigation.WomenCategory.TopNav;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageFR;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.KillChrome;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesBagsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesHeadwearPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesScarfAndPonchosPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesSocksPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingBreechesAndTightsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingOuterwearPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingShowPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingSweatTshirtAndWoodiesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingTopsAndTshirtsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFeatured.WomenFeaturedSubcategories.WomenFeaturedHeritageCollectionPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFeatured.WomenFeaturedSubcategories.WomenFeaturedTriFactorBreechPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFeatured.WomenFeaturedSubcategories.WomenFeaturedWarmWeatherRidingPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearCasualShoesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearCountryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearRidingPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearWesternPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenClothingPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenFeaturedPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenFootwearPage;


/**
 * Test pages redirection from Women Category to all its sub-categories tree France test
 * structure
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class WomenCategoriesAndSubcategoriesTopNavFRTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePageUK homePageUK;
	private HomePageFR homePageFR;
	private HomePage homePage;
	private WomenCategoryPage womenCategoryPage;
	
	private WomenFootwearPage womenFootwearPage;
	private WomenFootwearRidingPage womenFootwearRidingPage;
	private WomenFootwearWesternPage womenFootwearWesternPage;
	private WomenFootwearCountryPage womenFootwearCountryPage;
	private WomenFootwearCasualShoesPage womenFootwearCasualShoesPage;
	
	private WomenClothingPage womenClothingPage;
	private WomenClothingOuterwearPage womenClothingOuterwearPage;
	private WomenClothingBreechesAndTightsPage womenClothingBreechesAndTightsPage;
	private WomenClothingShowPage womenClothingShowPage;
	private WomenClothingSweatTshirtAndWoodiesPage womenClothingSweatTshirtAndWoodiesPage;
	private WomenClothingTopsAndTshirtsPage womenClothingTopsAndTshirtsPage;
	
	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenAccessoriesBagsPage womenAccessoriesBagsPage;
	private WomenAccessoriesGlovesPage womenAccessoriesGlovesPage;
	private WomenAccessoriesHeadwearPage womenAccessoriesHeadwearPage;
	private WomenAccessoriesScarfAndPonchosPage womenAccessoriesScarfAndPonchosPage;
	private WomenAccessoriesSocksPage womenAccessoriesSocksPage;
	
	private WomenFeaturedPage womenFeaturedPage;
	private WomenFeaturedHeritageCollectionPage womenFeaturedHeritageCollectionPage;
	private WomenFeaturedWarmWeatherRidingPage womenFeaturedWarmWeatherRidingPage;
	private WomenFeaturedTriFactorBreechPage womenFeaturedTriFactorBreechPage;
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
    public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
			
    @BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority = 0)
	public void navigateWomenFootwearCategories() {
		logger.info("Starting navigate Women Footwear sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		womenCategoryPage = homePageFR.returnWomenCategoryPage();
		womenCategoryPage.womenCategory();
		womenFootwearPage = womenCategoryPage.returnWomenFootwearPage();
		womenCategoryPage.womenCategory();
		womenFootwearRidingPage = womenFootwearPage.returnWomenFootwearRidingCategoryPage();
		womenCategoryPage.womenCategory();
		womenFootwearWesternPage = womenFootwearPage.returnWomenFootwearWesternCategoryPage();
		womenCategoryPage.womenCategory();
		womenFootwearCountryPage = womenFootwearPage.returnWomenFootwearCountryCategoryPage();
		womenCategoryPage.womenCategory();
		womenFootwearCasualShoesPage = womenFootwearPage.returnWomenFootwearCasualShoesCategoryPage();
		logger.info("Finishing navigate Women Footwear sub-categories test.");
	}

	@Test(priority = 1)
	public void navigateWomenClothingCategoriesTest() {
		logger.info("Starting navigate Women Clothing sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		womenCategoryPage = homePageFR.returnWomenCategoryPage();
		womenCategoryPage.womenCategory();
		womenClothingPage = womenCategoryPage.returnWomenClothingCategoryPage();
		womenCategoryPage.womenCategory();
		womenClothingOuterwearPage = womenClothingPage.returnWomenClothingOuterwearCategoryPage();
		womenCategoryPage.womenCategory();
		womenClothingBreechesAndTightsPage = womenClothingPage.returnWomenClothingBreechesAndTightsCategoryPage();
		womenCategoryPage.womenCategory();
		womenClothingShowPage = womenClothingPage.returnWomenClothingShowCategoryPage();
		womenCategoryPage.womenCategory();
		womenClothingSweatTshirtAndWoodiesPage = womenClothingPage.returnWomenClothingSweatTshirtAndWoodiesCategoryPage();
		womenCategoryPage.womenCategory();
		womenClothingTopsAndTshirtsPage = womenClothingPage.returnWomenClothingTopsAndTshirtsCategoryPage();
		logger.info("Finishing navigate Women Clothing sub-categories test.");
	}

	@Test(priority = 2)
	public void navigateWomenAccessoriesCategoriesTest() {
		logger.info("Starting navigate Women Accessories sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		womenCategoryPage = homePageFR.returnWomenCategoryPage();
		womenCategoryPage.womenCategory();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryPage();
		womenCategoryPage.womenCategory();
		womenAccessoriesBagsPage = womenAccessoriesPage.returnWomenAccessoriesBagsCategoryPage();
		womenCategoryPage.womenCategory();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryPage();
		womenCategoryPage.womenCategory();
		womenAccessoriesHeadwearPage = womenAccessoriesPage.returnWomenAccessoriesHeadwearCategoryPage();
		womenCategoryPage.womenCategory();
		womenAccessoriesScarfAndPonchosPage = womenAccessoriesPage.returnWomenAccessoriesScarfAndPonchosCategoryPage();
		womenCategoryPage.womenCategory();
		womenAccessoriesSocksPage = womenAccessoriesPage.returnWomenAccessoriesSocksCategoryPage();
		logger.info("Finishing navigate Women Accessories sub-categories test.");
	}

	@Test(priority = 3)
	public void navigateWomenFeaturedCategoriesTest() {
		logger.info("Starting navigate Women Featured sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		womenCategoryPage = homePageFR.returnWomenCategoryPage();
		womenCategoryPage.womenCategory();
		womenFeaturedPage = womenCategoryPage.returnWomenFeaturedCategoryPage();
		womenCategoryPage.womenCategory();
		womenFeaturedHeritageCollectionPage = womenFeaturedPage.returnWomenFeaturedHeritageCollectionCategoryPage();
		womenCategoryPage.womenCategory();
		womenFeaturedWarmWeatherRidingPage = womenFeaturedPage.returnWomenFeaturedWarmWeatherRidingCategoryPage();
		womenCategoryPage.womenCategory();
		womenFeaturedTriFactorBreechPage = womenFeaturedPage.returWomenFeaturedTriFactorBreechCategoryPage();
		logger.info("Finishing navigate Women Featured sub-categories test.");
	} 

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageFR.quit();
		womenCategoryPage.quit();
		womenFootwearPage.quit();
				
		womenFootwearRidingPage.quit();
		womenFootwearWesternPage.quit();
		womenFootwearCountryPage.quit();
		womenFootwearCasualShoesPage.quit();
		
		womenClothingPage.quit();
		womenClothingOuterwearPage.quit();
		womenClothingBreechesAndTightsPage.quit();
		womenClothingShowPage.quit();
		womenClothingSweatTshirtAndWoodiesPage.quit();
		womenClothingTopsAndTshirtsPage.quit();
		
		womenAccessoriesPage.quit();
		womenAccessoriesBagsPage.quit();
		womenAccessoriesGlovesPage.quit();
		womenAccessoriesHeadwearPage.quit();
		womenAccessoriesScarfAndPonchosPage.quit();
		womenAccessoriesSocksPage.quit();
		
		womenFeaturedPage.quit();
		womenFeaturedHeritageCollectionPage.quit();
		womenFeaturedWarmWeatherRidingPage.quit();
		womenFeaturedTriFactorBreechPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
