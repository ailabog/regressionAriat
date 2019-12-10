package com.ariat.Pages.Main;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Utils.WebDriverUtils;

/**
 * This class contains specific locators, methods for Add Address page and link
 * with Addresses page
 * 
 * @author aila.bogasieru@ariat.com
 */

public class AddAddressesPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(AddAddressesPage.class);

	private By fNameTtextBox = By.id("dwfrm_profile_address_firstname");
	private By lNameTextBox = By.id("dwfrm_profile_address_lastname");
	private By address1TextBox = By.id("dwfrm_profile_address_address1");
	private By address2TextBox = By.id("dwfrm_profile_address_address2");
	private By cityTextBox = By.id("dwfrm_profile_address_city");
	private By countryTextBox = By.id("dwfrm_profile_address_country");
	private By postCodeTextBox = By.id("dwfrm_profile_address_zip");
	private By phoneTextBox = By.id("dwfrm_profile_address_phone");
	private By addressIdTextBox = By.id("dwfrm_profile_address_addressid");
	private By saveAddressButton =By.name("dwfrm_profile_address_create");
	private By saveAddressButtonFR =By.xpath("//button[@value='Appliquer']");
	 private By saveAddressButtonDE = By.xpath("//button[@value='Anwenden']");
	private By saveAddressEditButton = By.xpath("//*[@value='Apply']");
	private By saveAddressEditButtonDE = By.xpath("//*[@value='Anwenden']");
	private By saveAddressEditButtonFR = By.xpath("//*[@value='Appliquer']");
	private By cancelAddressButton = By.name("dwfrm_profile_address_cancel");
	private By editAddressButton = By.name("dwfrm_profile_address_edit");
	private By addressesText = By.xpath("//*contains[text(), 'Address']");
	private By addressesTextFR = By.xpath("//*contains[text(), 'Addresses']");
 	private By deleteAddressButton = By.name("dwfrm_profile_address_remove");
	private By deleteAddressButtonDE = By.name("dwfrm_profile_address_remove");
	private By addressesTextDE = By.xpath("//*contains[text(), 'Adressen']");
    private By stateBox = By.id("dwfrm_profile_address_states_state");
    private By missingFieldsText=By.xpath("//*contains[text(),'This field is required.']");
   
  		
	public AddAddressesPage(WebDriver driver) {
		super(driver);
	}

	
	public void setDetailsAddress(String name, String last, String address1, String city, String country, String zip, String phone, String addressId) {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, fNameTtextBox, name);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, lNameTextBox, last);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, address1TextBox, address1);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, cityTextBox, city);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.selectVisibleText(driver, countryTextBox, country);
		WebDriverUtils.enterTextBox(driver, postCodeTextBox, zip);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, phoneTextBox, phone);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, addressIdTextBox, addressId);

	}
	
	public void setDetailsAddressUS(String name, String last, String address1, String city, String state, String zip, String phone, String addressId) {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, fNameTtextBox, name);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, lNameTextBox, last);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, address1TextBox, address1);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, cityTextBox, city);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.selectDropDown(driver,stateBox, state);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, postCodeTextBox, zip);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, phoneTextBox, phone);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, addressIdTextBox, addressId);
	}
	
	public void enterAddressId(String addressId) {
		logger.info("Entering poste code: ");
		WebDriverUtils.enterTextBox(driver, addressIdTextBox, addressId);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
	}
	
	public void selectState(String state) {
		logger.info("Selecting state: ");
		WebDriverUtils.selectDropDown(driver, stateBox, state);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		
	}


	public void clearAddressId() {
		logger.info("Clearing text box Address Id:");
		WebDriverUtils.clearElement(driver, addressIdTextBox);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		
	}

	public void saveAddress() {
		logger.info("Saving this address: ");
		WebDriverUtils.scroll500Down(driver, saveAddressButton);
		WebDriverUtils.clickOnElementWithWait(driver, saveAddressButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
		
	}

	public void saveAddressEdit() {
		logger.info("Saving this address: ");
		WebDriverUtils.clickOnElementWithWait(driver, saveAddressEditButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
	}

	public void editAddress() {
		logger.info("Editing this address: ");
		WebDriverUtils.clickOnElementWithWait(driver, editAddressButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		
	}

	public void cancelAddress() {
		logger.info("Canceling this address to be created: ");
		WebDriverUtils.clickOnElementWithWait(driver, cancelAddressButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		
	}
	
	public void assertMissingValueAddress(String msgExpected) {
		String msg = WebDriverUtils.getElementText(driver, missingFieldsText);
		assertEquals(msg, msgExpected, "This field is required.");
	}

	public void deleteAddress() {
		logger.info("Deleteing this address ");
		WebDriverUtils.clickOnElementWithWait(driver, deleteAddressButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
		
	}
	
	public void saveAddressDE() {
		logger.info("Saving this address: ");
		WebDriverUtils.scroll500Down(driver, saveAddressButtonDE);
		WebDriverUtils.clickOnElementWithWait(driver, saveAddressButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
		
	}
	
	public void saveAddressFR() {
		logger.info("Saving this address: ");
		WebDriverUtils.scroll500Down(driver, saveAddressButtonFR);
		WebDriverUtils.clickOnElementWithWait(driver, saveAddressButton);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_6000_SECONDS);
		
	}


	public AddressesPage returnAddressesPage() {
		WebDriverUtils.scroll350Down(driver, saveAddressButton);
		WebDriverUtils.clickOnElementWithWait(driver, saveAddressButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addressesText));
		return new AddressesPage(driver);
	}
	
	public AddressesPage returnAddressesPageWithoutScroll() {
		WebDriverUtils.clickOnElementWithWait(driver, saveAddressButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addressesText));
		return new AddressesPage(driver);
	}
	
	public AddressesPage returnAddressesPageFR() {
		WebDriverUtils.scroll500Down(driver, saveAddressButtonFR);
		WebDriverUtils.clickOnElementWithWait(driver, saveAddressButtonFR);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addressesTextFR));
		return new AddressesPage(driver);
	}
	
	public AddressesPage returnAddressesPageDE() {
		WebDriverUtils.scroll500Down(driver, saveAddressButtonDE);
		WebDriverUtils.clickOnElementWithWait(driver, saveAddressButtonDE);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addressesText));
		return new AddressesPage(driver);
	}
	
	public AddressesPage returnAddressesSaveFromEditPage() {
		WebDriverUtils.clickOnElementWithWait(driver, saveAddressEditButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addressesText));
		return new AddressesPage(driver);
	}
	
	public AddressesPage returnAddressesSaveFromEditPageDE() {
		WebDriverUtils.clickOnElementWithWait(driver, saveAddressEditButtonDE);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addressesText));
		return new AddressesPage(driver);
	}
	
	public AddressesPage returnAddressesSaveFromEditPageFR() {
		WebDriverUtils.clickOnElementWithWait(driver, saveAddressEditButtonFR);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addressesText));
		return new AddressesPage(driver);
	}
	
	public AddressesPage returnAddressesFromEditPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, editAddressButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addressesText));
		return new AddressesPage(driver);
	}
	
	public AddressesPage returnAddressesFromEditDeletePage() {
		WebDriverUtils.scrollMiddlePage(driver, deleteAddressButton);
		WebDriverUtils.clickOnElementWithWait(driver, deleteAddressButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addressesText));
		return new AddressesPage(driver);
	}
	
	public AddressesPage returnAddressesFromEditDeletePageDE() {
		WebDriverUtils.scrollElementToPosition(driver, deleteAddressButtonDE);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, deleteAddressButtonDE);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_4000_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(addressesTextDE));
		return new AddressesPage(driver);
	}
}
