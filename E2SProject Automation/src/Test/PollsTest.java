package Test;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.PollsPage;
import utility.Constants;
import utility.ExcelUtils;
import utility.GenericMEthods;

public class PollsTest extends FunctionalTest{
	

	PollsPage polls = new PollsPage();
	GenericMEthods gm = new GenericMEthods();
	
	public void executePollsTestCases() throws InterruptedException
	{
		//polls.testLaterDisabeled();
		
		//polls.validate2Response();
		
		//polls.validateMissingPredifinedTemplates();
		
		
		polls.validatePollPublishPage();
		
	}
	
	
	@Test(priority = 1, enabled = false, description = "Verify whether added category are displayed under \"Select Category\"")
	public void vaidateTC_P_003() throws Exception {

		extentTest = extent.startTest("vaidateTC_P_003");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigatetopollspage();

		Thread.sleep(5000);
		
		gm.click("Xpath", gm.readproperty_file("clickcreatepoll"));
		Thread.sleep(3000);

		createpollscategory();
		Thread.sleep(3000);

		//gm.Wait(gm.readproperty_file("categoryddl"));
		//Assert.assertTrue(gm.getText("Xpath", gm.readproperty_file("categoryddl"))
				//.equalsIgnoreCase(ExcelUtils.getCellData(1, 21)));

	}
	
	@Test(priority = 2, enabled = false, description = "Verify whether added category are displayed under \"Select Category\"")
	public void vaidateTC_P_008() throws Exception {

		extentTest = extent.startTest("vaidateTC_P_003");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigatetopollspage();

		
	}
	
	
	public void createpollscategory() throws Exception {

		gm.click("Xpath", gm.readproperty_file("createnewcategorybutton"));

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Polls_TestData);

		gm.SendKeys("Xpath", gm.readproperty_file("entercategoryname"), ExcelUtils.getCellData(1, 21));
		gm.SendKeys("Xpath", gm.readproperty_file("enterdesc"), ExcelUtils.getCellData(1, 23));

		// gm.click("Xpath", gm.readproperty_file("selectimagebutton);
		Thread.sleep(5000);

		// gm.uploadFile(gm.readproperty_file("selectimagebutton"),
		// "C:\\Users\\HP\\Documents\\Engage2Serve Project Documents\\sample
		// images\\alt-schools-stock.jpg");
		gm.click("Xpath", gm.readproperty_file("clickpermissionsettings"));

		gm.Wait(gm.readproperty_file("enterrole"));
		gm.SendKeys("Xpath", gm.readproperty_file("enterrole"), ExcelUtils.getCellData(1, 24));
		driver.findElement(By.xpath(gm.readproperty_file("enterrole"))).sendKeys(Keys.ENTER);

		// Assert.assertEquals(gm.getAttribute("Xpath",
		// gm.readproperty_file("enterrole"), "value"),
		// ExcelUtils.getCellData(1, 25));

		gm.click("Xpath", gm.readproperty_file("savenewcategorybutton"));

		Thread.sleep(5000);
		Assert.assertTrue(gm.getText("Xpath", gm.readproperty_file("selectcategroyddl-polls"))
				.equalsIgnoreCase(ExcelUtils.getCellData(1, 21)));

	}

}
