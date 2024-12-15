package test;



import java.security.PublicKey;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.LoginPage;

//1. Launch Chrome browser.
//2. Launch URL https://www.amazon.in
//3. Click on the location select option. (right top corner)
//3. Enter valid pincode (i.e. 400XXX)
//4. Click on the apply button.
//5. Validate that the mentioned pincode appears on the location select option.
//6. Close the browser.
public class Testcase4 extends BaseTest{
	
	@Test
	public void Verifylocation() {
	boolean flag = false;
	LoginPage login = new LoginPage(driver);
	login.updateLocation();
	//id="glow-ingress-line2"
	if(login.getPinCode().contains("506370")){
		flag = true;
	}
	Assert.assertTrue(flag);

	}
	
	

}
