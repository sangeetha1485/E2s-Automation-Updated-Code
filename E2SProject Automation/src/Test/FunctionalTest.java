	package Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.Constants;

public class FunctionalTest {

	static ExtentTest test;
	static ExtentReports report;
	public static WebDriver driver = null;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	

	
	@BeforeTest
	public void setExtent()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Sangeetha PC");
		extent.addSystemInfo("User Name", "Sangeetha");
		extent.addSystemInfo("Environment", "QA");
	}
	
	
	@BeforeMethod
	public void setUp(Method method) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.home") + "\\Documents\\selenium\\chromedriver_win32_old\\chromedriver.exe");
		Test test = method.getAnnotation(Test.class);
	    System.out.println("Test name is " +  method.getName());
	    System.out.println("Test description is " + test.description());
	   	
		driver = new ChromeDriver();

		driver.get(Constants.URL);

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='usrnm']")));

		driver.findElement(By.xpath("//input[@name='usrnm']")).sendKeys(Constants.Username);

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Constants.Password);

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		Thread.sleep(10000);
		boolean isdisplayed=driver.findElements(By.xpath("(//div[2]/div/ul/li/a/span/img)[1]")).size() > 0;
		
		if(isdisplayed==true)
		{
			driver.findElement(By.xpath("(//div[2]/div/ul/li/a/span/img)[1]")).click();
		}

	}

	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.home") + "/Documents/Engage2Serve Project Documents/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		//.copyFile(source, finalDestination);
		
		FileHandler.copy(source, finalDestination);
		return destination;
	}

	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getMethod().getDescription()); 

			String screenshotPath = FunctionalTest.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			extentTest.log(LogStatus.SKIP, "TEST CASE FAILED IS "+result.getMethod().getDescription()); 

		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
			extentTest.log(LogStatus.PASS, "TEST CASE FAILED IS "+result.getMethod().getDescription()); 

		}
		
		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report

		driver.quit();
	}

}
