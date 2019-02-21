package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import frameworkbase.ProjectWrapper;
import pages.Login;

public class ExistingCandidateSampleTest extends ProjectWrapper {

	
	@BeforeClass
	public void steData() {

		testCaseName = "Existing Candidate should be able to sign in";
		testCaseDescription = "As an existing Candidate I should be able to sign in with the existing User name (Registered Email Address) and Password in the Web App Environment ) when I access";
		author = "Sruthi";
		category = "sanity";
		wbookName = "ExistingCandidateTestbook";
	} 

	@Test(dataProvider="fetchData")
	public void registration(String text, String emailid, String pswd) throws InterruptedException {

		new Login()
		.testcandidate(text)
		.verifyText()
		.enterEmail(emailid)
		.enterPassword(pswd)
		.Loginbuttonwithvalidataion();
		closeBrowser();
		
		
	}
}
