package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.excel_Readdata;
import pageObjects.formPage;
import testBase.base;
   

public class testcase_FormValid extends base {
	public formPage f;
	
	@Test(groups= {"regression"},dependsOnMethods="check_title_validform")
	public void validformtest() throws InterruptedException, IOException {
	
	
	
	
	log.info("**getting form detils from Excel**");
	f.form_Details(excel_Readdata.read_Data(System.getProperty("user.dir")+"\\testData\\Hackathon_TestInputdata.xlsx","Sheet1", 6, 1));
	
	f.submit_button();
	
	
	
	Assert.assertEquals(f.thank_you_Message_Text(),getProperties().getProperty("thank_you_message") );
	log.info("**capturing Thank You Screenshot**");
	captureScreen("THANKYOU_FormSubmitted");
	}
	
	
	@Test(groups= {"sanity"})
	public void check_title_validform() throws IOException, InterruptedException {
		f=new formPage(driver);
		log.info("**opening Form**");
		f.corporates_Link_Click();
		Thread.sleep(1000);
		f.health_And_Wellness_Plans_Link_Click();
		Thread.sleep(1000);
		scroll(f.scroll_To_Form_Page_Heading);
		Thread.sleep(1000);
		log.info("**Starting sanity test**");
		log.info("Checking the title of the current page url");
		String title=driver.getTitle();
		
		Assert.assertEquals(title, getProperties().getProperty("form_page_title"));
		captureScreen("FormPage");
	}
	
	
	
}
