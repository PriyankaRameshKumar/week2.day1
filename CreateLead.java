package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//http://leaftaps.com/opentaps/control/main
		
		// setup driver
		WebDriverManager.chromedriver().setup();
		
		//Open the browser
		ChromeDriver driver = new ChromeDriver();
		
		//load the url
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//maximize the window
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Identify webelement
		WebElement findElement = driver.findElement(By.linkText("CRM/SFA"));
		//do actions 
		findElement.click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Priyanka");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ramesh Kumar");
		
		//dropdown
		// identify dropdown element
		WebElement sourcedd = driver.findElement(By.id("createLeadForm_dataSourceId"));
		
		//Create an object for select class and link it with dropdown element
		Select dd = new Select(sourcedd);
		
		//choose the option with either value , visibletext or index
		dd.selectByVisibleText("Conference");	
		
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Priyanka");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Information Technology");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is the description field");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("priyanka.omg@gmail.com");
		
		WebElement statedd = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd2 = new Select(statedd);
		dd2.selectByValue("NY");
		
		driver.findElement(By.name("submitButton")).click();
		driver.getTitle();
		
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("updateLeadForm_description")).clear();
		Thread.sleep(5000);
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("This is the important note section");
		driver.findElement(By.name("submitButton")).click();
		driver.getTitle();
		
		
			
		
	}

}
