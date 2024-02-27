package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends pageBase {

	public homePage(WebDriver driver){
		super(driver);
	}
	
	//Locating WebElements
	
	//locate location input box
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input")
	WebElement location_inputbox;
	
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[1]/div[2]/div[2]/div[1]/span[1]/div")
	WebElement city_option;
	
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[2]/div/input")
	WebElement speciality_inputbox;
	
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[2]/div[2]/div[1]/div[1]/span[1]/div")
	WebElement speciality;
	
	
	//Action methods
	public void location_clear() {
		location_inputbox.clear();
	}
	
	public void location_click() {
		location_inputbox.click();
	}
	
	public void location_text(String txt) {
		location_inputbox.sendKeys(txt);
	}
	
	public void city_click() {
		city_option.click();
	}
	
	public void speciality_inputbox_click() {
		speciality_inputbox.click();
	}
	
	public void speciality_txt(String txt) {
		speciality_inputbox.sendKeys(txt);
	}
	
	public void speciality_click() {
		speciality.click();
	}
}
