package com.ariat.Pages.Products;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Pages.Main.MyAccountWishListPage;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Main.MyWishListPage;
import com.ariat.Utils.WebDriverUtils;


/**
 * Implements Heritage Product Page by implementing ProductAttributes interface
 * @author aila.bogasieru@ariat.com
 *
 */

public class HeritageProductPage extends BasePage{
	
	private By addToBasket = By.cssSelector("#add-to-cart");
	private By myBagText = By.xpath("*[contains[text(), 'My Bag']");
	private By wishList = By.cssSelector(".add-to-wishlist");
	private By bonusDialog = By.id("bonus-choose-container product-content");
	private By myWishListText = By.xpath("//*contains[text(), 'Wish list']");
	private By myAccountText = By.xpath("//*contains[text()='My account']");
	private By myWishlistText = By.xpath("//*contains[text()='Wishlist']");
	private By selectSize = By.id("va-size");
	private By selectCalf = By.id("va-calf");
	private By selectHeight = By.id("va-height");
	private By increaseQty = By.xpath("//span[text()='+']");
	private By decreaseQty = By.xpath("//span[text()='-']");
	private By writeReview = By.xpath("//*[@id=\"BVRRSummaryContainer\"]/div/div/div/div/div/div/div");
	private By reviewDialog = By.id("bv-mbox-lightbox-list");
	private By starReviewExcellent = By.xpath("//a[@id='bv-radio-rating-5']/span");
	private By starReviewGood = By.xpath("//a[@id='bv-radio-rating-4']/span");
	private By starReviewAverage = By.xpath("//a[@id='bv-radio-rating-3']/span");
	private By starReviewFair = By.xpath("//a[@id='bv-radio-rating-2']/span");
	private By starReviewPoor = By.xpath("//a[@id='bv-radio-rating-1']/span");
	private By titleReview = By.id("bv-text-field-title");
	private By textReview = By.id("bv-textarea-field-reviewtext");
	private By addPhotoReview = By.xpath("//span[text()='Add Photo']");
	private By addVideoReview = By.xpath("//button[text()=' Add Video ']");
	private By addPhotoModal = By.id("bv-mbox-lightbox-list");
	private By choosePhotoReview = By.id("bv-text-field-photourl_1");
	private By videoModalReview = By.id("bv-mbox-lightbox-list");
	private By insertVideoURLReview = By.id("bv-text-field-videourl_1");
	private By addVideoButton = By.xpath("//button[text()='Add Video']");
	private By recommendProductYes = By.id("bv-radio-isrecommended-true-label");
	private By recommendProductNo = By.id("bv-radio-isrecommended-false-label");
	private By nicknameReview = By.id("bv-text-field-usernickname");
	private By userLocation = By.id("bv-text-field-userlocation");
	private By emailReview = By.id("bv-email-field-hostedauthentication_authenticationemail");
	private By postReviewButton = By.xpath("//button[text()='Post Review']");
	private By updateButton = By.id("add-to-cart");
	private By lengthLocator = By.id("va-length");
	
	public HeritageProductPage(WebDriver driver) {
		super(driver);
	}
	public void selectAttributeSize(String size) {
		WebDriverUtils.selectVisibleText(driver, selectSize, size);
	
	}

	public void selectAttributeCalf(String calf) {
		WebDriverUtils.selectVisibleText(driver, selectCalf, calf);
	
	}

	public void selectAttributeHeight(String height) {
		WebDriverUtils.selectVisibleText(driver, selectHeight, height);
	
	}

	public void setQtyIncrease(int n) {
		for (int i = 0; i <= n; i++) {
			WebDriverUtils.clickOnElementWithWait(driver, increaseQty);

		}
	}

	public void setQtyDecrease(int n) {
		for (int i = 0; i <= n; i++) {
			WebDriverUtils.clickOnElementWithWait(driver, decreaseQty);
		}
	}

	public void writeReviewClick() {
		WebDriverUtils.clickOnElementWithWait(driver, writeReview);

	}

	public void writeReviewStar(String star) {
		if (WebDriverUtils.findElement(driver, reviewDialog) != null) {
			switch (star) {
			case "Excellent":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewExcellent);
				break;

			case "Good":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewGood);
				break;

			case "Average":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewAverage);
				break;

			case "Fair":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewFair);
				break;

			case "Poor":
				WebDriverUtils.clickOnElementWithWait(driver, starReviewPoor);
				break;

			default:
				throw new RuntimeException("No star supported");
			}
		}
	}

	public void writeReviewContent(String titleReviewText, String reviewText) {
		WebDriverUtils.enterTextBox(driver, titleReview, titleReviewText);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		WebDriverUtils.enterTextBox(driver, textReview, reviewText);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
	}

	public void addPhoto() {
		WebDriverUtils.clickOnElementWithWait(driver, addPhotoReview);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		if (WebDriverUtils.findElement(driver, addPhotoModal) != null) {
			WebDriverUtils.clickOnElementWithWait(driver, choosePhotoReview);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
			// Upload the file
		}
	}

	public void addVideo(String videoURL) {
		WebDriverUtils.clickOnElementWithWait(driver, addVideoReview);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		if (WebDriverUtils.findElement(driver, videoModalReview) != null) {
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
			WebDriverUtils.enterTextBox(driver, insertVideoURLReview, videoURL);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
			WebDriverUtils.clickOnElementWithWait(driver, addVideoButton);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		}
	}

	public void recommendProductYes() {
		WebDriverUtils.clickOnElementWithWait(driver, recommendProductYes);
	
	}

	public void recommendProductNo() {
		WebDriverUtils.clickOnElementWithWait(driver, recommendProductNo);

	}

	public void userInfoReview(String nickname, String userLocationReview, String email) {
		WebDriverUtils.enterTextBox(driver, nicknameReview, nickname);
		WebDriverUtils.enterTextBox(driver, userLocation, userLocationReview);
		WebDriverUtils.enterTextBox(driver, emailReview, email);

	}

	public void selectAttributeLength(String lengthSize) {
		WebDriverUtils.enterTextBox(driver, lengthLocator, lengthSize);
	}

	public void postReview() {
		WebDriverUtils.clickOnElementWithWait(driver, postReviewButton);

	}

	public void addToCart() {
		WebDriverUtils.clickOnElementWithWait(driver, addToBasket);

	}

	public void update() {
		WebDriverUtils.clickOnElementWithWait(driver, updateButton);
	
	}

	public MyBagPage returnMyBagPage() {
		WebDriverUtils.scrollLittDown(driver, addToBasket);
		WebDriverUtils.clickOnElementWithWait(driver, addToBasket);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(bonusDialog));
		return new MyBagPage(driver);
	}

	public MyAccountWishListPage returnMyAccountWishListPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, wishList);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myAccountText));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myWishlistText));
		return new MyAccountWishListPage(driver);
	}

	public MyWishListPage returnMyWishListPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, wishList);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myWishListText));
		return new MyWishListPage(driver);
	}
}
