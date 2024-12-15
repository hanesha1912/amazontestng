package base;



import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;
import org.apache.poi.ss.usermodel.Cell;

public class BaseTest {
	public WebDriver driver;
	
	public static final Logger logger = Logger.getLogger(BaseTest.class.getName());
	public Properties prop;
	public static ExtentTest test;
	
	@BeforeTest
	public void setup() {
		prop = new Properties();
		try(FileInputStream fis= new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/utilities/config.properties")){
			prop.load(fis);
		}catch(Exception e) {
			System.out.println("The config.properties file was not found");
			logger.info("config.properties not found");
			e.printStackTrace();
		}
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
	
	}
	
	
	public void fetchDataFromExcel() throws IOException {
		File excelFile = new File(System.getProperty("user.dir")+ "src\\main\\java\\utilities\\fw.xlsx" );
		FileInputStream fis = new FileInputStream(excelFile);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
	//	HSSFWorkbook workbook = new HSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		DataFormatter format = new DataFormatter();
		Cell cell = sheet.getRow(1).getCell(0);
	
	String username = format.formatCellValue(cell);
	System.out.println("The username from the excel is :" + username);
	String password  =  sheet.getRow(1).getCell(1).getStringCellValue();
	System.out.println("The password from the excel is :" + password);
	
	workbook.close();
	
	}
	
	@AfterTest
	
	public void teardown() {
		driver.quit();
		logger.config("Quitted Driver");
	}
		
		public static String getCurrentDateTime(){
			return new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
		} 
		
		public String getScreenShotPath(String testcasename,WebDriver driver) throws IOException {
			TakesScreenshot ts= (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir")+"/screenshots/"+ testcasename +".png";
			FileUtils.copyFile(source,new File(destination));
			
			return(destination);
		
		}
		
		
	}

