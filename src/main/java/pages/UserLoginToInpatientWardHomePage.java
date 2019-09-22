package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class UserLoginToInpatientWardHomePage extends TestBase {
	
	@FindBy(xpath = "//H4[text()='Logged in as Super User () at Inpatient Ward.']")
	WebElement inpatientPageVerification;
	
	
	public UserLoginToInpatientWardHomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyInpatientPageDisplayedText() {
		String inpatientPageTextVerification=inpatientPageVerification.getText();		
		return inpatientPageTextVerification;
	}
	
	public String verifyInpatientPageTitle() {
		
		return driver.getTitle();
	}

}

