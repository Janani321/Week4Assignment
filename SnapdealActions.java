package Week4.HomeAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapdealActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// Find and click "Men's Fashion"
		driver.findElement(By.className("catText")).click();

        // Find and click "Sports Shoes"
		driver.findElement(By.className("linkTest")).click();

        // Get the count of sports shoes
		WebElement sportsShoesCount = driver.findElement(By.className("category-count"));
        String countText = sportsShoesCount.getText();
        System.out.println("Count of sports shoes: " + countText);

        // Find and click "Training Shoes"
		driver.findElement(By.className("child-cat-count")).click();


        // Find and select "Low to High" sorting option
        WebElement sortDropdown = driver.findElement(By.className("sort-drop"));
        sortDropdown.click();
       driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
        
        // Verify if the displayed items are sorted correctly (you can implement your own verification logic here)

        // Select price range (500-700)
        WebElement priceRangeDropdown = driver.findElement(By.className("price-drop"));
        priceRangeDropdown.click();
        WebElement priceRangeOption = driver.findElement(By.xpath("//a[text()='Rs 500 - Rs 700']"));
        priceRangeOption.click();

        // Filter by color (you can change the color as needed)
        WebElement colorFilter = driver.findElement(By.xpath("//label[@title='Black']"));
        colorFilter.click();
        // Verify all the applied filters (you can implement your own verification logic here)

        // Mouse hover on the first resulting "Training Shoes"
        WebElement firstTrainingShoes = driver.findElement(By.xpath("//div[@class='product-desc-rating']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstTrainingShoes).build().perform();

        // Click the "Quick View" button
        WebElement quickViewButton = driver.findElement(By.xpath("//span[@text ='21% Off']"));
        quickViewButton.click();

        // Print the cost and the discount percentage
        WebElement cost = driver.findElement(By.className("payBlkBig"));
        WebElement discountPercentage = driver.findElement(By.className("product-discount"));
        System.out.println("Cost: " + cost.getText());
        System.out.println("Discount Percentage: " + discountPercentage.getText());

        // Close the browser
        driver.quit();
    }
	}


