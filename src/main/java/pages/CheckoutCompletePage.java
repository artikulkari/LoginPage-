package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutCompletePage extends TestBase {

	@FindBy(xpath = "//span[text()='Checkout: Complete!']")
	private WebElement completeTxT;
	@FindBy(xpath = "//img[@class='pony_express']")
	private WebElement completeLogo;
	@FindBy(xpath = "//h2[text()='Thank you for your order!']")
	private WebElement ThankYou;
	@FindBy(xpath = "//div[@class='complete-text']")
	private WebElement completeSubTxt;
	@FindBy(xpath = "//button[@id='back-to-products']")
	private WebElement backBtn;

	public CheckoutCompletePage() {

		PageFactory.initElements(driver, this);
	}

	public String verifyCompleteTxt() {

		return completeTxT.getText();

	}

	public boolean verifycompleteLogo() {
		return completeLogo.isDisplayed();
	}

	public String verifyThankYouTxt() {
		return ThankYou.getText();
	}

	public String verifyCompleteSubTxt() {
		return completeSubTxt.getText();
	}

	public String verifyBackBtn() {
		backBtn.click();
		return driver.getCurrentUrl();
	}

}
