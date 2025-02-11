package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckoutPage;
import pages.CheckoutStepTwo;
import pages.InventoryPage;
import pages.LoginPage;
import utility.Screenshots;

public class CheckoutStepTwoTest extends TestBase{
	
	LoginPage login;
	InventoryPage inventory;
	CartPage cart;
	CheckoutPage checkout;
	CheckoutStepTwo checkoutStepTwo;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		login=new LoginPage();
		inventory=new InventoryPage();
		cart=new CartPage();
		checkout=new CheckoutPage();
		checkoutStepTwo=new CheckoutStepTwo();
		login.verifyLoginPage();
		inventory.add6CartProducts();
		inventory.verifyShppingCartFunctionality();
		cart.verifyCheckoutBtnFunctionality();	
		checkout.enterYourInformationToContinue();
	}
	@Test
	public void verifyCheckoutOverviewTxtTest() {
		String expTxt="Checkout: Overview";
		String actTxt=checkoutStepTwo.verifyCheckoutOverviewTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Checkout: Overview is present= " + actTxt);
	}
	@Test
	public void verifyPaymentInformationTxtTest() {
		String expTxt="Payment Information:";
		String actTxt=checkoutStepTwo.verifyPaymentInformationTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Payment Information: is present= " + actTxt);
	}
	@Test
	public void verifyPaymentValueTest() {
		String expTxt="SauceCard #31337";
		String actTxt=checkoutStepTwo.verifyPaymentValue();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("SauceCard #31337 is present= " + actTxt);
	}
	@Test()
	public void verifyshippingInformationTxtTest() {
		String expTxt="Shipping Information:";
		String actTxt=checkoutStepTwo.verifyshippingInformationTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Shipping Information: is present= " + actTxt);
	}
	@Test
	public void verifyshippingValueTest() {
		String expTxt="Free Pony Express Delivery!";
		String actTxt=checkoutStepTwo.verifyshippingValue();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Free Pony Express Delivery!is present= " + actTxt);
	}
	@Test
	public void verifyTotalPriceTxtTest() {
		String expTxt="Price Total";
		String actTxt=checkoutStepTwo.verifyTotalPriceTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Price Total is present= " + actTxt);
	}
	@Test
	public void verifySubtoTotalabelTest() {
		String expTxt="Item total: $129.94";
		String actTxt=checkoutStepTwo.verifySubtoTotalabel();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Item total: $129.94 is present= " + actTxt);
	}
	@Test
	public void verifyTaxLabelTest() {
		String expTxt="Tax: $10.40";
		String actTxt=checkoutStepTwo.verifyTaxLabel();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Tax: $10.40 is present= " + actTxt);
	}
	@Test
	public void verifyTotalLabelTest() {
		String expTxt="Total: $140.34";
		String actTxt=checkoutStepTwo.verifyTotalLabel();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Total: $140.34 is present= " + actTxt);
	}
	@Test
	public void verifyCancelBtnTxtTest() {
		String expTxt="Cancel";
		String actTxt=checkoutStepTwo.verifyCancelBtnTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("cancel button txt is present= " + actTxt);
	}
	@Test
	public void verifyFinishBtnTxtTest() {
		String expTxt="Finish";
		String actTxt=checkoutStepTwo.verifyFinishBtnTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("finish button text is present = " + expTxt);
	}
	@Test
	public void verifyCancelBtnTest() {
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=checkoutStepTwo.verifyCancelBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Click  on cancel button navigate to= " + expURL);
	}
	@Test
	public void verifyfinishBtnTest() {
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=checkoutStepTwo.verifyFinishBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("finish button txt is present = " + expURL);
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException {
		if(it.FAILURE==it.getStatus()) {
			Screenshots.screenshot(it.getName());
		}
		
		driver.close();
	}
	

}
