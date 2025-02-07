package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutPage extends TestBase {

	@FindBy(xpath = "//span[text()='Checkout: Your Information']")
	private WebElement checkoutTitle;
	@FindBy(xpath = "//input[@id='first-name']")
	private WebElement firstNameTxtBox;
	@FindBy(xpath = "//input[@id='last-name']")
	private WebElement lastNameTxtBox;
	@FindBy(xpath = "//input[@id='postal-code']")
	private WebElement postalCodeTxtBox;
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueBtn;
	@FindBy(xpath = "//button[@id='cancel']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//h3[text()='Error: Postal Code is required']")
	private WebElement errorMsgForPostalCode;
	@FindBy(xpath = "//h3[text()='Error: First Name is required']")
	private WebElement errorMsgFirstName;
	@FindBy(xpath = "//h3[text()='Error: Last Name is required']")
	private WebElement errorMsgLastName;

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyCheckoutYourInformationTxt() {
		return checkoutTitle.getText();
	}

	public String enterYourInformationToContinue() {
		firstNameTxtBox.sendKeys("Arti");
		lastNameTxtBox.sendKeys("Kulkarni");
		postalCodeTxtBox.sendKeys("431517");
		continueBtn.click();
		return driver.getCurrentUrl();

	}

	public String verifyErrorMsgForPostalCode() {
		firstNameTxtBox.sendKeys("arti");
		lastNameTxtBox.sendKeys("kulkarni");
		continueBtn.click();
		return errorMsgForPostalCode.getText();
	}

	public String verifyErrorMsgForFirstName() {

		lastNameTxtBox.sendKeys("kulkarni");
		postalCodeTxtBox.sendKeys("431517");
		continueBtn.click();
		return errorMsgFirstName.getText();
	}

	public String verifyErrorMsgForLastName() {

		firstNameTxtBox.sendKeys("arti");
		postalCodeTxtBox.sendKeys("431517");
		continueBtn.click();
		return errorMsgLastName.getText();
	}

	public boolean verifyContinueBtn() {
		return continueBtn.isDisplayed();

	}

	public boolean verifyCancelBtn() {
		return cancelBtn.isDisplayed();
	}



	public String verifyCancleBtnFunctionality() {
		cancelBtn.click();
		return driver.getCurrentUrl();

	}



	public String verifyCancleBtnTxt() {

		return cancelBtn.getText();

	}

}
