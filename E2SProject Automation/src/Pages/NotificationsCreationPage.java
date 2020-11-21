package Pages;
//package Tests;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import Test.FunctionalTest;
import utility.GenericMEthods;

public class NotificationsCreationPage extends FunctionalTest{

	
GenericMEthods gm= new 	GenericMEthods();
	

private static WebElement element =null;




//reusable methods and xpath for Notifications-Page

public class notificationpagelocators extends NotificationsCreationPage
{

	//Notifications-Page Locators
	
			//create notification
			public static final String selectCategory="//label[contains(text(),'Select Category*')]";
			public static final String labelTitle="//label[contains(text(),'Enter Title*')]";
			public static final String clickcreatenotif="//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div[1]/div/div[2]/button[2]";
			
			public static final String labeLockScreenMsg="//label[contains(text(),'Lock Screen Message*')]";
			public static final String clickNextButton="//button[@id='btnNext']" ;
			
			public static final String clickPreviousButton="//button[contains(text(),'Previous')]";
			public static final String mandatoryFieldsErrorMsg="//div[contains(text(),'Please fill all mandatory fields')]";
			public static final String enterTitle="//label[contains(text(),'Enter Title*')]//following::input";
			
			
			public static final String enterLockScreenMsg="//div[contains(text(),'200 characters max')]//preceding::textarea";
			public static final String titleErrorMsg="//div[contains(text(),'Please enter your title')]";
			public static final String lockScreenErrorMsg="//div[contains(text(),'Please enter your lock screen message')]";
			public static final String entercontent="//div[@class='note-editable panel-body']";
			public static final String errorMsgContent="//div[contains(text(),'Please enter your content')]";
			
			public static final String mobilepreviewbutton="//button[contains(text(),'Mobile Preview')]";
			public static final String lockscreenpreviewbutton="//button[contains(text(),'Lock Screen Preview')]";
			public static final String createnewcategorybutton="//a[@class='poll-type-create-new-btn']";
			public static final String mobilepreviewclosebutton="//a[contains(text(),'X')]";
			public static final String newcategoryname="//label[contains(text(),'Category Name*')]//following::input";
			public static final String selectimagebutton="//button[contains(text(),'Select Image')]";
					
			public static final String addrolesbutton="//a[@class='col-sm-4 poll-category-roles-add text-right ng-scope']";
			public static final String enterrole="//span[@class='ui-select-match']//following::input[@type='text']";
			public static final String savenewcategorybutton="//button[@class='ladda-button btn btn-primary']";
			public static final String categoryddl="//div[@class='dropDownSelect2Popup ui-select-container select2 select2-container ng-valid']";
			
			public static final String clicklaterradiobutton="//label[contains(text(),'Later')]//preceding::ins[1]";
			
			public static final String clickdate="//input[@id='sDate']";
			public static final String clickuserttypeddl="//div/div/div/a/span[2]";
			
			public static final String enterusertype="//input[@id='ui_select_search_input_user']";
			public static final String selectallrecepientssoption="//label[contains(text(),'All Recipients')]//preceding::ins[1]";
			
			public static final String  totalrecepientscount="//a[@class='ng-binding ng-scope'][1]";
			
			public static final String  mobileuserscount="//div[@class='col-sm-12']/table/tbody/tr[2]/td[3]/span/a";
			
			public static final String nonmobileuserscount="//div[@class='col-sm-12']/table/tbody/tr[3]/td[3]/span/a";
			public static final String specificrecepientsoption="//label[contains(text(),'Specific Recipients')]//preceding::ins[1]";
			
			public static final String recepientsbutton="//a[@class='btn btn-white btn-sm bottom-10 recipient-btn ng-binding ng-scope']";
			
			public static final String recepientssearch="//input[@id='institution_structure_search']";
			
			public static final String personastab="//button[contains(text(),'Personas')]";
			public static final String groupsstab="//button[contains(text(),'Groups')]";
			public static final String individualsstab="//button[contains(text(),'Individuals')]";
			
			public static final String uploadrecepientstab="//button[contains(text(),'Upload Recipients')]";
			
			public static final String uploadcsvfilebutton="//button[@class='btn btn-primary pull-right ng-binding']";
			
			public static final String clickcontinuebutton="//button[contains(text(),'Continue')]";
			
			public static final String clickinvitebutton="//button[contains(text(),'Invite')]";
			public static final String clicksummarybutton="//button[contains(text(),'Summary')]";
			
			public static final String closerecepientspopup="//div[@class='col-sm-4 right-side-popup-close text-right']/a";
			
			public static final String clickpublishbutton="//span[contains(text(),'Publish')]";
			
			public static final String entercategoryname="//label[contains(text(),'Category Name*')]//following::input[1]";		
			
			public static final String selectmisccategory="//a[contains(text(),'Miscellaneous')]";
			public static final String removeimage="//button[text()='Remove']";

			//xpath for filter-categories 
			public static final String clickfilterbutton="//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div/div[1]/div/div[2]/div/div/div[2]/button";
			public static final String clickstatusddl="//input[@placeholder='Select or search status']";
			
			public static final String selectscheduledoption="//div[contains(text(),'Scheduled')]";
			public static final String selectcompletedoption="//div[contains(text(),'Completed')]";
			public static final String selectonholdoption="//div[contains(text(),'On Hold')]";
			
			public static final String clickapplybutton="//button[contains(text(),'Apply')]";
			
			public static final String clickfirstnotif="//div/table/tbody/tr[1]/td[1]/a";
			public static final String onholdhelpicon="//i[@tooltip='Temporarily holds this notification from being published on the scheduled date and time.']";
			
			public static final String selectrecepients="//*[@id='manulaclick']/table/thead/tr/th[1]/div/ins";
			
			public static final String totalusersuploaded="//label[contains(text(),'Total users uploaded')]//following::strong[@class='ng-binding']";
			
			public static final String usersfoundwithinsystem="//label[contains(text(),'Users found within the system')]//following::strong[@class='ng-binding']";
			
			public static final String usersnotfound="//label[contains(text(),'Users not found')]//following::strong[@class='ng-binding']";

			public static final String deletenototification="//button[contains(text(),'Delete')]";
			
			
}
//	public void allFieldsMandatoryCheckStep1() throws InterruptedException
//	{
//		Thread.sleep(5000);
//
//		//mandatoty fields for step 1
//		String selectcategory=driver.findElement(By.xpath("//label[contains(text(),'Select Category*')]")).getText();
//		System.out.println("first field name"+selectcategory);
//		Assert.assertTrue(selectcategory.contains("*"), "select category field mandatory check is done");
//		//fields blank validation error message
//		String entertitle=driver.findElement(By.xpath("//label[contains(text(),'Enter Title*')]")).getText();
//		Assert.assertTrue(entertitle.contains("*"), "select category field mandatory check is done");
//	
//		String lockscreenmessage=driver.findElement(By.xpath("//label[contains(text(),'Lock Screen Message*')]")).getText();
//		Assert.assertTrue(lockscreenmessage.contains("*"), "select category field mandatory check is done");
//		
//		
//		//character length
//
//	}
	
	
	public void ValidateStep1allFieldsBlank() throws InterruptedException
	{
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='btnNext']")).click();

		Boolean blankfieldmsg=driver.findElement(By.xpath("//div[contains(text(),'Please fill all mandatory fields')]")).isDisplayed();
		
		Assert.assertTrue(blankfieldmsg,"error message to fill mandatory fields is displayed");

	}
	
	public void validateStep1FieldsBlank() throws InterruptedException
	{
		
		
		driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-valid ng-valid-maxlength']")).sendKeys("");
		
		Thread.sleep(3000);
		
		
		
		driver.findElement(By.xpath("//div[contains(text(),'200 characters max')]//preceding::textarea")).sendKeys("entering sample text");
		
		driver.findElement(By.xpath("//button[@id='btnNext']")).click();
		
		Boolean blankfieldmsg=driver.findElement(By.xpath("//div[contains(text(),'Please fill all mandatory fields')]")).isDisplayed();
		
		Assert.assertTrue(blankfieldmsg,"error message to fill mandatory fields is displayed");

		
		driver.findElement(By.xpath("//label[contains(text(),'Enter Title*')]//following::input")).sendKeys("test8");
		driver.findElement(By.xpath("//div[contains(text(),'200 characters max')]//preceding::textarea")).clear();


		driver.findElement(By.xpath("//button[@id='btnNext']")).click();
		Thread.sleep(3000);

		//validating lock screen blank msg
		Boolean blankcategorymsg=driver.findElement(By.xpath("//div[contains(text(),'Please enter your lock screen message')]")).isDisplayed();

		Assert.assertTrue(blankfieldmsg,"error message to fill mandatory fields is displayed");
		
		//validate category name blank msg

	}
	
	
	public void checkFieldsHighlightStep1()
	{
		
		driver.findElement(By.xpath("//div[contains(text(),'200 characters max')]//preceding::textarea")).clear();
		driver.findElement(By.xpath("//label[contains(text(),'Enter Title*')]//following::input")).clear();
		driver.findElement(By.xpath("//button[@id='btnNext']")).click();
		
		List<WebElement> errors = driver.findElements(By.xpath("//div[@class='form-group has-error']"));

		System.out.println(errors.size());
		Assert.assertTrue(errors.size()>0,"error message is dsiplayed for two text fields in step1");
//		//String getbgcolor=driver.findElement(By.xpath("//div[contains(text(),'200 characters max')]//preceding::textarea")).getCssValue("border-bottom-color");
//		
//		//Assert.assertEquals(getbgcolor,"rgb(255,0,0)");
//		
//		String getbgcolor=driver.findElement(By.xpath("//label[contains(text(),'Enter Title*')]//following::input")).getCssValue("border-color");
//		
//		Assert.assertEquals(getbgcolor,"rgb(255,0,0)");


	}

	
	public void validateMaxLengthDisplayedStep1()
	{
		String charlengthtitle=driver.findElement(By.xpath("//div[contains(text(),'50 characters max')]")).getText();
		
		Assert.assertEquals(charlengthtitle, "50 characters max");
		String charlengthlockscreen=driver.findElement(By.xpath("//div[contains(text(),'200 characters max')]")).getText();
		Assert.assertEquals(charlengthlockscreen, "200 characters max");


	}
	
	
	public void validateMaxCharactersStep1() throws InterruptedException
	{
		//input string having more than 50 characters
		String titleinput="This is just a sample text to test the maximum char length";
		
		driver.findElement(By.xpath("//label[contains(text(),'Enter Title*')]//following::input")).sendKeys(titleinput);

		Thread.sleep(4000);
		String typedTitle=driver.findElement(By.xpath("//label[contains(text(),'Enter Title*')]//following::input")).getAttribute("value");
		
		int count=getCountOfCharacters(typedTitle);
		
		Assert.assertEquals(count, 50,"the number of characters of title doesnot exceed 50 characters");
		
		String lockscreeninput="This is just a sample text to test the maximum char length of lock screen message to display lockscreen message in lock screen preview. This sample text will be reduced to 200 characters and will be displayed in mobile";
		driver.findElement(By.xpath("//div[contains(text(),'200 characters max')]//preceding::textarea")).sendKeys(lockscreeninput);

		
		String typedLockscreenmsg=driver.findElement(By.xpath("//div[contains(text(),'200 characters max')]//preceding::textarea")).getAttribute("value");
		
		count=getCountOfCharacters(typedLockscreenmsg);
		Assert.assertEquals(count, 200,"the number of characters of lock screen message doesnot exceed 200 characters");

					
						
		
	}
	
	public void validateStep1ValidData() throws InterruptedException
	{
		//input string having more than 50 characters
		
		driver.findElement(By.xpath("//label[contains(text(),'Enter Title*')]//following::input")).sendKeys("Demo Notification1");

		Thread.sleep(4000);
		
		
		
		driver.findElement(By.xpath("//div[contains(text(),'200 characters max')]//preceding::textarea")).sendKeys("Sample Input");

		

					
						
		
	}

	
	
	public void createNotificationStep2() throws InterruptedException
	{
		//mandatoty fields for step 1
		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[@id='btnNext']")).click();
		

		Boolean blankfieldmsg=driver.findElement(By.xpath("//div[contains(text(),'Please enter your content')]")).isDisplayed();
//		
		Assert.assertTrue(blankfieldmsg,"error message to fill mandatory fields is displayed");
//
		Thread.sleep(4000);

		

		driver.findElement(By.xpath("//div[@class='note-editable panel-body']")).sendKeys("testing");
//
//		
		driver.findElement(By.xpath("//button[contains(text(),'Mobile Preview')]")).click();
//
		Thread.sleep(3000);
//
//		
		driver.findElement(By.xpath("//a[contains(text(),'X')]")).click();
//
		Thread.sleep(3000);
//
		driver.findElement(By.xpath("//button[@id='btnNext']")).click();
//		
		Thread.sleep(3000);


	}

	
	public void validatUIStep3()
	{
		//steps 3-default now shld be selected
		//later-date/time enable
		//"Do you wish to make this notification available publicly? -disabled
		//" All Recipients-enabeled
		


	}


	
	
	
	
	public void createNotificationUsingNewCategory() throws InterruptedException, IOException, AWTException
	{
		//check that added value is displayed in ddl
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='poll-type-create-new-btn']")).click();
		String newcategoryname="Demo category26";
		
		Thread.sleep(4000);

		driver.findElement(By.xpath("//label[@class='ng-binding']//following::input[@type='text'][4]")).sendKeys("Demo category26");	
		Thread.sleep(4000);

		//driver.findElement(By.xpath("//label[@class='btn btn-primary btn-sm ng-binding']")).click();	

		//Thread.sleep(4000);
		
//		WebDriverWait wait = new WebDriverWait(driver,20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Select Image')]")));
		
		Thread.sleep(4000);


		WebElement upload_btn =  driver.findElement(By.xpath("//label[text()='Select Image']"));
//
//
		setClipboardData("C:\\Users\\HP\\Desktop\\download.jpg");
//
		Actions builder  = new Actions(driver);
//
		org.openqa.selenium.interactions.Action myAction = builder.click(upload_btn).release().build();
//
		myAction.perform();
//
		Robot rbt = new Robot();
		rbt.delay(4000);
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_ENTER);
//		
		rbt.keyRelease(KeyEvent.VK_ENTER);
		rbt.delay(4000);
//		
		driver.findElement(By.xpath("//a[@class='col-sm-4 poll-category-roles-add text-right ng-scope']")).click();
//		
		driver.findElement(By.xpath("//span[@class='ui-select-match']//following::input[@type='text']")).sendKeys("Super Admin");
//		
//		
		driver.findElement(By.xpath("//span[@class='ui-select-match']//following::input[@type='text']")).sendKeys(Keys.ENTER);
//
//		Thread.sleep(4000);
//		
		driver.findElement(By.xpath("//button[@class='ladda-button btn btn-primary']")).click();
		Thread.sleep(4000);
//
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		
		//WebElement e1=driver.findElement(By.xpath("//div[@class='dropDownSelect2Popup ui-select-container select2 select2-container ng-valid']"));
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dropDownSelect2Popup ui-select-container select2 select2-container ng-valid']")));
		
		String newcategory=driver.findElement(By.xpath("//div[@class='dropDownSelect2Popup ui-select-container select2 select2-container ng-valid']")).getText();
		Thread.sleep(4000);

		System.out.println(newcategory);
		//Assert.assertEquals(newcategoryname, newcategory,"newly added category is added to category dropdown");
		
//		driver.findElement(By.xpath("//div[@class='dropDownSelect2Popup ui-select-container select2 select2-container ng-valid']")).click();
//		Thread.sleep(3000);
//
//		
//		driver.findElement(By.xpath("//div[contains(text(),'EH Sports')]")).click();
		
		driver.findElement(By.xpath("//label[contains(text(),'Enter Title*')]//following::input")).sendKeys("Test Demo");

		
		
		String lockscreeninput="Test Lock Message";
		
		
		driver.findElement(By.xpath("//div[contains(text(),'200 characters max')]//preceding::textarea")).sendKeys(lockscreeninput);

		driver.findElement(By.xpath("//button[contains(text(),'Lock Screen Preview')]")).click();
		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//a[contains(text(),'X')]")).click();
		Thread.sleep(3000);


		driver.findElement(By.xpath("//button[@id='btnNext']")).click();

	}
	
	
	
	

	

	
	
	
	
	public void validateStep3Scenarios() throws InterruptedException, AWTException
	{
		//now-publish date time now displayed
		
		driver.findElement(By.xpath("//label[contains(text(),'Later')]//preceding::ins[1]")).click();

		
		
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='sDate']")).click();
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//*[@id='ng-app']/body/div[7]/div[1]/div[2]/table/tbody/tr[5]/td[5]")).click();
		Date date=new Date();
		
		DateFormat sdf=new SimpleDateFormat("dd");
		
		String todaydate=sdf.format(date);
		
		driver.findElement(By.xpath("//td[@data-date='+todaydate+' and @data-month='4']/div")).click();
		
		driver.findElement(By.xpath("//input[@id='sDate']")).click();
	
		//driver.findElement(By.xpath("//*[@id='ng-app']/body/div[7]/div[1]/div[2]/table/tbody/tr[5]/td[5]")).click();

		Thread.sleep(3000);

		
		
		Thread.sleep(3000);



		driver.findElement(By.xpath("//div/div/div/a/span[2]")).click();	

		
		
		Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@id='ui_select_search_input_user']")).sendKeys("Staff");
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_user']")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//label[contains(text(),'All Recipients')]//preceding::ins[1]")).click();
		
		//getting total recepient count
		String totalrecepientcount=driver.findElement(By.xpath("//a[@class='ng-binding ng-scope'][1]")).getText();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@class='ng-binding ng-scope'][1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='col-sm-4 right-side-popup-close text-right']/a")).click();

		
		//getting mobile users count

		String mobileusers=driver.findElement(By.xpath("//div[@class='col-sm-12']/table/tbody/tr[2]/td[3]/span/a")).getText();				
		System.out.println("the count of mobile users" + mobileusers);
		
		//getting non mobile users count
		String nonmobileusers=driver.findElement(By.xpath("//div[@class='col-sm-12']/table/tbody/tr[3]/td[3]/span/a")).getText();
		System.out.println("the count of non mobile users" + nonmobileusers);

		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'Specific Recipients')]//preceding::ins[1]")).click();
		
		driver.findElement(By.xpath("//a[@class='btn btn-white btn-sm bottom-10 recipient-btn ng-binding ng-scope']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys("Mark Colman");
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//span[@class='pull-right fa fa-close']")).click();		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//button[contains(text(),'Upload Recipients')]")).click();
		
		//driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right ng-binding']")).click();
		
		WebElement upload_btn =  driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right ng-binding']"));


		setClipboardData("C:\\Users\\HP\\Desktop\\Book3.csv");

		Actions builder1  = new Actions(driver);

		org.openqa.selenium.interactions.Action myAction = builder1.click(upload_btn).release().build();

		myAction.perform();

		Robot rbt = new Robot();
		rbt.delay(4000);
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_ENTER);
		
		rbt.keyRelease(KeyEvent.VK_ENTER);
		rbt.delay(4000);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Invite')]")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'Summary')]")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='col-sm-4 right-side-popup-close text-right']/a")).click();
		

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(text(),'Publish')]")).click();
		
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys("Miscellaneous");
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),'Miscellaneous')]")).click();
		Thread.sleep(3000);



		




	}
	
	
		
	
	public void validateStep3Scenariosnow() throws InterruptedException, AWTException
	{
		//now-publish date time now displayed
		
		//driver.findElement(By.xpath("//label[contains(text(),'Later')]//preceding::ins[1]")).click();

		
		
		
		Thread.sleep(3000);
		
		


		driver.findElement(By.xpath("//div/div/div/a/span[2]")).click();	

		
		
		Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@id='ui_select_search_input_user']")).sendKeys("Alumni");
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_user']")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//label[contains(text(),'Specific Recipients')]//preceding::ins[1]")).click();
		
		driver.findElement(By.xpath("//a[@class='btn btn-white btn-sm bottom-10 recipient-btn ng-binding ng-scope']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys("Aaliyah Casper");
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//span[@class='pull-right fa fa-close']")).click();		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//button[contains(text(),'Upload Recipients')]")).click();
		
		//driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right ng-binding']")).click();
		
		WebElement upload_btn =  driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right ng-binding']"));


		setClipboardData("C:\\Users\\HP\\Desktop\\Book3.csv");

		Actions builder  = new Actions(driver);

		org.openqa.selenium.interactions.Action myAction = builder.click(upload_btn).release().build();

		myAction.perform();

		Robot rbt = new Robot();
		rbt.delay(4000);
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_ENTER);
		
		rbt.keyRelease(KeyEvent.VK_ENTER);
		rbt.delay(4000);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Invite')]")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'Summary')]")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='col-sm-4 right-side-popup-close text-right']/a")).click();
		

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(text(),'Publish')]")).click();
		
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys("Miscellaneous");
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),'Miscellaneous')]")).click();
		Thread.sleep(3000);



		
		Actions builder1 = new Actions(driver);        
		builder1.sendKeys(Keys.ENTER);


		driver.findElement(By.xpath("//a[@tooltip='Report']")).click();

		Thread.sleep(5000);




	}
	
	public void validateCancelButtonMissingFileUpload() throws InterruptedException, AWTException
	{
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='poll-type-create-new-btn']")).click();
		String newcategoryname="Demo category34";
		
		Thread.sleep(4000);

		driver.findElement(By.xpath("//label[@class='ng-binding']//following::input[@type='text'][4]")).sendKeys(newcategoryname);	
		Thread.sleep(4000);

		
		
		Thread.sleep(4000);


		WebElement upload_btn =  driver.findElement(By.xpath("//button[text()='Select Image']"));
//
//
		setClipboardData("C:\\Users\\HP\\Desktop\\download.jpg");
//
		Actions builder  = new Actions(driver);
//
		org.openqa.selenium.interactions.Action myAction = builder.click(upload_btn).release().build();
//
		myAction.perform();
//
		Robot rbt = new Robot();
		rbt.delay(4000);
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_ENTER);
//		
		rbt.keyRelease(KeyEvent.VK_ENTER);
		rbt.delay(4000);
		
		//check remove button is displayed
		Boolean removebuttonexists=driver.findElement(By.xpath("//button[text()='Remove']")).isDisplayed();
		
		Assert.assertTrue(removebuttonexists, "Remove button is displayed");
		
		
	}

	
	public void validateHelpIconHoldsNotification() throws InterruptedException
	{
		Thread.sleep(4000);
		//searching miscellaneous category
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys("Miscellaneous");
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),'Miscellaneous')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@tooltip='Filter']")).click();
		
		
		driver.findElement(By.xpath("//input[@placeholder='Select or search status']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Scheduled')]")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		
		//*[@id="page-wrapper"]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div[3]/button[2]
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div/table/tbody/tr[1]/td[1]/a")).click();
		Thread.sleep(3000);
		
		Boolean HelpTextIcon=driver.findElement(By.xpath("//i[@tooltip=\"Temporarily holds this notification from being published on the scheduled date and time.\"]")).isDisplayed();
		
		Assert.assertTrue(HelpTextIcon, "Help icon is displayed");
		
		
		
	}
	
	public void setUp() throws InterruptedException
	{


		driver.manage().window().maximize();
		
		
		

		
		
		Thread.sleep(3000);

		
		
		driver.findElement(By.xpath("//div[@class='dropDownSelect2Popup ui-select-container select2 select2-container ng-valid']")).click();
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//div[contains(text(),'EH Sports')]")).click();
		

		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//button[contains(text(),'Lock Screen Preview')]")).click();
		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//a[contains(text(),'X')]")).click();


		
				
		driver.findElement(By.xpath("//div[@class='note-editable panel-body']")).sendKeys("testing");
		
		driver.findElement(By.xpath("//button[contains(text(),'Mobile Preview')]")).click();

		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//a[contains(text(),'X')]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='btnNext']")).click();
		
		Thread.sleep(3000);

		
		//driver.findElement(By.xpath("//label[contains(text(),'Later')]//preceding::ins[1]")).click();


		
		driver.findElement(By.xpath("//div[@id='sDate']")).click();
//		driver.findElement(By.xpath("//*[@id='ng-app']/body/div[7]/div[1]/div[2]/table/tbody/tr[3]/td[6]")).click();
//		
		
//		WebElement dateWidget = driver.findElement(By.xpath("//div[@class='xdsoft_calendar']/body/div[7]/div[1]/div[2]/table/tbody/tr[3]"));
//		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
//
//		for (WebElement cell: columns){
//		   //Select 13th Date 
//		   if (cell.getText().equals("13")){
//		      cell.findElement(By.linkText("13")).click();
//		      break;
//		 }
       		Thread.sleep(5000);

		
		driver.findElement(By.xpath("//label[contains(text(),'Specific Recipients')]//preceding::ins[1]")).click();
		
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[@class='btn btn-white btn-sm bottom-10 recipient-btn ng-binding ng-scope']")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[@class='icheckbox_square-green'][1]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Invite')]")).click();
		
		
		
		Thread.sleep(5000);


		driver.findElement(By.xpath("//span[contains(text(),'Publish')]")).click();
		
		Thread.sleep(5000);

		
		driver.findElement(By.xpath("//a[contains(text(),'EH Sports')]")).click();
		Thread.sleep(5000);

		
		//driver.findElement(By.xpath("//input[@type='search' and @placeholder='Search by title']")).sendKeys(notificationtitle);

		Thread.sleep(5000);

		
		Actions builder = new Actions(driver);        
		builder.sendKeys(Keys.ENTER);


		driver.findElement(By.xpath("//a[@tooltip='Report']")).click();

		Thread.sleep(5000);

		driver.quit();
		
		
	}

	public int getCountOfCharacters(String word)
	{
		
		//String string = "The best of both worlds";    
        int count = 0;    
            
        //Counts each character except space    
        for(int i = 0; i < word.length(); i++) {    
                count++;    
        }    
            
        //Displays the total number of characters present in the given string    
        System.out.println("Total number of characters in a string: " + count);
		return count; 
	}
	
	public static void setClipboardData(String string) {

		StringSelection stringSelection = new StringSelection(string);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		}      
		
	}
	


