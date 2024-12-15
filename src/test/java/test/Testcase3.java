package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pageObjects.CartPage;
import pageObjects.LoginPage;


public class Testcase3 extends BaseTest {
	
	@Test
	public void testCartPageTitle() {
	LoginPage login = new LoginPage(driver);
	login.navigateToCart();
	logger.info("Navigated to Cart");
	test.log(Status.INFO,"Navigated to Cart");
	

	CartPage cart = new CartPage(driver);
	Assert.assertEquals(cart.getLabelEmptyCart().getText(), "Your Amazon Cart is empty");
	logger.info("Assertion Passed - Amazon Cart is Empty");
	test.log(Status.PASS,"Assertion Passed - Amazon Cart is Empty");
	
	Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart", "Test Failed because the title didn't match");
	logger.info("Assertion Passed -  Cart Title is matched");
	test.log(Status.PASS,"Assertion Passed -  Cart Title is matched");
	}
}
