package com.ariat.Tests.CreditCard.Countries.MakeDefaultCreditCard;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Enums.ListOfCreditCards;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageNO;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.PaymentInformationPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.KillChrome;
import com.ariat.Pages.Header.SignInPage;

/**
 * Tests for delete credit card Norway
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MakeDefaultCreditCardNOTest extends BaseTest {

	private HomePage homePage;
	private HomePageNO homePageNO;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private PaymentInformationPage paymentInfoPage;
	private Environments environment;
	private EUCountries euCountry;
	private ListOfCreditCards typeCard;

	private static final String EMAIL = "aila.bogasieru@yahoo.com";
	private static final String PASSWORD = "Parola12345!";

	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}

	@Test
	public void makeDefaultCreditCardFromPaymentInfoNOTest() {
		logger.info("Starting make default credit card from Payment Info Norway test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageNO = (HomePageNO) homePage.chooseEULocation(euCountry.NO, euCountry.NO.getCurrencyISO());
		signInPage = homePageNO.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		paymentInfoPage = myAccountPage.returnPaymentInformationPageAddDeleteCardMiddleNav();
		// paymentInfoPage.makeDefaultCreditCard("were", typeCard.VISA.getName(),
		// "05/2016");
		logger.info("Finishing make default credit card from Payment info Netherlands test");

	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageNO.quit();
		homePageUK.quit();
		signInPage.quit();
		paymentInfoPage.quit();
		myAccountPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}