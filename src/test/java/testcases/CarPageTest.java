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
import pages.InventoryPage;
import pages.LoginPage;
import utility.Screenshots;

public class CarPageTest extends TestBase {
	
	LoginPage login;
	InventoryPage inventory;
	CartPage cart;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		login = new LoginPage();
		inventory = new InventoryPage();
		cart=new CartPage();
		login.verifyLoginPage();
		inventory.add6CartProducts();
		inventory.verifyShppingCartFunctionality();
		
	}
	
	@Test
	public void verifyYourCartTxtTest() throws InterruptedException {
		String expTxt="Your Cart";
		String actTxt=cart.verifyYourCartTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Your cart txt on cart page is present= " + actTxt);
	}
	@Test
	public void verifyShoppingCartDescriptionTxtTest() throws InterruptedException {
		String expTxt="Description";
		String actTxt=cart.verifyShoppingCartDescriptionTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Description txt on cart page is present= " + actTxt);
	}
	@Test
	public void verifyCheckoutBtnTest() throws InterruptedException {
		boolean result=cart.verifyCheckoutBtn();
		Assert.assertEquals(result, true);
		Reporter.log("Checkout button is present="+result);
	}
	@Test
	public void verifyCheckoutBtnTxtTest() throws InterruptedException {
		String expTxt="Checkout";
		String actTxt=cart.verifyCheckoutBtnTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Checkout txt on cart page is present= " + actTxt);
	}
	@Test
	public void verifyCheckoutBtnFunctionalityTest() throws InterruptedException {
		String expURL="https://www.saucedemo.com/checkout-step-one.html";
		String actURL=cart.verifyCheckoutBtnFunctionality();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Navigate to checkout Page="+actURL);
	}
	@Test
	public void verifyContinueShoppingBtnTest() throws InterruptedException {
		boolean result=cart.verifyContinueShoppingBtn();
		Assert.assertEquals(result, true);
		Reporter.log("Continue shopping button is present="+result);
	}
	@Test
	public void verifyContinueShoppingBtnTxtTest() throws InterruptedException {
		String expTxt="Continue Shopping";
		String actTxt=cart.verifyContinueShoppingBtnTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Continue Shopping on cart page is present= " + actTxt);
	}
	@Test
	public void verifyContinueShoppingBtnFunctionalityTest()throws InterruptedException  {
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=cart.verifyContinueShoppingBtnFunctionality();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Navigate to product page="+actURL);
	}	
	@Test
	public void verifyQTYTxtTest() {
		String expTxt="QTY";
		String actTxt=cart.verifyQTYTxt();
		Assert.assertEquals(expTxt, actTxt);
		
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException {
		if(it.FAILURE==it.getStatus()) {
			Screenshots.screenshot(it.getName());
		}
		
		driver.close();
	}
}
