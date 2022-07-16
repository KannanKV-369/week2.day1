package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	/*Steps:
	01_ Launch, maximize
	02_ Login to application
	03_ Click CRM/SFA Link
	04_ Click Leads Link
	05_ Click Create Lead Link
	06_ Enter Company Name
	07_ Enter First Name
	08_ Enter Last Name
	 Select the DropDown
	09_ Click Submit button
	10_ Verify the Verify Lead Page Title 
	 */

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		String attribute = driver.findElement(By.className("decorativeSubmit")).getAttribute("value");
		if(attribute.equals("Logout"))
			System.out.println("Successfully Logged In");

		//Click CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		//Thread.sleep(2000);
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Zensar");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kannan");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("K.V.");
		//SELECT DROP DOWN
		WebElement findElement = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select select = new Select(findElement);
		select.selectByVisibleText("Website");		
		driver.findElement(By.name("submitButton")).click();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "View Lead | opentaps CRM";
		if((actualTitle.equals(expectedTitle))||actualTitle.contains("View Lead"))
			System.out.println("The Page is verified");
		else
			System.out.println("Wrong Page");


	}

}
