package pageObjects;



import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[contains(text(),'Your Amazon Cart is empty')]")
	private WebElement lbl_AmazonCartIsEmpty;
	
	@FindBy(xpath = "//*[@class='a-truncate-cut']")
	private List<WebElement> lbl_ProductAddToCart;
	
//	Action Methods
	public WebElement getLabelEmptyCart() {
		return lbl_AmazonCartIsEmpty;
	}
	
	public String getProductNameFromCart() {
		return lbl_ProductAddToCart.get(0).getText();
	}
	
	public int getProductCountFromCart() {
		return lbl_ProductAddToCart.size();
	}
	
	
		
		
	}


