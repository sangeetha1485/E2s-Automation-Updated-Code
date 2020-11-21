package Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.AudiencePage;
import Pages.AudiencePage.audiencepagelocators;
import utility.Constants;
import utility.ExcelUtils;
import utility.GenericMEthods;
import utility.RepositoryParser;

public class AudienceTest extends FunctionalTest {

	

	AudiencePage ap = new AudiencePage();
	

	GenericMEthods gm = new GenericMEthods();
	
	
	
	
	
	@Test(priority = 1, enabled = false,description="Verify the Internal option is displayed under source when user select Staff from the dropdown of user type")
	public void vaidateTC_AP_006() throws InterruptedException, DocumentException, IOException
	{
		
		
	    
		extentTest = extent.startTest("vaidateTC_AP_006");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		
		Thread.sleep(10000);
		
		
		
		driver.findElement(By.name("personaname")).sendKeys("testpersona4");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(gm.readproperty_file("selectUserType"))).click();
		
		driver.findElement(By.xpath(gm.readproperty_file("selectStaffUserTypeGroups"))).click();
		

		
		String assertInternalOption=driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[2]/form/div/div/div/div[5]/div/div")).getText();
		
		System.out.println("expected text "+assertInternalOption);
		Thread.sleep(5000);
		
		
		
		Assert.assertEquals(assertInternalOption," Internal","Internal option is present for staff user type");
		
	}

	@Test(priority = 2, enabled = false,description="Verify user able to select Source by clicking the Radio button in Create new page")
	public void vaidateTC_AP_007() throws InterruptedException, IOException
	{
		extentTest = extent.startTest("vaidateTC_AP_007");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		
		driver.findElement(By.name("personaname")).sendKeys("testpersona4");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(gm.readproperty_file("selectUserType"))).click();
		
		driver.findElement(By.xpath(gm.readproperty_file("selectStaffUserTypeGroups"))).click();
	

		driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[2]/form/div/div/div/div[5]/div/div/div/ins")).click();
		
		Thread.sleep(5000);
		
		Boolean assertInternalOptiondisplayed=driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[2]/form/div/div/div/div[5]/div/div/div")).isDisplayed();
		
		
		Assert.assertTrue(assertInternalOptiondisplayed, "Internal option can be selected");
		
		
		
		
		
	}
	
	@Test(priority = 3, enabled = true,description="Verify Error message is displayed when user add filter rule without selecting value in the \"Filters for selecting alumni List\" field")
	public void vaidateTC_AP_010() throws InterruptedException, DocumentException, IOException
	{
		
	    
	    
		extentTest = extent.startTest("vaidateTC_AP_010");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		
		Thread.sleep(20000);
		
		gm.click("Xpath", gm.readproperty_file("clickIndividualsTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickPersonasTab"))).click();
		
		Thread.sleep(20000);

		//gm.click("Xpath", gm.readproperty_file("clickPersonasTab"));
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.name("personaname")).sendKeys("testpersona4");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(gm.readproperty_file("enterDescription"))).sendKeys("test");
		
		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Graduation Year')]")).click();
		
		
		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));
		
		
		driver.findElement(By.xpath(gm.readproperty_file("selectEqual"))).click();
		
		
		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(2000);
		
		
		Boolean alertdisplayed=driver.findElement(By.xpath("//div[contains(text(),'Please enter value')]")).isDisplayed();
		
		Assert.assertTrue(alertdisplayed, "Alert message is displayed for leaving value field empty");
		
		
		
		
		
	}
	
	@Test(priority = 4, enabled = false,description="Verify user able to add Filter rule after selecting Attribute, Operator, Value")
	public void vaidateTC_AP_011() throws InterruptedException, IOException
	{
		extentTest = extent.startTest("vaidateTC_AP_011");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		gm.click("Xpath", gm.readproperty_file("clickIndividualsTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickPersonasTab"))).click();

		Thread.sleep(10000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		
		driver.findElement(By.name("personaname")).sendKeys("testpersona4");
		
		
		
		driver.findElement(By.xpath(gm.readproperty_file("enterDescription"))).sendKeys("test");
		
		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(gm.readproperty_file("selectSeatNumber"))).click();
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));
		
		driver.findElement(By.xpath(gm.readproperty_file("selectEqual"))).click();
		
		
		
		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(2000);
		
		
		Boolean alertdisplayed=driver.findElement(By.xpath("//div[contains(text(),'Please select value')]")).isDisplayed();
		
		Assert.assertTrue(alertdisplayed, "Alert message is displayed for leaving value field empty");
		
		
		
		
		
	}
	
	@Test(priority = 5, enabled = false,description="Verify Created rule is displayed when user click plus icon after selecting Attribute,Operator,Value in the Personas create page")
	public void vaidateTC_AP_012() throws InterruptedException, IOException
	{
		extentTest = extent.startTest("vaidateTC_AP_012");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		gm.click("Xpath", gm.readproperty_file("clickIndividualsTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickPersonasTab"))).click();

		Thread.sleep(10000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		
		driver.findElement(By.name("personaname")).sendKeys("testpersona4");
		
		//driver.findElement(By.xpath("//a[@class='select2-choice ui-select-match']//following::span[@class='select2-chosen ng-binding ng-hide']")).click();
		
		//driver.findElement(By.xpath(gm.readproperty_file("selectStaffUserTypeGroups)).click();
		
		driver.findElement(By.xpath(gm.readproperty_file("enterDescription"))).sendKeys("test");
		
		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();
		
		driver.findElement(By.xpath(gm.readproperty_file("selectSeatNumber"))).click();
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));
		
		driver.findElement(By.xpath(gm.readproperty_file("selectEqual"))).click();
		
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//input[@placeholder='Value']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Value']")).sendKeys("12");
		
		
		
		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(3000);
		
		
		Boolean attributePresent=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[1]")).isDisplayed();
		
		Boolean attributeOperator=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")).isDisplayed();
		
		Boolean attributeValue=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]")).isDisplayed();
		
		
		
		if(attributePresent && attributeOperator && attributeValue)
		{
			System.out.println("created rule is displayed");
		}
		
		
		
		
		
		
		
	}
	
	@Test(priority = 6, enabled = false,description="Verify user allow to create more than one rule in the Filters for selecting Student List field of Personas create page")
	public void vaidateTC_AP_013() throws InterruptedException, IOException
	{
		extentTest = extent.startTest("vaidateTC_AP_013");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		gm.click("Xpath", gm.readproperty_file("clickIndividualsTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickPersonasTab"))).click();

		Thread.sleep(10000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		
		driver.findElement(By.name("personaname")).sendKeys("testpersona4");
		
		//driver.findElement(By.xpath("//a[@class='select2-choice ui-select-match']//following::span[@class='select2-chosen ng-binding ng-hide']")).click();
		
		//driver.findElement(By.xpath(gm.readproperty_file("selectStaffUserTypeGroups)).click();
		
		driver.findElement(By.xpath(gm.readproperty_file("enterDescription"))).sendKeys("test");
		
		//entering first rule
		
		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();
		
		driver.findElement(By.xpath(gm.readproperty_file("selectSeatNumber"))).click();
		Thread.sleep(5000);
		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));
		
		driver.findElement(By.xpath(gm.readproperty_file("selectEqual"))).click();
		
		Thread.sleep(3000);
		
		
		//driver.findElement(By.xpath("//span[contains(text(),'Select or search value')]")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Value']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Value']")).sendKeys("12");
		
		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(3000);
		
		
		//entering second rule
		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Program')]")).click();
		
		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));
		
		driver.findElement(By.xpath(gm.readproperty_file("selectEqual"))).click();
		
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Select or search value')]")).click();
		
		
		driver.findElement(By.xpath(gm.readproperty_file("selectValue"))).sendKeys("Dentistry");
		driver.findElement(By.xpath(gm.readproperty_file("selectValue"))).sendKeys(Keys.ENTER);
		//
		
		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(3000);
		
		
		Boolean attributePresent=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[1]")).isDisplayed();
		
		Boolean attributeOperator=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")).isDisplayed();
		
		Boolean attributeValue=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]")).isDisplayed();
		
		Boolean attributePresent1=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[2]/td[1]")).isDisplayed();
		
		Boolean attributeOperator1=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[2]/td[2]")).isDisplayed();
		
		Boolean attributeValue1=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[2]/td[3]")).isDisplayed();
		
		if(attributePresent && attributeOperator && attributeValue && attributePresent1 && attributeOperator1 && attributeValue1)
		{
			System.out.println("created rule is displayed");
		}
		
		
		
		
		
		
		
	}
	
	@Test(priority = 7, enabled = false,description="Verify user able to edit rule by clicking the edit icon appears under Action column in the Rule set")
	public void vaidateTC_AP_014() throws InterruptedException, IOException
	{
		extentTest = extent.startTest("vaidateTC_AP_014");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		gm.click("Xpath", gm.readproperty_file("clickIndividualsTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickPersonasTab"))).click();

		Thread.sleep(10000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		
		driver.findElement(By.name("personaname")).sendKeys("testpersona4");
		
		
		
		driver.findElement(By.xpath(gm.readproperty_file("enterDescription"))).sendKeys("test");
		
		
		
		
		//adding rule
		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath(gm.readproperty_file("selectSeatNumber"))).click();
		Thread.sleep(2000);
		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));
		
		driver.findElement(By.xpath(gm.readproperty_file("selectEqual"))).click();
		
		Thread.sleep(3000);
		
		
	
		
		
		driver.findElement(By.xpath(gm.readproperty_file("selectValue"))).sendKeys("12");
		
		
		
		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(3000);
		
		//*[@id="page-wrapper"]/div[2]/div[2]/form/div/div/div/div[6]/div[2]/div[2]/div/div/table/tbody/tr/td[4]
		
		//clicking on edit
		driver.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
		Thread.sleep(3000);
		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));
	  // driver.findElement(By.xpath("//i[@class='fa fa-check']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Not Equals')]")).click();
		
		Thread.sleep(3000);
		
		
	
		//i[@class='fa fa-pencil']
		
		
		
		driver.findElement(By.xpath("//span[@class='audience-create-add-btn ng-scope']//i")).click();
		Thread.sleep(3000);
		
		String newrule=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")).getText();
		
		Assert.assertEquals(newrule, "Not Equals","user is able to edit rule added");
		
		
		
		
	}
	
	@Test(priority = 8, enabled = false,description="Verify the Manage user page is displayed when user click on the count of the Total audience count matching with above selection")
	public void vaidateTC_AP_018() throws InterruptedException, IOException
	{
		extentTest = extent.startTest("vaidateTC_AP_018");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		Thread.sleep(5000);
		gm.navigateToAudiencePage();
		gm.click("Xpath", gm.readproperty_file("clickIndividualsTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickPersonasTab"))).click();

		Thread.sleep(10000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		
		driver.findElement(By.name("personaname")).sendKeys("testpersona4");
		
		
		
		driver.findElement(By.xpath(gm.readproperty_file("enterDescription"))).sendKeys("test");
		
		
		
		
		//adding rule
		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath(gm.readproperty_file("selectSeatNumber"))).click();
		Thread.sleep(2000);
		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));
		
		driver.findElement(By.xpath(gm.readproperty_file("selectEqual"))).click();
		
		Thread.sleep(3000);
		
		
	
		
		
		driver.findElement(By.xpath(gm.readproperty_file("selectValue"))).sendKeys("12");
		
		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(3000);
		
		
		//clicking on apply
		driver.findElement(By.xpath("//button[@class='ladda-button btn btn-primary btn-sm']")).click();
		Thread.sleep(3000);
		
		//clicking total audience count link
		driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[2]/form/div/div/div/div[6]/div[1]/div/span/a")).click();
		
	
		//*[@id="page-wrapper"]/div[2]/div[2]/form/div/div/div/div[6]/div[1]/div/span/a
		Thread.sleep(3000);
		
		String assertmanageaudience=driver.findElement(By.xpath("//div[@class='col-sm-8 right-side-popup-heading ng-binding']")).getText();
		
		Assert.assertEquals(assertmanageaudience, "Manage Audience","Manage audience page pop is displayed ");
		
		
		
		
		
	}
	
	@Test(priority = 9, enabled = false,description="Verify user able to list the Active and In active personas by selecting Active and In active option in the Status dropdown of the audience personas page")
	public void vaidateTC_AP_027() throws InterruptedException, IOException
	{
		extentTest = extent.startTest("vaidateTC_AP_027");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		gm.click("Xpath", gm.readproperty_file("clickIndividualsTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickPersonasTab"))).click();

		Thread.sleep(10000);
		
		
		
	driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[2]/div[2]/div/div/div[1]/div/div/div[2]/button[1]")).click();
	
	driver.findElement(By.xpath("//span[contains(text(),'Select or search status')]")).click();
	
	//selecting active records
	driver.findElement(By.xpath("//div[contains(text(),'Active')]")).click();
	
	driver.findElement(By.xpath(gm.readproperty_file("clickApplyViewUsers"))).click();
	Thread.sleep(3000);
	
	List<WebElement> activepersonas=driver.findElements(By.xpath("//span[@id='switchery_id']"));
	
	System.out.println(activepersonas.size());
	
	
	
	Thread.sleep(5000);
	
	if(activepersonas.size()!=0)
	{
	for(int i=0;i<activepersonas.size();i++)
	{
		
		
		String bordercolor=driver.findElements(By.xpath("//span[@id='switchery_id']")).get(i).getCssValue("border-color");
		
		System.out.println(bordercolor);
		
		Assert.assertEquals(bordercolor, "rgb(26, 179, 148)","Active personas are displayed in green");	
	}
	}
	
	//selecting inactive records
		driver.findElement(By.xpath("//span[contains(text(),'Active')]")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Inactive')]")).click();
		
		driver.findElement(By.xpath(gm.readproperty_file("clickApplyViewUsers"))).click();
		Thread.sleep(3000);
		
		List<WebElement> inactivepersonas=driver.findElements(By.xpath("//span[@id='switchery_id']"));
		
		System.out.println(inactivepersonas.size());
		
		
		
		Thread.sleep(5000);
		
		if(inactivepersonas.size()!=0)
		{
		for(int i=0;i<inactivepersonas.size();i++)
		{
			
			
			String bordercolor=driver.findElements(By.xpath("//span[@id='switchery_id']")).get(i).getCssValue("border-color");
			
			System.out.println(bordercolor);
			
			Assert.assertEquals(bordercolor, "rgb(223, 223, 223)","Inactive personas are displayed in grey");	
		}
		}
		
	
	}
	
	
	@Test(priority = 10, enabled = false,description="Verify user able to view users if user clicks on count displayed against Total audience count matching with above selection link in the personas page")
	public void vaidateTC_AP_032() throws InterruptedException, IOException
	{
		extentTest = extent.startTest("vaidateTC_AP_032");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
        gm.navigateToAudiencePage();
        gm.click("Xpath", gm.readproperty_file("clickIndividualsTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickPersonasTab"))).click();

		Thread.sleep(10000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		
		driver.findElement(By.name("personaname")).sendKeys("testpersona4");
		
		
		
		driver.findElement(By.xpath(gm.readproperty_file("enterDescription"))).sendKeys("test");
		
		
		
		
		//adding rule
		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath(gm.readproperty_file("selectSeatNumber"))).click();
		Thread.sleep(2000);
		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));
		
		driver.findElement(By.xpath(gm.readproperty_file("selectEqual"))).click();
		
		Thread.sleep(3000);
		
		
	
		
		
		driver.findElement(By.xpath(gm.readproperty_file("selectValue"))).sendKeys("12");
		
		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(3000);
		
		
		//clicking on apply
		driver.findElement(By.xpath("//button[@class='ladda-button btn btn-primary btn-sm']")).click();
		Thread.sleep(3000);
		
		//clicking total audience count link
		driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[2]/form/div/div/div/div[6]/div[1]/div/span/a")).click();
		
		
		
		Thread.sleep(3000);
		
		String assertmanageaudience=driver.findElement(By.xpath("//div[@class='col-sm-8 right-side-popup-heading ng-binding']")).getText();
		
		Assert.assertEquals(assertmanageaudience, "Manage Audience","Manage audience page pop is displayed ");
		
		Boolean userpresent=driver.findElement(By.xpath("//*[@id='manulaclick']/table/tbody/tr/td[2]")).isDisplayed();
		
		Assert.assertTrue(userpresent, "users are displayed in manage audience popup");
		
		
	
	}
	
	@Test(priority = 11, enabled = false,description="Verify user is able to add \"not equal \"option as a rule in persona page")
	public void vaidateTC_AP_033() throws InterruptedException, IOException
	{
		extentTest = extent.startTest("vaidateTC_AP_033");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
        gm.navigateToAudiencePage();
        gm.click("Xpath", gm.readproperty_file("clickIndividualsTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickPersonasTab"))).click();

		Thread.sleep(10000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		
		driver.findElement(By.name("personaname")).sendKeys("testpersona4");
		
		
		
		driver.findElement(By.xpath(gm.readproperty_file("enterDescription"))).sendKeys("test");
		
		
		
		
		//adding rule
		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath(gm.readproperty_file("selectSeatNumber"))).click();
		Thread.sleep(2000);
		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));
		
		driver.findElement(By.xpath("//div[contains(text(),'Not Equals')]")).click();
		
		Thread.sleep(3000);
		
		
	
		
		
		driver.findElement(By.xpath(gm.readproperty_file("selectValue"))).sendKeys("12");
		
		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(3000);
		
		
		//clicking on apply
		driver.findElement(By.xpath("//button[@class='ladda-button btn btn-primary btn-sm']")).click();
		Thread.sleep(3000);
		
		
		Boolean NotEqualsRulePresent=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")).isDisplayed();
		
		//*[@id="page-wrapper"]/div[2]/div[2]/form/div/div/div/div[6]/div[2]/div[2]/div/div/table/tbody/tr/td[2]
		
		Assert.assertTrue(NotEqualsRulePresent, "Not equal option is added");
	
	}
	
	@Test(priority = 12, enabled = false,description="Verify user is able to add greater than or equal option as a rule in persona page")
	public void vaidateTC_AP_034() throws InterruptedException, IOException
	{
		extentTest = extent.startTest("vaidateTC_AP_034");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
        gm.navigateToAudiencePage();
        gm.click("Xpath", gm.readproperty_file("clickIndividualsTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickPersonasTab"))).click();

		Thread.sleep(10000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		
		driver.findElement(By.name("personaname")).sendKeys("testpersona4");
		
		
		
		driver.findElement(By.xpath(gm.readproperty_file("enterDescription"))).sendKeys("test");
		
		
		
		
		//adding rule
		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath(gm.readproperty_file("selectSeatNumber"))).click();
		Thread.sleep(2000);
		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));
		
		driver.findElement(By.xpath("//div[contains(text(),'Greater Than or Equal')]")).click();
		
		Thread.sleep(3000);
		
		
	
		
		
		driver.findElement(By.xpath(gm.readproperty_file("selectValue"))).sendKeys("5");
		
		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(3000);
		
		
		//clicking on apply
		driver.findElement(By.xpath("//button[@class='ladda-button btn btn-primary btn-sm']")).click();
		Thread.sleep(3000);
		
		
		Boolean GreaterthanorequalRulePresent=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")).isDisplayed();
		

		
		Assert.assertTrue(GreaterthanorequalRulePresent, "Greater than or equal option is added");
	
	}
	
	@Test(priority = 13, enabled = false,description="Verify user is able to add Greater than option as a rule in persona page")
	public void vaidateTC_AP_036() throws InterruptedException, IOException
	{
		extentTest = extent.startTest("vaidateTC_AP_036");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
        gm.navigateToAudiencePage();
        gm.click("Xpath", gm.readproperty_file("clickIndividualsTab"));
		driver.findElement(By.xpath(gm.readproperty_file("clickPersonasTab"))).click();

		Thread.sleep(10000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		
		driver.findElement(By.name("personaname")).sendKeys("testpersona4");
		
		
		
		driver.findElement(By.xpath(gm.readproperty_file("enterDescription"))).sendKeys("test");
		
		
		
		
		//adding rule
		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath(gm.readproperty_file("selectSeatNumber"))).click();
		Thread.sleep(2000);
		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));
		
		driver.findElement(By.xpath("//div[contains(text(),'Greater Than')]")).click();
		
		Thread.sleep(3000);
		
		
	
		
		
		driver.findElement(By.xpath(gm.readproperty_file("selectValue"))).sendKeys("5");
		
		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(3000);
		
		
		//clicking on apply
		driver.findElement(By.xpath("//button[@class='ladda-button btn btn-primary btn-sm']")).click();
		Thread.sleep(3000);
		
		
		Boolean GreaterthanRulePresent=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")).isDisplayed();
		

		
		Assert.assertTrue(GreaterthanRulePresent, "Greater than option is added");
	
	}
	
	@Test(priority = 14, enabled = false,description="Verify user able to create new personas with staff")
	public void validateTC_AP_029() throws InterruptedException {

		extentTest = extent.startTest("validateTC_AP_029");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		
		Thread.sleep(5000);
		gm.click("Xpath", audiencepagelocators.createnewbutton);
		Thread.sleep(10000);

		gm.SendKeys("Name", audiencepagelocators.personaname, "test persona 16");

		gm.SendKeys("Xpath", audiencepagelocators.enterDescription, "test");

		gm.click("Xpath", audiencepagelocators.selectAttribute);

		Thread.sleep(3000);

		// write code for seat number

		gm.click("Xpath", audiencepagelocators.selectSeatNumber);
		Thread.sleep(3000);
		gm.click("Xpath", audiencepagelocators.selectOperator);

		// write code for operator

		gm.click("Xpath", audiencepagelocators.selectGreaterThanOrEqual);

		gm.SendKeys("Xpath", audiencepagelocators.selectValue, "5");

		gm.click("Xpath", audiencepagelocators.clickAddButton);

		Thread.sleep(3000);

		gm.click("Xpath", audiencepagelocators.clickApplyButton);
		// ap.checkingUserCounts();

		gm.scrollDown(audiencepagelocators.createpersonaButton);

		gm.click("Xpath", audiencepagelocators.createpersonaButton);

		Thread.sleep(5000);
		Assert.assertTrue(driver.getPageSource().contains("test persona 16"), "persona created successfully");

	}

	@Test(priority = 15, enabled = false,description="Verify that button available in the screen")
	public void validateTC_AI_074() throws InterruptedException, IOException {
		extentTest = extent.startTest("validateTC_AI_074");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		Thread.sleep(5000);

		gm.click("Xpath", audiencepagelocators.clickIndividualsTab);
		
		gm.click("Xpath", audiencepagelocators.clickStaffUserTypeOption);

		gm.click("Xpath", audiencepagelocators.selectStaffUserTypeOption);
		
		gm.click("Xpath", audiencepagelocators.clickImportButton);

		Thread.sleep(5000);

		gm.click("Xpath", audiencepagelocators.clickUploadCSV);

		Thread.sleep(5000);
		// gm.wa
		gm.click("LinkText", audiencepagelocators.clickdownload);

		Thread.sleep(5000);

		String home = System.getProperty("user.home");
		File file = new File(home + "/Downloads/" + "Staff" + ".csv");

		Boolean isfileDeleted = gm.deleteFile(file);

		File LatestFile = gm.getLastModifiedFile(file.getParentFile());

		System.out.println(LatestFile.getName());

		Assert.assertTrue(LatestFile.getName().contains("staff"), "staff template is downloaded");

	}

	@Test(priority = 16, enabled = false)
	public void validateTC_AI_064() throws Exception {
		extentTest = extent.startTest("validateTC_AI_064");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		Thread.sleep(5000);

		gm.click("Xpath", audiencepagelocators.clickIndividualsTab);
		Thread.sleep(10000);

		gm.click("Xpath", audiencepagelocators.clickStaffUserTypeOption);

		gm.click("Xpath", audiencepagelocators.selectStaffUserTypeOption);

		Thread.sleep(3000);
		gm.click("Xpath", audiencepagelocators.clickCustomAttributeBuuton);

		gm.click("Xpath", audiencepagelocators.selectGroupDDL);
		Thread.sleep(3000);
		
		
		
		gm.click("Xpath", audiencepagelocators.selectGroupName);

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.File_TestData);
		Thread.sleep(3000);
		gm.SendKeys("Xpath", audiencepagelocators.enterFieldName, ExcelUtils.getCellData(1, 10));

		gm.click("Xpath", audiencepagelocators.enterFieldType);

		gm.click("Xpath", audiencepagelocators.selectTextFieldType);

		Thread.sleep(3000);
		gm.click("Xpath", audiencepagelocators.clickValidateAsOption);
		gm.click("Xpath", audiencepagelocators.selectValidateAsText);

		gm.SendKeys("Xpath", audiencepagelocators.enterCharacterLimit, "12");

		gm.scrollToElement(audiencepagelocators.clickAddAttributeButton);

		gm.click("Xpath", audiencepagelocators.clickAddAttributeButton);

		Boolean verifyattributeadded = gm.verifyElementCustomAttributeTable(audiencepagelocators.attributeTable,
				ExcelUtils.getCellData(1, 12));

		Assert.assertTrue(verifyattributeadded, "attribute is added to attribute table");

		gm.click("Xpath", audiencepagelocators.clickCreateAndContinue);

		Thread.sleep(10000);
		Boolean attributesadded = driver.findElement(By.xpath(gm.readproperty_file("attributeCreatedSuccessMsg")))
				.isDisplayed();

		Assert.assertTrue(attributesadded, "attributes are added successfully");

	}

	@Test(priority = 17, enabled = false,description="Verify that staff can navigates to create new staff screen")
	public void validateTC_AI_073() throws InterruptedException, IOException {
		extentTest = extent.startTest("validateTC_AI_073");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		Thread.sleep(5000);

		gm.click("Xpath", audiencepagelocators.clickIndividualsTab);

		gm.click("Xpath", audiencepagelocators.clickStaffUserTypeOption);

		gm.click("Xpath", audiencepagelocators.selectStaffUserTypeOption);

		gm.click("Xpath", audiencepagelocators.createnewbutton);

		String[] expected = { "Individuals", "Staff", "Create New" };

		List<WebElement> createnewstaff = driver
				.findElements(By.xpath("//div[@class='audience-breadcrumbs ng-scope']"));

		for (int i = 0; i < expected.length; i++) {

			String breadcrumb = createnewstaff.get(0).getText();

			if (breadcrumb.contains(expected[i])) {

				System.out.println("passed on: " + breadcrumb);
			} else {
				System.out.println("failed on: " + breadcrumb);
			}
		}
	}

	@Test(priority = 18, enabled = false,description="Verify that when there is not entered values and clicking on cancel button")
	public void validateTC_AI_086() throws InterruptedException, IOException {
		extentTest = extent.startTest("validateTC_AI_086");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		Thread.sleep(5000);

		gm.click("Xpath", audiencepagelocators.clickIndividualsTab);

		gm.click("Xpath", audiencepagelocators.clickStaffUserTypeOption);

		gm.click("Xpath", audiencepagelocators.selectStaffUserTypeOption);

		gm.click("Xpath", audiencepagelocators.createnewbutton);

		gm.click("Xpath", audiencepagelocators.clickCancel);
		Thread.sleep(5000);
		Boolean individualspagedisplayed = driver.findElement(By.xpath(gm.readproperty_file("clickIndividualsTab")))
				.isDisplayed();

		Assert.assertTrue(individualspagedisplayed, "On clicking cancel,Individuals home page is displayed");
	}

	@Test(priority = 19, enabled = false,description="Verify that new staff should be created when entered all fields and clicked on Create or Create and Continue button")
	public void validateTC_AI_087() throws Exception {
		extentTest = extent.startTest("validateTC_AI_087");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		Thread.sleep(5000);

		gm.click("Xpath", audiencepagelocators.clickIndividualsTab);

		gm.click("Xpath", audiencepagelocators.clickStaffUserTypeOption);

		gm.click("Xpath", audiencepagelocators.selectStaffUserTypeOption);

		gm.click("Xpath", audiencepagelocators.createnewbutton);

		Thread.sleep(5000);

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.File_TestData);
		Thread.sleep(5000);
		gm.SendKeys("Xpath", audiencepagelocators.enterStaffID, ExcelUtils.getCellData(1, 0));

		gm.SendKeys("Xpath", audiencepagelocators.enterFirstName, ExcelUtils.getCellData(1, 1));

		gm.SendKeys("Xpath", audiencepagelocators.enterLastName, ExcelUtils.getCellData(1, 2));

		gm.SendKeys("Xpath", audiencepagelocators.enterEmail, ExcelUtils.getCellData(1, 3));

		gm.SendKeys("Xpath", audiencepagelocators.clickCampusDDL, ExcelUtils.getCellData(1, 4));

		driver.findElement(By.xpath(gm.readproperty_file("clickCampusDDL"))).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		Thread.sleep(5000);
		gm.click("Xpath", audiencepagelocators.clickDeptDDL);

		gm.SendKeys("Xpath", audiencepagelocators.enterDeptValue, "Finance Department");
		driver.findElement(By.xpath(gm.readproperty_file("enterDeptValue"))).sendKeys(Keys.ENTER);

		gm.click("Xpath", audiencepagelocators.clickrolesDDL);

		gm.click("Xpath", audiencepagelocators.selectAdmin);

		gm.click("Xpath", audiencepagelocators.clickAdd);

		Thread.sleep(3000);

		gm.scrollDown(audiencepagelocators.clickCreate);

		gm.click("Xpath", audiencepagelocators.clickCreate);
		Thread.sleep(5000);

		Assert.assertTrue(gm.isDisplayed("Xpath", audiencepagelocators.staffCreationSuccessMsg),
				"Success message is displayed after staff creation");

		Boolean individualshomepagedisplayed = driver.findElement(By.xpath(gm.readproperty_file("clickIndividualsTab")))
				.isDisplayed();

		Assert.assertTrue(individualshomepagedisplayed, "Individuals home page is displayed");

	}

//	@Test(priority = 20, enabled = false)
//	public void validateTC_AI_066() throws Exception {
//		extentTest = extent.startTest("validateTC_AI_066");
//		Thread.sleep(5000);
//		gm.Wait("//*[@id='top_navigation_heading']");
//		gm.navigateToAudiencePage();
//
//		Thread.sleep(5000);
//
//		// driver.findElement(By.xpath(gm.readproperty_file("clickIndividualsTab)).click();
//		gm.click("Xpath", audiencepagelocators.clickIndividualsTab);
//
//		gm.click("Xpath", audiencepagelocators.clickStaffUserTypeOption);
//
//		gm.click("Xpath", audiencepagelocators.selectStaffUserTypeOption);
//
//		Thread.sleep(5000);
//		// clicking on custom attributes button
//		driver.findElement(By.xpath(gm.readproperty_file("clickCustomAttributeBuuton)).click();
//
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//a[@class='poll-type-create-new-btn']")).click();
//
//		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.File_TestData);
//		
//		driver.findElement(By.xpath("//input[@placeholder='Group name']")).sendKeys(ExcelUtils.getCellData(1, 10));
//
//		// clicking on create group button
//		List<WebElement> buttons = driver
//				.findElements(By.xpath("//button[@class='ladda-button btn btn-primary ng-binding ng-scope']"));
//		buttons.get(2).click();
//
//		Thread.sleep(5000);
//
//		Boolean groupcreatedsuccessmsg = driver
//				.findElement(By.xpath("//div[contains(text(),'Group created successfully')]")).isDisplayed();
//
//		Assert.assertTrue(groupcreatedsuccessmsg, "Success message is displayed after creating group");
//
//		WebElement element = driver.findElement(By.xpath(gm.readproperty_file("selectGroupDDL));
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//
//		Boolean groupcreated = driver.findElement(By.xpath("//span[contains(text(),'Academics Group')]")).isDisplayed();
//
//		Assert.assertTrue(groupcreated, "Created group is displayed in dropdown");
//	}

	@Test(priority = 21, enabled = false,description="Verify user able to compose mail by clicking the Email option from the Action dropdown(staff)")
	public void vaidateTC_AI_041() throws InterruptedException {
		extentTest = extent.startTest("vaidateTC_AI_041");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();

		Thread.sleep(5000);

		// driver.findElement(By.xpath(gm.readproperty_file("clickIndividualsTab)).click();
		gm.click("Xpath", audiencepagelocators.clickIndividualsTab);

		gm.click("Xpath", audiencepagelocators.clickStaffUserTypeOption);

		gm.click("Xpath", audiencepagelocators.selectStaffUserTypeOption);

		Thread.sleep(3000);

		gm.click("Xpath", audiencepagelocators.clickSelectAllOption);

		gm.click("Xpath", audiencepagelocators.clickActionsButton);

		Thread.sleep(3000);

		gm.click("Xpath", audiencepagelocators.selectEmailOption);

		Thread.sleep(3000);

		gm.SendKeys("Xpath", audiencepagelocators.enterMailSubject, "Test Email");

		gm.SendKeys("Xpath", audiencepagelocators.enterMailContent, "Test Email Content");

		// gm.click("Xpath", audiencepagelocators.clickSend);

	}

//	@Test(priority = 22, enabled = false,description="Verify that staff have permission to view the newly Created staff when clicked on hyperlink with name of the staff")
//	public void vaidateTC_AI_089() throws Exception {
//		extentTest = extent.startTest("validateTC_AI_089");
//		Thread.sleep(5000);
//		gm.Wait("//*[@id='top_navigation_heading']");
//		gm.navigateToAudiencePage();
//
//		Thread.sleep(5000);
//
//		gm.click("Xpath", audiencepagelocators.clickIndividualsTab);
//
//		gm.click("Xpath", audiencepagelocators.clickStaffUserTypeOption);
//
//		gm.click("Xpath", audiencepagelocators.selectStaffUserTypeOption);
//
//		Thread.sleep(5000);
//		// clicking on filter button
//		driver.findElement(By.xpath(
//				"//*[@id='page-wrapper']/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/div[1]/div/div[2]/button[1]/i"))
//				.click();
//
//		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.File_TestData);
//	
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//label[contains(text(),'Email ID')]//following::input[1]"))
//				.sendKeys(ExcelUtils.getCellData(1, 3));
//		Thread.sleep(3000);
//		driver.findElement(By.xpath(gm.readproperty_file("clickApply)).click();
//
//		Thread.sleep(3000);
//		Boolean StudentPresent = driver.findElement(By.xpath("//span[contains(text(),'"+ExcelUtils.getCellData(1, 3)+"')]"))
//				.isDisplayed();
//
//		Assert.assertTrue(StudentPresent, "Staff details related to entered email id is displayed");
//
//		Thread.sleep(5000);
//
//		driver.findElement(By.xpath("//div[@class='audience-contact-box-detail-name ng-binding ng-scope']")).click();
//		Thread.sleep(5000);
//		
//
//		
//		// comparing excel input and added staff details
//		Thread.sleep(10000);
//		//Assert.assertEquals(ExcelUtils.getCellData(1, 0), gm.getText("Xpath", audiencepagelocators.enterStaffID),
//				//"entered staff id is not displayed");
//		String enteredfirtname=driver.findElement(By.xpath(gm.readproperty_file("enterFirstName)).getText();
//		String enteredemail=driver.findElement(By.xpath(gm.readproperty_file("enterEmail)).getText();
//		
//		Assert.assertEquals(ExcelUtils.getCellData(1, 1),enteredfirtname, 
//				"entered staff first name is not displayed");
//		
//		Assert.assertEquals(ExcelUtils.getCellData(1, 3), enteredemail,
//				"entered staff email id is not displayed");
//
//	}

	@Test(priority = 23, enabled = false,description="Verify the success message when staff edited the staff details")
	public void vaidateTC_AI_091() throws Exception {
		extentTest = extent.startTest("validateTC_AI_091");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();

		Thread.sleep(5000);

		gm.click("Xpath", audiencepagelocators.clickIndividualsTab);

		gm.click("Xpath", audiencepagelocators.clickStaffUserTypeOption);

		gm.click("Xpath", audiencepagelocators.selectStaffUserTypeOption);

		Thread.sleep(5000);
		// clicking on filter button
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/div[1]/div/div[2]/button[1]/i"))
				.click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[contains(text(),'Email ID')]//following::input[1]"))
		.sendKeys(ExcelUtils.getCellData(1, 3));
		Thread.sleep(3000);
		driver.findElement(By.xpath(gm.readproperty_file("clickApply"))).click();
		
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.File_TestData);
		Thread.sleep(5000);
		Boolean StaffPresent = driver.findElement(By.xpath("//span[contains(text(),'"+ExcelUtils.getCellData(1, 3)+"')]"))
				.isDisplayed();

		Assert.assertTrue(StaffPresent, "Staff details related to entered email id is displayed");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[@class='audience-contact-box-detail-name ng-binding ng-scope']")).click();

		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.File_TestData);
		Thread.sleep(5000);

		driver.findElement(By.xpath(gm.readproperty_file("enterStaffID"))).clear();

		driver.findElement(By.xpath(gm.readproperty_file("enterFirstName"))).clear();

		gm.SendKeys("Xpath", audiencepagelocators.enterStaffID, ExcelUtils.getCellData(1, 0));

		gm.SendKeys("Xpath", audiencepagelocators.enterFirstName, ExcelUtils.getCellData(1, 1));

		gm.click("Xpath", audiencepagelocators.clickUpdateButton);
		Thread.sleep(3000);

		String updatesuccessmsg = gm.getText("Xpath", "//div[contains(text(),'Staff account updated successfully.')]");

		Assert.assertEquals(updatesuccessmsg, "Staff account updated successfully.");

	}

	@Test(priority = 24, enabled = false,description="Verify list of Student is displayed who contains a mail id which is user entered in the a Email field after click Apply button")
	public void vaidateTC_AI_020() throws InterruptedException, IOException {
		extentTest = extent.startTest("vaidateTC_AI_020");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();

		Thread.sleep(5000);

		driver.findElement(By.xpath(gm.readproperty_file("clickIndividualsTab"))).click();

		Thread.sleep(5000);
		// clicking on filter button
		driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/div[1]/div/div[2]/button[1]/i"))
				.click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[contains(text(),'Email ID')]//following::input[1]"))
				.sendKeys("aarathimanokaran@yopmail.com");

		driver.findElement(By.xpath(gm.readproperty_file("clickApply"))).click();

		Thread.sleep(3000);
		Boolean StudentPresent = driver.findElement(By.xpath("//span[contains(text(),'aarathimanokaran@yopmail.com')]"))
				.isDisplayed();

		Assert.assertTrue(StudentPresent, "Student details related to entered email id is displayed");
	}

	@Test(priority = 25, enabled = false,description="Verify user able to list the Active groups by selecting Active option in the Status dropdown of the audience group page")
	public void vaidateTC_AG_008() throws InterruptedException, IOException {
		extentTest = extent.startTest("vaidateTC_AG_008");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		Thread.sleep(5000);
		gm.navigateToAudiencePage();

		Thread.sleep(5000);

		driver.findElement(By.xpath(gm.readproperty_file("clickGroupsTab"))).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//*[@id='page-wrapper']/div[2]/div[2]/div[2]/div/div/div[1]/div/div/div[2]/button[1]"))
				.click();

		driver.findElement(By.xpath("//span[contains(text(),'Select or search status')]")).click();

		// selecting active records
		driver.findElement(By.xpath("//div[contains(text(),'Active')]")).click();

		driver.findElement(By.xpath(gm.readproperty_file("clickApplyViewUsers"))).click();
		Thread.sleep(3000);

		List<WebElement> activepersonas = driver.findElements(By.xpath("//span[@id='switchery_id']"));

		System.out.println(activepersonas.size());

		Thread.sleep(5000);

		if (activepersonas.size() != 0) {
			for (int i = 0; i < activepersonas.size(); i++) {

				String bordercolor = driver.findElements(By.xpath("//span[@id='switchery_id']")).get(i)
						.getCssValue("border-color");

				System.out.println(bordercolor);

				Assert.assertEquals(bordercolor, "rgb(26, 179, 148)", "Active groups are displayed in green");
			}
		}

		// selecting inactive records
		driver.findElement(By.xpath("//span[contains(text(),'Active')]")).click();

		driver.findElement(By.xpath("//div[contains(text(),'Inactive')]")).click();

		driver.findElement(By.xpath(gm.readproperty_file("clickApplyViewUsers"))).click();
		Thread.sleep(3000);

		List<WebElement> inactivepersonas = driver.findElements(By.xpath("//span[@id='switchery_id']"));

		System.out.println(inactivepersonas.size());

		Thread.sleep(5000);

		if (inactivepersonas.size() != 0) {
			for (int i = 0; i < inactivepersonas.size(); i++) {

				String bordercolor = driver.findElements(By.xpath("//span[@id='switchery_id']")).get(i)
						.getCssValue("border-color");

				System.out.println(bordercolor);

				Assert.assertEquals(bordercolor, "rgb(223, 223, 223)", "Inactive groups are displayed in grey");
			}
		}

	}

	@Test(priority = 26, enabled = false,description="Verify the created rule is displayed when user click plus icon after selecting Attribute,Operator,Value in the group edit page")
	public void validateTC_AG_021() throws InterruptedException, IOException {
		extentTest = extent.startTest("vaidateTC_AG_021");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();

		Thread.sleep(5000);

		driver.findElement(By.xpath(gm.readproperty_file("clickGroupsTab"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();

		driver.findElement(By.name("personaname")).sendKeys("testgroup4");

		// driver.findElement(By.xpath("//a[@class='select2-choice
		// ui-select-match']//following::span[@class='select2-chosen ng-binding
		// ng-hide']")).click();

		// driver.findElement(By.xpath(gm.readproperty_file("selectStaffUserTypeGroups)).click();

		driver.findElement(By.xpath(gm.readproperty_file("enterDescription"))).sendKeys("test");

		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();

		driver.findElement(By.xpath("//div[contains(text(),'Program')]")).click();

		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));

		driver.findElement(By.xpath(gm.readproperty_file("selectEqual"))).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[contains(text(),'Select or search value')]")).click();

		driver.findElement(By.xpath("//input[@id='ui_select_search_input_value']")).sendKeys("Dentistry");

		driver.findElement(By.xpath("//input[@id='ui_select_search_input_value']")).sendKeys(Keys.ENTER);


		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(5000);

		Boolean attributePresent = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[1]"))
				.isDisplayed();

		Boolean attributeOperator = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"))
				.isDisplayed();

		Boolean attributeValue = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]"))
				.isDisplayed();

		if (attributePresent && attributeOperator && attributeValue) {
			System.out.println("created rule is displayed");
		}

	}

	@Test(priority = 27, enabled = false,description="Verify user allow to create more than one rule in the Filters for selecting staff List field of group edit page")
	public void vaidateTC_AG_022() throws InterruptedException, IOException {
		extentTest = extent.startTest("vaidateTC_AG_022");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();

		Thread.sleep(10000);

		driver.findElement(By.xpath(gm.readproperty_file("clickGroupsTab"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();

		driver.findElement(By.name("personaname")).sendKeys("testgroup4");

		// driver.findElement(By.xpath("//a[@class='select2-choice
		// ui-select-match']//following::span[@class='select2-chosen ng-binding
		// ng-hide']")).click();

		// driver.findElement(By.xpath(gm.readproperty_file("selectStaffUserTypeGroups)).click();

		driver.findElement(By.xpath(gm.readproperty_file("enterDescription"))).sendKeys("test");

		// entering first rule

		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Program')]")).click();

		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));

		driver.findElement(By.xpath(gm.readproperty_file("selectEqual"))).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[contains(text(),'Select or search value')]")).click();

		driver.findElement(By.xpath("//input[@id='ui_select_search_input_value']")).sendKeys("Dentistry");

		driver.findElement(By.xpath("//input[@id='ui_select_search_input_value']")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(5000);

		// entering second rule
		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();

		driver.findElement(By.xpath(gm.readproperty_file("selectSeatNumber"))).click();

		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));

		gm.click("Xpath", audiencepagelocators.selectGreaterThanOrEqual);
		
		//driver.findElement(By.xpath("//div[contains(text(),'Greater Than or Equal')]")).click();

		Thread.sleep(3000);

		// driver.findElement(By.xpath("//span[contains(text(),'Select or search
		// value')]")).click();

		driver.findElement(By.xpath(gm.readproperty_file("selectValue"))).sendKeys("5");

		// 

		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(3000);

		Boolean attributePresent = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[1]"))
				.isDisplayed();

		Boolean attributeOperator = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"))
				.isDisplayed();

		Boolean attributeValue = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]"))
				.isDisplayed();

		Boolean attributePresent1 = driver
				.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[2]/td[1]")).isDisplayed();

		Boolean attributeOperator1 = driver
				.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[2]/td[2]")).isDisplayed();

		Boolean attributeValue1 = driver
				.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[2]/td[3]")).isDisplayed();

		if (attributePresent && attributeOperator && attributeValue && attributePresent1 && attributeOperator1
				&& attributeValue1) {
			System.out.println("created rule is displayed");
		}

	}

	@Test(priority = 28, enabled = false,description="Verify user able to edit rule by clicking the edit icon appears under Action column in the Rule set of the group edit page")
	public void vaidateTC_AG_023() throws InterruptedException, IOException {
		extentTest = extent.startTest("vaidateTC_AG_023");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickGroupsTab"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();

		driver.findElement(By.name("personaname")).sendKeys("testgroup4");

		driver.findElement(By.xpath(gm.readproperty_file("enterDescription"))).sendKeys("test");

		// adding rule
		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath(gm.readproperty_file("selectSeatNumber"))).click();

		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));

		driver.findElement(By.xpath(gm.readproperty_file("selectEqual"))).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(gm.readproperty_file("selectValue"))).sendKeys("12");

		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(3000);

		// *[@id="page-wrapper"]/div[2]/div[2]/form/div/div/div/div[6]/div[2]/div[2]/div/div/table/tbody/tr/td[4]

		// clicking on edit
		driver.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
		Thread.sleep(3000);

		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));

		driver.findElement(By.xpath("//div[contains(text(),'Not Equals')]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[@class='audience-create-add-btn ng-scope']//i")).click();
		Thread.sleep(3000);

		String newrule = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")).getText();

		Assert.assertEquals(newrule, "Not Equals", "user is able to edit rule added");

	}

	@Test(priority = 29, enabled = false,description="Verify the Manage user page is displayed when user click on the count of the \"Total audience count matching with above selection\"")
	public void vaidateTC_AG_025() throws InterruptedException, IOException {
		extentTest = extent.startTest("vaidateTC_AG_025");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickGroupsTab"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();

		driver.findElement(By.name("personaname")).sendKeys("testgroup4");

		driver.findElement(By.xpath(gm.readproperty_file("enterDescription"))).sendKeys("test");

		// adding rule
		driver.findElement(By.xpath(gm.readproperty_file("selectAttribute"))).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath(gm.readproperty_file("selectSeatNumber"))).click();

		gm.click("Xpath", gm.readproperty_file("selectsearchoperator"));

		driver.findElement(By.xpath(gm.readproperty_file("selectEqual"))).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(gm.readproperty_file("selectValue"))).sendKeys("12");

		driver.findElement(By.xpath(gm.readproperty_file("clickAddButton"))).click();
		Thread.sleep(3000);

		// clicking on apply
		driver.findElement(By.xpath("//button[@class='ladda-button btn btn-primary btn-sm']")).click();
		Thread.sleep(5000);

		// clicking total audience count link
		
		gm.click("Xpath", audiencepagelocators.totalUsersUploadedCount);
		
		Thread.sleep(3000);

		String assertmanageaudience = driver
				.findElement(By.xpath("//div[@class='col-sm-8 right-side-popup-heading ng-binding']")).getText();

		Assert.assertEquals(assertmanageaudience, "Manage Audience", "Manage audience page pop is displayed ");

	}
	@Test(priority = 30, enabled = false,description="Verify error message is displayed when user click create button without filling mandatory fields")
	public void vaidateTC_AG_011() throws InterruptedException, IOException {
		extentTest = extent.startTest("vaidateTC_AG_011");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickGroupsTab"))).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		
		gm.scrollDown("//button[contains(text(),'Cancel')]//following::button[1]");
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]//following::button[1]")).click();
		Thread.sleep(3000);
		String assertErrorPopup = driver
				.findElement(By.xpath("//div[contains(text(),'Please fill all mandatory fields')]")).getText();

		Assert.assertEquals(assertErrorPopup, "Please fill all mandatory fields", "Error pop is displayed on leaving mandatory fields blank ");
		
		
	}
	
	@SuppressWarnings("static-access")
	@Test(priority = 31, enabled = false,description="Verify user is able to upload csv file")
	public void vaidateTC_AG_013() throws Exception {
		extentTest = extent.startTest("vaidateTC_AG_013");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickGroupsTab"))).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		Thread.sleep(3000);
		gm.click("Xpath", audiencepagelocators.importUsersRadioButton);
		
		//gm.click("Xpath", audiencepagelocators.clickUploadButton);
		Thread.sleep(3000);
		gm.uploadFile(audiencepagelocators.clickUploadButton, "C:\\Users\\HP\\Desktop\\Book2.csv");
		Thread.sleep(5000);
		gm.click("Xpath", audiencepagelocators.clickContinueButton);
		
		gm.click("Xpath", audiencepagelocators.clickAdduser);
		Thread.sleep(3000);
		gm.getText("Xpath", audiencepagelocators.totalUsersUploadedCount);
	
		
		gm.click("Xpath", audiencepagelocators.totalUsersUploadedCount);
		//ExcelUtils.setExcelFile("C:\\Users\\HP\\Desktop\\Book2.csv", "Book2");
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HP\\Desktop\\Book2.csv"));  
		
		String line = "";  
		String splitBy = ",";  
		List<String> list=new ArrayList<String>();  
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='manulaclick']/table/tbody/tr"));

		for(int i=1;i<=rows.size();i++)
		{
			//assert.assertEquals(actual, expected);
			list.add(gm.getText("Xpath", "//*[@id='manulaclick']/table/tbody/tr["+i+"]/td[3]")); 
			
			
			
		}
		int csvrecordscount=gm.getRecordsCountInCSV("C:\\Users\\HP\\Desktop\\","Book2.csv");
			
		//String[] employee = line.;   // use comma as separator  
		
		Assert.assertTrue((list.size()==csvrecordscount), "uploaded excel data is uploaded to groups");
		
		
		
			 
			 
		 }
		
	@Test(priority = 32, enabled = false,description="Verify error message is displayed when user import file except .csv format")
	public void vaidateTC_AG_014() throws Exception {
		extentTest = extent.startTest("vaidateTC_AG_014");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickGroupsTab"))).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		Thread.sleep(3000);
		gm.click("Xpath", audiencepagelocators.importUsersRadioButton);
		
		Thread.sleep(3000);
		gm.uploadFile(audiencepagelocators.clickUploadButton, "C:\\Users\\HP\\Desktop\\Book3.xlsx");
		
		
		String errortext=gm.getText("Xpath", audiencepagelocators.invaliFileErrorMsg);
				
		
		
		Assert.assertEquals(errortext, "File format is invalid. Please correct it and try again");
		
	}
	
	 
	@Test(priority = 33, enabled = false,description="Verify user not able to upload duplicate staff while importing users as student")
	public void vaidateTC_AG_016() throws Exception {
		extentTest = extent.startTest("vaidateTC_AG_016");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickGroupsTab"))).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		Thread.sleep(3000);
		gm.click("Xpath", audiencepagelocators.importUsersRadioButton);
		
		Thread.sleep(3000);
		gm.uploadFile(audiencepagelocators.clickUploadButton, "C:\\Users\\HP\\Desktop\\duplicatealumni.csv");
		
		
		String errortext=gm.getText("Xpath", audiencepagelocators.duplicateDataErrorMsg);
				
		
		
		Assert.assertEquals(errortext, "Please remove duplicate email ID");
		
	}	
		 
	@Test(priority = 34, enabled = false,description="Verify user not able to upload duplicate staff while importing users as Staff")
	public void vaidateTC_AG_015() throws Exception {
		extentTest = extent.startTest("vaidateTC_AG_015");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickGroupsTab"))).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(gm.readproperty_file("createnewbutton"))).click();
		Thread.sleep(5000);
		
		gm.click("Xpath", audiencepagelocators.selectUserType);

		gm.click("Xpath", audiencepagelocators.selectStaffUserTypeGroups);
		
		gm.click("Xpath", audiencepagelocators.importUsersRadioButton);
		
		Thread.sleep(3000);
		gm.uploadFile(audiencepagelocators.clickUploadButton, "C:\\Users\\HP\\Desktop\\duplicatestaff.csv");
		
		
		String errortext=gm.getText("Xpath", audiencepagelocators.duplicateDataErrorMsg);
				
		
		
		Assert.assertEquals(errortext, "Please remove duplicate email ID");
		
	}
	
	@Test(priority = 35, enabled = false,description="Verify user able the filter the users with name in the view users page")
	public void vaidateTC_AG_033() throws Exception {
		extentTest = extent.startTest("vaidateTC_AG_033");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();

		Thread.sleep(10000);
		driver.findElement(By.xpath(gm.readproperty_file("clickGroupsTab"))).click();
		Thread.sleep(3000);
		
		List<WebElement>groupmembers=driver.findElements(By.xpath("//div[contains(text(),'Total Audience Count')]//following::span[@class='ng-scope']"));
		
		for(int i=0;i<groupmembers.size();i++)
		{
			if(!(groupmembers.get(i).getText().equals(0)))
					{
				groupmembers.get(i).click();
				gm.click("Xpath", audiencepagelocators.clickFilterButtonViewUsers);
				
				
				Thread.sleep(10000);
				String searchusername=driver.findElement(By.xpath("//div[@class='audience-contact-box-detail-name ng-binding ng-scope'][1]")).getText();
				
				
				
				gm.SendKeys("Xpath", audiencepagelocators.enterNameViewUsers, searchusername);
				
				gm.click("Xpath", audiencepagelocators.clickApplyViewUsers);
				Thread.sleep(5000);
				//String searchtext=driver.findElement(By.xpath("//div[@class='audience-contact-box-detail-name ng-binding ng-scope'][1]")).getText();
				
				Assert.assertTrue(gm.isDisplayed("Xpath", "//div[@class='audience-contact-box-detail-name ng-binding ng-scope'][1]"), "user name matching the search text is not displayed");
				break;
					}
		}
		
		
		
		
		
	}
	
	@Test(priority = 36, enabled = false,description="Verify user able to compose mail by clicking the Email option from the Action dropdown(student)")
	public void vaidateTC_AI_005() throws InterruptedException, IOException
	{
		extentTest = extent.startTest("vaidateTC_AI_005");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		 
		//*[@id="page-wrapper"]/div[2]/div[2]/div[1]/div[1]/div[3]/button
		 
		 Thread.sleep(5000);
		 
		 driver.findElement(By.xpath(gm.readproperty_file("clickIndividualsTab"))).click();
		 
		 
		 Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@class='ng-binding']/div[@class='icheckbox_square-green']/ins")).click();
		


		
		
		 driver.findElement(By.xpath(gm.readproperty_file("clickActionsButton"))).click();
		
		 Thread.sleep(3000);
		
		 driver.findElement(By.xpath(gm.readproperty_file("selectEmailOption"))).click();
		 Thread.sleep(3000);
		 
		 driver.findElement(By.xpath(gm.readproperty_file("enterMailSubject"))).sendKeys("Test Email");
		 
		 driver.findElement(By.xpath(gm.readproperty_file("enterMailContent"))).sendKeys("Test Email Content");
		 
		 //driver.findElement(By.xpath("//span[contains(text(),'Send')]")).click();
		
	}
	
	
	@Test(priority = 37, enabled = false,description="Verify the staff is able create new custom attributes by clicking custom attributes option(student)")
	public void validateTC_AI_030() throws Exception
	{
		extentTest = extent.startTest("validateTC_AI_030");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		
		 
		 Thread.sleep(5000);
		 
		 driver.findElement(By.xpath(gm.readproperty_file("clickIndividualsTab"))).click();
		 
		 Thread.sleep(5000);
		 //clicking on custom attributes button
		
		 driver.findElement(By.xpath(gm.readproperty_file("clickCustomAttributeBuuton"))).click();
		
		 Thread.sleep(5000);
		 
		 driver.findElement(By.xpath(gm.readproperty_file("selectGroupDDL"))).click();
		 
		 driver.findElement(By.xpath("//div[contains(text(),'Academics group')]")).click();
		 
		 //driver.findElement(By.xpath("//label[contains(text(),'Group Name*')]//following::span[@class='select2-chosen']")).click();
		 
		 ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.File_TestData);
			Thread.sleep(5000);
			
			
		 driver.findElement(By.xpath(gm.readproperty_file("enterFieldName"))).sendKeys(ExcelUtils.getCellData(1, 15));
		 
		 driver.findElement(By.xpath(gm.readproperty_file("enterFieldType"))).click();
		 
		 driver.findElement(By.xpath(gm.readproperty_file("selectTextFieldType"))).click();
		 
		 driver.findElement(By.xpath(gm.readproperty_file("enterFieldDesc"))).sendKeys("test");
		 
		 //driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("Interest");
		 
		 driver.findElement(By.xpath(gm.readproperty_file("enterValidateAs"))).click();
		 
		 Thread.sleep(3000);
		 
		 driver.findElement(By.xpath(gm.readproperty_file("selectValidateAsText"))).click();
		 
		 driver.findElement(By.xpath("//input[@placeholder='Character limit']")).sendKeys("10");
		 
		 Thread.sleep(5000);
		 
		 WebElement element = driver.findElement(By.xpath(gm.readproperty_file("clickAddAttributeButton")));
		 
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		 
		 driver.findElement(By.xpath(gm.readproperty_file("clickAddAttributeButton"))).click();
		 
		 Thread.sleep(5000);
		 
		 //WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped margin-bottom-0']"));
		 
		
		 List<WebElement> tableLinks = driver.findElements(By.xpath("//table[@class='table table-striped margin-bottom-0']"));
		 
		for(int i=0;i<tableLinks.size();i++)
		{
				if(tableLinks.get(i).getText().contains(ExcelUtils.getCellData(1, 15)));
				{
					System.out.println("added attribute is displayed in grid");
				}
		 
		 
		}
		 driver.findElement(By.xpath(gm.readproperty_file("clickCreateAndContinue"))).click();
		 Thread.sleep(4000);
		 
		 Boolean attributesadded=driver.findElement(By.xpath("//div[contains(text(),'Attribute(s) created successfully')]")).isDisplayed();
		 
		 Assert.assertTrue(attributesadded, "attributes are added successfully");
		 
		

			
			
		
	}
	
	@Test(priority = 38, enabled = false,description="Verify staff is able to create new group for students")
	public void validateTC_AI_033() throws Exception
	{
		extentTest = extent.startTest("validateTC_AI_033");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		
		 
		
		 
		 Thread.sleep(5000);
		 
		 driver.findElement(By.xpath(gm.readproperty_file("clickIndividualsTab"))).click();
		 
		 Thread.sleep(5000);
		 //clicking on custom attributes button
		 driver.findElement(By.xpath(gm.readproperty_file("clickCustomAttributeBuuton"))).click();
		
		 
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//a[@class='poll-type-create-new-btn']")).click();
		 
		 ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.File_TestData);
			Thread.sleep(5000);
			
		 driver.findElement(By.xpath("//input[@placeholder='Group name']")).sendKeys(ExcelUtils.getCellData(1, 14));
		
		 //clicking on create group button
		 List<WebElement> buttons = driver.findElements(By.xpath("//button[@class='ladda-button btn btn-primary ng-binding ng-scope']"));
		 buttons.get(2).click();
		 
		 Thread.sleep(5000);
		 
		 Boolean groupcreatedsuccessmsg=driver.findElement(By.xpath("//div[contains(text(),'Group created successfully')]")).isDisplayed();
		 
		 Assert.assertTrue(groupcreatedsuccessmsg, "Success message is displayed after creating group");
		 
		 WebElement element = driver.findElement(By.xpath(gm.readproperty_file("selectGroupDDL")));
				 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		
		
		 
		 //driver.findElement(By.xpath(gm.readproperty_file("selectGroupDDL)).click();
			
		 Boolean groupcreated= driver.findElement(By.xpath("//span[contains(text(),'"+ExcelUtils.getCellData(1, 14)+"')]")).isDisplayed();
		 
		 Assert.assertTrue(groupcreated, "Created group is displayed in dropdown");
	}
	
	@Test(priority = 39, enabled = false,description="Verify staff is able to create new group for staffs")
	public void validateTC_AI_066() throws Exception
	{
		extentTest = extent.startTest("validateTC_AI_066");
		Thread.sleep(5000);
		gm.Wait("//*[@id='top_navigation_heading']");
		gm.navigateToAudiencePage();
		 
		
		 
		 Thread.sleep(5000);
		 
		 gm.click("Xpath", audiencepagelocators.clickIndividualsTab);

			gm.click("Xpath", audiencepagelocators.clickStaffUserTypeOption);

			gm.click("Xpath", audiencepagelocators.selectStaffUserTypeOption);


		 Thread.sleep(5000);
		 //clicking on custom attributes button
		 driver.findElement(By.xpath(gm.readproperty_file("clickCustomAttributeBuuton"))).click();
		
		
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//a[@class='poll-type-create-new-btn']")).click();
		 ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.File_TestData);
			Thread.sleep(5000);
			
			
		 driver.findElement(By.xpath("//input[@placeholder='Group name']")).sendKeys(ExcelUtils.getCellData(1, 13));
		
		 //clicking on create group button
		 List<WebElement> buttons = driver.findElements(By.xpath("//button[@class='ladda-button btn btn-primary ng-binding ng-scope']"));
		 buttons.get(2).click();
		 
		 Thread.sleep(5000);
		 
		 Boolean groupcreatedsuccessmsg=driver.findElement(By.xpath("//div[contains(text(),'Group created successfully')]")).isDisplayed();
		 
		 Assert.assertTrue(groupcreatedsuccessmsg, "Success message is displayed after creating group");
		 
		 WebElement element = driver.findElement(By.xpath(gm.readproperty_file("selectGroupDDL")));
				 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		
		 
		 //driver.findElement(By.xpath(gm.readproperty_file("selectGroupDDL)).click();
			
		 Boolean groupcreated= driver.findElement(By.xpath("//span[contains(text(),'"+ExcelUtils.getCellData(1, 13)+"')]")).isDisplayed();
		 
		 Assert.assertTrue(groupcreated, "Created group is displayed in dropdown");
	}
	
	
	
	}

