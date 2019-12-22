package com.ariat.Tests.Categories.Countries.Navigation.WomenCategory.LeftNav;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageIE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.KillChrome;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenRidingPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFashionSubcategory.WomenFashionSneakersPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearCountrySubcategories.WomenFootwearCountryFashionPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearCountrySubcategories.WomenFootwearCountryRubberPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearCountrySubcategories.WomenFootwearCountryToolBootsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearCountrySubcategories.WomenFootwearCountryWalkingPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearRidingSubcategories.WomenFootwearAllWeatherRidingPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearRidingSubcategories.WomenFootwearRidingBarnyardPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearRidingSubcategories.WomenFootwearRidingEndurancePage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearRidingSubcategories.WomenFootwearRidingHalfChapsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearRidingSubcategories.WomenFootwearRidingPaddockPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearRidingSubcategories.WomenFootwearRidingToolBootsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearWesternSubcategories.WomenFootwearWesternFashionPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearWesternSubcategories.WomenFootwearWesternPerformancePage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearCasualShoesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearWesternPage;


/**
 * Left navigation for Men category Ireland test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class WomenFootwearSubcategoriesLeftNavIETest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageIE homePageIE;
	private WomenCategoryPage womenCategoryPage;
	private com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenFootwearPage womenFootwearPage;
	private WomenRidingPage womenRidingPage;
	private WomenFootwearRidingToolBootsPage womenFootwearRidingToolBootsPage;
	private WomenFootwearRidingPaddockPage womenFootwearRidingPaddockPage;
	private WomenFootwearRidingHalfChapsPage womenFootwearRidingHalfChapsPage;
	private WomenFootwearAllWeatherRidingPage womenFootwearAllWeatherRidingPage;
	private WomenFootwearRidingEndurancePage womenFootwearRidingEndurancePage;
	private WomenFootwearRidingBarnyardPage womenFootwearRidingBarnyardPage;

	private com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearCountryPage womenFootwearCountryPage;
	private WomenFootwearCountryFashionPage womenFootwearCountryFashionPage;
	private WomenFootwearCountryRubberPage womenFootwearCountryRubberPage;
	private WomenFootwearCountryToolBootsPage womenFootwearCountryToolBootsPage;
	private WomenFootwearCountryWalkingPage womenFootwearCountryWalkingPage;

	private WomenFootwearWesternPage womenFootwearWesternPage;
	private WomenFootwearWesternPerformancePage womenFootwearWesternPerformancePage;
	private WomenFootwearWesternFashionPage womenFootwearWesternFashionPage;

	private WomenFootwearCasualShoesPage womenFootwearCasualShoesPage;
	private WomenFashionSneakersPage womenFootwearSneakersPage;
	private WomenFootwearCasualShoesPage womenFootwearCasual;

	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test(priority = 0)
	public void leftNavigationMenFootwearRidingSubcategories() {
		logger.info("Starting left navigation Men Footwear Riding sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		womenCategoryPage = homePageIE.returnWomenCategoryPage();
		womenFootwearPage = womenCategoryPage.returnWomenFootwearPage();
		womenRidingPage = womenFootwearPage.returnWomennRidingCategoryPageLeftNav();
		womenFootwearRidingToolBootsPage = womenRidingPage.returnWomenFootwearRidingToolBootsPageLeftNav();
		womenFootwearRidingPaddockPage = womenRidingPage.returnWomenFootwearRidingPaddockPagePageLeftNav();
		womenFootwearRidingHalfChapsPage = womenRidingPage.returnWomenFootwearRidingHalfChapsCategoryPageLeftNav();
		womenFootwearAllWeatherRidingPage = womenRidingPage.returnWomenFootwearAllWeatherRidingCategoryPageLeftNav();
		womenFootwearRidingEndurancePage = womenRidingPage.returnWomenFootwearRidingEnduranceCategoryPageLeftNav();
		womenFootwearRidingBarnyardPage = womenRidingPage.returnWomenFootwearRidingBarnyardCategoryPageLeftNav();
		logger.info("Finishing left navigation Men Footwear Riding sub-categories test.");
	}

	@Test(priority = 1)
	public void leftNavigationMenFootwearCountrySubcategories() {
		logger.info("Starting left navigation Men Footwear Country sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		womenCategoryPage = homePageIE.returnWomenCategoryPage();
		womenFootwearPage = womenCategoryPage.returnWomenFootwearPage();
		womenFootwearCountryPage = womenFootwearPage.returnWomenFootwearCountryCategoryPage();
		womenFootwearCountryFashionPage = womenFootwearCountryPage.returnWomenFootwearCountryFashionCategoryPageLeftNav();
		womenFootwearCountryRubberPage = womenFootwearCountryPage.returnWomenFootwearCountryRubberCategoryPageLeftNav();
		womenFootwearCountryToolBootsPage = womenFootwearCountryPage.returnWomenFootwearCountryTallBootsCategoryPageLeftNav();
		womenFootwearCountryWalkingPage = womenFootwearCountryPage.returnWomenFootwearCountryWalkingCategoryPageLeftNav();
		logger.info("Finishing left navigation Men Footwear Country sub-categories test.");
	}

	@Test(priority = 2)
	public void leftNavigationMenFootwearWesternSubcategories() {
		logger.info("Starting left navigation Men Footwear Western sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		womenCategoryPage = homePageIE.returnWomenCategoryPage();
		womenFootwearPage = womenCategoryPage.returnWomenFootwearPage();
		womenFootwearWesternPage = womenFootwearPage.returnWomenFootwearWesternCategoryPage();
		womenFootwearWesternPerformancePage = womenFootwearWesternPage
				.returnWomenFootwearWesternPerformanceCategoryPageLeftNav();
		womenFootwearWesternFashionPage = womenFootwearWesternPage.returnWomenFootwearWesternFashionCategoryLeftNav();
		logger.info("Finishing left navigation Men Footwear Western sub-categories test.");
	}

	

	@Test(priority = 3)
	public void leftNavigationMenFootwearCasualShoesSubcategories() {
		logger.info("Starting left navigation Men Footwear Casual shoes sub-category test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		womenCategoryPage = homePageIE.returnWomenCategoryPage();
		womenFootwearPage = womenCategoryPage.returnWomenFootwearPage();
		womenFootwearCasualShoesPage = womenFootwearPage.returnWomenFootwearCasualShoesCategoryPage();
		womenFootwearCasual = womenFootwearCasualShoesPage.returnWomenFootwearCasualShoesPageCategoryPageLeftNav();
		womenFootwearSneakersPage = womenFootwearCasualShoesPage.returnWomenFashionSneakersCategoryPageLeftNav();
		logger.info("Finishing left navigation Men Footwear Casual shoes sub-category test.");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageIE.quit();
		womenCategoryPage.quit();
		womenFootwearPage.quit();

		womenRidingPage.quit();
		womenFootwearRidingToolBootsPage.quit();
		womenFootwearRidingPaddockPage.quit();
		womenFootwearRidingHalfChapsPage.quit();
		womenFootwearAllWeatherRidingPage.quit();
		womenFootwearRidingEndurancePage.quit();
		womenFootwearRidingBarnyardPage.quit();

		womenFootwearCountryPage.quit();
		womenFootwearCountryFashionPage.quit();
		womenFootwearCountryRubberPage.quit();
		womenFootwearCountryToolBootsPage.quit();
		womenFootwearCountryWalkingPage.quit();

		womenFootwearWesternPage.quit();
		womenFootwearWesternPerformancePage.quit();
		womenFootwearWesternFashionPage.quit();

		womenFootwearCasualShoesPage.quit();
		womenFootwearSneakersPage.quit();
		womenFootwearCasual.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
