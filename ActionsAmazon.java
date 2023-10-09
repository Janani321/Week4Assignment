package Week4.HomeAssignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ActionsAmazon {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("OnePlus 9 Pro");
     // Submit the search
        searchBox.submit();
     
     // Extract the price information from the first product
        String price = driver.findElement(By.xpath("//span[@class='a-price']")).getText();
        System.out.println("Price of the first product: " + price);
     //Print Rating for first product
        WebElement ratings = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']"));
        String numberOfRatings = ratings.getText();
        System.out.println("Number of Ratings for the first product: " + numberOfRatings);
	//screenshot of the product displayed
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        File target = new File("./snap/firstproduct.png");
        FileUtils.copyFile(screenshot, target);
        
     // Click on the first search result (assuming it's the product you want)
        WebElement firstResult = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'](1)"));
        firstResult.click();

        // Add the product to the cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
        
        // Click on the cart icon to go to the cart
        WebElement cartIcon = driver.findElement(By.id("nav-cart-count"));
        cartIcon.click();

        // Verify the cart value (subtotal)
        WebElement cartValue = driver.findElement(By.cssSelector(".a-size-medium:nth-child(2) span.a-price-whole"));
        String cartValueText = cartValue.getText();
        double Value = Double.parseDouble(cartValueText.replace(",", "")); // Remove commas from the price
        double expectedCartValue = 9999.00;
     // Check if the cart value matches the expected value
        if (Value == expectedCartValue) {
            System.out.println("Cart value is correct: " + Value);
        } else {
            System.out.println("Cart value is incorrect. Expected: " + expectedCartValue + ", Actual: " + Value);
        }
        // Close the browser
        driver.quit();
        }
	}

