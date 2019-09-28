package com.ariat.Tests.Product.NegativeAddToCart;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearRidingPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenFootwearPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageUS;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Products.HeritageProductPage;
import com.ariat.Tests.Base.BaseTest;


/**
 * Product page - > Women Category -> Negative Add to cart test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class ProductNegativeAddToCartWomenCategoryUSTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageUS homePageUS;
	private WomenCategoryPage womenCategoryPage;
	private MyBagPage myBagPage;
	private WomenFootwearPage womenFootwearPage;
	private WomenFootwearRidingPage womenFootwearRidingPage;
	private HeritageProductPage heritageProductPage;
		
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}
	
  @Test(priority=0)
	public void productPageWomenCategoryAddToCartTest() {
		logger.info("Starting product page -> Women Category Gloves sub-category product glove negative add to cart test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		womenCategoryPage = homePageUS.returnWomenCategoryPage();
		womenFootwearPage = womenCategoryPage.returnWomenFootwearPage();
		womenFootwearRidingPage=womenFootwearPage.returnWomenFootwearRidingCategoryPage();
		heritageProductPage.selectAttributeCalf("Slim");
		myBagPage = heritageProductPage.returnMyBagPage();
		logger.info("Finishing product page -> Women Category Gloves sub-category product glove negative add to cart test.");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageUS.quit();
		womenCategoryPage.quit();
		myBagPage.quit();
		womenFootwearRidingPage.quit();
		heritageProductPage.quit();
		myBagPage.quit();
	}
}