
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LambdaTest_S2_SliderTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Step 1: Open the URL and click on "Drag & Drop Sliders"
            driver.get("https://www.lambdatest.com/selenium-playground");
            driver.findElement(By.linkText("Drag & Drop Sliders")).click();

            // Step 2: Find the slider with label 'Default value 15'
            WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
            WebElement rangeValue = driver.findElement(By.id("rangeSuccess"));

            // Use Actions to drag the slider
            Actions action = new Actions(driver);

            // Drag the slider until the value becomes 95
            int targetValue = 95;
            while (Integer.parseInt(rangeValue.getText()) < targetValue) {
                action.clickAndHold(slider).moveByOffset(215, 0).release().perform();
            }

            // Validate final value
            String finalValue = rangeValue.getText();
            if (finalValue.equals("95")) {
                System.out.println("Slider value is successfully set to " + finalValue);
            } else {
                System.out.println("Slider value is: " + finalValue);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}