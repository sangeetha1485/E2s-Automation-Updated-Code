package Test;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ServiceDesk;
import Pages.ServiceDesk.ServiceDesklocators;
import utility.Constants;
import utility.ExcelUtils;
import utility.GenericMEthods;

public class ServiceDeskTest extends FunctionalTest {

	ServiceDesk sd = new ServiceDesk();

	GenericMEthods gm = new GenericMEthods();

	@Test(priority = 1, enabled = false, description = "Verify user not able to create template without selecting Ticket category & template")
	public void vaidateTC_SD_020() throws InterruptedException {

		extentTest = extent.startTest("vaidateTC_SD_020");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		// gm.scrollDown("//li[@title='Configuration']/a/i");
		gm.scrollToElement("//li[@title='Configuration']/a/i");

		gm.navigateToServiceDeskConfigPage();

		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.clickfeaturesetup);

		gm.click("Xpath", ServiceDesklocators.featureticketoption);
		gm.click("Xpath", ServiceDesklocators.clicktickettemplateoption);
		gm.click("Xpath", ServiceDesklocators.createnewtemplate);

		Thread.sleep(5000);
		gm.SendKeys("Xpath", ServiceDesklocators.templatename, "testtemplate1");
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.selectpriority);
		gm.click("Xpath", ServiceDesklocators.selectnormalpriority);

		gm.SendKeys("Xpath", ServiceDesklocators.entersubject, "test");
		gm.SendKeys("Xpath", ServiceDesklocators.enterdescvalue, "test");

		gm.scrollDown(ServiceDesklocators.cliccreate);
		gm.click("Xpath", ServiceDesklocators.cliccreate);

		Thread.sleep(3000);
		Boolean errormsg = gm.isDisplayed("Xpath", "//div[contains(text(),'Please select ticket category')]");

		Assert.assertTrue(errormsg);
	}

	@Test(priority = 2, enabled = false, description = "Verify category is selected if template is selected for the ticket in create page")
	public void vaidateTC_SD_023() throws InterruptedException {

		extentTest = extent.startTest("vaidateTC_SD_023");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		// gm.scrollDown("//li[@title='Configuration']/a/i");
		gm.scrollToElement("//li[@title='Configuration']/a/i");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(3000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(3000);
		Boolean categorydisplayed = gm.isDisplayed("Xpath", ServiceDesklocators.selectedcategory);
		Assert.assertTrue(categorydisplayed);

	}

	@Test(priority = 3, enabled = false, description = "Verify user not able to create ticket without selecting Priority")
	public void vaidateTC_SD_028() throws InterruptedException {

		extentTest = extent.startTest("vaidateTC_SD_023");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		// gm.scrollDown("//li[@title='Configuration']/a/i");
		gm.scrollToElement("//li[@title='Configuration']/a/i");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(3000);
//		gm.click("Xpath", ServiceDesklocators.addremainder);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		WebElement button = driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span"));
//
//		js.executeScript("arguments[0].click();", button);
//
//		// driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span")).click();
//
//		
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@id='sdate1']")).click();
//		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='selPriority']/a/abbr")).click();
		gm.click("Xpath", ServiceDesklocators.cliccreatandcontinue);
		Thread.sleep(3000);

		Boolean alertdisplayed = gm.isDisplayed("Xpath", "//div[contains(text(),'Please select priority')]");
		Assert.assertTrue(alertdisplayed);

	}

	@Test(priority = 5, enabled = false, description = "Verify by default service is selected for Ticket type in ticket creation page")
	public void vaidateTC_SD_030() throws InterruptedException {

		extentTest = extent.startTest("vaidateTC_SD_030");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		// gm.scrollDown("//li[@title='Configuration']/a/i");
		gm.scrollToElement("//li[@title='Configuration']/a/i");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(3000);

		Boolean ischecked = driver.findElement(By.xpath(ServiceDesklocators.servicetickettype)).isSelected();

		Assert.assertTrue(ischecked);
	}

	@Test(priority = 6, enabled = false, description = "Verify user able to change the ticket type as Grouped in ticket creation page")
	public void vaidateTC_SD_031() throws InterruptedException {

		extentTest = extent.startTest("vaidateTC_SD_031");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		// gm.scrollDown("//li[@title='Configuration']/a/i");
		gm.scrollToElement("//li[@title='Configuration']/a/i");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='iradio_square-green']")).click();

		// gm.click("Xpath", ServiceDesklocators.grouptickettype);
		Thread.sleep(3000);
		Boolean ischecked = driver.findElement(By.xpath(ServiceDesklocators.grouptickettype)).isSelected();

		Assert.assertTrue(ischecked);
	}

	@Test(priority = 7, enabled = false, description = "Verify user able to change the Priority from the ticket creation page after selecting the category")
	public void vaidateTC_SD_033() throws InterruptedException {

		extentTest = extent.startTest("vaidateTC_SD_033");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		// gm.scrollDown("//li[@title='Configuration']/a/i");
		gm.scrollToElement("//li[@title='Configuration']/a/i");

		gm.navigateToServiceDeskConfigPage();
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.clickfeaturesetup);

		gm.click("Xpath", ServiceDesklocators.featureticketoption);
		gm.click("Xpath", ServiceDesklocators.ticketcategories);
		Thread.sleep(5000);
		gm.SendKeys("Xpath", ServiceDesklocators.searchcategory, "ticket wellbeing");
		gm.click("Xpath", ServiceDesklocators.selectcategory);
		Thread.sleep(3000);
		String defaultpriority = gm.getText("Xpath", ServiceDesklocators.defaultpriority);
		System.out.println("defaultpriority" + defaultpriority);
		driver.findElement(By.xpath("//span[@id='top_navigation_heading']")).click();
		Thread.sleep(5000);
		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(3000);
		String categorydisplayed = gm.getText("Xpath", ServiceDesklocators.selectedcategory);

		System.out.println(categorydisplayed);

		String selpriority = driver
				.findElement(By.xpath("//span[contains(text(),'Select or search priority')]//following::span[2]"))
				.getText();

		// String selpriority=gm.getText("Xpath", ServiceDesklocators.selectpriority);
		System.out.println("selpriority" + selpriority);
		Assert.assertEquals(selpriority, defaultpriority, "selected and default priority values are not same");

	}

	@Test(priority = 8, enabled = false, description = "Verify user able to change the Priority from the ticket creation page after selecting the category")
	public void vaidateTC_SD_035() throws InterruptedException {

		extentTest = extent.startTest("vaidateTC_SD_035");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		// gm.scrollDown("//li[@title='Configuration']/a/i");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(3000);
		String selpriority = driver
				.findElement(By.xpath("//span[contains(text(),'Select or search priority')]//following::span[2]"))
				.getText();

		gm.click("Xpath", ServiceDesklocators.selectpriority);

		gm.click("Xpath", ServiceDesklocators.selecthighpriority);
		Thread.sleep(3000);
		String priority = driver
				.findElement(By.xpath("//span[contains(text(),'Select or search priority')]//following::span[2]"))
				.getText();

		Assert.assertNotEquals(selpriority, priority, "priority value is not changed");

	}

	@Test(priority = 9, enabled = false, description = "Verify user able to attach allowed file formats for the Tickets")
	public void vaidateTC_SD_036() throws InterruptedException, AWTException {

		extentTest = extent.startTest("vaidateTC_SD_036");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(3000);

		// gm.click("Xpath", ServiceDesklocators.attachfiles);
		gm.scrollToElement(ServiceDesklocators.attachfiles);
		gm.uploadFile(ServiceDesklocators.attachfiles,
				"C:\\Users\\HP\\Documents\\Engage2Serve Project Documents\\sample images\\download__11__1.jpeg");
		gm.uploadFile(ServiceDesklocators.attachfiles, "C:\\Users\\HP\\Desktop\\Book3.xlsx");

		String file1 = driver.findElement(By.xpath("//div[@class='calendar-wizard-table']/table/tbody/tr/td[1]"))
				.getText();
		String file2 = driver.findElement(By.xpath("//div[@class='calendar-wizard-table']/table/tbody/tr[2]/td[1]"))
				.getText();

		Assert.assertTrue(file1.contains(".jpeg"), "jpeg file is not uploaded");

		Assert.assertTrue(file2.contains(".xlsx"), "xlsx file is not uploaded");

	}

	@Test(priority = 10, enabled = false, description = "Verify user not able to upload file size more than given at ticket creation page")
	public void vaidateTC_SD_037() throws InterruptedException, AWTException {

		extentTest = extent.startTest("vaidateTC_SD_037");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(3000);

		gm.uploadFile(ServiceDesklocators.attachfiles,
				"C:\\Users\\HP\\Documents\\Engage2Serve Project Documents\\sample images\\cambridge.jpg");

		Boolean alertdisplayed = gm.isDisplayed("Xpath", "//div[contains(text(),'Please upload file less than 1MB')]");
		Assert.assertTrue(alertdisplayed);

	}

	@Test(priority = 11, enabled = false, description = "Verify user able to create a ticket by click on 'Create' button")
	public void vaidateTC_SD_040() throws Exception {

		extentTest = extent.startTest("vaidateTC_SD_040");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(3000);

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.File_TestData);

		Thread.sleep(3000);

//		WebElement options = driver.findElement(By.xpath("//a[@placeholder='Search by Name, ID or Email ID']"));
//		//
//		Actions act = new Actions(driver);
//		//
//		
//		act.moveToElement(options).click();
//		act.moveToElement(options).sendKeys(ExcelUtils.getCellData1(1, 11)).perform();
//		act.moveToElement(options).sendKeys(Keys.ENTER).perform();

		driver.findElement(By.xpath("//a[@placeholder='Search by Name, ID or Email ID']")).click();

		driver.findElement(By.xpath("//input[@id='ui_select_search_input_ID']"))
				.sendKeys(ExcelUtils.getCellData1(1, 11));
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_ID']")).sendKeys(Keys.ENTER);

		gm.click("Xpath", ServiceDesklocators.clickaddnotes);
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement button = driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span"));

		js.executeScript("arguments[0].click();", button);

		// driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span")).click();

		Thread.sleep(3000);

		gm.scrollToElement("//div[@id='note1']/div[2]/div[4]/div[3]");

		gm.SendKeys("Xpath", "//div[@id='note1']/div[2]/div[4]/div[3]", "test notes.");

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.cliccreatandcontinue);
		Thread.sleep(5000);
		String message = driver.findElement(By.xpath("//*[@id='ng-app']/body/div[6]/div/div[1]")).getText();

		Assert.assertTrue(message.contains("created successfully"));

	}

	@Test(priority = 12, enabled = false, description = "Verify user able to transfer the created ticket to other staff")
	public void vaidateTC_SD_067() throws Exception {

		extentTest = extent.startTest("vaidateTC_SD_067");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(3000);

		gm.click("Xpath", ServiceDesklocators.clicktransfer);

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement button = driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span"));

		js.executeScript("arguments[0].click();", button);

		// driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span")).click();

		Thread.sleep(3000);

		gm.click("Xpath", ServiceDesklocators.selectcampus);

		driver.findElement(By.xpath("//input[@id='ui_select_search_input_campus']")).sendKeys("Sunderland Campus");
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_campus']")).sendKeys(Keys.ENTER);

		gm.click("Xpath", ServiceDesklocators.selectdept);
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_department']"))
				.sendKeys("Finance Support Sundarland");
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_department']")).sendKeys(Keys.ENTER);

		gm.click("Xpath", ServiceDesklocators.selectteam);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_team']"))
				.sendKeys("Fund Management Sundarland");
//		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_team']")).sendKeys(Keys.ENTER);
//		Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(10000);

		// gm.click("Xpath", ServiceDesklocators.selectuser);

		// driver.findElement(By.xpath("//input[@id='ui_select_search_input_user']")).sendKeys("Compass
		// Qa");
		// driver.findElement(By.xpath("//input[@id='ui_select_search_input_user']")).sendKeys(Keys.ENTER);

		gm.click("Xpath", ServiceDesklocators.clickcreateandtransfer);
		Thread.sleep(10000);
		gm.click("Xpath", ServiceDesklocators.clickmyaction);
		Thread.sleep(3000);
		gm.click("Xpath", ServiceDesklocators.transferredbyme);
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.ticketlink);

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.tickethistory);
		Thread.sleep(3000);
		String tickethistory = gm.getText("Xpath", ServiceDesklocators.tickethistorycontents);

		Assert.assertTrue(tickethistory.contains("Fund management Sundarland"),
				"ticket is not transferred selected user");

	}

	@Test(priority = 13, enabled = false, description = "Verify template remains the same  if category is changed in the ticket create page")
	public void vaidateTC_SD_024() throws Exception {

		extentTest = extent.startTest("vaidateTC_SD_024");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		// gm.scrollDown("//li[@title='Configuration']/a/i");
		gm.scrollToElement("//li[@title='Configuration']/a/i");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(3000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(3000);

		gm.SendKeys("Xpath", ServiceDesklocators.searchcategoryticket, "Ticket abuse");

		driver.findElement(By.xpath("//div/span/h5")).click();

		Thread.sleep(5000);

		String categorydisplayed = gm.getText("Xpath", ServiceDesklocators.selectedcategory);
		Assert.assertEquals(categorydisplayed, "Ticket abuse");

	}

	@Test(priority = 14, enabled = false, description = "Verify user not able to create ticket without select user type")
	public void vaidateTC_SD_025() throws Exception {

		extentTest = extent.startTest("vaidateTC_SD_025");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		// gm.scrollDown("//li[@title='Configuration']/a/i");
		gm.scrollToElement("//li[@title='Configuration']/a/i");

		gm.navigateToServiceDeskConfigPage();
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.clickfeaturesetup);
		gm.click("Xpath", ServiceDesklocators.featureticketoption);

		gm.click("Xpath", ServiceDesklocators.configurationoption);

		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.requesteroption);

		Boolean yesenabeled = driver.findElement(By.xpath(ServiceDesklocators.associatereqyesoption)).isSelected();

		if (yesenabeled == false) {
			gm.click("Xpath", ServiceDesklocators.associatereqyesoption);
		}

		driver.findElement(By.xpath("//span[@id='top_navigation_heading']")).click();
		Thread.sleep(5000);

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(3000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(3000);

		gm.click("Xpath", ServiceDesklocators.clickaddnotes);
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement button = driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span"));

		js.executeScript("arguments[0].click();", button);

		// driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span")).click();

		Thread.sleep(3000);

		gm.click("Xpath", ServiceDesklocators.cliccreatandcontinue);
		Thread.sleep(5000);

		Boolean isdisplayed = driver.findElement(By.xpath("//div[contains(text(),'Please select user')]"))
				.isDisplayed();

		Assert.assertTrue(isdisplayed, "message is not displayed for leaving user filed blank");

	}

	@Test(priority = 15, enabled = false, description = "Verify completion percentage is not greater than 100 in add task page of ticket")
	public void vaidateTC_SD_061() throws Exception {

		extentTest = extent.startTest("vaidateTC_SD_061");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		// gm.scrollDown("//li[@title='Configuration']/a/i");
		gm.scrollToElement("//li[@title='Configuration']/a/i");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(3000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickaddtask);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement button = driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span"));

		js.executeScript("arguments[0].click();", button);

		// driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span")).click();

		Thread.sleep(3000);

		gm.SendKeys("Xpath", ServiceDesklocators.taskname, "test task 3");
		Thread.sleep(3000);
		gm.click("Xpath", ServiceDesklocators.priority);
		Thread.sleep(3000);
		gm.click("Xpath", ServiceDesklocators.selecthigh);

		gm.SendKeys("Xpath", ServiceDesklocators.comppercentage, "100");

		String result = driver.findElement(By.xpath("//div[@id='teamTask-dropdown']")).getAttribute("disabled");

		System.out.println(result);
		Thread.sleep(3000);
		Assert.assertTrue(result.contentEquals("false"), "team dropdown value is not disabled");

		String result1 = driver.findElement(By.xpath("//div[@id='user-dropdown']")).getAttribute("disabled");

		System.out.println(result1);

		Assert.assertTrue(result1.contentEquals("false"), "team dropdown value is not disabled");

	}

	@Test(priority = 16, enabled = false, description = "Verify confidential notes added in Ticket is not visible to students")
	public void vaidateTC_SD_049() throws Exception {

		extentTest = extent.startTest("vaidateTC_SD_049");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		// gm.scrollDown("//li[@title='Configuration']/a/i");
		gm.scrollToElement("//li[@title='Configuration']/a/i");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(3000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@placeholder='Search by Name, ID or Email ID']")).click();

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.File_TestData);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='ui_select_search_input_ID']"))
				.sendKeys(ExcelUtils.getCellData1(1, 11));

		driver.findElement(By.xpath("//input[@id='ui_select_search_input_ID']")).sendKeys(Keys.ENTER);

		gm.click("Xpath", ServiceDesklocators.clickaddnotes);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement button = driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span"));

		js.executeScript("arguments[0].click();", button);

		// driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span")).click();

		Thread.sleep(5000);

		gm.scrollToElement("//div[@id='note1']/div[2]/div[4]/div[3]");

		gm.SendKeys("Xpath", "//div[@id='note1']/div[2]/div[4]/div[3]", "test notes.");

		Thread.sleep(5000);

		gm.SendKeys("Xpath", ServiceDesklocators.confnotes, "confidential notes to check for student access");

		driver.findElement(By.xpath("//i[@class='fa fa-chevron-down']")).click();
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.selectcampus);
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_campus']")).sendKeys("Sunderland Campus");
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_campus']")).sendKeys(Keys.ENTER);

		gm.click("Xpath", ServiceDesklocators.selectdept);
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_department']"))
				.sendKeys("Finance Support Sundarland");
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_department']")).sendKeys(Keys.ENTER);

		gm.click("Xpath", ServiceDesklocators.selectteam);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_team']"))
				.sendKeys("Fund Management Sundarland");
//		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_team']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		gm.click("Xpath", ServiceDesklocators.clickadd);

		gm.click("Xpath", ServiceDesklocators.cliccreatandcontinue);
		Thread.sleep(5000);

		// opening student portal in incognito window
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		ChromeDriver driver1 = new ChromeDriver(options);
		driver1.get("https://compass-qa.engage2serve.com/");

		driver1.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver1, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='usrnm']")));

		driver1.findElement(By.xpath("//input[@name='usrnm']")).sendKeys("Adam Finlay@yopmail.com");

		driver1.findElement(By.xpath("//input[@type='password']")).sendKeys("demo");

		driver1.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(10000);

		driver1.findElement(By.xpath("//*[@id='navbar-menu']/ul/li[3]/a")).click();

		driver1.findElement(By.xpath("//*[@id='navbar-menu']/ul/li[3]/ul/li[1]/a")).click();
		Thread.sleep(5000);
		driver1.findElement(By.xpath("//span[@class='enquiry-id']")).click();

		Thread.sleep(5000);

		driver1.findElement(By.xpath("//bdi[contains(text(),'Enquiry History')]")).click();

		String confnotes = "confidential notes to check for staff access";

		Assert.assertFalse(driver1.getPageSource().contains(confnotes));

	}

	@Test(priority = 17, enabled = false, description = "Verify only added user can view the confidential notes of the ticket")
	public void vaidateTC_SD_051() throws Exception {

		extentTest = extent.startTest("vaidateTC_SD_051");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		// gm.scrollDown("//li[@title='Configuration']/a/i");
		gm.scrollToElement("//li[@title='Configuration']/a/i");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(3000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@placeholder='Search by Name, ID or Email ID']")).click();

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.File_TestData);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='ui_select_search_input_ID']"))
				.sendKeys(ExcelUtils.getCellData1(1, 11));

		driver.findElement(By.xpath("//input[@id='ui_select_search_input_ID']")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		// driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span")).click();

		// WebElement elementLocator = driver.findElement(By.id("ID"));

//		

		gm.click("Xpath", ServiceDesklocators.clickaddnotes);

		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		WebElement button1 = driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span"));

		js1.executeScript("arguments[0].click();", button1);

		// driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span")).click();

		Thread.sleep(5000);

		gm.scrollToElement("//div[@id='note1']/div[2]/div[4]/div[3]");

		gm.SendKeys("Xpath", "//div[@id='note1']/div[2]/div[4]/div[3]", "test notes.");

		Thread.sleep(5000);

		gm.SendKeys("Xpath", ServiceDesklocators.confnotes, "confidential notes to check for staff access");

		driver.findElement(By.xpath("//i[@class='fa fa-chevron-down']")).click();
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.selectcampus);
		// driver.findElement(By.xpath("//input[@id='ui_select_search_input_campus']")).sendKeys("Sunderland
		// Campus");

		driver.findElement(By.xpath("//div[contains(text(),'" + ExcelUtils.getCellData(1, 12) + "')]")).click();

		Thread.sleep(3000);
		gm.click("Xpath", ServiceDesklocators.selectdept);
		driver.findElement(By.xpath("//div[contains(text(),'" + ExcelUtils.getCellData(1, 13) + "')]")).click();

		// driver.findElement(By.xpath("//input[@id='ui_select_search_input_department']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		gm.click("Xpath", ServiceDesklocators.selectteam);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'" + ExcelUtils.getCellData(1, 14) + "')]")).click();

		// driver.findElement(By.xpath("//input[@id='ui_select_search_input_team']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='select_placeholder_s']")).click();

		driver.findElement(By.xpath("//div[contains(text(),'" + ExcelUtils.getCellData(1, 15) + "')]")).click();
		// driver.findElement(By.xpath("(//input[@id='ui_select_search_input_user'])[2]")).sendKeys(Keys.ENTER);
		gm.click("Xpath", ServiceDesklocators.clickadd);

		gm.click("Xpath", ServiceDesklocators.cliccreatandcontinue);
		Thread.sleep(5000);

		String message = driver.findElement(By.xpath("//*[@id='ng-app']/body/div[6]/div/div[1]")).getText();

		String[] elements = message.split(" ");
		System.out.println(elements[2]);

		// opening student portal in incognito window
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		ChromeDriver driver1 = new ChromeDriver(options);
		driver1.get("https://compass-qa.engage2serve.com/");

		driver1.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver1, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='usrnm']")));

		driver1.findElement(By.xpath("//input[@name='usrnm']")).sendKeys("RobertReed@yopmail.com");

		driver1.findElement(By.xpath("//input[@type='password']")).sendKeys("demo");

		driver1.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(10000);
		// gm.Wait("//*[@id='top_navigation_heading']");
		// gm.scrollDown("//li[@title='Configuration']/a/i");

		WebElement element = driver1.findElement(By.xpath("//li[@title='Configuration']/a/i"));

		((JavascriptExecutor) driver1).executeScript("arguments[0].scrollIntoView();", element);

		Thread.sleep(5000);

		WebElement options1 = driver1.findElement(By.xpath("//div[@class='sidebar-collapse']"));
		//
		Actions act = new Actions(driver1);
		//
		act.moveToElement(options1).perform();
		Thread.sleep(10000);

		driver1.findElement(By.xpath("//span[contains(text(),'Service Desk')]")).click();

		Thread.sleep(3000);

		driver1.findElement(By.xpath("//span[contains(text(),'Inbox')]")).click();

		Thread.sleep(5000);
		driver1.findElement(By.partialLinkText("All")).click();
		Thread.sleep(5000);
		driver1.findElement(By.linkText(elements[2])).click();

		Thread.sleep(5000);

		driver1.findElement(By.xpath("//a[contains(text(),'Ticket History')] ")).click();

		Thread.sleep(5000);

		String confnotes = "confidential notes to check for staff access";

		Assert.assertTrue(driver1.getPageSource().contains(confnotes));

		Thread.sleep(5000);

		driver1.close();

	}

	@Test(priority = 18, enabled = false, description = "Verify notes added in Transfer tab is visible to the students if Visible to student is Checked")
	public void vaidateTC_SD_068() throws Exception {

		extentTest = extent.startTest("vaidateTC_SD_068");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@placeholder='Search by Name, ID or Email ID']")).click();

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.File_TestData);

		Thread.sleep(3000);

		System.out.println("student name" + ExcelUtils.getCellData1(1, 11));

		driver.findElement(By.xpath("//div[contains(text(),'" + ExcelUtils.getCellData(1, 11) + "')]")).click();

		gm.click("Xpath", ServiceDesklocators.clicktransfer);

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement button = driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span"));

		js.executeScript("arguments[0].click();", button);

		// driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span")).click();

		Thread.sleep(3000);

		gm.click("Xpath", ServiceDesklocators.selectcampus);

		driver.findElement(By.xpath("//input[@id='ui_select_search_input_campus']")).sendKeys("Sunderland Campus");
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_campus']")).sendKeys(Keys.ENTER);

		gm.click("Xpath", ServiceDesklocators.selectdept);
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_department']"))
				.sendKeys("Finance Support Sundarland");
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_department']")).sendKeys(Keys.ENTER);

		gm.click("Xpath", ServiceDesklocators.selectteam);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_team']"))
				.sendKeys("Fund Management Sundarland");
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_team']")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		gm.scrollToElement("//div[@id='note1']/div[2]/div[4]/div[3]");

		gm.SendKeys("Xpath", "//div[@id='note1']/div[2]/div[4]/div[3]", "test notes.");
		Thread.sleep(10000);

		Boolean isselected = driver.findElement(By.xpath(ServiceDesklocators.visibletostudent)).isEnabled();

		Assert.assertTrue(isselected, "visible to student check box is not selected");

		gm.click("Xpath", ServiceDesklocators.clickcreateandtransfer);
		Thread.sleep(10000);

		String message = driver.findElement(By.xpath("//*[@id='ng-app']/body/div[6]/div/div[1]")).getText();

		String[] elements = message.split(" ");
		System.out.println(elements[2]);

		// opening student portal in incognito window
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		ChromeDriver driver1 = new ChromeDriver(options);
		driver1.get("https://compass-qa.engage2serve.com/");

		driver1.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver1, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='usrnm']")));

		driver1.findElement(By.xpath("//input[@name='usrnm']")).sendKeys("Adam Finlay@yopmail.com");

		driver1.findElement(By.xpath("//input[@type='password']")).sendKeys("demo");

		driver1.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(10000);

		driver1.findElement(By.xpath("//*[@id='navbar-menu']/ul/li[3]/a")).click();

		driver1.findElement(By.xpath("//*[@id='navbar-menu']/ul/li[3]/ul/li[1]/a")).click();
		Thread.sleep(5000);
		driver1.findElement(By.xpath("//span[@class='enquiry-id']")).click();

		Thread.sleep(5000);

		driver1.findElement(By.xpath("//bdi[contains(text(),'Enquiry History')]")).click();

		Thread.sleep(5000);

		String transfernotes = "test notes.";

		Assert.assertTrue(driver1.getPageSource().contains(transfernotes));

		Thread.sleep(5000);

		driver1.close();

	}

	@Test(priority = 19, enabled = false, description = "Verify notes added in Transfer tab is visible to the students if not visible to student is Unchecked")
	public void vaidateTC_SD_069() throws Exception {

		extentTest = extent.startTest("vaidateTC_SD_069");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");

		gm.navigateToServiceDeskPage();

		Thread.sleep(5000);

		gm.click("Xpath", ServiceDesklocators.clickcreatenew);
		Thread.sleep(5000);
		gm.click("Xpath", ServiceDesklocators.selectemplate);

		driver.findElement(By.xpath("//div[contains(text(),'Demo Ticket Template')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@placeholder='Search by Name, ID or Email ID']")).click();

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.File_TestData);

		Thread.sleep(3000);

		System.out.println("student name" + ExcelUtils.getCellData1(1, 11));

		driver.findElement(By.xpath("//div[contains(text(),'" + ExcelUtils.getCellData(1, 11) + "')]")).click();

		gm.click("Xpath", ServiceDesklocators.clicktransfer);

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement button = driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span"));

		js.executeScript("arguments[0].click();", button);

		// driver.findElement(By.xpath("//button[@id='confirm_popup_confirm']/span")).click();

		Thread.sleep(3000);

		gm.click("Xpath", ServiceDesklocators.selectcampus);

		driver.findElement(By.xpath("//input[@id='ui_select_search_input_campus']")).sendKeys("Sunderland Campus");
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_campus']")).sendKeys(Keys.ENTER);

		gm.click("Xpath", ServiceDesklocators.selectdept);
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_department']"))
				.sendKeys("Finance Support Sundarland");
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_department']")).sendKeys(Keys.ENTER);

		gm.click("Xpath", ServiceDesklocators.selectteam);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_team']"))
				.sendKeys("Fund Management Sundarland");
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_team']")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		Boolean isselected = driver.findElement(By.xpath(ServiceDesklocators.visibletostudent)).isEnabled();

		Assert.assertTrue(isselected, "visible to student check box is selected");

		driver.findElement(By.xpath(ServiceDesklocators.visibletostudent)).click();

		gm.scrollToElement("//div[@id='note1']/div[2]/div[4]/div[3]");

		gm.SendKeys("Xpath", "//div[@id='note1']/div[2]/div[4]/div[3]", "test notes.");
		Thread.sleep(10000);

		gm.click("Xpath", ServiceDesklocators.clickcreateandtransfer);
		Thread.sleep(10000);

		String message = driver.findElement(By.xpath("//*[@id='ng-app']/body/div[6]/div/div[1]")).getText();

		String[] elements = message.split(" ");
		System.out.println(elements[2]);

		// opening student portal in incognito window
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		ChromeDriver driver1 = new ChromeDriver(options);
		driver1.get("https://compass-qa.engage2serve.com/");

		driver1.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver1, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='usrnm']")));

		driver1.findElement(By.xpath("//input[@name='usrnm']")).sendKeys("Adam Finlay@yopmail.com");

		driver1.findElement(By.xpath("//input[@type='password']")).sendKeys("demo");

		driver1.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(10000);

		driver1.findElement(By.xpath("//*[@id='navbar-menu']/ul/li[3]/a")).click();

		driver1.findElement(By.xpath("//*[@id='navbar-menu']/ul/li[3]/ul/li[1]/a")).click();
		Thread.sleep(5000);
		driver1.findElement(By.xpath("//span[@class='enquiry-id']")).click();

		Thread.sleep(5000);

		driver1.findElement(By.xpath("//bdi[contains(text(),'Enquiry History')]")).click();

		Thread.sleep(5000);

		String transfernotes = "test notes.";

		Assert.assertFalse(driver1.getPageSource().contains(transfernotes));

		Thread.sleep(5000);

		driver1.close();

	}
}
