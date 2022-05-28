package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("(//label[text()='First name:']/parent::div[@class='x-form-item x-tab-item'])//input")).sendKeys("Priyanka");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		String EditTitle = driver.getTitle();
		System.out.println(EditTitle);
		if(EditTitle.contains("View Lead"))
		{
			System.out.println("This is the View lead page");
		}
		else
		{
			System.out.println("This is the not the view lead page");
		}
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Conde");
		Thread.sleep(3000);
		String newcompany = driver.findElement(By.id("updateLeadForm_companyName")).getAttribute("value");
		System.out.println(newcompany);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		Thread.sleep(3000);
		String Companyname = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println(Companyname);
		
		if(Companyname.contains(newcompany))
		{
			System.out.println("The company name is updated.");
		}
		else
		{
			System.out.println("The company name is not updated.");
		}
		driver.close();

	}

}
