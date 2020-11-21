package Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.DateFormat;
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

public class AppointmentTest extends FunctionalTest {

	AppointmentPage ap = new AppointmentPage();

	GenericMEthods gm = new GenericMEthods();

	@Test(priority = 1, enabled = true, description = "Verify all the active appointment type is displayed in the type drop down")
	public void vaidateTC_APP_003() throws InterruptedException, DocumentException, IOException {

		extentTest = extent.startTest("vaidateTC_AP_006");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToConfigurationPage();
		gm.click("Xpath", gm.readproperty_file("clickfeaturesetup"));

		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickCalendar"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickCalendarType"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clickFilterButton"));

		gm.click("Xpath", gm.readproperty_file("clickType"));

		gm.click("Xpath", gm.readproperty_file("selectAppointmenttype"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("selectStatus"));
		gm.click("Xpath", gm.readproperty_file("selectActive"));

		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickApply"));

		Thread.sleep(3000);
		gm.getSingleColumnDataFromTable(gm.readproperty_file("calendarTypeTable"));

	}

	/*covered in TC_APP_023
	/*@Test(priority = 2, enabled = false, description = "Verify staff is able to publish availability the drafted appointment")
	public void vaidateTC_APP_056() throws InterruptedException, DocumentException, IOException {

		extentTest = extent.startTest("vaidateTC_APP_056");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.click("Xpath", gm.readproperty_file("clickfeaturesetup"));

		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickCalendar"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickCalendarType"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clickFilterButton"));

		gm.click("Xpath", gm.readproperty_file("clickType"));

		gm.click("Xpath", gm.readproperty_file("selectAppointmenttype"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("selectStatus"));
		gm.click("Xpath", gm.readproperty_file("selectActive"));

		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickApply"));

		Thread.sleep(3000);
		gm.getSingleColumnDataFromTable(gm.readproperty_file("calendarTypeTable"));

	}*/

	@Test(priority = 3, enabled = false, description = "Verify user able to create & select a location")
	public void vaidateTC_APP_014() throws Exception {

		extentTest = extent.startTest("vaidateTC_APP_014");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));

		gm.click("Xpath", gm.readproperty_file("clickCreateAppnmt"));
		// gm.click("Xpath", gm.readproperty_file("selectType);
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		// gm.SendKeys("Xpath", gm.readproperty_file("enterType,
		// ExcelUtils.getCellData(1, 0));
		gm.Wait(gm.readproperty_file("selectType"));

		gm.scrollToElement(gm.readproperty_file("selectCampusDdl"));

		gm.click("Xpath", gm.readproperty_file("selectCampusDdl"));

		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("selectCampusValue"));

		gm.click("Xpath", gm.readproperty_file("selectLocation"));
		gm.click("Xpath", gm.readproperty_file("clickCreateLocation"));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLocationName"), ExcelUtils.getCellData(1, 1));

		gm.SendKeys("Xpath", gm.readproperty_file("enterDesc"), ExcelUtils.getCellData(1, 2));

		gm.click("Xpath", gm.readproperty_file("clickCreateButton"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("selectLocation"));

		gm.click("Xpath", "//div[contains(text(),'" + ExcelUtils.getCellData(1, 1) + "')]");

		String locationame = gm.getText("Xpath", gm.readproperty_file("getSelectedLocation"));

		System.out.println("screen value" + locationame);

		Assert.assertEquals(locationame, ExcelUtils.getCellData(1, 1));

	}

	@Test(priority = 4, enabled = false, description = "Verify user able to create & select a room")
	public void vaidateTC_APP_015() throws Exception {

		extentTest = extent.startTest("vaidateTC_APP_015");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));

		gm.click("Xpath", gm.readproperty_file("clickCreateAppnmt"));
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		gm.Wait(gm.readproperty_file("selectType"));

		gm.scrollToElement(gm.readproperty_file("selectCampusDdl"));

		gm.click("Xpath", gm.readproperty_file("selectCampusDdl"));

		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("selectCampusValue"));

		gm.click("Xpath", gm.readproperty_file("selectLocation"));

		// gm.click("Xpath", gm.readproperty_file("selectLocationValue);
		gm.SendKeys("Xpath", gm.readproperty_file("enterLocationText"), ExcelUtils.getCellData(1, 1));
		driver.findElement(By.xpath(gm.readproperty_file("enterLocationText"))).sendKeys(Keys.ENTER);

		gm.click("Xpath", gm.readproperty_file("clickCreateRoomPlusButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("enterRoomName"), ExcelUtils.getCellData(1, 3));

		gm.SendKeys("Xpath", gm.readproperty_file("enterDesc"), ExcelUtils.getCellData(1, 4));
		gm.SendKeys("Xpath", gm.readproperty_file("enterCapacity"), ExcelUtils.getCellData(1, 5));

		gm.click("Xpath", gm.readproperty_file("clickCreateRoom"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clickSelectRoom"));

		gm.click("Xpath", "//div[contains(text(),'" + ExcelUtils.getCellData(1, 3) + "')]");

		String roomname = gm.getText("Xpath", gm.readproperty_file("selectedRoomValue"));

		System.out.println("screen value" + roomname);

		Assert.assertTrue(roomname.contains(ExcelUtils.getCellData(1, 3)));

	}

	@Test(priority = 5, enabled = false, description = "Verify user able to enable Book Appointment with user in the Appointment creation page")
	public void vaidateTC_APP_047() throws Exception {

		extentTest = extent.startTest("vaidateTC_APP_047");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));

		gm.click("Xpath", gm.readproperty_file("clickCreateAppnmt"));
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("selectType"));
		gm.SendKeys("Xpath", gm.readproperty_file("enterType"), ExcelUtils.getCellData(1, 0));

		driver.findElement(By.xpath(gm.readproperty_file("enterType"))).sendKeys(Keys.ENTER);

		gm.click("Xpath", gm.readproperty_file("clickBookAppoinmtWithUser"));
		// withTimeoutOf(15, TimeUnit.SECONDS).waitFor(MAIN_HEADING_LABEL);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		Boolean isselected = driver.findElement(By.xpath(gm.readproperty_file("clickBookAppoinmtWithUser")))
				.isEnabled();

		System.out.println(isselected);

	}

	@Test(priority = 6, enabled = false, description = "Verify staff is able to schedule slots for future dates by choosing single pattern")
	public void vaidateTC_APP_008() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_047");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));

		gm.click("Xpath", gm.readproperty_file("clickCreateAppnmt"));
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("selectPattern"));

		gm.click("Xpath", gm.readproperty_file("selectSinglePattern"));

		gm.click("Xpath", gm.readproperty_file("selectDate"));
		Thread.sleep(5000);

		// gm.selectDate(7, 8, gm.readproperty_file("selectDate"));

	}

	@Test(priority = 7, enabled = false, description = "Verify user is able to create a recurring - regular appointment")
	public void vaidateTC_APP_017() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_017");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		// gm.navigateToConfigurationPage();
		// createNewCalendarService();
		// mapAdvisorInAssociateUsersTab();
		gm.click("Xpath", "//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		CreateScheduledAppnmt();

		// gm.click("Xpath", gm.readproperty_file("ClickonSaveandPublishbutton);

		Thread.sleep(5000);
		// Boolean isPresent =
		// driver.findElements(By.xpath(gm.readproperty_file("appnmtCreationSuccessMsg)).size()
		// > 0;
		// Assert.assertTrue(isPresent);
		gm.click("LinkText", "Appointment");

		verifysubmittedvaluesdropinappnmt();
		Thread.sleep(5000);
		// Boolean
		// message=driver.findElement(By.xpath(gm.readproperty_file("dropCreationSuccessMsg)).isDisplayed();

		/*
		 * if (isPresent == false) { Boolean message2 =
		 * driver.findElements(By.xpath(gm.readproperty_file("anotherCalScheduledMsg))
		 * .size() > 0;
		 * 
		 * driver.findElement(By.xpath(gm.readproperty_file("clickEditSessionIcon)).
		 * click(); anotherCalendarScehduledinSameDurationValidation();
		 * 
		 * Thread.sleep(5000); isPresent =
		 * driver.findElements(By.xpath(gm.readproperty_file("dropCreationSuccessMsg))
		 * .size() > 0;
		 * 
		 * Assert.assertTrue(isPresent); }
		 * 
		 * else if (isPresent == true) {
		 * System.out.println("drop in appointment created successfully");
		 * 
		 * }
		 */

	}

	@Test(priority = 8, enabled = false, description = "Verify user able to update calendar when appointment is in the draft status")
	public void vaidateTC_APP_23() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_017");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));

		gm.click("Xpath", gm.readproperty_file("clickDraftsTab"));
		Thread.sleep(3000);
		List<WebElement> draftselements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));

		for (int i = 0; i < draftselements.size(); i++) {
			if (draftselements.size() > 0) {
				System.out.println("inside if loop");
				draftselements.get(i).click();
				Thread.sleep(5000);
			}

			else {
				CreateScheduledAppnmt();
				gm.click("Xpath", gm.readproperty_file("clickSaveAsDraft"));
				gm.click("Xpath", gm.readproperty_file("clickCalOption"));
				gm.click("Xpath", gm.readproperty_file("clickDraftsTab"));
			}
			gm.click("Xpath", gm.readproperty_file("clickEditDraftsAppnmt"));
			Thread.sleep(5000);

			JavascriptExecutor js4 = (JavascriptExecutor) driver;
			//
			WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("selectCampusDdl")));
			//
			js4.executeScript("arguments[0].click();", button4);
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("selectCampusValue1"));

			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			//
			WebElement button2 = driver.findElement(By.xpath(gm.readproperty_file("selectLocation")));
			//
			js2.executeScript("arguments[0].click();", button2);
			Thread.sleep(5000);

			gm.SendKeys("Xpath", gm.readproperty_file("enterLocationText"), ExcelUtils.getCellData(2, 1));
			driver.findElement(By.xpath(gm.readproperty_file("enterLocationText"))).sendKeys(Keys.ENTER);

			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			//
			WebElement button3 = driver.findElement(By.xpath(gm.readproperty_file("clickSelectRoom")));
			//
			js2.executeScript("arguments[0].click();", button3);
			Thread.sleep(5000);

			gm.SendKeys("Xpath", gm.readproperty_file("enterRoomText"), ExcelUtils.getCellData(2, 3));
			driver.findElement(By.xpath(gm.readproperty_file("enterRoomText"))).sendKeys(Keys.ENTER);

			gm.click("Xpath", gm.readproperty_file("clickSaveAsDraft"));
			Thread.sleep(5000);
			boolean message = gm.isDisplayed("Xpath", gm.readproperty_file("draftsupdatemsg"));
			Assert.assertTrue(message);
			gm.click("Xpath", gm.readproperty_file("clickEditDraftsAppnmt"));
			Thread.sleep(5000);
			// String campustext=gm.getText("Xpath",
			// gm.readproperty_file("selectCampusDdl);
			String roomtext = gm.getText("Xpath", gm.readproperty_file("enterRoomText"));
			String locationtext = gm.getText("Xpath", gm.readproperty_file("selectLocation"));

			// Assert.assertEquals(campustext, ExcelUtils.getCellData(2, 6));
			Assert.assertEquals(roomtext, ExcelUtils.getCellData(2, 3));
			Assert.assertEquals(locationtext, ExcelUtils.getCellData(2, 1));
			Thread.sleep(5000);

		}

	}

	@Test(priority = 9, enabled = false, description = "Verify cancelled Appointment of scheduled is displayed under cancelled status of sleek dashboard of calendar")
	public void vaidateTC_APP_021() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_021");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(5000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		Thread.sleep(3000);
		System.out.println(scheduledelements.size());

		List<WebElement> appnmtdates = driver.findElements(By.xpath("//div[@class='drop-in-event-list-date']"));
		Thread.sleep(5000);

		System.out.println(appnmtdates.size());
		String timeStamp = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		String text = null;
		String newappnmtname = null;
		if (scheduledelements.size() != 0) {
			for (int i = 0; i < scheduledelements.size(); i++) {
				String appnmtname = scheduledelements.get(i).getText();

				if ((appnmtname.contains("Appointment")) && (!(appnmtdates.get(i).getText().contains(timeStamp)))) {
					System.out.println("inside if loop");
					scheduledelements.get(i).click();

					System.out.println("sch appnmt name" + scheduledelements.get(i).getText());

					newappnmtname = scheduledelements.get(i).getText();

					Thread.sleep(5000);

					gm.click("LinkText", "Appointment");

					text = gm.getText("Xpath", gm.readproperty_file("enterTitle"));
					System.out.println("title" + text);
					Thread.sleep(5000);
					String patterntype = gm.getText("Xpath", "//*[@id='patternOption']/span[2]");
					System.out.println("patterntype:" + patterntype);

					if (patterntype.contains("Recurring")) {
						gm.click("Xpath", gm.readproperty_file("clickCancelAppointment"));
						JavascriptExecutor js3 = (JavascriptExecutor) driver;
						//
						WebElement button3 = driver.findElement(By.xpath(gm.readproperty_file("clickCancelSession")));
						//
						js3.executeScript("arguments[0].click();", button3);
						Thread.sleep(3000);
						break;
					}

					else {
						gm.click("Xpath", gm.readproperty_file("clickCancelAppointment"));
						Thread.sleep(5000);
						JavascriptExecutor js4 = (JavascriptExecutor) driver;
						//
						WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("confirmApmntCancel")));
						//
						js4.executeScript("arguments[0].click();", button4);
						Thread.sleep(3000);

						break;
					}

				} else {
					System.out.println(
							"Appointment with scheduled date greater than today's date is not present.Creating new scheduled appointment");
					CreateScheduledAppnmt();
					gm.click("Xpath", gm.readproperty_file("ClickonSaveandPublishbutton"));
					Thread.sleep(5000);
					gm.click("LinkText", "Appointment");

					newappnmtname = gm.getText("Xpath", gm.readproperty_file("enterTitle"));
					Thread.sleep(5000);
					gm.click("Xpath", gm.readproperty_file("clickCancelAppointment"));

					JavascriptExecutor js3 = (JavascriptExecutor) driver;
					//
					WebElement button3 = driver.findElement(By.xpath(gm.readproperty_file("confirmApmntCancel")));
					//
					js3.executeScript("arguments[0].click();", button3);
					Thread.sleep(3000);
					break;
				}
			}
		}

		else {
			System.out.println("No appointment is present.Creating new scheduled appointment");
			Thread.sleep(5000);
			CreateScheduledAppnmt();
			gm.click("Xpath", gm.readproperty_file("ClickonSaveandPublishbutton"));
			Thread.sleep(5000);
			gm.click("LinkText", "Appointment");

			newappnmtname = gm.getText("Xpath", gm.readproperty_file("enterTitle"));
			Thread.sleep(5000);
			gm.click("Xpath", gm.readproperty_file("clickCancelAppointment"));

			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			//
			WebElement button3 = driver.findElement(By.xpath(gm.readproperty_file("confirmApmntCancel")));
			//
			js3.executeScript("arguments[0].click();", button3);
			Thread.sleep(3000);

		}

		Thread.sleep(5000);

		String message = driver.findElement(By.xpath("//div[@ng-show='!$messageTemplate']")).getText();
		System.out.println(message);
		Assert.assertTrue(message.contains("Cancelled successfully"));
		Thread.sleep(10000);
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		//
		WebElement button5 = driver.findElement(By.xpath(gm.readproperty_file("clickCancelledTab")));
		//
		js5.executeScript("arguments[0].click();", button5);

		Thread.sleep(5000);
		// gm.click("Xpath", gm.readproperty_file("clickCancelledTab);
		List<WebElement> cancelledappointments = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		System.out.println(cancelledappointments.size());

		for (int i = 0; i < cancelledappointments.size(); i++) {
			System.out.println(cancelledappointments.get(i).getText());
			System.out.println("newappnmtname" + newappnmtname);
			Assert.assertTrue(message, cancelledappointments.get(i).getText().contains(newappnmtname));
		}

	}

	@Test(priority = 10, enabled = false, description = "Verify staff is able to book an appointment from the slot tab")
	public void vaidateTC_APP_027() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_027");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(10000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		System.out.println("scheduledelements.size" + scheduledelements.size());

		Thread.sleep(10000);
		List<WebElement> appnmtdates = driver.findElements(By.xpath("//div[@class='drop-in-event-list-date']"));
		Thread.sleep(10000);
		System.out.println("appnmtdates.size" + appnmtdates.size());
		String timeStamp = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		String text = null;
		Thread.sleep(5000);
		if (scheduledelements.size() != 0) {
			for (int i = 0; i < scheduledelements.size(); i++) {

				if (!(appnmtdates.get(i).getText().contains(timeStamp))) {

					String appnmtname = scheduledelements.get(i).getText();

					Thread.sleep(5000);

					if ((appnmtname.contains("Appointment"))) {
						scheduledelements.get(i).click();
						gm.Wait(gm.readproperty_file("clickBook"));
						gm.click("Xpath", gm.readproperty_file("clickBook"));

						gm.Wait(gm.readproperty_file("selectUserType"));
						gm.click("Xpath", gm.readproperty_file("selectUserType"));

						// gm.click("Xpath", gm.readproperty_file("selectStudent);
						ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

						gm.SendKeys("Xpath", gm.readproperty_file("enterUserType"), ExcelUtils.getCellData(1, 18));
						driver.findElement(By.xpath(gm.readproperty_file("enterUserType"))).sendKeys(Keys.ENTER);
						Thread.sleep(3000);
						gm.click("Xpath", gm.readproperty_file("selectStudent"));
						gm.SendKeys("Xpath", gm.readproperty_file("enterAlumni"), ExcelUtils.getCellData(1, 19));
						driver.findElement(By.xpath(gm.readproperty_file("enterAlumni"))).sendKeys(Keys.ENTER);
						Thread.sleep(3000);
						System.out.println(ExcelUtils.getCellData(1, 21));
						gm.SendKeys("Xpath", gm.readproperty_file("enterSubject"), ExcelUtils.getCellData(1, 21));

						gm.SendKeys("Xpath", gm.readproperty_file("enterPurposeOfMeeting"),
								ExcelUtils.getCellData(1, 20));

						gm.click("Xpath", gm.readproperty_file("clickSubmit"));

						gm.Wait(gm.readproperty_file("getStatus"));
						String text1 = gm.getText("Xpath", gm.readproperty_file("getStatus"));

						Assert.assertTrue("status is not displayed as registered", text1.contains("Registered"));
						break;
					}

				}
			}
		}

	}

	@Test(priority = 11, enabled = false, description = "Verify user able to transfer a student for select appointment time")
	public void vaidateTC_APP_036() throws Exception {

		extentTest = extent.startTest("vaidateTC_APP_027");
		navigateToAppointmentPage();

		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		System.out.println("scheduledelements.size" + scheduledelements.size());

		Thread.sleep(10000);
		List<WebElement> appnmtdates = driver.findElements(By.xpath("//div[@class='drop-in-event-list-date']"));
		Thread.sleep(10000);
		System.out.println("appnmtdates.size" + appnmtdates.size());
		String timeStamp = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		String text = null;
		Thread.sleep(5000);
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);
		if (scheduledelements.size() != 0) {
			for (int i = 0; i < scheduledelements.size(); i++) {

				if (!(appnmtdates.get(i).getText().contains(timeStamp))) {

					String appnmtname = scheduledelements.get(i).getText();

					Thread.sleep(5000);

					if ((appnmtname.contains("Appointment"))) {
						Thread.sleep(3000);
						scheduledelements.get(i).click();
						Thread.sleep(15000);
						// gm.Wait(gm.readproperty_file("clickViewDetails);
						gm.click("Xpath", gm.readproperty_file("clickViewDetails"));
						Thread.sleep(50000);
						// gm.Wait(gm.readproperty_file("clickTransfer);
						gm.click("Xpath", gm.readproperty_file("clickTransfer"));
						Thread.sleep(5000);
						gm.click("Xpath", gm.readproperty_file("selectService"));

						gm.SendKeys("Xpath", gm.readproperty_file("enterServiceName"), ExcelUtils.getCellData(1, 22));
						driver.findElement(By.xpath(gm.readproperty_file("enterServiceName"))).sendKeys(Keys.ENTER);

						gm.click("Xpath", gm.readproperty_file("clickStaffddl"));
						gm.SendKeys("Xpath", gm.readproperty_file("enterStaffName"), ExcelUtils.getCellData(1, 23));
						driver.findElement(By.xpath(gm.readproperty_file("enterStaffName"))).sendKeys(Keys.ENTER);

						gm.click("Xpath", gm.readproperty_file("selectFrom"));

						gm.selectDate(ExcelUtils.getCellData(1, 25));

						gm.click("Xpath", gm.readproperty_file("selectTo"));
						gm.selectDate(ExcelUtils.getCellData(1, 26));

						gm.click("Xpath", gm.readproperty_file("clickSearch"));
						Thread.sleep(40000);
						List<WebElement> availslots = driver
								.findElements(By.xpath("//div[@ng-click='selectedSlot(avs)']"));

						if (availslots.size() > 0) {
							availslots.get(0).click();
						}

						Thread.sleep(5000);

						gm.SendKeys("Xpath", gm.readproperty_file("enterNotes"), ExcelUtils.getCellData(1, 24));
						gm.click("Xpath", gm.readproperty_file("clickSubmitButton"));
						// success msg is displayed wrongly
						Thread.sleep(5000);
						break;
					}
				}
			}
		}

	}

	@Test(priority = 12, enabled = false, description = "Verify added notes are displayed in the action track tab of Appointment detail page")
	public void vaidateTC_APP_042() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		extentTest = extent.startTest("vaidateTC_APP_042");
		navigateToAppointmentPage();

		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		System.out.println("scheduledelements.size" + scheduledelements.size());

		Thread.sleep(10000);
		List<WebElement> appnmtdates = driver.findElements(By.xpath("//div[@class='drop-in-event-list-date']"));
		Thread.sleep(10000);
		System.out.println("appnmtdates.size" + appnmtdates.size());
		String timeStamp = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		String text = null;
		Thread.sleep(5000);
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);
		if (scheduledelements.size() != 0) {
			for (int i = 0; i < scheduledelements.size(); i++) {

				if (!(appnmtdates.get(i).getText().contains(timeStamp))) {

					String appnmtname = scheduledelements.get(i).getText();

					Thread.sleep(5000);

					if ((appnmtname.contains("Appointment"))) {
						Thread.sleep(3000);
						scheduledelements.get(i).click();
						Thread.sleep(50000);
						// gm.Wait(gm.readproperty_file("clickViewDetails);

						Boolean isPresent = driver.findElements(By.xpath(gm.readproperty_file("clickViewDetails")))
								.size() > 0;
						if (isPresent == false) {
							BookAppointment();
						}
						Thread.sleep(15000);
						gm.click("Xpath", gm.readproperty_file("clickViewDetails"));
						Thread.sleep(50000);

						gm.click("Xpath", gm.readproperty_file("clickNotesTab"));
						gm.SendKeys("Xpath", gm.readproperty_file("enterNotesText"), ExcelUtils.getCellData(1, 24));
						gm.click("Xpath", gm.readproperty_file("clickSubmitButton"));
						Thread.sleep(5000);
						gm.click("LinkText", gm.readproperty_file("clickActionTrack"));
						Thread.sleep(5000);
						Assert.assertTrue(driver.getPageSource().contains(ExcelUtils.getCellData(1, 24)));
					}
				}
			}
		}
	}

	@Test(priority = 13, enabled = false, description = "Verify student is able to filter with advisor and appointment type")
	public void vaidateTC_SBAA_096() throws Exception {

		extentTest = extent.startTest("vaidateTC_SBAA_096");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);
		gm.navigateToConfigurationPage();

		mapAdvisorInAssociateUsersTab();

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		logintostudentportal();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();

		driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointment"))).click();

		Thread.sleep(5000);
		// driver1.findElement(By.xpath(
		// gm.readproperty_file("selectAdvisor)).click();
		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).sendKeys(" Student service ");
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(3000);
		// driver1.findElement(By.xpath(
		// gm.readproperty_file("selectAdvisor)).sendKeys(ExcelUtils.getCellData(1,
		// 11));

		driver.findElement(By.xpath(gm.readproperty_file("selectAdvisor"))).click();
		driver.findElement(By.xpath(gm.readproperty_file("enterAdvisor"))).sendKeys(ExcelUtils.getCellData(1, 11));
		driver.findElement(By.xpath(gm.readproperty_file("enterAdvisor"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath(gm.readproperty_file("selectAppointmentType"))).click();
		driver.findElement(By.xpath(gm.readproperty_file("enterAppointmentType")))
				.sendKeys(ExcelUtils.getCellData(1, 0));
		driver.findElement(By.xpath(gm.readproperty_file("enterAppointmentType"))).sendKeys(Keys.ENTER);

		Thread.sleep(5000);
		String enteredadvisor = driver
				.findElement(By.xpath("//span[@id='select_placeholder_advisor']//following::span")).getText();
		String selectedappnmttype = driver
				.findElement(By.xpath("//span[@id='select_placeholder_appointment']//following::span")).getText();

		Assert.assertEquals(enteredadvisor, ExcelUtils.getCellData(1, 11));
		Assert.assertEquals(selectedappnmttype, ExcelUtils.getCellData(1, 0));

	}

	@Test(priority = 14, enabled = false, description = "Verify booked appointment are displayed in My Profile")
	public void vaidateTC_SBAA_098() throws Exception {
		extentTest = extent.startTest("vaidateTC_SBAA_098");
		logintostudentportal();

		// driver.switchTo().window(tabs.get(1));
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);
		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();

		driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointment"))).click();

		Thread.sleep(5000);
		// driver1.findElement(By.xpath(
		// gm.readproperty_file("selectAdvisor)).click();
		driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
				.sendKeys(ExcelUtils.getCellData(1, 31));
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(5000);
		// driver1.findElement(By.xpath(
		// gm.readproperty_file("selectAdvisor)).sendKeys(ExcelUtils.getCellData(1,
		// 11));

		// driver.findElement(By.xpath(gm.readproperty_file("selectAdvisor)).click();
		// driver.findElement(By.xpath(
		// gm.readproperty_file("enterAdvisor)).sendKeys(ExcelUtils.getCellData(2,
		// 11));
		// driver.findElement(By.xpath(gm.readproperty_file("enterAdvisor)).sendKeys(Keys.ENTER);
		// Thread.sleep(5000);
		driver.findElement(By.xpath(gm.readproperty_file("selectAppointmentType"))).click();
		driver.findElement(By.xpath(gm.readproperty_file("enterAppointmentType")))
				.sendKeys(ExcelUtils.getCellData(1, 0));
		driver.findElement(By.xpath(gm.readproperty_file("enterAppointmentType"))).sendKeys(Keys.ENTER);

		List<WebElement> availableslots = driver
				.findElements(By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end ng-scope']"));

		for (int i = 0; i < availableslots.size(); i++) {
			availableslots.get(i).click();
			break;
		}
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//div[@class='icheckbox_square-green']//following::ins")).click();
		// driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();

		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(" test ");
		driver.findElement(By.xpath("//input[@placeholder='Purpose of meeting']")).sendKeys(" test Purpose of meeting");

		driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(gm.readproperty_file("clickMyProfile"))).click();
		Thread.sleep(20000);

		// gm.Wait(gm.readproperty_file("clickAppointmentsTab);
		driver.findElement(By.xpath(gm.readproperty_file("clickAppointmentsTab"))).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[4]/div[1]/div/div[2]/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[1]/a"))
				.click();

		Thread.sleep(5000);
		String text = driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[3]/div[1]/div/div/div/ul/li[3]"))
				.getText();
		Assert.assertTrue(text.equalsIgnoreCase("Appointment details"));

	}

	@Test(priority = 15, enabled = false, description = "Verify staff is able to filter with advisor and appointment type")
	public void vaidateTC_BAA_077() throws Exception {

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		extentTest = extent.startTest("vaidateTC_BAA_077");

		gm.Wait("//*[@id='top_navigation_heading']");
		WebElement options = driver.findElement(By.xpath("//div[@class='sidebar-collapse']"));
//
		Actions act = new Actions(driver);
//	
		act.moveToElement(options).perform();
		Thread.sleep(10000);

		driver.findElement(By.xpath("(//span[contains(text(),'Calendar')])[1]")).click();

		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clickBookAppointmentoption"));

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
				.sendKeys(ExcelUtils.getCellData(1, 31));
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(5000);
		// driver1.findElement(By.xpath(
		// gm.readproperty_file("selectAdvisor)).sendKeys(ExcelUtils.getCellData(1,
		// 11));

		driver.findElement(By.xpath(gm.readproperty_file("selectAdvisor"))).click();
		driver.findElement(By.xpath(gm.readproperty_file("enterAdvisor"))).sendKeys(ExcelUtils.getCellData(1, 11));
		driver.findElement(By.xpath(gm.readproperty_file("enterAdvisor"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath(gm.readproperty_file("selectAppointmentType"))).click();
		driver.findElement(By.xpath(gm.readproperty_file("enterAppointmentType")))
				.sendKeys(ExcelUtils.getCellData(1, 0));
		driver.findElement(By.xpath(gm.readproperty_file("enterAppointmentType"))).sendKeys(Keys.ENTER);

		Thread.sleep(5000);
		String enteredadvisor = driver
				.findElement(By.xpath("//span[@id='select_placeholder_advisor']//following::span")).getText();
		String selectedappnmttype = driver
				.findElement(By.xpath("//span[@id='select_placeholder_appointment']//following::span")).getText();

		Assert.assertEquals(enteredadvisor, ExcelUtils.getCellData(1, 11));
		Assert.assertEquals(selectedappnmttype, ExcelUtils.getCellData(1, 0));
	}

	@Test(priority = 16, enabled = false, description = "Verify user able to register the student while scheduling the appointment")
	public void vaidateTC_APP_048() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_048");
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		gm.navigateToCalendarPage();
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));

		gm.click("Xpath", gm.readproperty_file("clickCreateAppnmt"));

		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("selectUserType"));
		Thread.sleep(3000);
		gm.SendKeys("Xpath", gm.readproperty_file("enterAppnmtUserType"), ExcelUtils.getCellData(1, 0));
		driver.findElement(By.xpath(gm.readproperty_file("enterAppnmtUserType"))).sendKeys(Keys.ENTER);
		gm.click("Xpath", gm.readproperty_file("clickBookAppoinmtWithUser"));
		// System.out.println("excel title" + ExcelUtils.getCellData(1, 7));
		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 7));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("selectPattern"));

		if (ExcelUtils.getCellData(1, 27).contains("single")) {
			gm.click("Xpath", gm.readproperty_file("selectSinglePattern"));
			Thread.sleep(3000);
			gm.click("Xpath", gm.readproperty_file("clickStartDate"));
			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 16));
			Thread.sleep(5000);
		}

		else if (ExcelUtils.getCellData(1, 27).contains("recurring")) {
			gm.click("Xpath", gm.readproperty_file("selectRecurringRegularPattern"));

			gm.click("Xpath", gm.readproperty_file("clickStartDate"));

			gm.selectDate(ExcelUtils.getCellData(1, 16));

			gm.click("Xpath", gm.readproperty_file("selectPatternEndDate"));
			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 17));
		}

		gm.click("Xpath", gm.readproperty_file("clickServiceDddl"));
		gm.SendKeys("Xpath", gm.readproperty_file("enterservicename"), ExcelUtils.getCellData(1, 31));
		driver.findElement(By.xpath(gm.readproperty_file("enterservicename"))).sendKeys(Keys.ENTER);
		// gm.uploadFile(gm.readproperty_file("uploadImage,
		// "C:\\Users\\HP\\Documents\\Engage2Serve Project Documents\\sample
		// images\\download__11__1.jpeg");

		// gm.click("Xpath", gm.readproperty_file("SelectSaveButtonFromPopupMessage);

		Thread.sleep(10000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		//
		WebElement button = driver.findElement(By.xpath(gm.readproperty_file("selectStartTime")));
		//
		js.executeScript("arguments[0].click();", button);
		Thread.sleep(5000);

		driver.findElement(By.xpath(gm.readproperty_file("sessionStartTimeHour")))
				.sendKeys(ExcelUtils.getCellData(1, 8));

		driver.findElement(By.xpath(gm.readproperty_file("sessionStartTimeHour"))).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		Boolean msg = driver.findElements(By.xpath(gm.readproperty_file("enterTimeGraterThanCurrentTime"))).size() > 0;

		if (msg == true) {
			enterTimeGreaterThanCurrentTimeValidation();

		}

		driver.findElement(By.xpath(gm.readproperty_file("clickSessionMinutesddl"))).click();

		driver.findElement(By.xpath(gm.readproperty_file("sessionStartTimeMins")))
				.sendKeys(ExcelUtils.getCellData(1, 9));

		driver.findElement(By.xpath(gm.readproperty_file("sessionStartTimeMins"))).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("selectCampusDdl"));
		Thread.sleep(5000);
		WebElement button7 = driver
				.findElement(By.xpath("//div[contains(text(),'" + ExcelUtils.getCellData(1, 6) + "')]"));
		Thread.sleep(3000);

		js.executeScript("arguments[0].click();", button7);
		// gm.click("Xpath", gm.readproperty_file("selectCampusValue);

		gm.click("Xpath", gm.readproperty_file("selectLocation"));
		gm.SendKeys("Xpath", gm.readproperty_file("enterLocationText"), ExcelUtils.getCellData(1, 1));
		driver.findElement(By.xpath(gm.readproperty_file("enterLocationText"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickSelectRoom"));

		gm.SendKeys("Xpath", gm.readproperty_file("enterRoomText"), ExcelUtils.getCellData(1, 3));

		driver.findElement(By.xpath(gm.readproperty_file("enterRoomText"))).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("selectUserTypeDdl"));
		Thread.sleep(3000);
		gm.SendKeys("Xpath", gm.readproperty_file("enterUserTypeval"), ExcelUtils.getCellData(1, 33));
		driver.findElement(By.xpath(gm.readproperty_file("enterUserTypeval"))).sendKeys(Keys.ENTER);

		gm.click("Xpath", gm.readproperty_file("selectStudentddl"));
		Thread.sleep(3000);
		gm.click("Xpath", "//div[contains(text(),'Aarathi A/P Manokaran / 74454061 / aarathimanokaran@yopmail.com')]");

		gm.click("Xpath", gm.readproperty_file("clickBookingInfoButton"));
		Thread.sleep(3000);

		gm.SendKeys("Xpath", gm.readproperty_file("enterSubjectval"), "test");
		gm.SendKeys("Xpath", gm.readproperty_file("enterPurposeOfMeetingval"), "test PurposeOfMeeting");

		gm.click("Xpath", gm.readproperty_file("clickSubmitbtn"));
		// appnmtCreationSuccessMsg

		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("ClickonSaveandPublishbutton"));

		Thread.sleep(5000);
		Boolean roomalreadybookedmsg = driver.findElements(By.xpath(gm.readproperty_file("enterDiffRoom"))).size() > 0;

		if (roomalreadybookedmsg == true) {
			Thread.sleep(5000);
			System.out.println("creating new room");
			createnewroom();

			gm.click("Xpath", gm.readproperty_file("ClickonSaveandPublishbutton"));
		}

		Thread.sleep(5000);

		Boolean anotherCalScheduledMsg = driver.findElements(By.xpath(gm.readproperty_file("anotherCalScheduledMsg")))
				.size() > 0;

		if (anotherCalScheduledMsg == true) {
			anotherCalendarScehduledinSameDurationValidation();
			gm.click("Xpath", gm.readproperty_file("ClickonSaveandPublishbutton"));

		}

		// Thread.sleep(5000);
		Boolean isPresent = driver.findElements(By.xpath(gm.readproperty_file("appnmtCreationSuccessMsg"))).size() > 0;
		Assert.assertTrue(isPresent);

	}

	@Test(priority = 17, enabled = false, description = "Verify slot duration option is not displayed If \"Book Appointment with user\" is enabled")
	public void vaidateTC_APP_049() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_049");

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));

		gm.click("Xpath", gm.readproperty_file("clickCreateAppnmt"));

		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("selectUserType"));
		Thread.sleep(3000);
		gm.SendKeys("Xpath", gm.readproperty_file("enterAppnmtUserType"), ExcelUtils.getCellData(1, 0));
		driver.findElement(By.xpath(gm.readproperty_file("enterAppnmtUserType"))).sendKeys(Keys.ENTER);
		gm.click("Xpath", gm.readproperty_file("clickBookAppoinmtWithUser"));

		Thread.sleep(5000);
		Boolean isdisplayed = driver.findElements(By.xpath(gm.readproperty_file("selectslotDuration"))).size() > 0;

		Assert.assertFalse("slot suration option is not disabeled", isdisplayed);

	}

	@Test(priority = 18, enabled = false, description = "Verify appointment status is changed as completed if appointment time is expired")
	public void vaidateTC_APP_043() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_043");

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCalendarPage();
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(5000);
		List<WebElement> availdates = driver.findElements(By.xpath(gm.readproperty_file("calendardates")));

		Iterator<WebElement> itr = availdates.iterator();

		while (itr.hasNext()) {
			WebElement element = itr.next();
			System.out.println("availdates" + element.getText());
			if (!(element.getText().equals("0"))) {

				element.click();
				Thread.sleep(5000);
				gm.click("Xpath", gm.readproperty_file("completedtab"));

				Thread.sleep(5000);
				WebElement completedappmnt = driver.findElement(By.xpath(gm.readproperty_file("completedappmnts")));

				System.out.println("inside completed tab");
				System.out.println(completedappmnt.getText());

				Assert.assertTrue("status of appointments are not displayed as completed",
						completedappmnt.getText().contains("Completed"));
				break;

			}
		}
	}

	@Test(priority = 19, enabled = false, description = "Verify by selecting the service all the upcoming available slots are displayed")
	public void vaidateTC_BAA_062() throws Exception {
		extentTest = extent.startTest("vaidateTC_BAA_062");
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		gm.Wait("//*[@id='top_navigation_heading']");
		WebElement options = driver.findElement(By.xpath("//div[@class='sidebar-collapse']"));
//
		Actions act = new Actions(driver);
//	
		act.moveToElement(options).perform();
		Thread.sleep(10000);

		driver.findElement(By.xpath("(//span[contains(text(),'Calendar')])[1]")).click();

		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clickBookAppointmentoption"));

		Thread.sleep(5000);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(" h:mm a");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
				.sendKeys(ExcelUtils.getCellData(1, 31));

		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(50000);
		List<WebElement> availslots = driver
				.findElements(By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end ng-scope']"));
		Thread.sleep(5000);
		Iterator<WebElement> itr = availslots.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			if (!((element.getText().contains(formattedDate)))) {

				System.out.println("available slots" + element.getText());
				System.out.println("the upcoming available slots are displayed");
			}

		}

	}

	@Test(priority = 20, enabled = false, description = "Verify slots are segregated accordingly on mentioned minutes with start & end time of appointment creation page")
	public void vaidateTC_APP_022() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_022");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();

		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(10000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		System.out.println("scheduledelements.size" + scheduledelements.size());

		Thread.sleep(10000);
		List<WebElement> appnmtdates = driver.findElements(By.xpath("//div[@class='drop-in-event-list-date']"));
		Thread.sleep(10000);
		System.out.println("appnmtdates.size" + appnmtdates.size());
		String timeStamp = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		String text = null;
		Thread.sleep(5000);
		if (scheduledelements.size() != 0) {
			for (int i = 0; i < scheduledelements.size(); i++) {

				if (!(appnmtdates.get(i).getText().contains(timeStamp))) {

					String appnmtname = scheduledelements.get(i).getText();

					Thread.sleep(5000);

					if ((appnmtname.contains("Appointment"))) {
						scheduledelements.get(i).click();

						gm.click("LinkText", "Appointment");

						gm.Wait(gm.readproperty_file("getStartTime"));
						String starttime = gm.getText("Xpath", gm.readproperty_file("getStartTime"));
						String endtime = gm.getText("Xpath", gm.readproperty_file("getEndTime"));

						gm.click("LinkText", "Slots");

						gm.Wait("//*[@id='tab-2']/div/div/div[1]/div[1]/div/div[2]/table/tbody/tr[1]/td[3]");
						String slotstarttime = gm.getText("Xpath",
								"//*[@id='tab-2']/div/div/div[1]/div[1]/div/div[2]/table/tbody/tr[1]/td[3]");
						String slotendtime = gm.getText("Xpath",
								"//*[@id='tab-2']/div/div/div[1]/div[6]/div/div[2]/table/tbody/tr[1]/td[3]");

						Assert.assertTrue("slots segregated contains start time", slotstarttime.contains(starttime));
						Assert.assertTrue("slots segregated contains end time", slotendtime.contains(endtime));
						break;
					}
				}
			}
		}

	}

	@Test(priority = 21, enabled = false, description = "Verify student is able to View the appointment history in the Action Track")
	public void vaidateTC_SBAA_102() throws Exception {
		extentTest = extent.startTest("vaidateTC_SBAA_102");
		logintostudentportal();
		Thread.sleep(5000);
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);
		driver.findElement(By.xpath(gm.readproperty_file("clickMyProfile"))).click();
		Thread.sleep(20000);

		// gm.Wait(gm.readproperty_file("clickAppointmentsTab);
		driver.findElement(By.xpath(gm.readproperty_file("clickAppointmentsTab"))).click();
		Thread.sleep(3000);
		// gm.scrollDown("//*[@id='page-wrapper']/div[2]/div[3]/div[4]/div[1]/div/div[2]/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[1]/a");
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[4]/div[1]/div/div[2]/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[1]/a"))
				.click();

		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("clickNotesHistory"));
		Thread.sleep(5000);
		List<WebElement> notescontents = driver.findElements(By.xpath(gm.readproperty_file("getNotesHistoryContents")));

		if (notescontents.size() == 0) {
			gm.click("Xpath", gm.readproperty_file("clickAddNotes"));
			gm.SendKeys("Xpath", gm.readproperty_file("addnotes"), ExcelUtils.getCellData(1, 35));

			gm.click("Xpath", gm.readproperty_file("clickSubmitbutton"));
		}

		Thread.sleep(5000);

		Iterator<WebElement> itr = notescontents.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			System.out.println("checking notes history");
			System.out.println("Excel value" + ExcelUtils.getCellData(1, 35));
			System.out.println(element.getText());
			Assert.assertTrue("advisor name is displayed", element.getText().contains(ExcelUtils.getCellData(1, 35)));
			break;
		}

	}

	@Test(priority = 22, enabled = false, description = "Verify draft mode appointments are not displayed in the calendar")
	public void vaidateTC_BAA_073() throws Exception {

		extentTest = extent.startTest("vaidateTC_BAA_073");
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		Thread.sleep(10000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));

		gm.click("Xpath", gm.readproperty_file("clickDraftsTab"));
		Thread.sleep(10000);
		List<WebElement> draftselements = driver.findElements(By.xpath("//span[@id='selected_campus_']"));
		Thread.sleep(5000);
		List<String> all_elements_text = new ArrayList<>();
		for (int i = 0; i < draftselements.size(); i++) {
			if (draftselements.size() > 0) {

				all_elements_text.add(draftselements.get(i).getText());
				System.out.println("inside if loop");
				// draftselements.get(i).click();
				Thread.sleep(5000);
			}

		}
		// gm.Wait("//*[@id='top_navigation_heading']");
		WebElement options = driver.findElement(By.xpath("//div[@class='sidebar-collapse']"));
//
		Actions act = new Actions(driver);
//	
		act.moveToElement(options).perform();
		Thread.sleep(10000);

		driver.findElement(By.xpath("(//span[contains(text(),'Calendar')])[1]")).click();

		Thread.sleep(3000);

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		//
		WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointmentoption")));
		//
		js4.executeScript("arguments[0].click();", button4);
		Thread.sleep(5000);

		List<WebElement> availservice = driver.findElements(By.xpath("//div[@class='applet-module-desc']"));

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
				.sendKeys(ExcelUtils.getCellData(1, 31));

		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(50000);
		List<WebElement> availslots = driver
				.findElements(By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end ng-scope']"));
		Thread.sleep(5000);

		for (int i = 0; i < availslots.size(); i++) {
			System.out.println("checking for drafts appointments");
			System.out.println(all_elements_text.get(i).toString());

			Assert.assertFalse("drafts appointments are displayed in calendar",
					availslots.get(i).getText().contains(all_elements_text.get(i).toString()));
			break;
		}

	}

	@Test(priority = 23, enabled = false, description = "Verify the past slots are not displayed when staff select the service")
	public void vaidateTC_BAA_063() throws Exception {

		extentTest = extent.startTest("vaidateTC_BAA_063");
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);
		gm.Wait("//*[@id='top_navigation_heading']");
		WebElement options = driver.findElement(By.xpath("//div[@class='sidebar-collapse']"));
//
		Actions act = new Actions(driver);
//	
		act.moveToElement(options).perform();
		Thread.sleep(10000);

		driver.findElement(By.xpath("(//span[contains(text(),'Calendar')])[1]")).click();

		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clickBookAppointmentoption"));

		Thread.sleep(5000);

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yy");

		String currentdate = sdf1.format(cal.getTime());
		cal.add(Calendar.DATE, -1);

		currentdate = sdf1.format(cal.getTime());

		System.out.println("past date " + currentdate);

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
				.sendKeys(ExcelUtils.getCellData(1, 31));

		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(50000);
		List<WebElement> availslots = driver
				.findElements(By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end ng-scope']"));
		Thread.sleep(10000);
		for (int i = 0; i < availslots.size(); i++) {
			System.out.println(availslots.get(i).getCssValue("border-color"));
			String hexacolor = Color.fromString(availslots.get(i).getCssValue("border-color")).asHex();

			System.out.println(hexacolor);
			if (hexacolor.equalsIgnoreCase("#89AC65")) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", availslots.get(i));

				Thread.sleep(20000);
				String text = driver.findElement(By.xpath("//*[@id='ng-app']/body/div[7]/div/div/div[2]/div[2]/div[2]"))
						.getText();
				System.out.println("slot time" + text);
				Assert.assertFalse(" past date slots are displayed", text.equals(currentdate));
				break;

			}
		}

	}

	@Test(priority = 24, enabled = false, description = "Verify the past slots are display when student select the service")
	public void vaidateTC_SBAA_084() throws Exception {

		extentTest = extent.startTest("vaidateTC_SBAA_084");
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		// Thread.sleep(5000);
		// gm.Wait("//*[@id='top_navigation_heading']");

		logintostudentportal();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();

		driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointment"))).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).sendKeys(" Nursing ");
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(gm.readproperty_file("selectAdvisor"))).click();
		driver.findElement(By.xpath(gm.readproperty_file("enterAdvisor"))).sendKeys(ExcelUtils.getCellData(1, 11));
		driver.findElement(By.xpath(gm.readproperty_file("enterAdvisor"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath(gm.readproperty_file("selectAppointmentType"))).click();
		driver.findElement(By.xpath(gm.readproperty_file("enterAppointmentType")))
				.sendKeys(ExcelUtils.getCellData(1, 0));
		driver.findElement(By.xpath(gm.readproperty_file("enterAppointmentType"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yy");

		String currentdate = sdf1.format(cal.getTime());
		cal.add(Calendar.DATE, -1);

		currentdate = sdf1.format(cal.getTime());

		System.out.println("past date " + currentdate);

		Thread.sleep(50000);
		List<WebElement> availslots = driver
				.findElements(By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end ng-scope']"));
		Thread.sleep(10000);
		for (int i = 0; i < availslots.size(); i++) {
			System.out.println(availslots.get(i).getCssValue("border-color"));
			String hexacolor = Color.fromString(availslots.get(i).getCssValue("border-color")).asHex();

			System.out.println(hexacolor);
			if (hexacolor.equalsIgnoreCase("#89AC65")) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", availslots.get(i));

				Thread.sleep(20000);
				String text = driver.findElement(By.xpath("//*[@id='create']/div/div[2]/form/div[1]/div/div[1]/div[2]"))
						.getText();
				System.out.println("slot time" + text);
				Assert.assertFalse(" past date slots are displayed", text.contains(currentdate));
				break;

			}
		}

	}

	@Test(priority = 25, enabled = false, description = "Verify by selecting the service all the upcoming available slots are displayed")
	public void vaidateTC_SBAA_083() throws Exception {
		extentTest = extent.startTest("vaidateTC_SBAA_083");
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		logintostudentportal();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();

		driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointment"))).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).sendKeys(" Nursing ");
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(gm.readproperty_file("selectAdvisor"))).click();
		driver.findElement(By.xpath(gm.readproperty_file("enterAdvisor"))).sendKeys(ExcelUtils.getCellData(1, 11));
		driver.findElement(By.xpath(gm.readproperty_file("enterAdvisor"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath(gm.readproperty_file("selectAppointmentType"))).click();
		driver.findElement(By.xpath(gm.readproperty_file("enterAppointmentType")))
				.sendKeys(ExcelUtils.getCellData(1, 0));
		driver.findElement(By.xpath(gm.readproperty_file("enterAppointmentType"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(" h:mm a");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);

		Thread.sleep(50000);
		List<WebElement> availslots = driver
				.findElements(By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end ng-scope']"));
		Thread.sleep(5000);
		Iterator<WebElement> itr = availslots.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			if (!((element.getText().contains(formattedDate)))) {

				System.out.println("available slots" + element.getText());
				System.out.println("the upcoming available slots are displayed");
				break;
			}

		}

	}

	@Test(priority = 26, enabled = false, description = "Verify draft mode appointments are not displayed in the calendar")
	public void vaidateTC_SBAA_092() throws Exception {

		extentTest = extent.startTest("vaidateTC_SBAA_092");
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		Thread.sleep(10000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));

		gm.click("Xpath", gm.readproperty_file("clickDraftsTab"));
		Thread.sleep(30000);
		List<WebElement> draftselements = driver.findElements(By.xpath("//span[@id='selected_campus_']"));
		Thread.sleep(5000);
		List<String> all_elements_text = new ArrayList<>();
		for (int i = 0; i < draftselements.size(); i++) {
			if (draftselements.size() > 0) {

				all_elements_text.add(draftselements.get(i).getText());
				System.out.println("inside if loop");
				// draftselements.get(i).click();
				Thread.sleep(5000);
			}

		}
		// gm.Wait("//*[@id='top_navigation_heading']");
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(30000);

		driver.get("https://qa-platform.engage2serve.com/");

		Thread.sleep(20000);
		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/a/span");
		Thread.sleep(3000);

		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/ul/li[2]/a/div");

		Thread.sleep(5000);
		logintostudentportal();

		// Thread.sleep(10000);

		gm.Wait(gm.readproperty_file("clickCalendarTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();

		// driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointment)).click();

		// Thread.sleep(5000);

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		//
		WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointment")));
		//
		js4.executeScript("arguments[0].click();", button4);
		Thread.sleep(5000);

		// List<WebElement> availservice =
		// driver.findElements(By.xpath("//div[@class='applet-module-desc']"));

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
				.sendKeys(ExcelUtils.getCellData(1, 31));

		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(50000);
		List<WebElement> availslots = driver
				.findElements(By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end ng-scope']"));
		Thread.sleep(5000);

		for (int i = 0; i < availslots.size(); i++) {
			System.out.println("checking for drafts appointments");
			System.out.println(all_elements_text.get(i).toString());

			Assert.assertFalse("drafts appointments are displayed in calendar",
					availslots.get(i).getText().contains(all_elements_text.get(i).toString()));
			break;
		}

	}

	@Test(priority = 27, enabled = false, description = "Verify student is able to click on the available slots and view details")
	public void vaidateTC_SBAA_085() throws Exception {
		extentTest = extent.startTest("vaidateTC_SBAA_085");
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		logintostudentportal();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();

		driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointment"))).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
				.sendKeys(ExcelUtils.getCellData(1, 31));
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(gm.readproperty_file("selectAdvisor"))).click();
		driver.findElement(By.xpath(gm.readproperty_file("enterAdvisor"))).sendKeys(ExcelUtils.getCellData(1, 11));
		driver.findElement(By.xpath(gm.readproperty_file("enterAdvisor"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath(gm.readproperty_file("selectAppointmentType"))).click();
		driver.findElement(By.xpath(gm.readproperty_file("enterAppointmentType")))
				.sendKeys(ExcelUtils.getCellData(1, 0));
		driver.findElement(By.xpath(gm.readproperty_file("enterAppointmentType"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		Thread.sleep(50000);
		List<WebElement> availslots = driver
				.findElements(By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end ng-scope']"));
		Thread.sleep(5000);

		for (int i = 0; i < availslots.size(); i++) {
			availslots.get(i).click();
			Thread.sleep(5000);
			Assert.assertTrue("service name is not displayed",
					driver.getPageSource().contains(ExcelUtils.getCellData(1, 31)));
			Assert.assertTrue("advisor name is not displayed",
					driver.getPageSource().contains(ExcelUtils.getCellData(2, 11)));
			Thread.sleep(3000);
			break;

		}

	}

	@Test(priority = 28, enabled = false, description = "Verify available seat count is decreased if user book an Appointment for a student")
	public void vaidateTC_APP_029() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_029");
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		// gm.navigateToConfigurationPage();
		// createNewCalendarService();
		// mapAdvisorInAssociateUsersTab();
		gm.click("Xpath", "//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(10000);

		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		Thread.sleep(15000);
		System.out.println(scheduledelements.size());

		if (!(scheduledelements.size() == 0)) {
			scheduledelements.get(0).click();

			Thread.sleep(5000);

			List<WebElement> slots = driver
					.findElements(By.xpath("//div[@class='calendar-session-info-box-container']"));

			for (int j = 1; j <= slots.size(); j++) {

				String status = driver
						.findElement(By.xpath(
								"(//div[@class='calendar-session-info-box-container'])[" + j + "]//following::td[15]"))
						.getText();
				System.out.println(status);

				if (status.equals("Scheduled")) {
					System.out.println("inside if loop");
					String availseats = gm.getText("Xpath",
							"(//div[@class='calendar-session-info-box-container'])[" + j + "]//following::td[12]");
					int avail = Integer.parseInt(availseats);

					gm.click("Xpath", "(//div[@class='calendar-session-info-box-container'])[" + j
							+ "]//following::div//button[2]");// -first slot- book button
					// gm.click("Xpath", gm.readproperty_file("clickBook);

					gm.Wait(gm.readproperty_file("selectUserType"));
					gm.click("Xpath", gm.readproperty_file("selectUserType"));

					// gm.click("Xpath", gm.readproperty_file("selectStudent);
					ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

					gm.SendKeys("Xpath", gm.readproperty_file("enterUserType"), ExcelUtils.getCellData(1, 18));
					driver.findElement(By.xpath(gm.readproperty_file("enterUserType"))).sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					gm.click("Xpath", gm.readproperty_file("selectStudent"));
					gm.SendKeys("Xpath", gm.readproperty_file("enterAlumni"), ExcelUtils.getCellData(1, 19));
					driver.findElement(By.xpath(gm.readproperty_file("enterAlumni"))).sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					System.out.println(ExcelUtils.getCellData(1, 21));
					gm.SendKeys("Xpath", gm.readproperty_file("enterSubject"), ExcelUtils.getCellData(1, 21));

					gm.SendKeys("Xpath", gm.readproperty_file("enterPurposeOfMeeting"), ExcelUtils.getCellData(1, 20));

					gm.click("Xpath", gm.readproperty_file("clickSubmit"));

					Thread.sleep(5000);
					String availseats1 = gm.getText("Xpath",
							"(//div[@class='calendar-session-info-box-container'])[" + j + "]//following::td[12]");
					int avail1 = Integer.parseInt(availseats1);

					Assert.assertTrue("available seat count is not decreased", avail > avail1);
				}

			}
		}
		// gm.click("Xpath", gm.readproperty_file("ClickonSaveandPublishbutton);

		else {
			CreateScheduledAppnmt();
			Thread.sleep(5000);
			String availseats = gm.getText("Xpath", gm.readproperty_file("getAvailableSlots"));
			int i = Integer.parseInt(availseats);

			BookAppointment();
			Thread.sleep(5000);
			String availseats1 = gm.getText("Xpath", gm.readproperty_file("getAvailableSlots"));
			int j = Integer.parseInt(availseats1);

			Assert.assertTrue("available seat count is not decreased", i > j);
		}

	}

	@Test(priority = 29, enabled = false, description = "Verify based on service configuration the available slots are displayed")
	public void vaidateTC_BAA_072() throws Exception {
		extentTest = extent.startTest("vaidateTC_BAA_072");
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		// gm.navigateToConfigurationPage();
		// createNewCalendarService();
		// mapAdvisorInAssociateUsersTab();
		gm.click("Xpath", "//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(10000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		Thread.sleep(3000);
		System.out.println("scheduledelements.size" + scheduledelements.size());

		Thread.sleep(5000);

		int slotsize = 0;
		for (int i = 0; i < scheduledelements.size(); i++) {

			List<WebElement> scheduledelements1 = driver
					.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));

			String appnmtname = scheduledelements1.get(i).getText();

			Thread.sleep(5000);
			scheduledelements.get(i).click();

			System.out.println("sch appnmt name" + scheduledelements1.get(i).getText());

			Thread.sleep(10000);
			gm.click("LinkText", "Appointment");

			String text = gm.getText("Xpath", gm.readproperty_file("getService"));
			System.out.println("title" + text);
			Thread.sleep(5000);

			if (text.equals(ExcelUtils.getCellData(1, 31))) {
				gm.click("LinkText", "Slots");
				Thread.sleep(5000);
				List<WebElement> slots = driver
						.findElements(By.xpath("//div[@class='calendar-session-info-box-container']"));

				System.out.println("slots size" + slots.size());

				int t = slots.size();

				slotsize = slotsize + t;

				JavascriptExecutor js5 = (JavascriptExecutor) driver;
				//
				WebElement button5 = driver
						.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[1]/div[1]/ol/li[1]/a"));
				//
				js5.executeScript("arguments[0].click();", button5);
				Thread.sleep(5000);

				// driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[1]/div[1]/ol/li[1]/a")).click();
				WebElement button6 = driver.findElement(By.xpath(gm.readproperty_file("clickAppointment")));
				//
				js5.executeScript("arguments[0].click();", button6);

				// gm.click("Xpath", gm.readproperty_file("clickAppointment"));

			}

		}

		Thread.sleep(5000);
		WebElement options = driver.findElement(By.xpath("//div[@class='sidebar-collapse']"));
		//
		Actions act = new Actions(driver);
		//
		act.moveToElement(options).perform();
		Thread.sleep(10000);

		driver.findElement(By.xpath("(//span[contains(text(),'Calendar')])[1]")).click();

		Thread.sleep(3000);

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		//
		WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointmentoption")));
		//
		js4.executeScript("arguments[0].click();", button4);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
				.sendKeys(ExcelUtils.getCellData(1, 31));
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();
		Thread.sleep(30000);

		List<WebElement> availslots = driver.findElements(By.xpath("//div[@class='fc-content']"));
		Thread.sleep(10000);
		System.out.println(slotsize);
		System.out.println(availslots.size());

		Assert.assertEquals("slot counts are not matching", availslots.size(), slotsize);

	}

	@Test(priority = 30, enabled = false, description = "Verify based on service configuration the available slots are displayed")
	public void vaidateTC_SBAA_091() throws Exception {
		extentTest = extent.startTest("vaidateTC_SBAA_091");
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.click("Xpath", "//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(10000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		Thread.sleep(3000);
		System.out.println("scheduledelements.size" + scheduledelements.size());
		int slotsize = 0;
		if (scheduledelements.size() == 0) {
			CreateScheduledAppnmt();
			Thread.sleep(5000);

			Thread.sleep(10000);
			gm.click("LinkText", "Appointment");

			String text = gm.getText("Xpath", gm.readproperty_file("getService"));
			System.out.println("title" + text);
			Thread.sleep(5000);

			if (text.equals(ExcelUtils.getCellData(1, 31))) {
				gm.click("LinkText", "Slots");
				Thread.sleep(5000);
				List<WebElement> slots = driver
						.findElements(By.xpath("//div[@class='calendar-session-info-box-container']"));

				System.out.println("slots size" + slots.size());

				int t = slots.size();

				slotsize = slotsize + t;

				JavascriptExecutor js5 = (JavascriptExecutor) driver;

				WebElement button5 = driver
						.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[1]/div[1]/ol/li[1]/a"));

				js5.executeScript("arguments[0].click();", button5);
				Thread.sleep(5000);

				WebElement button6 = driver.findElement(By.xpath(gm.readproperty_file("clickAppointment")));

				js5.executeScript("arguments[0].click();", button6);

			}

		}
		Thread.sleep(5000);

		if (!(scheduledelements.size() == 0)) {

			for (int i = 0; i < scheduledelements.size(); i++) {

				List<WebElement> scheduledelements2 = driver
						.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));

				String appnmtname = scheduledelements2.get(i).getText();

				Thread.sleep(5000);
				scheduledelements2.get(i).click();

				System.out.println("sch appnmt name" + scheduledelements2.get(i).getText());

				Thread.sleep(10000);
				gm.click("LinkText", "Appointment");

				String text1 = gm.getText("Xpath", gm.readproperty_file("getService"));
				System.out.println("title" + text1);
				Thread.sleep(5000);

				if (text1.equals(ExcelUtils.getCellData(1, 31))) {
					gm.click("LinkText", "Slots");
					Thread.sleep(5000);
					List<WebElement> slots = driver
							.findElements(By.xpath("//div[@class='calendar-session-info-box-container']"));

					System.out.println("slots size" + slots.size());

					int t = slots.size();

					slotsize = slotsize + t;

					JavascriptExecutor js5 = (JavascriptExecutor) driver;

					WebElement button5 = driver
							.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[1]/div[1]/ol/li[1]/a"));

					js5.executeScript("arguments[0].click();", button5);
					Thread.sleep(5000);

					WebElement button6 = driver.findElement(By.xpath(gm.readproperty_file("clickAppointment")));
					//
					js5.executeScript("arguments[0].click();", button6);

				}

			}
		}
		Thread.sleep(5000);

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(30000);

		driver.get("https://qa-platform.engage2serve.com/");

		Thread.sleep(20000);
		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/a/span");
		Thread.sleep(3000);

		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/ul/li[2]/a/div");

		Thread.sleep(5000);
		logintostudentportal();

		gm.Wait(gm.readproperty_file("clickCalendarTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		//
		WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointment")));
		//
		js4.executeScript("arguments[0].click();", button4);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
				.sendKeys(ExcelUtils.getCellData(1, 31));

		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(50000);
		List<WebElement> availslots = driver.findElements(By.xpath("//div[@class='fc-content']"));

		Thread.sleep(10000);
		System.out.println(slotsize);
		System.out.println(availslots.size());

		Assert.assertEquals("slot counts are not matching", availslots.size(), slotsize);

	}

	@Test(priority = 31, enabled = false, description = "Verify Staff is able to click on the available slots and view details")
	public void vaidateTC_BAA_064() throws Exception {
		extentTest = extent.startTest("vaidateTC_BAA_064");
		gm.Wait("//*[@id='top_navigation_heading']");
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		WebElement options = driver.findElement(By.xpath("//div[@class='sidebar-collapse']"));
//
		Actions act = new Actions(driver);
//	
		act.moveToElement(options).perform();
		Thread.sleep(10000);

		driver.findElement(By.xpath("(//span[contains(text(),'Calendar')])[1]")).click();

		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clickBookAppointmentoption"));

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
				.sendKeys(ExcelUtils.getCellData(1, 31));

		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(50000);
		List<WebElement> availslots = driver
				.findElements(By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end ng-scope']"));
		Thread.sleep(5000);
		for (int i = 0; i < availslots.size(); i++) {

			availslots.get(i).click();

			Assert.assertTrue("service name is not displayed",
					driver.getPageSource().contains(ExcelUtils.getCellData(1, 31)));
			Assert.assertTrue("advisor name is not displayed",
					driver.getPageSource().contains(ExcelUtils.getCellData(2, 11)));
			Thread.sleep(3000);
			break;

		}

	}

	@Test(priority = 32, enabled = false, description = "Verify cancelled appointment are display in the calendar")
	public void vaidateTC_SBAA_094() throws Exception {
		extentTest = extent.startTest("vaidateTC_SBAA_094");

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.click("Xpath", "//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(10000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		Thread.sleep(3000);
		System.out.println("scheduledelements.size" + scheduledelements.size());
		int slotsize = 0;

		CreateScheduledAppnmt();

		Thread.sleep(10000);
		gm.click("LinkText", "Appointment");

		String text = gm.getText("Xpath", gm.readproperty_file("getService"));
		System.out.println("title" + text);

		// gm.click("Xpath", gm.readproperty_file("ClickonSaveandPublishbutton);

		String newappnmtname = gm.getText("Xpath", gm.readproperty_file("enterTitle"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickCancelAppointment"));

		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		//
		WebElement button3 = driver.findElement(By.xpath(gm.readproperty_file("confirmApmntCancel")));
		//
		js3.executeScript("arguments[0].click();", button3);
		Thread.sleep(3000);

		Thread.sleep(5000);

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(30000);

		driver.get("https://qa-platform.engage2serve.com/");

		Thread.sleep(20000);
		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/a/span");
		Thread.sleep(3000);

		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/ul/li[2]/a/div");

		Thread.sleep(5000);
		logintostudentportal();

		gm.Wait(gm.readproperty_file("clickCalendarTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		//
		WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointment")));
		//
		js4.executeScript("arguments[0].click();", button4);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
				.sendKeys(ExcelUtils.getCellData(1, 31));

		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(50000);
		List<WebElement> availslots = driver.findElements(By.xpath("//div[@class='fc-content']"));

		for (int i = 0; i < availslots.size(); i++) {
			availslots.get(i).getText();
			System.out.println("student portal slots text" + availslots.get(i).getText());
			Assert.assertFalse("cancelled appointment is displayed in the calendar",
					availslots.contains(newappnmtname));

			break;
		}

	}

	@Test(priority = 33, enabled = false, description = "Verify cancelled appointment are displayed in the calendar")
	public void vaidateTC_BAA_075() throws Exception {
		extentTest = extent.startTest("vaidateTC_BAA_075");

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.click("Xpath", "//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(10000);

		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		//
		WebElement button5 = driver.findElement(By.xpath(gm.readproperty_file("clickCancelledTab")));
		//
		js5.executeScript("arguments[0].click();", button5);

		Thread.sleep(5000);
		// gm.click("Xpath", gm.readproperty_file("clickCancelledTab);
		List<WebElement> cancelledappointments = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));

		String text;

		String newappnmtname;

		System.out.println("cancelledappointments" + cancelledappointments.size());

		if (cancelledappointments.size() == 0) {
			CreateScheduledAppnmt();
			Thread.sleep(10000);
			gm.click("LinkText", "Appointment");

			text = gm.getText("Xpath", gm.readproperty_file("getService"));
			System.out.println("title" + text);

			newappnmtname = gm.getText("Xpath", gm.readproperty_file("enterTitle"));
			Thread.sleep(5000);
			gm.click("Xpath", gm.readproperty_file("clickCancelAppointment"));

			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			//
			WebElement button3 = driver.findElement(By.xpath(gm.readproperty_file("confirmApmntCancel")));
			//
			js3.executeScript("arguments[0].click();", button3);
			Thread.sleep(3000);

		}

		else {
			cancelledappointments.get(0).click();
			Thread.sleep(10000);
			gm.click("LinkText", "Appointment");

			text = gm.getText("Xpath", gm.readproperty_file("getService"));
			System.out.println("title" + text);

			// gm.click("Xpath", gm.readproperty_file("ClickonSaveandPublishbutton);

			newappnmtname = gm.getText("Xpath", gm.readproperty_file("enterTitle"));
			Thread.sleep(5000);

		}

		Thread.sleep(5000);
		WebElement options = driver.findElement(By.xpath("//div[@class='sidebar-collapse']"));
		//
		Actions act = new Actions(driver);
		//
		act.moveToElement(options).perform();
		Thread.sleep(10000);

		driver.findElement(By.xpath("(//span[contains(text(),'Calendar')])[1]")).click();

		Thread.sleep(3000);

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		//
		WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointmentoption")));
		//
		js4.executeScript("arguments[0].click();", button4);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).sendKeys(text);
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();
		Thread.sleep(30000);

		List<WebElement> availslots = driver.findElements(By.xpath("//div[@class='fc-content']"));
		for (int i = 0; i < availslots.size(); i++) {
			availslots.get(i).getText();
			System.out.println("staff portal slots text" + availslots.get(i).getText());
			Assert.assertFalse("cancelled appointment is displayed in the calendar",
					availslots.contains(newappnmtname));

			break;
		}

	}

	@Test(priority = 34, enabled = false, description = "Verify Deleted slots are displaying in the calendar")
	public void vaidateTC_SBAA_090() throws Exception {
		extentTest = extent.startTest("vaidateTC_SBAA_090");

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.click("Xpath", "//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(10000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		Thread.sleep(5000);
		System.out.println("scheduledelements.size" + scheduledelements.size());
		int slotsize = 0;

		CreateScheduledAppnmt();

		Thread.sleep(10000);
		gm.click("LinkText", "Appointment");
		Thread.sleep(5000);

		String newappnmtname = gm.getText("Xpath", gm.readproperty_file("enterTitle"));
		gm.click("LinkText", "Slots");
		Thread.sleep(5000);
		String datetime = driver
				.findElement(By.xpath("//*[@id='tab-2']/div/div/div[1]/div[1]/div/div[2]/table/tbody/tr[1]/td[3]"))
				.getText();

		gm.click("Xpath", "//*[@id='tab-2']/div/div/div[1]/div[2]/div/div[3]/div/span/button[1]");

		Thread.sleep(5000);
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		//
		WebElement button5 = driver.findElement(By.xpath("//span[contains(text(),'Confirm')]"));
		//
		js5.executeScript("arguments[0].click();", button5);

		Thread.sleep(5000);

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(30000);

		driver.get("https://qa-platform.engage2serve.com/");

		Thread.sleep(20000);
		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/a/span");
		Thread.sleep(3000);

		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/ul/li[2]/a/div");

		Thread.sleep(5000);
		logintostudentportal();

		gm.Wait(gm.readproperty_file("clickCalendarTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		//
		WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointment")));
		//
		js4.executeScript("arguments[0].click();", button4);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
				.sendKeys(ExcelUtils.getCellData(1, 31));

		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(5000);
		List<WebElement> availslots = driver.findElements(By.xpath("//div[@class='fc-content']"));

		List<WebElement> appmntnames = driver.findElements(By.xpath("//span[@class='fc-title']"));

		Thread.sleep(10000);

		System.out.println("availslots.size" + availslots.size());

		for (int i = 0; i <= availslots.size(); i++) {
			if (appmntnames.get(i).getText().contains(newappnmtname)) {
				System.out.println("inside if loop");
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", availslots.get(i));
				Thread.sleep(5000);
				String studappdate = driver
						.findElement(By.xpath("//*[@id='create']/div/div[2]/form/div[1]/div/div[1]/div[2]")).getText();

				Thread.sleep(3000);
				Assert.assertFalse(studappdate.contains(datetime));
				break;
			}
		}

	}

	@Test(priority = 34, enabled = false, description = "Verify staff is able to book an appointment along with the booking form from the slot tab")
	public void vaidateTC_APP_028() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_028");

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToConfigurationPage();
		Thread.sleep(10000);

		gm.click("Xpath", gm.readproperty_file("clickfeaturesetup"));

		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickCalendar"));
		Thread.sleep(5000);

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		//
		WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("clickFormsOption")));
		//
		js4.executeScript("arguments[0].click();", button4);
		Thread.sleep(5000);

		// gm.click("Xpath", gm.readproperty_file("clickFormsOption"));

		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickFormsFilter"));

		gm.click("Xpath", gm.readproperty_file("clickFormTypeDdl"));

		gm.click("Xpath", gm.readproperty_file("selectAppointmentFormType"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickApplyformtype"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("editFormType"));
		Thread.sleep(5000);

		gm.click("LinkText", "Custom fields");
		Thread.sleep(5000);
		String field1 = gm.getText("Xpath", gm.readproperty_file("customFormField1"));
		String field2 = gm.getText("Xpath", gm.readproperty_file("customFormField2"));
		String field3 = gm.getText("Xpath", gm.readproperty_file("customFormField3"));

		gm.click("Xpath", gm.readproperty_file("clickCalendarService"));
		gm.SendKeys("Xpath", gm.readproperty_file("searchService"), ExcelUtils.getCellData(1, 31));

		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("selectServiceValue"));
		Thread.sleep(5000);
		gm.click("Xpath", "//*[@id='lblCompleted2']/a");

		Thread.sleep(3000);

		gm.scrollToElement(gm.readproperty_file("enterBookingFormName"));

		String isdisplayed = gm.getText("Xpath", "//*[@id='bookingForm-Dropdown']/a/span[2]/span");

		// Assert.assertEquals(isdisplayed, "Request Form");

		if (!(isdisplayed.contains("Request Form"))) {
			gm.click("Xpath", "//*[@id='bookingForm-Dropdown']/a/span[2]/span");

			gm.SendKeys("Xpath", gm.readproperty_file("enterBookingFormName"), "Request Form");

			gm.click("Xpath", gm.readproperty_file("clickUpdateButon"));
		}

		Thread.sleep(5000);
		gm.click("Xpath", "//*[@id='top_navigation_heading']");
		Thread.sleep(5000);
		gm.navigateToCalendarPage();
		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(10000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		Thread.sleep(5000);
		System.out.println("scheduledelements.size" + scheduledelements.size());
		int slotsize = 0;

		CreateScheduledAppnmt();

		Thread.sleep(10000);
		// gm.click("LinkText", "Slots");

		gm.Wait(gm.readproperty_file("clickBook"));
		gm.click("Xpath", gm.readproperty_file("clickBook"));
		Thread.sleep(7000);
		Assert.assertTrue("booking form fields are not displayed", driver.getPageSource().contains(field1));
		Assert.assertTrue("booking form fields are not displayed", driver.getPageSource().contains(field1));
		Assert.assertTrue("booking form fields are not displayed", driver.getPageSource().contains(field1));

	}

	@Test(priority = 35, enabled = false, description = "Verify staff is able to link appointment with the previous appointment")
	public void vaidateTC_APP_053() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_053");

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);
		Thread.sleep(5000);
		gm.navigateToCalendarPage();
		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(10000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		Thread.sleep(5000);
		System.out.println("scheduledelements.size" + scheduledelements.size());

		if (scheduledelements.size() == 0) {
			CreateScheduledAppnmt();
		}

		else {
			scheduledelements.get(0).click();
			Thread.sleep(7000);

			boolean viewdetailbutton = driver.findElements(By.xpath(gm.readproperty_file("clickViewDetails")))
					.size() > 0;

			if (viewdetailbutton == true) {
				gm.click("Xpath", gm.readproperty_file("clickViewDetails"));
			}

			else {
				Thread.sleep(5000);

				BookAppointment();

				Thread.sleep(5000);

				gm.click("Xpath", gm.readproperty_file("clickViewDetails"));
			}

		}

		Thread.sleep(5000);

		gm.click("LinkText", gm.readproperty_file("clickLinkages"));

		gm.Wait(gm.readproperty_file("clickLinkAppointmentsButton"));

		gm.click("Xpath", gm.readproperty_file("clickLinkAppointmentsButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("searchAppnmtNum"), ExcelUtils.getCellData(1, 38));

		driver.findElement(By.xpath(gm.readproperty_file("searchAppnmtNum"))).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("selectAppmnt"));

		gm.click("Xpath", gm.readproperty_file("clickAdd"));

		gm.click("Xpath", gm.readproperty_file("clickLinkAppointments"));

		Thread.sleep(3000);

		boolean isdisplayed = gm.isDisplayed("Xpath", gm.readproperty_file("linkappointmentssuccessmsg"));

		Assert.assertTrue("message is not displayed after linking appointments", isdisplayed);

	}

	@Test(priority = 36, enabled = false, description = "Verify staff is able to link appointment with the ticket")
	public void vaidateTC_APP_052() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_052");
		gm.navigateToCalendarPage();
		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(10000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		Thread.sleep(5000);
		System.out.println("scheduledelements.size" + scheduledelements.size());

		if (scheduledelements.size() == 0) {
			CreateScheduledAppnmt();
		}

		else {
			scheduledelements.get(0).click();
			Thread.sleep(7000);

			boolean viewdetailbutton = driver.findElements(By.xpath(gm.readproperty_file("clickViewDetails")))
					.size() > 0;

			if (viewdetailbutton == true) {
				gm.click("Xpath", gm.readproperty_file("clickViewDetails"));
			}

			else {
				Thread.sleep(5000);

				BookAppointment();

				Thread.sleep(5000);

				gm.click("Xpath", gm.readproperty_file("clickViewDetails"));
			}

		}

		Thread.sleep(5000);

		gm.click("LinkText", gm.readproperty_file("clickLinkages"));
		gm.click("LinkText", gm.readproperty_file("clickTicketsTab"));

		gm.Wait(gm.readproperty_file("clickLinkTickets"));

		gm.click("Xpath", gm.readproperty_file("clickLinkTickets"));

		gm.SendKeys("Xpath", gm.readproperty_file("searchtickets"), ExcelUtils.getCellData(1, 37));

		driver.findElement(By.xpath(gm.readproperty_file("searchtickets"))).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("selectAppmnt"));

		gm.click("Xpath", gm.readproperty_file("clickAdd"));

		gm.click("Xpath", gm.readproperty_file("clicklinktickets"));

		Thread.sleep(3000);

		boolean isdisplayed = gm.isDisplayed("Xpath", gm.readproperty_file("ticketslinkedsuccessmsg"));

		Assert.assertTrue("message is not displayed after linking appointments", isdisplayed);

	}

	@Test(priority = 37, enabled = false, description = "Verify staff is able to mark attendance for the completed appointment")
	public void vaidateTC_APP_041() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_041");
		gm.navigateToCalendarPage();
		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));

		gm.click("Xpath", gm.readproperty_file("completedtab"));
		Thread.sleep(5000);

		List<WebElement> completedelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		System.out.println("completedelements.size" + completedelements.size());

		completedelements.get(0).click();
		Thread.sleep(5000);
		boolean viewdetailbutton = driver.findElements(By.xpath(gm.readproperty_file("clickViewDetails"))).size() > 0;

		if (viewdetailbutton == true) {
			gm.click("Xpath", gm.readproperty_file("clickViewDetails"));
		}

		else {
			Thread.sleep(5000);

			BookAppointment();

			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("clickViewDetails"));
		}

		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("clickattendancetab"));

		gm.SendKeys("Xpath", gm.readproperty_file("addnotesattendance"), "test notes");

		gm.click("Xpath", gm.readproperty_file("clicksubmit"));
		Thread.sleep(5000);

	}

	@Test(priority = 38, enabled = false, description = "Verify student is able to book an appointment with booking form")
	public void vaidateTC_SBAA_087() throws Exception {
		extentTest = extent.startTest("vaidateTC_SBAA_087");

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToConfigurationPage();
		Thread.sleep(10000);

		gm.click("Xpath", gm.readproperty_file("clickfeaturesetup"));

		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickCalendar"));
		Thread.sleep(5000);

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		//
		WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("clickFormsOption")));
		//
		js4.executeScript("arguments[0].click();", button4);
		Thread.sleep(5000);

		// gm.click("Xpath", gm.readproperty_file("clickFormsOption"));

		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickFormsFilter"));

		gm.click("Xpath", gm.readproperty_file("clickFormTypeDdl"));

		gm.click("Xpath", gm.readproperty_file("selectAppointmentFormType"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickApplyformtype"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("editFormType"));
		Thread.sleep(5000);

		gm.click("LinkText", "Custom fields");
		Thread.sleep(5000);
		String field1 = gm.getText("Xpath", gm.readproperty_file("customFormField1"));
		String field2 = gm.getText("Xpath", gm.readproperty_file("customFormField2"));
		String field3 = gm.getText("Xpath", gm.readproperty_file("customFormField3"));

		gm.click("Xpath", gm.readproperty_file("clickCalendarService"));
		gm.SendKeys("Xpath", gm.readproperty_file("searchService"), ExcelUtils.getCellData(1, 31));

		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("selectServiceValue"));
		Thread.sleep(5000);
		gm.click("Xpath", "//*[@id='lblCompleted2']/a");

		Thread.sleep(3000);

		gm.scrollToElement(gm.readproperty_file("enterBookingFormName"));

		String isdisplayed = gm.getText("Xpath", "//*[@id='bookingForm-Dropdown']/a/span[2]/span");

		// Assert.assertEquals(isdisplayed, "Request Form");

		if (!(isdisplayed.contains("Request Form"))) {
			gm.click("Xpath", "//*[@id='bookingForm-Dropdown']/a/span[2]/span");

			gm.SendKeys("Xpath", gm.readproperty_file("enterBookingFormName"), "Request Form");

			gm.click("Xpath", gm.readproperty_file("clickUpdateButon"));
		}

		Thread.sleep(5000);

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		driver.get("https://qa-platform.engage2serve.com/");

		Thread.sleep(20000);
		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/a/span");
		Thread.sleep(3000);

		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/ul/li[2]/a/div");

		Thread.sleep(5000);
		logintostudentportal();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();

		driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointment"))).click();

		Thread.sleep(5000);
		// driver1.findElement(By.xpath(
		// gm.readproperty_file("selectAdvisor)).click();
		driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
				.sendKeys(ExcelUtils.getCellData(1, 31));
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(3000);

		List<WebElement> availableslots = driver
				.findElements(By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end ng-scope']"));

		for (int i = 0; i < availableslots.size(); i++) {
			availableslots.get(i).click();
			break;
		}
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(" test ");
		driver.findElement(By.xpath("//input[@placeholder='Purpose of meeting']")).sendKeys(" test Purpose of meeting");
		driver.findElement(By.xpath(gm.readproperty_file("entercontactnum1"))).sendKeys(" test num1");
		driver.findElement(By.xpath(gm.readproperty_file("entercontactnum2"))).sendKeys(" test num 2");

		gm.click("Xpath", gm.readproperty_file("clickgroup1ddl"));

		driver.findElement(By.xpath(gm.readproperty_file("entergroup1val"))).sendKeys("1");
		driver.findElement(By.xpath(gm.readproperty_file("entergroup1val"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		driver.findElement(By.xpath(gm.readproperty_file("entersecondval"))).sendKeys("222");

		driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();

		Thread.sleep(5000);

	}

	@Test(priority = 39, enabled = false, description = "Verify student is able to book an appointment without booking form")
	public void vaidateTC_SBAA_086() throws Exception {
		extentTest = extent.startTest("vaidateTC_SBAA_086");

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToConfigurationPage();
		Thread.sleep(10000);

		gm.click("Xpath", gm.readproperty_file("clickfeaturesetup"));

		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickCalendar"));
		Thread.sleep(5000);

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		//
		WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("clickFormsOption")));
		//
		js4.executeScript("arguments[0].click();", button4);
		Thread.sleep(5000);

		// gm.click("Xpath", gm.readproperty_file("clickFormsOption"));

		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickFormsFilter"));

		gm.click("Xpath", gm.readproperty_file("clickFormTypeDdl"));

		gm.click("Xpath", gm.readproperty_file("selectAppointmentFormType"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickApplyformtype"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("editFormType"));
		Thread.sleep(5000);

		gm.click("LinkText", "Custom fields");
		Thread.sleep(5000);
		String field1 = gm.getText("Xpath", gm.readproperty_file("customFormField1"));
		String field2 = gm.getText("Xpath", gm.readproperty_file("customFormField2"));
		String field3 = gm.getText("Xpath", gm.readproperty_file("customFormField3"));

		gm.click("Xpath", gm.readproperty_file("clickCalendarService"));
		gm.SendKeys("Xpath", gm.readproperty_file("searchService"), ExcelUtils.getCellData(1, 31));

		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("selectServiceValue"));
		Thread.sleep(5000);
		gm.click("Xpath", "//*[@id='lblCompleted2']/a");

		Thread.sleep(3000);

		gm.scrollToElement(gm.readproperty_file("enterBookingFormName"));

		String isdisplayed = gm.getText("Xpath", "//*[@id='bookingForm-Dropdown']/a/span[2]/span");

		// Assert.assertEquals(isdisplayed, "Request Form");

		if (!(isdisplayed.contains("Request Form"))) {
			gm.click("Xpath", "//*[@id='bookingForm-Dropdown']/a/span[2]/span");

			gm.SendKeys("Xpath", gm.readproperty_file("enterBookingFormName"), "Request Form");

			gm.click("Xpath", gm.readproperty_file("clickUpdateButon"));
		}

		Thread.sleep(5000);

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		driver.get("https://qa-platform.engage2serve.com/");

		Thread.sleep(20000);
		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/a/span");
		Thread.sleep(3000);

		gm.click("Xpath", "//*[@id='page-wrapper']/div[1]/div[1]/nav/div/ul/li[6]/ul/li[2]/a/div");

		Thread.sleep(5000);
		logintostudentportal();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickCalendarTab"))).click();

		driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointment"))).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
				.sendKeys(ExcelUtils.getCellData(1, 31));
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
				.click();

		Thread.sleep(3000);

		List<WebElement> availableslots = driver
				.findElements(By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end ng-scope']"));

		for (int i = 0; i < availableslots.size(); i++) {
			availableslots.get(i).click();
			break;
		}
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(" test ");
		driver.findElement(By.xpath("//input[@placeholder='Purpose of meeting']")).sendKeys(" test Purpose of meeting");

		driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();

		Thread.sleep(5000);

	}

	@Test(priority = 40, enabled = false, description = "Verify staff is able to perform confirm arrival action when the appointment starts before one hour")
	public void vaidateTC_APP_040() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_040");

		gm.navigateToCalendarPage();
		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(10000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		Thread.sleep(5000);
		System.out.println("scheduledelements.size" + scheduledelements.size());

		if (scheduledelements.size() == 0) {
			CreateScheduledAppnmt();
		}

		else {
			scheduledelements.get(0).click();
			Thread.sleep(7000);

			boolean viewdetailbutton = driver.findElements(By.xpath(gm.readproperty_file("clickViewDetails")))
					.size() > 0;

			if (viewdetailbutton == true) {
				gm.click("Xpath", gm.readproperty_file("clickViewDetails"));
			}

			else {
				Thread.sleep(5000);

				BookAppointment();

				Thread.sleep(5000);

				gm.click("Xpath", gm.readproperty_file("clickViewDetails"));
			}

		}

		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("clickConfirmArrival"));

		gm.SendKeys("Xpath", gm.readproperty_file("confirmarrivalnotes"), "student's confirm arrival notes");
		gm.click("Xpath", gm.readproperty_file("clicksubmit"));
		Thread.sleep(5000);
		

	}

	@Test(priority = 41, enabled = false, description = "Verify user able to book different user with different slots")
	public void vaidateTC_APP_031() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_031");
		gm.navigateToCalendarPage();
		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(10000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		Thread.sleep(5000);
		System.out.println("scheduledelements.size" + scheduledelements.size());

		CreateScheduledAppnmt();

		Thread.sleep(5000);

		for (int i = 1; i <= 2; i++) {
			gm.Wait(gm.readproperty_file("clickBook"));

			// clicking slot book button
			gm.click("Xpath",
					"(//div[@class='calendar-session-info-box-container'])[" + i + "]//following::div//button[2]");

			gm.Wait(gm.readproperty_file("selectUserType"));
			gm.click("Xpath", gm.readproperty_file("selectUserType"));

			// gm.click("Xpath", gm.readproperty_file("selectStudent);
			ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

			gm.SendKeys("Xpath", gm.readproperty_file("enterUserType"), ExcelUtils.getCellData(i, 18));
			driver.findElement(By.xpath(gm.readproperty_file("enterUserType"))).sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			gm.click("Xpath", gm.readproperty_file("selectStudent"));

			gm.click("Xpath", "//div[contains(text(),'" + ExcelUtils.getCellData(i, 19) + "')]");
			Thread.sleep(5000);
			System.out.println(ExcelUtils.getCellData(1, 21));
			gm.SendKeys("Xpath", gm.readproperty_file("enterSubject"), ExcelUtils.getCellData(1, 21));

			gm.SendKeys("Xpath", gm.readproperty_file("enterPurposeOfMeeting"), ExcelUtils.getCellData(1, 20));
			Thread.sleep(5000);
			gm.click("Xpath", gm.readproperty_file("clickSubmit"));

			Thread.sleep(5000);

			gm.click("LinkText", "Slots");

			Thread.sleep(10000);
			// clicking view details button
			driver.findElement(By.xpath("//*[@id='tab-2']/div/div/div[1]/div[" + i + "]/div/div[3]/div/button"))
					.click();

			Thread.sleep(5000);

			String name = gm.getText("Xpath", "//table/tbody/tr/td[2]/table/tbody/tr[1]/td/span[1]");
			System.out.println(name);
			Thread.sleep(5000);
			Assert.assertTrue("given student/alumni name is not present in view details page",
					ExcelUtils.getCellData(i, 19).contains(name));

			gm.click("Xpath", "//*[@id='page-wrapper']/div[3]/div[1]/div[1]/ol/li[3]");
			Thread.sleep(5000);

		}

	}

	
	@Test(priority = 42, enabled = false, description = "Verify the booked appointment color change to orange")
	public void vaidateTC_BAA_068() throws Exception {
		extentTest = extent.startTest("vaidateTC_APP_031");
		gm.navigateToCalendarPage();
		gm.Wait(gm.readproperty_file("clickAppointment"));
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Thread.sleep(10000);
		List<WebElement> scheduledelements = driver
				.findElements(By.xpath("//a[@class='drop-in-event-list-name ng-scope']"));
		Thread.sleep(5000);
		System.out.println("scheduledelements.size" + scheduledelements.size());

		if(scheduledelements.size()==0)
		{
		CreateScheduledAppnmt();
		}
		
		Thread.sleep(5000);
		WebElement options = driver.findElement(By.xpath("//div[@class='sidebar-collapse']"));
		//
				Actions act = new Actions(driver);
		//	
				act.moveToElement(options).perform();
				Thread.sleep(10000);

				driver.findElement(By.xpath("(//span[contains(text(),'Calendar')])[1]")).click();

				Thread.sleep(3000);

				JavascriptExecutor js4 = (JavascriptExecutor) driver;
				//
				WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("clickBookAppointmentoption")));
				//
				js4.executeScript("arguments[0].click();", button4);
				Thread.sleep(5000);

				

				driver.findElement(By.xpath("//input[@placeholder='Select or search service']")).click();
				driver.findElement(By.xpath("//input[@placeholder='Select or search service']"))
						.sendKeys(ExcelUtils.getCellData(1, 31));

				Thread.sleep(5000);

		driver.findElement(By.xpath(
						"//*[@id='page-wrapper']/div[3]/div[2]/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5"))
						.click();

				Thread.sleep(50000);
		gm.click("Xpath", gm.readproperty_file("selectUserType"));
		gm.click("Xpath","//div[contains(text(),'Student')]");
		
		
		gm.click("Xpath", gm.readproperty_file("selectStudentddl"));
		
		Thread.sleep(3000);
		gm.click("Xpath", "//div[contains(text(),'Abdullah  . / M00434132 / Abdullah .@yopmail.com')]");
		//driver.findElement(By.xpath(gm.readproperty_file("enterStudentID"))).sendKeys(Keys.ENTER);
		
		gm.click("Xpath", gm.readproperty_file("selectAdvisor"));
		
		gm.SendKeys("Xpath", gm.readproperty_file("enterAdvisor"), ExcelUtils.getCellData(1, 11));
		driver.findElement(By.xpath(gm.readproperty_file("enterAdvisor"))).sendKeys(Keys.ENTER);
		
		gm.click("Xpath", gm.readproperty_file("selectAppointmentType"));
		
		gm.SendKeys("Xpath", gm.readproperty_file("enterAppointmentType"), ExcelUtils.getCellData(1, 0));
		driver.findElement(By.xpath(gm.readproperty_file("enterAppointmentType"))).sendKeys(Keys.ENTER);
		
		List<WebElement> availslots = driver
				.findElements(By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end ng-scope']"));
		Thread.sleep(5000);
		for (int i = 0; i < availslots.size(); i++) {
			
			String hexacolor = Color.fromString(availslots.get(i).getCssValue("border-color")).asHex();

			System.out.println(hexacolor);
			if (hexacolor.equalsIgnoreCase("#89AC65")) {

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", availslots.get(i));

				Thread.sleep(20000);
				
				gm.click("Xpath", gm.readproperty_file("clickagree"));
				gm.click("Xpath", gm.readproperty_file("appmnt-clickcontinue"));
				gm.SendKeys("Xpath", gm.readproperty_file("entersubject"), ExcelUtils.getCellData(1, 21));
				gm.SendKeys("Xpath", gm.readproperty_file("enterpurposeofmeeting"), ExcelUtils.getCellData(1, 20));
				
				gm.click("Xpath", gm.readproperty_file("clickSubmit"));
				Thread.sleep(10000);
				List<WebElement> availslots1 = driver
						.findElements(By.xpath("//a[@class='fc-day-grid-event fc-h-event fc-event fc-start fc-end ng-scope']"));
				String hexacolor1 = Color.fromString(availslots1.get(i).getCssValue("border-color")).asHex();
				Assert.assertTrue("booked slot colour not changed to orange", hexacolor1.equalsIgnoreCase("#DAA871"));
				break;
				
		}
		
		}
		
		
	}
	
	
	
	public void logintostudentportal() throws InterruptedException {
		driver.get("https://qa-platform.engage2serve.com/");

		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='usrnm']")));

		driver.findElement(By.xpath("//input[@name='usrnm']")).clear();

		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@name='usrnm']")).sendKeys("aarathimanokaran@yopmail.com");

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("demo");

		gm.Wait("//button[@type='submit']");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	public void enterTimeGreaterThanCurrentTimeValidation() throws InterruptedException, IOException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH");

		String currenttime = sdf1.format(cal.getTime());
		cal.add(Calendar.HOUR_OF_DAY, +1);

		currenttime = sdf1.format(cal.getTime());

		System.out.println("currenttime " + currenttime);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(By.xpath(gm.readproperty_file("selectStartTime")));

		js.executeScript("arguments[0].click();", button);
		Thread.sleep(5000);

		driver.findElement(By.xpath(gm.readproperty_file("sessionStartTimeHour"))).sendKeys(currenttime);

		driver.findElement(By.xpath(gm.readproperty_file("sessionStartTimeHour"))).sendKeys(Keys.ENTER);
	}

	public void mapAdvisorInAssociateUsersTab() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);
		gm.click("Xpath", gm.readproperty_file("clickfeaturesetup"));
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickCalendar"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clickCalendarService"));
		gm.click("Xpath", gm.readproperty_file("searchService"));

		gm.SendKeys("Xpath", gm.readproperty_file("searchService"), ExcelUtils.getCellData(1, 31));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("selectServiceValue"));
		Thread.sleep(3000);
		gm.click("LinkText", gm.readproperty_file("clickAssociateUsersTab"));
		Thread.sleep(3000);
		List<WebElement> advisorslist = driver.findElements(By.xpath("//div[@class='panel-body']/ul/li"));

		for (int i = 0; i < advisorslist.size(); i++) {
			if (!(advisorslist.get(i).getText().contains(ExcelUtils.getCellData(2, 11)))) {
				System.out.println(ExcelUtils.getCellData(2, 11));
				gm.SendKeys("Xpath", gm.readproperty_file("searchstaff"), ExcelUtils.getCellData(2, 11));
				driver.findElement(By.xpath(gm.readproperty_file("searchstaff"))).sendKeys(Keys.ENTER);
				Thread.sleep(3000);

				// Element which needs to drag.
				WebElement From = driver.findElement(By.xpath("(//div[@class='dragStatus'])[1]"));

				// Element on which need to drop.
				WebElement To = driver.findElement(By.xpath("(//div[@class='panel-body'])[2]"));

				// Using Action class for drag and drop.
				Actions act = new Actions(driver);
				Thread.sleep(3000);
				// Dragged and dropped.
				act.dragAndDrop(From, To).build().perform();
				gm.click("Xpath", gm.readproperty_file("clickUpdateButon"));
				Thread.sleep(3000);
				break;
			}
		}

	}

	public void createNewCalendarService() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);
		gm.click("Xpath", gm.readproperty_file("clickfeaturesetup"));
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickCalendar"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clickCalendarService"));
		gm.SendKeys("Xpath", gm.readproperty_file("enterCalServiceName"), ExcelUtils.getCellData(1, 31));
		gm.click("Xpath", gm.readproperty_file("selectAppnmtType"));

		gm.click("Xpath", "//div[contains(text(),'" + ExcelUtils.getCellData(1, 0) + "')]");

		Thread.sleep(3000);
		gm.click("LinkText", gm.readproperty_file("clickAssociateUsersTab"));
		Thread.sleep(3000);

		System.out.println(ExcelUtils.getCellData(1, 11));
		gm.SendKeys("Xpath", gm.readproperty_file("searchstaff"), ExcelUtils.getCellData(1, 11));
		driver.findElement(By.xpath(gm.readproperty_file("searchstaff"))).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		// Element which needs to drag.
		WebElement From = driver.findElement(By.xpath("(//div[@class='dragStatus'])[1]"));

		// Element on which need to drop.
		WebElement To = driver.findElement(By.xpath("(//div[@class='panel-body'])[2]"));

		// Using Action class for drag and drop.
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		// Dragged and dropped.
		act.dragAndDrop(From, To).build().perform();
		Thread.sleep(3000);

		gm.click("Xpath", "//span[@id='lblCompleted2']/a");
		gm.SendKeys("Xpath", "//input[@ng-disabled='prefix']", ExcelUtils.getCellData(1, 32));

		gm.click("Xpath", gm.readproperty_file("clickSaveButton"));
		Thread.sleep(5000);

	}

	public void anotherCalendarScehduledinSameDurationValidation() throws InterruptedException, IOException {
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		//
		WebElement button2 = driver.findElement(By.xpath(gm.readproperty_file("selectStartTime")));
		//
		js2.executeScript("arguments[0].click();", button2);
		Thread.sleep(5000);

		driver.findElement(By.xpath(gm.readproperty_file("sessionStartTimeHour")))
				.sendKeys(ExcelUtils.getCellData(1, 14));

		driver.findElement(By.xpath(gm.readproperty_file("sessionStartTimeHour"))).sendKeys(Keys.ENTER);

		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		WebElement button3 = driver.findElement(By.xpath(gm.readproperty_file("clickSessionMinutesddl")));

		js3.executeScript("arguments[0].click();", button3);
		Thread.sleep(5000);

		driver.findElement(By.xpath(gm.readproperty_file("sessionStartTimeMins")))
				.sendKeys(ExcelUtils.getCellData(1, 15));

		driver.findElement(By.xpath(gm.readproperty_file("sessionStartTimeMins"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("ClickonSaveandPublishbutton"));
	}

	public void navigateToAppointmentPage() throws InterruptedException, IOException {
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToCalendarPage();
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));
		Thread.sleep(10000);
	}

	public void BookAppointment() throws Exception {
		gm.Wait(gm.readproperty_file("clickBook"));
		gm.click("Xpath", gm.readproperty_file("clickBook"));

		gm.Wait(gm.readproperty_file("selectUserType"));
		gm.click("Xpath", gm.readproperty_file("selectUserType"));

		// gm.click("Xpath", gm.readproperty_file("selectStudent);
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		gm.SendKeys("Xpath", gm.readproperty_file("enterUserType"), ExcelUtils.getCellData(1, 18));
		driver.findElement(By.xpath(gm.readproperty_file("enterUserType"))).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("selectStudent"));
		gm.SendKeys("Xpath", gm.readproperty_file("enterAlumni"), ExcelUtils.getCellData(1, 19));
		driver.findElement(By.xpath(gm.readproperty_file("enterAlumni"))).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.println(ExcelUtils.getCellData(1, 21));
		gm.SendKeys("Xpath", gm.readproperty_file("enterSubject"), ExcelUtils.getCellData(1, 21));

		gm.SendKeys("Xpath", gm.readproperty_file("enterPurposeOfMeeting"), ExcelUtils.getCellData(1, 20));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickSubmit"));

		Thread.sleep(5000);
		// String text1 = gm.getText("Xpath", gm.readproperty_file("getStatus"));

		// Assert.assertTrue("status is not displayed as registered",
		// text1.contains("Registered"));
	}

	public void createnewroom() throws IOException, InterruptedException {
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickCreateRoomPlusButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("enterRoomName"), ExcelUtils.getCellData(1, 29));

		gm.SendKeys("Xpath", gm.readproperty_file("enterDesc"), ExcelUtils.getCellData(1, 4));
		gm.SendKeys("Xpath", gm.readproperty_file("enterCapacity"), ExcelUtils.getCellData(1, 5));

		gm.click("Xpath", gm.readproperty_file("clickCreateRoom"));
		Thread.sleep(3000);

		// gm.click("Xpath", gm.readproperty_file("clickSelectRoom);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		//
		WebElement button2 = driver.findElement(By.xpath(gm.readproperty_file("clickSelectRoom")));
		//
		js2.executeScript("arguments[0].click();", button2);

		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		//
		WebElement button3 = driver
				.findElement(By.xpath("//div[contains(text(),'" + ExcelUtils.getCellData(1, 29) + "')]"));
		//
		js3.executeScript("arguments[0].click();", button3);

		// gm.click("Xpath", "//div[contains(text(),'" + ExcelUtils.getCellData(1, 29) +
		// "')]");

		String roomname = gm.getText("Xpath", gm.readproperty_file("selectedRoomValue"));

		System.out.println("screen value" + roomname);

		Assert.assertTrue(roomname.contains(ExcelUtils.getCellData(1, 29)));
		Thread.sleep(3000);
	}

	public void verifysubmittedvaluesdropinappnmt() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);
		Thread.sleep(5000);

		String title = gm.getAttribute("Xpath", gm.readproperty_file("enterTitle"),"value");

		Assert.assertEquals(title, ExcelUtils.getCellData(1, 7));

		
		Thread.sleep(3000);
		
		String pattern=gm.getText("Xpath", gm.readproperty_file("getPattern"));
		Thread.sleep(3000);
		Assert.assertTrue(pattern.equalsIgnoreCase(ExcelUtils.getCellData(1, 27)));
		
		
		gm.scrollToElement(gm.readproperty_file("getStartTime"));
		Thread.sleep(5000);
		
		
		
		
		
		
		Thread.sleep(3000);
		Assert.assertEquals((gm.getText("Xpath", gm.readproperty_file("getStartTime"))),
				ExcelUtils.getCellData(1, 8));
		
		
		Thread.sleep(3000);
		//Assert.assertEquals((gm.getText("Xpath", gm.readproperty_file("getCampusValue"))),
				//ExcelUtils.getCellData(1, 6));
		Thread.sleep(3000);
		Assert.assertEquals((gm.getText("Xpath", gm.readproperty_file("getLocationValue"))),
				ExcelUtils.getCellData(1, 1));
		Thread.sleep(3000);
		Assert.assertTrue(gm.getText("Xpath", gm.readproperty_file("getRoomValue")).contains(ExcelUtils.getCellData(1, 3)));
		
		
		
		
		Thread.sleep(5000);
	}

	public void verifysubmittedvaluesscheduledappnmt() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		Assert.assertEquals(gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 7));

		Assert.assertTrue("pattern type entered is not matching the given pattern value ",
				gm.readproperty_file("getPattern").contains(ExcelUtils.getCellData(1, 27)));
		Assert.assertTrue("start date entered is not matching the given start date value ",
				gm.readproperty_file("getStartDate").contains(ExcelUtils.getCellData(1, 16)));
		Assert.assertTrue("end date entered is not matching the given end date value ",
				gm.readproperty_file("getendDate").contains(ExcelUtils.getCellData(1, 17)));

		Assert.assertEquals(gm.readproperty_file("sessionStartTimeMins"), ExcelUtils.getCellData(1, 9));

		Assert.assertEquals(gm.readproperty_file("getCampusValue"), ExcelUtils.getCellData(1, 6));
		Assert.assertEquals(gm.readproperty_file("getLocationValue"), ExcelUtils.getCellData(1, 1));
		Assert.assertEquals(gm.readproperty_file("getRoomValue"), ExcelUtils.getCellData(1, 3));
		Assert.assertEquals(gm.readproperty_file("getMaxAttendees"), ExcelUtils.getCellData(1, 5));

	}

	public void CreateScheduledAppnmt() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Appointment_TestData);

		// gm.navigateToCalendarPage();
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickAppointment"));

		gm.click("Xpath", gm.readproperty_file("clickCreateAppnmt"));

		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("selectAppmntType"));
		Thread.sleep(3000);

		System.out.println(ExcelUtils.getCellData(1, 0));
		gm.SendKeys("Xpath", gm.readproperty_file("enterAppnmtUserType"), ExcelUtils.getCellData(1, 0));
		Thread.sleep(3000);
		driver.findElement(By.xpath(gm.readproperty_file("enterAppnmtUserType"))).sendKeys(Keys.ENTER);

		// System.out.println("excel title" + ExcelUtils.getCellData(1, 7));
		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 7));
		Thread.sleep(3000);

		if (!(ExcelUtils.getCellData(1, 28).contains("Scheduled"))) {
			gm.SendKeys("Xpath", gm.readproperty_file("enterDescription1"), ExcelUtils.getCellData(1, 12));
		}

		gm.click("Xpath", gm.readproperty_file("selectPattern"));

		if (ExcelUtils.getCellData(1, 27).contains("single")) {
			gm.click("Xpath", gm.readproperty_file("selectSinglePattern"));
			gm.click("Xpath", gm.readproperty_file("selectDate"));
			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 16));
			Thread.sleep(5000);
		}

		else if (ExcelUtils.getCellData(1, 27).contains("recurring")) {
			gm.click("Xpath", gm.readproperty_file("selectRecurringRegularPattern"));

			gm.click("Xpath", gm.readproperty_file("selectDate"));

			gm.selectDate(ExcelUtils.getCellData(1, 16));

			gm.click("Xpath", gm.readproperty_file("selectPatternEndDate"));
			Thread.sleep(5000);
			gm.selectDate(ExcelUtils.getCellData(1, 17));
		}

		if (!(ExcelUtils.getCellData(1, 28).contains("Scheduled"))) {
			List<WebElement> weekdays = driver
					.findElements(By.xpath("//span[@ng-if='days.value >= dayStart &&  days.value <= dayEnd']"));

			for (int i = 0; i < weekdays.size(); i++) {
				// System.out.println(ExcelUtils.getCellData(1, 13));
				if (weekdays.get(i).getText().contains(ExcelUtils.getCellData(1, 13))) {
					driver.findElement(By.xpath("//input[@ng-model='days.checked']//following::ins")).click();

				}
				// System.out.println(weekdays.get(i).getText());

				else if (ExcelUtils.getCellData(1, 13).contains("All")) {
					driver.findElement(By.xpath("(//input[@ng-model='days.checked']//following::ins)[" + (i + 1) + "]"))
							.click();

				}

			}
		}

		gm.click("Xpath", gm.readproperty_file("clickServiceDddl"));
		gm.SendKeys("Xpath", gm.readproperty_file("enterservicename"), ExcelUtils.getCellData(1, 31));
		driver.findElement(By.xpath(gm.readproperty_file("enterservicename"))).sendKeys(Keys.ENTER);
		// gm.uploadFile(gm.readproperty_file("uploadImage,
		// "C:\\Users\\HP\\Documents\\Engage2Serve Project Documents\\sample
		// images\\download__11__1.jpeg");

		// gm.click("Xpath", gm.readproperty_file("SelectSaveButtonFromPopupMessage);

		Thread.sleep(10000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		//
		WebElement button = driver.findElement(By.xpath(gm.readproperty_file("selectStartTime")));
		//
		js.executeScript("arguments[0].click();", button);
		Thread.sleep(5000);

		if (!(ExcelUtils.getCellData(1, 28).contains("Scheduled"))) {
			gm.SendKeys("Xpath", gm.readproperty_file("enterSessionName"), ExcelUtils.getCellData(1, 10));
		}

		driver.findElement(By.xpath(gm.readproperty_file("sessionStartTimeHour")))
				.sendKeys(ExcelUtils.getCellData(1, 8));

		driver.findElement(By.xpath(gm.readproperty_file("sessionStartTimeHour"))).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		Boolean msg = driver.findElements(By.xpath(gm.readproperty_file("enterTimeGraterThanCurrentTime"))).size() > 0;

		if (msg == true) {
			enterTimeGreaterThanCurrentTimeValidation();

		}

		driver.findElement(By.xpath(gm.readproperty_file("clickSessionMinutesddl"))).click();

		driver.findElement(By.xpath(gm.readproperty_file("sessionStartTimeMins")))
				.sendKeys(ExcelUtils.getCellData(1, 9));

		driver.findElement(By.xpath(gm.readproperty_file("sessionStartTimeMins"))).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		// gm.click("Xpath", gm.readproperty_file("selectCampusDdl"));
		Thread.sleep(5000);
		// WebElement button7 = driver
		// .findElement(By.xpath("//div[contains(text(),'" + ExcelUtils.getCellData(1,
		// 6) + "')]"));
		// Thread.sleep(3000);

		// js.executeScript("arguments[0].click();", button7);
		// gm.click("Xpath", gm.readproperty_file("selectCampusValue);

		gm.click("Xpath", gm.readproperty_file("selectLocation"));
		gm.SendKeys("Xpath", gm.readproperty_file("enterLocationText"), ExcelUtils.getCellData(1, 1));
		driver.findElement(By.xpath(gm.readproperty_file("enterLocationText"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickSelectRoom"));

		gm.SendKeys("Xpath", gm.readproperty_file("enterRoomText"), ExcelUtils.getCellData(1, 3));

		driver.findElement(By.xpath(gm.readproperty_file("enterRoomText"))).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		if (!(ExcelUtils.getCellData(1, 28).contains("Scheduled"))) {
			gm.click("Xpath", gm.readproperty_file("clickAdvisorddl"));
			gm.SendKeys("Xpath", gm.readproperty_file("enterAdvisorName"), ExcelUtils.getCellData(2, 11));
			driver.findElement(By.xpath(gm.readproperty_file("enterAdvisorName"))).sendKeys(Keys.ENTER);

			gm.click("Xpath", gm.readproperty_file("addSession"));
			Thread.sleep(5000);
			Boolean message1 = driver.findElement(By.xpath(gm.readproperty_file("sessionCreatedSuccessMsg")))
					.isDisplayed();
			Assert.assertTrue(message1);
		}
		gm.click("Xpath", gm.readproperty_file("selectslotDuration"));
		gm.click("Xpath", gm.readproperty_file("selectThirtyMinutes"));

		gm.click("Xpath", gm.readproperty_file("ClickonSaveandPublishbutton"));
		Thread.sleep(5000);
		Boolean roomalreadybookedmsg = driver.findElements(By.xpath(gm.readproperty_file("enterDiffRoom"))).size() > 0;

		if (roomalreadybookedmsg == true) {
			Thread.sleep(5000);
			System.out.println("creating new room");
			createnewroom();
			/*
			 * System.out.println("changing lcoation"); JavascriptExecutor js5 =
			 * (JavascriptExecutor) driver; // WebElement button5 =
			 * driver.findElement(By.xpath(gm.readproperty_file("selectLocation));
			 * 
			 * 
			 * // js5.executeScript("arguments[0].click();", button5);
			 * 
			 * WebElement button7 = driver.findElement(By.xpath("//div[contains(text(),'" +
			 * ExcelUtils.getCellData(1, 30) + "')]")); Thread.sleep(3000);
			 * js5.executeScript("arguments[0].click();", button7);
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * Thread.sleep(5000); System.out.println("changing room"); JavascriptExecutor
			 * js6 = (JavascriptExecutor) driver; // WebElement button6 =
			 * driver.findElement(By.xpath(gm.readproperty_file("clickSelectRoom)); //
			 * js6.executeScript("arguments[0].click();", button6);
			 * 
			 * Thread.sleep(3000);
			 * 
			 * WebElement button8 = driver.findElement(By.xpath("//div[contains(text(),'" +
			 * ExcelUtils.getCellData(1, 29) + "')]")); //
			 * js6.executeScript("arguments[0].click();", button8);
			 * 
			 * 
			 * 
			 * Thread.sleep(5000);
			 */

			gm.click("Xpath", gm.readproperty_file("ClickonSaveandPublishbutton"));
		}

		Thread.sleep(7000);
		// gm.click("Xpath", gm.readproperty_file("ClickonSaveandPublishbutton);

		Boolean anotherCalScheduledMsg = driver.findElements(By.xpath(gm.readproperty_file("anotherCalScheduledMsg")))
				.size() > 0;

		if (anotherCalScheduledMsg == true) {
			anotherCalendarScehduledinSameDurationValidation();
			gm.click("Xpath", gm.readproperty_file("ClickonSaveandPublishbutton"));

		}

	}
}
