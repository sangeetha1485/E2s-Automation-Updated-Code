package Pages;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.AudiencePage.audiencepagelocators;
import Test.FunctionalTest;
import utility.GenericMEthods;

public class AudiencePage {
	
static GenericMEthods gm= new GenericMEthods();
WebDriver driver;




	private static WebElement element =null;
	
//	public static void main(String[] args) throws DocumentException {
//		File inputFile = new File(System.getProperty("user.dir") +"\\Properties.xml");									
//	    SAXReader saxReader = new SAXReader();					
//	    Document document = saxReader.read(inputFile);
//	    final String createnewbtn = document.selectSingleNode("//audience/createnewbutton").getText();							
//
//	}
	
	
	
	//reusable methods and xpath for Audience-Page

	public class audiencepagelocators extends AudiencePage
	{
		
		
	    
		//Audience -Persona Page Locators
		
		//create persona
		public static final String createnewbutton="//button[contains(text(),'Create New')]";
		public static final String personaname="personaname";
		public static final String enterDescription="//textarea[@name='description']";
		public static final String selectAttribute="//span[contains(text(),'Select or search attribute')]";
		
		public static final String selectOperator="//span[@id='select_placeholder_opt']//following::span[@class='select2-chosen']";
		public static final String selectValue="//label[contains(text(),'Value*')]//following::input";
		
		public static final String clickAddButton ="//a[@class='audience-create-add-btn ng-scope']";
		public static final String clickApplyButton="//span[contains(text(),'Apply')]";
		
		public static final String createpersonaButton="//button[contains(text(),'Cancel')]//following::button";
		public static final String selectSeatNumber="//div[contains(text(),'seat number')]";
		public static final String selectsearchoperator="//span[@id='select_placeholder_opt']//following::span";
		
		public static final String selectGreaterThanOrEqual="//div[contains(text(),'Greater Than or Equal')]";
		public static final String selectEqual="//div[contains(text(),'Equals')]";
		
		
		public static final String selectUserType="//*[@id='selected_user_']";
		public static final String clickStaffUserTypeOption="//*[@id='page-wrapper']/div[2]/div[2]/div[1]/div[2]/div/a";
		public static final String selectStaffUserTypeOption="//a[contains(text(),'Staff')]";
		
		public static final String selectInternalOption="//*[@id='page-wrapper']/div[2]/div[2]/form/div/div/div/div[5]/div/div";
		public static final String alertMessageemptyValue="alertMessageemptyValue";
		
		
		//Audience-Individuals Page Locators
		
		//import functionality
		public static final String clickIndividualsTab="//button[contains(text(),'Individuals')]";
		public static final String clickImportButton="//button[@class='btn btn-white btn-sm ng-scope'][1]";
		public static final String clickUploadCSV="//button[@class='btn btn-sm btn-primary ng-binding'][1]";
		public static final String clickdownload ="download";
		
		//custom attribute
		public static final String clickCustomAttributeBuuton="//button[@class='btn btn-white btn-sm ng-scope'][2]";
		
		public static final String selectGroupDDL="//span[contains(text(),'Select or search group name')]";
		public static final String selectGroupName="//div[contains(text(),'Additional Information')]";
		
		public static final String enterFieldName="//input[@name='name' and @type='text']";
		public static final String enterFieldType="//span[contains(text(),'Select field type')]";
		
		public static final String selectTextFieldType="//div[contains(text(),'Textbox')]";
		
		public static final String enterFieldDesc="//label[contains(text(),' Field Description* ')]//following::textarea";
		public static final String enterValidateAs="//span[contains(text(),'Select or search validate as')]";
		public static final String clickValidateAsOption="//span[contains(text(),'Select or search validate as')]";
		public static final String selectValidateAsText="//div[contains(text(),'Text')]";
		
		public static final String enterCharacterLimit="//input[@placeholder='Character limit']";
		public static final String clickAddAttributeButton="//button[contains(text(),'Add')]";
		public static final String attributeTable="//table[@class='table table-striped margin-bottom-0']";
		public static final String clickCreateAndContinue="//span[contains(text(),'Create and Continue')]";
		public static final String attributeCreatedSuccessMsg="//div[contains(text(),'Attribute(s) created successfully')]";
		
		//Staff-Personal information
		public static final String enterStaffID="//input[@placeholder='Staff ID']";
		public static final String enterFirstName="//input[@placeholder='First name']";
		public static final String enterLastName="//input[@placeholder='Last name']";
		public static final String enterEmail	="//input[@placeholder='Email']";
		public static final String clickCampusDDL	="//input[@id='multi_search_input_campus']";
		public static final String selectCampus="//*[@id='ui-select-choices-row-54-1']/a/div";
		public static final String clickDeptDDL="//span[@id='select_placeholder_department']";
		public static final String enterDeptValue="//input[@id='ui_select_search_input_department']";
		
		public static final String selectDept="//*[@id='ui-select-choices-row-28-4']";
		
		public static final String clickrolesDDL="//span[@id='select_placeholder_role']";
		
		//public static final String enterRoleValue="//inputid="ui_select_search_input_role"
		public static final String selectAdmin="//div[contains(text(),'Admin')]";
		public static final String selectITSupport="//div[contains(text(),'IT Support')]";
		public static final String selectSuperAdmin="//div[contains(text(),'Super Admin')]";
		
		
		
		
		public static final String clickAdd="//button[@class='btn btn-sm btn-primary pull-right margin-top-175']";
				
		public static final String clickCreateAndContine="//span[contains(text(),'Create and Continue')]";
		public static final String clickCreate="//span[contains(text(),'Create and Continue')]//following::span[2]";
		public static final String clickCancel="//button[contains(text(),'Cancel')]";
		
		//Individuals Home Page
		
		public static final String clickFilterButton="//*[@id='page-wrapper']/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/div[1]/div/div[2]/button[1]";
		
		public static final String enterEmailIDfilter="//input[@placeholder='Search by email ID']";
		public static final String clickApply="//button[contains(text(),'Apply')]";
		
		public static final String staffCreationSuccessMsg="//div[contains(text(),'Staff account created successfully, an activation email has been send to the registered email address.')]";
		
		public static final String clickSelectAllOption="//label[@class='ng-binding']/div[@class='icheckbox_square-green']/ins";
		
		public static final String clickActionsButton="//button[contains(text(),'Actions')]";
		
		public static final String selectEmailOption="//a[contains(text(),'Email')]";
		public static final String enterMailSubject="//label[contains(text(),'Subject* ')]//following::input[1]";
		public static final String enterMailContent="//div[@class='note-editable panel-body']";
		public static final String clickSend="//span[contains(text(),'Send')]";
		
		public static final String clickUpdateButton="//span[contains(text(),'Update')]";
	
		
		//Audience Groups Locators
		public static final String clickGroupsTab="//button[contains(text(),'Groups')]";
		
		public static final String importUsersRadioButton="//div[@class='iradio_square-green']//following::ins[1]";
		public static final String clickUploadButton="//button[contains(text(),'Upload')]";
		
		public static final String clickContinueButton="//button[contains(text(),'Continue')]";
		
		public static final String clickAdduser="//button[contains(text(),'Add')]";
		
		public static final String totalUsersUploadedCount="//div[contains(text(),'Total audience count matching with above selection:')]//following::span[1]";
		public static final String invaliFileErrorMsg="//div[contains(text(),'File format is invalid. Please correct it and try again')]";
		
		public static final String duplicateDataErrorMsg="//div[contains(text(),'Please remove duplicate email ID')]";
		public static final String selectStaffUserTypeGroups="//div[contains(text(),'Staff')]";
		
		
		public static final String totalAudienceCount="//div[contains(text(),'Total Audience Count')]";
		
				                                             
		public static final String clickFilterButtonViewUsers="//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div[1]/div/div[2]/button";
		
		public static final String enterNameViewUsers="//label[contains(text(),'Name')]//following::input[1]";
		
		public static final String clickApplyViewUsers="//span[contains(text(),'Apply')]";
		
		
		
	}
	
	
	
	
	public void selectEqualsOperator()
	{
		
	}
	
	
	

	
	
	
	public static WebElement alertMessageemptyValue(WebDriver driver) throws InterruptedException 
	{
		
		element=driver.findElement(By.xpath("//div[contains(text(),'Please select value')]"));
		return element;
	}
	
	
	public void test2729() throws InterruptedException
	{
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Groups')]")).click();
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//button[contains(text(),'Create New')]")).click();
		
		
		
		String groupname=driver.findElement(By.xpath("//label[contains(text(),'Group Name*')]")).getText();
		
		
		Assert.assertTrue(groupname.contains("*"), "Group name contains asterisk");
		
	}
	
	public  void validateCreateAttributeSuccessmsg() throws InterruptedException
	{
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		
	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Individuals')]")).click();
		Thread.sleep(4000);
		
		
		driver.findElement(By.xpath("//button[@class='btn btn-white btn-sm ng-scope'][2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Select or search group name')]")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Roll Number')]")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.name("name")).sendKeys("testname1");
		
		driver.findElement(By.xpath("//span[contains(text(),'Select field type')]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(text(),'Dropdown')]")).click();
		
		
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//textarea[@placeholder='Description']")).sendKeys("testing");
		
		driver.findElement(By.xpath("//input[@name='Single']//following::ins[1]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[contains(text(),'Add data against this field to be listed for selection*')]//following::input")).sendKeys("testdata1");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Create and Continue')]")).click();
		
		Thread.sleep(4000);
		
		Boolean successmsg=driver.findElement(By.xpath("//div[contains(text(),'Attribute(s) created successfully')]")).isDisplayed();
		
		Assert.assertTrue(successmsg, "Attribute(s) created successfully  message is displayed");
		
	}
	
	
	
	public void checkingUserCounts()
	{
		String userscount=driver.findElement(By.xpath("//span[@class='ng-scope']/a")).getText();
        
        int userscounts = Integer.parseInt(userscount);
        
        if(userscounts>0)
        {
        driver.findElement(By.xpath("//div[2]/button[2]/span[1]")).click();
        }
        
	}
	
	//reusable methods and xpath for Audience-Individuals
	
	
	public void vaidateCreateGroups() throws InterruptedException
	{
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[contains(text(),'Groups')]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Create New')]")).click();
		
		driver.findElement(By.name("personaname")).sendKeys("samplegroup4");
		
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("test");
		
		driver.findElement(By.xpath("//span[contains(text(),'Select or search attribute')]")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Chat group')]")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Select or search operator')]")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Equals')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@id='select_placeholder_aud']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'2009 batch')]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[@class='audience-create-add-btn ng-scope']")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Apply')]")).click();
		
		
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		//Find element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.xpath("//div[2]/button[2]/span[1]"));

        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
        
     
        
        driver.findElement(By.xpath("//div[2]/button[2]/span[1]")).click();
		
		Thread.sleep(5000);
		
		Assert.assertTrue(driver.getPageSource().contains("samplegroup4"),"group created successfully");
		
	}
	
	
	public void validateAlertMsgInvalidMobile() throws InterruptedException
	{
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[contains(text(),'Individuals')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Create New')]")).click();
		
		
		Thread.sleep(4000);
//		driver.findElement(By.xpath("//input[@placeholder='Univeristy Roll Number']")).sendKeys("testunvi123");
//		
//		driver.findElement(By.xpath("//input[@id='new_firstName']")).sendKeys("testname1");
//		
//		
//		driver.findElement(By.xpath("//input[@placeholder='Univeristy Name']")).sendKeys("vit");
//		
//		
//		driver.findElement(By.xpath("//input[@placeholder='Chat group']")).sendKeys("vitgrp1");
//		
//		
//		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("name1");
//		
//		
//		driver.findElement(By.xpath("//span[contains(text(),'Graduation year')]")).sendKeys("2009");
		
		
		driver.findElement(By.xpath("//input[@id='new_mobile_number']")).sendKeys("1221221");
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Create and Continue')]")).click();
		Thread.sleep(4000);
		
		Boolean invalidmobilenomsg=driver.findElement(By.xpath("//div[contains(text(),'Please enter a valid mobile number')]")).isDisplayed();
		
		Assert.assertTrue(invalidmobilenomsg, "alert message is displayed to enter valid mobile number");
		
		
	}
}
