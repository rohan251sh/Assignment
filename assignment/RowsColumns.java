package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RowsColumns {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Actions act=new Actions(driver);
		act.scrollByAmount(1650, 1660).perform();
		
		String text=driver.findElement(By.xpath("//caption[text()='The Three Most Popular JavaScript Libraries']")).getText();
		System.out.println(text);
		System.out.println("***********************************************");
		
		//Number of rows		
		List<WebElement>list=driver.findElements(By.xpath("//div[@class='render']//table/tbody/tr"));
		int rowsize=list.size();
		System.out.println("Number of rows : " + rowsize);
		
		//Number of columns
		
		List<WebElement>list1=driver.findElements(By.xpath("//div[@class='render']/table//th"));
		int columnsize1=list1.size();
		System.out.println("Number of columns : " + columnsize1);
		Thread.sleep(200);
		driver.quit();
		
	}

}

