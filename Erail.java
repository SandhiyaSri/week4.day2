package week4.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://erail.in");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MS",Keys.TAB);
//		driver.findElement(By.xpath("//div[text()='Chennai Egmore']")).click();
		
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU",Keys.TAB);
		//driver.findElement(By.xpath("//div[text()='Madurai Jn']")).click();
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		Thread.sleep(2000);
		//Go to table
		int rowcount = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
		List<String> trainNames=new ArrayList<String>();
		for(int i=1;i<=rowcount;i++)
		{
			String names = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
			trainNames.add(names);
		}
		Set<String> trainSet=new HashSet<String>(trainNames);
			if(trainNames.size()==trainSet.size())
			{
				System.out.println("No Duplicates");
			}
			else
			{
				System.out.println("Duplicates");
			}
		
		
		
		
		
		
		
	}

}
