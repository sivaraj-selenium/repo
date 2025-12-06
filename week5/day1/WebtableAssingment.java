package week5.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebtableAssingment {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Launch the erail URL.
		driver.get("https://erail.in/");
		// Enter "MAS" as the "From" station.
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS");
		driver.findElement(By.xpath("//div[text()='Mgr Chennai Ctr']")).click();

		// Enter "MDU" as the "To" station.
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU");
		driver.findElement(By.xpath("//div[text()='Madurai Jn']")).click();

		// - Uncheck the "Sort on Date" checkbox.
		driver.findElement(By.id("chkSelectDateOnly")).click();

		// - Retrieve the train names from the web table.
		List<WebElement> TranNameList = driver.findElements(
				By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']/tbody/tr/td[2]"));
		int NoOfTrain = TranNameList.size();
		System.out.println("No of Train list: " + NoOfTrain);

		for (int i = 0; i < NoOfTrain; i++) {
			String TrainName = TranNameList.get(i).getText();
			boolean isDuplicate = false;

			for (int j = i + 1; j < NoOfTrain; j++) {
				String DupCheck = TranNameList.get(j).getText();
				if (TrainName.equals(DupCheck)) {
					isDuplicate = true;
					System.out.println("Duplicate Rail name: " + TrainName);
					break;

				}
			}
			if (!isDuplicate) {
				System.out.println("Unique Rail name: " + TrainName);

			}

		}

	}

}
