package assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntraa {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// 2)Mouseover on Brands and Mouseover on Popular
		Actions act=new Actions(driver);
		WebElement men=driver.findElement(By.className("desktop-main"));
        act.moveToElement(men).perform();
        
        //3) Click Jackets 
      WebElement search=driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
      search.sendKeys("jackets for men");
      search.sendKeys(Keys.ENTER);
      
      //4) Find the total count of item 
      String totalcount1=driver.findElement(By.xpath("//span[@class='title-count']")).getText();
      String text = totalcount1.replaceAll("\\D","") ;
      int totalcount=Integer.parseInt(text) ;
      System.out.println("Total count of item : " +totalcount);
      
      //Validate the sum of categories count matches
      String text1=driver.findElement(By.xpath("//label[@class='common-customCheckbox vertical-filters-label']")).getText();
      String str=text1.replaceAll("\\D", "");  //removes all non digit characters
      int jacketcount=Integer.parseInt(str);  //converts gettext to integer
      
      String text2=driver.findElement(By.xpath("(//label[@class='common-customCheckbox vertical-filters-label'])[2]")).getText();
      String str1=text2.replaceAll("\\D", "");
      int nehrujackets=Integer.parseInt(str1);
      
      int sum=jacketcount+nehrujackets;
      System.out.println("Sum of Category :" +sum);
      if(totalcount==sum)
      {
    	  System.out.println("Category count matches total count of item");
      }
      else
      {
    	  System.out.println("Category count not matches total count of item");
      }
	
	//6) Check jackets
	driver.findElement(By.xpath("//label[@class='common-customCheckbox vertical-filters-label']")).click();
	
	//7) Click + More option under BRAND
driver.findElement(By.xpath("//div[@class='brand-more']")).click();

//8) Type Duke and click checkbox
driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();

//9) Close the pop-up x
driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();

//10) Confirm all the Coats are of brand Duke
Thread.sleep(200);

List <WebElement>duke =driver.findElements(By.xpath("//h3[@class='product-brand']"));
List<String>brandname=new ArrayList<String>();
for (WebElement e : duke)
{
    brandname.add(e.getText());
}
System.out.println("Coats brand name:" +brandname);



//11) Sort by Better Discount
WebElement sort=driver.findElement(By.xpath("//div[text()='Sort by : ']"));
act.moveToElement(sort).perform();
driver.findElement(By.xpath("//label[text()='Better Discount']")).click();

//12) Find the price of first displayed item
Thread.sleep(200);
List<WebElement> pricelist = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
String  price=pricelist.get(0).getText().replaceAll("\\D", "");
System.out.println("The price of first displayed item "+price);

//Click on the first product
driver.findElement(By.xpath("//img[@class='img-responsive']")).click();
Set<String>whandle=driver.getWindowHandles();
List<String>swi=new ArrayList<String>(whandle);
driver.switchTo().window(swi.get(1));

//13) Take a screen shot
File source=driver.getScreenshotAs(OutputType.FILE);
File dest=new File("./Image/shot.jpg");
FileUtils.copyFile(source, dest);
    Thread.sleep(200);
    driver.close();
 

	}	
}

