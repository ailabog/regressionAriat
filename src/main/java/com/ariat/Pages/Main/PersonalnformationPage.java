package com.ariat.Pages.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ariat.Utils.WebDriverUtils;

/**
 * This page contains link with My account page and method to edit profile
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class PersonalnformationPage extends BasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonalnformationPage.class);

	private By saveEditsButton = By.name("dwfrm_profile_confirm");
	private By myAccountTitle = By.className("account-overview__title ms-font--proxima_nova_semibold");
	private By firstNameTextBox = By.id("dwfrm_profile_customer_firstname");
	private By lastNameTextBox = By.id("dwfrm_profile_customer_lastname");
	private By emailTextBox = By.id("dwfrm_profile_customer_email");
	private By confirmEmailTextBox = By.id("dwfrm_profile_customer_emailconfirm");
	private By passwordTextBox = By.id("dwfrm_profile_login_password");
	private By confirmPasswordTextBox = By.id("dwfrm_profile_login_passwordconfirm");

	public PersonalnformationPage(WebDriver driver) {
		super(driver);
	}
	
	public void setDetails(String firstName, String lastName, String email, String password) {
		logger.info("Start collecting information to create a new account: First Name");
		WebDriverUtils.enterTextBox(driver, firstNameTextBox, firstName);
		logger.info("Start collecting information to create a new account: Last Name");
		WebDriverUtils.enterTextBox(driver, lastNameTextBox, lastName);
		logger.info("Start collecting information to create a new account: enter email");
		WebDriverUtils.enterTextBox(driver, emailTextBox, email);
		logger.info("Start collecting information to create a new account: confirm email");
		WebDriverUtils.enterTextBox(driver, confirmEmailTextBox, email);
		logger.info("Start collecting information to create a new account: enter passsword");
		WebDriverUtils.enterTextBox(driver, passwordTextBox, password);
		logger.info("Start collecting information to create a new account: confirm email");
		WebDriverUtils.enterTextBox(driver, confirmPasswordTextBox, password);
		logger.info("Finalize collecting information to create a new account");
	}

	public void clearFirstName() {
		logger.info("Clearing text box First Name:");
		WebDriverUtils.clearElement(driver, firstNameTextBox);
	
	}

	public void lastNameInfo(String lastName) {
		logger.info("Start collecting information to create a new account: Last Name");
		WebDriverUtils.enterTextBox(driver, lastNameTextBox, lastName);
	
	}

	public void clearLastName() {
		logger.info("Clearing text box Last Name:");
		WebDriverUtils.clearElement(driver, lastNameTextBox);
	}
	
	public void clearEmail() {
		logger.info("Clearing text box Email:");
		WebDriverUtils.clearElement(driver, emailTextBox);
	}

	public void saveEdits() {
		logger.info("Saving the updates for personal informations ");
		WebDriverUtils.clickOnElementWithWait(driver, saveEditsButton);
	}
	
	public MyAccountPage returnMyAccountPage() {
		WebDriverUtils.clickOnElementWithWait(driver, saveEditsButton);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(myAccountTitle));
		return new MyAccountPage(driver);
	}
}
