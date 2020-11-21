package utility;
import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.util.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class ExtentDemo {
	
	WebDriver driver;
static ExtentTest test;
static ExtentReports report;
@BeforeClass
public static void startTest()
{
report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
test = report.startTest("ExtentDemo");
}
@Test
public void extentReportsDemo(String status,WebDriver driver) throws IOException
{

if(status.equals("PASS"))
{
test.log(LogStatus.PASS, "Navigated to the specified URL");
}
else
{
test.log(LogStatus.FAIL, "Test Failed");
test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");


}
}


public static String capture(WebDriver driver) throws IOException {
File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()
+ ".png");
String errflpath = Dest.getAbsolutePath();
FileHandler.copy(scrFile, new File("D:/reports/screenshot.png"));


return errflpath;
}


@AfterClass
public static void endTest()
{
report.endTest(test);
report.flush();
}
}