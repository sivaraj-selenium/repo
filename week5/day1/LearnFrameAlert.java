package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFrameAlert {
	public static void main(String[] args) {
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
	driver.switchTo().frame("iframeResult");
	driver.findElement(By.xpath("//button[text()='Try it']")).click();
	driver.switchTo().alert().accept();
	WebElement AlertMessage = driver.findElement(By.id("demo"));
	String PrintedAlertMessage = AlertMessage.getText();
	System.out.println(PrintedAlertMessage);
 
}
}
