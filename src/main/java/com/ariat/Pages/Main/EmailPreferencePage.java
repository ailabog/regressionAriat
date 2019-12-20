package com.ariat.Pages.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Utils.WebDriverUtils;

/**
 * This page contains methods for preferences in email and links to
 * EmailPreferencesInfo
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class EmailPreferencePage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(EmailPreferencePage.class);

	private By savePreferencesButton = By.name("ctl00$cphContent$submitButton");
	private By femaleCheck = By.xpath("//*[@id=\"RegistrationForm\"]/div[1]/div[5]/div/div/div[2]/span");
	private By maleCheck = By.xpath("//*[@id=\"RegistrationForm\"]/div[1]/div[5]/div/div/div[1]/span");
	private By countryCheck = By.xpath("//*[@id=\"RegistrationForm\"]/div[1]/div[9]/div[1]/div[2]/span");
	private By workCheck = By.xpath("//*[@id=\"RegistrationForm\"]/div[1]/div[9]/div[2]/div[2]/span");
	private By westernCheck = By.xpath("//*[@id=\"RegistrationForm\"]/div[1]/div[9]/div[2]/div[1]/span");
	private By englishCheck = By.xpath("//*[@id=\"RegistrationForm\"]/div[1]/div[9]/div[1]/div[1]/span");
	private By fashionCheck = By.xpath("//*[@id=\"RegistrationForm\"]/div[1]/div[9]/div[2]/div[3]/span");
	private By otherCheck = By.xpath("//*[@id=\"RegistrationForm\"]/div[1]/div[5]/div/div/div[3]/span");
	private By apparelCheck = By.xpath("//*[@id=\"RegistrationForm\"]/div[1]/div[9]/div[1]/div[3]/span");
	private By saveEditsButton = By.name("dwfrm_profile_confirm");
	private By myAccountText = By.xpath("//*[contains(text(), 'My account']");
	private By emailTxtBox = By.name("dwfrm_profile_customer_email");
	private By confirmEmailTxtBox = By.id("dwfrm_profile_customer_emailconfirm");
	private By fNameTxtBox = By.id("dwfrm_profile_customer_firstname");
	private By lNameTxtBox = By.id("dwfrm_profile_customer_lastname");
	private By genderCheck = By.id("RadioGender01");
	private By monthSelect = By.id("dwfrm_profile_customer_customProfile_birthdayMonth");
	private By daySelect = By.id("dwfrm_profile_customer_customProfile_birthdayDay");
	private By emailTxtBoxUS = By.id("ctl00_cphContent_txtEmail");
	private By confirmEmailTxtBoxUS = By.id("ctl00_cphContent_txtConfirmEmail");
	private By fNameTxtBoxUS = By.id("ctl00_cphContent_firstname");
	private By lNameTxtBoxUS = By.id("ctl00_cphContent_lastname");
	private By genderCheckUS = By.id("ctl00_cphContent_Female");
	private By monthSelectUS = By.id("ctl00_cphContent_ddlBMonth");
	private By daySelectUS = By.id("ctl00_cphContent_ddlBDay");
	private By yearSelectUS = By.id("ctl00_cphContent_ddlBYear");
	private By saveprefBtn = By.xpath("//input[@value='SAVE PREFERENCES']");

	public EmailPreferencePage(WebDriver driver) {
		super(driver);
	}
	
	public void checkGender(String option) {
		switch(option) {
		case "Male":
			WebDriverUtils.clickOnElementWithWait(driver, maleCheck);
		
		break;
		case "Female":
			WebDriverUtils.clickOnElementWithWait(driver, femaleCheck);
		
		break;
		case "Other":
			WebDriverUtils.clickOnElementWithWait(driver, otherCheck);
		
		default:
			logger.info("No option found");
		}		
	}
	
	public void ariatProductsCheck(String option) {
		switch(option) {
		case "English":
			WebDriverUtils.clickOnElementWithWait(driver, englishCheck);
		
		break;	
		case "Country":
			WebDriverUtils.clickOnElementWithWait(driver, countryCheck);
			
		break;	
		case "Apparel":
			WebDriverUtils.clickOnElementWithWait(driver, apparelCheck);
		
		break;	
		case "Western":
			WebDriverUtils.clickOnElementWithWait(driver, westernCheck);
			
		case "Work":
			WebDriverUtils.clickOnElementWithWait(driver, workCheck);
		
			
		case "Fashion":
			WebDriverUtils.clickOnElementWithWait(driver, fashionCheck);
		
		default:
			logger.info("No option found");
		}			
	}
	
	
	public void selectBirthData(String monthValue, String dayValue, String yearValue) {
		logger.info("Selecting month of birth..");
		WebDriverUtils.selectVisibleText(driver, monthSelect, monthValue);
		logger.info("Selecting day of birth..");
		WebDriverUtils.selectVisibleText(driver, daySelect, dayValue);
	}
	
	
	public void savePrefUS() {
		logger.info("Saving email preferences..");
		WebDriverUtils.clickOnElementWithWait(driver, saveprefBtn);
	}
	
	
	public void saveEditsClick() {
		WebDriverUtils.scroll500Down(driver, saveEditsButton);
		WebDriverUtils.clickOnElementWithWait(driver, saveEditsButton);
		
		logger.info("Changes were saved");
	}
	
	public void enterEmailUS(String emailValue) {
		logger.info("Entering email..");
		WebDriverUtils.enterTextBox(driver, emailTxtBoxUS, emailValue);
	}
	
	public void enterConfirmEmailUS(String confirmEmailValue) {
		logger.info("Entering email..");
		WebDriverUtils.enterTextBox(driver, confirmEmailTxtBoxUS, confirmEmailValue);
	}
	
	public void enterFNameUS(String fName) {
		logger.info("Entering First name..");
		WebDriverUtils.enterTextBox(driver, fNameTxtBoxUS, fName);
	}
	
	public void enterLNameUS(String lName) {
		logger.info("Entering Last name..");
		WebDriverUtils.enterTextBox(driver, lNameTxtBoxUS, lName);
	}

	public void checkGenderFemaleUS() {
		WebDriverUtils.clickOnElementWithWait(driver, genderCheckUS);
	}
	
	public void selectBirthDataUS(String monthValue, String dayValue, String yearValue) {
		logger.info("Selecting month of birth..");
		WebDriverUtils.selectVisibleText(driver, monthSelectUS, monthValue);
		logger.info("Selecting day of birth..");
		WebDriverUtils.selectVisibleText(driver, daySelectUS, dayValue);
		logger.info("Selecting year of birth..");
		WebDriverUtils.selectVisibleText(driver, yearSelectUS, dayValue);
	}

	public void savePreferencesClick() {
		WebDriverUtils.clickOnElementWithWait(driver, savePreferencesButton);
	
	}

	public MyAccountPage returnMyAccountPage() {
		WebDriverUtils.clickOnElementWithWait(driver, saveEditsButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myAccountText));
		return new MyAccountPage(driver);
	}
}
