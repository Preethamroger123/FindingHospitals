package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.doctors_Page;
import pageObjects.homePage;
import pageObjects.surgeries;
import testBase.base;



public class Stepdefinitions_DoctorSurgeries {
	Hooks h=new Hooks();
	public WebDriver driver=h.getDriver();
	base b=new base();
    public homePage hp=new homePage(driver);
    public doctors_Page dp=new doctors_Page(driver);
    public surgeries s=new surgeries(driver);
	
	
	@Given("practo page is opened")
	public void practo_page_is_opened() throws IOException {
		String title=driver.getTitle();
		Assert.assertEquals(title,h.getProperties().getProperty("title") );
	    
		
	}

	@When("provide location and specialisation details")
	public void provide_location_and_specialisation_details() throws IOException, InterruptedException{
        
		hp.location_clear();
		
		hp.location_text(b.getProperties().getProperty("location_txt"));
		Thread.sleep(2000);
		
		
		hp.city_click();
		
	
		hp.speciality_inputbox_click();
		hp.speciality_txt(b.getProperties().getProperty("specialty"));
		Thread.sleep(2000);
		hp.speciality_click();
	    
		
	}

	@When("Apply all filter options")
	public void Apply_all_filter_options() throws InterruptedException {
		dp.patient_Stories_click();
		dp.select_Option(dp.patient_stories_optionlist);
		Thread.sleep(2000);
		
		
		dp.experience_Click();
		dp.select_Option(dp.experience_Optionlist);
		Thread.sleep(2000);
		
		
		dp.allfilters_Click();
		
		dp.select_Option(dp.fees_Radiolist);
		Thread.sleep(2000);
		
		dp.allfilters_Click();
		
		dp.select_Option(dp.availabilty_Radiolist);
		Thread.sleep(2000);
		
		
		dp.sortby_Click();
		
		dp.select_Option(dp.sortby_Optionslist);
		Thread.sleep(2000);
	   
	}

	@Then("print first five doctor detials")
	public void print_first_five_doctor_detials() {
		dp.doctors_list(dp.doctors_Infolist);
	    
	}

	@Then("click on surgiers")
	public void click_on_surgiers() {
	    dp.doctorspage_SurgeriesClick();
	    h.scroll(s.popular_Surgeries_txt);
	    
	    
	}

	@Then("print list of surgiers")
	public void print_list_of_surgiers() {
		s.surgerieslist_Print(s.surgeries_list);
	    
	}
}
