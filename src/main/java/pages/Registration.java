package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import frameworkbase.BaseMethod;

public class Registration extends BaseMethod {

	public Registration enterFirstName(String name) {

		WebElement frstnm = locateElement("id", "firstname");
		typewithnosnap(frstnm, name);
		return this;
	}
	public Registration enterLastName(String lastname) {
		WebElement lstnm = locateElement("id", "lastname");
		typewithnosnap(lstnm, lastname);
		return this;
	}

	public Registration enterAddressLine1() {

		WebElement addr1 = locateElement("id", "txtStreetAddress1");
		typewithnosnap(addr1, "60 Patterson Blvd SW ");
		return this;
	}

	public Registration enterCity() {

		WebElement citynm = locateElement("id", "city");
		typewithnosnap(citynm, "Calgary");
		return this;

	}

	public Registration selectProvince() {

		WebElement prvn = locateElement("id", "Province");
		selectDropDownUsingText(prvn, "Alberta");
		return this; 
	}

	public Registration postalcode() {

		WebElement pstlcd1 = locateElement("id", "post1");
		typewithnosnap(pstlcd1, "T3H");
		WebElement pstlcd2 = locateElement("id", "post2" );
		typewithnosnap(pstlcd2, "2E1");
		return this;
	}

	public Registration phnnum() {

		WebElement num = locateElement("id", "phone");
		typewithnosnap(num, "9789548369");
		return this;
	}
	public Registration location() {

		WebElement location = locateElement("id", "Location");
		selectDropDownUsingText(location, "Calgary");
		return this;

	}

	public Registration verifyPhoneNumber() {
		WebElement phnnum = locateElement("id", "mobphone");
		verifySelected(phnnum);
		return this;
	}


	public Registration enterEmailId() {

		WebElement emal = locateElement("id", "email");
		typewithnosnap(emal,"sample@gmail.com");
		WebElement emalcnfm = locateElement("id", "confirmemail");
		typewithnosnap(emalcnfm, "sample@gmail.com");
		return this;
	}

	public Registration enterPassword(String password, String confirmpassword) {

		WebElement pswd = locateElement("id", "pass1");
		type(pswd, password);
		WebElement pswdcnfm = locateElement("id", "pass2");
		type(pswdcnfm, confirmpassword);
		return this;
	}


	public Registration selectResident() {

		WebElement resid = locateElement("id", "canadaresidentyes");
		click(resid);
		return this;
	}

	public Registration selectCompanyType() {

		WebElement cmpnynm = locateElement("id", "incorpno");
		click(cmpnynm);
		return this;
	}


	public void clickNextwithValidation() throws InterruptedException {

		WebElement nextbtn = locateElement("id", "Next");
		click(nextbtn);
		
		List<WebElement> errors = locateElements("xpath", "//span[@class='error']");
		if(errors != null) {
			for (WebElement error : errors) {
				System.out.println(error.getText());
				reportStep(" Error Message : " +error.getText()+ " is received successfully ", "pass");
			}
		}

		else {

			System.out.println("Successfully moved to next page");
			movetonextStep();
		}

	}


	public RegistrationSpecSkills clickNextwithoutValidation() {

		WebElement nextbtn = locateElement("id", "Next");
		click(nextbtn);
		return new  RegistrationSpecSkills();
		
	}

	public RegistrationSpecSkills movetonextStep() {


		return new RegistrationSpecSkills();
	}





}



