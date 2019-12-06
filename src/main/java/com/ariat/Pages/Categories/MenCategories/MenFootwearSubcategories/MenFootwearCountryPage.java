package com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories;

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
 * Implements Men Footwear Country Category Page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MenFootwearCountryPage extends BasePage {

	private By tallBootsFootwearCountryCategoryleftNav = By
			.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[1]/a");
	private By walkingFootwearCountryCategoryleftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[4]/a");
	private By outdoorFootwearCountryCategoryleftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[3]/a");
	private By rubberFootwearCountryCategoryleftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[2]/a");
	private By tallBootsFootwearCountryText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By rubberFootwearCountryText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By outdoorFootwearCountryText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By walkingFootwearCountryText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");

	public MenFootwearCountryPage(WebDriver driver) {
		super(driver);
	}

	public MenFootwearCountryOutdoorPage returnMenFootwearCountryOutdoorCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, outdoorFootwearCountryCategoryleftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(outdoorFootwearCountryText));
		return new MenFootwearCountryOutdoorPage(driver);
	}

	public MenFootwearCountryRubberPage returnMenFootwearCountryRubberCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, rubberFootwearCountryCategoryleftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(rubberFootwearCountryText));
		return new MenFootwearCountryRubberPage(driver);
	}

	public MenFootwearCountryToolBootsPage returnMenFootwearCountryTallBootsCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, tallBootsFootwearCountryCategoryleftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(tallBootsFootwearCountryText));
		return new MenFootwearCountryToolBootsPage(driver);
	}

	public MenFootwearCountryWalkingPage returnMenFootwearCountryWalkingCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, walkingFootwearCountryCategoryleftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(walkingFootwearCountryText));
		return new MenFootwearCountryWalkingPage(driver);
	}
}
