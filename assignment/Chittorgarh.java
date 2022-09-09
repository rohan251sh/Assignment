package assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
		driver.findElement(By.linkText("NSE Bulk Deals")).click();
		Actions act=new Actions(driver);
		act.scrollByAmount(650, 660).perform();
		
		String title=driver.findElement(By.xpath("(//table[@class='table table-bordered table-condensed table-striped']//th)[3]")).getText();
		System.out.println(title);
		System.out.println("****************");
		
		java.util.List<WebElement> rcount = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr"));
		int rsize=rcount.size();
		System.out.println("Original Security names:" + rsize);
		List<String>security=new ArrayList<String>();
		
		for(int i=1;i<rsize;i++)
		{
			String rowvalues=driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr["+i+"]/td[3]")).getText();
			//System.out.println(rowvalues);
			security.add(rowvalues);
		}
		
	
		Set<String>names=new LinkedHashSet<String>(security);
		int rsize1=names.size();
		System.out.println("Security names without duplicates Count : " +rsize1);
		System.out.println("Security names without duplicates : " +names);
	Thread.sleep(2000);
	driver.quit();
		
	    
				
	}

}
