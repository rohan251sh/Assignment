package assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	private static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(" https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//2.search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro ");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		//3.Get the price of the first product
	List	<WebElement> text=driver.findElements(By.xpath("(//span[@class='a-price-whole'])"));
	String  price=text.get(0).getText().replaceAll("\\D", "");
	System.out.println("The price of first displayed item "+price);
		Thread.sleep(200);
		Actions act=new Actions(driver);
		act.scrollByAmount(400, 500).perform();
		
		//4.Print the number of customer ratings for the first displayed product
		driver.findElement(By.xpath("//i[@class='a-icon a-icon-popover']")).click();
		
	
	//5. Mouse Hover on the stars
	String rating=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-beside-button a-text-bold']")).getText();
	System.out.println("Rating of the product :  " +rating);
	
	//6. Get the percentage of ratings for the 5 star
	String price1= driver.findElement(By.xpath("//td[@class='a-text-right a-nowrap']")).getText();
	System.out.println("5 Star rating percentage : " +price1);
	
	//7. Click the first text link of the first image
	driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]")).click();
	
	Set<String>whandles=driver.getWindowHandles();
	List<String>swi=new ArrayList<String>(whandles);
	driver.switchTo().window(swi.get(1));
	
	//8. Take a screen shot of the product displayed
	File source=driver.getScreenshotAs(OutputType.FILE);
	File dest=new File("./Image/shot.jpg");
	FileUtils.copyFile(source, dest);
	 
	//9. Click 'Add to Cart' button
	driver.findElement(By.id("add-to-cart-button")).click();

	Set<String>whandle=driver.getWindowHandles();
	List<String>swi1=new ArrayList<String>(whandle);
	driver.switchTo().window(swi1.get(1));
	
	//10. Get the cart subtotal and verify if it is correct.
	 driver.findElement(By.id("attach-sidesheet-view-cart-button")).click();
	String subtotal = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")).getText();
	System.out.println("The cart subtotal : " +subtotal);
	Thread.sleep(200);
	driver.quit();
	}

}
