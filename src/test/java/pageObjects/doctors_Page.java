package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class doctors_Page extends pageBase {
	
	public doctors_Page(WebDriver driver){
		super(driver);
	}
	
	//Locating WebElements
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[2]/span/i")
	WebElement patient_Stories;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[2]/ul/li/span")
	public
	List<WebElement> patient_stories_optionlist;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[3]/span/i")
	WebElement Experience;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[3]/ul/li/span")
	public
	List<WebElement> experience_Optionlist;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[4]/i")
	WebElement all_Filters;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[2]/div/div[1]/div/label/div")
	public
	List<WebElement> fees_Radiolist;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[2]/div/div[2]/div/label/div")
	public
	List<WebElement> availabilty_Radiolist;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[6]/div/div/div/span")
	WebElement sortby;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[6]/div/div/div/ul/li/span")
	public
	List<WebElement> sortby_Optionslist;
	
	@FindBy(xpath="//*[@class=\"info-section\"]")
	public
	List<WebElement> doctors_Infolist;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[5]/a/div[1]")
	WebElement doctorspage_SurgeriesLink;
	
	
	
	
	
	//Action methods
	public void patient_Stories_click() {
		patient_Stories.click();
	}
	
	public void select_Option(List<WebElement> list) {
		list.get(0).click();
	}
	
	public void experience_Click() {
		Experience.click();
	}
	
	public void allfilters_Click() {
		all_Filters.click();
	}
	
	public void sortby_Click() {
		sortby.click();
	}
	
	public void doctors_list(List<WebElement> list) {
		for(int i=0;i<5;i++) {
		System.out.println(list.get(i).getText()+"  ");
		}
	}
		
	public List<String> getString(List<WebElement> doc){
			List<String> s=new ArrayList<String>();
			for(int i=0;i<5;i++) {
				s.add(doc.get(i).getText());
				
			}
			return s;
		}
	
	public void doctorspage_SurgeriesClick() {
		doctorspage_SurgeriesLink.click();
	}
		
	
		
	
	

	
	
	
	
	
	
	
	

}
