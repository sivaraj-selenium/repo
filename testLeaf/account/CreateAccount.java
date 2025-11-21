package testLeaf.account;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\TestLeaf-Nov25\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("Guest");
		WebDriver obj = new ChromeDriver(opt);
		obj.manage().window().maximize();
		obj.get("http://leaftaps.com/opentaps/");
		obj.findElement(By.id("username")).sendKeys("Demosalesmanager");
		obj.findElement(By.id("password")).sendKeys("crmsfa");
		obj.findElement(By.className("decorativeSubmit")).click();
		obj.findElement(By.partialLinkText("CRM")).click();
		obj.findElement(By.partialLinkText("Accounts")).click();
		obj.findElement(By.partialLinkText("Create")).click();
		WebElement accName = obj.findElement(By.id("accountName"));
		accName.sendKeys("siva1987"+UUID.randomUUID());
		System.out.println("^^^^^^^"+accName.getText());
		obj.findElement(By.name("description")).sendKeys("Selenium Automation Tester.");
		WebElement dropdown = obj.findElement(By.name("industryEnumId"));
		Select choose = new Select(dropdown);
		choose.selectByIndex(3);
		// Select "S-Corporation" as ownership using SelectByVisibleText.
		WebElement ownership = obj.findElement(By.name("ownershipEnumId"));
		Select ownerDrop = new Select(ownership);
		ownerDrop.selectByVisibleText("S-Corporation");
		// Select "Employee" as the source using SelectByValue.
		WebElement source = obj.findElement(By.id("dataSourceId"));
		Select sourceDrop = new Select(source);
		sourceDrop.selectByValue("LEAD_EMPLOYEE");
		// Select "eCommerce Site Internal Campaign" as the marketing campaign using
		// SelectByIndex.
		WebElement market = obj.findElement(By.id("marketingCampaignId"));
		Select marketDrop = new Select(market);
		marketDrop.selectByIndex(6);
		// Select "Texas" as the state/province using SelectByValue.
		WebElement state = obj.findElement(By.id("generalStateProvinceGeoId"));
		Select stateDrop = new Select(state);
		stateDrop.selectByValue("TX");
		// Click the "Create Account" button.
		obj.findElement(By.className("smallSubmit")).click();
		String accountname = obj.findElement(By.partialLinkText("siva1987")).getText();
		System.out.println(accountname);
		//if(accountname.contains(accountname))
	}

}
