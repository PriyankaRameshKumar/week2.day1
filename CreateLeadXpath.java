package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Absolute xpath
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/p/input[@id='username']")).sendKeys("DemoSalesManager");
		
		//attribute based xpath
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class= 'decorativeSubmit']")).click();
		
		//partial text based xpath
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//text based xpath
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		
		//partial attribute xpath
		driver.findElement(By.xpath("//input[contains(@id,'companyName')]")).sendKeys("TestLeaf");
		
		//mutptiple attributes
		driver.findElement(By.xpath("//input[contains(@id,'firstName') and @name = 'firstName']")).sendKeys("Priyanka");
		
		//index based xpath
		driver.findElement(By.xpath("(//input[contains(@id,'lastName') ])[1]")).sendKeys("Ramesh Kumar");
		
		WebElement eledd = driver.findElement(By.xpath("//select[@id='createLeadForm_dataSourceId']"));
		Select dd = new Select(eledd);
		dd.selectByVisibleText("Conference");
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		////span[text()='Subject']/parent::label/following-sibling::input
		
	}

}
