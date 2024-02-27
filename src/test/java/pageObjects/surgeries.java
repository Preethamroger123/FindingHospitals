package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class surgeries extends pageBase {
   
	public surgeries(WebDriver driver)
	{
	 super(driver);
    }
	
	//Locating WebElements
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[5]/a/div[1]")
	WebElement surgeries_Link;
	
	@FindBy(xpath="//*[@id=\"surgeries\"]/div/div[1]/div/h1")
	public
	WebElement popular_Surgeries_txt;
	
	@FindBy(xpath="//*[@id=\"surgeries\"]/div/div[1]/div/div/div/div/p")
	public
	List<WebElement> surgeries_list;
	
	
	//Action Methods
	public void surgeries_Click() {
		surgeries_Link.click();
	}
	
	public void surgerieslist_Print(List<WebElement> list) {
		int c=0;
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			c=c+1;
		}
		System.out.println("Total Surgeries Count:"+c);
	}
}
