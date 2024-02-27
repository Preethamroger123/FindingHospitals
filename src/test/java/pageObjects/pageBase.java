package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class pageBase {
    WebDriver driver;
    pageBase(WebDriver driver){
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
 
}
