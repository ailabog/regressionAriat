package com.ariat.Pages.Categories.MenCategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Categories.MenCategories.MenFootwearCountry.MenFootwearCountrySubcategories.MenFootwearCountryOutdoorPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearCountry.MenFootwearCountrySubcategories.MenFootwearCountryRubberPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearCountry.MenFootwearCountrySubcategories.MenFootwearCountryToolBootsPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearCountry.MenFootwearCountrySubcategories.MenFootwearCountryWalkingPage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * This contains Men Country Page' locators, methods and links with next pages
 * @author aila.bogasieru@ariat.com
 *
 */

public class MenCountryPage extends BasePage{
	
	private By footwearSwitcher = By.xpath("//*[@id=\"main\"]/div[1]/ul/li/a/span[2]");
	private By tallBootsCountryCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div[1]/ul/li/ul/li[1]/a");
	private By rubberCountryCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div[1]/ul/li/ul/li[2]/a");
	private By outdoorCountryCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div[1]/ul/li/ul/li[3]/a");
	private By walkingCountryCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div[1]/ul/li/ul/li[4]/a");
	private By tallBootsCountryCategoryText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By rubberCountryCategoryText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By outdoorCountryCategoryText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By walkingCountryCategoryText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");

	public MenCountryPage(WebDriver driver) {
		super(driver);
	}
	
	public void switcherClick() {
		WebDriverUtils.clickOnElementWithWait(driver, footwearSwitcher);
	}
	
	public MenFootwearCountryToolBootsPage returnMenFootwearCountryToolBootsCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, tallBootsCountryCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(tallBootsCountryCategoryText));
		return new MenFootwearCountryToolBootsPage(driver);
	}
	
	public MenFootwearCountryRubberPage returnMenFootwearCountryRubberCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, rubberCountryCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(rubberCountryCategoryText));
		return new MenFootwearCountryRubberPage(driver);
	}
	
	
	public MenFootwearCountryOutdoorPage returnMenFootwearCountryOutdoorCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, outdoorCountryCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(outdoorCountryCategoryText));
		return new MenFootwearCountryOutdoorPage(driver);
	}
	
	public MenFootwearCountryWalkingPage returnMenFootwearCountryWalkingCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, walkingCountryCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(walkingCountryCategoryText));
		return new MenFootwearCountryWalkingPage(driver);
	}
}
