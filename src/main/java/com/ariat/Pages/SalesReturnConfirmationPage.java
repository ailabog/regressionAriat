package com.ariat.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ariat.Pages.Main.BasePage;
import com.ariat.Pages.Main.OrderDetailsPage;
import com.ariat.Utils.WebDriverUtils;

/**
 * This contains Sales Return Confirmation Page' locators, methods and links with next pages
 * @author aila.bogasieru@ariat.com
 *
 */

public class SalesReturnConfirmationPage extends BasePage{
	
	
	private By backToOrderDetailsLink = By.linkText("« Back to order details");
	private By orderDetailsText = By.xpath("//*contains[text(),'Order Details']");

	protected SalesReturnConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public OrderDetailsPage returnOrderDetailsPage() {
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_40_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, backToOrderDetailsLink);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(orderDetailsText));
		return new OrderDetailsPage(driver);
	}
}
