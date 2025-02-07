package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshots;

public class CheckoutPageTest extends TestBase {
	
	LoginPage login;
	InventoryPage inventory;
	CartPage cart;
	CheckoutPage checkout;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, InterruptedException {
		initialization();
		login=new LoginPage();
		inventory=new InventoryPage();
		cart=new CartPage();
		checkout=new CheckoutPage();
		login.verifyLoginPage();
		inventory.add6CartProducts();
		inventory.verifyShppingCartFunctionality();
		cart.verifyCheckoutBtnFunctionality();	
	}
	@Test
	public void verifyCheckoutYourInformationTxtTest() throws EncryptedDocumentException, IOException {
		String expTxt=ReadData.excelSheetData(0, 0);//Checkout: Your Information
		String actTxt=checkout.verifyCheckoutYourInformationTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("your information txt on checkout page="+actTxt);
		
	}
	@Test
	public void enterYourInformationToContinueTest() throws EncryptedDocumentException, IOException {
		String expURL=ReadData.excelSheetData(0, 1);//"https://www.saucedemo.com/checkout-step-two.html"
		String actURL=checkout.enterYourInformationToContinue();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After checkout navigate to="+actURL);
				
	}
	@Test
	public void ververifyContinueBtnTest() {
		boolean result=checkout.verifyContinueBtn();
		Assert.assertEquals(result, true);
		Reporter.log("continue button is present="+result);
	}
	@Test
	public void ververifyCancleBtnTest() {
		boolean result=checkout.verifyCancelBtn();
		Assert.assertEquals(result, true);
		Reporter.log("cancel button is present="+result);
	}
	
	@Test
	public void verifyCancleBtnTxtTest() throws EncryptedDocumentException, IOException {
		String expTxt=ReadData.excelSheetData(0, 3);//"Cancel"
		String actTxt=checkout.verifyCancleBtnTxt();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("cancel button  txt on checkout page="+actTxt);
		
	}
	@Test(groups = "regression")
	public void verifyCancleBtnFunctionalityTest() throws EncryptedDocumentException, IOException {
		String expURL=ReadData.excelSheetData(0, 4);//"https://www.saucedemo.com/cart.html"
		String actURL=checkout.verifyCancleBtnFunctionality();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After cancel navigate to="+actURL);
				
	}
	@Test(groups = "sanity")
	public void verifyErrorMsgForPostalCodeTest() throws EncryptedDocumentException, IOException {
		String expTxt=ReadData.excelSheetData(0, 5);//"Error: Postal Code is required";
		String actTxt=checkout.verifyErrorMsgForPostalCode();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("error msg if postal text box is empty="+actTxt);
	}
	@Test(groups = "sanity")
	public void verifyErrorMsgForFirstNameTest() throws EncryptedDocumentException, IOException {
		String expTxt=ReadData.excelSheetData(0, 6);//"Error: First Name is required";
		String actTxt=checkout.verifyErrorMsgForFirstName();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("error msg if first name  text box is empty="+actTxt);
	}
	@Test
	public void verifyErrorMsgForLastNameTest() throws EncryptedDocumentException, IOException {
		String expTxt=ReadData.excelSheetData(0, 7);//"Error: Last Name is required";
		String actTxt=checkout.verifyErrorMsgForLastName();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("error msg if last name text box is empty="+actTxt);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException {
		if(it.FAILURE==it.getStatus()) {
			Screenshots.screenshot(it.getName());
		}
		driver.close();
	}
	
	

}
