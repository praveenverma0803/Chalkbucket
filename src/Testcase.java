

import java.util.List;


import org.openqa.selenium.*;
import org.testng.annotations.*;


public class Testcase extends utility
{
	utility Browser = new utility();  
	
	@BeforeSuite
	public void Launchbrowser()
	{   
		Browser.Browser("firefox");
	}
	
	@BeforeTest
	public void openURL()  
	{
	Browser.URL("http://uatchalkbucketlabsc-env.elasticbeanstalk.com");
	}
	
	@BeforeClass
	public void Login() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='UserName']")).sendKeys("mvp@cbl.com");
		driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys("chalk123");
		driver.findElement(By.xpath(".//*[@class='blue-button login-button']")).click();
		Thread.sleep(9000);
	}
	
	
	@Test (testName = "AddMember" )
	public void AddMember() throws InterruptedException
	{
		for (int i=0; i<25; i++)
	     { 
		
		driver.findElement(By.xpath("//*[@class='left_panel']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@title='Members']/a/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='left_panel open']/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='btnAddAthlete']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@aria-owns='MembershipID_listbox']/span/span/span")).click();
		Thread.sleep(3000);
		
		List<WebElement> Memberships = driver.findElements(By.xpath("//*[@id='MembershipID_listbox']/li"));
		Thread.sleep(1000);
		for (WebElement membership : Memberships)
		{
			if("Test".equals(membership.getText()))
				membership.click();
			
		}
		
		String FirstName = Browser.generateRandomString(10);
		driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys(FirstName);
		System.out.println("First Name: " +FirstName);
		
		String LastName = Browser.generateRandomString(10);
		driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys(LastName);
		System.out.println("Last Name: " +LastName);
		
		String Email = Browser.generateEmail(15);
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(Email);
		System.out.println("Email: " +Email);
		
		String Password = "test123";
		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(Password);
		driver.findElement(By.xpath("//*[@id='ConfirmPassword']")).sendKeys(Password);
		System.out.println("Password: " +Password);
		
		String Phonenumber = Browser.generateRandomNumber(10);
		driver.findElement(By.xpath("//*[@id='PhoneNumber']")).sendKeys(Phonenumber);
		
		driver.findElement(By.xpath("//*[@id='rbtnMale']")).click();
		
		String Address = Browser.generateRandomAlphaNumeric(10);
		driver.findElement(By.xpath("//*[@id='txtStreet1']")).sendKeys(Address);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scroll(0,850)", "");
		Thread.sleep(2000);
		
		String City = Browser.generateRandomString(10);
		driver.findElement(By.xpath("//*[@id='txtCity']")).sendKeys(City);
		
		driver.findElement(By.xpath("//*[@id='divstate']/span/span")).click();
		Thread.sleep(3000);
		List<WebElement> States = driver.findElements(By.xpath("//*[@id='ddlState_listbox']/li"));
		for (WebElement State : States)
		{
			
			if("CA".equals(State.getText()))
				State.click();
		}
		
		Thread.sleep(3000);
		String PostalCode = Browser.generateRandomNumber(5);
		driver.findElement(By.xpath("//*[@id='txtPostalCode']")).sendKeys(PostalCode);
		
		driver.findElement(By.xpath("//*[@aria-owns='PaymentMode_listbox']/span")).click();
		Thread.sleep(3000);
		List<WebElement> Payments = driver.findElements(By.xpath("//*[@id='PaymentMode_listbox']/li"));
		for (WebElement Payment : Payments)
		{
			
			if("No Charge".equals(Payment.getText()))
				Payment.click();
		}
		 
		driver.findElement(By.xpath("//*[@id='chkTemrs']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='btnRegister']")).click();
		
		Thread.sleep(5000);
		System.out.println(i);
		 } 
		
		/*
		driver.findElement(By.xpath("//*[@class='left_panel']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@title='Members']/a/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='left_panel open']/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='FindAthlete']")).sendKeys(FirstName);
		Thread.sleep(2000);
		
		List<WebElement> Members = driver.findElements(By.xpath("//*[@id='grdAthletes']/table/tbody/tr/td"));
		 for (WebElement Member : Members)
		 {
			 if(FirstName.equals(Member.getText()))
			 System.out.println("Member created"  +Member.getText());
			 Thread.sleep(2000);
	
		 }*/
	}
	
	
	
	
	
	/*
	@Test (priority = 1,testName = "Financial" )
	public void Financial()
	{
		System.out.println(driver.findElement(By.xpath("//*[@id='lblMonth']")).getText());
		
		System.out.println("Revenue = " +driver.findElement(By.xpath("//*[@id ='lblAnnualAmount']")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@class='graph_left']//span[contains(., 'Active Members')]")).getText());
		System.out.println("New Members = " +driver.findElement(By.xpath("//*[@id='lblNewMembers']")).getText());
		System.out.println("New Members Amount = " +driver.findElement(By.xpath("//*[@id='lblNewMemberAmount']")).getText());
		System.out.println("Cancel/Hold Members = " +driver.findElement(By.xpath("//*[@id='lblCancel']")).getText());
		System.out.println("Cancel/Hold Amount = " +driver.findElement(By.xpath("//*[@id='lblCancelAmount']")).getText());
		System.out.println("Total changes in Amount = " +driver.findElement(By.xpath("//*[@id='lblNetChangeAmount']")).getText());
	}
	
	
	@Test(priority = 2,testName = "Daily Attendence" )
	public void DailyAttendence() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scroll(0,850)", "");
		Thread.sleep(2000);
				
		List<WebElement> options = driver.findElements(By.xpath("//*[@id='TrainingProgramId-list']/ul/li"));
		for(WebElement option : options)
		{
					driver.findElement(By.xpath("//*[@aria-activedescendant='TrainingProgramId_option_selected']/span/span[2]")).click();
					Thread.sleep(2000);	
			   		System.out.print(option.getText());
			   		option.click();
			   		Thread.sleep(2000);	
			   		System.out.println("   " +driver.findElement(By.xpath("//*[@id='lblActiveMembers']")).getText());
			   		Thread.sleep(2000);	
		}
		
		System.out.println(driver.findElement(By.xpath("//*[@id='lblMemberUpdate']")).getText());
		System.out.println(driver.findElement(By.xpath(".//*[@id='lblMemberNotAttended']")).getText());
		driver.findElement(By.xpath("//*[@id='inactiveMember']")).click();
		
		List<WebElement> Members = driver.findElements(By.xpath("//*[@id='gridInactiveMember']/table/tbody/tr"));
		
		for(WebElement Member : Members)
		{
			System.out.println(Member.getText());
		}
		
		driver.findElement(By.xpath("//*[@id='dvInactiveMember']/button")).click();
		jse.executeScript("window.scroll(0,-850)", "");
		Thread.sleep(2000);
		
	} 
	
*/

	/*@AfterClass
	public void Logout() throws InterruptedException
	{	
		try{
		driver.findElement(By.xpath(".//*[@id='divDropMenuBtn']")).click();
		Thread.sleep(2000);
				
		List<WebElement> options = driver.findElements(By.xpath(".//*[@class='dropMenu']/ul/li/a"));
		
		for(WebElement option : options)
		{
			   	if("Logout".equals(option.getText()))
			   		
				option.click();
		}
		} catch (Exception e)
		{
			System.out.println(e);
		}
		driver.quit();
	}*/
	
}
