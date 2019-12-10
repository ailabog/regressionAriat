package com.ariat.Tests.CreditCard.Countries.AddCreditCard;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Enums.ListOfCreditCards;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageSE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.AddACreditCardPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.PaymentInformationPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;

/**
 * Tests for Add Credit card Sweden
 * @author aila.bogasieru@ariat.com
 *
 */


public class AddCreditCardSETest extends BaseTest{
	
	private HomePage homePage;
	private HomePageSE homePageSE;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private AddACreditCardPage addACreditCardPage;
	private PaymentInformationPage paymentInfoPage;
	private Environments environment;
	private EUCountries euCountry;
	private ListOfCreditCards typeCard;
	
	private static final String EMAIL = "aila.bogasieru@yahoo.com";
	private static final String PASSWORD = "Parola12345!";
	private static final String CARD_ID = "XX";
	private static final String CARD_OWNER = "Aila B";
	private static final String YEAR = "2023";
	private static final String MONTH = "January";
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}


	@Test(priority = 0)
	public void addCreditCardSETest() {
		String expirationDate = "MONTH/YEAR";
		logger.info("Starting add a credit card Sweden test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageSE = (HomePageSE) homePage.chooseEULocation(euCountry.SE, euCountry.SE.getCurrencyISO());
		signInPage = homePageSE.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addACreditCardPage = myAccountPage.returnAddACreditCardMiddleNav();
		addACreditCardPage.setDetailsCreditCard(CARD_ID, CARD_OWNER, typeCard.VISA.getName(), typeCard.VISA.getNumber(), typeCard.VISA.getCvs(), MONTH, YEAR);
		paymentInfoPage = addACreditCardPage.returnPaymentInformationPage();
		paymentInfoPage.checkCreditCard(CARD_OWNER, typeCard.VISA.getName(), expirationDate);
		logger.info("Finishing add a credit card Sweden test");
  } 
	
	@Test(priority = 1)
	public void addCreditCardFromPaymentInfoSETest() {
		logger.info("Starting add credit card from Payment Info Sweden test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageSE = (HomePageSE) homePage.chooseEULocation(euCountry.SE, euCountry.SE.getCurrencyISO());
		signInPage = homePageSE.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		paymentInfoPage = myAccountPage.returnPaymentInformationPageLeftNav();
		addACreditCardPage = paymentInfoPage.returnAddACreditCardPage();
		addACreditCardPage.setDetailsCreditCard(CARD_ID, CARD_OWNER, typeCard.MASTER_CARD.getName(), typeCard.MASTER_CARD.getNumber(), typeCard.MASTER_CARD.getCvs(), MONTH, YEAR);
		addACreditCardPage.applyCardCreation();
		logger.info("Finishing add credit card from Payment info Sweden test");
		
  }
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageSE.quit();
		signInPage.quit();
		addACreditCardPage.quit();
		paymentInfoPage.quit();
		myAccountPage.quit();
	}
}