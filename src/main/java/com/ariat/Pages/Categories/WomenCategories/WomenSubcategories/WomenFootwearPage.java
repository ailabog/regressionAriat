package com.ariat.Pages.Categories.WomenCategories.WomenSubcategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Categories.WomenCategories.WomenRidingPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearCasualShoesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearCountryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearRidingPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearWesternPage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements returns methods to pages: 
 * Women Footwear Riding Category Page
 * Women Footwear CasualShoes Category Page
 * Women Footwear Western Category Page
 * Women Footwear Country Category Page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class WomenFootwearPage extends BasePage{
	

	private By womenFootwearRidingCategoryFR = By.linkText("Equitation");
	private By womenFootwearRidingText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By womenFootwearCountryCategory = By.linkText("Country");
	private By womenFootwearCountryCategoryFR = By.linkText("Campagne");
	private By womenFootwearCountryText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By womenFootwearWesternCategory = By.linkText("Western");
    private By womenFootwearWesternText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
    private By womenFootwearCasualShoesCategory = By.xpath("//a[contains(text(),'Casual Shoes')])[2]");
    private By womenFootwearCasualShoesCategoryFR = By.linkText("Chaussures de loisir");
    private By womenFootwearCasualShoesCategoryDE = By.linkText("Freizeitschuhe");
    private By casualShoesText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
    private By womenCategory = By.linkText("//a[contains(text(),'Women')]");
    private By menFootwearRidingText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By footwearRidingCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[1]/a");

	public WomenFootwearPage(WebDriver driver) {
		super(driver);
	}
	
	public void womenCategory() {
		WebDriverUtils.moveToElement(driver, womenCategory);
	}
	
	
	public WomenFootwearRidingPage returnWomenFootwearRidingCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, womenFootwearRidingCategoryFR);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenFootwearRidingText));
		return new WomenFootwearRidingPage(driver);
	}
	
	public WomenFootwearRidingPage returnWomenFootwearRidingCategoryPageFR() {
		WebDriverUtils.clickOnElementWithWait(driver, womenFootwearRidingCategoryFR);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenFootwearRidingText));
		return new WomenFootwearRidingPage(driver);
	}
	
	public WomenFootwearCountryPage returnWomenFootwearCountryCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, womenFootwearCountryCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenFootwearCountryText));
		return new WomenFootwearCountryPage(driver);
	}
	
	public WomenFootwearCountryPage returnWomenFootwearCountryCategoryPageFR() {
		WebDriverUtils.clickOnElementWithWait(driver, womenFootwearCountryCategoryFR);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenFootwearCountryText));
		return new WomenFootwearCountryPage(driver);
	}
	
	public WomenFootwearWesternPage returnWomenFootwearWesternCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, womenFootwearWesternCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(womenFootwearWesternText));
		return new WomenFootwearWesternPage(driver);
	}
	
	public WomenFootwearCasualShoesPage returnWomenFootwearCasualShoesCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, womenFootwearCasualShoesCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(casualShoesText));
		return new WomenFootwearCasualShoesPage(driver);
	}
	
	public WomenFootwearCasualShoesPage returnWomenFootwearCasualShoesCategoryPageFR() {
		WebDriverUtils.clickOnElementWithWait(driver, womenFootwearCasualShoesCategoryFR);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(casualShoesText));
		return new WomenFootwearCasualShoesPage(driver);
	}
	
	public WomenFootwearCasualShoesPage returnWomenFootwearCasualShoesCategoryPageDE() {
		WebDriverUtils.clickOnElementWithWait(driver, womenFootwearCasualShoesCategoryDE);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(casualShoesText));
		return new WomenFootwearCasualShoesPage(driver);
	}

	public WomenRidingPage returnWomennRidingCategoryPageLeftNav() {
			WebDriverUtils.clickOnElementWithWait(driver, footwearRidingCategoryLeftNav);
			WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
					ExpectedConditions.invisibilityOfElementLocated(menFootwearRidingText));
			return new WomenRidingPage(driver);
	}
}
