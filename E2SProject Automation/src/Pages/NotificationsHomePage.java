package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Test.FunctionalTest;
import utility.GenericMEthods;


public class NotificationsHomePage  extends FunctionalTest{

	

	GenericMEthods gm= new GenericMEthods();
	


	public void getHeader() throws InterruptedException {

		Thread.sleep(5000);
        
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row border-bottom ng-scope']//following::h2")));

        String notiftitle=driver.findElement(By.xpath("//div[@class='row border-bottom ng-scope']//following::h2")).getText();
        Assert.assertEquals(notiftitle, "Notifications");
	}
	
	
	public void checkDefaults() throws InterruptedException
	{
		//check for card view button
		
		Thread.sleep(4000);
		
		boolean iscardviewpresent=driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).isDisplayed();
        Assert.assertTrue(iscardviewpresent, "card view button is present");

        //check for list view button
		boolean islistviewpresent=driver.findElement(By.xpath("//button[@class='btn btn-sm btn-white']")).isDisplayed();
        Assert.assertTrue(islistviewpresent, "listview  button is present");
        
        //check for filter button
		boolean isfilterpresent=driver.findElement(By.xpath("//button[@class='btn btn-white btn-sm']")).isDisplayed();
        Assert.assertTrue(isfilterpresent, "filter button is present");

        //check for create notification button

		boolean isCreateNotifcationButtonPresent=driver.findElement(By.xpath("//button[contains(text(),'Create Notification')]")).isDisplayed();
        Assert.assertTrue(isCreateNotifcationButtonPresent, "create notification button is present");

        //check for plus button
		boolean isPlusButtonPresent=driver.findElement(By.xpath("//a[@class='ng-scope']//following::img[@src='img/create-new02.png']")).isDisplayed();
        Assert.assertTrue(isPlusButtonPresent, "plus button is present");

        //check for sent status
        boolean isSentStatusdisplayed=driver.findElement(By.xpath("//div[@class='poll-list-grid-box-footer']//li[1]")).isDisplayed();
        Assert.assertTrue(isSentStatusdisplayed, "sent status is present");
        
        //check for hold status

        boolean isHoldStatusdisplayed=driver.findElement(By.xpath("//div[@class='poll-list-grid-box-footer']//li[2]")).isDisplayed();
        Assert.assertTrue(isHoldStatusdisplayed, "hold status is present");


      //check for scheduled status

        boolean isscheduledStatusdisplayed=driver.findElement(By.xpath("//div[@class='poll-list-grid-box-footer']//li[2]")).isDisplayed();
        Assert.assertTrue(isscheduledStatusdisplayed, "scheduled status is present");
        
        //check for report icon 
       // boolean isReprotIcondisplayed=driver.findElement(By.xpath("//a[@class='ng-scope']//i[@class='fa fa-bar-chart']")).isDisplayed();
        //Assert.assertTrue(isReprotIcondisplayed, "report icon is present");
        
        //check for active icon
        boolean isActiveIcondisplayed=driver.findElement(By.xpath("//a[@class='ng-scope']//preceding::img[@tooltip='Active']")).isDisplayed();
        Assert.assertTrue(isActiveIcondisplayed, "report icon is present");

        
        //check for notifications by category displayed
        boolean isNotificationscategorydisplayed=driver.findElement(By.xpath("//div[contains(text(),'Notifications by category')][1]")).isDisplayed();
        Assert.assertTrue(isNotificationscategorydisplayed, "Notifications category text is present");

        

		
		
		//no edit option for miscellanious-pending

	}
	
	
	public void clickPlusSymbolCreateNotification() throws InterruptedException
	{
		//plus symbol-> create notification page
		
		Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@class='ng-scope']//following::img[@src='img/create-new02.png'][1]")).click();

		//driver.findElement(By.xpath("//a[@class='poll-type-create-new-btn']")).click();
		
		//check create notification page is displayed 
        boolean isCreateNotifdisplayed=driver.findElement(By.xpath("//li[@class='ng-scope']//following::strong[contains(text(),'Create Notification')]")).isDisplayed();
        Assert.assertTrue(isCreateNotifdisplayed, "create notification page is displayed");
        gm.navigateToHomePage();
	}
	
	public NotificationsCreationPage clickCreateNotification() throws InterruptedException
	{
		
		gm.navigateToNotificationsHomePage();
		
		Thread.sleep(5000);
		 boolean isCreateNotifdisplayed=driver.findElement(By.xpath("//button[contains(text(),'Create Notification')]")).isDisplayed();
	        Assert.assertTrue(isCreateNotifdisplayed, "create notification page is displayed");
		driver.findElement(By.xpath("//button[contains(text(),'Create Notification')]")).click();
		
		
		Thread.sleep(3000);
		//check create notification page is displayed 
       
        //gm.navigateToHomePage();

		return new NotificationsCreationPage();


	}


	
	
	
	
}
