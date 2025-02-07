package pages;

import java.io.IOException;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDown;

public class InventoryPage extends TestBase {

	@FindBy(xpath = "//a[text()='Twitter']")
	private WebElement twitterLogo;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement shoppingCartLogo;
	@FindBy(xpath = "//a[text()='Facebook']")
	private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']")
	private WebElement linkedLogo;
	@FindBy(xpath = "//div[text()='Swag Labs']")
	private WebElement swagLabTxt;
	@FindBy(xpath = "//span[text()='Products']")
	private WebElement productsTxt;
	@FindBy(xpath = "//div[@class='footer_copy']")
	private WebElement footerTxt;
	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement dropDownList;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement backpackProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
	private WebElement bikelightProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	private WebElement boltT_shirtProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
	private WebElement fleeceJacketProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
	private WebElement onesieProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
	private WebElement redT_shirtProduct;
	@FindBy(xpath = "//span[@class='active_option']")
	private WebElement nameAtoZTxt;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	private WebElement shoppingCartCount;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
	private WebElement removeBackpackProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
	private WebElement reomveBikeLightProduct;
     
	public InventoryPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyTwitterLogo() {
		return twitterLogo.isDisplayed();
	}
	public String verifyShppingCartFunctionality() throws InterruptedException {
		shoppingCartLogo.click();
		Thread.sleep(1000);
		return driver.getCurrentUrl();
	}

	public boolean verifyFacebookLogo() {
		return facebookLogo.isDisplayed();
	}

	public boolean verifylinkedinLogo() {
		return linkedLogo.isDisplayed();
	}

	public boolean verifyShoppingCartLogo() {
		return shoppingCartLogo.isDisplayed();
	}

	public String verifySwagLabTxt() {
		return swagLabTxt.getText();
	}

	public String verifyProductsTxt() {
		return productsTxt.getText();
	}

	public String verifyfooterTxt() {
		return footerTxt.getText();
	}

	public String verifyDropDownItemAToZ() {
		HandleDropDown.handleDropDown(dropDownList, "Name (A to Z)");
		return nameAtoZTxt.getText();

	}

	public String add6CartProducts() throws InterruptedException {
		HandleDropDown.handleDropDown(dropDownList, "Name (A to Z)");
		backpackProduct.click();
		Thread.sleep(1000);
		bikelightProduct.click();
		Thread.sleep(1000);
		boltT_shirtProduct.click();
		Thread.sleep(1000);
		fleeceJacketProduct.click();
		Thread.sleep(1000);
		onesieProduct.click();
		Thread.sleep(1000);
		redT_shirtProduct.click();
		Thread.sleep(1000);
		return shoppingCartCount.getText();
	}

	public String remove2Products() throws InterruptedException {
		add6CartProducts();
		Thread.sleep(2000);
		removeBackpackProduct.click();
		reomveBikeLightProduct.click();
		return shoppingCartCount.getText();
	}

	
}
