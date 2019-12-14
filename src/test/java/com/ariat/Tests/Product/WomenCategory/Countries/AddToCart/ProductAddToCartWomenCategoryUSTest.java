package com.ariat.Tests.Product.WomenCategory.Countries.AddToCart;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesBagsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageUS;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Products.BagsProductPage;
import com.ariat.Tests.Base.BaseTest;

/**
 * Product page - > Men Category -> Add to cart test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class ProductAddToCartWomenCategoryUSTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageUS homePageUS;
	private WomenCategoryPage menCategoryPage;
	private MyBagPage myBagPage;
	private WomenAccessoriesPage menAccessoriesPage;
	private WomenAccessoriesBagsPage menAccessoriesBagsPage;
	private BagsProductPage bagsProductPage;


	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
    public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
			
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}
	
    @Test(priority=0)
	public void productPageMennCategoryAddToCartTest() {
		logger.info("Starting product page -> Men Category Bags add to cart test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		menCategoryPage = homePageUS.returnWomenCategoryPage();
		menCategoryPage.womenCategory();
		menAccessoriesPage = menCategoryPage.returnWomenAccessoriesCategoryPage();
		menAccessoriesBagsPage = menAccessoriesPage.returnWomenAccessoriesBagsCategoryPage();
		bagsProductPage = menAccessoriesBagsPage.returnBagsProductPage();
		myBagPage = bagsProductPage.returnMyBagPage();
		myBagPage.removeProduct();
		logger.info("Finishing product page -> Men Category Bags add to cart test.");
	}
    
  
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageUS.quit();
		menCategoryPage.quit();
		myBagPage.quit();
		menAccessoriesPage.quit();
		menAccessoriesBagsPage.quit();
		bagsProductPage.quit();
	}
}
