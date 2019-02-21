package frameworkbase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.HtmlReporter;

public class BaseMethod extends HtmlReporter implements BaseMethodInterface {

	public int i = 1;
	public static RemoteWebDriver driver;
	public static ChromeOptions op;
	public static WebDriverWait wait;
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				op = new ChromeOptions();
				op.addArguments("--disable-notifications");
				driver = new ChromeDriver(op);
			} else if (browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if(browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "./drivers/edge.exe");
				driver = new EdgeDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			reportStep("The Browser "+browser+" Launched Successfully", "pass");
			//			System.out.println("The Browser "+browser+" Launched Successfully");
		} catch (WebDriverException e) {
			reportStep("The Browser "+browser+" not Launched", "fail");
			//			System.err.println("The Browser "+browser+" not Launched");
		} finally {
			takeSnap();
		}

	}


	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator) {
			case "id"	 : return driver.findElementById(locValue);
			case "name"	 : return driver.findElementByName(locValue);
			case "class" : return driver.findElementByClassName(locValue);
			case "tagname" : return driver.findElementByTagName(locValue);
			case "xpath" : return driver.findElementByXPath(locValue);
			case "linktext" : return driver.findElementByLinkText(locValue);
			case "partiallink" : return driver.findElementByPartialLinkText(locValue);
			case "css" : return driver.findElementByCssSelector(locValue);
			}
		} catch (NoSuchElementException e) {

		} catch (Exception e) {

		}
		return null;
	}

	public List<WebElement> locateElements(String locator, String locValue) {
		try {
			switch(locator) {
			case "id"	 : return driver.findElementsById(locValue);
			case "class" : return driver.findElementsByClassName(locValue);
			case "xpath" : return driver.findElementsByXPath(locValue);
			case "linktext" : return driver.findElementsByLinkText(locValue);
			case "name" : return driver.findElementsByName(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("The Elements are not found", "fail");
		} catch (Exception e) {
			reportStep("Unknow Exception ", "fail");
		}
		return null;
	}

	public WebElement locateElement(String locValue) {
		try {
			return driver.findElementById(locValue);
		} catch (NoSuchElementException e) {
			reportStep("The Element is not found", "fail");
		} catch (Exception e) {
			reportStep("Unknow Exception ", "fail");
		}
		return null;
	}


	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			reportStep("The data "+data+" is Entered Successfully", "pass");
		} catch (WebDriverException e) {
			reportStep("The data "+data+" is Not Entered", "fail");
		} finally {
			takeSnap();
		}
	}

	public void typewithnosnap(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			reportStep("The data "+data+" is Entered Successfully", "pass");
		} catch (WebDriverException e) {
			reportStep("The data "+data+" is Not Entered", "fail");
		}
	}
	public void clickWithNoSnap(WebElement ele) {
		try {
			ele.click();
			reportStep("The Element "+ele+" Clicked Successfully", "pass");
		} catch (Exception e) {
			reportStep("The Element "+ele+" is not Clicked", "fail");
		}
	}


	@Override
	public void click(WebElement ele) {
		try {
			ele.click();
			reportStep("The Element "+ele+" Clicked Successfully", "pass");
		} catch (WebDriverException e) {
			reportStep("The Element "+ele+" is not Clicked", "fail");
		} finally {
			takeSnap();
		}
	}

	@Override
	public String getText(WebElement ele) {
		try {
			String text = ele.getText();
			return text;
			
			
		} catch (NoSuchElementException e) {
			reportStep("Element" + ele + " not found", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}
		return null;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select dd = new Select(ele);
			dd.selectByVisibleText(value);
			reportStep("The DropDown is Selected with VisibleText: "+value, "pass");
		} catch (Exception e) {
			reportStep("The DropDown is not Selected with VisibleText: "+value, "fail");
		} finally {
			takeSnap();
		}

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select dd = new Select(ele);
			dd.selectByIndex(index);
			reportStep("The DropDown is Selected with index "+ index, "pass");
		} catch (Exception e) {
			reportStep("The DropDown is not Selected with index "+ index, "fail");
		} finally {
			takeSnap();
		}
	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			Select dd = new Select(ele);
			dd.selectByValue(value);
			reportStep("The DropDown is Selected with index "+ value, "pass");
		} catch (Exception e) {
			reportStep("The DropDown is not Selected with index "+ value, "fail");
		} finally {
			takeSnap();
		}

	}



	@Override
	public void verifyTitle(String expectedTitle) {
		String title = driver.getTitle();
		if(title.equals(expectedTitle))
		{
			reportStep("Current Page Title: "+title+" And expected title: "+expectedTitle+" matches exactly", "pass");
		}else {
			reportStep("Current Page Title: "+title+" And expected title: "+expectedTitle+ " doesn't matches", "fail");
		}
	}

	@Override
	public boolean verifyExactText(WebElement ele, String expectedText) {
		try {
			String text = ele.getText();
			boolean check = text.equals(expectedText);
			return check;
		} catch (NoSuchElementException e) {
			reportStep("Element" + ele + " not found", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}
		return false;
	}

	@Override
	public boolean verifyPartialText(WebElement ele, String expectedText) {
		try {
			String text = ele.getText();
			boolean containscheck = expectedText.contains(text);
			return containscheck;
		} catch (NoSuchElementException e) {
			reportStep("Element" + ele + " not found", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}
		return false;
	}

	@Override
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			String attributevalue = ele.getAttribute(attribute);
			boolean equalscheck = attributevalue.equals(value);
			return equalscheck;
		} catch (NoSuchElementException e) {
			reportStep("Element" + ele + " not found", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}
		return false;
	}

	@Override
	public boolean verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			String attributevalue = ele.getAttribute(attribute);
			boolean containscheck = attributevalue.contains(value);
			return containscheck;
		} catch (NoSuchElementException e) {
			reportStep("Element" + ele + " not found", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}
		return false;
	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			boolean selected = ele.isSelected();
			if(selected)
			{
				reportStep("Element " + ele + " is selected", "pass");
			}else {
				reportStep("Element " + ele + " is not selected", "pass");
			}
		} catch (NoSuchElementException e) {
			reportStep("Element not found", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}
	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		try {
			boolean displayed = ele.isDisplayed();
			if(displayed)
			{
				reportStep("Element " + ele + " is displayed", "pass");
			}else {
				reportStep("Element " + ele + " is not displayed", "pass");
			}
		} catch (NoSuchElementException e) {
			reportStep("Element not found", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}
	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> winset = driver.getWindowHandles();
			List<String> winlist = new ArrayList<String>();
			winlist.addAll(winset);
			driver.switchTo().window(winlist.get(index));
		} catch (NoSuchWindowException e) {
			reportStep("Window which you have requested is not found", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}
	}

	@Override
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
		} catch (NoSuchFrameException e) {
			reportStep("Frame not found on the page", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}
	}

	@Override
	public void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			reportStep("Frame not found on the page", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}

	}


	@Override
	public void switchToFrame(String locvalue) {
		try {
			driver.switchTo().frame(locvalue);
		} catch (NoSuchFrameException e) {
			reportStep("Frame not found on the page", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}
	}

	@Override
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			reportStep("Alert not found on the page", "fail");
		} catch(UnhandledAlertException e) {
			reportStep("Alert is not handled properly", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}
	}

	@Override
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportStep("Alert not found on the page", "fail");
		} catch(UnhandledAlertException e) {
			reportStep("Alert is not handled properly", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}
	}

	@Override
	public String getAlertText() {
		try {
			return driver.switchTo().alert().getText();
		} catch (NoAlertPresentException e) {
			reportStep("Alert not found on the page", "fail");
		} catch(Exception e) {
			reportStep("Unknown Exception found", "fail");
		}
		return null;
	}
	
	protected void isPageLoaded() {
		ExpectedCondition<Boolean> pageLoadCondition;

		wait = new WebDriverWait(driver, 30);
		try {
			pageLoadCondition = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver arg0) {
					return ((JavascriptExecutor) driver)
							.executeScript("return document.readyState")
							.toString().equals("complete");
				}
			};
			wait.until(pageLoadCondition);
		} catch (TimeoutException e) {
			// TODO: handle exception
		}
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img"+i+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			reportStep("IOException", "fail");
		}
		i++;
	}

	@Override
	public void closeBrowser() {
		driver.close();
	}

	@Override
	public void closeAllBrowsers() {
		driver.quit();
	}



}
