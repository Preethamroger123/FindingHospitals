package testCases;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.excel_WriteData;
import pageObjects.doctors_Page;
import pageObjects.homePage;
import testBase.base;

public class Home extends base {
	
	public homePage hp;
	public doctors_Page dp;
	List<String> doctorDetialsString;
	
	
	
	
	@Test(groups= {"regression"},dependsOnMethods="check_title")
	public void  homepagetest() throws IOException, InterruptedException {
		hp=new homePage(driver);
		dp=new doctors_Page(driver);
		log.info("***Practo page has been opened***");
		
	    
		hp.location_clear();
		
		hp.location_text(getProperties().getProperty("location_txt"));
		Thread.sleep(2000);
		
		
		hp.city_click();
		
	
		hp.speciality_inputbox_click();
		hp.speciality_txt(getProperties().getProperty("specialty"));
		Thread.sleep(2000);
		hp.speciality_click();
		
		log.info("**loaction and specialisation has been selected");
		
		log.info("**Selecting all the filter options required**");
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
		
		captureScreen("doctorDetails");
		
		dp.doctors_list(dp.doctors_Infolist);
		log.info("**Printing the doctors details**");
		
		
		
		doctorDetialsString=dp.getString(dp.doctors_Infolist);
		int listCount=1;
		for(String s:doctorDetialsString) {
			String[] data=convert_String_to_Array(s);
			
			
				
			excel_WriteData.setData(System.getProperty("user.dir")+"\\testData\\hackathon_Testoutputdata.xlsx","Sheet1",listCount,data.length,data);
			
			
			
			
			listCount++;
			
		}
		
	}
	
	@Test(groups= {"sanity"})
	public void check_title()  throws IOException {
	
		log.info("**Starting sanity test**");
		log.info("Checking the title of the current page url");
		String title=driver.getTitle();
		Assert.assertEquals(title, getProperties().getProperty("title"));
		captureScreen("HomePage");
	}
	

	
	
	
	
	
	
	
	
	

}
