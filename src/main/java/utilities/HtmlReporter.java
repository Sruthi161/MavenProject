package utilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class HtmlReporter {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static String testCaseName, testCaseDescription, author, category, fileNamedesc;

	@BeforeSuite
	public void startResult() {
		//Non-Editable html file
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/result.html");
		//to maintain history of test runs
		html.setAppendExisting(true);
		//to control the chart visibility in the report
		html.config().setChartVisibilityOnOpen(true);
		//Convert to Editable file
		extent = new ExtentReports();
		extent.attachReporter(html);
		extent.setReportUsesManualConfiguration(true);
	}

	@BeforeMethod
	public void startTestCase() {
		//Creating a test case and its description
		test = extent.createTest(testCaseName, testCaseDescription);
		test.assignAuthor(author);
		test.assignCategory(category);
	}

	public void reportStep(String desc, String status) {
		if(status.equalsIgnoreCase("pass")) {
			test.pass(desc);
		}else if(status.equalsIgnoreCase("fail")) {
			test.fail(desc);
		}
	}

	@AfterSuite
	public void stopResult() {
		extent.flush();
	}


}
