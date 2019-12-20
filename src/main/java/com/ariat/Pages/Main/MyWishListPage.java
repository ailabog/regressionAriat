package com.ariat.Pages.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Utils.WebDriverUtils;

/**
 * Contain locators, methods Wish List page and links to page:
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MyWishListPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(MyWishListPage.class);

	private By sendToAFriendButton = By.xpath("//a[@title='Send to a Friend']");
	private By sendToAFriendButtonDE = By.xpath("//a[@title='Meine Wunschliste teilen']");
	private By sendToAFriendButtonFR = By.xpath("//a[@title='Envoyer à un ami']");
	private By nameTxtBox = By.id("dwfrm_sendtofriend_friendsname");
	private By emailFriendTextBox = By.id("dwfrm_sendtofriend_friendsemail");
	private By shareEmailListButton = By.name("dwfrm_sendtofriend_send");
	private By closeSendFriendButton = By.xpath("//*[@id=\"ext-gen44\"]/body/div[7]/div[1]/a/span");
	private By startShoppingButton = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div/div/a");
	private By ukLocation = By.xpath("//img[contains(@src, 'GB.gif')]");
	private By usLocation = By.xpath("//img[contains(@src, 'US.gif')]");
	private By increaseQty = By
			.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div/div[1]/div[5]/form/div[3]/div[1]/div/div/span[2]");
	private By decreaseQty = By
			.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div/div[1]/div[5]/form/div[3]/div[1]/div/div/span[1]");
	private By prioritySelect = By.id("dwfrm_wishlist_items_i0_priority");
	private By updateItemWishList = By.name("dwfrm_wishlist_items_i0_updateItem");
	private By removeItemWishList = By.xpath("//button[text()='Remove']");
	private By editItemWishList = By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/a[1]");
	private By addToCartWishList = By.name("dwfrm_wishlist_items_i0_addItemToCart");
	private By goBackToWishListEdit = By.cssSelector("span.ui-icon.ui-icon-closethick");
    
    private By noIteminWishListText = By.xpath("//*[contains[text(), 'You have no items on your wishlist.']");
    private By ItemsTable = By.id("id-b74204a4db5dec790e1f5d43c0");
	 
    private boolean noItemWishList;
    
    public MyWishListPage(WebDriver driver) {
		super(driver);
	}

	public void sendListToAFriend(String nameFrined, String email) {
		logger.info("Sending my wish list to a friend");
		WebDriverUtils.clickOnElementWithWait(driver, sendToAFriendButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, nameTxtBox, nameFrined);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, emailFriendTextBox, email);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, shareEmailListButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public void sendListToAFriendFR(String nameFrined, String email) {
		logger.info("Sending my wish list to a friend");
		WebDriverUtils.clickOnElementWithWait(driver, sendToAFriendButtonFR);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, nameTxtBox, nameFrined);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, emailFriendTextBox, email);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, shareEmailListButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	
	}
	
	public void sendListToAFriendDE(String nameFrined, String email) {
		logger.info("Sending my wish list to a friend");
		WebDriverUtils.clickOnElementWithWait(driver, sendToAFriendButtonDE);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, nameTxtBox, nameFrined);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, emailFriendTextBox, email);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, shareEmailListButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void closeSendToAFriend() {
		logger.info("Closing the sharing wish list with a friend window");
		WebDriverUtils.clickOnElement(driver, closeSendFriendButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public HomePage returnHomePage() {
		WebDriverUtils.clickOnElementWithWait(driver, startShoppingButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(ukLocation));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(usLocation));
		return new HomePage(driver);
	}

	public void increaseQtyWishList(int n) {
		for (int i = 0; i < n; i++) {
			WebDriverUtils.clickOnElementWithWait(driver, increaseQty);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		}
	}

	public void decreaseQtyWishList(int n) {
		for (int i = 0; i < n; i++) {
			WebDriverUtils.clickOnElementWithWait(driver, decreaseQty);
			WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		}
	}

	public void setPriorityWishList(String priority) {
		WebDriverUtils.selectDropDown(driver, prioritySelect, priority);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void updateItemWishList() {
		WebDriverUtils.clickOnElementWithWait(driver, updateItemWishList);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
	}

	public void removeItemWishList() {
		WebDriverUtils.clickOnElementWithWait(driver, removeItemWishList);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}

	public void editItemWishList() {
		WebDriverUtils.clickOnElementWithWait(driver, editItemWishList);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public void goBackFromEditToWishlist() {
		WebDriverUtils.clickOnElementWithWait(driver, goBackToWishListEdit);
	}

	public void addToCartItemWishList() {
		WebDriverUtils.scrollLittDown(driver, addToCartWishList);
		WebDriverUtils.clickOnElementWithWait(driver, addToCartWishList);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public boolean noItemWishList() {
		if(WebDriverUtils.findElement(driver, noIteminWishListText) != null) {
			noItemWishList = true;
			logger.info("Product was added in cart from WishList" + noItemWishList);
		}
		return noItemWishList;
	}
}

