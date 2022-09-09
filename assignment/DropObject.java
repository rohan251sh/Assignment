package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropObject {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		Thread.sleep(200);
WebElement drag=driver.findElement(By.id("draggable"));
WebElement drop=driver.findElement(By.id("droppable"));
Actions act=new Actions(driver);
act.dragAndDrop(drag, drop).perform();
Thread.sleep(2000);
driver.quit();
		
		
	}

}
