package testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutPage;
import pages.CheckoutStepTwo;
import pages.InventoryPage;
import pages.LoginPage;
import utility.Screenshots;

public class CheckoutCompletePageTest extends TestBase {

	LoginPage login;
	InventoryPage inventory;
	CheckoutPage checkoutPage;
	CheckoutStepTwo cstepTwo;
	CartPage cart;
	CheckoutCompletePage completePage;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		login = new LoginPage();
		inventory = new InventoryPage();
		checkoutPage = new CheckoutPage();
		cstepTwo = new CheckoutStepTwo();
		cart = new CartPage();
		completePage = new CheckoutCompletePage();
		login.verifyLoginPage();
		inventory.add6CartProducts();
		inventory.verifyShppingCartFunctionality();
		cart.verifyCheckoutBtnFunctionality();
		checkoutPage.enterYourInformationToContinue();
		cstepTwo.verifyFinishBtn();

	}

	@Test
	public void verifyCompleteTxt() {

		String expTxt="Checkout: Complete!";
		String actTxt=completePage.verifyCompleteTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Checkout: Complete! txt is: " + actTxt);

	}

	@Test
	public void verifycompleteLogo() {
		boolean result=completePage.verifycompleteLogo();
		Assert.assertEquals(result, true);
		Reporter.log("logo is present="+result);
	}

	@Test
	public void verifyThankYouTxt() {
		String expTxt="Thank you for your order!";
		String actTxt=completePage.verifyThankYouTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Thank you for your order! is: " + actTxt);
	}

	@Test
	public void verifyCompleteSubTxt() {
		String expTxt="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actTxt=completePage.verifyCompleteSubTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Your order has been dispatched, and will arrive just as fast as the pony can get there! is: " + actTxt);
	}

	@Test
	public void verifyBackBtn() {
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=completePage.verifyBackBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After click on back button navigate to="+actURL);
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException {
		if(it.FAILURE==it.getStatus()) {
			Screenshots.screenshot(it.getName());
		}
		
		driver.close();
	}

}
