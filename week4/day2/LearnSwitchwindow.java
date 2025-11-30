package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnSwitchwindow {

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		ChromeOptions disableNotify = option.addArguments("--disable-notifications");
		ChromeDriver obj = new ChromeDriver(disableNotify);
		// - Initialize ChromeDriver - Load the URL (https://www.irctc.co.in/)
		obj.get("https://www.irctc.co.in/");
		// - Maximize the browser window
		obj.manage().window().maximize();
		// - Add an implicit wait to ensure the webpage elements are fully loaded
		obj.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		obj.findElement(By.xpath("//button[text()='OK']")).click();
		obj.findElement(By.xpath("//span[@class='allcircle circleone']")).click();
		// obj.findElement(By.partialLinkText("FLIGHTS")).click();
		// - Capture the title of the new window that opens (flights window -AirTicket).
		Set<String> windowOpened = obj.getWindowHandles();
		System.out.println(windowOpened);
		List<String> copyWindows = new ArrayList<String>(windowOpened);
		obj.switchTo().window(copyWindows.get(1));
		String childtitle = obj.getTitle();
		System.out.println(childtitle);
		// Close the parent tab (Train ticket booking) alone.
		obj.switchTo().window(copyWindows.get(0));
		String parenttitle = obj.getTitle();
		if (parenttitle.contains("IRCTC Next")) {
			// Close the parent tab (Train ticket booking) alone.
			obj.close();
			System.out.println("The parent tab (Train ticket booking) was closed");

		} else {
			System.out.println("Parent webpage is not Switched");
		}

	}

}
