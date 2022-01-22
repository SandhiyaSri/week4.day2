package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
	public static void main(String[] args) throws InterruptedException {
		
		//driver setup
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//find brands
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
				
		// Create Action class and Object
		Actions builder = new Actions(driver);
		
		//mouse hover
		builder.moveToElement(brands).perform();
		
		//find lorial paris
		WebElement lorealParis = driver.findElement(By.linkText("L'Oreal Paris"));
		
		//mouse over
		builder.moveToElement(lorealParis).click().perform();
		
		//get title
		if(driver.getTitle().contains("Loreal"))
				{
			System.out.println(driver.getTitle());
				}
		//click sortby
		driver.findElement(By.xpath("//button[@class=' css-p2rfnw']/span[@class='sort-name']")).click();
		
		Thread.sleep(3000);
		//click customer rated
		driver.findElement(By.xpath("//div[@class='control-box css-1w85ogp']/label[@for='radio_customer top rated_undefined']")).click();
		
		//click category
		driver.findElement(By.id("first-filter")).click();
		
		//click hair
//		driver.findElement(By.xpath("//li[@class='css-1do4irw']//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']//following-sibling::span")).click();
		
		//click hair care
		//driver.findElement(By.xpath("//li[@class='css-1do4irw']//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']/following-sibling::span")).click();
		
		//click shampoo
		driver.findElement(By.xpath("//li[@class='css-1do4irw']//label[@for='checkbox_Shampoo_316']")).click();
		
		Thread.sleep(2000);
		//click concern
		driver.findElement(By.xpath("//div[@class='css-vuirr6']//span[text()='Concern']")).click();
		
		//click color protection
		driver.findElement(By.xpath("//div[@class='control-box css-1w85ogp']/label[@for='checkbox_Color Protection_10764']")).click();
		
		//Click Loreal paris shampoo
		driver.findElement(By.xpath("//div[@class='productWrapper css-la441k'][1]")).click();
		
		//Get windowHandles
		Set<String> windowHandles = driver.getWindowHandles();
		
		//Conver to List
		List<String>windows=new ArrayList<String>(windowHandles);
		
		//switch to window
		driver.switchTo().window(windows.get(1));
		
		//find dropdown element
		WebElement dd = driver.findElement(By.xpath("//div[@class='css-11wjdq4']/select[@title='SIZE']"));
		
		//Select class
		Select dropdown=new Select(dd);
		
		//select value as 175ml
		dropdown.selectByVisibleText("175ml");
		
		//get MRP
		String mrp = driver.findElement(By.className("css-12x6n3h")).getText();
		System.out.println("Mrp of 175 ml Shampoo is: "+mrp);
		
		//Click Add to bag
		driver.findElement(By.xpath("//div[@class='css-1rn9gza']//span[@class='btn-text']")).click();
		
		//Click cart
		driver.findElement(By.xpath("//button[@class='css-5s18zx eoh7kvv0']")).click();
		
		Thread.sleep(2000);
		
		//switch to frame
		driver.switchTo().frame(0);
		
		//Get Grand total
		String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println("Grand total is:"+grandTotal);
		
		//click proceed
		driver.findElement(By.xpath("//div[@class='second-col']")).click();
		
		//continue on guest
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
				
		
		//get the final grand total
		String grandTotalFinal = driver.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']/div[@class='value']")).getText();
		
		//check both grand total
		if(grandTotal==grandTotalFinal)
		{
			System.out.println("Both Grand total are same");
		}
		else
		{
			System.out.println("Both Grand toal are not same. Pls check!");
		}
		
		//Close all windows
		driver.switchTo().defaultContent();
		
		//close the driver
		driver.close();
		
	}

}
