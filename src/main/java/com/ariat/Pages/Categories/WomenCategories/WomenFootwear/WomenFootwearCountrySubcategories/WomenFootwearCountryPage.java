package com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearCountrySubcategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Women Footwear Country Page
 * @author aila.bogasieru@ariat.com
 *
 */

public class WomenFootwearCountryPage extends BasePage {

	private By tallBootsFootwearCountryCategoryleftNav = By
			.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[1]/a");
	private By walkingFootwearCountryCategoryleftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[4]/a");
	private By fashionFootwearCountryCategoryleftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[3]/a");
	private By rubberFootwearCountryCategoryleftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[2]/a");
	private By tallBootsFootwearCountryText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By rubberFootwearCountryText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By fashionFootwearCountryText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/h1");
	private By walkingFootwearCountryText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");

	public WomenFootwearCountryPage(WebDriver driver) {
		super(driver);
	}

	public WomenFootwearCountryFashionPage returnWomenFootwearCountryOutdoorCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, fashionFootwearCountryCategoryleftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(fashionFootwearCountryText));
		return new WomenFootwearCountryFashionPage(driver);
	}

	public WomenFootwearCountryRubberPage returnWomenFootwearCountryRubberCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, rubberFootwearCountryCategoryleftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(rubberFootwearCountryText));
		return new WomenFootwearCountryRubberPage(driver);
	}

	public WomenFootwearCountryToolBootsPage returnWomenFootwearCountryTallBootsCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, tallBootsFootwearCountryCategoryleftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(tallBootsFootwearCountryText));
		return new WomenFootwearCountryToolBootsPage(driver);
	}

	public WomenFootwearCountryWalkingPage returnWomenFootwearCountryWalkingCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, walkingFootwearCountryCategoryleftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(walkingFootwearCountryText));
		return new WomenFootwearCountryWalkingPage(driver);
	}
}
