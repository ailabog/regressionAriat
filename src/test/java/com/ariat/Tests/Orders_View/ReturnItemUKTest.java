package com.ariat.Tests.Orders_View;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.ReturnItemsPage;
import com.ariat.Pages.SalesReturnConfirmationPage;
import com.ariat.Pages.VerifyReturnItemsPage;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.MyOrdersPage;
import com.ariat.Pages.Main.OrderDetailsPage;
import com.ariat.Tests.Base.BaseTest;

/**
 * Test return item for an logged customer and for a returning customer using different navigation
 * top nav for returning customer
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class ReturnItemUKTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private OrderDetailsPage orderDetailsPage;
	private ReturnItemsPage returnItemsPage;
	private VerifyReturnItemsPage verifyReturnItemsPage;
	private SalesReturnConfirmationPage salesReturnConfirmationPage;
	private com.ariat.Pages.Main.MyAccountPage myAccountPage;
	private MyOrdersPage myOrdersPage;

	public static final String EMAIL = "aila.bogasieru@ariat.com";
	public static final String PASSWORD = "Parola12345!";
	public static final String ORDER_NO = "10003202";
	public static final String BILLING_ZIP_CODE = "41641";
	private static final String RETURN_REASON = "Uncomfortable";
	private static final String RETURN_REASON1 = "Shipping error";
	private static final String EXPECTED_MESSAGE = "Please select at least one item you wish to return";
	private static final String REASON_DESCRIPTION = "The article is not comfortable as expected";
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
	public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}
	
	@Test
	public void returnItemWithoutBeingLoggedTest() {
		logger.info("Starting  return item for a customer not being logged test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		signInPage = homePageUK.returnSignInPage();
		signInPage.checkOrder(ORDER_NO, EMAIL, BILLING_ZIP_CODE);
		orderDetailsPage = signInPage.returnOrderDetailsPage();
		returnItemsPage = orderDetailsPage.returnReturnItemsPage();
		returnItemsPage.continueClick();
		returnItemsPage.AssertNoReason(EXPECTED_MESSAGE);
		orderDetailsPage = returnItemsPage.returnOrderDetailsPage();
		returnItemsPage = orderDetailsPage.returnReturnItemsPage();
		returnItemsPage.continueClick();
		returnItemsPage.checkItemClick();
		returnItemsPage.selectReturnReason(RETURN_REASON);
		returnItemsPage.describeReason(REASON_DESCRIPTION);
		returnItemsPage.selectQuantity("1");
		verifyReturnItemsPage = returnItemsPage.returnVerifyReturnItemsPage();
		salesReturnConfirmationPage = verifyReturnItemsPage.returnSalesReturnConfirmationPage();
		salesReturnConfirmationPage.returnOrderDetailsPage();
		logger.info("Finishing return item for a customer not being logged test...");
	}

	@Test
	public void returnItemReturningCustomerTest() {
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		signInPage = homePageUK.returnSignInPage();
		signInPage.setLoginDetails(EMAIL, "EnglishUK", PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myOrdersPage = myAccountPage.returnMyOrdersPageTopNav();
		orderDetailsPage = myOrdersPage.returnOrderDetailsPage();
		returnItemsPage = orderDetailsPage.returnReturnItemsPage();
		returnItemsPage.checkItemClick();
		returnItemsPage.selectReturnReason(RETURN_REASON1);
		returnItemsPage.describeReason(REASON_DESCRIPTION);
		returnItemsPage.selectQuantity("1");
		verifyReturnItemsPage = returnItemsPage.returnVerifyReturnItemsPage();
		verifyReturnItemsPage.editReturn();
		returnItemsPage.selectQuantity("2");
		verifyReturnItemsPage = returnItemsPage.returnVerifyReturnItemsPage();
		salesReturnConfirmationPage = verifyReturnItemsPage.returnSalesReturnConfirmationPage();
		salesReturnConfirmationPage.returnOrderDetailsPage();
		logger.info("Finishing return item as returning customer test...");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
		signInPage.quit();
		myAccountPage.quit();
		orderDetailsPage.quit();
		returnItemsPage.quit();
		verifyReturnItemsPage.quit();
		salesReturnConfirmationPage.quit();
	}
}
