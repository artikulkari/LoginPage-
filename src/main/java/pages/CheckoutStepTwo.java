package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutStepTwo extends TestBase {
	
	@FindBy(xpath="//span[@class='title']") private WebElement checkoutOverview;
	@FindBy(xpath="//div[text()='Payment Information:']") private WebElement paymentInformation;
	@FindBy(xpath="//div[@data-test='payment-info-value']") private WebElement paymentInformationValue;
	@FindBy(xpath="//div[text()='Shipping Information:']")private WebElement shippingInformation;
	@FindBy(xpath="//div[@data-test='shipping-info-value']")private WebElement shippingInformationValue;
	@FindBy(xpath="//div[text()='Price Total']")private WebElement totalPriceTxt;
	@FindBy(xpath="//div[@data-test='subtotal-label']")private WebElement subtototalabel;
	@FindBy(xpath="//div[@data-test='tax-label']")private WebElement taxLabel;
	@FindBy(xpath="//div[@data-test='total-label']")private WebElement totalLabel;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancelBtn;
	@FindBy(xpath="//button[@id='finish']") private WebElement finishBtn;
	
	
	public CheckoutStepTwo() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckoutOverviewTxt() {
		return checkoutOverview.getText();
	}
	public String verifyPaymentInformationTxt() {
		return paymentInformation.getText();
	}
	public String verifyPaymentValue() {
		return paymentInformationValue.getText();
	}
	public String verifyshippingInformationTxt() {
		return shippingInformation.getText();
	}
	public String verifyshippingValue() {
		return shippingInformationValue.getText();
	}
	public String verifyTotalPriceTxt() {
		return totalPriceTxt.getText();
	}
	public String verifySubtoTotalabel() {
		return subtototalabel.getText();
	}
	public String verifyTaxLabel() {
		return taxLabel.getText();
	}
	public String verifyTotalLabel() {
		return totalLabel.getText();
	}
	public String verifyCancelBtnTxt() {
		
		return cancelBtn.getText();
	}
	public String verifyFinishBtnTxt() {
		
		return finishBtn.getText();
	}
	
	public String verifyCancelBtn() {
		cancelBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyFinishBtn() {
		finishBtn.click();
		return driver.getCurrentUrl();
	}

}
