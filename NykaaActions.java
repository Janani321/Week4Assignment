package Week4.HomeAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NykaaActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// Mouseover on "Brands"
        WebElement brandsMenu = driver.findElement(By.linkText("brands"));
        Object actions;
		((Object) actions).moveToElement(brandsMenu).perform();

        // Search for "L'Oreal Paris"
        WebElement searchInput = driver.findElement(By.id("search"));
        searchInput.sendKeys("L'Oreal Paris");
        searchInput.submit();

        // Click on "L'Oreal Paris"
        WebElement lorealParisLink = driver.findElement(By.linkText("L'Oreal Paris"));
        lorealParisLink.click();
		
		
		
	}

}
