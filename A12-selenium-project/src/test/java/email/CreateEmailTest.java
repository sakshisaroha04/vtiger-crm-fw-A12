package email;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CreateEmailTest {
public static void main(String[] args)throws InterruptedException {
		
//		Open Browser 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Login
		driver.get("http://localhost:8888/");
		
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("manager");
		
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Email")).click();
		Thread.sleep(2000);
		
		//driver.findElement(By.partialLinkText("javascript")).click();
		
		//driver.findElement(By.linkText("Compose")).click();
		
		//String pid = driver.getWindowHandle();
		//Set<String> cid = driver.getWindowHandles();
		
		//for (String win : cid) {
		 //   if (!win.equals(pid)) {
		     //
		
		driver.findElement(By.linkText("Compose")).click();

		String pid = driver.getWindowHandle();
		Set<String> cid = driver.getWindowHandles();

		// switch to compose window
		for (String win : cid) {
		    if (!win.equals(pid)) {
		        driver.switchTo().window(win);
		    }
		}

		System.out.println("Current Title: " + driver.getTitle());

		// ==== Compose Window ====
		// yaha frame mat lo, direct fields fill karo
		driver.findElement(By.id("parent_name")).sendKeys("sakshi@mail.com");
		driver.findElement(By.id("cc_name")).sendKeys("sonali@gmail.com");
		driver.findElement(By.name("subject")).sendKeys("Test Subject");

		Thread.sleep(2000);

		// Select Email Template button click
		driver.findElement(By.xpath("//input[@value='Select Email Template']")).click();

		// ==== Switch to Template Window ====
		Set<String> allWins2 = driver.getWindowHandles();
		String composeWin = driver.getWindowHandle();  // abhi ka active (compose)

		for (String win : allWins2) {
		    if (!win.equals(pid) && !win.equals(composeWin)) {
		        driver.switchTo().window(win); // template window
		    }
		}

		System.out.println("Switched to Template: " + driver.getTitle());

		// ==== Template Window Active ====
		driver.findElement(By.linkText("Thanks Note")).click();

		// ==== Switch back to Compose Window ====
		driver.switchTo().window(composeWin);
		System.out.println("Back to Compose: " + driver.getTitle());

		Thread.sleep(2000);

		// Send button
		driver.findElement(By.name("button")).click();

		
		
		
		
		
}
}
