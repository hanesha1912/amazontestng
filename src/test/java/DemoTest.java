import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class DemoTest {
	

	public void testamazon() {

			WebDriver driver;
			driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			WebElement btn_Signin = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
			btn_Signin.click();
			WebElement txt_Username = driver.findElement(By.xpath("//input[@id='ap_email']"));
			txt_Username.sendKeys("9879879879");
			
			WebElement btn_Continue = driver.findElement(By.id("continue"));
			btn_Continue.click();
			WebElement txt_Password = driver.findElement(By.xpath("//input[@id='ap_password']"));
			txt_Password.sendKeys("AbCD@1234");
			WebElement btn_Submit = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
			btn_Submit.click();
			WebElement lbl_IncorrectPassword = driver.findElement(By.xpath("//*[@class='a-list-item']"));
	boolean flag = false;
			try {
				flag = lbl_IncorrectPassword.isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
			}
	  Assert.assertFalse(flag);
	

	}

}
