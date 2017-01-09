package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_page {
	final WebDriver driver;
	
	@FindBy(how = How.NAME, using = "USERNAME")
	public WebElement txt_Username;
	
	@FindBy(how = How.NAME, using = "PASSWORD")
	public WebElement txt_Password;
	
	@FindBy(how = How.NAME, using = "remember")
	public WebElement chk_RememberMe;
	
	public Login_page(WebDriver driver)
	{
		this.driver = driver;
	}

}
