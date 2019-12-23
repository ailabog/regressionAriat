package com.ariat.Pages.HomePagesCountries;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.GlobalCountries;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * This contains the Login page with all locators and methods associated and
 * links to SignIn page and Logout page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class HomePage extends BasePage implements List<HomePage> {

	private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

	public static final String URL = "https://development.ariat.com";

	private By closeLocationx = By.xpath("//*[@id=\"ext-gen44\"]/body/div[6]/div[1]/a/span");
	private By ariatLogo = By.className("global-nav-logo-svg");
	private By saveAndContinueLocationButton = By.id("btnSaveContext");
	private By chooseLocationArrow = By.xpath("//*[@id=\"chooserTriggerHeader\"]/span/span");
	private By listCountries = By.xpath("//*[@id=\"contextChooser\"]/ul[1]");
	private By countrySelectorWindow = By.xpath("//span[@class='icon icon-full-arrow-down ms_desktop-only']");


	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void verifyLogo() {
		logger.info("Ariat Logo is being displayed");
		WebDriverUtils.getElementText(driver, ariatLogo);
	}

	public HomePage closeLocation() {
		logger.info("Closing the location..");
		WebDriverUtils.clickOnElementWithWait(driver, closeLocationx);
		return new HomePage(driver);
	}

	public List<HomePage> chooseGlobalLocation(GlobalCountries country, String currency) {
		logger.info("Selecting global Ariat store country...");
		switch (country.getCountryName()) {
		case "United States":
			logger.info("I choose US as a location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.clickOnElementWithWait(driver, country.USA.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.clickOnElementWithWait(driver, country.USA.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			}
			return new HomePageUS(driver);

		case "United Kingdom":
			logger.info("I choose United Kingdom as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.scrollDown(driver, country.UK.getLocator());
				WebDriverUtils.scrolltoElement(driver, country.UK.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.clickOnElementWithWait(driver, country.UK.getLocator());
			}
			return new HomePageUK(driver);
	
		// TO DO ADD THE REST OF THE COUNTRIES FROM THE ENUM
		default:
			throw new RuntimeException("Country" + country + "not supported");
		}
	}

	public List<HomePage> chooseEULocation(EUCountries euCountry, String currency) {
		logger.info("Selecting EU  Ariat store country...");

		switch (euCountry.getCountryName()) {
		case "(United States)":
			logger.info("I choose United States as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.scrollLittDown(driver, euCountry.USA.getLocator());
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.USA.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			}
			return new HomePageUS(driver);

     		
		/*Jenkins version 
			case "(United Kingdom)":
			logger.info("I choose English United Kingdom as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.scrollLittDown(driver, euCountry.UK.getLocator());
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.UK.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.UK.getLocator());
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
			}
			return new HomePageUK(driver);*/
			//local version
		case "(United Kingdom)":
			logger.info("I choose English United Kingdom as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.scrolltoElement(driver, euCountry.UK.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.UK.getLocator());
			}
			return new HomePageUK(driver); 

		case "(Belgium)":
			logger.info("I choose English Belgium as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.BE.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			}
			return new HomePageBE(driver);

	
		case "(Ireland)":
			logger.info("I choose English Ireland as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.scrollLittDown(driver, euCountry.IE.getLocator());
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.IE.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			}
			return new HomePageIE(driver);

		case "(Denmark)":
			logger.info("I choose English Denmark as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.scrollLittDown(driver, euCountry.DK.getLocator());
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.DK.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			}
			return new HomePageDK(driver);

		case "(France)":
			logger.info("I choose Francais France as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.scrollLittDown(driver, euCountry.FR.getLocator());
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.FR.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			}
			return new HomePageFR(driver);

		case "(Deutschland)":
			logger.info("I choose Deutsch Deutschland as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.DE.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			}
			return new HomePageDE(driver);

		case "(Norway)":
			logger.info("I choose English Norway as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.NO.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			}
			return new HomePageNO(driver);

		case "(Finland)":
			logger.info("I choose English  Finland as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.scrollLittDown(driver, euCountry.FI.getLocator());
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.FI.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);

			}
			return new HomePageFI(driver);

		case "(Netherlands)":
			logger.info("I choose English Netherlands as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.scroll350Down(driver, euCountry.NL.getLocator());
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.NL.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			}
			return new HomePageNL(driver);

		case "(Luxembourg)":
			logger.info("I choose English  Luxembourg as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.scrollLittDown(driver, euCountry.LU.getLocator());
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.LU.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			}
			return new HomePageLU(driver);

		case "(Sweden)":
			logger.info("I choose English  Sweden as location");
			WebDriverUtils.clickOnElementWithWait(driver, chooseLocationArrow);
			if (WebDriverUtils.findElement(driver, countrySelectorWindow) != null) {
				WebDriverUtils.clickOnElementWithWait(driver, listCountries);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				WebDriverUtils.scroll350Down(driver, euCountry.SE.getLocator());
				WebDriverUtils.clickOnElementWithWait(driver, euCountry.SE.getLocator());
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
				logger.info("Saving location...");
				WebDriverUtils.clickOnElementWithWait(driver, saveAndContinueLocationButton);
				WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
			}
			return new HomePageSE(driver);

		default:
			throw new RuntimeException("Country" + euCountry + "not supported");
		}
	}

	public void loadHomePage(String url) {
		load(url);
	}

	@Override
	public boolean add(HomePage e) {

		return false;
	}

	@Override
	public void add(int index, HomePage element) {

	}

	@Override
	public boolean addAll(Collection<? extends HomePage> c) {

		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends HomePage> c) {

		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public boolean contains(Object o) {

		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {

		return false;
	}

	@Override
	public HomePage get(int index) {

		return null;
	}

	@Override
	public int indexOf(Object o) {

		return 0;
	}

	@Override
	public boolean isEmpty() {

		return false;
	}

	@Override
	public Iterator<HomePage> iterator() {

		return null;
	}

	@Override
	public int lastIndexOf(Object o) {

		return 0;
	}

	@Override
	public ListIterator<HomePage> listIterator() {

		return null;
	}

	@Override
	public ListIterator<HomePage> listIterator(int index) {

		return null;
	}

	@Override
	public boolean remove(Object o) {

		return false;
	}

	@Override
	public HomePage remove(int index) {

		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {

		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {

		return false;
	}

	@Override
	public HomePage set(int index, HomePage element) {

		return null;
	}

	@Override
	public int size() {

		return 0;
	}

	@Override
	public List<HomePage> subList(int fromIndex, int toIndex) {

		return null;
	}

	@Override
	public Object[] toArray() {

		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {

		return null;

	}
}
