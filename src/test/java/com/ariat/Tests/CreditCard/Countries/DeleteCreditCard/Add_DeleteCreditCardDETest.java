package com.ariat.Tests.CreditCard.Countries.DeleteCreditCard;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Enums.ListOfCreditCards;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageDE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.AddACreditCardPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.PaymentInformationPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;


/**
 * Tests for add & deletet credit card Deutschland
 * @author aila.bogasieru@ariat.com
 *
 */


public class Add_DeleteCreditCardDETest extends BaseTest{
	
	private HomePage homePage;
	private HomePageDE homePageDE;
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
	private static final String CARD_ID = "MASTER_ID123";
	private static final String CARD_OWNER = "Aila B";
	private static final String YEAR = "2023";
	private static final String MONTH = "Dezember";
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}
	@Test
	public void add_deleteCreditCardDETest() {
		String expirationDate = "MONTH/YEAR";
		logger.info("Starting add credit card & delete it Germany test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		signInPage = homePageDE.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "Deutsch", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addACreditCardPage = myAccountPage.returnAddACreditCardMiddleNavDE();
		addACreditCardPage.setDetailsCreditCard(CARD_ID, CARD_OWNER, typeCard.VISA.getName(), typeCard.VISA.getNumber(), typeCard.VISA.getCvs(), MONTH, YEAR);
		paymentInfoPage = addACreditCardPage.returnPaymentInformationPage();
		paymentInfoPage.checkCreditCardDE(CARD_OWNER, typeCard.MASTER_CARD1.getName(), expirationDate);
		paymentInfoPage.deleteCreditCardYesDE(CARD_OWNER, typeCard.MASTER_CARD1.getName(), expirationDate);
		logger.info("Finishing add credit card & delete it Germany test");
  } 
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageDE.quit();
		signInPage.quit();
		addACreditCardPage.quit();
		paymentInfoPage.quit();
		myAccountPage.quit();
	
	}
}