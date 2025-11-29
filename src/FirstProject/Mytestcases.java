package FirstProject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class Mytestcases {
	
	WebDriver driver=new ChromeDriver();
	String myWebsite = "https://automationexercise.com";
    String Signuppage= "https://automationexercise.com/signup";
    Random Rand=new Random();
	String PublicEmail;  // عشان يصير يشوف شغل الايميل يلي عملناه جوا @Test  الاول 

  


 


    
			
			
	@BeforeTest
	public void mysetup() {
		
		driver.get(myWebsite);
		driver.manage().window().maximize();
		//System.out.println(Username[RandomName]);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
		
		
	@Test (priority = 1, invocationCount = 1) 
	public void signup() throws InterruptedException
	{
		int RandnumberforEmail =Rand.nextInt(225332);
	 
		String [] Username= {"Marah", "laith","Mohmmad", "Bashar","Aoun"};
		   int RandomName =Rand.nextInt(Username.length);
		String Email = Username[RandomName] + RandnumberforEmail+"@gmail.com"; 
		driver.navigate().to(Signuppage);
		
		PublicEmail=Email;
		
		
		WebElement NameSignup =driver.findElement(By.xpath("//input[@placeholder='Name']"));
		WebElement EmailSignup =driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		WebElement SignupBtn =driver.findElement(By.xpath("//button[normalize-space()='Signup']"));
		
		NameSignup.sendKeys(Username[RandomName]);
		EmailSignup.sendKeys(Email);
		SignupBtn.click();
		Thread.sleep(4000);
		
		
	}
	@Test (priority = 2) 
	public void login() {
		
		driver.navigate().to("https://automationexercise.com/login");
		WebElement EmailLogin =driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		EmailLogin.sendKeys(PublicEmail);
		
		
	}
	
	
	
	@AfterTest
	public void AfterTest() {

		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
