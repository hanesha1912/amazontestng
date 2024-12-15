package pageObjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	boolean flag = false;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "nav-link-accountList-nav-line-1" )
	private WebElement btn_Signin;
	
	@FindBy(xpath = "//input[@id='ap_email']" )
	private WebElement txt_Username;
	
	@FindBy(id="continue")
	private WebElement btn_Continue;
	
	@FindBy(xpath="//input[@id='ap_password']")
	private WebElement txt_Password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement btn_Submit;
	
	@FindBy(xpath="//*[@class='a-list-item']")
	private WebElement lbl_IncorrectPassword;
	
	@FindBy(id = "nav-cart")
	private WebElement btn_Cart;

	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement txt_SearchBar;

	@FindBy(id = "nav-search-submit-button")
	private WebElement btn_Search;

	@FindBy(xpath = "//*[@class='a-size-medium a-color-base a-text-normal']")
	private List<WebElement> lbl_ProductList;
	
	@FindBy(id="glow-ingress-line2")
	private WebElement lbl_pincode;
	
	@FindBy(id="GLUXZipUpdateInput")
	private WebElement txt_pincodebox;
	
	
	@FindBy(id="glow-ingress-line2")
	private WebElement txt_location;
//	id="glow-ingress-line2"
	//id="GLUXZipUpdate-announce"
	
	//*[@aria-labelledby="GLUXZipUpdate-announce"]
	//*[@aria-labelledby='GLUXZipUpdate-announce']
	@FindBy(xpath = "//*[@aria-labelledby='GLUXZipUpdate-announce']")
	private WebElement btn_Apply;
	
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	private WebElement btn_signin;
	
	@FindBy(xpath = "//span[@class='nav-action-inner']")
	private WebElement btn_signin1;
	
/*	@FindBy(xpath ="//*[@class='navFooterDescItem']")
	private WebElement */
	
	
	@FindBy(xpath= "//*[@class='a-badge-text' and contains(text(),'Limited time deal')]")
	private List<WebElement> lbl_LimitedTimeDealList;
	
	@FindBy(xpath ="//*[@class='navFooterDescItem']/a")
	private List<WebElement> lbl_FooterList;
	
	
	@FindBy(xpath ="//div[@class='nav-search-facade']")
	private WebElement dd_dropdown;
	

//	WebElement btn_Signin = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
//	WebElement txt_Username = driver.findElement(By.xpath("//input[@id='ap_email']"));
//	WebElement btn_Continue = driver.findElement(By.id("continue"));
//	WebElement txt_Password = driver.findElement(By.xpath("//input[@id='ap_password']"));
//	WebElement btn_Submit = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
//	WebElement lbl_IncorrectPassword = driver.findElement(By.xpath("//*[@class='a-list-item']"));
	
	//Action methods
	public void atemptlogin() {
		//perform all operations
		btn_Signin.click();
		txt_Username.sendKeys("+919879879879");
		btn_Continue.click();
		txt_Password.sendKeys("AbCD@1234");
		btn_Submit.click();
	}
	
	public void navigateToCart() {
		btn_Cart.click();
	}

	public void openFirstSearchResultElement() throws InterruptedException {
		txt_SearchBar.sendKeys("Samsung Galaxy");
		btn_Search.click();
	}
	
	public String getProductname() {
		String productName = lbl_ProductList.get(0).getText();
		lbl_ProductList.get(0).click();
		return productName;
	}
	
	public void updateLocation() {
		//perform all operations
		lbl_pincode.click();
		txt_pincodebox.clear();
		txt_pincodebox.sendKeys("506370");
		btn_Apply.click();
		
	}
	
	public String getPinCode() {
		return txt_location.getText();
	}
	
/*	Actions act = new Actions(driver);
	act.moveToElement(sign_in).build().perform();*/
	
	public void productSearch(String productname) {
		txt_SearchBar.sendKeys(productname);
		btn_Search.click();

	}
	
	
	
	public String addproductToCartByIndex(int index) {
		String productName = lbl_ProductList.get(index).getText();
		lbl_ProductList.get(index).click();
		return productName;
	}
	
	public WebElement getLimitedTimeDeal() {
		return lbl_LimitedTimeDealList.get(0);

	}
	
	public List<WebElement> getFooterList() {
		return lbl_FooterList;
		
	}
	
	public boolean verifyFooterHrefToUrl() {
		for(int i=0; i<=getFooterList().size()-1; i++) {
			
			String href = getFooterList().get(i).getAttribute("href");
			getFooterList().get(i).click();
		
			if(driver.getCurrentUrl().contains(href)) {
				flag =true;
				
				
			}
	}
	return flag;
	}
}
