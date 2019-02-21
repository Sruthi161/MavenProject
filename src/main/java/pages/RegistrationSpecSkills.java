package pages;

import org.openqa.selenium.WebElement;

import frameworkbase.BaseMethod;

public class RegistrationSpecSkills extends BaseMethod{

	public RegistrationSpecSkills selectPrimarySpecialization() {
		
		WebElement specialization = locateElement("id", "Specialization_1");
	    selectDropDownUsingText(specialization, "Business Intelligence");
	    return this;
	    
	}
}
