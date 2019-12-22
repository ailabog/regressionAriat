package com.ariat.Tests.Product.WomenCategory.WriteReview;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingTopsAndTshirtsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageUS;
import com.ariat.Pages.Products.GlovesProductPage;
import com.ariat.Pages.Products.RebarTopProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;

/**
 * Product page - > Men Category test write review on Glove product
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class ProductWriteReviewWomenCategoryUSTest extends BaseTest {

	private Environments environment;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageUS homePageUS;
	private WomenAccessoriesGlovesPage womenAccessoriesGlovesPage;
	private GlovesProductPage gloveProductPage;
	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenClothingTopsAndTshirtsPage womenClothingTopsAndTshirtsPage;
	private RebarTopProductPage rebarTopProductPage;
	private WomenCategoryPage womenCategoryPage;
	private EUCountries euCountry;
	
	private static final String TITLE_REVIEW = "This is my review";
	private static final String CONTENT_REVIEW = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam a porttitor nisl, id rhoncus massa. Nunc imperdiet luctus porta. Sed consequat eros quis pellentesque pulvinar. Nulla facilisi. Vestibulum at dui ac elit laoreet suscipit. Suspendisse erat turpis, aliquet id mauris vitae, viverra iaculis massa. Proin ullamcorper enim quis orci tempor consectetur quis vel augue. Aliquam rutrum nibh arcu, at vestibulum urna blandit at. Quisque at dapibus erat. Donec id sapien eu massa interdum laoreet a non libero. Nunc finibus, odio quis laoreet pretium, velit ante imperdiet nisl, id volutpat elit nisl sit amet mi. Aenean aliquet, elit tincidunt ullamcorper suscipit, nisi felis malesuada eros, in vehicula ipsum urna ac felis.";
    private static final String USER = GenerateRandomDataUtils.generateRandomString(5);
    private static final String EMAIL = "aila.bogasieru@gmail.com";
    private static final String CITY = "New York";
    public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test
	public void productPageWomenCategoryWriteReviewYesRecommendTest() {
		logger.info("Starting product page -> Men Category write review recommend product for Glove product test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		womenAccessoriesPage = homePageUS.returnAccessoriesCategoryPage();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		gloveProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		gloveProductPage.writeReviewClick();
		gloveProductPage.writeReviewContent(TITLE_REVIEW, CONTENT_REVIEW);
		gloveProductPage.writeReviewStar("Excellent");
		gloveProductPage.recommendProductYes();
		gloveProductPage.userInfoReview(USER, CITY, EMAIL);
		gloveProductPage.postReview();
		logger.info("Finishing product page -> Men Category write review recommend product for Glove product test.");
	}

@Test
	public void productPageWomenCategoryWriteReviewNoRecommendTest() {
		logger.info("Starting product page -> Men Category write review don't recommend product for Breech product test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		womenCategoryPage = homePageUS.returnWomenCategoryPage();
		//womenClothingTopsAndTshirtsPage = homePageUS.returnWomenClothingTopsAndTshirtsPage();
		rebarTopProductPage = womenClothingTopsAndTshirtsPage.returnRebarToptPage();
		rebarTopProductPage.writeReviewClick();
		rebarTopProductPage.writeReviewContent(TITLE_REVIEW, TITLE_REVIEW);
		rebarTopProductPage.writeReviewStar("Poor");
		//breechProductPage.recommendProductNo();
		rebarTopProductPage.userInfoReview(USER, CITY, EMAIL);
		rebarTopProductPage.postReview();
		logger.info("Finishing product page -> Men Category don't recommend product for Breech product test.");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageUS.quit();
		womenAccessoriesPage.quit();
		womenCategoryPage.quit();
		womenAccessoriesGlovesPage.quit();
		gloveProductPage.quit();
		rebarTopProductPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
