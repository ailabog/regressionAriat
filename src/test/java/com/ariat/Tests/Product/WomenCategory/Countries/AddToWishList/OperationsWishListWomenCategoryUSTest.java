package com.ariat.Tests.Product.WomenCategory.Countries.AddToWishList;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.MyWishListPage;
import com.ariat.Pages.Products.BagsProductPage;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageUS;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesBagsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.KillChrome;

/**
 * Product page - > Men Category -> Add to wishlist update, edit, set
 * priority, remove product test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class OperationsWishListWomenCategoryUSTest extends BaseTest {

	private Environments environment;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageUS homePageUS;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private MyWishListPage myWishListPage;
	private EUCountries euCountry;

	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenAccessoriesBagsPage womenAccessoriesBagsPage;
	private BagsProductPage bagsProductPage;
	private WomenCategoryPage womenCategoryPage;

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

	@Test(priority = 0)
	public void productPageWomenCategoryAddToWishListShareToAFriendTest() {
		logger.info("Starting product page -> Women Category Add to Wishlist & share it to a friend test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		signInPage = homePageUS.returnSignInPage();
		signInPage.setLoginDetails(EMAIL_WISHLIST, "EnglishUS", PASSWORD_WISHLIST);
		bagsProductPage = homePageUS.returnBagsProductPage();
		myWishListPage = bagsProductPage.returnMyWishListPage();
		myWishListPage.sendListToAFriend("Ana", "aila.bogasieru@yahoo.com");
		logger.info("Finishing product page -> Women Category Add to WishList & share it to a friend test.");
	}

	@Test(priority = 1)
	public void productPageWomenCategoryAddToWishListDifferentActionsTest() {
		logger.info("Starting product page -> Women Category Add to Wishlist & different actions test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		signInPage = homePageUS.returnSignInPage();
		signInPage.setLoginDetails(EMAIL_WISHLIST, "EnglishUS", PASSWORD_WISHLIST);
		bagsProductPage = homePageUS.returnBagsProductPage();
		myWishListPage = bagsProductPage.returnMyWishListPage();
		myWishListPage.setPriorityWishList("Medium");
		myWishListPage.increaseQtyWishList(3);
		myWishListPage.decreaseQtyWishList(2);
		myWishListPage.editItemWishList();
		bagsProductPage.update();
		// myWishListPage.goBackFromEditToWishlist();
		logger.info("Finishing product page -> Women Category Add to WishList  & different actions test.");
	}

	@Test(priority = 2)
	public void productPageWomenCategoryAddToWishListAddToCartTest() {
		logger.info("Starting product page -> Women Category Add to Wishlist & add to cart test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		signInPage = homePageUS.returnSignInPage();
		signInPage.setLoginDetails(EMAIL_WISHLIST, "EnglishUS", PASSWORD_WISHLIST);
		bagsProductPage = homePageUS.returnBagsProductPage();
		myWishListPage = bagsProductPage.returnMyWishListPage();
		myWishListPage.addToCartItemWishList();
		logger.info("Finishing product page -> Women Category Add to WishList& add to cart test."
				+ homePageUK.minicartShow());

	}

	@Test(priority = 3)
	public void productPageWomenCategoryAddToWishListRemoveItemTest() {
		logger.info("Starting product page -> Women Category Add to Wishlist & add to cart test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		signInPage = homePageUS.returnSignInPage();
		signInPage.setLoginDetails(EMAIL_WISHLIST, "EnglishUS", PASSWORD_WISHLIST);
		bagsProductPage = homePageUS.returnBagsProductPage();
		myWishListPage = bagsProductPage.returnMyWishListPage();
		myWishListPage.removeItemWishList();
		logger.info("Finishing product page -> Women Category Add to WishList& add to cart test.");
		//logger.info("Finishing product page -> Women Category Add to WishList& add to cart test."
		//		+ myWishListPage.noItemWishList());
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageUS.quit();
		signInPage.quit();
		myAccountPage.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesBagsPage.quit();
		bagsProductPage.quit();
		myWishListPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
