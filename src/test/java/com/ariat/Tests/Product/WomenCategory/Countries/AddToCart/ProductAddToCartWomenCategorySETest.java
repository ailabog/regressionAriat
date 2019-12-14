package com.ariat.Tests.Product.WomenCategory.Countries.AddToCart;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenFootwearPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageSE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Products.CasualShoeProductPage;
import com.ariat.Pages.Products.GlovesProductPage;
import com.ariat.Pages.Products.HeritageProductPage;
import com.ariat.Tests.Base.BaseTest;

/**
 * Product page - > Women Category -> Add to cart test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class ProductAddToCartWomenCategorySETest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageSE homePageSE;
	private WomenCategoryPage womenCategoryPage;
	private MyBagPage myBagPage;
	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenAccessoriesGlovesPage womenAccessoriesGlovesPage;
	private GlovesProductPage glovesProductPage;
	private com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearCasualShoesPage womenFootwearCasualShoesCategoryPage;
	private WomenFootwearPage womenFootwearPage;
	private CasualShoeProductPage casualProductShoePage;
	private HeritageProductPage productPage;

	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

    @Test(priority=0)
	public void productPageWomenCategoryAddToCartTest() {
		logger.info("Starting product page -> Women Category Gloves sub-category product glove add to cart test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageSE = (HomePageSE) homePage.chooseEULocation(euCountry.SE, euCountry.SE.getCurrencyISO());
		womenCategoryPage = homePageSE.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage= womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		myBagPage.removeProduct();
		logger.info("Finishing product page -> Women Category Gloves sub-category product glove add to cart test.");
	}
	
	@Test(priority=1)
	public void productPageWomenCategoryAddToCartNoFreeGiftTest() {
		logger.info("Starting product page -> Women Category Casual Shoe prduct category add to cart test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageSE = (HomePageSE) homePage.chooseEULocation(euCountry.SE, euCountry.SE.getCurrencyISO());
		womenCategoryPage = homePageSE.returnWomenCategoryPage();
		womenFootwearPage = womenCategoryPage.returnWomenFootwearPage();
		womenFootwearCasualShoesCategoryPage = womenFootwearPage.returnWomenFootwearCasualShoesCategoryPage();
		casualProductShoePage = womenFootwearCasualShoesCategoryPage.returnCasualShoeProductPage();
		casualProductShoePage.selectAttributeSize("36");
		myBagPage = casualProductShoePage.returnMyBagPage();
		myBagPage.removeProduct();
		//myBagPage.cancelFreeGift();
		//myBagPage.checkMyBagNoFreeGift();
		logger.info("Finishing product page -> Women Category Casual Shoe prduct category add to cart test.");
	}
	
	@Test(priority=2)
	public void productPageWomenCategoryAddToCartYesFreeGiftTest() {
		logger.info("Starting product page -> Women Category Add to cart test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageSE = (HomePageSE) homePage.chooseEULocation(euCountry.SE, euCountry.SE.getCurrencyISO());
		womenCategoryPage = homePageSE.returnWomenCategoryPage();
		productPage = womenCategoryPage.returnHeritageProduct();
		productPage.selectAttributeSize("37");
		productPage.selectAttributeCalf("Extra Slim");
		productPage.selectAttributeHeight("Medium");
		myBagPage = productPage.returnMyBagPage();
		myBagPage.removeProduct();
		logger.info("Finishing product page -> Women Category Add to cart  test.");
	}
	
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageSE.quit();
		womenCategoryPage.quit();
		myBagPage.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesGlovesPage.quit();
		glovesProductPage.quit();
		womenFootwearCasualShoesCategoryPage.quit();
		casualProductShoePage.quit();
		productPage.quit();
	}
}
