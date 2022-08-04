package webprj.webapp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class secondTest extends Base {
	public WebDriver driver;
	public Login login;
	
	public static Logger log= LogManager.getLogger(Base.class.getName());	

	@BeforeTest

	public void init1() throws IOException
	{
		driver=driverinit();
		driver.get("https://www.google.com");
		
		login = new Login(driver);
		
		
	}
	
	@Test(priority=-1,enabled=true)
	public void signin()
	{
		login.signinlink().click();
		
	
	}
	
	@Test(priority=2, dataProvider="getData")
	public void emailtxt(String url1) throws InterruptedException
	{
		login.emailtext().sendKeys(url1);
		Thread.sleep(1000);
		login.nxtbutton().click();
	Thread.sleep(1000);
	
		driver.navigate().back();
		login.emailtext().clear();
	}
	
	@DataProvider
	public Object[] getData()
	{
		Object[] o=new Object[2];
				o[0]="nishapgholap@gmail.com";
						o[1]="golap.nish@gmail.com";
						return o;
						
	}
	
	@Test(priority=3, enabled=true)
	public void createaccount()
	{
		login.createaccnlink().click();
		log.info("successfully validated createaccount button clicked");	
		login.createaccount().click();
		log.error("stop test");
	}
	

@AfterTest
	
	public void Teardown()
	{
		driver.close();
		
	}
}

