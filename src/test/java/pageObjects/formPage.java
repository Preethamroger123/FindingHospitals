package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class formPage extends pageBase {
	
	public formPage(WebDriver driver){
		super(driver);
	}
	
	//Locating WebElements
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/span/span[2]")
	WebElement for_Corporates_Link;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/span/div/div[1]/a")
	WebElement health_And_Wellness_Plans_Link;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[1]/div/div/div/h1")
	public
	WebElement scroll_To_Form_Page_Heading;
	
	@FindBy(xpath="//*[@id=\"name\"]")
	WebElement form_Name_inputbox;
	
	@FindBy(xpath="//*[@id=\"organizationName\"]")
	WebElement form_Org_Name_inputbox;
	
	@FindBy(xpath="//*[@id=\"contactNumber\"]")
	WebElement form_Contact_No_inputbox;
	
	@FindBy(xpath="//*[@id=\"officialEmailId\"]")
	WebElement form_Email_inputbox;
	
	@FindBy(xpath="//*[@id=\"organizationSize\"]")
	WebElement org_Size_Dropdown;
	
	@FindBy(xpath="//*[@id=\"interestedIn\"]")
	WebElement interested_In_Dropdown;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/form/button")
	WebElement schedule_Demo_Button;
	
	@FindBy(xpath="/html/body/div[4]/div/div/div/div[1]")
	WebElement thank_You_Message;
	
	
	
	
	//Action Methods
	public void corporates_Link_Click() {
		for_Corporates_Link.click();
	}
	
	public void  health_And_Wellness_Plans_Link_Click() {
		health_And_Wellness_Plans_Link.click();
	}
	
	public void form_Details(List<String> list) {
		form_Name_inputbox.sendKeys(list.get(0));
		form_Org_Name_inputbox.sendKeys(list.get(1));
		form_Contact_No_inputbox.sendKeys(list.get(2));
		form_Email_inputbox.sendKeys(list.get(3));
		
		Select s1=new Select(org_Size_Dropdown);
		s1.selectByVisibleText(list.get(4));
		
		Select s2=new Select(interested_In_Dropdown);
		s2.selectByVisibleText(list.get(5));
	}
	
	public void submit_button() {
		schedule_Demo_Button.click();
	}
		
	
	public boolean schedule_Demo_Status() {
		return schedule_Demo_Button.isEnabled();
	}
	
	public String thank_you_Message_Text() {
		return thank_You_Message.getText();
	}
	

}
