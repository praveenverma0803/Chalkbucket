import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class utility 
{
	public static WebDriver driver;
	
	public void Browser(String browsername)
	{
		switch(browsername)
		
		{
		case "firefox":
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			break;
			
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
			
		default:
			System.out.println("browser not found");
		}
	}
	
	
	
	
	public void URL(String url)
	{
			driver.get(url);
	}
	

	
	public void Explicitwait(String Xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
	}
	
	public void ImpilicitWait()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	public String generateRandomString(int length)
	{
		return RandomStringUtils.randomAlphabetic(length);
	}
	
	public String generateRandomNumber(int length)
	{
		return RandomStringUtils.randomNumeric(length);
	}
	
	public String generateRandomAlphaNumeric(int length)
	{
		String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
				"1234567890" ;   //numbers
				   
		String AlphaNum="";
		String temp=RandomStringUtils.random(length,allowedChars);
		AlphaNum=temp.substring(0,temp.length()-9);
		return AlphaNum;
	}

	
	public String generateEmail(int length) 
	{
		String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
				"1234567890";
		String email="";
		String temp=RandomStringUtils.random(length,allowedChars);
		email=temp.substring(0,temp.length()-9)+"@cbl.com";
		return email;
	}
	
	public String generateUrl(int length) 
	{
		String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
				"1234567890" +   //numbers
				"_-.";   //special characters
		String url="";
		String temp=RandomStringUtils.random(length,allowedChars);
		url=temp.substring(0,3)+"."+temp.substring(4,temp.length()-4)+"."+temp.substring(temp.length()-3);
		return url;
	}
}
