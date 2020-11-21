package Test;


import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.NotificationsHomePage;

public class LoginTest extends FunctionalTest{
	
	
	
	@Test
	public void run() throws InterruptedException
	{


	LoginPage rp=new LoginPage();
	
	
	rp.clickNotificationsOption();
	
	NotificationsHomePage nhp = new NotificationsHomePage();
	
	nhp.getHeader();
	nhp.checkDefaults();
	
	nhp.clickCreateNotification();
	
	nhp.clickPlusSymbolCreateNotification();
	
	
	
	}
}
