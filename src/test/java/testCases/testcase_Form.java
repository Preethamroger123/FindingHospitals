package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.excel_Readdata;
import pageObjects.formPage;
import testBase.base;

public class testcase_Form extends base {
	public formPage fp;
	
	@Test(groups= {"regression"},dependsOnMethods="check_title_invalidform")
	public void formpagetest() throws InterruptedException, IOException {
		
		
		
		
		log.info("**Getting form details from Excel**");
		fp.form_Details(excel_Readdata.read_Data(System.getProperty("user.dir")+"\\testData\\Hackathon_TestInputdata.xlsx","Sheet1", 6, 0));
		Thread.sleep(1000);
		log.info("**capturing invalidform screenshot **");
		captureScreen("FormDetails");
		boolean status=fp.schedule_Demo_Status();
		Assert.assertEquals(status, false);
	}
	
	@Test(groups= {"sanity"})
	public void check_title_invalidform() throws IOException, InterruptedException {
		fp=new formPage(driver);

		log.info("**opening form**");
		fp.corporates_Link_Click();
		Thread.sleep(1000);
		fp.health_And_Wellness_Plans_Link_Click();
		Thread.sleep(1000);
		scroll(fp.scroll_To_Form_Page_Heading);
		Thread.sleep(1000);
		log.info("**Starting sanity test**");
		log.info("Checking the title of the current page url");
		String title=driver.getTitle();
		
		Assert.assertEquals(title, getProperties().getProperty("form_page_title"));
		captureScreen("FormPage");
	}

}
