package test;

import java.util.Set;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class Testcase6 extends BaseTest {
	
	@Test
	public void testProductIsAddedToCart() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.openFirstSearchResultElement();
		String prodName = login.getProductname();
		logger.info("List Product Name "+prodName);
		
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		
		ProductPage product = new ProductPage(driver);
		logger.info(driver.getTitle());
		product.addToCart();
		CartPage cartPage = new CartPage(driver);
		
		driver.switchTo().window(parentWindow);
		driver.navigate().refresh();
		logger.info(driver.getTitle());
		
		login.navigateToCart();
		logger.info("Navigated to cart page");
		String productName = cartPage.getProductNameFromCart();
		logger.info("cart productName is "+ productName);
		
		Assert.assertEquals(prodName,productName,"Test failed -The product name didn't match");
		logger.info("Test passed-product name matched");
		
	
	}

}
