//package Tests;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Notifications {

	WebDriver driver;
	
	@Test
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Documents\\selenium\\chromedriver_win32_old\\chromedriver.exe");

		 driver= new ChromeDriver();
		 
		driver.get("https://edgehill-iuat.engage2serve.com/#/login");


		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@name='usrnm']")).sendKeys("edgehill.iuat@yopmail.com");
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("demodemo");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//div[@class='sidebar-collapse']")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Content Library')]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(text(),'Notifications')]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'Create Notification')]")).click();
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//div[@class='dropDownSelect2Popup ui-select-container select2 select2-container ng-valid']")).click();
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//div[contains(text(),'EH Sports')]")).click();
		
		Thread.sleep(3000);
		
		
		String notificationtitle="test8";
		
		
		driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-valid ng-valid-maxlength']")).sendKeys(notificationtitle);
		
		driver.findElement(By.xpath("//div[contains(text(),'200 characters max')]//preceding::textarea")).sendKeys("entering sample text");

		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//button[contains(text(),'Lock Screen Preview')]")).click();
		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//a[contains(text(),'X')]")).click();


		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='btnNext']")).click();
		
		driver.findElement(By.xpath("//div[@class='note-editable panel-body']")).sendKeys("testing");
		
		driver.findElement(By.xpath("//button[contains(text(),'Mobile Preview')]")).click();

		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//a[contains(text(),'X')]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='btnNext']")).click();
		
		Thread.sleep(3000);

		
		//driver.findElement(By.xpath("//label[contains(text(),'Later')]//preceding::ins[1]")).click();


		
//		driver.findElement(By.xpath("//div[@id='sDate']")).sendKeys("15-05-2020");
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

		
		driver.findElement(By.xpath("//input[@type='search' and @placeholder='Search by title']")).sendKeys(notificationtitle);

		Thread.sleep(5000);

		
		Actions builder = new Actions(driver);        
		builder.sendKeys(Keys.ENTER);


		driver.findElement(By.xpath("//a[@tooltip='Report']")).click();

		Thread.sleep(5000);

		driver.quit();
		
		
	}
		
	}
	


