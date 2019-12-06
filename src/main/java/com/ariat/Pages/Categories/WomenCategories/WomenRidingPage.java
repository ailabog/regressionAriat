package com.ariat.Pages.Categories.WomenCategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesBagsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesHeadwearPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesSocksPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingOuterwearPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingSweatTshirtAndWoodiesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories.WomenClothingTopsAndTshirtsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearRidingSubcategories.WomenFootwearAllWeatherRidingPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearRidingSubcategories.WomenFootwearRidingBarnyardPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearRidingSubcategories.WomenFootwearRidingEndurancePage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearRidingSubcategories.WomenFootwearRidingHalfChapsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearRidingSubcategories.WomenFootwearRidingPaddockPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwear.WomenFootwearRidingSubcategories.WomenFootwearRidingToolBootsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearRidingPage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Women Riding Page
 * @author aila.bogasieru@ariat.com
 *
 */

public class WomenRidingPage extends BasePage{

	private By shopRidingButton = By
			.xpath("//*[@id=\"Men-Riding-Tribe-Hero-Show-Feb18\"]/div/a/div[2]/div[2]/span/span[1]");
	private By menFootwearRidingText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By footwearSwitcher = By.xpath("//*[@id=\"main\"]/div[1]/ul/li[1]/a/span[2]");
	private By clothingSwitcher = By.xpath("//*[@id=\"main\"]/div[1]/ul/li[2]/a/span[2]");
	private By accessoriesSwitcher = By.xpath("//*[@id=\"main\"]/div[1]/ul/li[3]/a/span[2]");
	private By tallBootsFootwearLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[1]/a");
	private By paddockFootwearLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[2]/a");
	private By halfChapsFoowearLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[3]/a");
	private By allWeatherRidingFootwearLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[4]/a");
	private By enduranceFootwearLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[5]/a");
	private By barnyardFootwearLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[6]/a");
	private By outwearClothingLeftNav = By.xpath("//*[@id=\"main\"]/div[1]/ul/li[2]/ul/li[1]/a");
	private By sweatshirtsAndWoodiesClothingLeftNav = By.xpath("//*[@id=\"main\"]/div[1]/ul/li[2]/ul/li[2]/a");
	private By topsAndTshirtsClothingCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div[1]/ul/li[2]/ul/li[3]/a");
	private By tallBootsFootwearCategoryText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By paddockFootwearCategoryText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By halfChapsFootwearCategoryText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By allWeatherRidingBootsCategoryText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By enduranceFootwearText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By barnyardFootwearText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By menClothingOuterwearText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By menClothingSweatTshirtAndWoodiesText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By menClothingTopsAndTshirtsText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By accessoriesHeadwearLeftNav = By.xpath("//*[@id=\"main\"]/div[1]/ul/li[3]/ul/li[1]/a");
	private By menAccessoriesHeadwearText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By accessoriesBagsLeftNav = By.xpath("//*[@id=\"main\"]/div[1]/ul/li[3]/ul/li[2]/a");
	private By accessoriesGlovesLeftNav = By.xpath("//*[@id=\"main\"]/div[1]/ul/li[3]/ul/li[3]/a");
	private By accessoriesSocksLeftNav = By.xpath("//*[@id=\"main\"]/div[1]/ul/li[3]/ul/li[4]/a");
	private By menAccessoriesGlovesText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By menAccessoriesBagsText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By menAccessoriesSocksText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");

	public WomenRidingPage(WebDriver driver) {
		super(driver);

	}

	public WomenFootwearRidingPage returnWomenFootwearRidingCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, shopRidingButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFootwearRidingText));
		return new WomenFootwearRidingPage(driver);
	}

	public void footwearClick() {
		WebDriverUtils.clickOnElementWithWait(driver, footwearSwitcher);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
	}

	public void clothingClick() {
		WebDriverUtils.clickOnElementWithWait(driver, clothingSwitcher);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
	}

	public void accessoriesClick() {
		WebDriverUtils.clickOnElementWithWait(driver, accessoriesSwitcher);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
	}

	public WomenFootwearRidingToolBootsPage returnWomenFootwearRidingToolBootsPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, tallBootsFootwearLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(tallBootsFootwearCategoryText));
		return new WomenFootwearRidingToolBootsPage(driver);
	}

	public WomenFootwearRidingPaddockPage returnWomenFootwearRidingPaddockPagePageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, paddockFootwearLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(paddockFootwearCategoryText));
		return new WomenFootwearRidingPaddockPage(driver);
	}

	public WomenFootwearRidingHalfChapsPage returnWomenFootwearRidingHalfChapsCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, halfChapsFoowearLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(halfChapsFootwearCategoryText));
		return new WomenFootwearRidingHalfChapsPage(driver);
	}

	public WomenFootwearAllWeatherRidingPage returnWomenFootwearAllWeatherRidingCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, allWeatherRidingFootwearLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(allWeatherRidingBootsCategoryText));
		return new WomenFootwearAllWeatherRidingPage(driver);
	}

	public WomenFootwearRidingEndurancePage returnWomenFootwearRidingEnduranceCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, enduranceFootwearLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(enduranceFootwearText));
		return new WomenFootwearRidingEndurancePage(driver);
	}

	public WomenFootwearRidingBarnyardPage returnWomenFootwearRidingBarnyardCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, barnyardFootwearLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(barnyardFootwearText));
		return new WomenFootwearRidingBarnyardPage(driver);
	}

	public WomenClothingOuterwearPage returnWomenClothingOutwearCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, outwearClothingLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingOuterwearText));
		return new WomenClothingOuterwearPage(driver);

	}

	public WomenClothingSweatTshirtAndWoodiesPage returnWomenClothingSweatTshirtAndWoodiesCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, sweatshirtsAndWoodiesClothingLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingSweatTshirtAndWoodiesText));
		return new WomenClothingSweatTshirtAndWoodiesPage(driver);

	}

	public WomenClothingTopsAndTshirtsPage returnWomenClothingTopsAndTshirtsCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, topsAndTshirtsClothingCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingTopsAndTshirtsText));
		return new WomenClothingTopsAndTshirtsPage(driver);

	}

	public WomenAccessoriesBagsPage returnWomenAccessoriesBagsCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, accessoriesBagsLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menAccessoriesBagsText));
		return new WomenAccessoriesBagsPage(driver);

	}

	public WomenAccessoriesSocksPage returnWomenAccessoriesSocksCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, accessoriesSocksLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menAccessoriesSocksText));
		return new WomenAccessoriesSocksPage(driver);

	}

	public WomenAccessoriesGlovesPage returnWomenAccessoriesGlovesCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, accessoriesGlovesLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menAccessoriesGlovesText));
		return new WomenAccessoriesGlovesPage(driver);

	}

	public WomenAccessoriesHeadwearPage returnWomenAccessoriesHeadwearCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, accessoriesHeadwearLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menAccessoriesHeadwearText));
		return new WomenAccessoriesHeadwearPage(driver);
	}
}
