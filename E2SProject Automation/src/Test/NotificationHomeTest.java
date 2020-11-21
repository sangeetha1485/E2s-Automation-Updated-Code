package Test;

import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.NotificationsHomePage;

public class NotificationHomeTest  extends FunctionalTest{
	
	LoginPage lp = new LoginPage();

	NotificationsHomePage nhp= new NotificationsHomePage();

	@Test
	public void Login() throws InterruptedException
	{
	
		

		Thread.sleep(5000);
		
		lp.clickNotificationsOption();
		
		nhp.getHeader();
		nhp.checkDefaults();
		nhp.clickCreateNotification();
		
		nhp.clickPlusSymbolCreateNotification();
	}
	

}
