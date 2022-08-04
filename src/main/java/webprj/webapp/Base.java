package webprj.webapp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	
	public WebDriver driver;
	public	Properties prop;
	String url1;
		public WebDriver driverinit() throws IOException
		{
			
			 prop= new Properties();
			
			FileInputStream fis= new FileInputStream("C:\\javaworkspace\\prac\\src\\main\\java\\resource\\data.properties");
			prop.load(fis);
			String str=prop.getProperty("browser");
			System.out.println(str);
			
		String url1=prop.getProperty("url");
			System.out.println(url1);
			
			ChromeOptions op = new ChromeOptions();
			op.setAcceptInsecureCerts(true);
			
		if (str.equalsIgnoreCase("chrome"))
	{	
			System.setProperty("webdriver.chrome.driver","D:\\javaworkspace\\chromedriver.exe");
			driver= new ChromeDriver(op);
			
	}
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			return driver;
			
		}
	}


