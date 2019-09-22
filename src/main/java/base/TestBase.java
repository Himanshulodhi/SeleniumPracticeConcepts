package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.EventListenerUtil;
import utilities.TestUtil;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static WebDriverManager webdrivermanager;
	public static EventFiringWebDriver eventfiringwebdriver;
	public static EventListenerUtil eventlistenerutil;
	
	public TestBase() {
		FileInputStream fp;
		try {
			fp=new FileInputStream("E:\\Eclipse_Workspace\\PracticeConcepts\\src\\main\\java\\config\\config.properties");
		   prop=new Properties();
		   try {
			prop.load(fp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialisation() {
		String browser=prop.getProperty("browser");
		if (browser.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver","./src/main/java/drivers/chromedriver.exe");
			//WebDriverManager.chromedriver().version("2.40").arch64().setup();
			driver=new ChromeDriver();				
			
		}
		
		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/main/java/drivers/gecko.exe");
			driver=new FirefoxDriver();
			//WebDriverManager.firefoxdriver().setup();			
		}
		else if (browser.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			
		}
		else {
			System.out.println("Browser Not Vlid");
		}
	eventfiringwebdriver= new EventFiringWebDriver(driver);
	eventlistenerutil=new EventListenerUtil();
	eventfiringwebdriver.register(eventlistenerutil);
	driver=eventfiringwebdriver;
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("url"));
	}

}
