package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		Thread.sleep(200);
		
      Actions act=new Actions(driver);
      WebElement drag=driver.findElement(By.id("draggable"));
      org.openqa.selenium.Point location=drag.getLocation();
      int x=location.getX();
      int y=location.getY();
      act.dragAndDropBy(drag, x+80, y+90).perform();
      Thread.sleep(200);
      act.dragAndDropBy(drag, x+80, y+90).perform();
      Thread.sleep(200);
      act.dragAndDropBy(drag, x-70, y-80).perform();
      Thread.sleep(200);
      act.dragAndDropBy(drag, x-60, y-70).perform();
      Thread.sleep(2000);
      driver.quit();
	}

}

