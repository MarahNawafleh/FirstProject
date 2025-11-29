package FirstProject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElements {
	
	
	WebDriver driver = new EdgeDriver(); 
	
	String website = "https://www.saucedemo.com/";
	
	
	
	@BeforeTest
	
	public void mySetup() {
		
driver.get(website);
		
		driver.manage().window().maximize();
	}
	
	
	
	@Test ( priority =1)
	public void add() {
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");;
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");;
		
		driver.findElement(By.id("login-button")).click();
		
		
	List<WebElement> addtoCartButtons = driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
	//addtoCartButtons.get(0).click();
	
	System.out.println(addtoCartButtons.size());
	
	for (int i = 0 ; i<addtoCartButtons.size();i++) {
		
		addtoCartButtons.get(i).click();
	}
		
	}
	
	@Test ( priority =2)
	public void remove() {
		
		
		
	List<WebElement> removetoCartButtons = driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory"));
	//addtoCartButtons.get(0).click();
	
	System.out.println(removetoCartButtons.size());
	
	for (int i = 0 ; i<removetoCartButtons.size();i++) {
		
		removetoCartButtons.get(i).click();
		
		
		
		
		
	}
	}
	
	
	
	@AfterTest
	
	public void AfterMyTest() {}
	

}
