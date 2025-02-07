package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import base.TestBase;
import pages.LoginPage;
import utility.Screenshots;

public class LoginPageTest extends TestBase {

	LoginPage login;

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		login = new LoginPage();
	}

	@Test
	public void verifyLoginPageTest() throws IOException {
		String expURL = "https://www.saucedemo.com/inventory.html";
		String actURL = login.verifyLoginPage();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Login sucessful" + actURL);
	}

	@Test(dependsOnMethods = "verifyLoginPageTest()")
	public void verifyURLOfApplicationTest() {

		String expURL = "https://www.saucedemo.com/";
		String actURL = login.varifyURLOfApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Swag Lab URL " + actURL);
	}

	@Test(dependsOnMethods = "verifyLoginPageTest()")
	public void verifyTitleOfApplicationTest() {
		String expTitle = "Swag Labs";
		String actTitle = login.varifyTitleOfApplication();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Swag Lab Title " + actTitle);
	}

	@DataProvider(name = "credForLogin")
	public Object[][] getData() {
		return new Object[][] { { "standard_user", "secret_sauce" }, { "locked_out_user", "secret_sauce" },
				{ "problem_user", "secret_sauce" }, { "performance_glitch_user", "secret_sauce" },
				{ "error_user", "secret_sauce" }, { "visual_user", "secret_sauce" } };
	}

	@Test(dataProvider = "credForLogin")
	public void verifyLoginPageWithMultipleUsersTest(String un, String pass) {
		SoftAssert sa = new SoftAssert();
		String expURL = "https://www.saucedemo.com/inventory.html";
		String actURL = login.verifyLoginPageWithMultipleUsers(un, pass);
		sa.assertEquals(expURL, actURL);
		sa.assertAll();
	}

	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException {
		if (it.FAILURE == it.getStatus()) {
			Screenshots.screenshot(it.getName());
		}
		report.flush();
		driver.close();
	}

}
