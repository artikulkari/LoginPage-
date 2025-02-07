package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase {
	
	
	@FindBy(xpath = "//span[text()='Your Cart']")
	private WebElement yourCartTxt;
	@FindBy(xpath = "//div[text()='Description']")
	private WebElement shoppingCartDescriptionTxt;
	@FindBy(xpath = "//button[@id='checkout']")
	private WebElement checkoutBtn;
	@FindBy(xpath = "//button[@id='continue-shopping']")
	private WebElement countinueShoppingBtn;
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement qtyTxt;
	
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	

	public String verifyYourCartTxt() throws InterruptedException {
		
		return yourCartTxt.getText();
	}

	public String verifyShoppingCartDescriptionTxt() throws InterruptedException {

		return shoppingCartDescriptionTxt.getText();
	}

	public boolean verifyCheckoutBtn() throws InterruptedException {
	
		return checkoutBtn.isDisplayed();
	}

	public String verifyCheckoutBtnTxt() throws InterruptedException {
		
		return checkoutBtn.getText();
	}
	public String verifyCheckoutBtnFunctionality() throws InterruptedException {
		
		checkoutBtn.click();
		return driver.getCurrentUrl();
	}
	public boolean verifyContinueShoppingBtn() throws InterruptedException {
		
		return countinueShoppingBtn.isDisplayed();
	}
	public String verifyContinueShoppingBtnTxt() throws InterruptedException {
		
		return countinueShoppingBtn.getText();
	}
	public String verifyContinueShoppingBtnFunctionality() throws InterruptedException {
		
		countinueShoppingBtn.click();
		return driver.getCurrentUrl();
		
		
	}
	public String verifyQTYTxt() {
		return qtyTxt.getText();
		
		
	}
	
	
	
	

}
