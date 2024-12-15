package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class Testcase10 extends BaseTest{
	
	public LoginPage login;
	
	@BeforeClass
	public void preTest() {
		login = new LoginPage(driver);
		
	}
	
	@Test
	public void testLimitedDeal() throws InterruptedException {
		login.productSearch("mobile phones");
	/*	Actions actions = new Actions(driver);
		actions.moveToElement(login.getLimitedTimeDeal());
		actions.build().perform();
		Thread.sleep(5000);*/
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", login.getLimitedTimeDeal());

	}

}
