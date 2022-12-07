package amzon;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\seleniumsetup\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=null;
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("laptops");
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		
		String originalwindow=driver.getWindowHandle();
		System.out.println(originalwindow);
		
		String expec=driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base a-text-normal')]")).getText();
		driver.findElement(By.xpath("(//img[contains(@src,'https://m.media-amazon.com/images/I/')])[3]")).click();

		
		Set<String> handles=driver.getWindowHandles();
//		Iterator<String> windows=handles.iterator();
//		
//		String parentwindow=windows.next();
//		String childwindow=windows.next();
//		
//		driver.switchTo().window(childwindow);
//		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		for(String i:handles)
		{
			System.out.println(i);
			Thread.sleep(4000);
			if(!i.equalsIgnoreCase(originalwindow))
				//if(i!=originalwindow)
			{
				driver.switchTo().window(i);
				driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
				
			}
		}
		
		
	}

}
