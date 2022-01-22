package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom3 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Go to the List box element
		WebElement selenium = driver.findElement(By.xpath("//select/option[text()='Select your programs']/following-sibling::option[text()='Selenium']"));
		WebElement loadRunner = driver.findElement(By.xpath("//select/option[text()='Select your programs']/following-sibling::option[text()='Loadrunner']"));
		
		//Action class
		Actions builder=new Actions(driver);
		//ctrl key
		builder.keyDown(Keys.CONTROL).click(selenium).click(loadRunner).keyUp(Keys.CONTROL).perform();
		
	}

}
