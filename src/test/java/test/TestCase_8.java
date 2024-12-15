package test;

import java.security.PublicKey;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;

//Steps
//1. Launch Chrome browser.
//2. Launch URL https://www.amazon.in
//3. Click on the Search dropdown list from the homepage.
//4. Get the count of All the options from the list.
//5. Use Select class and get the text of the 4th element from the options.
//6. Use Select class and click on “Electronics”, so that "Electronics" is selected from the dropdown
//7. Search Laptop from the search box.
//8. Validate Page title contains 'laptop'
//9. Close the browser.

public class TestCase_8 extends BaseTest{
	//public static void main(String[] args) throws InterruptedException {
	@Test
	public void test8() {
		driver.findElement(By.xpath("//div[@class='nav-search-facade']"));
		
	}
	
	
 //1. Launch Chrome browser.
			/*WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();

			//2. Launch URL https://www.amazon.in
			driver.get("https://www.amazon.in/");
			Thread.sleep(2000);
			
			//3.Create a variable for the search dropdown select class
			WebElement searchDD = driver.findElement(By.xpath("//div[@class='nav-search-facade']"));
			
			
			//"//select[@id='searchDropdownBox'][1]"
			Select s = new Select(searchDD);
			
			//.check If multiple selection is possible for the created dropdown select class
			boolean multi = s.isMultiple();
			
			//5.print true or false in the console
			
			System.out.println("Is multiple selection allowed : "+multi);
			
			//5. Use Select class and get the text of the 4th element from the options.
			s.selectByIndex(3);
			System.out.println("the 4th element from the options : ");
			
			driver.navigate().refresh();
			
			//6. Use Select class and click on “Electronics”, so that "Electronics" is selected from the dropdown
			s.selectByVisibleText("Electronics");
			
			//7. Search Laptop from the search box.
			WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
			search.sendKeys("laptop");
			
			//8. Validate Page title contains 'laptop'
			//9.Validate page title.It should contains 'Mobile Phones'
			String title = driver.getTitle();
			System.out.println("title");
			if(title.contains("laptop")) {
				System.out.println("page validation successful");
				}
			else {
				System.out.println("page validation failed");
			}
			
				//10.close the browser
			driver.close();*/
		
		}

