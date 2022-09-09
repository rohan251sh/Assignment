package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		Thread.sleep(200);
		
		
		driver.findElement(By.xpath("//li[text()='Item 2']")).click();
		//driver.findElement(By.xpath("//li[text()='Item 4']")).click();
		Thread.sleep(2000);
		driver.quit();
		

	}

}
