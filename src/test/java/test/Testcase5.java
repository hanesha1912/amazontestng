package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import base.BaseTest;

//1. Launch Chrome browser.
//2. Launch URL https://www.amazon.in
//3. Mouse hover to the sign-in option.
//4. Click on the sign-in button
//4. Validate the sign-in page URL
//5. Close the browser.
public class Testcase5 extends BaseTest{
	
	/*//3. Mouse hover to the sign-in option.
	WebElement sign_in = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		
	Actions act = new Actions(driver);
	act.moveToElement(sign_in).build().perform();
	
	WebElement sign_in1 = driver.findElement(By.xpath("//span[@class='nav-action-inner']"));
	
	sign_in1.click();*/
	
	
	public void verifypageurl() {
		System.out.println("Verifying the current page url:"+driver.getCurrentUrl());
		
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.in/","test failed because url didn't matched");

	}

}
