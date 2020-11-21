package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Test.FunctionalTest;


public class LoginPage extends FunctionalTest {
	
	
	


	


	
	public NotificationsHomePage clickNotificationsOption() throws InterruptedException {
		
		Thread.sleep(10000);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='top_navigation_heading']")));
		
		WebElement options=driver.findElement(By.xpath("//div[@class='sidebar-collapse']"));

		
		Actions act= new Actions(driver);
		
		act.moveToElement(options).perform();
		
		driver.findElement(By.xpath("//span[contains(text(),'Content Library')]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(text(),'Notifications')]")).click();

		return new NotificationsHomePage();
		
		
	}

}
