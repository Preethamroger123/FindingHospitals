package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utility.excel_Readdata;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.formPage;

public class Stepdefinitions_invalidForm   {
	Hooks h=new Hooks();
	public WebDriver driver=h.getDriver();
	formPage fp=new formPage(driver);
	
	
	
	
	@Given("navigate to practo website")
	public void navigate_to_practo_website() throws IOException {
		
		String title=driver.getTitle();
		Assert.assertEquals(title,h.getProperties().getProperty("title") );
	    
	}
	
	@When("demo form page is open")
	public void demo_form_page_is_open() throws InterruptedException {
		
		fp.corporates_Link_Click();
		Thread.sleep(1000);
		fp.health_And_Wellness_Plans_Link_Click();
		Thread.sleep(1000);
		h.scroll(fp.scroll_To_Form_Page_Heading);
		Thread.sleep(1000);
	    
	}
	
	@When("set detials for all fields")
	public void set_detials_for_all_fields() throws IOException, InterruptedException {
		
		fp.form_Details(excel_Readdata.read_Data(System.getProperty("user.dir")+"\\testData\\Hackathon_TestInputdata.xlsx","Sheet1", 6, 0));
		Thread.sleep(1000);
	   
	}

	@Then("check whether the submit button disabled or not")
	public void check_whether_the_submit_button_disabled_or_not() {
		
		boolean status=fp.schedule_Demo_Status();
		Assert.assertEquals(status, false);
	    
	}
}
