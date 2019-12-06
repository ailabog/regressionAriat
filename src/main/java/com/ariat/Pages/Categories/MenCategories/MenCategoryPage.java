package com.ariat.Pages.Categories.MenCategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearRidingPage;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements returns methods to pages: (top & left navigation)
 * Men Category Page
 * Men Footwear Page
 * Men Clothing Page
 * Men Accessories Page
 * Men Featured Page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MenCategoryPage extends BasePage{
	
	private By menFootwearCategory = By.xpath("(//a[contains(text(),'Footwear')])[2]");
    private By menFootwearCategoryDE = By.linkText("Schuhe");
    private By menFootwearCategoryFR = By.xpath("//a[contains(text(),'Bottes et boots')])[2]");
	private By menFootwearText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
	private By menClothingCategory = By.xpath("//a[contains(text(),'Clothing')]");
	private By menClothingCategoryFR = By.xpath("//a[contains(text(),'Vêtements')])[3]");
	private By menClothingCategoryDE = By.xpath("(//a[contains(text(),'Bekleidung')])[2]");
	private By menClothingText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
    private By menAccesoriesCategory = By.xpath("//a[contains(text(),'Accessories')]");
    private By menAccesoriesCategoryFR = By.xpath(" //a[contains(text(),'Accessoires')])[3]");
    private By menAccessoriesText = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/span[1]");
    private By menFeaturedCategory = By.xpath("//a[contains(text(),'Featured')]");
    private By menFeaturedCategoryFR = By.xpath("//a[contains(text(),'Featured')])[2]");
    private By menFeaturedText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
    private By menCategory = By.xpath("//a[contains(text(),'Men')]");
    private By menText = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[2]/span[1]");
    private By menCategoryDE = By.xpath("//a[contains(text(),'Herren')]");
    private By footwearCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[1]/a");
    private By clothingCategoryLeftNav =By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[2]/a");
    private By accessoriesCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[3]/a");
    private By ridingCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[4]/a");
    private By countryCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[5]/a");
    private By westernCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[6]/a");
    private By workCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[7]/a");
    private By fashionCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[8]/a");
    private By featuredCategoryLeftNav = By.xpath("//*[@id=\"main\"]/div/div[1]/aside/div[3]/ul/li[9]/a");
    private By ridingTextLeftNav = By.xpath("//*[contains(text(),'Riding']");
    private By countryTextLeftNav = By.xpath("//*[contains(text(),'Country']");
    private By westernTextLeftNav = By.xpath("//*[contains(text(),'Western']");
    private By fashionTextLeftNav = By.xpath("//*[contains(text(),'Fashion']");
    private By workTextLeftNav = By.xpath("//*[contains(text(),'Work']");
    private By sortDropWomenCategoryUp = By.xpath("//div[@id='main']/div/div[2]/div[3]/div[2]/div/div/h3/p/span");
    private By show36ItemLink = By.linkText("36 Items");
	private By show72ItemLink = By.linkText("72 Items");
    private By show36ItemLinkDE = By.linkText("36 Artikel");
	private By show72ItemLinkDE = By.linkText("72 Artikel");
	private By show108ItemLinkDE = By.xpath("108 Artikel");
	private By show36ItemLinkFR = By.linkText("36 Articles");
	private By show72ItemLinkFR = By.linkText("72 Articles");
	private By show108ItemLinkFR = By.xpath("108 Articles");
	private By show108ItemLink = By.linkText("108 Items");
	private By show108ItemLinkDown = By.xpath("//*[@id=\"main\"]/div/div[2]/div[3]/div[2]/div[4]/div[3]/ul/li[3]/a");
	private By nextPaginationButtonUp = By.xpath("//a[contains(text(),'Next')]");
	private By prevPaginationButtonUp = By.cssSelector(".search-result-options:nth-child(1) > .pagination span");
	private By backToTopButton = By.xpath("//*[@id=\"main\"]/div/div[1]/div[1]/a");
	private By sortDropWomenCategoryDown = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[2]/div[4]/div[1]/h3/p[1]/span");
	private By nextPaginationButtonDown = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[2]/div[4]/div[4]/ul/li[5]/a");
	private By prevPaginationButtonDown = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[2]/div[4]/div[4]/ul/li[7]/a");
	private By recommendedLink = By.linkText("Recommended");
	private By priceHighToLowLink = By.linkText("Price (High to Low)");
	private By priceLowToHighLink = By.linkText("Price (Low to High)");
	private By bestSellersLink = By.linkText("Best Sellers");
	private By bestSellersLinkFR = By.linkText("Meilleurs Ventes");
	

    
	public MenCategoryPage(WebDriver driver) {
		super(driver);
	}
	
	public void menCategory() {
		WebDriverUtils.moveToElement(driver, menCategory);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	public void menCategoryDE() {
		WebDriverUtils.moveToElement(driver, menCategoryDE);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	public void clickSortUp() {
		WebDriverUtils.clickOnElementWithWait(driver, sortDropWomenCategoryUp);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	public void clickSortDown() {
		WebDriverUtils.clickOnElementWithWait(driver, sortDropWomenCategoryDown);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void sortProductWomenCategoryRecommended() {
		WebDriverUtils.clickOnElementWithWait(driver, recommendedLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	public void sortProductWomenCategoryPriceHighToLow() {
		WebDriverUtils.clickOnElementWithWait(driver, priceHighToLowLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	public void sortProductWomenCategoryPriceLowToHigh() {
		WebDriverUtils.clickOnElementWithWait(driver, priceLowToHighLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	public void sortProductWomenCategoryBestSellers() {
		WebDriverUtils.clickOnElementWithWait(driver, bestSellersLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	
	public void sortProductWomenCategoryBestSellersFR() {
		WebDriverUtils.clickOnElementWithWait(driver, bestSellersLinkFR);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	public void show36ItemsUp() {
		WebDriverUtils.clickOnElementWithWait(driver, show36ItemLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void show72ItemsUp() {
		WebDriverUtils.clickOnElementWithWait(driver, show72ItemLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void show108ItemLinkUp() {
		WebDriverUtils.clickOnElementWithWait(driver, show108ItemLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	public void show36ItemsUpDE() {
		WebDriverUtils.clickOnElementWithWait(driver, show36ItemLinkDE);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void show72ItemsUpDE() {
		WebDriverUtils.clickOnElementWithWait(driver, show72ItemLinkDE);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void show108ItemLinkUpDE() {
		WebDriverUtils.clickOnElementWithWait(driver, show108ItemLinkDE);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	public void show36ItemsUpFR() {
		WebDriverUtils.clickOnElementWithWait(driver, show36ItemLinkFR);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void show72ItemsUpFR() {
		WebDriverUtils.clickOnElementWithWait(driver, show72ItemLinkFR);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void show108ItemLinkUpFR() {
		WebDriverUtils.clickOnElementWithWait(driver, show108ItemLinkFR);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}


	public void nextPaginationUp() {
		WebDriverUtils.clickOnElementWithWait(driver, nextPaginationButtonUp);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void prevPaginationButtonUp() {
		WebDriverUtils.clickOnElementWithWait(driver, prevPaginationButtonUp);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void backToTopClick() {
		WebDriverUtils.scrolltoElement(driver, backToTopButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, backToTopButton);
	}

	public void show36ItemsDown() {
		WebDriverUtils.scrolltoElement(driver, show36ItemLink);
	    WebDriverUtils.clickOnElementWithWait(driver, show36ItemLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void show72ItemsDown() {
		WebDriverUtils.scrollDown(driver, show72ItemLink);
		WebDriverUtils.clickOnElementWithWait(driver, show72ItemLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void show108ItemLinkDown() {
		WebDriverUtils.scrollBottomPage(driver, show108ItemLinkDown);
		WebDriverUtils.clickOnElementWithWait(driver, show108ItemLinkDown);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	public void nextPaginationDown() {
		WebDriverUtils.scrollElementToPosition(driver, nextPaginationButtonDown);
		WebDriverUtils.clickOnElementWithWait(driver, nextPaginationButtonDown);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void prevPaginationButtonDown() {
		WebDriverUtils.scrollElementToPosition(driver, prevPaginationButtonDown);
		WebDriverUtils.clickOnElementWithWait(driver, prevPaginationButtonDown);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}
	
	//Top navigation
	public MenCategoryPage returnMenCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, menCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menText));
		return new MenCategoryPage(driver);
	}
	
	public MenFootwearPage returnMenFootwearPage() {
		WebDriverUtils.clickOnElementWithWait(driver, menFootwearCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFootwearText));
		return new MenFootwearPage(driver);
	}
	
	public MenFootwearPage returnMenFootwearPageFR() {
		WebDriverUtils.clickOnElementWithWait(driver, menFootwearCategoryFR);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFootwearText));
		return new MenFootwearPage(driver);
	}
	
	public MenFootwearPage returnMenFootwearPageDE() {
		WebDriverUtils.clickOnElementWithWait(driver, menFootwearCategoryDE);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFootwearText));
		return new MenFootwearPage(driver);
	}
	
	public MenClothingPage returnMenClothingCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, menClothingCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingText));
		return new MenClothingPage(driver);
	}
	
	public MenClothingPage returnMenClothingCategoryPageFR() {
		WebDriverUtils.clickOnElementWithWait(driver, menClothingCategoryFR);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingText));
		return new MenClothingPage(driver);
	}
	
	public MenClothingPage returnMenClothingCategoryPageDE() {
		WebDriverUtils.clickOnElementWithWait(driver, menClothingCategoryDE);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingText));
		return new MenClothingPage(driver);
	}
	
	public MenAccessoriesPage returnMenAccessoriesCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, menAccesoriesCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menAccessoriesText));
		return new MenAccessoriesPage(driver);
	}
	
	public MenAccessoriesPage returnMenAccessoriesCategoryPageFR() {
		WebDriverUtils.clickOnElementWithWait(driver, menAccesoriesCategoryFR);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menAccessoriesText));
		return new MenAccessoriesPage(driver);
	}
	
	public MenFeaturedPage returnMenFeaturedCategoryPage() {
		WebDriverUtils.clickOnElementWithWait(driver, menFeaturedCategory);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFeaturedText));
		return new MenFeaturedPage(driver);
	}
	
	public MenFeaturedPage returnMenFeaturedCategoryPageFR() {
		WebDriverUtils.clickOnElementWithWait(driver, menFeaturedCategoryFR);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFeaturedText));
		return new MenFeaturedPage(driver);
	}
	
//Left navigation
	
	public MenFootwearPage returnMenFootwearPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, footwearCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFootwearText));
		return new MenFootwearPage(driver);
	}
	
	public MenClothingPage returnMenClothingPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, clothingCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menClothingText));
		return new MenClothingPage(driver);
	}
	
	public MenAccessoriesPage returnMenAccessoriesPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, accessoriesCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menAccessoriesText));
		return new MenAccessoriesPage(driver);
	}
	
	public MenFootwearRidingPage returnMenFootwearRidingPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, ridingCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(ridingTextLeftNav));
		return new MenFootwearRidingPage(driver);
	}
	
	public MenCountryPage returnMenCountryPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, countryCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(countryTextLeftNav));
		return new MenCountryPage(driver);
	}
	
	public MenWesternPage returnMenFootwearWesternPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, westernCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(westernTextLeftNav));
		return new MenWesternPage(driver);
	}
	
	public MenFashionPage returnMenFootwearFashionPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, fashionCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(fashionTextLeftNav));
		return new MenFashionPage(driver);
	}
	
	public MenWorkPage returnMenWorkPageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, workCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(workTextLeftNav));
		return new MenWorkPage(driver);
	}
	
	public MenFeaturedPage returnMenFeaturedPagePageLeftNav() {
		WebDriverUtils.clickOnElementWithWait(driver, featuredCategoryLeftNav);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(menFeaturedText));
		return new MenFeaturedPage(driver);
	}
} 
