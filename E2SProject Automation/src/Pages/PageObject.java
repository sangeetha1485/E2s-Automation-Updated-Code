package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {

	WebDriver driver;
	
	WebDriverWait wait;
	
	
	public PageObject(WebDriver driver) {
		
		this.driver=driver;
		
		this.wait=new WebDriverWait(this.driver,15);
	}
		
		//abstract methods
		
		public abstract String getPageTitle();
		
		
		public abstract String getPageHeader(By locator);

		public abstract WebElement getElement(By locator);
		
		public abstract void waitForElementPresent(By locator);
		
		public abstract void waitForPageTitle(String title);
		
		
		//non abstract method
		//passing page class at run time and passing webdriver instance for the declared constructor .new instance is to create instance.instead of new 
		//keyword newinstance is used.check generics topic in java .
		public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass)
		{
			try
			{
				return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}


}
