package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home_page {
	final WebDriver driver;
	
	@FindBy(how = How.NAME, using = "log")
	public WebElement btn_login;
			
	public Home_page(WebDriver driver)
	{
		this.driver = driver;
	}
	

}
