package com.ariat.Pages.Categories.MenCategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearCasualShoesPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearCountryPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearRidingPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearWesternPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearWorkPage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Men Footwear Category Page from top & left navigations
 * @author aila.bogasieru@ariat.com
 *
 */

public class MenFootwearPage extends BasePage{
	
	private By menFootwearRidingCategory = By.linkText("Riding");
	private By menFootwearRidingText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By menFootwearCountryCategory = By.linkText("Country");
	private By menFootwearCountryText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By menFootwearWesternCategory = By.linkText("Western");
    private By menFootwearWesternText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
    private By menFootwearCasualShoesCategory = By.linkText("Casual Shoe");
    private By menCasualShoesText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
    private By menFootwearWorkCategory = By.linkText("Work");
    private By menFootwearWorkText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
    private By footwearRidingCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[1]/a");
    private By footwearCountryCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[2]/a");
    private By footwearWesternCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[3]/a");
    private By footwearWorkCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[4]/a");
    private By footwearCasualShoesCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[5]/a");
   

	public MenFootwearPage(WebDriver driver) {
		super(driver);
		}
	
	//Top navigation
	
	public MenFootwearRidingPage returnMenFootwearRidingCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, menFootwearRidingCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFootwearRidingText));
		return new MenFootwearRidingPage(driver);
	}
	
	public MenFootwearCountryPage returnMenFootwearCountryCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, menFootwearCountryCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFootwearCountryText));
		return new MenFootwearCountryPage(driver);
	}
	
	public MenFootwearWesternPage returnMenFootwearWesternCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, menFootwearWesternCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFootwearWesternText));
		return new MenFootwearWesternPage(driver);
	}
	
	public MenFootwearWorkPage returnMenFootwearWorkCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, menFootwearWorkCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFootwearWorkText));
		return new MenFootwearWorkPage(driver);
	}
	
	public MenFootwearCasualShoesPage returnMenFootwearCasualShoesCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, menFootwearCasualShoesCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menCasualShoesText));
		return new MenFootwearCasualShoesPage(driver);
	}
	
	//Left navigation
	
	public MenRidingPage returnMenRidingCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, footwearRidingCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFootwearRidingText));
		return new MenRidingPage(driver);
	}
	
	public MenFootwearCountryPage returnMenFootwearCountryCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, footwearCountryCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFootwearCountryText));
		return new MenFootwearCountryPage(driver);
	}
	
	public MenFootwearWesternPage returnMenFootwearWesternCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, footwearWesternCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFootwearWesternText));
		return new MenFootwearWesternPage(driver);
	}
	
	public MenFootwearWorkPage returnMenFootwearWorkCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, footwearWorkCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFootwearWorkText));
		return new MenFootwearWorkPage(driver);
	}
	
	public MenFootwearCasualShoesPage returnMenFootwearCasualShoesCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, footwearCasualShoesCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menCasualShoesText));
		return new MenFootwearCasualShoesPage(driver);
	}
}

