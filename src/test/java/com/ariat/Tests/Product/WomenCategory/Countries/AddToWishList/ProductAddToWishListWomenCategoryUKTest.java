package com.ariat.Tests.Product.WomenCategory.Countries.AddToWishList;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.CreateAccountPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.MyAccountWishListPage;
import com.ariat.Pages.Main.MyWishListPage;
import com.ariat.Pages.Products.GlovesProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;

/**
 * Product page - > Women Category -> Add to Wishlist test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class ProductAddToWishListWomenCategoryUKTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private MyWishListPage myWishListPage;
	private WomenCategoryPage womenCategoryPage;
	private MyAccountWishListPage myAccountWishListPage;
	private CreateAccountPage createAccountPage;
	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenAccessoriesGlovesPage womenAccessoriesGlovesPage;
	private GlovesProductPage glovesProductPage;

	
	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomString(7);
	public static final String BIRTH_MONTH = "March";
	public static final String BIRTH_DAY = "02";

	public static final String EMAIL = GenerateRandomDataUtils.generateEmail(12);
	public static final String PASSWORD = GenerateRandomDataUtils.generateRandomString(10);

	public static final String ORDER_NO = GenerateRandomDataUtils.generateRandomNumber(8);
	public static final String BILLING_ZIP_CODE = GenerateRandomDataUtils.generateRandomNumber(6);
	
	public static final String F_NAME = "Aila";
	public static final String L_NAME = "Bogasieru";
	public static final String EMAIL_WISHLIST = "aila.bogasieru@ariat.com";
	public static final String PASSWORD_WISHLIST = "Parola12345!";
	
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority=0)
	public void productPageWomenCategoryAddToWishListLoggedTest() {
		logger.info("Starting product page -> Women Category Add to Wishlist being logged test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		signInPage = homePageUK.returnSignInPage();
		signInPage.setLoginDetails(EMAIL_WISHLIST, "EnglishUK", PASSWORD_WISHLIST);
		myAccountPage = signInPage.returnMyAccountPage();
		womenCategoryPage = homePageUK.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage= womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myWishListPage = glovesProductPage.returnMyWishListPage();
		logger.info("Finishing product page -> Women Category Add to WishList being logged test.");
	} 
	
    @Test(priority=1)
	public void productPageWomenCategoryAddToWishListNotLoggedTest() {
		logger.info("Starting product page -> Women Category Add to Wishlist not being logged test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		womenCategoryPage = homePageUK.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage= womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myAccountWishListPage = glovesProductPage.returnMyAccountWishListPage();
		myAccountWishListPage.returningCustomer(EMAIL, "EnglishUK");
		myAccountWishListPage.returningPassword(PASSWORD);
		myWishListPage = myAccountWishListPage.returnMyWishListPage();
		logger.info("Finishing product page -> Women Category Add to WishList not being logged test.");
	}
	
	@Test(priority=2)
	public void productPageWomenCategoryAddToWishListCreateAccountTest() {
		logger.info("Starting product page -> Women Category Add to Wishlist create account test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		womenCategoryPage = homePageUK.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage= womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myAccountWishListPage = glovesProductPage.returnMyAccountWishListPage();
		createAccountPage = myAccountWishListPage.returnCreateAccountPage();
		createAccountPage.createAccount(FIRST_NAME, LAST_NAME, BIRTH_MONTH, BIRTH_DAY, EMAIL, EMAIL, PASSWORD, PASSWORD);
		myAccountWishListPage = createAccountPage.returnMyAccountWishListPage();
		logger.info("Finishing product page -> Women Category Add to WishList create account test.");
	} 
	
	@Test(priority=3)
	public void productPageWomenCategoryFindSomeoneWishListTest() {
		logger.info("Starting product page -> Women Category find someone's WishList test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		womenCategoryPage = homePageUK.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPage();
		womenAccessoriesGlovesPage= womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myAccountWishListPage = glovesProductPage.returnMyAccountWishListPage();
		myAccountWishListPage.findWishListFName(F_NAME);
		myAccountWishListPage.findWishListLName(L_NAME);
		myAccountWishListPage.findWishListEmail(EMAIL_WISHLIST);
		myAccountWishListPage.findWishListClick();
		logger.info("Finishing product page -> Women Category find someone's WishList test.");
	}
		
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		signInPage.quit();
		myAccountPage.quit();
		womenCategoryPage.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesGlovesPage.quit();
		glovesProductPage.quit();
		myWishListPage.quit();
	   createAccountPage.quit();
	   KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
