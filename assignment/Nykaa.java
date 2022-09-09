package assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Mouseover on Brands and Mouseover on Popular
		Actions act=new Actions(driver);
		WebElement text=driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
		act.moveToElement(text).perform();
		
		// Click L'Oreal Paris
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		String title=driver.getTitle();
	       System.out.println(title);
	       
	      // Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
		act.scrollByAmount(600, 700).perform();
		
		//Click Category and click Shampoo
        driver.findElement(By.xpath("//span[text()='Category']")).click();
		act.scrollByAmount(300, 400).perform();
		
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		act.scrollByAmount(300, 400).perform();
		Thread.sleep(20);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		//check whether the Filter is applied with Shampoo
		String filter=driver.findElement(By.xpath("//span[@class='name']")).getText();
		System.out.println(filter);
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//img[@class='css-11gn9r6']")).click();
		
		Set<String>whandles=driver.getWindowHandles();
		List<String>swi=new ArrayList<String>(whandles);
		driver.switchTo().window(swi.get(1));
		driver.manage().window().maximize();
		
		//Print the MRP of the product
		String shampooprice=driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
		String price=shampooprice.replaceAll("\\D","");
		int pricevalue=Integer.parseInt(price);
		System.out.println("Shampoo MRP : " +pricevalue);
		
		Thread.sleep(20);
		
		//Click on ADD to BAG
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		
		// Go to Shopping Bag
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Set<String>whandle=driver.getWindowHandles();
		List<String>swi1=new ArrayList<String>(whandle);
		driver.switchTo().window(swi1.get(1));
		  driver.switchTo().frame(0);
		  Thread.sleep(2000);
		// Print the Grand Total amount
		String total=driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		String price1=total.replaceAll("\\D","");
		int pricevalue1=Integer.parseInt(price1);
		System.out.println("Grand Total : " +pricevalue1);		
		
		// Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		//Click on Continue as Guest
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		Thread.sleep(200);
		
		//Check if this grand total is the same in step 14
		String total1=driver.findElement(By.xpath("//span[text()='259']")).getText();
		String price2=total1.replaceAll("\\D","");
		int pricevalue2=Integer.parseInt(price2);
		System.out.println("Grand Total on shippment page : " +pricevalue2);
		if(pricevalue1==pricevalue2)
			System.out.println("The Grand total matches");
		else System.out.println("the Grand total didnot match");
		Thread.sleep(2000);
		driver.quit();
		
		

	}

}


