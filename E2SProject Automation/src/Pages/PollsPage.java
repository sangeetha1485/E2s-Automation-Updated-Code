package Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Test.FunctionalTest;
import utility.GenericMEthods;

public class PollsPage extends FunctionalTest{
	
GenericMEthods gm= new GenericMEthods();
	


	public void getHeader() throws InterruptedException {

		Thread.sleep(5000);
        
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row border-bottom ng-scope']//following::h2")));

        String notiftitle=driver.findElement(By.xpath("//div[@class='row border-bottom ng-scope']//following::h2")).getText();
        Assert.assertEquals(notiftitle, "Notifications");
	}


	public void testLaterDisabeled() throws InterruptedException
	{
		
		Thread.sleep(10000);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='top_navigation_heading']")));
		
		WebElement options=driver.findElement(By.xpath("//div[@class='sidebar-collapse']"));

		
		Actions act= new Actions(driver);
		
		act.moveToElement(options).perform();
		
		driver.findElement(By.xpath("//span[contains(text(),'Content Library')]")).click();

		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Polls')]")).click();

		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'Create Poll')]")).click();
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//div[@class='col-sm-12']//following::textarea")).sendKeys("Test Polls 2");
		
		driver.findElement(By.xpath("//button[@id='btnNext']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='poll-choose-custom-template-pod ng-scope']/img[@src='../../img/star-02.png']")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='btnNext']")).click();
		Thread.sleep(3000);


		driver.findElement(By.xpath("//input[@id='edate1']")).click();
		
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//input[@id='edate1']")).sendKeys("29-05-2020 13:51");
		
		Date date=new Date();
		
		DateFormat sdf=new SimpleDateFormat("dd");
		
		String todaydate=sdf.format(date);
		
		driver.findElement(By.xpath("//td[@data-date='29' and @data-month='4']/div")).click();

		
		//driver.findElement(By.xpath("//*[@id='ng-app']/body/div[7]/div[1]/div[2]/table/tbody/tr[5]/td[6]/div")).click();
		
		//driver.findElement(By.xpath("//td[@data-date='29' and  @data-month='3']")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(text(),'Publish')]")).click();
		
		Thread.sleep(5000);

		String isdisabeled=driver.findElement(By.xpath("//div[@class='iradio_square-green disabled']")).getText();
		
		Assert.assertEquals(isdisabeled, "Later");

		
	}

	
	
	
	public void validate2Response() throws InterruptedException
	{
		
		Thread.sleep(10000);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='top_navigation_heading']")));
		
		WebElement options=driver.findElement(By.xpath("//div[@class='sidebar-collapse']"));

		
		Actions act= new Actions(driver);
		
		act.moveToElement(options).perform();
		
		driver.findElement(By.xpath("//span[contains(text(),'Content Library')]")).click();

		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Polls')]")).click();

		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'Create Poll')]")).click();
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//div[@class='col-sm-12']//following::textarea")).sendKeys("Test Polls 2");
		
		driver.findElement(By.xpath("//button[@id='btnNext']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='poll-choose-custom-template-pod ng-scope']/img[@src='../../img/star-02.png']")).click();
		
		Thread.sleep(3000);
		
		
		for( int i=0;i<=2;i++)
		{
			Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'X')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
		
		}
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'X')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
		
		Thread.sleep(3000);
		
		Boolean popupdisplayed=driver.findElement(By.xpath("//div[contains(text(),'Minimum 2 options are required')]")).isDisplayed();
		
		
		Assert.assertTrue(popupdisplayed, "minimum 2 options required message is displayed");
		
	}
	
	public void validateMissingPredifinedTemplates() throws InterruptedException
	{
		
		Thread.sleep(10000);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='top_navigation_heading']")));
		
		WebElement options=driver.findElement(By.xpath("//div[@class='sidebar-collapse']"));

		
		Actions act= new Actions(driver);
		
		act.moveToElement(options).perform();
		
		driver.findElement(By.xpath("//span[contains(text(),'Content Library')]")).click();

		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Polls')]")).click();

		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'Create Poll')]")).click();
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//div[@class='col-sm-12']//following::textarea")).sendKeys("Test Polls 2");
		
		driver.findElement(By.xpath("//button[@id='btnNext']")).click();

		Thread.sleep(3000);
		
		List<WebElement>templatescount=driver.findElements(By.xpath("//div[contains(@class,'poll-choose-custom-template-pod')]"));
		
		Assert.assertEquals(templatescount.size(),12, "predefined templates are present in polls page");
		
	}
	
	
	public void testEQ2701() throws InterruptedException
	{
		
		Thread.sleep(10000);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='top_navigation_heading']")));
		
		WebElement options=driver.findElement(By.xpath("//div[@class='sidebar-collapse']"));

		
		Actions act= new Actions(driver);
		
		act.moveToElement(options).perform();
		
		driver.findElement(By.xpath("//span[contains(text(),'Content Library')]")).click();

		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Polls')]")).click();

		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys("Miscellaneous");
		
		driver.findElement(By.xpath("//input[@id='institution_structure_search']")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),'Miscellaneous')]")).click();
		Thread.sleep(3000);

		
		
		driver.findElement(By.xpath("//button[@type='button']//i")).click();
		driver.findElement(By.xpath("//span[@id='select_placeholder_status']")).click();
		
		
		driver.findElement(By.xpath("//div[contains(text(),'Scheduled') and @id='new_ticket_category']")).click();
		
		//*[@id="page-wrapper"]/div[2]/div[2]/div/div/div/div/div[3]/div/div/div/table/thead/tr/th[4]
		
		List<WebElement>CloseDateCol=driver.findElements(By.xpath("//div[@class='poll-list-view-table']/table/thead/tr/th[4]"));
		  // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
		   
		//how to include AM/PM to time
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm ");  

		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  

		
		for(int i=0;i<CloseDateCol.size();i++)
		{
			//Assert.assertTrue(CloseDateCol.get(i).getText() > currentdate);
		}
		
	}	
				
		public void validatePollPublishPage() throws InterruptedException
		{
			Thread.sleep(10000);
			
			WebDriverWait wait = new WebDriverWait(driver,20);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='top_navigation_heading']")));
			
			WebElement options=driver.findElement(By.xpath("//div[@class='sidebar-collapse']"));

			
			Actions act= new Actions(driver);
			
			act.moveToElement(options).perform();
			
			driver.findElement(By.xpath("//span[contains(text(),'Content Library')]")).click();

			Thread.sleep(3000);
			
			
			driver.findElement(By.xpath("//span[contains(text(),'Polls')]")).click();

			
			Thread.sleep(3000);

			driver.findElement(By.xpath("//button[contains(text(),'Create Poll')]")).click();
			Thread.sleep(3000);

			
			driver.findElement(By.xpath("//div[@class='col-sm-12']//following::textarea")).sendKeys("Test Polls 2");
			
			driver.findElement(By.xpath("//button[@id='btnNext']")).click();

			Thread.sleep(3000);

			driver.findElement(By.xpath("//div[@class='poll-choose-custom-template-pod ng-scope']/img[@src='../../img/star-02.png']")).click();
			
			Thread.sleep(3000);

			driver.findElement(By.xpath("//button[@id='btnNext']")).click();
			Thread.sleep(3000);


			driver.findElement(By.xpath("//input[@id='edate1']")).click();
			
			Thread.sleep(3000);

			//driver.findElement(By.xpath("//input[@id='edate1']")).sendKeys("29-05-2020 13:51");
			
			Date date=new Date();
			
			DateFormat sdf=new SimpleDateFormat("dd");
			
			String todaydate=sdf.format(date);
			
			//driver.findElement(By.xpath("//td[@data-date='"+todaydate+"']/div")).click();

			driver.findElement(By.xpath("//td[@data-date='3' and @data-month='5']")).click();
			
			
			
			Thread.sleep(3000);

			driver.findElement(By.xpath("//span[contains(text(),'Publish')]")).click();
			
			Thread.sleep(5000);
			
			Boolean ispopupdisplayed=driver.findElement(By.xpath("//div[contains(text(),'Poll close date should be greater than start date')]")).isDisplayed();
			
			Assert.assertTrue(ispopupdisplayed, "pop up is displayed to enter close date greater than start date");
			
			//String pollcategory=driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/div[1]/div[1]/span[1]/a")).getText();
			
			//Assert.assertEquals(pollcategory,  "Poll Categories", "poll category page is displayed");
		}
		
}

		
	


