package com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearWesternCategories.MenFootwearWesternFashionPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearWesternCategories.MenFootwearWesternPerformancePage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Men Footwear Western Category Page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MenFootwearWesternPage extends BasePage {

	private By performanceFootwearWesternText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By fashionFootwearWesternText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
	private By performanceFootwearWesternCategoryLeftNav = By
			.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[1]/a");
	private By fashionFootwearWesternCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[2]/a");

	public MenFootwearWesternPage(WebDriver driver) {
		super(driver);

	}

	public MenFootwearWesternPerformancePage returnMenFootwearWesternPerformanceCategoryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, performanceFootwearWesternCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(performanceFootwearWesternText));
		return new MenFootwearWesternPerformancePage(driver);
	}

	public MenFootwearWesternFashionPage returnMenFootwearWesternFashionCategoryLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, fashionFootwearWesternCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(fashionFootwearWesternText));
		return new MenFootwearWesternFashionPage(driver);
	}

}
