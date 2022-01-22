package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	public static void main(String[] args) throws InterruptedException, IOException {
		// driver setup
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Create Action class and Object
		Actions builder = new Actions(driver);

		// Find Mens Fashion element
		WebElement mensFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));

		// perform mouse hover
		builder.moveToElement(mensFashion).click().perform();

		// Find Shirt element
		WebElement shirt = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));

		// mouse hover on shirt
		builder.moveToElement(shirt).click().perform();

		// Get count
		String shoeCount = driver.findElement(By.xpath(
				"//h1[@category='Sports Shoes for Men']/following-sibling::span[@class='category-name category-count']"))
				.getText();
		System.out.println(shoeCount);

		// Click training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		// Find sorting dropdown
		driver.findElement(
				By.xpath("//div[@class='sort-drop clearfix']/i[@class='sd-icon sd-icon-expand-arrow sort-arrow']"))
				.click();

		// Select price low-high
		driver.findElement(By.xpath("//li[@class='search-li' and @data-index='1']")).click();

		// give min price range
		WebElement fromValue = driver.findElement(By.name("fromVal"));
		fromValue.clear();
		fromValue.sendKeys("900");

		// Give max price range
		WebElement toVal = driver.findElement(By.name("toVal"));
		toVal.clear();
		toVal.sendKeys("1200");

		// press Go
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(3000);

		// click view more
		driver.findElement(By.xpath("//button[@data-filtername='Color_s']")).click();

		// select navy checkbox
		driver.findElement(By.xpath("//div[@class='sdCheckbox filters-list ']/label[@for='Color_s-Navy']")).click();
		Thread.sleep(3000);
		// find first shoe element

		WebElement firstShoe = driver.findElement(By.xpath("//div[@data-js-pos='0']"));
		// mouse hover
		builder.moveToElement(firstShoe).perform();

		// find quick view element
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();

		// get price
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();

		// get discount
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();

		// print
		System.out.println("Cost of the shoe is:" + price + ". Discount is  " + discount);

		// Find shoe image
		WebElement shoeToTakeScreenShot = driver.findElement(By.xpath("//li/img[@class='cloudzoom']"));

		// Take screen shot
		File source = shoeToTakeScreenShot.getScreenshotAs(OutputType.FILE);

		// Destination File
		File destination = new File("./images/FirstShoe.png");

		// copy to destination
		FileUtils.copyFile(source, destination);

		// close current window
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();

		// close browser
		driver.close();

	}

}
