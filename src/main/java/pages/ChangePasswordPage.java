package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import frameworkbase.BaseMethod;

public class ChangePasswordPage extends BaseMethod {
	
	
	public ChangePasswordPage verifyTileandText() {
		
		return this;
	}
	
	public ChangePasswordPage oldPassword() {
		
		return this;
		
	}
	
	public ChangePasswordPage newPassword() {
		
		return this;
	}
	
	public ChangePasswordPage confirmNewPswd() {
		
		return this;
	}
	
    public void clickUpdate() {
    
    	//next button
		WebElement asd  = locateElement("id", "xyz" );
		click(asd);

		List<WebElement> errors = locateElements("xpath", "");
		if(errors == null) {
			movetonext();
		} else {
			for (WebElement error : errors) {
				System.out.println(error.getText());
				reportStep( error.getText()+ " message received successfully ", "pass");;
			}
		}
    }
    
    public ChangePasswordPage movetonext() {
    	
    	return this;
    }
	

}
