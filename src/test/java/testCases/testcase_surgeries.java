package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.surgeries;
import testBase.base;

public class testcase_surgeries extends base {
	
	public surgeries s;
	
	
	
	@Test(groups= {"regression"},dependsOnMethods="check_title_surgeries")
	public void surgeries_test() throws IOException {
		
		
		
		log.info("**printing surgeries list in console**");
		s.surgerieslist_Print(s.surgeries_list);
		scroll(s.popular_Surgeries_txt);
		log.info("***capturing screenshot of surgeries list***");
		captureScreen("surgeriesList");
		
		
	}
	
	@Test(groups= {"sanity"})
	public void check_title_surgeries() throws IOException {
		s=new surgeries(driver);
		s.surgeries_Click();
		log.info("**Starting sanity test**");
		log.info("Checking the title of the current page url");
		String title=driver.getTitle();
		
		Assert.assertEquals(title, getProperties().getProperty("surgeries_page_title"));
		captureScreen("SurgeriesPage");
	}
}
