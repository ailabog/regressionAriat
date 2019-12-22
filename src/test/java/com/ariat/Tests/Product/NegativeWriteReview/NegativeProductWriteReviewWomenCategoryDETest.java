package com.ariat.Tests.Product.NegativeWriteReview;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesBagsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageDE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Products.BagsProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;

/**
 * Product page - > Women Category test negative write review on Glove product
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class NegativeProductWriteReviewWomenCategoryDETest extends BaseTest {

	private Environments environment;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageDE homePageDE;
	private BagsProductPage bagsProductPage;
	private WomenAccessoriesBagsPage womenAccessoriesBagsPage;
	private WomenAccessoriesPage womenAccessoriesPage;
	private EUCountries euCountry;
	
    
    private static final String TITLE_REVIEW =  GenerateRandomDataUtils.generateRandomNumber(10);
	private static final String CONTENT_REVIEW = GenerateRandomDataUtils.generateRandomNumber(50);
    private static final String USER = GenerateRandomDataUtils.generateRandomNumber(5);
    private static final String EMAIL = "aila.bogasieru@gmail.com";
    private static final String CITY = "London";
    public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test
	public void productPageWomenCategoryWriteReviewYesRecommendTest() {
		logger.info("Starting product page -> Women Category write negative review product for Glove product test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		womenAccessoriesPage = homePageDE.returnAccessoriesCategoryPageDE();
		womenAccessoriesBagsPage = womenAccessoriesPage.returnWomenAccessoriesBagsCategoryPage();
		bagsProductPage = womenAccessoriesBagsPage.returnBagsProductPage();
		bagsProductPage.writeReviewClick();
		bagsProductPage.userInfoReview(USER, CITY, EMAIL);
		bagsProductPage.postReview();
		logger.info("Finishing product page -> Women Category write negative review recommend product for Glove product test.");
	}


	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageDE.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesBagsPage.quit();
		bagsProductPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
