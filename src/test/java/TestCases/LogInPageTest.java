package TestCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import junit.framework.Assert;
import pages.LoginPage;
import pages.UserLoginToInpatientWardHomePage;
import utilities.TestUtil;

public class LogInPageTest extends TestBase {
	
	LoginPage loginpage;
	Logger log=Logger.getLogger(LogInPageTest.class.getName());
	
	
	UserLoginToInpatientWardHomePage userlogininpatientwardhomepage;
	public LogInPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialisation();
		loginpage=new LoginPage();
		userlogininpatientwardhomepage=new UserLoginToInpatientWardHomePage();
	}
	
	@DataProvider(name = "LoginDetails")
	public Object[][] getLoginDetails(){
		Object[][] data=TestUtil.getTestData("LoginDetails");
		return data;
	}
	
	@Test(dataProvider = "getLoginDetails")
	public void UserLoginToInpatientWardTest(String uname, String pword) {
		loginpage.loginUserToInpatientWard(uname, pword);
		String actualText=userlogininpatientwardhomepage.verifyInpatientPageTitle();
		PropertyConfigurator.configure("E:\\Eclipse_Workspace\\PracticeConcepts\\src\\main\\java\\config\\log4j.properties");
		log.info("Checking the Title of the page");
		Assert.assertEquals("Home", actualText);
		log.info("Title matched testcase passed");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
