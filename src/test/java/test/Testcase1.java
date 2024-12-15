package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class Testcase1 extends BaseTest{
	
	boolean flag = false ;
	
	@Test
	public void verifypagetitle() {
	//	String actualPageTitle = driver.getTitle();
	//	System.out.println("The Actual page title :"+actualPageTitle);
	//	String expectedPageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
	//	if(expectedPageTitle.contains(actualPageTitle)) {
	//		 flag = true;
			
	//	}
	//	else {
	//		flag = false;
	//	}
//		Assert.assertTrue(flag,"Test failed because the title didn't match");
	Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	
	}
	
	public void verifypageurl() {
		System.out.println("Verifying the current page url:"+driver.getCurrentUrl());
		
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.in/","test failed because url didn't matched");

	}

}
