package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import frameworkbase.ProjectWrapper;
import pages.Login;

public class SampleTest extends ProjectWrapper{

	@BeforeClass
	public void steData() {

		testCaseName = "New Candidate self Registration";
		testCaseDescription = "As a New Candidate during candidate self registration, I should be able to enter the Password adhered to the New Password Policy requirements.";
		author = "Sruthi";
		category = "sanity";
		wbookName = "testbook";
		
	} 
	
	

	@Test(priority =1,dataProvider="fetchData")
	public void registration(String fname, String lname ,String pswrd, String cnfmpswd) throws InterruptedException {

		new Login()
		.Register()
		.enterFirstName(fname)
		.enterLastName(lname)
		.enterAddressLine1()
		.enterCity()
		.selectProvince()
		.postalcode()
		.phnnum()
		.location()
		.verifyPhoneNumber()
		.enterEmailId()
		.enterPassword(pswrd,cnfmpswd)	  
		.selectResident()
		.selectCompanyType()
		.clickNextwithValidation();
		WebElement text = locateElement("xpath", "//span[text()=' Your Specialization, Roles and Skills ']");
		try{if(text.isEnabled()) {
		reportStep(getText(text) +" found ", "pass");
		}
		else {
			closeBrowser();
		}
		}catch (Exception e) {
			
		}
		{
			
		}
		closeBrowser();	

	}


}



