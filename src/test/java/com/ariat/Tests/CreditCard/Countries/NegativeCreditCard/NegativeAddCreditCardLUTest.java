package com.ariat.Tests.CreditCard.Countries.NegativeCreditCard;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Enums.ListOfCreditCards;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageLU;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.AddACreditCardPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.PaymentInformationPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;

/**
 * Tests for Negative Add Credit card Denmark
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class NegativeAddCreditCardLUTest extends BaseTest {

	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageLU homePageLU;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private AddACreditCardPage addACreditCardPage;
	private PaymentInformationPage paymentInfoPage;
	private Environments environment;
	private EUCountries euCountry;
	private ListOfCreditCards typeCard;

	private static final String EMAIL = "aila.bogasieru@ariat.com";
	private static final String PASSWORD = "Parola12345!";
	private static final String CARD_ID = "ryttrytry";
	private static final String CARD_OWNER = "5654657665";
	private static final String YEAR = "2021";
	private static final String MONTH = "January";

	private static final String YEAR1 = "2009";
	private static final String MONTH1 = "January";

	private static final String CARD_IDWILD = "#$%^&*(";
	private static final String CARD_OWNERWILD = "@#$%^&*(";

	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}


	@Test(priority = 0)
	public void negativeAddCreditCardDKTest() {
		String expirationDate = "MONTH/YEAR";
		logger.info("Starting add negative credit card FI test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageLU = (HomePageLU) homePage.chooseEULocation(euCountry.LU, euCountry.LU.getCurrencyISO());
		signInPage = homePageLU.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addACreditCardPage = myAccountPage.returnAddACreditCardMiddleNav();
		addACreditCardPage.setDetailsCreditCard(CARD_ID, CARD_OWNER, typeCard.VISA.getName(), typeCard.VISA.getNumber(), typeCard.VISA.getCvs(), MONTH, YEAR);
		paymentInfoPage = addACreditCardPage.returnPaymentInformationPage();
		paymentInfoPage.checkCreditCard(CARD_OWNER, typeCard.VISA.getName(), expirationDate);
		logger.info("Finishing add negative credit card FI test");
	}

	@Test(priority = 1)
	public void negativeAddCreditCardDKTestWildCard() {
		String expirationDate = "MONTH/YEAR";
		logger.info("Starting add negative credit card DK test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageLU = (HomePageLU) homePage.chooseEULocation(euCountry.LU, euCountry.LU.getCurrencyISO());
		signInPage = homePageLU.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addACreditCardPage = myAccountPage.returnAddACreditCardMiddleNav();
		addACreditCardPage.setDetailsCreditCard(CARD_IDWILD, CARD_OWNERWILD, typeCard.VISA.getName(), "#$%^&*", typeCard.VISA.getCvs(), MONTH, YEAR);
		paymentInfoPage = addACreditCardPage.returnPaymentInformationPage();
		paymentInfoPage.checkCreditCard(CARD_OWNER, typeCard.VISA.getName(), expirationDate);
		logger.info("Finishing add negative credit card DK test");
	}
	@Test(priority = 2)
	public void negativeAddCreditCardDKTestMissingValues() {
		String expirationDate = "MONTH/YEAR";
		logger.info("Starting add negative credit card FI test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageLU = (HomePageLU) homePage.chooseEULocation(euCountry.LU, euCountry.LU.getCurrencyISO());
		signInPage = homePageLU.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addACreditCardPage = myAccountPage.returnAddACreditCardMiddleNav();
		addACreditCardPage.setDetailsCreditCard(CARD_ID, CARD_OWNER, typeCard.VISA.getName(), null, typeCard.VISA.getCvs(), MONTH, YEAR);
		paymentInfoPage = addACreditCardPage.returnPaymentInformationPage();
		paymentInfoPage.checkCreditCard(CARD_OWNER, typeCard.VISA.getName(), expirationDate);
		logger.info("Finishing add negative credit card FI test");
	}

	@Test(priority = 3)
	public void negativeAddCreditCardDKTestExpirationDate() {
		String expirationDate = "MONTH1/YEAR1";
		logger.info("Starting add a credit card FI test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageLU = (HomePageLU) homePage.chooseEULocation(euCountry.LU, euCountry.LU.getCurrencyISO());
		signInPage = homePageLU.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addACreditCardPage = myAccountPage.returnAddACreditCardMiddleNav();
		addACreditCardPage.setDetailsCreditCard(CARD_ID, CARD_OWNER, typeCard.VISA.getName(), null, typeCard.VISA.getCvs(), MONTH1, YEAR1);
		paymentInfoPage = addACreditCardPage.returnPaymentInformationPage();
		paymentInfoPage.checkCreditCard(CARD_OWNER, typeCard.VISA.getName(), expirationDate);
		logger.info("Finishing add a credit card FI test");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageLU.quit();
		signInPage.quit();
		addACreditCardPage.quit();
		paymentInfoPage.quit();
		myAccountPage.quit();
	}
}