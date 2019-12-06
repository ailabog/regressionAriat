package com.ariat.Pages.Categories.MenCategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Categories.MenCategories.MenAccessoriesSubcategories.MenAccessoriesBagsPage;
import com.ariat.Pages.Categories.MenCategories.MenAccessoriesSubcategories.MenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.MenCategories.MenAccessoriesSubcategories.MenAccessoriesHeadwearPage;
import com.ariat.Pages.Categories.MenCategories.MenAccessoriesSubcategories.MenAccessoriesSocksPage;
import com.ariat.Pages.Categories.MenCategories.MenClothingSubcategories.MenClothingOuterwearPage;
import com.ariat.Pages.Categories.MenCategories.MenClothingSubcategories.MenClothingSweatTshirtAndWoodiesPage;
import com.ariat.Pages.Categories.MenCategories.MenClothingSubcategories.MenClothingTopsAndTshirtsPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearRiding.MenFootwearRidingCategories.MenFootwearAllWeatherRidingPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearRiding.MenFootwearRidingCategories.MenFootwearRidingBarnyardPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearRiding.MenFootwearRidingCategories.MenFootwearRidingEndurancePage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearRiding.MenFootwearRidingCategories.MenFootwearRidingHalfChapsPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearRiding.MenFootwearRidingCategories.MenFootwearRidingPaddockPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearRiding.MenFootwearRidingCategories.MenFootwearRidingToolBootsPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearRidingPage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * This contains Men Riding Page' locators, methods and links with next pages
 * @author aila.bogasieru@ariat.com
 *
 */

public class MenRidingPage extends BasePage {

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

	public MenRidingPage(WebDriver driver) {
		super(driver);

	}

	public MenFootwearRidingPage returnMenFootwearRidingCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, shopRidingButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFootwearRidingText));
		return new MenFootwearRidingPage(driver);
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

	public MenFootwearRidingToolBootsPage returnMenFootwearRidingToolBootsPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, tallBootsFootwearLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(tallBootsFootwearCategoryText));
		return new MenFootwearRidingToolBootsPage(driver);
	}

	public MenFootwearRidingPaddockPage returnMenFootwearRidingPaddockPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, paddockFootwearLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(paddockFootwearCategoryText));
		return new MenFootwearRidingPaddockPage(driver);
	}

	public MenFootwearRidingHalfChapsPage returnMenFootwearRidingHalfChapsCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, halfChapsFoowearLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(halfChapsFootwearCategoryText));
		return new MenFootwearRidingHalfChapsPage(driver);
	}

	public MenFootwearAllWeatherRidingPage returnMenFootwearAllWeatherRidingCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, allWeatherRidingFootwearLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(allWeatherRidingBootsCategoryText));
		return new MenFootwearAllWeatherRidingPage(driver);
	}

	public MenFootwearRidingEndurancePage returnMenFootwearRidingEnduranceCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, enduranceFootwearLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(enduranceFootwearText));
		return new MenFootwearRidingEndurancePage(driver);
	}

	public MenFootwearRidingBarnyardPage returnMenFootwearRidingBarnyardCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, barnyardFootwearLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(barnyardFootwearText));
		return new MenFootwearRidingBarnyardPage(driver);
	}

	public MenClothingOuterwearPage returnMenClothingOutwearCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, outwearClothingLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingOuterwearText));
		return new MenClothingOuterwearPage(driver);

	}

	public MenClothingSweatTshirtAndWoodiesPage returnMenClothingSweatTshirtAndWoodiesCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, sweatshirtsAndWoodiesClothingLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingSweatTshirtAndWoodiesText));
		return new MenClothingSweatTshirtAndWoodiesPage(driver);

	}

	public MenClothingTopsAndTshirtsPage returnMenClothingTopsAndTshirtsCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, topsAndTshirtsClothingCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingTopsAndTshirtsText));
		return new MenClothingTopsAndTshirtsPage(driver);

	}

	public MenAccessoriesBagsPage returnMenAccessoriesBagsCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, accessoriesBagsLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menAccessoriesBagsText));
		return new MenAccessoriesBagsPage(driver);

	}

	public MenAccessoriesSocksPage returnMenAccessoriesSocksCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, accessoriesSocksLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menAccessoriesSocksText));
		return new MenAccessoriesSocksPage(driver);

	}

	public MenAccessoriesGlovesPage returnMenAccessoriesGlovesCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, accessoriesGlovesLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menAccessoriesGlovesText));
		return new MenAccessoriesGlovesPage(driver);

	}

	public MenAccessoriesHeadwearPage returnMenAccessoriesHeadwearCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, accessoriesHeadwearLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menAccessoriesHeadwearText));
		return new MenAccessoriesHeadwearPage(driver);

	}

}
