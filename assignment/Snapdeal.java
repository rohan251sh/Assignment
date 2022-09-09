package assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//2. Go to Mens Fashion
		Actions act=new Actions(driver);
		WebElement mens=driver.findElement(By.xpath("//span[@class='catText']"));
		act.moveToElement(mens).perform();
		
		//3. Go to Sports Shoes
		driver.findElement(By.xpath("//span[@class='linkTest']")).click();
		
		//4. Get the count of the sports shoes
		 String text=driver.findElement(By.xpath("//div[@class='child-cat-count ']")).getText();
		System.out.println("Number of sports shoes : " +text);
		
		//5. Click Training shoes
		driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
		
		//Before Sorting
		List<WebElement> price=driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<String> prices = new ArrayList<String>();
		for (WebElement e : price)
		{
		    prices.add(e.getText());
		}
		System.out.println("Before sorted:" +prices);
	        
	        Thread.sleep(200);
	        
		//6. Sort by Low to High
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//li[@class='search-li']")).click();
		 driver.navigate().refresh();
	        Thread.sleep(200);
		List<WebElement> price1=driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<String> prices1 = new ArrayList<String>();
		
		for (WebElement e : price1)
		{
		    prices1.add(e.getText());
		}
		System.out.println("After sorted " +prices1);

		//7.Check if the items displayed are sorted correctly
		
		if(prices.equals(prices1))
		{
			System.out.println("Items are not sorted");
		}
		else
		{
			System.out.println("Items are sorted");
		}
	    
		//8.Select the price range (900-1200)
		WebElement slider1=driver.findElement(By.xpath("//a[@class='price-slider-scroll left-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']"));
        act.dragAndDropBy(slider1, 50, 0).perform();
        Thread.sleep(2000);
        WebElement slider2=driver.findElement(By.xpath("//a[@class='price-slider-scroll right-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']"));
        act.dragAndDropBy(slider2,-130,0).perform();
        
        Thread.sleep(200);
        
        //9.Filter with color Navy
  
        // Mouse Hover on first resulting Training shoes
       WebElement firstresult= driver.findElement(By.xpath("//img[@class='product-image wooble']"));
       act.moveToElement(firstresult).perform();
       
       //12. click QuickView button
       Thread.sleep(200);
       driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();
       
       //13. Print the cost and the discount percentage
    
       String cost = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
   	System.out.println("Price of the shoe : " +cost);
   	String discount=driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
   	System.out.println("Discount is : " +discount);

   	//14. Take the snapshot of the shoes.
   	File source=driver.getScreenshotAs(OutputType.FILE);
	File dest=new File("./Image/shot.jpg");
	FileUtils.copyFile(source, dest);
        Thread.sleep(2000);
      
       driver.quit();
        
	}

}

