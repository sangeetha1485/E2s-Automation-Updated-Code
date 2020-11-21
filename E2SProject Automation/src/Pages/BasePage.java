package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends PageObject {

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}

	@Override
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
		}

	@Override
	public String getPageHeader(By locator) {
		// TODO Auto-generated method stub
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		// TODO Auto-generated method stub
		WebElement ele=null;
		try {
		
			ele=driver.findElement(locator);
			
		}
		
		catch(Exception e)
		{
			System.out.println("some error has occured due to" + ele);
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public void waitForElementPresent(By locator) {
		// TODO Auto-generated method stub
		try {
			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			
		}
		catch(Exception e)
		{
			System.out.println("some error has occured while waiting for the element" +locator.toString());
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		// TODO Auto-generated method stub
		
		try {
			
			wait.until(ExpectedConditions.titleContains(title));
			
		}
		catch(Exception e)
		{
			System.out.println("some error has occured while waiting for the element" +title);
		}
		
	}

}
