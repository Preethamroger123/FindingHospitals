package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utility.excel_Readdata;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.formPage;

public class Stepdefinitions_validForm{
	Hooks h=new Hooks();
	public WebDriver driver=h.getDriver();
	formPage fp=new formPage(driver);
    
	
	@Given("practo website is open and working")
	public void practo_website_is_open_and_working() throws IOException {

		String title=driver.getTitle();
		Assert.assertEquals(title,h.getProperties().getProperty("title") );
		
	}
	
	@When("taking demo form is open")
	public void taking_demo_form_is_open() throws InterruptedException {
		fp.corporates_Link_Click();
		Thread.sleep(1000);
		fp.health_And_Wellness_Plans_Link_Click();
		Thread.sleep(1000);
		h.scroll(fp.scroll_To_Form_Page_Heading);
		Thread.sleep(1000);	   
		
	}
	
	@When("set detials for all form fields")
	public void set_detials_for_all_form_fields() throws IOException {

		fp.form_Details(excel_Readdata.read_Data(System.getProperty("user.dir")+"\\testData\\Hackathon_TestInputdata.xlsx","Sheet1", 6, 1));

		
	}
	
	@Then("click on submit button")
	public void click_on_submit_button() {
	    
		fp.submit_button();
		
	}

	@Then("retrieve the thankyou message")
	public void retrieve_the_thankyou_message() throws IOException {
	    
		Assert.assertEquals(fp.thank_you_Message_Text(),h.getProperties().getProperty("thank_you_message") );

	}
}
