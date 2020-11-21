package Pages;

import Test.FunctionalTest;
import utility.GenericMEthods;

public class ServiceDesk extends FunctionalTest{
	
	GenericMEthods gm = new GenericMEthods(); 
	
	public class ServiceDesklocators extends ServiceDesk
	{
		//inbox locators
		public static final String selectpriority="//span[@id='select_placeholder_priority']//following::span";
		
		public static final String selectsource="//span[contains(text(),'Select or search source')]";
		public static final String enterdesc="//div[@class='note-editable panel-body']";
		public static final String clickaddnotes="//button[contains(text(),'Add Notes')]";
		public static final String selectemplate="//span[contains(text(),'Select or search template')]";
		
		public static final String searchcategoryticket="//*[@id='page-wrapper']/div[2]/div[3]/div/div/div/div[2]/div/div/div[3]/div[1]/div/table/tbody/tr[1]/td[1]/input";
		
		public static final String selectedcategory="//*[@id='page-wrapper']/div[2]/div[3]/div/div/div/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/label";
		public static final String entersubjectvalue="//label[contains(text(),'Subject*')]//following::input";
		public static final String clearaction="//button[contains(text(),'Clear Action')]";
		public static final String servicetickettype="//input[@value='service']";
		public static final String grouptickettype="//input[@value='grouped']";
		public static final String confnotes="(//div[@id='note1']/div[2]/div[4]/div[3])[2]";
		
		public static final String clickclose="//button[contains(text(),'Close')]";
		public static final String clicktransfer="//button[contains(text(),'Transfer')]";
		public static final String clickaddreminder="//button[contains(text(),'Add Reminder')]";
		
		public static final String clickaddtask="//table/tbody/tr/td/div[1]/div[1]/button[5]";
		public static final String taskname="//input[@id='new_task']";
		public static final String priority="//a[@id='priority']/span";
		
		public static final String selecthigh="//li[2]/div/div";
		public static final String comppercentage="//input[@id='percentage']";
		
		public static final String clickhold="//button[contains(text(),'Hold')]";
		public static final String clickcreatenew="//button[contains(text(),' Create New')]";
		public static final String addremainder="//button[contains(text(),'Add Reminder')]";
         
		public static final String cliccreatandcontinue="//span[contains(text(),'Create and Continue')]";
		public static final String cliccreate="//span[contains(text(),'Create')]";
		
		public static final String clickMyticketstab="//*[@id='page-wrapper']/div[2]/div[1]/div[2]/div/div/div/div[3]/div[2]/div/div/ul/li[1]/a";
		
		public static final String clickunassignedtab="//*[@id='page-wrapper']/div[2]/div[1]/div[2]/div/div/div/div[3]/div[2]/div/div/ul/li[2]/a";
		
		public static final String clickonholdtab="//*[@id='page-wrapper']/div[2]/div[1]/div[2]/div/div/div/div[3]/div[2]/div/div/ul/li[3]/a";
		public static final String clickmyteamtab="//*[@id='page-wrapper']/div[2]/div[1]/div[2]/div/div/div/div[3]/div[2]/div/div/ul/li[4]/a";
		
		public static final String clickmyactiontab="//span[contains(text(),'My Actions')]";
		public static final String selectnormalpriority="//div[contains(text(),'Normal')]";
		public static final String selecthighpriority="//div[contains(text(),'High')]";
		public static final String attachfiles="//input[@id='upload']";
		public static final String ticketlink="//*[@id='page-wrapper']/div[2]/div[1]/div[2]/div/div/div/div[3]/div[3]/div[2]/div/div/div[1]/div/table/tbody[1]/tr[1]/td[8]/div/label/a";
		public static final String tickethistory="//a[contains(text(),'Ticket History')]";
		public static final String tickethistorycontents="//timeline-panel/div/div[1]/div";
		public static final String clickcreateandtransfer="//span[contains(text(),'Create & Transfer')]";
		
		public static final String clickmyaction="//span[contains(text(),'My Action')]";

		public static final String transferredbyme="//*[@id='page-wrapper']/div[2]/div[1]/div[2]/div/div/div/div[3]/div[2]/div/div/ul/li[7]/ul/li[1]/a/div";
		public static final String enternotes="//label[contains(text(),'Notes')]//following::div[4]";
		
		public static final String selectcampus="//span[contains(text(),'Select or search campus')]";
		public static final String selectdept="//span[contains(text(),'Select or search department')]";
		public static final String selectteam="//span[contains(text(),'Select or search team')]";
		
		public static final String selectuser="//span[contains(text(),'Select or search user')]";
		public static final String visibletostudent="//div/div/ins";
		
		//confidential notes-view access
		public static final String clickadd="//input[@type='submit']";
		
		//configuration locators-ticket templates
		
		public static final String clickfeaturesetup="//*[@id='feature']/a/span";
		public static final String featureticketoption="//*[@id='ticket']/a/span";
		public static final String clicktickettemplateoption="//*[@id='feature']/ul/div[1]/li[3]/a/span";
		public static final String createnewtemplate="//*[@id='page-wrapper']/div/div/div/div[1]/div/div[2]/div[1]/button";
		public static final String templatename="//label[contains(text(),'Name*')]//following::input[1]";
		public static final String selecctticketwellbeingcategory="//*[@id='ng-app']/body/div[7]/div/div/div/div/div[2]/div[3]/div[1]/div/div[1]/div[1]/div[2]/div/span/h5";
		public static final String selecttemplatepriority="//*[@id='select_placeholder_priority']";
		
		
		public static final String ticketcategories="//span[contains(text(),'Ticket Categories')]";
		public static final String searchcategory="//input[@placeholder='Search Category']";
		public static final String selectcategory="//*[@id='page-wrapper']/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/span/h5";
		public static final String defaultpriority="//span[@id='select_placeholder_priority']//following::span[2]";
		
		
		public static final String selectsourcevalue="//*[@id='select_placeholder_source']";
		public static final String selectrequesttype="//*[@id='select_placeholder_call']";
		public static final String selectpreferredmode="//*[@id='select_placeholder_pmode']";
		public static final String entersubject="//label[contains(text(),'Subject*')]//following::input[1]";
		
		public static final String enterdescvalue="//div[@class='note-editable panel-body']";
		public static final String enterresolution="//textarea[@class='note-codable']//following::div[13]";
		public static final String createtemplate="//span[contains(text(),'Create')]";
		
		public static final String configurationoption="//*[@id='feature']/ul/div[1]/li[7]/a/span";
		
		
		public static final String requesteroption="//*[@id='page-wrapper']/div/div/div/div/div/div[2]/div/div[1]/div/div/div/ul[1]/li[4]/a";
		public static final String associatereqyesoption="//*[@id='page-wrapper']/div/div/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/div/div/div/span[1]/div/ins";
		public static final String associatereqnooption="//*[@id='page-wrapper']/div/div/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div/div/div/div/span[2]/div/ins";
		
		public static final String associatereqgrpticketyesopt="//*[@id='page-wrapper']/div/div/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/span[1]/div/ins";
		public static final String associatereqgrpticketnoopt="//*[@id='page-wrapper']/div/div/div/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/span[2]/div/ins";
		
		
		//student portal locators
		public static final String clickenquiry="//*[@id='navbar-menu']/ul/li[3]/a";
		public static final String clickmyenquiry="//*[@id='navbar-menu']/ul/li[3]/ul/li[1]/a";
		public static final String enqhistory="//bdi[contains(text(),'Enquiry History')]";
		
		
		
		
		
		
	}

}
