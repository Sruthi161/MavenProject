package frameworkbase;

import org.openqa.selenium.WebElement;

public interface BaseMethodInterface {

	/**
	 * This method will launch the Any browser and 
	 * maximise the browser and set the wait for 30 seconds 
	 * and load the url
	 * @author Sruthi
	 * @param browser - This will load the specified browser
	 * @throws MalformedURLException 
	 */
	public void startApp(String browser,String url);

	/**
	 * This method will locate the element using any given locator
	 * @param locator  - The locator by which the element to be found
	 * @param locValue - The locator value by which the element to be found
	 * @author Sruthi 
	 * @throws NoSuchElementException
	 */
	public WebElement locateElement(String locator, String locValue) ;	

	/**
	 * This method will locate the element using id
	 * @param locValue - The locator value by which the element to be found
	 * @author Sruthi 
	 * @throws NoSuchElementException
	 */
	public WebElement locateElement(String locValue) ;	

	/**
	 * This method will enter the value in the given text field 
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Sruthi 
	 * @throws ElementNotVisibleException		 * 
	 */
	public void type(WebElement ele, String data) ;

	/**
	 * This method will click the element and take snap
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @author Sruthi 
	 */
	public void click(WebElement ele);

	/**
	 * This method will get the text of the element
	 * @param ele   - The Webelement (button/link/element) in which text to be retrieved
	 * @author Sruthi 
	 */
	public String getText(WebElement ele);

	/**
	 * This method will select the drop down visible text
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value The value to be selected (visibletext) from the dropdown 
	 * @author Sruthi 
	 */
	public void selectDropDownUsingText(WebElement ele, String value) ;

	/**
	 * This method will select the drop down using index
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param index  - The index to be selected from the dropdown 
	 * @author Sruthi 
	 */
	public void selectDropDownUsingIndex(WebElement ele, int index) ;

	/**
	 * This method will select the drop down using value
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value - The value to be selected from the dropdown 
	 * @author Sruthi 
	 */
	public void selectDropDownUsingValue(WebElement ele, String value) ;

	/**
	 * This method will verify browser actual title with expected
	 * @param title - The expected title of the browser
	 * @author Sruthi 
	 */
	public void verifyTitle(String expectedTitle);

	/**
	 * This method will verify exact given text with actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Sruthi 
	 */
	public boolean verifyExactText(WebElement ele, String expectedText);

	/**
	 * This method will verify given text contains actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Sruthi 
	 */
	public boolean verifyPartialText(WebElement ele, String expectedText);

	/**
	 * This method will verify exact given attribute's value with actual value on the given element
	 * @param ele   - The Webelement in which the attribute value to be need to be verified
	 * @param attribute  - The attribute to be checked (like value, href etc)
	 * @param value  - The value of the attribute
	 * @author Sruthi 
	 */
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value);

	/**
	 * This method will verify partial given attribute's value with actual value on the given element
	 * @param ele   - The Webelement in which the attribute value to be need to be verified
	 * @param attribute  - The attribute to be checked (like value, href etc)
	 * @param value  - The value of the attribute
	 * @author Sruthi 
	 */
	public boolean verifyPartialAttribute(WebElement ele, String attribute, String value);

	/**
	 * This method will verify if the element (Radio button, Checkbox)  is selected
	 * @param ele   - The Webelement (Radio button, Checkbox) to be verified
	 * @author Sruthi 
	 */
	public void verifySelected(WebElement ele);

	/**
	 * This method will verify if the element is visible in the DOM
	 * @param ele   - The Webelement to be checked
	 * @author Sruthi 
	 */
	public void verifyDisplayed(WebElement ele);

	/**
	 * This method will switch to the Window of interest
	 * @param index The window index to be switched to. 0 -> first window 
	 * @author Sruthi 
	 */
	public void switchToWindow(int index);

	/**
	 * This method will switch to the specific frame by using web element
	 * @param ele   - The Webelement (frame) to be switched
	 * @author Sruthi 
	 */
	public void switchToFrame(WebElement ele);

	/**
	 * This method will switch to the specific frame  by using index
	 * @param index   - The index (frame) to be switched
	 * @author Sruthi 
	 */
	public void switchToFrame(int index);

	/**
	 * This method will switch to the specific frame by using id or name
	 * @param locvalue   - The value of the locators id or name (frame) to be switched
	 * @author Sruthi 
	 */
	public void switchToFrame(String locvalue);

	/**
	 * This method will accept the alert opened
	 * @author Sruthi 
	 */
	public void acceptAlert();

	/**
	 * This method will dismiss the alert opened
	 * @author Sruthi 
	 */
	public void dismissAlert();

	/**
	 * This method will return the text of the alert
	 * @author Sruthi 
	 */
	public String getAlertText();

	/**
	 * This method will take snapshot of the browser
	 * @author Sruthi 
	 */
	public void takeSnap();

	/**
	 * This method will close the active browser
	 * @author Sruthi 
	 */
	public void closeBrowser();		

	/**
	 * This method will close all the browsers
	 * @author Sruthi 
	 */
	public void closeAllBrowsers();

}
