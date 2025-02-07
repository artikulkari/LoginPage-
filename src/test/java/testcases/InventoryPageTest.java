package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.BooleanArraySerializer;

import base.TestBase;
import pages.InventoryPage;
import pages.LoginPage;
import utility.Screenshots;

public class InventoryPageTest extends TestBase {

	LoginPage login;
	InventoryPage inventory;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		initialization();
		login = new LoginPage();
		inventory = new InventoryPage();
		login.verifyLoginPage();
	}

	@Test(groups = "sanity")
	public void verifyTwitterLogoTest() {
		boolean result = inventory.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("twitter logo is presnet=" + result);

	}

	@Test(groups = "sanity")
	public void verifyFacebookLogoTest() {
		boolean result = inventory.verifyFacebookLogo();
		Assert.assertEquals(result, true);
		Reporter.log("facebook logo is presnet=" + result);
	}
	@Test(groups = "sanity")
	public void verifyShppingCartFunctionalityTest() throws InterruptedException {
		String expURL="https://www.saucedemo.com/cart.html";
		String actURL=inventory.verifyShppingCartFunctionality();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Navigate to shopping cart Page="+actURL);
	}

	@Test(groups = "sanity")
	public void verifyLinkedInLogoTest() {
		boolean result = inventory.verifylinkedinLogo();
		Assert.assertEquals(result, true);
		Reporter.log("linkedin logo is presnet=" + result);
	}

	@Test(groups = "sanity")
	public void verifyShoppingCartLogoTest() {
		boolean result = inventory.verifyShoppingCartLogo();
		Assert.assertEquals(result, true);
		Reporter.log("shoppingcart logo is presnet=" + result);
	}

	@Test
	public void verfySwagLabTxtTest() {
		String expTxt="Swag Labs";
		String actTxt=inventory.verifySwagLabTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Swag Lab txt is: " + actTxt);

	}
	@Test
	public void verifyProductsTxtTest() {
		String expTxt="Products";
		String actTxt=inventory.verifyProductsTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Products txt is: " + actTxt);
	}
	@Test(groups = "regression")
	public void verifyFooterTxtTest() {
		String expTxt="© 2025 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actTxt=inventory.verifyfooterTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("footer  txt is=" + actTxt);
	}
	@Test(groups = "regression")
	public void verifyDropDownItemAToZTest() {
		String expTxt="Name (A to Z)";
		String actTxt=inventory.verifyDropDownItemAToZ();
		Assert.assertEquals(expTxt,actTxt);
		Reporter.log("Name (A to Z) option is present="+actTxt);
	}
	@Test
	public void add6ProductsTest() throws InterruptedException {
		String expCount="6";
		String actCount=inventory.add6CartProducts();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Added 6 Product="+actCount);
	}
	@Test
	public void remove2ProductsTest() throws InterruptedException {
		String expCount="4";
		String actCount=inventory.remove2Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("remove 2 Product="+actCount);
		
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException {
		if(it.FAILURE==it.getStatus()) {
			Screenshots.screenshot(it.getName());
		}
		
		driver.close();
	}
}
