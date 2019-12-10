package com.ariat.Tests.MyAccount.Countries.PersonalInfo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.PersonalnformationPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;

/**
 * Personal Information Unite Kingdom test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class PersonalInformationUKTest extends BaseTest {

	private HomePage homePage;
	private HomePageUK homePageUK;
	private Environments environment;
	private EUCountries euCountry;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private PersonalnformationPage personalInformationPage;
	

	private static final String EMAIL = "aila.bogasieru@ariat.com";
	private static final String PASSWORD = "Parola12345!";
	private static final String NEW_EMAIL = "aila.bogasieru@yahoo.com";
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test
	public void updatePersonalInformationTest() {
		logger.info("Starting update personal information test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		signInPage = homePageUK.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		personalInformationPage = myAccountPage.returnPersonalInfoPageMiddleNav();
		personalInformationPage.clearEmail();
		personalInformationPage.enterEmail(NEW_EMAIL);
		personalInformationPage.confirmEmail(NEW_EMAIL);
		personalInformationPage.enterPassword(PASSWORD);
		personalInformationPage.confirmPassword(PASSWORD);
		personalInformationPage.saveEdits();
		logger.info("Update personal information test ended...");
	}
	
	@AfterMethod
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		signInPage.quit();
		myAccountPage.quit();
		personalInformationPage.quit();
	}
}
