package com.ariat.Tests.FooterTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.MyAccountWishListPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;


/**
 * Test Contact Us page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class WishListFooterUKTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private MyAccountWishListPage myAccountWishList;
	
	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomString(7);
	
	public static final String F_NAME = "Aila";
	public static final String L_NAME = "Bogasieru";
	public static final String EMAIL_WISHLIST = "aila.bogasieru@ariat.com";
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}
	@Test
	public void productPageWomenCategoryAddToWishListLoggedTest() {
		logger.info("Starting WishList page test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		myAccountWishList = homePageUK.returnMyAccountWishListPage();
		myAccountWishList.returningCustomer("aila.bogasieru@ariat.com", "EnglishUK");
		myAccountWishList.returningPassword("Parola12345!");
		myAccountWishList.loginClick();
		logger.info("Finishing WishList page test.");
	} 
	
 	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		myAccountWishList.quit();
  }
}

