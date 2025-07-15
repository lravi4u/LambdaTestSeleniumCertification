
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LambdaTest_S3_InputFormSubmitTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Step 1: Open the page and click “Input Form Submit”
            driver.get("https://www.lambdatest.com/selenium-playground");
            driver.findElement(By.linkText("Input Form Submit")).click();

            // Step 2: Click Submit without filling the form
            WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
            submitButton.click();

            // Step 3: Assert the browser validation message
            WebElement firstField = driver.findElement(By.name("name"));
            String validationMessage = firstField.getAttribute("validationMessage");

            if (validationMessage != null && !validationMessage.isEmpty()) {
                System.out.println("Browser validation message is displayed : '" + validationMessage + "'");
            } else {
                System.out.println("Browser Validation message NOT displayed");
            }

            // Step 4–6: Fill all required fields and submit the form
            driver.findElement(By.name("name")).sendKeys("John Doe");
            driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("jd@example.com");
            driver.findElement(By.name("password")).sendKeys("Password123");
            driver.findElement(By.name("company")).sendKeys("Ravi Corp");
            driver.findElement(By.name("website")).sendKeys("https://example.com");

            Select countryDropdown = new Select(driver.findElement(By.name("country")));
            countryDropdown.selectByVisibleText("United States");

            driver.findElement(By.name("city")).sendKeys("New York");
            driver.findElement(By.name("address_line1")).sendKeys("123 Elm Street");
            driver.findElement(By.name("address_line2")).sendKeys("Apt 4B");
            driver.findElement(By.cssSelector("#inputState")).sendKeys("NY");
            driver.findElement(By.name("zip")).sendKeys("10001");

            // Step 6: Click Submit
            submitButton.click();

            // Step 7: Validate success message
            WebElement successMessage = driver.findElement(By.className("success-msg"));
            String messageText = successMessage.getText();

            if (messageText.contains("Thanks for contacting us, we will get back to you shortly.")) {
                System.out.println("Success message displayed correctly. The message is '" + messageText + "'");
            } else {
                System.out.println("Success message not found or incorrect.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
