package pages;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase{
	

	
	@FindBy(xpath ="//input[@name='user-name']") private WebElement userNameTxtBox; 
	@FindBy(xpath ="//input[@name='password']") private WebElement passwordTxtBox ;
	@FindBy(xpath ="//input[@name='login-button']") private WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLoginPage() throws IOException {
	
		logger=report.createTest("Login To Sauce Lab Application");
		userNameTxtBox.sendKeys(ReadData.readPropertyFile("Username"));
		logger.log(Status.INFO, "Username is Entered");
		passwordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		logger.log(Status.INFO, "Password is Entered");
		loginBtn.click();
		logger.log(Status.INFO, "Login button is clicked");
		logger.log(Status.PASS, "Login Successfull!!");
		return driver.getCurrentUrl();
	}
	public String verifyLoginPageWithMultipleUsers(String un, String pass) {
		userNameTxtBox.sendKeys(un);
		passwordTxtBox.sendKeys(pass);
		loginBtn.click();
		return driver.getCurrentUrl();
		
	}
	public String varifyURLOfApplication() {
		return driver.getCurrentUrl();
		
	}
	public String varifyTitleOfApplication() {
		return driver.getTitle();
	}

}
