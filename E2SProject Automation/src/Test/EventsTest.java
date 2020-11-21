package Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pages.AppointmentPage;
import Pages.AppointmentPage.appointmentpagelocators;
import junit.framework.Assert;
import utility.Constants;
import utility.ExcelUtils;
import utility.GenericMEthods;

public class EventsTest extends FunctionalTest {

	GenericMEthods gm = new GenericMEthods();

	@Test(priority = 1, enabled = false, description = "Verify User able to see the Event details when clicking Event name from the list under scheduled section in the Calendar page")
	public void vaidateTC_CF_011() throws Exception {

		extentTest = extent.startTest("vaidateTC_CF_011");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("EventTab"));
		Thread.sleep(5000);
		List<WebElement> scheduledevents = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		if (scheduledevents.size() == 0) {
			createvent();
		}

		else {
			scheduledevents.get(0).click();
		}

		gm.click("Xpath", gm.readproperty_file("EventTab"));
		Thread.sleep(5000);
		Assert.assertTrue("event title is not present",
				driver.getPageSource().contains(gm.getText("Xpath", gm.readproperty_file("getTitle"))));

		Assert.assertTrue("event ShotDescription is not present",
				driver.getPageSource().contains(gm.getText("Xpath", gm.readproperty_file("enterShotDescription"))));

		Assert.assertTrue("event AdditionalInformations is not present", driver.getPageSource()
				.contains(gm.getText("Xpath", gm.readproperty_file("enterAdditionalInformations"))));

		Assert.assertTrue("event Pattern is not present",
				driver.getPageSource().contains(gm.getText("Xpath", gm.readproperty_file("selectPatternEvent"))));
		Assert.assertTrue("event Start Date is not present", driver.getPageSource().contains(
				gm.getText("Xpath", "//*[@id='tab-1']/div/div[9]/div/div/div[2]/div[1]/div[2]/div/div/input")));

		gm.scrollToElement(gm.readproperty_file("selectPatternEvent"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		//
		WebElement button = driver.findElement(By.xpath("//span[@title='Edit Session']/i"));
		//
		js.executeScript("arguments[0].click();", button);
		Thread.sleep(5000);

		// gm.click("Xpath", "//span[@title='Edit Session']/i");
		Thread.sleep(5000);
		Assert.assertTrue("event start time is not present",
				driver.getPageSource().contains(gm.getText("Xpath", gm.readproperty_file("starttimeddl"))));

		Assert.assertTrue("event end time is not present",
				driver.getPageSource().contains(gm.getText("Xpath", gm.readproperty_file("endtimeddl"))));
		Assert.assertTrue("event campus is not present",
				driver.getPageSource().contains(gm.getText("Xpath", gm.readproperty_file("selectcampus"))));
		Assert.assertTrue("event location is not present",
				driver.getPageSource().contains(gm.getText("Xpath", gm.readproperty_file("selectlocation"))));
		Assert.assertTrue("event room is not present",
				driver.getPageSource().contains(gm.getText("Xpath", gm.readproperty_file("selectroom"))));

	}

	@Test(priority = 2, enabled = false, description = "Verify clicking on + icon user is asked with Following option1.Event 2.Appointment")
	public void vaidateTC_CF_015() throws Exception {

		extentTest = extent.startTest("vaidateTC_CF_015");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		gm.click("LinkText", gm.readproperty_file("clickall"));
		gm.click("Xpath", gm.readproperty_file("clickplusicon"));

		Assert.assertTrue("events option is not present",
				driver.getPageSource().contains(gm.getText("Xpath", gm.readproperty_file("eventsoption"))));
		Assert.assertTrue("appointment option is not present",
				driver.getPageSource().contains(gm.getText("Xpath", gm.readproperty_file("appointmentsoption"))));

	}

	@Test(priority = 3, enabled = false, description = "Verify user able to select Event type from drop down")
	public void vaidateTC_CF_017() throws Exception {

		extentTest = extent.startTest("vaidateTC_CF_017");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("EventTab"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickplusicon"));
		Thread.sleep(5000);
		String step1type = gm.getText("Xpath", gm.readproperty_file("getType"));

		Assert.assertFalse("event type is empty", step1type.isEmpty());

	}

	@Test(priority = 4, enabled = false, description = "Verify user able to add new event type")
	public void vaidateTC_CF_018() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_018");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("EventTab"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickplusicon"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("createtypebutton"));

		gm.Wait(gm.readproperty_file("Name"));
		gm.SendKeys("Xpath", gm.readproperty_file("Name"), ExcelUtils.getCellData(1, 16));

		gm.SendKeys("Xpath", gm.readproperty_file("Color"), ExcelUtils.getCellData(1, 17));

		gm.click("Xpath", gm.readproperty_file("Attendees"));

		gm.click("Xpath", gm.readproperty_file("selectsinglepattern"));

		// gm.SendKeys("Xpath", gm.readproperty_file("ThankYouURL"),
		// ExcelUtils.getCellData(1, 0));

		gm.click("Xpath", gm.readproperty_file("clicYes"));

		gm.click("Xpath", gm.readproperty_file("Createbutton"));
		Thread.sleep(5000);
		String step1type = gm.getText("Xpath", gm.readproperty_file("getType"));

		Assert.assertEquals(step1type, ExcelUtils.getCellData(1, 16));

	}

	@Test(priority = 5, enabled = false, description = "Verify only start date is required for the single pattern event")
	public void vaidateTC_CF_029() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_029");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("EventTab"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickplusicon"));
		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("getTitle"), ExcelUtils.getCellData(1, 0));

		gm.SendKeys("Xpath", gm.readproperty_file("enterShotDescription"), ExcelUtils.getCellData(1, 1));

		gm.SendKeys("Xpath", gm.readproperty_file("enterAdditionalInformations"), ExcelUtils.getCellData(1, 2));

		gm.scrollToElement(gm.readproperty_file("selectPatternEvent"));
		Thread.sleep(5000);
		Boolean enddatepresent = driver.findElements(By.xpath(gm.readproperty_file("selectenddate"))).size() > 0;

		Assert.assertFalse("end date field is present", enddatepresent);

	}

	@Test(priority = 6, enabled = false, description = "Verify start & end date is required for the recurring event")
	public void vaidateTC_CF_030() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_030");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("EventTab"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickplusicon"));
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("getType"));
		gm.SendKeys("Xpath", gm.readproperty_file("entertypevalue"), ExcelUtils.getCellData(1, 18));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();

		gm.SendKeys("Xpath", gm.readproperty_file("getTitle"), ExcelUtils.getCellData(1, 0));

		gm.SendKeys("Xpath", gm.readproperty_file("enterShotDescription"), ExcelUtils.getCellData(1, 1));

		gm.SendKeys("Xpath", gm.readproperty_file("enterAdditionalInformations"), ExcelUtils.getCellData(1, 2));

		gm.scrollToElement(gm.readproperty_file("selectPatternEvent"));

		gm.click("Xpath", gm.readproperty_file("selectPatternEvent"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("selectRecurringRegular"));
		Thread.sleep(5000);

		Boolean startdatepresent = driver.findElements(By.xpath(gm.readproperty_file("selectStrtDate"))).size() > 0;

		Assert.assertTrue("start date field is present", startdatepresent);

		Boolean enddatepresent = driver.findElements(By.xpath(gm.readproperty_file("selectenddate"))).size() > 0;

		Assert.assertTrue("end date field is present", enddatepresent);

	}

	@Test(priority = 7, enabled = false, description = "Verify user not able to publish the event without adding session")
	public void vaidateTC_CF_034() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_034");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("EventTab"));

		createvent();

		Boolean errormsg = driver.findElements(By.xpath(gm.readproperty_file("addsessionserrormsg"))).size() > 0;

		Assert.assertTrue("error message for not adding session is not displayed", errormsg);
	}

	@Test(priority = 8, enabled = false, description = "Verify user can edit their event after publish if it is scheduled later.")
	public void vaidateTC_CF_041() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_041");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("EventTab"));
		Thread.sleep(5000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(5000);
		System.out.println("scheduledelements.size" + scheduledelements.size());

		if (scheduledelements.size() == 0) {
			createvent();
		}

		else {
			scheduledelements.get(0).click();
		}
		gm.Wait(gm.readproperty_file("getTitle"));
		driver.findElement(By.xpath(gm.readproperty_file("getTitle"))).clear();
		gm.SendKeys("Xpath", gm.readproperty_file("getTitle"), ExcelUtils.getCellData(1, 20));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clicksavenadcontinue"));
		gm.Wait(gm.readproperty_file("getTitle"));
		Thread.sleep(5000);

		Thread.sleep(5000);
		String updatedtitle = driver.findElement(By.xpath(gm.readproperty_file("getTitle"))).getAttribute("value");

		Thread.sleep(7000);
		System.out.println(updatedtitle);
		Assert.assertEquals(updatedtitle, ExcelUtils.getCellData(1, 20));

	}

	@Test(priority = 9, enabled = false, description = "Verify user can book mark their events by clicking on book mark icon in the event")
	public void vaidateTC_CE_054() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CE_054");
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("Calender"));

		gm.click("Xpath", gm.readproperty_file("MyCalender"));

		gm.Wait(gm.readproperty_file("EventTab"));
		gm.click("Xpath", gm.readproperty_file("EventTab"));

		Thread.sleep(10000);
		// gm.Wait(gm.readproperty_file("bookmarkicon"));
		gm.click("Xpath", gm.readproperty_file("bookmarkicon"));
		Thread.sleep(5000);
		Boolean successmsg = gm.isDisplayed("Xpath", gm.readproperty_file("bookmarksuccessmsg"));

		Assert.assertTrue("success message is not displayed after bookmark", successmsg);

	}

	@Test(priority = 10, enabled = false, description = "Verify the Calendar displays Today's Date")
	public void vaidateTC_CF_009() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_009");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		// Thread.sleep(3000);
		// gm.click("Xpath", gm.readproperty_file("EventTab"));
		Thread.sleep(5000);

		String timeStamp = new SimpleDateFormat("d").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);

		String todaydate = driver.findElement(By.cssSelector(".cal-day-today span[data-cal-date]")).getText();

		System.out.println("today's date" + todaydate);
		Assert.assertEquals(timeStamp, todaydate);
	}

	@Test(priority = 11, enabled = false, description = "Verify filtered status is available for the user")
	public void vaidateTC_CE_053() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CE_053");
		Thread.sleep(5000);

		String username = null;
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(5000);
		System.out.println("scheduledelements.size" + scheduledelements.size());
		int size = scheduledelements.size();
		if (size == 0) {
			createvent();
		}

		else

		{

			scheduledelements.get(size - 1).click();
			Thread.sleep(10000);
			gm.click("LinkText", gm.readproperty_file("clickinviteestab"));

			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("clickinvitedtab"));
			List<WebElement> invitedevents = driver
					.findElements(By.xpath("//*[@id='exportable']/table/tbody/tr/td[3]"));

			System.out.println(invitedevents.size());
			Thread.sleep(5000);
			if (invitedevents.size() == 0) {
				gm.click("LinkText", "Calendar");
				Thread.sleep(5000);
				gm.click("LinkText", "Event");
				Thread.sleep(5000);
				createvent();
				Thread.sleep(10000);
				gm.click("LinkText", gm.readproperty_file("clickinviteestab"));

			}

			Thread.sleep(10000);

			gm.click("LinkText", gm.readproperty_file("clickinviteestab"));
			Thread.sleep(5000);
			gm.click("Xpath", gm.readproperty_file("clickinvitedtab"));
			List<WebElement> invitedevents1 = driver
					.findElements(By.xpath("//*[@id='exportable']/table/tbody/tr/td[3]"));

			System.out.println(invitedevents1.size());
			Thread.sleep(5000);

			username = gm.getText("Xpath", "//*[@id='exportable']/table/tbody/tr[1]/td[3]");
			Thread.sleep(3000);

			Actions actions = new Actions(driver);
			WebElement elementLocator = driver.findElement(By.xpath(gm.readproperty_file("clickaction")));

			actions.click(elementLocator).build().perform();
			Thread.sleep(5000);

			gm.click("LinkText", "Register");

			gm.click("Xpath", gm.readproperty_file("clicktoregisterbutton"));

			Thread.sleep(5000);

		}
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://compass-qa.engage2serve.com/");
		Thread.sleep(20000);
		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/a/span");
		Thread.sleep(3000);

		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/ul/li[2]/a/div");

		Thread.sleep(5000);
		logintostudentportal(username);

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'My Calendar')]")).click();

		gm.Wait(gm.readproperty_file("EventTab"));
		gm.click("Xpath", gm.readproperty_file("EventTab"));

		Thread.sleep(10000);
		gm.click("Xpath", gm.readproperty_file("clickregistered"));

		Thread.sleep(3000);

		Assert.assertTrue("registered events are not displayed",
				driver.getPageSource().contains(ExcelUtils.getCellData(1, 0)));
	}

	@Test(priority = 12, enabled = false, description = "Verify in view event screen , register event is displaying with Accept and reject option")
	public void vaidateTC_CE_057() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CE_057");
		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(5000);
		System.out.println("scheduledelements.size" + scheduledelements.size());
		int size = scheduledelements.size();
		if (size == 0) {
			creatandregisterevent();
		} else {
			scheduledelements.get(0).click();
		}
		Thread.sleep(10000);

		gm.click("LinkText", gm.readproperty_file("clickinviteestab"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickinvitedtab"));

		String username = gm.getText("Xpath", "//*[@id='exportable']/table/tbody/tr[1]/td[3]");
		Thread.sleep(3000);

		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://compass-uat.engage2serve.com/");
		Thread.sleep(20000);
		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/a/span");
		Thread.sleep(3000);

		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/ul/li[2]/a/div");

		Thread.sleep(5000);
		logintostudentportal("ricky@yopmail.com");

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'My Calendar')]")).click();

		gm.Wait(gm.readproperty_file("EventTab"));
		gm.click("Xpath", gm.readproperty_file("EventTab"));

		Thread.sleep(10000);

		List<WebElement> registeredelements = driver
				.findElements(By.xpath("//div[@class='student-portal-event-pod-content-heading ng-binding']"));
		Thread.sleep(5000);
		System.out.println(registeredelements.size());
		if (registeredelements.get(0).getText().contains(ExcelUtils.getCellData(1, 0))) {
			registeredelements.get(0).click();
			Thread.sleep(10000);

			Assert.assertTrue("accept button is not displayed",
					gm.isDisplayed("Xpath", gm.readproperty_file("clickaccept")));
			Assert.assertTrue("decline button is not displayed",
					gm.isDisplayed("Xpath", gm.readproperty_file("clickdecline")));

		}
	}

	@Test(priority = 13, enabled = false, description = "Verify user can search their events in search textbox .")
	public void vaidateTC_CE_051() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CE_051");
		Thread.sleep(5000);

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://compass-qa.engage2serve.com/");
		Thread.sleep(20000);
		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/a/span");
		Thread.sleep(3000);

		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/ul/li[2]/a/div");

		Thread.sleep(5000);
		logintostudentportal();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'My Calendar')]")).click();

		gm.Wait(gm.readproperty_file("EventTab"));
		gm.click("Xpath", gm.readproperty_file("EventTab"));

		Thread.sleep(10000);
		//

		gm.SendKeys("Xpath", gm.readproperty_file("searchevent"), ExcelUtils.getCellData(1, 0));
		driver.findElement(By.xpath(gm.readproperty_file("searchevent"))).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		Assert.assertTrue("event name given in search is not displayed",
				driver.getPageSource().contains(ExcelUtils.getCellData(1, 0)));
	}

	@Test(priority = 14, enabled = false, description = "Verify under Draft section not published Events are displayed by clicking Draft tab in the right top corner, while Event tab appears in the left top corner of Calendar page is clicked")
	public void vaidateTC_CF_013() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_013");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);
		creatdraftevent();
		Thread.sleep(10000);
		gm.click("Xpath", gm.readproperty_file("clickDraftsTab"));
		Thread.sleep(3000);

		List<WebElement> draftselements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));

		for (int i = 0; i < draftselements.size(); i++) {
			Assert.assertTrue("draft event is not present in drafts tab ",
					draftselements.get(i).getText().contains(ExcelUtils.getCellData(1, 0)));
		}

	}

	@Test(priority = 15, enabled = false, description = "Verify logged in user forced to choose the calendar type when creating a new calendar type")
	public void vaidateTC_CF_003() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_003");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToConfigurationPage();
		gm.click("Xpath", gm.readproperty_file("clickfeaturesetup"));

		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickCalendar"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickCalendarType"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("createnewcalendartype"));
		Thread.sleep(5000);
		Assert.assertTrue("appointment type is not present",
				gm.isDisplayed("Xpath", gm.readproperty_file("selectappmnttype")));
		Assert.assertTrue("event type is not present",
				gm.isDisplayed("Xpath", gm.readproperty_file("selecteventtype")));
	}

	@Test(priority = 16, enabled = false, description = "Verify Add type screen displays when calendar type is selected")
	public void vaidateTC_CF_004() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_004");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToConfigurationPage();
		gm.click("Xpath", gm.readproperty_file("clickfeaturesetup"));

		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickCalendar"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickCalendarType"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("createnewcalendartype"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("selectappmnttype"));

		gm.Wait(gm.readproperty_file("addtypepage"));
		Assert.assertTrue("event type is not present", gm.isDisplayed("Xpath", gm.readproperty_file("addtypepage")));

	}

	@Test(priority = 17, enabled = false, description = "Verify event created is only for single event if event pattern is selected as single in event type creation page")
	public void vaidateTC_CF_022() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_022");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("EventTab"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickplusicon"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("createtypebutton"));

		gm.Wait(gm.readproperty_file("Name"));
		gm.SendKeys("Xpath", gm.readproperty_file("Name"), ExcelUtils.getCellData(1, 16));

		gm.SendKeys("Xpath", gm.readproperty_file("Color"), ExcelUtils.getCellData(1, 17));

		gm.click("Xpath", gm.readproperty_file("Attendees"));

		gm.click("Xpath", gm.readproperty_file("selectsinglepattern"));
		Thread.sleep(3000);
		// gm.SendKeys("Xpath", gm.readproperty_file("ThankYouURL"),
		// ExcelUtils.getCellData(1, 0));

		gm.click("Xpath", gm.readproperty_file("clicYes"));

		gm.click("Xpath", gm.readproperty_file("Createbutton"));
		Thread.sleep(5000);
		String step1type = gm.getText("Xpath", gm.readproperty_file("getType"));

		Assert.assertEquals(step1type, ExcelUtils.getCellData(1, 16));
		Thread.sleep(3000);
		gm.scrollToElement(gm.readproperty_file("selectPatternEvent"));
		gm.click("Xpath", gm.readproperty_file("selectPatternEvent"));
		Thread.sleep(5000);
		Assert.assertTrue("single pattern type is not present",
				gm.isDisplayed("Xpath", "//div[contains(text(),'Single')]"));
		// Assert.assertFalse("recurring regular pattern type is present",
		// gm.isDisplayed("Xpath", "//div[contains(text(),'Recurring - Regular')]"));
		// Assert.assertFalse("recurring custom type is present",
		// gm.isDisplayed("Xpath", "//div[contains(text(),'Recurring - Custom')]"));

	}

	@Test(priority = 18, enabled = false, description = "Verify event can created only as Recurring event if event pattern is selected as Recurring - Regular in event type creation page")
	public void vaidateTC_CF_023() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_023");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("EventTab"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickplusicon"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("createtypebutton"));

		gm.Wait(gm.readproperty_file("Name"));
		gm.SendKeys("Xpath", gm.readproperty_file("Name"), ExcelUtils.getCellData(1, 16));

		gm.SendKeys("Xpath", gm.readproperty_file("Color"), ExcelUtils.getCellData(1, 17));

		gm.click("Xpath", gm.readproperty_file("Attendees"));

		gm.click("Xpath", gm.readproperty_file("selectrecurringrular"));
		Thread.sleep(3000);
		// gm.SendKeys("Xpath", gm.readproperty_file("ThankYouURL"),
		// ExcelUtils.getCellData(1, 0));

		gm.click("Xpath", gm.readproperty_file("clicYes"));

		gm.click("Xpath", gm.readproperty_file("Createbutton"));
		Thread.sleep(5000);
		String step1type = gm.getText("Xpath", gm.readproperty_file("getType"));

		Assert.assertEquals(step1type, ExcelUtils.getCellData(1, 16));
		Thread.sleep(3000);
		gm.scrollToElement(gm.readproperty_file("selectPatternEvent"));
		gm.click("Xpath", gm.readproperty_file("selectPatternEvent"));
		Thread.sleep(5000);
		Assert.assertTrue("single pattern type is not present",
				gm.isDisplayed("Xpath", "//div[contains(text(),'Recurring - Regular')]"));

	}

	@Test(priority = 19, enabled = false, description = "Verify user not able to create event with same session start & end time for the same event type")
	public void vaidateTC_CF_035() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_035");
		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("EventTab"));

		gm.click("Xpath", gm.readproperty_file("clickplusicon"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("getType"));
		gm.SendKeys("Xpath", gm.readproperty_file("entertypevalue"), ExcelUtils.getCellData(1, 18));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("getTitle"), ExcelUtils.getCellData(1, 0));

		gm.SendKeys("Xpath", gm.readproperty_file("enterShotDescription"), ExcelUtils.getCellData(1, 1));

		gm.SendKeys("Xpath", gm.readproperty_file("enterAdditionalInformations"), ExcelUtils.getCellData(1, 2));

		gm.click("Xpath", gm.readproperty_file("selectPatternEvent"));

		if (ExcelUtils.getCellData(1, 3).contains("Single")) {
			gm.click("Xpath", gm.readproperty_file("selectSingle"));

			gm.click("Xpath", gm.readproperty_file("selectStrtDate"));

			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 4));
			Thread.sleep(5000);
		}

		gm.click("Xpath", gm.readproperty_file("selectregistration"));
		gm.click("Xpath", gm.readproperty_file("clicknextbutton"));
		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("starttimeddl"), ExcelUtils.getCellData(1, 6));

		gm.SendKeys("Xpath", gm.readproperty_file("starttimeminutesddl"), ExcelUtils.getCellData(1, 7));
		Thread.sleep(5000);

		driver.findElement(By.xpath(gm.readproperty_file("endtimeddl"))).clear();

		gm.SendKeys("Xpath", gm.readproperty_file("endtimeddl"), ExcelUtils.getCellData(1, 8));
		Thread.sleep(5000);
		driver.findElement(By.xpath(gm.readproperty_file("endtimeminutesddl"))).clear();
		gm.SendKeys("Xpath", gm.readproperty_file("endtimeminutesddl"), ExcelUtils.getCellData(1, 9));
		Thread.sleep(5000);

		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		//
		WebElement button5 = driver.findElement(By.xpath(gm.readproperty_file("selectcampus")));
		//
		js5.executeScript("arguments[0].click();", button5);

		// gm.click("Xpath", gm.readproperty_file("selectcampus"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercampusname"), ExcelUtils.getCellData(1, 10));
		driver.findElement(By.xpath(gm.readproperty_file("entercampusname"))).sendKeys(Keys.ENTER);

		gm.click("Xpath", gm.readproperty_file("selectlocation"));

		// gm.SendKeys("Xpath", gm.readproperty_file("enterlocation"),
		// ExcelUtils.getCellData(1, 11));
		Thread.sleep(7000);
		// driver.findElement(By.xpath(gm.readproperty_file("enterlocation"))).sendKeys(Keys.ENTER);

		gm.click("Xpath", "//div[contains(text(),'" + ExcelUtils.getCellData(1, 11) + "')]");

		Thread.sleep(5000);

		String roomvalue = ExcelUtils.getCellData(1, 12);
		System.out.println(ExcelUtils.getCellData(1, 12));
		gm.click("Xpath", gm.readproperty_file("selectroom"));
		Thread.sleep(7000);
		// gm.click("Xpath", "//div[contains(text(),'"+ExcelUtils.getCellData(1,
		// 12)+"')]");
		// Thread.sleep(5000);
		Actions action11 = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'" + roomvalue + "')]"));

		action11.moveToElement(element).click().build().perform();
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("specificrecepients-events"));
		Thread.sleep(3000);
		gm.click("LinkText", "Recipients");
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("allstudents"));

		gm.click("Xpath", gm.readproperty_file("clickinvite"));
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		//
		WebElement button = driver.findElement(By.xpath(gm.readproperty_file("clickaddsession")));
		//
		js.executeScript("arguments[0].click();", button);
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("clickpublish"));
		Thread.sleep(10000);
		Boolean errormsg = gm.isDisplayed("Xpath",
				"//div[contains(text(),'Selected Room is already occupied by another session')]");
		Assert.assertTrue("error message is not displayed for entering exisiting session time", errormsg);

	}

	@Test(priority = 20, enabled = false, description = "Verify user can able to select End Date/time less than event start date/time.")
	public void vaidateTC_CF_078() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_078");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("EventTab"));

		gm.click("Xpath", gm.readproperty_file("clickplusicon"));
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("getType"));
		gm.SendKeys("Xpath", gm.readproperty_file("entertypevalue"), ExcelUtils.getCellData(1, 18));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("getTitle"), ExcelUtils.getCellData(1, 0));

		gm.SendKeys("Xpath", gm.readproperty_file("enterShotDescription"), ExcelUtils.getCellData(1, 1));

		gm.SendKeys("Xpath", gm.readproperty_file("enterAdditionalInformations"), ExcelUtils.getCellData(1, 2));

		gm.click("Xpath", gm.readproperty_file("selectPatternEvent"));

		if (ExcelUtils.getCellData(1, 3).contains("Single")) {
			gm.click("Xpath", gm.readproperty_file("selectSingle"));

			gm.click("Xpath", gm.readproperty_file("selectStrtDate"));

			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 4));
			Thread.sleep(5000);
		}

		gm.click("Xpath", gm.readproperty_file("selectregistration"));
		gm.click("Xpath", gm.readproperty_file("clicknextbutton"));
		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("starttimeddl"), ExcelUtils.getCellData(1, 6));

		gm.SendKeys("Xpath", gm.readproperty_file("starttimeminutesddl"), ExcelUtils.getCellData(1, 7));
		Thread.sleep(5000);

		driver.findElement(By.xpath(gm.readproperty_file("endtimeddl"))).clear();

		gm.SendKeys("Xpath", gm.readproperty_file("endtimeddl"), ExcelUtils.getCellData(1, 8));
		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("endtimeminutesddl"), ExcelUtils.getCellData(1, 9));
		Thread.sleep(5000);

		Boolean errormsg = driver
				.findElements(By.xpath("//div[contains(text(),'Please select hour greater than start time')]"))
				.size() > 0;

		Assert.assertTrue("error message is not displayed for entering end time less than start time", errormsg);

	}

	@Test(priority = 21, enabled = false, description = "Verify student accepted event is displaying in staff portal registered tab")
	public void vaidateTC_CE_058() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CE_058");

		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(5000);
		System.out.println("scheduledelements.size" + scheduledelements.size());
		int size = scheduledelements.size();
		// if (size == 0) {
		createvent();
		// }
		// else
		// {
		// scheduledelements.get(0).click();
		// }
		Thread.sleep(10000);

		gm.click("LinkText", gm.readproperty_file("clickinviteestab"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickinvitedtab"));

		String username = gm.getText("Xpath", "//*[@id='exportable']/table/tbody/tr[1]/td[3]");
		Thread.sleep(5000);

		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://compass-uat.engage2serve.com/");
		Thread.sleep(20000);
		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/a/span");
		Thread.sleep(3000);

		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/ul/li[2]/a/div");

		Thread.sleep(5000);
		logintostudentportal(username);

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'My Calendar')]")).click();

		gm.Wait(gm.readproperty_file("EventTab"));
		gm.click("Xpath", gm.readproperty_file("EventTab"));

		Thread.sleep(10000);

		List<WebElement> registeredelements = driver
				.findElements(By.xpath("//div[@class='student-portal-event-pod-content-heading ng-binding']"));
		Thread.sleep(5000);
		System.out.println(registeredelements.size());
		if (registeredelements.get(0).getText().contains(ExcelUtils.getCellData(1, 0))) {
			registeredelements.get(0).click();
			Thread.sleep(10000);

			gm.click("Xpath", gm.readproperty_file("clickaccept"));

		}

		driver.switchTo().window(tabs.get(0));
		gm.click("Xpath", gm.readproperty_file("clickregisteredtab"));
		Thread.sleep(10000);
		String regname = gm.getText("cssSelector", gm.readproperty_file("firstregstudent"));

		System.out.println(regname);
		Assert.assertEquals(username, regname);
	}

	@Test(priority = 22, enabled = false, description = "Verify Book marked event is displaying when user filtered book marked")
	public void vaidateTC_CE_055() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CE_055");

		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("Calender"));

		gm.click("Xpath", gm.readproperty_file("MyCalender"));

		gm.Wait(gm.readproperty_file("EventTab1"));
		gm.click("Xpath", gm.readproperty_file("EventTab1"));

		Thread.sleep(10000);
		// gm.Wait(gm.readproperty_file("bookmarkicon"));
		gm.click("Xpath", gm.readproperty_file("bookmarkicon"));
		Thread.sleep(10000);

		// clickbookmarkfilter

		gm.click("Xpath", gm.readproperty_file("clickbookmarkfilter"));
		Thread.sleep(5000);
		Assert.assertTrue("bookmarked event is not displayed",
				driver.getPageSource().contains(ExcelUtils.getCellData(1, 0)));

	}

	@Test(priority = 23, enabled = false, description = "Verify under Cancelled section not published Events are displayed by clicking Draft tab in the right top corner, while Event tab appears in the left top corner of Calendar page is clicked")
	public void vaidateTC_CF_014() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_014");
		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);
		createvent();
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("cancelevent"));
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		//
		WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("clickconfirmtocancelevent")));
		//
		js4.executeScript("arguments[0].click();", button4);
		Thread.sleep(20000);

		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		//
		WebElement button5 = driver.findElement(By.xpath(gm.readproperty_file("Cancelled")));
		//
		js5.executeScript("arguments[0].click();", button5);

		// gm.click("Xpath", gm.readproperty_file("Cancelled"));
		Thread.sleep(5000);
		List<WebElement> cancelledevents = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		System.out.println(cancelledevents.size());
		int length = cancelledevents.size();

		Assert.assertTrue("cancelled event is not displayed in cancelled tab",
				cancelledevents.get(length - 1).getText().contains(ExcelUtils.getCellData(1, 0)));

	}

	@Test(priority = 24, enabled = false, description = "Verify user can able to add tag to that event")
	public void vaidateTC_CF_024() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_033");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);
		createvent();
		Thread.sleep(5000);

		String gettag = gm.getText("cssSelector", "span[ng-bind='$getDisplayText()']");
		System.out.println(gettag);
		Assert.assertTrue("added tag is not displayed", gettag.contains(ExcelUtils.getCellData(1, 24)));

	}

	@Test(priority = 25, enabled = false, description = "Verify user able to customize recurring start & end date for the event with recurring custom")
	public void vaidateTC_CF_033() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_033");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickplusicon"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("getType"));
		gm.SendKeys("Xpath", gm.readproperty_file("entertypevalue"), ExcelUtils.getCellData(1, 18));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("getTitle"), ExcelUtils.getCellData(1, 0));
		Thread.sleep(3000);
		gm.SendKeys("Xpath", gm.readproperty_file("addtag"), ExcelUtils.getCellData(1, 24));
		driver.findElement(By.xpath(gm.readproperty_file("addtag"))).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("enterShotDescription"), ExcelUtils.getCellData(1, 1));

		gm.SendKeys("Xpath", gm.readproperty_file("enterAdditionalInformations"), ExcelUtils.getCellData(1, 2));

		gm.click("Xpath", gm.readproperty_file("selectPatternEvent"));

		if (ExcelUtils.getCellData(1, 3).contains("Recurring - Custom")) {
			gm.click("Xpath", gm.readproperty_file("selectCustom"));

			gm.click("Xpath", gm.readproperty_file("selectStrtDate"));

			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 4));
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("selectEndDate"));

			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 25));
			Thread.sleep(5000);
		}

		gm.click("Xpath", gm.readproperty_file("clicknextbutton"));
		Thread.sleep(5000);
		Assert.assertTrue("start date is present", driver.getPageSource()
				.contains(gm.getText("Xpath", "//strong[contains(text(),'Start Date:')]//following::span")));
		Assert.assertTrue("end date is present", driver.getPageSource()
				.contains(gm.getText("Xpath", "//strong[contains(text(),'End Date:')]//following::span")));

	}

	@Test(priority = 26, enabled = false, description = "Verify feedback icon is displayed in the event session, if feedback is created for that event.")
	public void vaidateTC_EP_088() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_EP_088");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);

		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(3000);
		System.out.println(scheduledelements.size());

		createvent();

		gm.click("LinkText", "Feedback");
		Thread.sleep(5000);
		// gm.click("Xpath", gm.readproperty_file("enablefeedback"));
		// Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("selectfeedbackcategory"));
		gm.SendKeys("Xpath", gm.readproperty_file("entercategoryname"), ExcelUtils.getCellData(1, 26));

		driver.findElement(By.xpath(gm.readproperty_file("entercategoryname"))).sendKeys(Keys.ENTER);

		gm.SendKeys("Xpath", gm.readproperty_file("enterquestion"), ExcelUtils.getCellData(1, 27));

		gm.click("Xpath", gm.readproperty_file("clicknext-fb"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("selectgoodtoworsttemplate"));
		gm.click("Xpath", gm.readproperty_file("startdatefb"));

		Thread.sleep(5000);
		gm.selectDate(ExcelUtils.getCellData(1, 4));
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("endadatefb"));

		Thread.sleep(5000);
		gm.selectDate(ExcelUtils.getCellData(1, 25));
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("clickcreatefb"));
		Thread.sleep(3000);
		// gm.click("Xpath",
		// gm.readproperty_file("//*[@id='tab-1']/div/div[17]/div[2]/span/button[2]/span[1]"));

		Assert.assertTrue("feedback poll is not created successfully",
				gm.isDisplayed("Xpath", gm.readproperty_file("fbquestion")));

	}

	@Test(priority = 27, enabled = false, description = "Verify Upcoming All Events and Appointments created, is displayed in Calendar page by default")
	public void vaidateTC_CF_010() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_010");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);

		Thread.sleep(10000);

		// display date having events
		List<WebElement> availslots = driver.findElements(By.xpath("//div[@class='cal-cell1 cal-cell  pointer']"));
		Thread.sleep(5000);

		Iterator<WebElement> itr = availslots.iterator();
		for (int i = 0; i < availslots.size(); i++) {

			availslots.get(i).click();
			Thread.sleep(5000);

			Boolean date2p = driver.findElements(By.xpath("//table/tbody/tr/td[2]/div[2]/div/div/span/span"))
					.size() > 0;

			if (date2p == true) {
				String date2 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[2]/div/div/span/span"))
						.getText();
				// System.out.println(date2);

				java.util.Date textFieldAsDate = null;
				java.util.Date textFieldAsDate2 = null;

				textFieldAsDate = sdf.parse(date2);
				textFieldAsDate2 = sdf.parse(formattedDate);

				if ((textFieldAsDate.after(textFieldAsDate2) && (!(textFieldAsDate.equals(""))))) {

					System.out.println("available slots" + date2);
					System.out.println("the upcoming available events are displayed");
					break;
				}
			}

		}

	}

	@Test(priority = 28, enabled = false, description = "Verify enabling the question user is navigated to create feedback slide window .")
	public void vaidateTC_EP_063() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_EP_063");

		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("EventTab"));
		Thread.sleep(5000);
		List<WebElement> scheduledevents = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		if (scheduledevents.size() == 0) {
			createvent();
		}

		else {
			scheduledevents.get(0).click();
		}

		gm.click("Xpath", gm.readproperty_file("EventTab"));
		Thread.sleep(5000);
		gm.click("LinkText", "Feedback");
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("cancelfb"));
		Thread.sleep(5000);
		// enablefeedback
		gm.click("Xpath", gm.readproperty_file("enablefeedback"));

		String text = gm.getText("Xpath", gm.readproperty_file("feedbackpopuptitle"));
		Thread.sleep(3000);
		Assert.assertEquals(text, "Create Feedback");

	}

	@Test(priority = 29, enabled = false, description = "Verify user can edit their event after publish if it is Ongoing event")
	public void vaidateTC_CF_042() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_042");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);

		Thread.sleep(5000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(5000);
		System.out.println("scheduledelements.size" + scheduledelements.size());

		for (int i = 0; i < scheduledelements.size(); i++) {
			if (scheduledelements.get(i).getText().contains("Academics discussion")) {
				scheduledelements.get(i).click();
				gm.click("Xpath", gm.readproperty_file("EventTab"));
				Thread.sleep(5000);

				gm.SendKeys("Xpath", gm.readproperty_file("getTitle"), "Academics discussion1");

				Assert.assertTrue("event title is not present",
						driver.getPageSource().contains("Academics discussion1"));
			}

		}

	}

	@Test(priority = 30, enabled = false, description = "Verify user disable the toggle button in Do you wish to collect feedback for this event? question .")
	public void vaidateTC_EP_087() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_EP_087");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("EventTab"));
		Thread.sleep(5000);
		List<WebElement> scheduledevents = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		if (scheduledevents.size() == 0) {
			createvent();
		}

		else {
			scheduledevents.get(0).click();
		}

		gm.click("Xpath", gm.readproperty_file("EventTab"));
		Thread.sleep(5000);
		gm.click("LinkText", "Feedback");
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("cancelfb"));
		Thread.sleep(5000);
		// enablefeedback
		gm.click("Xpath", gm.readproperty_file("enablefeedback"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("cancelfb"));
		Thread.sleep(5000);
		// disable feedback
		gm.click("Xpath", gm.readproperty_file("enablefeedback"));

		String color = driver.findElement(By.xpath(gm.readproperty_file("enablefeedback"))).getCssValue("border-color");

		Assert.assertEquals(color, "rgb(223, 223, 223)");
		System.out.println(color);
	}

	@Test(priority = 31, enabled = false, description = "Verify user is displayed with 12 templates to create feedback.")
	public void vaidateTC_EP_070() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_EP_070");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);

		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(3000);
		System.out.println(scheduledelements.size());

		List<WebElement> eventdates = driver.findElements(By.xpath("//div[@class='drop-in-event-list-date']"));
		Thread.sleep(5000);

		System.out.println(eventdates.size());
		String timeStamp = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		String text = null;

		if (scheduledelements.size() != 0) {
			// (int i = 0; i < scheduledelements.size(); i++) {

			// if (!(eventdates.get(i).getText().contains(timeStamp))) {
			// System.out.println("inside if loop");
			scheduledelements.get(0).click();
			System.out.println(scheduledelements.get(0).getText());
			Thread.sleep(7000);
			gm.click("LinkText", "Feedback");

			// gm.click("Xpath", gm.readproperty_file("enablefeedback"));
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("selectfeedbackcategory"));
			gm.SendKeys("Xpath", gm.readproperty_file("entercategoryname"), ExcelUtils.getCellData(1, 26));

			driver.findElement(By.xpath(gm.readproperty_file("entercategoryname"))).sendKeys(Keys.ENTER);

			gm.SendKeys("Xpath", gm.readproperty_file("enterquestion"), ExcelUtils.getCellData(1, 27));

			gm.click("Xpath", gm.readproperty_file("clicknext-fb"));
			Thread.sleep(5000);

			Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("starstemplate")));
			Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("emojitemplate")));
			Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("satisfactiontemplate")));
			Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("selectgoodtoworsttemplate")));
			Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("yesornotemplate")));
			Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("familiaritytemplate")));
			Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("agreeordisagreetemplate")));
			Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("interesttemplate")));
			Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("easytodifficulttemlate")));
			Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("frequencytemplate")));
			Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("trueorfalsetemplate")));
			Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("daysofweektemplate")));

		}

	}

	@Test(priority = 32, enabled = false, description = "Verify user can able to select the template .")
	public void vaidateTC_EP_071() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_EP_071");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);

		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(3000);
		System.out.println(scheduledelements.size());

		List<WebElement> eventdates = driver.findElements(By.xpath("//div[@class='drop-in-event-list-date']"));
		Thread.sleep(5000);

		System.out.println(eventdates.size());
		String timeStamp = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		String text = null;

		if (scheduledelements.size() != 0) {
			// (int i = 0; i < scheduledelements.size(); i++) {

			// if (!(eventdates.get(i).getText().contains(timeStamp))) {
			// System.out.println("inside if loop");
			scheduledelements.get(0).click();
			System.out.println(scheduledelements.get(0).getText());
			Thread.sleep(7000);
			gm.click("LinkText", "Feedback");

			// gm.click("Xpath", gm.readproperty_file("enablefeedback"));
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("selectfeedbackcategory"));
			gm.SendKeys("Xpath", gm.readproperty_file("entercategoryname"), ExcelUtils.getCellData(1, 26));

			driver.findElement(By.xpath(gm.readproperty_file("entercategoryname"))).sendKeys(Keys.ENTER);

			gm.SendKeys("Xpath", gm.readproperty_file("enterquestion"), ExcelUtils.getCellData(1, 27));

			gm.click("Xpath", gm.readproperty_file("clicknext-fb"));
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("starstemplate"));
			Thread.sleep(3000);
			Assert.assertTrue(
					gm.isDisplayed("Xpath", " //div[@class='poll-choose-custom-template-pod ng-scope selected']"));

		}

	}

	@Test(priority = 33, enabled = false, description = "Verify user cant be able to select more than one template.")
	public void vaidateTC_EP_072() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_EP_072");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);

		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(3000);
		System.out.println(scheduledelements.size());

		List<WebElement> eventdates = driver.findElements(By.xpath("//div[@class='drop-in-event-list-date']"));
		Thread.sleep(5000);

		System.out.println(eventdates.size());
		String timeStamp = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		String text = null;

		if (scheduledelements.size() != 0) {
			// (int i = 0; i < scheduledelements.size(); i++) {

			// if (!(eventdates.get(i).getText().contains(timeStamp))) {
			// System.out.println("inside if loop");
			scheduledelements.get(0).click();
			System.out.println(scheduledelements.get(0).getText());
			Thread.sleep(7000);
			gm.click("LinkText", "Feedback");

			// gm.click("Xpath", gm.readproperty_file("enablefeedback"));
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("selectfeedbackcategory"));
			gm.SendKeys("Xpath", gm.readproperty_file("entercategoryname"), ExcelUtils.getCellData(1, 26));

			driver.findElement(By.xpath(gm.readproperty_file("entercategoryname"))).sendKeys(Keys.ENTER);

			gm.SendKeys("Xpath", gm.readproperty_file("enterquestion"), ExcelUtils.getCellData(1, 27));

			gm.click("Xpath", gm.readproperty_file("clicknext-fb"));
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("starstemplate"));

			JavascriptExecutor js5 = (JavascriptExecutor) driver;
			//
			WebElement button5 = driver
					.findElement(By.xpath("(//div[@class='poll-choose-custom-template-pod ng-scope'])[1]"));
			//
			js5.executeScript("arguments[0].click();", button5);
			Thread.sleep(5000);

			// gm.click("Xpath", gm.readproperty_file("emojitemplate"));
			gm.click("Xpath", gm.readproperty_file("clickconfirmtochangetemplate"));

			Thread.sleep(5000);

			List<WebElement> templateschosen = driver
					.findElements(By.xpath("//div[@class='poll-choose-custom-template-pod ng-scope selected']"));

			System.out.println(templateschosen.size());
			Assert.assertTrue("more than one template is chosen", templateschosen.size() == 1);
			Thread.sleep(3000);

		}

	}

	@Test(priority = 34, enabled = false, description = "Verify selected template option are displayed down further actions")
	public void vaidateTC_EP_073() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_EP_073");
		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);

		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(3000);
		System.out.println(scheduledelements.size());

		List<WebElement> eventdates = driver.findElements(By.xpath("//div[@class='drop-in-event-list-date']"));
		Thread.sleep(5000);

		System.out.println(eventdates.size());
		String timeStamp = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		String text = null;

		if (scheduledelements.size() != 0) {
			// (int i = 0; i < scheduledelements.size(); i++) {

			// if (!(eventdates.get(i).getText().contains(timeStamp))) {
			// System.out.println("inside if loop");
			scheduledelements.get(0).click();
			System.out.println(scheduledelements.get(0).getText());
			Thread.sleep(7000);
			gm.click("LinkText", "Feedback");

			// gm.click("Xpath", gm.readproperty_file("enablefeedback"));
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("selectfeedbackcategory"));
			gm.SendKeys("Xpath", gm.readproperty_file("entercategoryname"), ExcelUtils.getCellData(1, 26));

			driver.findElement(By.xpath(gm.readproperty_file("entercategoryname"))).sendKeys(Keys.ENTER);

			gm.SendKeys("Xpath", gm.readproperty_file("enterquestion"), ExcelUtils.getCellData(1, 27));

			gm.click("Xpath", gm.readproperty_file("clicknext-fb"));
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("starstemplate"));
			Thread.sleep(5000);

			Assert.assertTrue("response 1 is not displayed",
					gm.isDisplayed("Xpath", gm.readproperty_file("response1")));
			Assert.assertTrue("response 2 is not displayed",
					gm.isDisplayed("Xpath", gm.readproperty_file("response2")));
			Assert.assertTrue("response 3 is not displayed",
					gm.isDisplayed("Xpath", gm.readproperty_file("response3")));
			Assert.assertTrue("response 4 is not displayed",
					gm.isDisplayed("Xpath", gm.readproperty_file("response4")));
			Assert.assertTrue("response 5 is not displayed",
					gm.isDisplayed("Xpath", gm.readproperty_file("response5")));

		}

	}

	@Test(priority = 35, enabled = false, description = "Verify clicking on custom response radio button user navigate to custom response screen.")
	public void vaidateTC_EP_074() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_EP_074");
		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);

		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(3000);
		System.out.println(scheduledelements.size());

		List<WebElement> eventdates = driver.findElements(By.xpath("//div[@class='drop-in-event-list-date']"));
		Thread.sleep(5000);

		System.out.println(eventdates.size());
		String timeStamp = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		String text = null;

		if (scheduledelements.size() != 0) {
			// (int i = 0; i < scheduledelements.size(); i++) {

			// if (!(eventdates.get(i).getText().contains(timeStamp))) {
			// System.out.println("inside if loop");
			scheduledelements.get(0).click();
			System.out.println(scheduledelements.get(0).getText());
			Thread.sleep(7000);
			gm.click("LinkText", "Feedback");

			// gm.click("Xpath", gm.readproperty_file("enablefeedback"));
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("selectfeedbackcategory"));
			gm.SendKeys("Xpath", gm.readproperty_file("entercategoryname"), ExcelUtils.getCellData(1, 26));

			driver.findElement(By.xpath(gm.readproperty_file("entercategoryname"))).sendKeys(Keys.ENTER);

			gm.SendKeys("Xpath", gm.readproperty_file("enterquestion"), ExcelUtils.getCellData(1, 27));

			gm.click("Xpath", gm.readproperty_file("clicknext-fb"));
			Thread.sleep(5000);
			gm.click("Xpath", gm.readproperty_file("clickcustomresponse"));
			Thread.sleep(3000);

			Assert.assertTrue("custom response page is not displayed ",
					gm.isDisplayed("Xpath", gm.readproperty_file("typeresponselabel")));
		}

	}

	@Test(priority = 36, enabled = false, description = "Verify user can able to create custom response feedback .")
	public void vaidateTC_EP_075() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_EP_075");
		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);

		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(3000);
		System.out.println(scheduledelements.size());

		List<WebElement> eventdates = driver.findElements(By.xpath("//div[@class='drop-in-event-list-date']"));
		Thread.sleep(5000);

		System.out.println(eventdates.size());
		String timeStamp = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		String text = null;

		if (scheduledelements.size() != 0) {
			// (int i = 0; i < scheduledelements.size(); i++) {

			// if (!(eventdates.get(i).getText().contains(timeStamp))) {
			// System.out.println("inside if loop");
			scheduledelements.get(0).click();
			System.out.println(scheduledelements.get(0).getText());
			Thread.sleep(7000);
			gm.click("LinkText", "Feedback");

			// gm.click("Xpath", gm.readproperty_file("enablefeedback"));
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("selectfeedbackcategory"));
			gm.SendKeys("Xpath", gm.readproperty_file("entercategoryname"), ExcelUtils.getCellData(1, 26));

			driver.findElement(By.xpath(gm.readproperty_file("entercategoryname"))).sendKeys(Keys.ENTER);

			gm.SendKeys("Xpath", gm.readproperty_file("enterquestion"), ExcelUtils.getCellData(1, 27));

			gm.click("Xpath", gm.readproperty_file("clicknext-fb"));
			Thread.sleep(5000);
			gm.click("Xpath", gm.readproperty_file("clickcustomresponse"));
			Thread.sleep(3000);

			gm.SendKeys("Xpath", gm.readproperty_file("typecusstomresponse"), "Response 1");
			gm.click("Xpath", gm.readproperty_file("selectrisklevel"));

			gm.click("Xpath", gm.readproperty_file("selectpositivevalue"));
			gm.click("LinkText", "Add");
			Thread.sleep(3000);

			Assert.assertEquals(gm.getText("Xpath", gm.readproperty_file("addedcustomresponse")), "Response 1");

		}

	}

	@Test(priority = 37, enabled = false, description = "Verify event is created in all the dates between the selected days within the end date when user create recurring event")
	public void vaidateTC_EP_032() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_EP_032");
		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(3000);
		System.out.println(scheduledelements.size());

		if (scheduledelements.size() == 0) {

			createvent();
			gm.click("LinkText", "Calendar ");

			Thread.sleep(3000);
			gm.click("LinkText", "Event");
			Thread.sleep(5000);

			if (scheduledelements.get(0).getText().contains(ExcelUtils.getCellData(1, 0))) {
				String date = gm.getText("Xpath", "//table/tbody/tr/td[2]/div[2]/div/div/span/span");

				Assert.assertTrue("event is not created for given dates", date.contains(ExcelUtils.getCellData(1, 4)));
				Assert.assertTrue("event is not created for given dates", date.contains(ExcelUtils.getCellData(1, 25)));
			}
		}

		else if ((scheduledelements.size() != 0)) {

			for (int i = 1; i < scheduledelements.size(); i++) {
				// .out.println(scheduledelements.get(i-1).getText());
				// System.out.println(ExcelUtils.getCellData(1, 0));
				String text1 = ExcelUtils.getCellData(1, 0);
				String[] text = scheduledelements.get(i - 1).getText().split(":");

				System.out.println(text[1]);

				if (text[1].contains("sports meet")) {
					String date = gm.getText("Xpath",
							"(//table/tbody/tr/td[2]/div[2]/div/div/span/span)" + "[" + i + "]");
					System.out.println("inside if loop");
					System.out.println(date);
					Assert.assertTrue("event is not created for given dates",
							date.contains(ExcelUtils.getCellData(1, 4)));
					Assert.assertTrue("event is not created for given dates",
							date.contains(ExcelUtils.getCellData(1, 25)));
					break;
				}
			}
		}
	}

	@Test(priority = 39, enabled = false, description = "Verify feedback icon is displayed in the event session, if feedback is not created for that event.")
	public void vaidateTC_EP_089() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_EP_088");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);

		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(3000);
		System.out.println(scheduledelements.size());

		createvent();

		Assert.assertFalse("feedback poll is not created successfully",
				gm.isDisplayed("Xpath", gm.readproperty_file("fbquestion")));

	}

	
	@Test(priority = 40, enabled = false, description = "Verify user is displayed with template screen by default.")
	public void vaidateTC_EP_069() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_EP_069");
		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);

		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(3000);
		System.out.println(scheduledelements.size());

		List<WebElement> eventdates = driver.findElements(By.xpath("//div[@class='drop-in-event-list-date']"));
		Thread.sleep(5000);

		System.out.println(eventdates.size());
		String timeStamp = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		String text = null;

		if (scheduledelements.size() != 0) {
			// (int i = 0; i < scheduledelements.size(); i++) {

			// if (!(eventdates.get(i).getText().contains(timeStamp))) {
			// System.out.println("inside if loop");
			scheduledelements.get(0).click();
			System.out.println(scheduledelements.get(0).getText());
			Thread.sleep(7000);
			gm.click("LinkText", "Feedback");

			// gm.click("Xpath", gm.readproperty_file("enablefeedback"));
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("selectfeedbackcategory"));
			gm.SendKeys("Xpath", gm.readproperty_file("entercategoryname"), ExcelUtils.getCellData(1, 26));

			driver.findElement(By.xpath(gm.readproperty_file("entercategoryname"))).sendKeys(Keys.ENTER);

			gm.SendKeys("Xpath", gm.readproperty_file("enterquestion"), ExcelUtils.getCellData(1, 27));

			gm.click("Xpath", gm.readproperty_file("clicknext-fb"));
			Thread.sleep(5000);

			Assert.assertTrue("template option is not checked by default", gm.isDisplayed("Xpath",gm.readproperty_file("templatecheckedbydefault")));
			
		}
	}
	
	@Test(priority = 41, enabled = false, description = "Verify attendees can be assigned only for student if event type is created only with student")
	public void vaidateTC_CF_019() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_CF_019");
		Thread.sleep(5000);
		
		//Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToConfigurationPage();
		gm.click("Xpath", gm.readproperty_file("clickfeaturesetup"));

		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickCalendar"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickCalendarType"));
		Thread.sleep(3000);
		//
		
		gm.SendKeys("Xpath", gm.readproperty_file("typesearch"), ExcelUtils.getCellData(1, 18));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		
		
		
		
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("edittype"));
		//
		Thread.sleep(5000);

		String attenddestype=gm.getText("Xpath",  gm.readproperty_file("getattendeestype"));
		System.out.println(attenddestype);
		Thread.sleep(3000);
		
		gm.clickUsingJavaScriptExecutor(gm.readproperty_file("canceledittype"));
		
		//gm.click("Xpath", gm.readproperty_file("canceledittype"));
		gm.click("Xpath", gm.readproperty_file("clickhome"));
		Thread.sleep(3000);
		//gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(3000);
		gm.click("LinkText", "Event");
		Thread.sleep(5000);

		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-binding ng-scope']"));
		Thread.sleep(3000);
		
		scheduledelements.get(0).click();
		Thread.sleep(10000);

		//gm.scrollDown(gm.readproperty_file("specificrecepients-events"));
		gm.clickUsingJavaScriptExecutor(gm.readproperty_file("getusertype"));
		
		Boolean staffdisplayed=driver.findElements(By.xpath("//div[contains(text(),'Staff')]")).size() > 0;
		
		Assert.assertFalse("staff user type is displayed", staffdisplayed);
		String usertype=gm.getText("Xpath", gm.readproperty_file("getusertype"));
		System.out.println(usertype);
		Assert.assertEquals(attenddestype, usertype);
		
	}
	
	@Test(priority = 42, enabled = false, description = "Verify created calendar feedback is displayed in the poll module.")
	public void vaidateTC_EP_084() throws Exception {
		
		//vaidateTC_EP_088 has to be execcuted first to create feedback
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		extentTest = extent.startTest("vaidateTC_EP_084");
		Thread.sleep(5000);
		
		gm.navigatetopollspage();
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys(ExcelUtils.getCellData(1, 26));
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Library')]")).click();
		Thread.sleep(3000);
		
		Assert.assertTrue("created feedback is not displayed in poll", driver.getPageSource().contains(ExcelUtils.getCellData(1, 27)));
	}
	
	
	
	public void logintostudentportal(String uname) throws InterruptedException, IOException {
		driver.get("https://compass-uat.engage2serve.com/");

		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='usrnm']")));

		driver.findElement(By.xpath("//input[@name='usrnm']")).clear();

		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@name='usrnm']")).sendKeys(uname);

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(ExcelUtils.getCellData(1, 23));

		gm.Wait("//button[@type='submit']");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	public void logintostudentportal() throws InterruptedException, IOException {
		driver.get("https://compass-qa.engage2serve.com/");

		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='usrnm']")));

		driver.findElement(By.xpath("//input[@name='usrnm']")).clear();

		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@name='usrnm']")).sendKeys(ExcelUtils.getCellData(1, 22));

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(ExcelUtils.getCellData(1, 23));

		gm.Wait("//button[@type='submit']");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	public void createvent() throws Exception {
		Thread.sleep(5000);
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		gm.click("Xpath", gm.readproperty_file("clickplusicon"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("getType"));
		gm.SendKeys("Xpath", gm.readproperty_file("entertypevalue"), ExcelUtils.getCellData(1, 18));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("getTitle"), ExcelUtils.getCellData(1, 0));
		Thread.sleep(3000);
		gm.SendKeys("Xpath", gm.readproperty_file("addtag"), ExcelUtils.getCellData(1, 24));
		driver.findElement(By.xpath(gm.readproperty_file("addtag"))).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("enterShotDescription"), ExcelUtils.getCellData(1, 1));

		gm.SendKeys("Xpath", gm.readproperty_file("enterAdditionalInformations"), ExcelUtils.getCellData(1, 2));

		gm.click("Xpath", gm.readproperty_file("selectPatternEvent"));

		if (ExcelUtils.getCellData(1, 3).contains("Single")) {
			gm.click("Xpath", gm.readproperty_file("selectSingle"));

			gm.click("Xpath", gm.readproperty_file("selectStrtDate"));

			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 4));
			Thread.sleep(5000);
		}

		if (ExcelUtils.getCellData(1, 3).contains("Recurring - Custom")) {
			gm.click("Xpath", gm.readproperty_file("selectRecurringRegular"));

			gm.click("Xpath", gm.readproperty_file("selectStrtDate"));

			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 4));
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("selectEndDate"));

			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 4));
			Thread.sleep(5000);
		}

		gm.click("Xpath", gm.readproperty_file("selectregistration"));
		gm.click("Xpath", gm.readproperty_file("clicknextbutton"));
		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("sessionname"), ExcelUtils.getCellData(1, 5));
		gm.SendKeys("Xpath", gm.readproperty_file("starttimeddl"), ExcelUtils.getCellData(1, 6));

		gm.SendKeys("Xpath", gm.readproperty_file("starttimeminutesddl"), ExcelUtils.getCellData(1, 7));
		Thread.sleep(5000);

		driver.findElement(By.xpath(gm.readproperty_file("endtimeddl"))).clear();

		gm.SendKeys("Xpath", gm.readproperty_file("endtimeddl"), ExcelUtils.getCellData(1, 8));
		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("endtimeminutesddl"), ExcelUtils.getCellData(1, 9));
		Thread.sleep(5000);

		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		//
		WebElement button5 = driver.findElement(By.xpath(gm.readproperty_file("selectcampus")));
		//
		js5.executeScript("arguments[0].click();", button5);

		// gm.click("Xpath", gm.readproperty_file("selectcampus"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercampusname"), ExcelUtils.getCellData(1, 10));
		driver.findElement(By.xpath(gm.readproperty_file("entercampusname"))).sendKeys(Keys.ENTER);

		gm.click("Xpath", gm.readproperty_file("selectlocation"));

		// gm.SendKeys("Xpath", gm.readproperty_file("enterlocation"),
		// ExcelUtils.getCellData(1, 11));
		Thread.sleep(7000);
		// driver.findElement(By.xpath(gm.readproperty_file("enterlocation"))).sendKeys(Keys.ENTER);

		gm.click("Xpath", "//div[contains(text(),'" + ExcelUtils.getCellData(1, 11) + "')]");

		Thread.sleep(5000);

		String roomvalue = ExcelUtils.getCellData(1, 12);
		System.out.println(ExcelUtils.getCellData(1, 12));
		gm.click("Xpath", gm.readproperty_file("selectroom"));
		Thread.sleep(7000);
		// gm.click("Xpath", "//div[contains(text(),'"+ExcelUtils.getCellData(1,
		// 12)+"')]");
		// Thread.sleep(5000);
		Actions action11 = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'" + roomvalue + "')]"));

		action11.moveToElement(element).click().build().perform();
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("specificrecepients-events"));
		Thread.sleep(3000);
		gm.click("LinkText", "Recipients");
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("allstudents"));

		gm.click("Xpath", gm.readproperty_file("clickinvite"));
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		//
		WebElement button = driver.findElement(By.xpath(gm.readproperty_file("clickaddsession")));
		//
		js.executeScript("arguments[0].click();", button);
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("clickpublish"));
		Thread.sleep(10000);

	}

	public void creatandregisterevent() throws Exception {
		Thread.sleep(5000);
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		gm.click("Xpath", gm.readproperty_file("clickplusicon"));
		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("getTitle"), ExcelUtils.getCellData(1, 0));

		gm.SendKeys("Xpath", gm.readproperty_file("enterShotDescription"), ExcelUtils.getCellData(1, 1));

		gm.SendKeys("Xpath", gm.readproperty_file("enterAdditionalInformations"), ExcelUtils.getCellData(1, 2));

		gm.click("Xpath", gm.readproperty_file("selectPatternEvent"));

		if (ExcelUtils.getCellData(1, 3).contains("Single")) {
			gm.click("Xpath", gm.readproperty_file("selectSingle"));

			gm.click("Xpath", gm.readproperty_file("selectStrtDate"));

			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 4));
			Thread.sleep(5000);
		}

		if (ExcelUtils.getCellData(1, 3).contains("Recurring - Custom")) {
			gm.click("Xpath", gm.readproperty_file("selectRecurringRegular"));

			gm.click("Xpath", gm.readproperty_file("selectStrtDate"));

			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 4));
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("selectEndDate"));

			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 4));
			Thread.sleep(5000);
		}

		gm.click("Xpath", gm.readproperty_file("selectregistration"));
		gm.click("Xpath", gm.readproperty_file("clicknextbutton"));
		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("starttimeddl"), ExcelUtils.getCellData(1, 6));

		gm.SendKeys("Xpath", gm.readproperty_file("starttimeminutesddl"), ExcelUtils.getCellData(1, 7));
		Thread.sleep(5000);

		driver.findElement(By.xpath(gm.readproperty_file("endtimeddl"))).clear();

		gm.SendKeys("Xpath", gm.readproperty_file("endtimeddl"), ExcelUtils.getCellData(1, 8));
		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("endtimeminutesddl"), ExcelUtils.getCellData(1, 9));
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("selectcampus"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercampusname"), ExcelUtils.getCellData(1, 10));
		driver.findElement(By.xpath(gm.readproperty_file("entercampusname"))).sendKeys(Keys.ENTER);

		gm.click("Xpath", gm.readproperty_file("selectlocation"));

		// gm.SendKeys("Xpath", gm.readproperty_file("enterlocation"),
		// ExcelUtils.getCellData(1, 11));
		Thread.sleep(7000);
		// driver.findElement(By.xpath(gm.readproperty_file("enterlocation"))).sendKeys(Keys.ENTER);

		gm.click("Xpath", "//div[contains(text(),'" + ExcelUtils.getCellData(1, 11) + "')]");

		Thread.sleep(5000);

		String roomvalue = ExcelUtils.getCellData(1, 12);
		System.out.println(ExcelUtils.getCellData(1, 12));
		gm.click("Xpath", gm.readproperty_file("selectroom"));
		Thread.sleep(7000);
		// gm.click("Xpath", "//div[contains(text(),'"+ExcelUtils.getCellData(1,
		// 12)+"')]");
		// Thread.sleep(5000);
		Actions action11 = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'" + roomvalue + "')]"));

		action11.moveToElement(element).click().build().perform();
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("specificrecepients-events"));
		Thread.sleep(3000);
		gm.click("LinkText", "Recipients");
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("allstudents"));

		gm.click("Xpath", gm.readproperty_file("clickinvite"));
		Thread.sleep(5000);

		if (!(ExcelUtils.getCellData(1, 19).contains("no"))) {
			gm.click("Xpath", gm.readproperty_file("clickaddsession"));

		}

		gm.click("Xpath", gm.readproperty_file("clickpublish"));
		Thread.sleep(10000);
		gm.click("LinkText", gm.readproperty_file("clickinviteestab"));

		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("searchbyname"), ExcelUtils.getCellData(1, 21));
		driver.findElement(By.xpath(gm.readproperty_file("searchbyname"))).sendKeys(Keys.ENTER);

		gm.click("Xpath", gm.readproperty_file("clickaction"));
		Thread.sleep(3000);
		gm.click("LinkText", "Register");

		gm.click("Xpath", gm.readproperty_file("clicktoregisterbutton"));

		Thread.sleep(5000);
	}

	public void creatdraftevent() throws Exception {
		Thread.sleep(5000);
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Event_TestData);
		gm.click("Xpath", gm.readproperty_file("clickplusicon"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("getType"));
		gm.SendKeys("Xpath", gm.readproperty_file("entertypevalue"), ExcelUtils.getCellData(1, 18));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();

		Thread.sleep(3000);
		gm.SendKeys("Xpath", gm.readproperty_file("getTitle"), ExcelUtils.getCellData(1, 0));

		gm.SendKeys("Xpath", gm.readproperty_file("enterShotDescription"), ExcelUtils.getCellData(1, 1));

		gm.SendKeys("Xpath", gm.readproperty_file("enterAdditionalInformations"), ExcelUtils.getCellData(1, 2));

		gm.click("Xpath", gm.readproperty_file("selectPatternEvent"));

		if (ExcelUtils.getCellData(1, 3).contains("Single")) {
			gm.click("Xpath", gm.readproperty_file("selectSingle"));

			gm.click("Xpath", gm.readproperty_file("selectStrtDate"));

			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 4));
			Thread.sleep(5000);
		}

		if (ExcelUtils.getCellData(1, 3).contains("Recurring - Custom")) {
			gm.click("Xpath", gm.readproperty_file("selectRecurringRegular"));

			gm.click("Xpath", gm.readproperty_file("selectStrtDate"));

			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 4));
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("selectEndDate"));

			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 4));
			Thread.sleep(5000);
		}

		gm.click("Xpath", gm.readproperty_file("selectregistration"));
		gm.click("Xpath", gm.readproperty_file("clicknextbutton"));
		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("sessionname"), ExcelUtils.getCellData(1, 5));
		gm.SendKeys("Xpath", gm.readproperty_file("starttimeddl"), ExcelUtils.getCellData(1, 6));

		gm.SendKeys("Xpath", gm.readproperty_file("starttimeminutesddl"), ExcelUtils.getCellData(1, 7));
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("selectcampus"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercampusname"), ExcelUtils.getCellData(1, 10));
		driver.findElement(By.xpath(gm.readproperty_file("entercampusname"))).sendKeys(Keys.ENTER);

		gm.click("Xpath", gm.readproperty_file("selectlocation"));

		Thread.sleep(7000);

		gm.click("Xpath", "//div[contains(text(),'" + ExcelUtils.getCellData(1, 11) + "')]");

		Thread.sleep(5000);

		String roomvalue = ExcelUtils.getCellData(1, 12);
		System.out.println(ExcelUtils.getCellData(1, 12));
		gm.click("Xpath", gm.readproperty_file("selectroom"));
		Thread.sleep(7000);

		Actions action11 = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'" + roomvalue + "')]"));

		action11.moveToElement(element).click().build().perform();
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("specificrecepients-events"));
		Thread.sleep(3000);
		gm.click("LinkText", "Recipients");
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("allstudents"));

		gm.click("Xpath", gm.readproperty_file("clickinvite"));
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		//
		WebElement button = driver.findElement(By.xpath(gm.readproperty_file("savesession")));
		//
		js.executeScript("arguments[0].click();", button);
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("clickdraft"));

	}
}
