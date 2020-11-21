package Pages;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Test.FunctionalTest;
import utility.GenericMEthods;


public class AppointmentPage {

	static GenericMEthods gm= new GenericMEthods();
	WebDriver driver;




		private static WebElement element =null;
		
		public class appointmentpagelocators extends AppointmentPage
		{
			//xpath for appointment 
			public static final String clickCalendarOption="//span[contains(text(),'Calendar')]";
			
			public static final String clickAppointment="//a[contains(text(),'Appointment')]";
			
			public static final String clickCreateAppnmt="//i[@class='fa fa-plus-circle calendar-create ng-scope']";
			
			public static final String selectType="//*[@id='eventtypeOptions']/span[2]/span";
			public static final String clickCreateType=" //*[@id='tab-1']/div[1]/div/div/table/tbody/tr/td[2]/a";
			public static final String enterType="//input[@id='ui_select_search_input_appointment']";
			public static final String clickPublishAvailability="//span[contains(text(),'Publish Availability')]//preceding::ins";
			public static final String clickBookAppoinmtWithUser="(//span[contains(text(),'Book appointment with user')]//preceding::ins)[2]";
			//Clicking + Icon from Appointment Tab- //a[contains(text(),'Appointment')]

			public static final String enterDescription="//*[@id='note1']/div[2]/div[4]/div[3]";
			public static final String selectDropDown ="//div[contains(text(),'Appointment 2020')]";
			public static final String clickSaveAsDraft="//span[contains(text(),'Save as Draft')]";
			public static final String clickCalOption="//*[@id='page-wrapper']/div[2]/div[1]/div[1]/ol/li[1]/a";
			public static final String clickDraftsTab="//button[contains(text(),'Draft')]";
			public static final String enterTitle="//input[@placeholder='Title']";
			public static final String confirmApmntCancel="//span[contains(text(),'Confirm')]";
			public static final String selectUserTypeDdl="(//div[@id='user-dropdown']/a/span)[1]";
			
			public static final String enterUserTypeval="(//input[@id='ui_select_search_input_'])[6]";
			public static final String selectStudentddl="//span[@id='select_placeholder_student']";
			public static final String enterStudentID="//input[@id='ui_select_search_input_ID']";
			public static final String clickBookingInfoButton="//button[contains(text(),'Booking Information')]";
			public static final String  clickStartDate="//input[@id='startDate']";
			public static final String enterSubjectval="//input[@name='subject']";
			public static final String enterPurposeOfMeetingval="//input[@name='purposeMeeting']";
			public static final String clickSubmitbtn="//span[contains(text(),'Submit')]";
			public static final String bookingappnmtsuccessmsg="//div[contains(text(),'Booking information has been saved successfully')]";
			
		
			
			public static final String selectPattern="//span[contains(text(),'Select or search pattern')]";
			
			public static final String selectSinglePattern="//div[contains(text(),'Single')]";
			public static final String selectRecurringRegularPattern="//div[contains(text(),'Recurring - Regular')]";
			
			public static final String clickSessionMinutesddl="//span[contains(text(),'Minutes')]";
			
			public static final String selectDate="//input[@id='sdate1']";
			
			public static final String uploadImage="//button[contains(.,'Select Image')]";
			
			public static final String  SelectSaveButtonFromPopupMessage="//div[contains(@class,'btn btn-primary ng-binding')]";
			public static final String selectStartTime="//span[@id='select_placeholder_val']";
			
			public static final String selectslotDuration="//a[@placeholder='Select Duration']";
			public static final String selectTenMinutes="//div[contains(text(),'10')]";
			public static final String selectPatternEndDate="//input[@id='endDate123']";
			
			public static final String selectEndtime="//div[@id='endTimehour-dropdown']";
			
			public static final String sessionStartTimeHour="(//input[@id='ui_select_search_input_'])[2]";
			public static final String sessionStartTimeMins="(//input[@id='ui_select_search_input_'])[3]";
			public static final String clickEditSessionIcon="//*[@id='tab-1']/div[1]/form/div[11]/div/div/div[1]/div/div[2]/ul/li[1]/span/i";
			public static final String clickUpdateSession="//button[contains(text(),'Update Session')]";
			
			public static final String selectCampusDdl="//span[@id='select_placeholder_campus']";
			public static final String selectCampusValue="//div[contains(text(),'Clinical Campus - Kluang')]";
			public static final String selectCampusValue1="//div[contains(text(),'Clinical Campus - Batu Pahat')]";
			
			public static final String enterCampusValue="//input[@id='ui_select_search_input_campus']";
			public static final String draftsupdatemsg="//div[contains(text(),'Drop-in updated successfully')]";
					
			public static final String selectLocation="//span[@id='select_placeholder_location']";
			public static final String selectLocationValue="//div[contains(text(),'South Block')]";
			public static final String getSelectedLocation="//*[@id='location-dropdown']/a/span[2]/span";
			
			public static final String selectRoom="//div[@id='room-dropdown']";
			public static final String selectRoomValue="//div[contains(text(),'South B')]";
			public static final String clickBookAppointmentoption="//span[contains(text(),'Book Appointment')]";
			public static final String calendardates="//div[@class='cal-cell1 cal-cell  pointer']";
			public static final String completedtab="//button[contains(text(),'Completed')]";
			public static final String completedappmnts="(//div[@class='drop-in-event-list-status'])[1]";
			
			
			public static final String ClickonSaveandPublishbutton="//span[contains(text(),'Save and Publish')]";
			public static final String clickEditDraftsAppnmt="//span[@tooltip='Edit']/i";
			public static final String appnmtCreationSuccessMsg="//div[contains(text(),'Appointment created successfully')]";
			public static final String dropCreationSuccessMsg="//div[contains(text(),'Drop-in created successfully')]";
			public static final String anotherCalScheduledMsg="//div[contains(text(),'You have another calendar scheduled in the same duration')]";
			public static final String sessionCreatedSuccessMsg="//div[contains(text(),'Session created successfully')]";
			public static final String clickCancelledTab="//button[contains(text(),'Cancelled')]";
			public static final String enterAppnmtUserType="//*[@id='ui_select_search_input_appointment']";
			public static final String enterTimeGraterThanCurrentTime="//div[contains(text(),'Please select hour greater than current time')]";
			public static final String enterDiffRoom="//div[contains(text(),'Selected Room is already occupied by another session')]";
			public static final String clickServiceDddl="(//*[@id='patternOption']/span[2])[2]";
			public static final String enterservicename="//input[@id='ui_select_search_input_service']";
			public static final String clickSaveButton="//button[contains(text(),'Save')]";
			//locators for comparing submitted data
			
			public static final String getPattern="(//span[@id='type_selected'])[1]";
			
			public static final String getStartDate="//label[contains(text(),'Start Date*')]//following::input";
			public static final String getendDate="//label[contains(text(),'End Date*')]//following::input";
			public static final String getService="(//*[@id='patternOption']/span[2])[2]";
			public static final String getCampusValue="//label[contains(text(),'Campus*')]//following::span[2]";
			public static final String getLocationValue="//label[contains(text(),'Location*')]//following::span[2]";
			public static final String getRoomValue="//label[contains(text(),'Room*')]//following::span[2]";
			public static final String getMaxAttendees="//label[contains(text(),'Maximum Attendees*')]//following::input";
			public static final String getRoomAdvisor="//label[contains(text(),'Advisor*')]//following::span";
			public static final String getStartTime="//*[@id='startTimehour-dropdown']/a/span[2]";
			public static final String getEndTime="//*[@id='endTimehour-dropdown']/a/span[2]";
			
			
			//locators for create location
			
			public static final String clickCreateLocation="//a[@tooltip='Create Location']";
			public static final String enterLocationName="//input[@placeholder='Name']";
			
			
			public static final String selectCampus="(//span[@id='type_selected'])[4]";
			
			public static final String enterDesc="//textarea[@placeholder='Description']";
			public static final String clickCreateButton="(//button[contains(text(),'Cancel')]//following::span[contains(text(),'Create')])[2]";
			
			//locators for create room
			public static final String clickCreateRoomPlusButton="(//table/tbody/tr/td[2]/a)[3]";
			public static final String enterRoomName="//input[@id='title']";
			public static final String	enterRoomDesc="//textarea[@placeholder='Description']";	
			public static final String enterCapacity="//input[@id='capacity']";
			public static final String clickCreateRoom="//button[@class='ladda-button btn btn-primary ng-binding']";
			public static final String clickSelectRoom="//*[@id='select_placeholder_room']";		
			public static final String selectedRoomValue="//*[@id='room-dropdown']/a/span[2]/bdi";
			public static final String  enterSessionName="//input[@placeholder='Session Name']";
			public static final String clickAdvisorddl="//span[contains(text(),'Select or search advisor')]";
			public static final String enterAdvisorName="//input[@id='ui_select_search_input_advisor']";	
					
			public static final String enterCampusText="//input[@id='ui_select_search_input_campus']";	
			public static final String enterLocationText="//input[@id='ui_select_search_input_location']";
			public static final String enterRoomText="//input[@id='ui_select_search_input_room']";
			public static final String addSession="//button[contains(text(),'Add Session')]";
			
			//locators for slot page
			
			public static final String appointmentName="//*[@id='tab-2']/div/div/div[1]/div[1]/div/div[1]/div/div[1]/span";
			public static final String geDateAndTime="//table[@class='calendar-session-info-box-container-table']/tbody/tr[1]/td[3]";
			public static final String getTotalSlots="//table[@class='calendar-session-info-box-container-table']/tbody/tr[2]/td[3]";
			
			public static final String getBookedSlots="//table[@class='calendar-session-info-box-container-table']/tbody/tr[3]/td[3]";
			public static final String getAvailableSlots="//table[@class='calendar-session-info-box-container-table']/tbody/tr[4]/td[3]";
			public static final String getStatus="//table[@class='calendar-session-info-box-container-table']/tbody/tr[5]/td[3]";
			public static final String clickDelete="//button[contains(text(),'Delete')]";
			
			public static final String clickBook="//button[contains(text(),'Book')]";
			public static final String enterAlumni="//input[@id='ui_select_search_input_ID']";
			
			
			public static final String selectUserType="//*[@id='select_placeholder_user']";
			public static final String selectStudent="//*[@id='select_placeholder_student']";
			public static final String selectAppmntType="//*[@id='eventtypeOptions']/span[2]";
			
			
			public static final String enterSubject="//input[@placeholder='Subject']";
			
			public static final String enterPurposeOfMeeting="//input[@name='purposeMeeting']";
			public static final String clickSubmit="//span[contains(text(),'Submit')]";
			public static final String clickCancel="//button[contains(text(),'Cancel')]";
			
			public static final String clickViewDetails="//button[contains(text(),'View Details')]";
			public static final String enterUserType="(//input[@id='ui_select_search_input_'])[2]";
			
			
			//locators for view details page
			public static final String getStudentName="//table/tbody/tr/td[2]/table/tbody/tr[1]/td/span[1]";
			public static final String clickTransfer="//span[contains(text(),'Transfer')]";
			
			public static final String clickCancelAppointment="//button[contains(text(),'Cancel Appointment')]";
			public static final String clickCancelSession="//button[contains(text(),'Cancel Session')]";
		
			public static final String clickConfirmArrival="//button[contains(text(),'Confirm Arrival')]";
			public static final String clickAttendance="//button[contains(text(),'Attendance')]";

			public static final String clickActionTrack="Action Track";
			public static final String clickLinkages="Linkages";
			public static final String clickRecentFeedback="Recent Feedback";
			public static final String getStudentID="//table/tbody/tr/td[2]/table/tbody/tr[3]/td[3]";
			public static final String getEmail="//table/tbody/tr/td[2]/table/tbody/tr[4]/td[3]";
			public static final String getServiceName="//table/tbody/tr/td[2]/table/tbody/tr[4]/td[3]";
					
			public static final String getStaffName="//table/tbody/tr[2]/td[3]";
			public static final String getDate="//table/tbody/tr[3]/td[3]";
			
			public static final String selectService="//*[@id='select_placeholder_service']";
			public static final String selectStaff="//*[@id='select_placeholder_staff']";
			public static final String selectTypeValue="//*[@id='select_placeholder_type']";
			
			public static final String selectFrom="//*[@id='startDate']/div/input";
			public static final String selectTo="//*[@id='endDate']/div/input";
			
			public static final String clickSearch="//button[2]/span[1]/strong";
			public static final String enterNotes="//*[@id='page-wrapper']/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div[4]/textarea";
			public static final String clickSubmitButton="//span[contains(text(),'Submit')]";
			
			public static final String enterServiceName="//input[@id='ui_select_search_input_service']";
			public static final String enterStaffName="//input[@id='ui_select_search_input_staff']";
			public static final String clickStaffddl="//span[@id='select_placeholder_staff']";
			public static final String clickNotesTab="//button[contains(text(),'Notes')]";
			public static final String enterNotesText="//textarea[@ng-model='popup.notes']";
			
			
			
			//configuration page -locators
			public static final String clickConfiguration="(//*[@id='mnu_home2']/a/span)[2]";
			public static final String clickfeaturesetup="//*[@id='feature']/a/span";

			public static final String clickCalendar="//span[contains(.,' Calendar')]";
			public static final String clickCalendarType="//div[8]/li/a/span";
			
			public static final String clickFilterButton="//div[@class='btn-group']//button";
			public static final String clickType="//span[@id='select_placeholder_type']";
			
			public static final String selectAppointmenttype="//div[contains(text(),'Appointment')]";
			
			public static final String selectStatus="//span[@id='select_placeholder_defaultTag']";
			
			public static final String selectActive="//div[contains(text(),'Active')]";
			
			public static final String clickApply="//span[contains(text(),'Apply')]";
			public static final String clickCalendarService="//span[contains(text(),'Calendar Service')]";
			public static final String searchService="//input[@placeholder='Search service']";
			
			public static final String selectServiceValue="//*[@id='page-wrapper']/div/div/div/div/div/div[2]/div[1]/div/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div/span/h5";
			public static final String calendarTypeTable="//table/tbody/tr/td[1]";
			public static final String clickAssociateUsersTab="Associate Users";
			public static final String searchstaff="//input[@placeholder='Search by staff']";
			
			public static final String clickUpdateButon="//button[contains(text(),'Update')]";
			public static final String UserList="(//div[@class='panel-body'])[1]";
			public static final String Advisorcol="(//div[@class=panel-body])[2]";
			public static final String enterCalServiceName="//input[@ng-model='calendarService.name']";
			public static final String selectAppnmtType="//input[@id='multi_search_input_appointment']";
			public static final String selectBookingForm="//span[@id='select_placeholder_appointment']";
			
			public static final String enterBookingFormName="(//input[@id='ui_select_search_input_'])[9]";
			public static final String clickFormsOption="//span[contains(text(),'Forms')]";
			
			public static final String clickFormsFilter="//button[@class='btn btn-white btn-sm']";
			public static final String clickFormTypeDdl="//span[contains(text(),'Select or search form type')]";
			public static final String selectAppointmentFormType="//div[contains(text(),'Appointment')]";
			public static final String clickApplyformtype="//span[contains(text(),'Apply')]";
			public static final String editFormType="//table/tbody/tr[1]/td[5]/span[1]/a";
			public static final String customFormField1="//*[@id='tab-2']/div[4]/div/table/tbody/tr[2]/td[1]";
			
			
			public static final String customFormField2="//*[@id='tab-2']/div[4]/div/table/tbody/tr[4]/td[1]";
			
			public static final String customFormField3="//*[@id='tab-2']/div[4]/div/table/tbody/tr[5]/td[1]";
			
			
			//student portal locators
			public static final String selectAdvisor="//span[@id='select_placeholder_advisor']";
			public static final String enterAdvisor="//input[@id='ui_select_search_input_advisor']";
			
			public static final String selectAppointmentType="//span[@id='select_placeholder_appointment']";
			public static final String enterAppointmentType="//input[@id='ui_select_search_input_appointment']";
			
			public static final String clickMyProfile="//a[contains(text(),'My Profile')]";
			public static final String clickAppointmentsTab="//a[contains(text(),'Appointments')]";
			public static final String clickCalendarTab="//a[@class='ng-binding dropdown-toggle'][contains(text(),'Calendar')]";
			public static final String clickBookAppointment="//a[contains(text(),'Book an Appointment')]";
			public static final String clickNotesHistory="//img[@tooltip='Notes History']";
			
			public static final String getNotesHistoryContents="//div[@class='audit-list-content-second-row']//div[@class='row']";
			public static final String clickAddNotes="//img[@tooltip='Add Notes']";
			public static final String addnotes="//label[contains(text(),'Notes*')]//following::textarea";
			public static final String clickSubmitbutton="//span[contains(text(),'Submit')]";

			

	
			
		}
	
}
