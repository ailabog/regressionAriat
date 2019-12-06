package com.ariat.Pages.Categories.MenCategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Categories.MenCategories.MenClothingSubcategories.MenClothingBreechesPage;
import com.ariat.Pages.Categories.MenCategories.MenClothingSubcategories.MenClothingOuterwearPage;
import com.ariat.Pages.Categories.MenCategories.MenClothingSubcategories.MenClothingSweatTshirtAndWoodiesPage;
import com.ariat.Pages.Categories.MenCategories.MenClothingSubcategories.MenClothingTopsAndTshirtsPage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Women Clothing Category Page top & left navigations
 * @author aila.bogasieru@ariat.com
 *
 */

public class MenClothingPage extends BasePage{
	
	private By menClothingOuterwearCategory = By.linkText("Outerwear");
	private By menClothingOuterwearText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
    private By menClothingSweatTshirtAndWoodiesCategory = By.linkText("Sweatshirts & Hoodies");
    private By menClothingSweatTshirtAndWoodiesText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By menClothingTopsAndTshirtsCategory = By.xpath("//*[@id=\"global-nav-container\"]/li[2]/div[2]/div/div[2]/ul[2]/li/ul/li[3]/a");
	private By menClothingTopsAndTshirtsText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By menClothingBreechesCategory = By.linkText("Tops & T-Shirts");
	private By clothingOuterwearCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[1]/a");
	private By clothingSweatTshirtAndWoodiesCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[2]/a");
	private By clothingTopsAndTshirtsCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[3]/a");
	private By clothingBreechesCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[4]/a");
	
	public MenClothingPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Top navigation
	public MenClothingOuterwearPage returnMenClothingOuterwearCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, menClothingOuterwearCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingOuterwearText));
		return new MenClothingOuterwearPage(driver);
	}
	
	public MenClothingSweatTshirtAndWoodiesPage returnMenClothingSweatTshirtAndWoodiesCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, menClothingSweatTshirtAndWoodiesCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingSweatTshirtAndWoodiesText));
		return new MenClothingSweatTshirtAndWoodiesPage(driver);
	}
	
	public MenClothingTopsAndTshirtsPage returnMenClothingTopsAndTshirtsCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, menClothingTopsAndTshirtsCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingTopsAndTshirtsText));
		return new MenClothingTopsAndTshirtsPage(driver);
	}
	
	public MenClothingBreechesPage returnMenClothingBreechesCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, menClothingBreechesCategory);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		return new MenClothingBreechesPage(driver);
	}
	
	//Left navigation
	
	public MenClothingOuterwearPage returnMenClothingOuterwearCategoryLeftNavPage() {
		WebDriverUtils.clickOnElementWithWait(driver, clothingOuterwearCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingOuterwearText));
		return new MenClothingOuterwearPage(driver);
	}
	
	public MenClothingSweatTshirtAndWoodiesPage returnMenClothingSweatTshirtAndWoodiesCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, clothingSweatTshirtAndWoodiesCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingSweatTshirtAndWoodiesText));
		return new MenClothingSweatTshirtAndWoodiesPage(driver);
	}
	
	public MenClothingTopsAndTshirtsPage returnMenClothingTopsAndTshirtsCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, clothingTopsAndTshirtsCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingTopsAndTshirtsText));
		return new MenClothingTopsAndTshirtsPage(driver);
	}
	
	public MenClothingBreechesPage returnMenClothingBreechesCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, clothingBreechesCategoryLeftNav);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		return new MenClothingBreechesPage(driver);
	}
}
