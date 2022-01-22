package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://jqueryui.com/draggable/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//switchto frame
	driver.switchTo().frame(0);
	//Locate the element
	WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
	//Action Class
	Actions builder=new Actions(driver);
	//mouse over
	builder.moveToElement(drag).click().perform();
	//Drag and drop
	builder.dragAndDropBy(drag, 500, 700).perform();
	driver.switchTo().defaultContent();
}
}
