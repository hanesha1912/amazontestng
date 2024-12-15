package test;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.LoginPage;

//Steps:
//1. Launch Chrome browser.
//2. Launch URL https://www.amazon.in
//3. Go to the end of the page
//4. Click on all the footer links one by one and validate the page URL.
//5. Add an assertion to pass the test case.
//6. Close the browser.


public class Testcase11  extends BaseTest{
	public LoginPage login;
	boolean flag = false;
	
	@BeforeClass
	public void preTest() {
		login = new LoginPage(driver);
		
	}
	
	@Test
	public void footer() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).build().perform();
	
		for(int i=0; i<=login.getFooterList().size()-1; i++) {
			
			String href = login.getFooterList().get(i).getAttribute("href");
			login.getFooterList().get(i).click();
		
			if(driver.getCurrentUrl().contains(href)) {
				flag =true;
				
				
			}
			
			Assert.assertTrue(flag);
			driver.navigate().back();
		}

	}
	
	//*[@class='navFooterDescItem']/a
}
