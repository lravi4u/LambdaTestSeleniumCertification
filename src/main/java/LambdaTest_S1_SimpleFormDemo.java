
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LambdaTest_S1_SimpleFormDemo {

    public static void main(String[] args) {
        //ChromeOptions options = new ChromeOptions();
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Open LambdaTest’s Selenium Playground
            driver.get("https://www.lambdatest.com/selenium-playground");
            driver.manage().window().maximize();

            // 2. Click “Simple Form Demo”
            WebElement simpleFormLink = driver.findElement(By.linkText("Simple Form Demo"));
            simpleFormLink.click();

            // 3. Validate that the URL contains “simple-form-demo”
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("simple-form-demo")) {
                System.out.println("URL validation - contains text 'simple-form-demo' passed. URL is : " + currentUrl);
            } else {
                System.out.println("URL validation - contains text 'simple-form-demo' failed. URL is : " + currentUrl);
            }

            // 4. Create a variable for a string value
            String message = "Welcome to LambdaTest";

            // 5. Use this variable to enter value in the “Enter Message” text box
            WebElement messageInput = driver.findElement(By.id("user-message"));
            messageInput.clear();
            messageInput.sendKeys(message);

            // 6. Click “Get Checked Value”
            WebElement getCheckedValueButton = driver.findElement(By.xpath("//button[text()='Get Checked Value']"));
            getCheckedValueButton.click();

            // 7. Validate whether the same text is displayed
            WebElement displayedMessage = driver.findElement(By.id("message"));
            String actualMessage = displayedMessage.getText();

            if (actualMessage.equals(message)) {
                System.out.println("Message validation passed and contains text : " + actualMessage);
            } else {
                System.out.println("Message validation failed and contains text. Expected: " + message + ", but got: " + actualMessage);
            }

        } catch (Exception e) {
            System.out.println("Exception encountered: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

