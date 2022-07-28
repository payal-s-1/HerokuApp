package com.mindtree.herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ISelect;

import com.mindtree.selenium1.Select;
import com.mindtree.selenium1.WebElement;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");             //Step-1
		
		driver.findElement(By.linkText("Hovers")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@alt='User Avatar']"))).build().perform();
		
		WebElement n = driver.findElement(By.xpath("//h5[@value='name: user1']"));
		System.out.println(n.getText());
		driver.navigate().back();  
		
		driver.findElement(By.linkText("Checkboxes")).click();           //Step-2
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.navigate().back();
		
		driver.findElement(By.linkText("Inputs")).click();               //Step-3   
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1234");
		driver.navigate().back();
		
		driver.findElement(By.linkText("Dropdown")).click();             //Step-4
		Select sel = new Select(driver.findElement(By.id("dropdown")));
		sel.selectByVisibleText("Option 2");                             
		driver.navigate().back();
		
		driver.findElement(By.linkText("File Upload")).click();           //Step-5
		driver.findElement(By.xpath("//input[@id='file-upload']")).click();
		
		WebElement choose = driver.findElement(By.xpath("//input[@id='file-upload']"));
		choose.sendKeys("C:\\Users\\mindc1may140\\Desktop\\Dummy.odt");
		
		driver.findElement(By.xpath("//input[@id='file-submit'")).click();
		driver.navigate().back();
		
		driver.findElement(By.linkText("Sortable Data Tables")).click();      //Step-6
		
		driver.navigate().back();
		
		driver.findElement(By.linkText("Key Presses")).click();            //Step-7
		
		Actions b = new Actions(driver);
		b.moveToElement(driver.findElement(By.xpath("//input[@id='target']"))).click().sendKeys("w").build().perform();
		
		driver.navigate().back();
		
		driver.findElement(By.linkText("Multiple Windows")).click();       //Step-8
		driver.findElement(By.linkText("Click Here")).click();
		
		driver.navigate().to("http://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Context Menu")).click();            //Step-9
		Actions c = new Actions(driver);
		WebElement move = driver.findElement(By.id("hot-spot"));
		a.MoveToElement(move).contextClick().build().perform();
		
		
	}

}
