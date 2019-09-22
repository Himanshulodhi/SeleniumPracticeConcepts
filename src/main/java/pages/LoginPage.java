package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "loginButton")
    WebElement loginButton;
	
	//Location for this session
	 
	@FindBy(id = "Inpatient Ward")
	WebElement inpatientWard;
	@FindBy(id = "Isolation Ward")
	WebElement isolationWard;
	@FindBy(id = "Laboratory")
	WebElement laboratory;
	@FindBy(id = "Outpatient Clinic")
	WebElement OutpatientClinic;
	@FindBy(id = "Pharmacy")
	WebElement pharmacy;
	@FindBy(id = "Registration Desk")
	WebElement registrationDesk;
	
	public  LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public UserLoginToInpatientWardHomePage loginUserToInpatientWard(String uname,String pword) {
		username.sendKeys(uname);
		password.sendKeys(pword);
		inpatientWard.click();
		loginButton.click();
		return new UserLoginToInpatientWardHomePage();
		
	}
	
	
}
