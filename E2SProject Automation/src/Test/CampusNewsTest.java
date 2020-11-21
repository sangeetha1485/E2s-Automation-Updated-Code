package Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CampusNews;
import Pages.CampusNews.CampusNewslocators;
import utility.Constants;
import utility.ExcelUtils;
import utility.GenericMEthods;
import org.hamcrest.number.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

public class CampusNewsTest extends FunctionalTest {

	CampusNews cn = new CampusNews();
	GenericMEthods gm = new GenericMEthods();

	@Test(priority = 1, enabled = false)
	public void validateTC_CN_001() throws Exception {

		extentTest = extent.startTest("validateTC_CN_001");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);

		gm.click("Xpath", CampusNewslocators.selectcategoryddl);

		gm.SendKeys("Xpath", CampusNewslocators.searchcategory, "Alumni Activities");

		driver.findElement(By.xpath(CampusNewslocators.searchcategory)).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		String categoryname = driver.findElement(By.xpath("//span[contains(text(),'Alumni Activities')]")).getText();

		Assert.assertEquals(categoryname, "Alumni Activities",
				"entered category name is not displayed in select category field");

	}

	@Test(priority = 2, enabled = false)
	public void validateTC_CN_010() throws Exception {

		extentTest = extent.startTest("validateTC_CN_010");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);

		gm.click("Xpath", CampusNewslocators.clickcreatenewcategory);

		Boolean categorynamedisplayed = driver.findElement(By.xpath(CampusNewslocators.categoryname)).isDisplayed();

		Assert.assertTrue(categorynamedisplayed, "category pop is not displayed");

	}

	@Test(priority = 3, enabled = false, description = "Verify logged in user is able to invite personas of staff, Student when logged in user clicks on Personas tab")
	public void validateTC_CN_040() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);
		extentTest = extent.startTest("validateTC_CN_040");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		// gm.navigateToNotificationsHomePage();

		// nhp.clickCreateNotification();
		gm.navigateToCampusNews();

		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), ExcelUtils.getCellData(1, 16));

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), ExcelUtils.getCellData(1, 16));
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.click("Xpath", gm.readproperty_file("clicklaterradiobutton"));
		Thread.sleep(5000);

		List<String> list = new ArrayList<String>();

		String[] usertype = { "Staff", "Alumni" };

		for (int k = 0; k < usertype.length; k++) {

			gm.click("Xpath", gm.readproperty_file("specificrecepientsoption"));
			Thread.sleep(3000);
			System.out.println(usertype[k]);
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

	@Test(priority = 4, enabled = false, description = "Verify User able to pick before Current date in the Create Campus News step-3 page")
	public void validateTC_CN_031() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_N_031");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), ExcelUtils.getCellData(1, 16));
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), ExcelUtils.getCellData(1, 17));

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clicklaterradiobutton"));

		gm.click("Xpath", gm.readproperty_file("clickpublishdate"));
		Thread.sleep(3000);

		Boolean enabeled = driver.findElement(By.xpath("//td[@data-date='" + ExcelUtils.getCellData(1, 18)
				+ "' and @data-month='" + ExcelUtils.getCellData(1, 19) + "']/div")).isSelected();

		Assert.assertFalse(enabeled, "given past date is enabeled ");
		// gm.selectDate("21");

	}

	@Test(priority = 5, enabled = false, description = "Verify User able to pick date and time when Later option is checked")
	public void validateTC_CN_033() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_N_030");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), ExcelUtils.getCellData(1, 16));
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), ExcelUtils.getCellData(1, 17));

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clicklaterradiobutton"));

		gm.click("Xpath", gm.readproperty_file("clickpublishdate"));
		Thread.sleep(3000);
		gm.selectDate(ExcelUtils.getCellData(1, 20));
		gm.click("Xpath", gm.readproperty_file("clickpublishdate"));

		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("expirydate"));
		Thread.sleep(3000);

		WebElement element = driver.findElement(By.xpath(gm.readproperty_file("expirydate")));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly')", element);

		WebElement newElement = driver.findElement(By.xpath(gm.readproperty_file("expirydate")));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('value','" + ExcelUtils.getCellData(1, 21) + "')", newElement);
		// driver.findElement(By.xpath("//td[@data-date='29' and
		// @data-month='9']/div")).click();
		// gm.click("Xpath", gm.readproperty_file("expirydate"));

		Thread.sleep(3000);
		Thread.sleep(3000);
		// gm.selectDate(ExcelUtils.getCellData(1, 21));

		String startdate = driver.findElement(By.xpath(gm.readproperty_file("clickpublishdate"))).getAttribute("value");
		System.out.println(startdate);

		Assert.assertTrue(startdate.contains(ExcelUtils.getCellData(1, 20)),
				"start date is not same as input date value");

		String enddatedate = driver.findElement(By.xpath(gm.readproperty_file("expirydate"))).getAttribute("value");
		System.out.println(enddatedate);
		Assert.assertTrue(enddatedate.contentEquals(ExcelUtils.getCellData(1, 21)),
				"end date is not same as input date value");

	}

	@Test(priority = 5, enabled = false, description = "Verify user not allowed to select the past date/time in expiry Date/Time")
	public void validateTC_CN_030() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_N_031");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), ExcelUtils.getCellData(1, 16));
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), ExcelUtils.getCellData(1, 17));

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clicklaterradiobutton"));

		gm.click("Xpath", gm.readproperty_file("expirydate"));
		Thread.sleep(3000);

		Boolean enabeled = driver.findElement(By.xpath("//td[@data-date='" + ExcelUtils.getCellData(1, 18)
				+ "' and @data-month='" + ExcelUtils.getCellData(1, 19) + "']/div")).isSelected();

		Assert.assertFalse(enabeled, "given past date is enabeled ");
		// gm.selectDate("21");
	}

	@Test(priority = 6, enabled = false, description = "Verify User able to Pick expiry date and Time for both now and later option in the Create Campus News step-3 page")
	public void validateTC_CN_032() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_032");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), ExcelUtils.getCellData(1, 16));
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), ExcelUtils.getCellData(1, 17));

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("expirydate"));
		Thread.sleep(3000);

		gm.selectDate(ExcelUtils.getCellData(1, 21));

		String enddatedate = driver.findElement(By.xpath(gm.readproperty_file("expirydate"))).getAttribute("value");
		System.out.println(enddatedate);
		Assert.assertTrue(enddatedate.contains(ExcelUtils.getCellData(1, 21)),
				"end date is not same as input date value");
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clicklaterradiobutton"));
		Thread.sleep(3000);
		// .click("Xpath", gm.readproperty_file("expirydate"));
		Thread.sleep(7000);

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		//
		WebElement button4 = driver.findElement(By.xpath(gm.readproperty_file("expirydate")));
		//
		js4.executeScript("arguments[0].click();", button4);
		Thread.sleep(5000);
		gm.selectDate(ExcelUtils.getCellData(1, 21));

		Thread.sleep(3000);
		enddatedate = driver.findElement(By.xpath(gm.readproperty_file("expirydate"))).getAttribute("value");
		System.out.println(enddatedate);
		Assert.assertTrue(enddatedate.contains(ExcelUtils.getCellData(1, 21)),
				"end date is not same as input date value");

	}

	@Test(priority = 7, enabled = false, description = "Verify User able to see the updated Category list in the dropdown When user click Save button")
	public void validateTC_CN_026() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_026");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();
		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);

		createnewscategory();

	}

	@Test(priority = 8, enabled = false, description = "Verify Newly Created Category is displayed in the Campus News Page")
	public void validateTC_CN_046() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_026");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();
		Thread.sleep(5000);
		// gm.click("Xpath", CampusNewslocators.createnewsbutton);
		gm.SendKeys("Xpath", gm.readproperty_file("searchcampusnewscategory"), ExcelUtils.getCellData(1, 22));

		driver.findElement(By.xpath(gm.readproperty_file("searchcampusnewscategory"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		Assert.assertTrue(driver.getPageSource().contains(ExcelUtils.getCellData(1, 22)),
				"newly created category is not displayed in campus news apge");

	}

	@Test(priority = 9, enabled = false, description = "Verify user able to see the RSS URL field by clicking the Radio button in the Create Category window.")
	public void validateTC_CN_013() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_013");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();
		// Thread.sleep(5000);
		gm.click("Xpath", CampusNewslocators.createnewsbutton);
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("createnewcategorybutton"));
		// enabelerssfield
		gm.click("Xpath", gm.readproperty_file("enabelerssfield"));
		Thread.sleep(3000);

		// String
		// bgcolor=driver.findElement(By.xpath(gm.readproperty_file("enabelerssfield"))).getAttribute("background-color");

		// Assert.assertEquals(bgcolor, "rgb(26, 179, 148)");

		//
		Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("rssurlfield")),
				"rss url field is not displayed");

	}

	@Test(priority = 10, enabled = false, description = "Verify user is able to enter the RSS URL in RSS URL field")
	public void validateTC_CN_014() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_014");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();
		// Thread.sleep(5000);
		gm.click("Xpath", CampusNewslocators.createnewsbutton);
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("createnewcategorybutton"));
		// enabelerssfield
		gm.click("Xpath", gm.readproperty_file("enabelerssfield"));
		Thread.sleep(3000);

		// String
		// bgcolor=driver.findElement(By.xpath(gm.readproperty_file("enabelerssfield"))).getAttribute("background-color");

		// Assert.assertEquals(bgcolor, "rgb(26, 179, 148)");

		//
		gm.SendKeys("Xpath", gm.readproperty_file("rssurlfield"), "http://rss.cnn.com/rss/cnn_topstories.rss");

		String text = gm.getAttribute("Xpath", gm.readproperty_file("rssurlfield"), "value");

		Assert.assertEquals("http://rss.cnn.com/rss/cnn_topstories.rss", text);

	}

	@Test(priority = 11, enabled = false, description = "Verify Error message is displayed when logged in user enter invalid RSS URL")
	public void validateTC_CN_016() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_016");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();
		// Thread.sleep(5000);
		gm.click("Xpath", CampusNewslocators.createnewsbutton);
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("createnewcategorybutton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercategoryname"), ExcelUtils.getCellData(1, 22));
		gm.SendKeys("Xpath", gm.readproperty_file("enterdesc"), ExcelUtils.getCellData(1, 24));

		// enabelerssfield
		gm.click("Xpath", gm.readproperty_file("enabelerssfield"));
		Thread.sleep(3000);

		//
		gm.SendKeys("Xpath", gm.readproperty_file("rssurlfield"), "test");
		gm.click("Xpath", gm.readproperty_file("savenewcategorybutton"));

		Thread.sleep(3000);

		Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("invalidrssurlerror")));

	}

	@Test(priority = 12, enabled = false, description = "Verify user allowed to search the role in permission settings")
	public void validateTC_CN_021() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_021");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();
		// Thread.sleep(5000);
		gm.click("Xpath", CampusNewslocators.createnewsbutton);
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("createnewcategorybutton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercategoryname"), ExcelUtils.getCellData(1, 22));
		gm.SendKeys("Xpath", gm.readproperty_file("enterdesc"), ExcelUtils.getCellData(1, 24));

		gm.click("Xpath", gm.readproperty_file("clickpermissionsettings"));

		gm.Wait(gm.readproperty_file("enterrole"));
		gm.SendKeys("Xpath", gm.readproperty_file("enterrole"), ExcelUtils.getCellData(1, 27));

		Assert.assertEquals(gm.getAttribute("Xpath", gm.readproperty_file("enterrole"), "value"),
				ExcelUtils.getCellData(1, 27));

	}

	@Test(priority = 13, enabled = false, description = "Verify user able to select the permission setting")
	public void validateTC_CN_020() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_020");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();
		// Thread.sleep(5000);
		gm.click("Xpath", CampusNewslocators.createnewsbutton);
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("createnewcategorybutton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercategoryname"), ExcelUtils.getCellData(1, 22));
		gm.SendKeys("Xpath", gm.readproperty_file("enterdesc"), ExcelUtils.getCellData(1, 24));

		gm.click("Xpath", gm.readproperty_file("clickpermissionsettings"));
		gm.click("Xpath", gm.readproperty_file("enterrole"));

		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("selectsuperadminrole"));
		Thread.sleep(5000);
		Assert.assertEquals(gm.getAttribute("Xpath", "//input[@id='multi_search_input_']", "value"),
				ExcelUtils.getCellData(1, 27));

	}

	@Test(priority = 14, enabled = false, description = "Verify staff is able to edit the campus news category")
	public void validateTC_CN_079() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_079");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();
		Thread.sleep(5000);
		// gm.click("Xpath", CampusNewslocators.createnewsbutton);
		gm.SendKeys("Xpath", gm.readproperty_file("searchcampusnewscategory"), ExcelUtils.getCellData(1, 22));

		driver.findElement(By.xpath(gm.readproperty_file("searchcampusnewscategory"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("editcategory"));
		gm.Wait(gm.readproperty_file("enterdesc"));
		driver.findElement(By.xpath(gm.readproperty_file("enterdesc"))).clear();

		gm.SendKeys("Xpath", gm.readproperty_file("enterdesc"), ExcelUtils.getCellData(1, 24));
		gm.click("Xpath", gm.readproperty_file("updatecategory"));

		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("editcategory"));
		Thread.sleep(5000);
		Assert.assertEquals(gm.getAttribute("Xpath", gm.readproperty_file("enterdesc"), "value"),
				ExcelUtils.getCellData(1, 24));

	}

	@Test(priority = 15, enabled = false, description = "Verify by default the category is selected when staff click on plus icon in the specified category")
	public void validateTC_CN_081() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_079");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();
		Thread.sleep(5000);
		// gm.click("Xpath", CampusNewslocators.createnewsbutton);
		gm.SendKeys("Xpath", gm.readproperty_file("searchcampusnewscategory"), ExcelUtils.getCellData(1, 22));

		driver.findElement(By.xpath(gm.readproperty_file("searchcampusnewscategory"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("createnewsfromcategory"));
		Thread.sleep(5000);
		String categoryname = gm.getText("Xpath", gm.readproperty_file("getcategoryname"));

		Assert.assertEquals(categoryname, ExcelUtils.getCellData(1, 22));

	}

	@Test(priority = 16, enabled = false, description = "Verify \"Do you wish to make this campus news available publicly?\" is displayed in the step 3")
	public void validateTC_CN_077() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_077");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), ExcelUtils.getCellData(1, 16));
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), ExcelUtils.getCellData(1, 17));

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));
		Thread.sleep(3000);

		// availablepublicly

		Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("availablepublicly")),
				"Do you wish to make this news available publicly? option is not displayed");
	}

	@Test(priority = 17, enabled = false, description = "Verify User able to invite with upload recipients when user clicks on recipient")
	public void validateTC_CN_042() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_042");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), ExcelUtils.getCellData(1, 16));

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), ExcelUtils.getCellData(1, 17));
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
			//
			String invididualusersuploaded = driver
					.findElement(By.xpath(gm.readproperty_file("individualsusersuploaded-cn"))).getText();
			Assert.assertTrue((invididualusersuploaded.contains(usersfoundwithinsystem)),
					"users are uploaded from csv");
		}

	}

	@Test(priority = 18, enabled = false, description = "Verify count of total recipients, mobile user & non mobile user number is to be differed according to user type & recipients selection")
	public void validateTC_CN_043() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_043");
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);
		gm.Wait(gm.readproperty_file("enterTitle"));

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), ExcelUtils.getCellData(1, 16));
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), ExcelUtils.getCellData(1, 17));

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("specificrecepientsoption"));
		String totalrecepients = gm.getText("Xpath", gm.readproperty_file("totalrecepientscount"));

		String mobileusers = gm.getText("Xpath", gm.readproperty_file("mobileuserscount"));
		String nonmobileusers = gm.getText("Xpath", gm.readproperty_file("nonmobileuserscount"));

		gm.click("Xpath", gm.readproperty_file("recepientsbutton"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("selectallalumni"));
		gm.click("Xpath", gm.readproperty_file("clickinvitebutton"));

		//
		Thread.sleep(3000);
		// taking recepients count for alumni user type and persona recepients

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
		// taking recepients count for staff user type and persona recepients

		String totalrecepients1 = gm.getText("Xpath", gm.readproperty_file("totalrecepientscount"));

		String mobileusers1 = gm.getText("Xpath", gm.readproperty_file("mobileuserscount"));
		String nonmobileusers1 = gm.getText("Xpath", gm.readproperty_file("nonmobileuserscount"));

		Assert.assertFalse(totalrecepients.contentEquals(totalrecepients1), "total recepients counts are not changed");
		// Assert.assertFalse(mobileusers.contentEquals(mobileusers1), "mobile users
		// counts are not changed");

		Assert.assertFalse(nonmobileusers.contentEquals(nonmobileusers1), "non mobile users counts are not changed");

	}

	@Test(priority = 19, enabled = false, description = "Verify alert message is displayed when staff upload invalid format in the recipients")
	public void validateTC_CN_094() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_094");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), ExcelUtils.getCellData(1, 16));

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), ExcelUtils.getCellData(1, 17));
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.click("Xpath", gm.readproperty_file("clicklaterradiobutton"));
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("specificrecepientsoption"));
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clickuserttypeddl"));

		driver.findElement(By.xpath(gm.readproperty_file("enterusertype"))).clear();
		gm.SendKeys("Xpath", gm.readproperty_file("enterusertype"), "Staff");

		driver.findElement(By.xpath(gm.readproperty_file("enterusertype"))).sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='clear_filters_confirm']")).click();
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("recepientsbutton"));

		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("uploadrecepientstab"));

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Notification_TestData);

		gm.uploadFile(gm.readproperty_file("uploadcsvfilebutton"),
				"C:\\Users\\HP\\Documents\\Engage2Serve Project Documents\\sample images\\alt-schools-stock.jpg");

		Thread.sleep(3000);

		Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("invalidfileformat-error")),
				"error message is not displayed for uploading invalid file");
	}

	@Test(priority = 20, enabled = false, description = "Verify staff is able to edit and update few fields for the active news")
	public void validateTC_CN_095() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_095");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("searchcampusnewscategory"), ExcelUtils.getCellData(1, 26));

		driver.findElement(By.xpath(gm.readproperty_file("searchcampusnewscategory"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		gm.clickUsingJavaScriptExecutor("//a[contains(text(),'First')]");
//						
//						
		gm.click("Xpath", gm.readproperty_file("clickfilterbutton"));
//						
		gm.click("Xpath", gm.readproperty_file("clickstatusddl"));
//						
		gm.Wait(gm.readproperty_file("selectActive"));
		gm.click("Xpath", gm.readproperty_file("selectActive"));

		gm.click("Xpath", gm.readproperty_file("clickapplybutton"));

		gm.Wait(gm.readproperty_file("clickfirstactvie-campusnews"));
		gm.click("Xpath", gm.readproperty_file("clickfirstactvie-campusnews"));
		Thread.sleep(5000);

		gm.scrollToElement(gm.readproperty_file("expirydate"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("expirydate"));

		Thread.sleep(5000);

		Actions actions = new Actions(driver);
		WebElement elementLocator = driver
				.findElement(By.xpath("//td[@data-date='" + 31 + "' and @data-month='11']/div"));

		gm.click("Xpath", gm.readproperty_file("expirydate"));

		gm.click("Xpath", gm.readproperty_file("clickUpdateButton"));

		Thread.sleep(3000);
		Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("campusnews-updationsuccessmsg")),
				"success message is not displayed after updating campus news");
	}

	@Test(priority = 21, enabled = false, description = "Verify staff is able to view the list of recipients when staff click on count")
	public void validateTC_CN_092() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_092");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		Thread.sleep(5000);
		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("selectcategoryddl"));

		gm.SendKeys("Xpath", gm.readproperty_file("searchcategory"), ExcelUtils.getCellData(1, 8));

		driver.findElement(By.xpath(gm.readproperty_file("searchcategory"))).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		// gm.click("Xpath", locator);
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

		gm.Wait(gm.readproperty_file("totalrecepientscount"));
		String actualcount = gm.getText("Xpath", gm.readproperty_file("totalrecepientscount"));
		int count1 = Integer.valueOf(actualcount);
		System.out.println(count1);

		gm.click("Xpath", gm.readproperty_file("totalrecepientscount"));

		Thread.sleep(5000);

		int count = gm.getSingleColumnCountFromTable(gm.readproperty_file("totalrecepientnames"));
		Thread.sleep(5000);
		// System.out.println(count);

		Assert.assertEquals(count1, count);

	}

	@Test(priority = 22, enabled = false, description = "Verify combination of mobile and non mobile recipients count is display in the total recipients")
	public void validateTC_CN_091() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_091");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		Thread.sleep(5000);
		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("selectcategoryddl"));

		gm.SendKeys("Xpath", gm.readproperty_file("searchcategory"), ExcelUtils.getCellData(1, 8));

		driver.findElement(By.xpath(gm.readproperty_file("searchcategory"))).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		// gm.click("Xpath", locator);
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

		gm.Wait(gm.readproperty_file("totalrecepientscount"));
		String actualcount = gm.getText("Xpath", gm.readproperty_file("totalrecepientscount"));
		int totalcount = Integer.valueOf(actualcount);
		System.out.println(totalcount);

		String actualcount1 = gm.getText("Xpath", gm.readproperty_file("mobileuserscount"));
		int mobileuserscount = Integer.valueOf(actualcount1);
		System.out.println(mobileuserscount);

		String actualcount2 = gm.getText("Xpath", gm.readproperty_file("nonmobileuserscount"));
		int nonmobileuserscount = Integer.valueOf(actualcount2);
		System.out.println(nonmobileuserscount);

		int totalusers = mobileuserscount + nonmobileuserscount;

		Assert.assertEquals(totalusers, totalcount);

	}

	@Test(priority = 23, enabled = false, description = "Verify User able to invite with Group recipients when user clicks on recipient")
	public void validateTC_CN_041() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_041");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		Thread.sleep(5000);
		// gm.click("Xpath", CampusNewslocators.createnewsbutton);

		// Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("searchcampusnewscategory"), ExcelUtils.getCellData(1, 22));

		driver.findElement(By.xpath(gm.readproperty_file("searchcampusnewscategory"))).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		// gm.click("Xpath", locator);
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
		gm.click("Xpath", gm.readproperty_file("groupsstab"));

		gm.SendKeys("Xpath", gm.readproperty_file("searchgroup"), ExcelUtils.getCellData(1, 27));
		driver.findElement(By.xpath(gm.readproperty_file("searchgroup"))).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("selectgroup"));

		String count = gm.getText("Xpath", gm.readproperty_file("selectedgrouprecepientcounts"));
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("clickinvitebutton"));
		Thread.sleep(3000);

		String addedgroup = driver
				.findElement(By.xpath("//span[@class='ui-select-match-item btn btn-default btn-xs ng-scope']//span[2]"))
				.getText();
		System.out.println("addedpersona " + addedgroup);
		Thread.sleep(5000);

		if ((addedgroup.contains(ExcelUtils.getCellData(1, 27))) && (addedgroup.contains(count))) {
			System.out.println("selected group is added and counts of users are matching");

		}
	}

	@Test(priority = 24, enabled = false, description = "Verify User able to Publish the news from the Create Campus News Step-3")
	public void validateTC_CN_045() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_045");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		Thread.sleep(5000);
		// gm.click("Xpath", CampusNewslocators.createnewsbutton);

		// Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("searchcampusnewscategory"), ExcelUtils.getCellData(1, 22));

		driver.findElement(By.xpath(gm.readproperty_file("searchcampusnewscategory"))).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		gm.click("LinkText", ExcelUtils.getCellData(1, 22));

		Thread.sleep(5000);
		gm.click("LinkText", "Create News");

		gm.Wait(gm.readproperty_file("categoryddl"));
		Assert.assertTrue(gm.getText("Xpath", gm.readproperty_file("categoryddl"))
				.equalsIgnoreCase(ExcelUtils.getCellData(1, 22)));

		// gm.click("Xpath", locator);
		gm.Wait(gm.readproperty_file("enterTitle"));

		// gm.click("Xpath", locator);
		gm.SendKeys("Xpath", gm.readproperty_file("enterTitle"), ExcelUtils.getCellData(1, 9));

		gm.SendKeys("Xpath", gm.readproperty_file("enterLockScreenMsg"), ExcelUtils.getCellData(1, 16));

		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		gm.SendKeys("Xpath", gm.readproperty_file("entercontent"), ExcelUtils.getCellData(1, 17));
		gm.click("Xpath", gm.readproperty_file("clickNextButton"));

		Thread.sleep(5000);

		if (ExcelUtils.getCellData(1, 29).contains("Later")) {

			gm.click("Xpath", gm.readproperty_file("clicklateroption"));
			gm.click("Xpath", gm.readproperty_file("clickpublishdate"));
			/*
			 * WebElement element =
			 * driver.findElement(By.xpath(gm.readproperty_file("clickpublishdate")));
			 * ((JavascriptExecutor)
			 * driver).executeScript("arguments[0].removeAttribute('readonly')", element);
			 * 
			 * WebElement newElement =
			 * driver.findElement(By.xpath(gm.readproperty_file("clickpublishdate")));
			 * ((JavascriptExecutor) driver).executeScript(
			 * "arguments[0].setAttribute('value','" + ExcelUtils.getCellData(1, 20) + "')",
			 * newElement);
			 */

			Thread.sleep(5000);
			gm.clickUsingJavaScriptExecutor("(//div[contains(text(),'21:45')])[1]");

			Thread.sleep(5000);

		}
		gm.click("Xpath", gm.readproperty_file("expirydate"));
		/*
		 * WebElement element1 =
		 * driver.findElement(By.xpath(gm.readproperty_file("expirydate")));
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].removeAttribute('readonly')", element1);
		 * 
		 * WebElement newElement1 =
		 * driver.findElement(By.xpath(gm.readproperty_file("expirydate")));
		 * ((JavascriptExecutor) driver).executeScript(
		 * "arguments[0].setAttribute('value','" + ExcelUtils.getCellData(1, 21) + "')",
		 * newElement1);
		 */

		Thread.sleep(5000);
		// gm.clickUsingJavaScriptExecutor("//td[@data-date='" + 3 + "' and
		// @data-month='10']/div");

		gm.clickUsingJavaScriptExecutor("(//div[contains(text(),'22:00')])[2]");

		// gm.click("Xpath", gm.readproperty_file("expirydate"));

		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("specificrecepientsoption"));

		gm.click("Xpath", gm.readproperty_file("specificrecepientsoption"));

		gm.click("Xpath", gm.readproperty_file("recepientsbutton"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("selectallalumni"));
		gm.click("Xpath", gm.readproperty_file("clickinvitebutton"));

		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clickpublish"));
		gm.Wait(gm.readproperty_file("publish-successmsg"));

		Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("publish-successmsg")),
				"success message is not displayed after publishing campus news");
		// gm.click("Xpath", gm.readproperty_file("publish-successmsg"));
		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("search-aftercreatingcn"), ExcelUtils.getCellData(1, 9));
		driver.findElement(By.xpath(gm.readproperty_file("search-aftercreatingcn"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		Assert.assertTrue(driver.getPageSource().contains(ExcelUtils.getCellData(1, 9)),
				"created campus news is not linked to category");
		Thread.sleep(5000);

		verifysubmittedvaluesincampusnews();
	}

	@Test(priority = 25, enabled = false, description = "Verify user able to Navigate Edit,Report,Create News pages on clicking icons in the List view Page")
	public void validateTC_CN_005() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_045");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("listview"));

		gm.SendKeys("Xpath", gm.readproperty_file("searchcampusnewscategory"), ExcelUtils.getCellData(1, 22));

		driver.findElement(By.xpath(gm.readproperty_file("searchcampusnewscategory"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("editcategorylistview"));

		gm.Wait("//label[contains(text(),'Category Name*')]//following::input");

		Assert.assertTrue(driver.getPageSource().contains("Category"), "edit page is not displayed");
		gm.click("LinkText", "X");

		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("viewreport"));
		gm.Wait("//a[contains(text(),'Email')]");

		Assert.assertTrue(driver.getPageSource().contains("Report"), "report page is not displayed");
		gm.click("LinkText", "X");

		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("clickcreatenews1"));
		Thread.sleep(3000);

		Assert.assertTrue(driver.getPageSource().contains("Create"), "create campus news page is not displayed");

	}

	// execute validateTC_CN_045 before this tc
	@Test(priority = 26, enabled = false, description = "Verify staff is able to edit and update few fields for the scheduled news")
	public void validateTC_CN_096() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_096");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("searchcampusnewscategory"), ExcelUtils.getCellData(1, 22));

		driver.findElement(By.xpath(gm.readproperty_file("searchcampusnewscategory"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		gm.clickUsingJavaScriptExecutor("//a[contains(text(),'" + ExcelUtils.getCellData(1, 22) + "')]");
//						
//						
		gm.click("Xpath", gm.readproperty_file("clickfilterbutton"));
//						
		gm.click("Xpath", gm.readproperty_file("clickstatusddl"));
//						
		gm.Wait(gm.readproperty_file("selectscheduledoption"));
		gm.click("Xpath", gm.readproperty_file("selectscheduledoption"));

		gm.click("Xpath", gm.readproperty_file("clickapplybutton"));

		gm.Wait(gm.readproperty_file("clickfirstactvie-campusnews"));
		gm.click("Xpath", gm.readproperty_file("clickfirstactvie-campusnews"));
		Thread.sleep(5000);

		gm.scrollToElement(gm.readproperty_file("expirydate"));
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("expirydate"));
		Thread.sleep(3000);

		WebElement element = driver.findElement(By.xpath(gm.readproperty_file("expirydate")));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly')", element);

		WebElement newElement = driver.findElement(By.xpath(gm.readproperty_file("expirydate")));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('value','" + ExcelUtils.getCellData(1, 31) + "')", newElement);
		// driver.findElement(By.xpath("//td[@data-date='29' and
		// @data-month='9']/div")).click();
		// gm.click("Xpath", gm.readproperty_file("expirydate"));

		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("clickUpdateButton"));

		Thread.sleep(3000);
		Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("campusnews-updationsuccessmsg")),
				"success message is not displayed after updating campus news");

	}

	// validateTC_CN_045 has to be executed before this tc
	@Test(priority = 27, enabled = false, description = "Verify Report icon is not displayed for Scheduled campus news")
	public void validateTC_CN_054() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_054");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		Thread.sleep(5000);
		gm.SendKeys("Xpath", gm.readproperty_file("searchcampusnewscategory"), ExcelUtils.getCellData(1, 22));

		driver.findElement(By.xpath(gm.readproperty_file("searchcampusnewscategory"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		gm.clickUsingJavaScriptExecutor("//a[contains(text(),'" + ExcelUtils.getCellData(1, 22) + "')]");
//						
//						
		gm.click("Xpath", gm.readproperty_file("clickfilterbutton"));
//						
		gm.click("Xpath", gm.readproperty_file("clickstatusddl"));
//						
		gm.Wait(gm.readproperty_file("selectscheduledoption"));
		gm.click("Xpath", gm.readproperty_file("selectscheduledoption"));

		gm.click("Xpath", gm.readproperty_file("clickapplybutton"));

		Thread.sleep(5000);

		Boolean reporticon = driver.findElements(By.xpath(gm.readproperty_file("scheduledreports-filtericon")))
				.size() > 0;

		Assert.assertFalse(reporticon, "report is displayed for scheduled campus news");

	}

	@Test(priority = 28, enabled = false, description = "Verify while editing the category the added role is displayed in the permission settings")
	public void validateTC_CN_025() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_025");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		Thread.sleep(5000);

		// gm.click("Xpath", CampusNewslocators.createnewsbutton);
		gm.SendKeys("Xpath", gm.readproperty_file("searchcampusnewscategory"), ExcelUtils.getCellData(1, 22));

		driver.findElement(By.xpath(gm.readproperty_file("searchcampusnewscategory"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("editcategory"));

		Thread.sleep(5000);

		Boolean reporticon = driver.findElements(By.xpath(gm.readproperty_file("clickpermissionsettings"))).size() > 0;

		if (reporticon == false) {
			// gm.click("Xpath", gm.readproperty_file("clickpermissionsettings"));

			// Thread.sleep(5000);
			gm.click("Xpath", "//input[@id='multi_search_input_']");
			Thread.sleep(5000);

//		gm.SendKeys("CssSelector", "#multi_search_input_", ExcelUtils.getCellData(1, 25));
//		driver.findElement(By.cssSelector("#multi_search_input_")).sendKeys(Keys.ENTER);
			gm.click("Xpath", gm.readproperty_file("selectsuperadminrole"));

			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("updatecategory"));
		}

		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("editcategory"));
		Thread.sleep(5000);

		// gm.clickUsingJavaScriptExecutor("//*[@id='ng-app']/body/div[11]/div/div/div/div/div[2]/div/div[5]/div/div");
		// gm.click("Xpath",gm.readproperty_file("enterrole"));
		// Thread.sleep(5000);

		Assert.assertTrue(driver.getPageSource().contains(ExcelUtils.getCellData(1, 25)));

	}

	@Test(priority = 29, enabled = false, description = "Verify user able to select the multiple roles in permission settings")
	public void validateTC_CN_022() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_022");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		Thread.sleep(5000);

		// gm.click("Xpath", CampusNewslocators.createnewsbutton);
		gm.SendKeys("Xpath", gm.readproperty_file("searchcampusnewscategory"), ExcelUtils.getCellData(1, 22));

		driver.findElement(By.xpath(gm.readproperty_file("searchcampusnewscategory"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("editcategory"));

		Thread.sleep(5000);

		Boolean reporticon = driver.findElements(By.xpath(gm.readproperty_file("clickpermissionsettings"))).size() > 0;
		Boolean roles = driver.findElements(By.xpath("//span[@class='ui-select-match-item btn btn-default btn-xs']"))
				.size() > 1;

		if (reporticon == false) {
			if (roles == true) {
				System.out.println("mutiple roles are added");
			}

			else {
				gm.click("Xpath", "//input[@id='multi_search_input_']");
				Thread.sleep(5000);

//						gm.SendKeys("CssSelector", "#multi_search_input_", ExcelUtils.getCellData(1, 25));
//						driver.findElement(By.cssSelector("#multi_search_input_")).sendKeys(Keys.ENTER);
				gm.click("Xpath", gm.readproperty_file("selectsuperadminrole"));
				gm.click("Xpath", gm.readproperty_file("selectmanager"));

				Thread.sleep(5000);

				gm.click("Xpath", gm.readproperty_file("updatecategory"));
				Thread.sleep(5000);

				gm.click("Xpath", gm.readproperty_file("editcategory"));
				Thread.sleep(5000);
				Boolean roles1 = driver
						.findElements(By.xpath("//span[@class='ui-select-match-item btn btn-default btn-xs']"))
						.size() > 1;
				Assert.assertTrue(roles1, "more than one role cant be added");
				// gm.clickUsingJavaScriptExecutor("//*[@id='ng-app']/body/div[11]/div/div/div/div/div[2]/div/div[5]/div/div");
				// gm.click("Xpath",gm.readproperty_file("enterrole"));
				// Thread.sleep(5000);
			}

		}

	}

	@Test(priority = 30, enabled = false, description = "Verify created category is not displayed for the restricted role staff")
	public void validateTC_CN_019() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_019");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		gm.click("Xpath", CampusNewslocators.createnewsbutton);

		Thread.sleep(5000);

		createnewscategory();

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

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='usrnm']")));

		driver.findElement(By.xpath("//input[@name='usrnm']")).clear();
		driver.findElement(By.xpath("//input[@name='usrnm']")).sendKeys(ExcelUtils.getCellData(1, 32));

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Constants.Password);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();
		Thread.sleep(5000);
		// gm.click("Xpath", CampusNewslocators.createnewsbutton);
		gm.SendKeys("Xpath", gm.readproperty_file("searchcampusnewscategory"), ExcelUtils.getCellData(1, 22));

		driver.findElement(By.xpath(gm.readproperty_file("searchcampusnewscategory"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		Assert.assertFalse(driver.getPageSource().contains(ExcelUtils.getCellData(1, 22)),
				"newly created category is not displayed in campus news apge");

	}

	@Test(priority = 31, enabled = false, description = "Verify user able to remove some selected roles in permission settings")
	public void validateTC_CN_023() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_023");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		Thread.sleep(5000);

		// gm.click("Xpath", CampusNewslocators.createnewsbutton);
		gm.SendKeys("Xpath", gm.readproperty_file("searchcampusnewscategory"), ExcelUtils.getCellData(1, 22));

		driver.findElement(By.xpath(gm.readproperty_file("searchcampusnewscategory"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("editcategory"));

		Thread.sleep(5000);
		gm.click("Xpath", "//input[@id='multi_search_input_']");
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("selectmanager"));
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("removemanagerrole"));
		Thread.sleep(5000);

		// System.out.println(gm.getText("Xpath", "(//span[@class='ui-select-match-item
		// btn btn-default btn-xs'])[2]"));
		Boolean roles1 = driver
				.findElements(By.xpath("(//span[@class='ui-select-match-item btn btn-default btn-xs'])[2]")).size() > 1;

		Assert.assertFalse(roles1, "manager role is not removed");

	}

	@Test(priority = 32, enabled = false, description = "Verify only active role is displayed in the permission settings drop down")
	public void validateTC_CN_024() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_024");
		Thread.sleep(5000);

		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToConfigurationPage();

		gm.click("Xpath", gm.readproperty_file("clickimplemetationsetup"));
		Thread.sleep(5000);

		gm.click("LinkText", "Roles & Permission Sets");

		gm.click("Xpath", gm.readproperty_file("clickrolesoption"));

		Thread.sleep(5000);

		List<WebElement> activeroles = driver.findElements(By.xpath(gm.readproperty_file("activeroles")));

		int count1 = activeroles.size();

		System.out.println(count1);
		gm.click("Xpath", gm.readproperty_file("clickhomeoption"));
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToCampusNews();

		Thread.sleep(5000);

		// gm.click("Xpath", CampusNewslocators.createnewsbutton);
		gm.SendKeys("Xpath", gm.readproperty_file("searchcampusnewscategory"), ExcelUtils.getCellData(1, 22));

		driver.findElement(By.xpath(gm.readproperty_file("searchcampusnewscategory"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("editcategory"));

		Thread.sleep(5000);

		gm.click("Xpath", "//input[@id='multi_search_input_']");
		Thread.sleep(5000);
		int count2 = driver.findElements(By.xpath(gm.readproperty_file("roles-permissionsettings"))).size();

		Assert.assertEquals(count2, count1);

	}

	@Test(priority = 33, enabled = false, description = "Verify the Student able to bookmark the news by enable the book mark icon of the news in the My News option")
	public void validateTC_CN_071() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_071");
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("ClickonCampusnewsoption"));

		gm.SendKeys("Xpath", gm.readproperty_file("Searchcampusnews"), ExcelUtils.getCellData(1, 8));

		driver.findElement(By.xpath(gm.readproperty_file("Searchcampusnews"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		String isbookmarked = driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div/div[2]/div/i"))
				.getAttribute("ng-if");

		if (isbookmarked.contains("false")) {
			System.out.println("not already bookmarked");

			gm.click("Xpath", gm.readproperty_file("BookmarkCampusNews"));
		}

		else if (isbookmarked.contains("true")) {
			System.out.println("already bookmarked");
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("BookmarkCampusNews"));
			Thread.sleep(3000);
			// Bookmark removed successfully
			Assert.assertTrue(gm.isDisplayed("Xpath", "//div[contains(text(),'Bookmark removed successfully')]"),
					"campus news boomark is not removed");
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("BookmarkCampusNews"));

		}
		// String campusnewsname=gm.getText("Xpath",
		// gm.readproperty_file("campusnewsname"));
		gm.Wait(gm.readproperty_file("bookmarksuccessmsg"));

		Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("bookmarksuccessmsg")),
				"campus news is not boomarked");

	}

	@Test(priority = 34, enabled = false, description = "Verify Student able to see the Book Marked News in the Book Mark section by clicking the Book Mark icon in the top right corner of the Campus News page")
	public void validateTC_CN_072() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_072");
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("ClickonCampusnewsoption"));
		gm.SendKeys("Xpath", gm.readproperty_file("Searchcampusnews"), ExcelUtils.getCellData(1, 8));

		driver.findElement(By.xpath(gm.readproperty_file("Searchcampusnews"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		String isbookmarked = driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[3]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div/div[2]/div/i"))
				.getAttribute("ng-if");

		if (isbookmarked.contains("false")) {
			System.out.println("not already bookmarked");

			gm.click("Xpath", gm.readproperty_file("BookmarkCampusNews"));
		}

		else if (isbookmarked.contains("true")) {
			System.out.println("already bookmarked");
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("BookmarkCampusNews"));
			Thread.sleep(3000);
			// Bookmark removed successfully
			Assert.assertTrue(gm.isDisplayed("Xpath", "//div[contains(text(),'Bookmark removed successfully')]"),
					"campus news boomark is not removed");
			Thread.sleep(5000);

			gm.click("Xpath", gm.readproperty_file("BookmarkCampusNews"));

		}
		// String campusnewsname=gm.getText("Xpath",
		// gm.readproperty_file("campusnewsname"));
		gm.Wait(gm.readproperty_file("bookmarksuccessmsg"));

		Assert.assertTrue(gm.isDisplayed("Xpath", gm.readproperty_file("bookmarksuccessmsg")),
				"campus news is not boomarked");

		gm.click("Xpath", gm.readproperty_file("bookmarkicon"));
		Thread.sleep(5000);

		Assert.assertTrue(driver.getPageSource().contains(ExcelUtils.getCellData(1, 8)),
				"bookmarked campus news is not present");

	}

	@Test(priority = 35, enabled = false, description = "Verify User able to see All Categories of News by clicking All Categories option in the Campus News Page")
	public void validateTC_CN_075() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_075");
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("ClickonCampusnewsoption"));
		Thread.sleep(5000);

		String text = gm.getText("Xpath", gm.readproperty_file("allcategoriescount"));
		System.out.println(text);

		String text1 = gm.getText("Xpath", gm.readproperty_file("totalrecords"));
		Thread.sleep(5000);

		String[] words = text1.split("of");
		System.out.println(words[1]);

		Assert.assertTrue((words[1]).trim().contentEquals(text));
	}

	@Test(priority = 36, enabled = false, description = "Verify the visit count is displayed along with the message in the My News option in the Campus News page")
	public void validateTC_CN_070() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_070");
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("ClickonCampusnewsoption"));
		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("Searchcampusnews"), ExcelUtils.getCellData(1, 8));

		driver.findElement(By.xpath(gm.readproperty_file("Searchcampusnews"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		String visitcount1 = gm.getText("Xpath", gm.readproperty_file("visitcount-firstcampusnews"));
		System.out.println(visitcount1);

		gm.click("Xpath", gm.readproperty_file("clickreadamore"));

		Thread.sleep(5000);
		// navigating to student portal-campus news page
		gm.click("Xpath", "//a[contains(.,'Campus News')]");
		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("Searchcampusnews"), ExcelUtils.getCellData(1, 8));

		driver.findElement(By.xpath(gm.readproperty_file("Searchcampusnews"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		String visitcount2 = gm.getText("Xpath", gm.readproperty_file("visitcount-firstcampusnews"));
		System.out.println(visitcount2);
		Thread.sleep(5000);

		Integer i = Integer.parseInt(visitcount1);
		Integer j = Integer.parseInt(visitcount2);

		assertThat(j, greaterThan(i));
		// Assert.assertTrue(i>j, "visited count is not increased after viewing campus
		// news");

		String text = gm.getText("Xpath", gm.readproperty_file("getlockscreenmsg"));

		Assert.assertEquals(text, ExcelUtils.getCellData(1, 16));

	}

	@Test(priority = 37, enabled = false, description = "Verify User able to see the News Details on clicking on the News appears under the My News option in the Campus News Section Page")
	public void validateTC_CN_073() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_073");
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("ClickonCampusnewsoption"));
		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("Searchcampusnews"), ExcelUtils.getCellData(1, 8));

		driver.findElement(By.xpath(gm.readproperty_file("Searchcampusnews"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("clickreadamore"));
		Thread.sleep(10000);

		String firstpara = gm.getText("Xpath", gm.readproperty_file("contents-firstline"));
		String lastpara = gm.getText("Xpath", gm.readproperty_file("contents-lastline"));

		Assert.assertTrue(ExcelUtils.getCellData(1, 17).contains(firstpara),
				"given content is not present in campus news");
		Assert.assertTrue(ExcelUtils.getCellData(1, 17).contains(lastpara),
				"given content is not present in campus news");

	}

	@Test(priority = 38, enabled = false, description = "Verify only active campus is displayed when logged in student click campus news icon")
	public void validateTC_CN_076() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		extentTest = extent.startTest("validateTC_CN_076");
		Thread.sleep(5000);

		gm.click("Xpath", gm.readproperty_file("ClickonCampusnewsoption"));
		Thread.sleep(5000);

		gm.SendKeys("Xpath", gm.readproperty_file("Searchcampusnews"), ExcelUtils.getCellData(1, 8));

		driver.findElement(By.xpath(gm.readproperty_file("Searchcampusnews"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		Assert.assertFalse(driver.getPageSource().contains(ExcelUtils.getCellData(1, 33)),
				"inactive campus news is displayed in student portal");

	}

	
	
	
	public void verifysubmittedvaluesincampusnews() throws Exception {
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		gm.click("LinkText", ExcelUtils.getCellData(1, 9));

		Thread.sleep(5000);

		Assert.assertEquals((gm.getText("Xpath", gm.readproperty_file("getcategoryname"))),
				ExcelUtils.getCellData(1, 22));

		String title = gm.getAttribute("Xpath", gm.readproperty_file("gettitle"), "value");

		// Assert.assertEquals(title, ExcelUtils.getCellData(1, 9));

		gm.scrollToElement(gm.readproperty_file("expirydate"));
		Thread.sleep(5000);

		String expirydate = gm.getAttribute("Xpath", gm.readproperty_file("expirydate"), "value");

		// Assert.assertEquals(expirydate, ExcelUtils.getCellData(1, 21));

		// String deliverytype=gm.getAttribute("Xpath",
		// gm.readproperty_file("delivery-type"),"value");

		// Assert.assertEquals(deliverytype, ExcelUtils.getCellData(1, 29));

		Boolean laterenabeled = driver.findElement(By.xpath(gm.readproperty_file("clicklaterradiobutton")))
				.isSelected();

		Assert.assertFalse(laterenabeled, "later button is not disabeled");

		Boolean specificrecepientsselected = driver
				.findElement(By.xpath(gm.readproperty_file("specificrecepientsoption"))).isSelected();

		Assert.assertFalse(specificrecepientsselected, "specific recepients  is not disabeled");

		Assert.assertEquals((gm.getText("Xpath", gm.readproperty_file("getusertype"))), ExcelUtils.getCellData(1, 30));

	}

	public void createnewscategory() throws Exception {

		gm.click("Xpath", gm.readproperty_file("createnewcategorybutton"));

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.CampusNews_TestData);

		gm.SendKeys("Xpath", gm.readproperty_file("entercategoryname"), ExcelUtils.getCellData(1, 22));
		gm.SendKeys("Xpath", gm.readproperty_file("enterdesc"), ExcelUtils.getCellData(1, 24));

		// gm.click("Xpath", gm.readproperty_file("selectimagebutton);
		Thread.sleep(5000);

		// gm.uploadFile(gm.readproperty_file("selectimagebutton"),
		// "C:\\Users\\HP\\Documents\\Engage2Serve Project Documents\\sample
		// images\\alt-schools-stock.jpg");
		gm.click("Xpath", gm.readproperty_file("clickpermissionsettings"));

		gm.Wait(gm.readproperty_file("enterrole"));
		gm.SendKeys("Xpath", gm.readproperty_file("enterrole"), ExcelUtils.getCellData(1, 25));
		driver.findElement(By.xpath(gm.readproperty_file("enterrole"))).sendKeys(Keys.ENTER);

		// Assert.assertEquals(gm.getAttribute("Xpath",
		// gm.readproperty_file("enterrole"), "value"),
		// ExcelUtils.getCellData(1, 25));

		gm.click("Xpath", gm.readproperty_file("savenewcategorybutton"));

		Thread.sleep(5000);
		Assert.assertTrue(gm.getText("Xpath", gm.readproperty_file("categoryddl"))
				.equalsIgnoreCase(ExcelUtils.getCellData(1, 22)));

	}

}
