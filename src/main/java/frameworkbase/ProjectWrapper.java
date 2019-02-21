package frameworkbase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class ProjectWrapper extends BaseMethod{
	
	public static String wbookName;
	
	@BeforeMethod
	public void login() {
		startApp("chrome", "https://qa2www1.sisystems.com/");
	}

	@DataProvider(name="fetchData")
	public String[][] readData() {
		return utilities.DataProvider.getSheet(wbookName);
	}
}
