package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.LoginPage;

public class TestLogin extends BaseTest{
	
	@Test
	public void testLogin() {
		
		LoginPage login =new LoginPage(driver);
		System.out.println("browser launch and amazon page loaded");
		login.atemptlogin();
		System.out.println("Test finished");
	} 
	}

