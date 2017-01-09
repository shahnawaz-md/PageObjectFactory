package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.xml.DOMConfigurator;

import pageFactory.Home_page;
import pageFactory.Log;
import pageFactory.Login_page;

public class TestCase {
	static WebDriver driver;
	private static final long TIMEOUT = 12000;
	
	Home_page HomePage;
	Login_page LoginPage;
	
	@BeforeClass
	
	public void browser() throws InterruptedException {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("sTestCaseName");
		System.setProperty("webdriver.gecko.driver", "/root/Desktop/Jar Files/geckodriver");
		driver = new FirefoxDriver();
		Log.info("Opening the firefox browser");
		Thread.sleep(2000);
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shahnawaz\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();*/	
		
		driver.get("http://localhost/opensis_Update/openSIS_CE/");
		Log.info("Entering the Url");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		HomePage  = PageFactory.initElements(driver, Home_page.class);
		LoginPage  = PageFactory.initElements(driver, Login_page.class);
		
		}

	@AfterClass
	public void tearDown()	{
		
		driver.close();
		driver.quit();
		
		Log.info("Closing the browser");
		Log.endTestCase("THIS IS AN END");
	}	
	
	
	
	@Test
	public void login() throws InterruptedException {
		LoginPage.txt_Username.sendKeys("admin");
		Log.info("Entering the Username");
		Thread.sleep(2000);
		LoginPage.txt_Password.sendKeys("password@123");
		Log.info("Entering the Password");
		Thread.sleep(2000);
		LoginPage.chk_RememberMe.click();
		Log.info("Clicking on Remember me checkbox");
		Thread.sleep(2000);
		HomePage.btn_login.click();
		Log.info("Clicking on Login button");
		Thread.sleep(2000);
		Log.info("Logged in successfully");
		driver.navigate().to("http://localhost/opensis_Update/openSIS_CE/index.php?modfunc=logout");
		Log.info("Clicking on LogOut link");
		Log.info("Logged out successfully");
		Thread.sleep(TIMEOUT);
		
		
		
	
	

	}
}