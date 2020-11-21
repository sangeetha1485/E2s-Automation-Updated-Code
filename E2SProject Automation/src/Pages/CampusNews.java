package Pages;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import Test.FunctionalTest;
import utility.GenericMEthods;

public class CampusNews extends FunctionalTest{
	
	GenericMEthods gm = new GenericMEthods();

	
	public class CampusNewslocators extends AudiencePage
	{
	
		//campus news categories page locators
		
		
		public static final String misccategoryname="//a[contains(text(),'Miscellaneous')] ";
		
		public static final String searchbycategory="//input[@id='institution_structure_search'";
		public static final String createnewsbutton="//button[@class='btn btn-primary btn-sm ng-binding ng-scope']";
		public static final String searchcategory="//input[@id='ui_select_search_input_category']";
				
		public static final String selectcategoryddl="//span[contains(text(),'Miscellaneous')]";
		
		
		//miscellaneous category locators
		public static final String clickfilterbutton="//button[@class='btn btn-white btn-sm']";
		public static final String selectstatus="//input[@placeholder='Select or search status']";
		
		public static final String selectactive="//div[contains(text(),'Active')]";
		
		public static final String selectscheduled="//div[contains(text(),'Scheduled')]";
		public static final String selectonhold="//div[contains(text(),'On Hold')]";
		public static final String selectinactive="//div[contains(text(),'Inactive')]";
		public static final String selectexpired="//div[contains(text(),'Expired')]";
		
		public static final String clickpublishdate="//input[@id='startdate']";
		
		public static final String clearbutton="//button[contains(text(),'Clear')]";
		public static final String applybutton="//button[contains(text(),'Apply')]";
		public static final String createnews="//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div/div[1]/div/div[2]/div/div/div[1]/form/div/div/a";
		public static final String clickfirstnews="//div/table/tbody/tr[1]/td[1]/a";
		public static final String statusoffirstnews="//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div/div[2]/div/div/div[1]/table/tbody/tr[1]/td[2]";
		
		
		//create campus news page
		
		public static final String catgoryname="//span[@class='select2-chosen']//span[contains(text(),'Miscellaneous')]";
		
		//create new category
		public static final String clickcreatenewcategory="//span[@tooltip='Create Category']";
		public static final String categoryname="//label[contains(text(),'Category Name*')]//following::input";
		public static final String enterdesc="//label[contains(text(),'Description')]//following::textarea";
		public static final String enabelerssfield="//span[@id='switchery_id']";
		public static final String clickselectimagebutton="//button[@class='btn btn-primary btn-sm ng-binding']";
		
		public static final String clickremove="//button[contains(text(),'Remove')]";
		public static final String clicksave="//span[contains(text(),' Save')]";
		public static final String clickpermissionsettings="//*[@id='ng-app']/body/div[15]/div/div/div/div/div[2]/div/div[5]/div/a";
		public static final String enterrole="//input[@placeholder='Select or search role']";
		
		//step1 
		public static final String entertitle="//input[@placeholder='Your title goes here']";
		
		public static final String lockscreenmsg="//textarea[@placeholder='Your message goes here']";
		public static final String clicknextbutton="//button[@id='btnNext']";
		
		//step2
		public static final String  entercontentmsg="//div[@class='note-editable panel-body']";
		
		//step3
		public static final String clicklateroption="//label[contains(text(),'Later')]//preceding::ins[1]";
		
		public static final String pubishstartdate="//div[@class='input-group date'][1]//input[@id='startDate1']";
		public static final String expirydate="//div[@class='input-group date'][1]//input[@id='expiryDate1']";
		public static final String availablepublicly="//span[@class='switchery switchery-default']";
		public static final String usertypeddl="//div/div/div/a/span[2]";
		public static final String enterusertype="//input[@id='ui_select_search_input_user']";
		
		public static final String confirmpopup="//button[contains(text(),'Confirm')]";
		public static final String specificrecepientsoption="//label[contains(text(),'Specific Recipients')]//preceding::ins[1]";
		
		public static final String recepientsbutton="//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div/div/div[2]/div/span/div[4]/div/a";
		public static final String clickpublishbutton="//span[contains(text(),'Publish')]";
		public static final String clicksummarybutton="//button[contains(text(),'Summary')]";
		
		//recepients popup
		public static final String personastab="//button[contains(text(),'Personas')]";
		public static final String groupsstab="//button[contains(text(),'Groups')]";
		public static final String individualsstab="//button[contains(text(),'Individuals')]";
		
		public static final String uploadrecepientstab="//button[contains(text(),'Upload Recipients')]";
		
		public static final String uploadcsvfilebutton="//button[@class='btn btn-primary pull-right ng-binding']";
		
		public static final String clickcontinuebutton="//button[contains(text(),'Continue')]";
		
		public static final String clickinvitebutton="//button[contains(text(),'Invite')]";
		
		
		public static final String closerecepientspopup="//div[@class='col-sm-4 right-side-popup-close text-right']/a";
		
		
		public static final String selectrecepients="//*[@id='manulaclick']/table/thead/tr/th[1]/div/ins";
		
		public static final String totalusersuploaded="//label[contains(text(),'Total users uploaded')]//following::strong[@class='ng-binding']";
		
		public static final String usersfoundwithinsystem="//label[contains(text(),'Users found within the system')]//following::strong[@class='ng-binding']";
		
		public static final String usersnotfound="//label[contains(text(),'Users not found')]//following::strong[@class='ng-binding']";
		
	}
	public void validateEQ2658() throws InterruptedException, AWTException
	{
		Thread.sleep(5000);

		gm.navigateToCampusNews();
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys("Miscellaneous");
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),'Miscellaneous')]")).click();
		Thread.sleep(3000);

		//click filter button

		driver.findElement(By.xpath("//button[@class='btn btn-white btn-sm']")).click();

		
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//a[contains(text(),'testcampusnews1')]")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Select or search status']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Active')]")).click();
		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div/table/tbody/tr[1]/td[1]/a")).click();
		
		//for selecting image
		Thread.sleep(3000);

		
		WebElement upload_btn =  driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm ng-binding']"));


		setClipboardData("C:\\Users\\HP\\Documents\\Engage2Serve Project Documents\\sample images\\download__11__1.jpeg");

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
		
		driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'Mobile Preview')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='tabs-container']//li[2]/a")).click();
		Thread.sleep(3000);

		
		//int size=driver.findElements(By.xpath("//img[@src='https://s3.ap-southeast-1.amazonaws.com/e2s-pfprod-sing-4/1c5e3c1d-bdf2-4581-a8a2-83899d6420d4-image.jpeg']")).size();
	//	Boolean size=driver.findElements(By.xpath("//img[@src='https://s3sasmamsamslas']")).isEmpty();

		
		String text=driver.findElement(By.xpath("//div[2]/div[2]/img")).getAttribute("src");

		if(text==null)
		{
			System.out.println("image is not displayed");
		}
	

	}
	
	
	public void validateEQ2652() throws InterruptedException, AWTException
	{
		gm.navigateToCampusNews();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm ng-binding ng-scope']")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@placeholder='Your title goes here']")).sendKeys("testcampusnews4");
		
		
		driver.findElement(By.xpath("//textarea[@placeholder='Your message goes here']")).sendKeys("test");
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//button[@id='btnNext']")).click();
		
		driver.findElement(By.xpath("//div[@class='note-editable panel-body']")).sendKeys("test");
		Thread.sleep(3000);

		
		WebElement upload_btn =  driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm ng-binding']"));


		setClipboardData("C:\\Users\\HP\\Documents\\Engage2Serve Project Documents\\sample images\\download__11__1.jpeg");

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
		
		String removebuttontext=driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).getText();

		Assert.assertEquals(removebuttontext, "Remove","cancel button is changed to remove button in campus news ");	
		
		

	}
	
	
	public void validateAlertStep3ExpiryDate() throws InterruptedException
	{

		gm.navigateToCampusNews();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm ng-binding ng-scope']")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@placeholder='Your title goes here']")).sendKeys("testcampusnews4");
		
		
		driver.findElement(By.xpath("//textarea[@placeholder='Your message goes here']")).sendKeys("test");
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//button[@id='btnNext']")).click();
		
		driver.findElement(By.xpath("//div[@class='note-editable panel-body']")).sendKeys("test");
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//button[@id='btnNext']")).click();

		driver.findElement(By.xpath("//label[contains(text(),'Later')]//preceding::ins[1]")).click();
		
		Thread.sleep(3000);

		//start date
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[@class='input-group date'][1]//input[@id='startDate1']"));
		elementLocator.click();
		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//td[@data-date='4' and @data-month='5']/div")).click();
		actions.doubleClick(elementLocator).perform();


		Thread.sleep(5000);
		
		WebElement elementLocator1 = driver.findElement(By.xpath("//div[@class='input-group date'][1]//input[@id='expiryDate1']"));

         

		//end date
		elementLocator1.click();
		

		Thread.sleep(5000);
		

		driver.findElement(By.xpath("//td[@data-date='30' and @data-month='4']/div")).click();
		
		actions.doubleClick(elementLocator1).perform();


		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(text(),'Publish')]")).click();

		
		Boolean alertmsg=driver.findElement(By.xpath("//div[contains(text(),'Expiry date should be greater than publish date')]")).isDisplayed();
		
		
		Assert.assertTrue(alertmsg, "alert message is displayed when expiry date is greater than publush date");
		
		
		
		
		
		
		
	}
	
	public void validateStatusExpiredDateCrossed() throws InterruptedException
	{
		
		
		Thread.sleep(5000);

		gm.navigateToCampusNews();
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys("Miscellaneous");
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),'Miscellaneous')]")).click();
		Thread.sleep(3000);

		//click filter button

		driver.findElement(By.xpath("//button[@class='btn btn-white btn-sm']")).click();

		
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//a[contains(text(),'testcampusnews1')]")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Select or search status']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Expired')]")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		
		Thread.sleep(3000);
		
		String datetime=driver.findElement(By.xpath("//div[@class='poll-list-view-table']/table/thead/tr/th[4]//following::td[4]")).getText();
		
		Date date=new Date();
		
		DateFormat sdf=new SimpleDateFormat("MM/dd/yyy hh:mm a");
		
		String todaydate=sdf.format(date);
		//String formatteddatetime=sdf.format(datetime);
		
		
		System.out.println(todaydate +"todaydate");
		
		System.out.println(datetime + "formatteddatetime");

		if(datetime.compareTo(todaydate) <0)
		{
			System.out.println("expiry date is lesser than current date");
		}
		
	}
	
	public void validateLoadingIssueAlumni() throws InterruptedException
	{
		gm.navigateToCampusNews();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm ng-binding ng-scope']")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@placeholder='Your title goes here']")).sendKeys("testcampusnews4");
		
		
		driver.findElement(By.xpath("//textarea[@placeholder='Your message goes here']")).sendKeys("test");
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//button[@id='btnNext']")).click();
		
		driver.findElement(By.xpath("//div[@class='note-editable panel-body']")).sendKeys("test");
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//button[@id='btnNext']")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div/div/div/a/span[2]")).click();	
		Thread.sleep(3000);


		driver.findElement(By.xpath("//input[@id='ui_select_search_input_user']")).sendKeys("Staff");
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_user']")).sendKeys(Keys.ENTER);
		Thread.sleep(10000);

		
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        
			//WebElement e1=driver.findElement(By.xpath("//button[contains(text(),'Confirm') and @id='clear_filters_confirm']"));
		
		
		Thread.sleep(10000);

		driver.findElement(By.xpath("//div/div/div/a/span[2]")).click();	

		
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_user']")).clear();

		driver.findElement(By.xpath("//input[@id='ui_select_search_input_user']")).sendKeys("Alumni");
		driver.findElement(By.xpath("//input[@id='ui_select_search_input_user']")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//div[@id='modal_body_div']/div/div[2]/form/div[2]/button[2]")).click();
		Thread.sleep(3000);


		String usertype=driver.findElement(By.xpath("//span[@id='new_ticket_category_selected']")).getText();
		
		Assert.assertEquals(usertype, "Alumni","Alumni user type is loaded");
		Thread.sleep(3000);


	}
	
	public void validateWrongBreadCrumbMiscPlus() throws InterruptedException
	{
		Thread.sleep(5000);

		gm.navigateToCampusNews();
		
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys("Miscellaneous");
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		//driver.findElement(By.xpath("//a[contains(text(),'Miscellaneous')]")).click();

		
		driver.findElement(By.xpath("//div[3]/span[1]/a/img")).click();
		
		Thread.sleep(5000);
		
		String miscdisplayed=driver.findElement(By.xpath("//div[1]/ol/li[2]/a")).getText();
		Thread.sleep(3000);
		Assert.assertEquals(miscdisplayed, "Miscellaneous"," Miscellaneous breadcrumb is displayed correctly");
		
		
		
	}
		
	public void validateMiscDisplayedInCategoryDdl() throws InterruptedException
	{
		Thread.sleep(5000);

		gm.navigateToCampusNews();
		
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys("Miscellaneous");
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		
		
		driver.findElement(By.xpath("//div[3]/span[1]/a/img")).click();
		
		Thread.sleep(5000);
		
		String categorytext=driver.findElement(By.xpath("//span[@class='select2-chosen']//span[contains(text(),'Miscellaneous')]")).getText();
		
		Assert.assertEquals(categorytext, "Miscellaneous","Miscellaneous category is displayed");
		
	}
	
	public void validateEQ2666() throws InterruptedException
	{
		Thread.sleep(5000);

		gm.navigateToCampusNews();
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys("Miscellaneous");
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),'Miscellaneous')]")).click();
		Thread.sleep(3000);

		//click filter button

		driver.findElement(By.xpath("//button[@class='btn btn-white btn-sm']")).click();

		
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//a[contains(text(),'testcampusnews1')]")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Select or search status']")).click();
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//div[contains(text(),'Active')]")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		
		Thread.sleep(3000);
		
		String datetime=driver.findElement(By.xpath("//div[@class='poll-list-view-table']/table/thead/tr/th[3]//following::td[3]")).getText();
		
		Date date=new Date();
		
		DateFormat sdf=new SimpleDateFormat("MM/dd/yyy hh:mm a");
		
		String todaydate=sdf.format(date);
		//String formatteddatetime=sdf.format(datetime);
		
		
		System.out.println(todaydate +"todaydate");
		
		System.out.println(datetime + "formatteddatetime");

		if(datetime.compareTo(todaydate) <0 || datetime.compareTo(todaydate) == 0)
		{
			System.out.println("campus news status is active when publish date is crossed");
		}

		
	}
	public static void setClipboardData(String string) {

		StringSelection stringSelection = new StringSelection(string);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		}      


}
