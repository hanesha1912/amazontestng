package test;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class Testcase7 extends BaseTest{
	
	public LoginPage login;
	public ProductPage product;
	public CartPage cart;
	
	@BeforeClass
	public void preTest() {
		login = new LoginPage(driver);
		product = new ProductPage(driver);
		cart =new CartPage(driver);
	}
	
	@Test
	public void testmutltiplechildwindows() {
		login.productSearch("mobile phones");
		String productname1 = login.addproductToCartByIndex(2);
		
		String parentWindow =driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		
		Iterator<String> iterator = windowHandles.iterator();
		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if(!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				product.addToCart();
				driver.close();
			}
			
		}
		
		driver.switchTo().window(parentWindow);
		
String productname2 = login.addproductToCartByIndex(3);
		
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		Iterator<String> iterator2 = windowHandles2.iterator();
		while (iterator.hasNext()) {
			String childWindow = iterator2.next();
			if(!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.getTitle());
				product.addToCart();
				driver.close();
			}
			
		}
		
		driver.switchTo().window(parentWindow);
		driver.navigate().refresh();
		login.navigateToCart();
		Assert.assertEquals(cart.getProductCountFromCart(), 2,"The product added to cart doesn't match");
	}

}
