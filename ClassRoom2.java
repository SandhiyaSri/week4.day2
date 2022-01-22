package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom2 {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.snapdeal.com/");
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Create Action class and Object
		Actions builder=new Actions(driver);
		//Find Mens Fashion element
		WebElement mensFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		//perform mouse hover
		builder.moveToElement(mensFashion).click().perform();
		
		//Find Shirt element
		WebElement shirt = driver.findElement(By.xpath("//span[text()='Shirts']"));
		//mouse hover on shirt
		builder.moveToElement(shirt).click().perform();
		//find first shirt element
		WebElement firstShirt = driver.findElement(By.xpath("//div[@class='product-tuple-image ']"));
		//perform mouse hover
		builder.moveToElement(firstShirt).perform();
		//find quickview element
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		//close the driver
	driver.close();	
	}

}
