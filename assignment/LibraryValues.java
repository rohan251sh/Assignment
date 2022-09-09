package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibraryValues {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		//Number of rows		
				List<WebElement>list=driver.findElements(By.xpath("//div[@class='render']//table/tbody/tr"));
				int rowsize=list.size();
				System.out.println("Number of rows : " + rowsize);
				
		//Number of columns
				List<WebElement>list1=driver.findElements(By.xpath("//div[@class='render']/table//th"));
				int columnsize1=list1.size();
				System.out.println("Number of columns : " + columnsize1);
				
				//2. You have to print the respective values based on given Library
				
				
				for(int i=1;i<=columnsize1;i++)
				{
					String absolute=driver.findElement(By.xpath("//div[@class='render']//table/tbody[1]/tr[2]/td["+i+"]")).getText();
			System.out.println("Values on absolute usage " +absolute);
				}		
				Thread.sleep(2000);
				driver.quit();
 	}
}
