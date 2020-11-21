package Test;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.NotificationsCreationPage;
import Pages.NotificationsCreationPage.notificationpagelocators;
import Pages.NotificationsHomePage;
import utility.Constants;
import utility.ExcelUtils;
import utility.GenericMEthods;

public class NotificationTest extends FunctionalTest {

	LoginPage lp = new LoginPage();

	NotificationsHomePage nhp = new NotificationsHomePage();

	NotificationsCreationPage ncp = new NotificationsCreationPage();
	GenericMEthods gm = new GenericMEthods();

	@Test(priority = 1, enabled = false, description = "Verify validation error is displayed if logged in user clicks on \"Next\" button with entering only title")
	public void validateTC_N_003() throws Exception {
		extentTest = extent.startTest("validateTC_N_003");
		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		// gm.navigateToNotificationsHomePage();

		nhp.clickCreateNotification();

		if (driver.findElement(By.xpath(gm.readproperty_file("categoryddl"))).getAttribute("value") == null) {
			validateTC_N_011();
		}

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), "notif002");
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));
		Thread.sleep(3000);
		Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("lockScreenErrorMsg")),
				"Alert message is displayed for mandatory fields");

	}

	@Test(priority = 2, enabled = false, description = "Verify validation error is displayed if logged in user clicks on \"Next\" button with entering only lock screen message")
	public void validateTC_N_004() throws InterruptedException, IOException {
		extentTest = extent.startTest("validateTC_N_004");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToNotificationsHomePage();

		nhp.clickCreateNotification();

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), "test lock screen msg");

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		Thread.sleep(3000);

		Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("titleErrorMsg")),
				"Alert message is displayed for mandatory fields");

	}

	@Test(priority = 3, enabled = false, description = "Verify logged in user is able to create a category from notification")
	public void validateTC_N_011() throws Exception {
		extentTest = extent.startTest("validateTC_N_007");
		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToNotificationsHomePage();

		nhp.clickCreateNotification();

		gm.click("Xpath", gm.readproperty_file("createnewcategorybutton"));

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Notification_TestData);

		gm.SendKeys("Xpath", gm.readproperty_file("entercategoryname"), ExcelUtils.getCellData(1, 8));

		// gm.click("Xpath", gm.readproperty_file("selectimagebutton);

		gm.uploadFile(gm.readproperty_file("selectimagebutton"),
				"C:\\Users\\HP\\Documents\\Engage2Serve Project Documents\\sample images\\gujrat-university-results-declared.jpg");

		gm.click("Xpath", gm.readproperty_file("savenewcategorybutton"));

		Thread.sleep(5000);
		Assert.assertTrue(gm.getText("Xpath", gm.readproperty_file("categoryddl"))
				.equalsIgnoreCase(ExcelUtils.getCellData(1, 8)));

	}

	@Test(priority = 4, enabled = false, description = "Verify by default \"Student\" is selected as user type in the step 3")
	public void validateTC_N_017() throws InterruptedException, AWTException, IOException {
		extentTest = extent.startTest("validateTC_N_017");
		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToNotificationsHomePage();

		nhp.clickCreateNotification();

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), "notif002");

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), "test lock screen msg");

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), "test content msg");
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		Assert.assertTrue(gm.getText("Xpath", gm.readproperty_file("clickuserttypeddl")).equals("Alumni"));

	}

	@Test(priority = 5, enabled = false, description = "Verify logged in user is able to set delivery time as later")
	public void validateTC_N_015() throws InterruptedException, AWTException, IOException {
		extentTest = extent.startTest("validateTC_N_015");
		Thread.sleep(10000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToNotificationsHomePage();
		Thread.sleep(5000);
		nhp.clickCreateNotification();

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), "notif002");

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), "test lock screen msg");

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), "test content msg");
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clicklaterradiobutton"));
		Thread.sleep(5000);

		Assert.assertTrue(driver.findElement(By.xpath(gm.readproperty_file("clicklaterradiobutton"))).isEnabled(),
				"Later radio button is selected ");

	}

//	public void validateTC_N_017() throws InterruptedException, AWTException {
//		extentTest = extent.startTest("validateTC_N_017");
//		Thread.sleep(5000);
//		
//		gm.navigateToNotificationsHomePage();
//		
//		nhp.clickCreateNotification();
//		
//	
//		
//		
//		
//		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle, "notif002");
//		
//		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg, "test lock screen msg");
//
//		
//		gm.click("Xpath", gm.readproperty_file("clickNextButton);
//		
//		gm.SendKeys("Xpath", gm.readproperty_file("entercontent, "test content msg");
//		gm.click("Xpath", gm.readproperty_file("clickNextButton);
//		
//		gm.click("Xpath", gm.readproperty_file("clicklaterradiobutton);
//		
//		//gm.click("Xpath", gm.readproperty_file("clickdate);
//		
//		
//				Actions actions = new Actions(driver);
//				WebElement elementLocator = driver.findElement(By.xpath(gm.readproperty_file("clickdate));
//				elementLocator.click();
//				
//				Thread.sleep(3000);
//				
//				Date date=new Date();
//				
//				DateFormat sdf=new SimpleDateFormat("dd");
//				
//				String todaydate=sdf.format(date);
//				
//				
//				
//				driver.findElement(By.xpath("//td[@data-date='11' and @data-month='7']/div")).click();
//				
//				
//				
//				actions.doubleClick(elementLocator).perform();
//				DateFormat dateFormat = new SimpleDateFormat("dd");
//			    Calendar cal = Calendar.getInstance();
//			    cal.setTime(new Date());
//			    cal.add(Calendar.DATE, -2);
//			    
//			    
//			    String newDate = dateFormat.format(cal.getTime());
//			    
//			    //System.out.println(newDate);
//			    
//				//driver.findElement(By.xpath("//td[@data-date='11' and @data-month='7']/div")).click();
//
//			Boolean dateselected=driver.findElement(By.xpath("//td[@data-date='11' and @data-month='7']/div")).isSelected();
//				//Boolean dateisEnabled=driver.findElement(By.xpath("//td[@data-date='10' and @data-month='7']/div")).
//				
//			
//			String entereddate=driver.findElement(By.xpath("//div[@id='sDate']")).getText();
//			
//			String entereddate1=driver.findElement(By.xpath("//a[@id='startDate123']")).getText();
//			
//			
//				System.out.println(entereddate);
//				
//				System.out.println(entereddate1);
//				
//				//System.out.println(dateisEnabled);
//				
//		Thread.sleep(5000);
//	
//		
//		Assert.assertFalse(dateselected, "failed");
//		
//		//Assert.assertFalse(dateselected, "failed");
//		//Assert.assertTrue(text.isEmpty(), "past date is not enabeled ");
//		
//	}

	@Test(priority = 6, enabled = false, description = "Verify total number of recipients , mobile users & non mobile user are displayed in the step 3")
	public void validateTC_N_020() throws InterruptedException, AWTException, IOException {

		extentTest = extent.startTest("validateTC_N_020");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToNotificationsHomePage();

		nhp.clickCreateNotification();

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), "notif002");

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), "test lock screen msg");

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), "test content msg");
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.click("Xpath", gm.readproperty_file("clicklaterradiobutton"));
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("specificrecepientsoption"));

		gm.click("Xpath", gm.readproperty_file("recepientsbutton"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("selectrecepients"));

		gm.click("Xpath", gm.readproperty_file(""));
		Thread.sleep(5000);

		String totalrecepientscount = gm.getText("Xpath", gm.readproperty_file("totalrecepientscount"));
		String mobileuserscount = gm.getText("Xpath", gm.readproperty_file("mobileuserscount"));
		String nonmobileuserscount = gm.getText("Xpath", gm.readproperty_file("nonmobileuserscount"));

		Integer i = Integer.parseInt(totalrecepientscount);
		Integer j = Integer.parseInt(mobileuserscount);
		Integer k = Integer.parseInt(nonmobileuserscount);

		Assert.assertTrue(i > 0, "total recepient count is displayed");

		Assert.assertTrue(j > 0, "mobile users count is displayed");

		Assert.assertTrue(k > 0, "non mobile users count is displayed");

	}

	@Test(priority = 7, enabled = false, description = "Verify logged in user is able to view total recipients name with Login in when clicking on the total number count")
	public void validateTC_N_022() throws InterruptedException, AWTException, IOException {

		extentTest = extent.startTest("validateTC_N_022");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToNotificationsHomePage();

		nhp.clickCreateNotification();

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), "notif002");

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), "test lock screen msg");

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), "test content msg");
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.click("Xpath", gm.readproperty_file("clicklaterradiobutton"));
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("specificrecepientsoption"));

		gm.click("Xpath", gm.readproperty_file("recepientsbutton"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("selectrecepients"));

		gm.click("Xpath", gm.readproperty_file("clickinvitebutton"));
		Thread.sleep(5000);

		String totalrecepientscount = gm.getText("Xpath", gm.readproperty_file("totalrecepientscount"));

		gm.click("Xpath", gm.readproperty_file("totalrecepientscount"));

		Thread.sleep(5000);
		Integer i = Integer.parseInt(totalrecepientscount);
		List<String> list = new ArrayList<String>();

		List<WebElement> rows = driver
				.findElements(By.xpath("//table[@class='table table-striped  margin-bottom-0']/tbody/tr"));

		if (i > 0) {

			for (int l = 1; l <= rows.size(); l++) {
				// assert.assertEquals(actual, expected);
				list.add(gm.getText("Xpath",
						"//table[@class='table table-striped  margin-bottom-0']/tbody/tr[" + l + "]/td[1]"));

			}
		}

		Assert.assertTrue((list.size() == i), "users list is displayed after clicking on total recpeients count");

	}

	@Test(priority = 8, enabled = false, description = "Verify personas, groups & individuals are displayed in the recipient pop up window")
	public void validateTC_N_028() throws InterruptedException, AWTException, IOException {

		extentTest = extent.startTest("validateTC_N_028");

		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToNotificationsHomePage();

		nhp.clickCreateNotification();

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), "notif002");

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), "test lock screen msg");

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), "test content msg");
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.click("Xpath", gm.readproperty_file("clicklaterradiobutton"));
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("specificrecepientsoption"));

		gm.click("Xpath", gm.readproperty_file("recepientsbutton"));

		Thread.sleep(5000);

		Assert.assertTrue((gm.isDisplayed("Xpath", gm.readproperty_file("personastab"))), "personas tab is displayed");
		Assert.assertTrue((gm.isDisplayed("Xpath", gm.readproperty_file("groupsstab"))), "groups tab is displayed");
		Assert.assertTrue((gm.isDisplayed("Xpath", gm.readproperty_file("individualsstab"))),
				"individuals tab is displayed");

	}

	@Test(priority = 9, enabled = false, description = "Verify logged in user is able to invite personas of staff, Student when logged in user clicks on Personas tab")
	public void validateTC_N_030() throws InterruptedException, AWTException, IOException {

		extentTest = extent.startTest("validateTC_N_030");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToNotificationsHomePage();

		nhp.clickCreateNotification();

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), "notif002");

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), "test lock screen msg");

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), "test content msg");
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.click("Xpath", gm.readproperty_file("clicklaterradiobutton"));
		Thread.sleep(5000);

		List<String> list = new ArrayList<String>();

		String[] usertype = { "Staff", "Alumni" };

		for (int k = 0; k < usertype.length; k++) {

			gm.click("Xpath", gm.readproperty_file("specificrecepientsoption"));
			Thread.sleep(3000);

			gm.click("Xpath", gm.readproperty_file("clickuserttypeddl"));

			driver.findElement(By.xpath(gm.readproperty_file("enterusertype"))).clear();
			gm.SendKeys("Xpath", gm.readproperty_file("enterusertype"), usertype[k]);

			driver.findElement(By.xpath(gm.readproperty_file("enterusertype"))).sendKeys(Keys.ENTER);
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@id='clear_filters_confirm']")).click();
			Thread.sleep(5000);
			gm.click("Xpath", gm.readproperty_file("recepientsbutton"));

			Thread.sleep(3000);
			gm.click("Xpath", gm.readproperty_file("personastab"));

			Thread.sleep(5000);
			List<WebElement> countcolumnelements = driver.findElements(
					By.xpath("//table[@class='table margin-bottom-0 table-striped ng-scope']/tbody/tr/td[3]"));

			List<WebElement> rows = driver
					.findElements(By.xpath("//table[@class='table margin-bottom-0 table-striped ng-scope']/tbody/tr"));

			List<WebElement> personaelements = driver.findElements(
					By.xpath("//table[@class='table margin-bottom-0 table-striped ng-scope']/tbody/tr/td[2]"));

			List<WebElement> selectpersonaelements = driver.findElements(
					By.xpath("//table[@class='table margin-bottom-0 table-striped ng-scope']/tbody/tr/td[1]"));

			for (int i = 0; i <= countcolumnelements.size(); i++) {
				System.out.println("inside for loop");

				System.out.println(countcolumnelements.get(i).getText());

				if (!(countcolumnelements.get(i).getText().contains("0"))) {

					System.out.println("inside if loop");
					// driver.findElement(By.xpath("//table[@class='table margin-bottom-0
					// table-striped ng-scope']/tbody/tr["+i+"]/td[3]")).click();
					Thread.sleep(3000);
					selectpersonaelements.get(i).click();

					String j = countcolumnelements.get(i).getText();
					String clickedpersona = personaelements.get(i).getText();
					System.out.println("clicked persona name is " + personaelements.get(i).getText());

					gm.click("Xpath", gm.readproperty_file("clickinvitebutton"));

					String addedpersona = driver
							.findElement(By.xpath(
									"//span[@class='ui-select-match-item btn btn-default btn-xs ng-scope']//span[2]"))
							.getText();
					System.out.println("addedpersona " + addedpersona);
					Thread.sleep(5000);

					if ((addedpersona.contains(clickedpersona)) && (addedpersona.contains(j))) {
						System.out.println("selected persona is added and counts of users are matching");
						break;
					}

				}
			}

		}

	}

	@Test(priority = 10, enabled = false, description = "Verify logged in user is able to upload number of recipients using  Upload Recipients button")
	public void validateTC_N_033() throws Exception {

		extentTest = extent.startTest("validateTC_N_033");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToNotificationsHomePage();

		nhp.clickCreateNotification();

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), "notif002");

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), "test lock screen msg");

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), "test content msg");
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.click("Xpath", gm.readproperty_file("clicklaterradiobutton"));
		Thread.sleep(5000);
		String[] usertype = { "Staff", "Alumni" };
		String[] filepath = { "C:\\Users\\HP\\Desktop\\StaffData.csv", "C:\\Users\\HP\\Desktop\\AlumniData.csv" };

		for (int k = 0; k < usertype.length; k++) {
			gm.click("Xpath", gm.readproperty_file("specificrecepientsoption"));
			Thread.sleep(3000);

			gm.click("Xpath", gm.readproperty_file("clickuserttypeddl"));

			driver.findElement(By.xpath(gm.readproperty_file("enterusertype"))).clear();
			gm.SendKeys("Xpath", gm.readproperty_file("enterusertype"), usertype[k]);

			driver.findElement(By.xpath(gm.readproperty_file("enterusertype"))).sendKeys(Keys.ENTER);
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@id='clear_filters_confirm']")).click();
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("recepientsbutton"));

			Thread.sleep(3000);

			gm.click("Xpath", gm.readproperty_file("uploadrecepientstab"));

			ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Notification_TestData);

			gm.uploadFile(gm.readproperty_file("uploadcsvfilebutton"), filepath[k]);

			Thread.sleep(5000);
			System.out.println("screen value" + gm.getText("Xpath", gm.readproperty_file("totalusersuploaded")));

			System.out.println("excel input" + ExcelUtils.getCellData(1, 5));

			String usersfoundwithinsystem = gm.getText("Xpath", gm.readproperty_file("usersfoundwithinsystem"));

			Assert.assertEquals(gm.getText("Xpath", gm.readproperty_file("totalusersuploaded")),
					ExcelUtils.getCellData(1, 5));
			Assert.assertEquals(gm.getText("Xpath", gm.readproperty_file("usersfoundwithinsystem")),
					ExcelUtils.getCellData(1, 6));
			Assert.assertEquals(gm.getText("Xpath", gm.readproperty_file("usersnotfound")),
					ExcelUtils.getCellData(1, 7));
			// click continue button

			gm.click("Xpath", gm.readproperty_file("clickcontinuebutton"));

			String tabtext = gm.getText("Xpath", gm.readproperty_file("individualsstab"));

			gm.click("Xpath", gm.readproperty_file("clickinvitebutton"));

			Thread.sleep(3000);

			String invididualusersuploaded = driver.findElement(By.xpath(
					"//*[@id='page-wrapper']/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div/span/div[6]/div/div/div/div/span/span/span[2]"))
					.getText();

			Assert.assertTrue((invididualusersuploaded.contains(usersfoundwithinsystem)),
					"users are uploaded from csv");
		}

	}

	@Test(priority = 11, enabled = false, description = "Verify logged in user is able to edit any step using previous option")
	public void validateTC_N_040() throws Exception {

		extentTest = extent.startTest("validateTC_N_040");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToNotificationsHomePage();
		Thread.sleep(5000);
		driver.findElement(By.xpath(gm.readproperty_file("recepientssearch"))).sendKeys("Library Notifications");

		driver.findElement(By.xpath(gm.readproperty_file("recepientssearch"))).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(text(),'Library Notifications')]")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div/div[1]/div/div[2]/div/div/div[1]/form/div/div/a"))
				.click();

		Thread.sleep(3000);
		// nhp.clickCreateNotification();

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), "test notification8");

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), "test lock screen msg");

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), "test content msg");
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickuserttypeddl"));
		driver.findElement(By.xpath(gm.readproperty_file("enterusertype"))).clear();
		gm.SendKeys("Xpath", gm.readproperty_file("enterusertype"), "Staff");

		driver.findElement(By.xpath(gm.readproperty_file("enterusertype"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("clickPreviousButton"));

		driver.findElement(By.xpath(gm.readproperty_file("entercontent"))).clear();

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"),
				"editing content message after clicking previous button");

		String newcontentmsg = gm.getText("Xpath", gm.readproperty_file("entercontent"));

		Assert.assertEquals(newcontentmsg, "editing content message after clicking previous button",
				"content message is not updated after clicking previous button");

	}

//	@Test(priority = 12, enabled = false)
//	public void validateTC_N_045() throws Exception {
//		extentTest = extent.startTest("validateTC_N_045");
//		Thread.sleep(5000);
//		gm.Wait("//*[@id='top_navigation_heading']");
//		gm.navigateToNotificationsHomePage();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath(gm.readproperty_file("recepientssearch)).sendKeys("Library Notifications");
//
//		driver.findElement(By.xpath(gm.readproperty_file("recepientssearch)).sendKeys(Keys.ENTER);
//
//		Thread.sleep(3000);
//
//		driver.findElement(By.xpath("//a[contains(text(),'Library Notifications')]")).click();
//		
//		
//		gm.click("Xpath", gm.readproperty_file("clickfilterbutton);
//		
//		gm.click("Xpath", gm.readproperty_file("clickstatusddl);
//		
//		gm.click("Xpath", gm.readproperty_file("selectcompletedoption);
//		
//		
//		
//	}

	@Test(priority = 13, enabled = false, description = "Verify completed status is displayed if logged in user mention deliver date as now & completed scheduled time of notification")
	public void validateTC_N_046() throws Exception {

		extentTest = extent.startTest("validateTC_N_046");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToNotificationsHomePage();
		Thread.sleep(5000);
		driver.findElement(By.xpath(gm.readproperty_file("recepientssearch"))).sendKeys("Library Notifications");

		driver.findElement(By.xpath(gm.readproperty_file("recepientssearch"))).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(text(),'Library Notifications')]")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div/div[1]/div/div[2]/div/div/div[1]/form/div/div/a"))
				.click();

		Thread.sleep(3000);
		// nhp.clickCreateNotification();
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Notification_TestData);

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), "test lock screen msg");

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), "test content msg");
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("clickpublishbutton"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search by title']")).sendKeys("new announcement");
		driver.findElement(By.xpath("//input[@placeholder='Search by title']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String status = gm.getText("Xpath", "//table/tbody/tr/td[2]");

		Assert.assertEquals(status, "Completed", "notification status is not displayed as completed");

	}

	@Test(priority = 14, enabled = false, description = "Verify user able to enter title up to 50 characters")
	public void validateTC_N_005() throws Exception {

		extentTest = extent.startTest("validateTC_N_005");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		Thread.sleep(5000);

		nhp.clickCreateNotification();

		gm.validateMaxCharactersStep1(gm.readproperty_file("enterTitle"),
				"This is just a sample text to test the maximum char length", 50);

	}

	@Test(priority = 15, enabled = false, description = "Verify user not able to enter title more than 50 characters")
	public void validateTC_N_006() throws Exception {

		extentTest = extent.startTest("validateTC_N_006");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		Thread.sleep(5000);

		nhp.clickCreateNotification();

		gm.validateMaxCharactersStep1(gm.readproperty_file("enterTitle"),
				"This is just a sample text to test the maximum char length fifty", 50);

	}

	@Test(priority = 16, enabled = false, description = "Verify user able to enter lock screen message up to 200 characters")
	public void validateTC_N_007() throws Exception {

		extentTest = extent.startTest("validateTC_N_007");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		Thread.sleep(5000);

		nhp.clickCreateNotification();

		String lockscreeninput = "This is just a sample text to test the maximum char length of lock screen message to display lockscreen message in lock screen preview. This sample text will be reduced to 200 characters and will be displayed in mobile";

		gm.validateMaxCharactersStep1(gm.readproperty_file("enterLockScreenMsg"), lockscreeninput, 200);

	}

	@Test(priority = 17, enabled = false, description = "Verify user not able to enter lock screen more than 200 characters")
	public void validateTC_N_008() throws Exception {

		extentTest = extent.startTest("validateTC_N_008");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		Thread.sleep(5000);

		nhp.clickCreateNotification();

		String lockscreeninput = "This is just a sample text to test the maximum char length of lock screen message to display lockscreen message in lock screen preview. This sample text will be reduced to 200 characters and will be displayed in mobile testing";

		gm.validateMaxCharactersStep1(gm.readproperty_file("enterLockScreenMsg"), lockscreeninput, 200);

	}

	@Test(priority = 18, enabled = false, description = "Verify user not able to enter lock screen more than 200 characters")
	public void validateTC_N_013() throws Exception {

		extentTest = extent.startTest("validateTC_N_009");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		Thread.sleep(5000);

		nhp.clickCreateNotification();
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.ValidateStep1allFieldsBlank();

	}
	

	@Test(priority = 19, enabled = false, description = "Verify Lock screen preview is displayed if user click on \" Lock Screen Preview\"")
	public void validateTC_N_009() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Notification_TestData);

		extentTest = extent.startTest("validateTC_N_009");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		Thread.sleep(5000);

		nhp.clickCreateNotification();
		
		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), "test lock screen msg");
		
		//
		
		gm.click("Xpath", gm.readproperty_file("lockscreenpreviewbutton"));
		Thread.sleep(5000);

		Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("lockscreenpreviewimage")), "lock screen preview is not displayed");

	}
	
	@Test(priority = 20, enabled = false, description = "Verify entered title & lock screen message are displayed in the lock screen preview")
	public void validateTC_N_010() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Notification_TestData);

		extentTest = extent.startTest("validateTC_N_010");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		Thread.sleep(5000);
		
		nhp.clickCreateNotification();

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), ExcelUtils.getCellData(1, 16));
		
		//
		
		gm.click("Xpath", gm.readproperty_file("lockscreenpreviewbutton"));
		Thread.sleep(5000);
		
		Assert.assertEquals(gm.getText("Xpath", gm.readproperty_file("title-lockscreenpreview")),ExcelUtils.getCellData(1, 9) );
		Assert.assertEquals(gm.getText("Xpath", gm.readproperty_file("lockscreenmsg-lockscreenpreview")),ExcelUtils.getCellData(1, 16) );

		
	}
	
	@Test(priority = 21, enabled = false, description = "Verify logged in user is able to preview in mobile preview after entering contents in the step 2")
	public void validateTC_N_014() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Notification_TestData);

		extentTest = extent.startTest("validateTC_N_014");
		gm.Wait("//*[@id='top_navigation_heading']");
		Thread.sleep(5000);
		
		nhp.clickCreateNotification();

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), ExcelUtils.getCellData(1, 16));
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		
		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), ExcelUtils.getCellData(1, 17));
		//
		gm.click("Xpath", gm.readproperty_file("mobilepreviewbutton"));
		
		Thread.sleep(5000);
		
		Assert.assertEquals(gm.getText("Xpath", gm.readproperty_file("contents-mobilepreview")),ExcelUtils.getCellData(1, 17) );

	}
	
	@Test(priority = 21, enabled = false, description = "Verify staff not allowed to select the past date in publish date/time field")
	public void validateTC_N_018() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Notification_TestData);

		extentTest = extent.startTest("validateTC_N_018");
		gm.Wait("//*[@id='top_navigation_heading']");
		nhp.clickCreateNotification();

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), ExcelUtils.getCellData(1, 16));
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		
		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), ExcelUtils.getCellData(1, 17));
		
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));
		Thread.sleep(3000);
		
		gm.click("Xpath", gm.readproperty_file("clicklaterradiobutton"));
		
		gm.click("Xpath", gm.readproperty_file("clickdate"));
		Thread.sleep(3000);

		
		Boolean enabeled=driver
		.findElement(By.xpath("//td[@data-date='" + 21 + "' and @data-month='9']/div")).isSelected();
		
		Assert.assertFalse(enabeled, "given past date is enabeled ");
		//gm.selectDate("21");
		
		
	}
	
	@Test(priority = 22, enabled = true, description = "Verify count of total recipients, mobile user & non mobile user number is to be differed according to user type & recipients selection")
	public void validateTC_N_026() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Notification_TestData);

		extentTest = extent.startTest("validateTC_N_025");
		gm.Wait("//*[@id='top_navigation_heading']");
		nhp.clickCreateNotification();
		gm.Wait(gm.readproperty_file("enterTitle"));

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), ExcelUtils.getCellData(1, 16));
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		
		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), ExcelUtils.getCellData(1, 17));
		
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));
		Thread.sleep(5000);
		
		gm.click("Xpath", gm.readproperty_file("specificrecepientsoption"));

		gm.click("Xpath", gm.readproperty_file("recepientsbutton"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("selectallalumni"));
		gm.click("Xpath", gm.readproperty_file("clickinvitebutton"));

		//
		Thread.sleep(3000);
		//taking recepients count for alumni user type and persona recepients
		String totalrecepients=gm.getText("Xpath", gm.readproperty_file("totalrecepientscount"));
				
		String mobileusers=gm.getText("Xpath", gm.readproperty_file("mobileuserscount"));
		String nonmobileusers=gm.getText("Xpath", gm.readproperty_file("nonmobileuserscount"));
		gm.click("Xpath", gm.readproperty_file("specificrecepientsoption"));

		
		gm.click("Xpath", gm.readproperty_file("clickuserttypeddl"));
		gm.click("Xpath", "//div[contains(text(),'Staff')]");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("recepientsbutton"));
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("selectallalumni"));
		gm.click("Xpath", gm.readproperty_file("clickinvitebutton"));

		//
		Thread.sleep(3000);
		//taking recepients count for staff user type and persona recepients

		String totalrecepients1=gm.getText("Xpath", gm.readproperty_file("totalrecepientscount"));
		
		String mobileusers1=gm.getText("Xpath", gm.readproperty_file("mobileuserscount"));
		String nonmobileusers1=gm.getText("Xpath", gm.readproperty_file("nonmobileuserscount"));
		
		Assert.assertFalse(totalrecepients.contentEquals(totalrecepients1), "total recepients counts are not changed");
		Assert.assertFalse(mobileusers.contentEquals(mobileusers1), "mobile users counts are not changed");

		Assert.assertFalse(nonmobileusers.contentEquals(nonmobileusers1), "non mobile users counts are not changed");

		
	}
	
}
