package webprj.webapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class firstTest extends Base{
	public WebDriver driver;
	public Landingpg landingpg;
	public static Logger log= LogManager.getLogger(Base.class.getName());

	@BeforeTest

	public void init() throws IOException, InterruptedException
	{
		driver=driverinit();
	log.info("driver initialiaed");
		
		driver.get("https://www.google.com");
	log.info("navigated to home page");	
	landingpg = new Landingpg (driver);
		
		
	}

	@Test(enabled=true)
	public void gmaillinktest()
	{
		landingpg.gmaillink().click();
		
		System.out.println(	driver.getTitle());
		log.info("successfully validated gmail link");	
		driver.navigate().back();
	}


	@Test(enabled=true)
	public void imglinktest()
	{
		landingpg.imgslink().click();
		
		System.out.println(	driver.getTitle());
		log.info("successfully validated image link");	
		driver.navigate().back();
	}

	@Test(enabled=true)
	public void signinlinktest()
	{
		landingpg.signinlink().click();
		
		System.out.println(	driver.getTitle());
		log.info("successfully validated sign in link link");	
		driver.navigate().back();
	}

	@Test(priority=-1)
	public void searchtexttest() throws InterruptedException
	{
		landingpg.searchtext().sendKeys("flowers");
		List<String> lt= new ArrayList<String>();
		//lt.addAll(homepg.searchtextlist());
		lt=	landingpg.searchtextlist();
		Iterator<String> it=lt.iterator();
		while(it.hasNext())
		{System.out.println(it.next());
		}
		log.debug("checked drop down listof search textbar");
		}
		
		@AfterTest
		
		public void Teardown()
		{
			driver.close();
			
		}
		
		
		
	}

