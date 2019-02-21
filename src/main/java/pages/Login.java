package pages;

import org.openqa.selenium.WebElement;

import frameworkbase.BaseMethod;

public class Login extends BaseMethod{

	String heading;

	public Login testcandidate(String text) {
		
		reportStep("Scenario is for " + text, "pass");
		return this;
	}
	
	public Login verifyText() {
		
		heading = "Candidate Login";
		driver.getPageSource().contains(heading);
		reportStep(" Page contains "+heading, "pass");
		return this;
	}
	
	public Login enterEmail(String email) {

		WebElement emailid = locateElement("name", "CanLogin");
		type(emailid, email);
		return this;

	}

	public Login enterPassword(String Pswd) {

		WebElement emailid = locateElement("name", "CanPassword");
		type(emailid, Pswd);
		return this;

	}


	public void Loginbuttonwithvalidataion() throws InterruptedException {

		WebElement loginbutton = locateElement("xpath", "//input[@type ='submit']");
		click(loginbutton);

        Thread.sleep(3000);
		WebElement msg = locateElement("id", "QAQCMessageID");
		
		if(msg == null) {
			movetonextpage();
			Thread.sleep(3000);
		} else {
			
				System.out.println(msg.getText());
				reportStep( msg.getText()+ " message received successfully ", "pass");
				takeSnap();
		}
	}
	

	public ChangePasswordPage Loginbuttonwithoutvalidataion() {

		WebElement loginbutton = locateElement("xpath", "//input[@type ='submit']");
		click(loginbutton);


		return new ChangePasswordPage();
	}
	

	public Registration Register() {

		WebElement registerlink = locateElement("linktext", "Register with S.i.");
		click(registerlink);
		return new Registration();
	}

	public ChangePasswordPage movetonextpage() {

		reportStep("Successfully moved to next page", "pass");
		return new ChangePasswordPage();

	}



}
