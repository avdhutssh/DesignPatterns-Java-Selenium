package _01_SRP;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class standAlone {

	String searchItem1 = "Selenium";
	String searchItem2 = "Selenium java";
	int searchIndex = 3;

	@Test
	public void e2eFlow() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		WebElement searchBoxHomePage = driver.findElement(By.xpath("//*[@title='Search']"));
		searchBoxHomePage.sendKeys(searchItem1);
		Thread.sleep(1000);
		List<WebElement> searchResults = driver.findElements(By.cssSelector("div.wM6W7d"));
		searchResults.get(3).click();
		Thread.sleep(1000);
		WebElement searchBoxSearchPage = driver.findElement(By.xpath("//textarea[@aria-label='Search']"));
		searchBoxSearchPage.click();
		Thread.sleep(1000);
		searchBoxSearchPage.clear();
		searchBoxSearchPage.sendKeys(searchItem2 + Keys.ENTER);

	}
}
