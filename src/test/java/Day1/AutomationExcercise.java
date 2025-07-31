package Day1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;


import java.time.Duration;

public class AutomationExcercise {
    public static void main(String[] args) throws InterruptedException {

        // ✅ Get environment variables
        String email = System.getenv("LOGIN_EMAIL");
        String password = System.getenv("LOGIN_PASS");

        // ✅ Check if they are loaded
        if (email == null || password == null) {
            System.out.println("❌ ERROR: Environment variables not found. Please set LOGIN_EMAIL and LOGIN_PASS.");
            return;
        }

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        driver.get("https://automationexercise.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //WebDriverWait mywait =new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(text(),' Signup / Login')]")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebDriverWait mywait1 =new WebDriverWait(driver,Duration.ofSeconds(10));
        mywait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=' Products']")));
        //driver.findElement(By.xpath("//a[contains(text(),' Products')]")).click();

        WebElement scrollEle1= driver.findElement(By.xpath("//p[contains(text(),'Sleeveless')]/ancestor::div[@class='single-products']/following-sibling::div/descendant::a"));
        js.executeScript("arguments[0].scrollIntoView()",scrollEle1);
        scrollEle1.click();

        driver.findElement(By.xpath("//button[@type='button']")).click();
        //Alert alert=driver.switchTo().alert();
//
//myalert.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for modal and click 'View Cart'
        //WebElement viewCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View Cart")));
        //WebElement  viewCart=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//u[contains(text(),'View Cart')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Cart"))).click();
        //viewCart.click();
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();

       WebElement scrollEle= driver.findElement(By.xpath("//a[contains(text(),'Place Order')]"));

        js.executeScript("arguments[0].scrollIntoView()",scrollEle);
        wait.until(ExpectedConditions.elementToBeClickable(scrollEle)).click();

       driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("kanakasai");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("4506441234567777");
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("450");
        driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("12");
        driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2030");
        WebElement submit=driver.findElement(By.xpath("//button[@id='submit']"));
        js.executeScript("arguments[0].scrollIntoView()",submit);
        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
//Thread.sleep(5000);

        //p[text()='Congratulations! Your order has been confirmed!']
        String msg = driver.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']")).getText();
        String expectedMessage = "Congratulations! Your order has been confirmed!";

        try {
            Assert.assertEquals(msg, expectedMessage, "❌ Order confirmation message mismatch");
            System.out.println("✅ Order has been placed and TEST PASSED");
        } catch (AssertionError e) {
            System.out.println("TEST FAILED: " + e.getMessage());
            driver.close(); // Close the browser on failure
            throw e; // Optional: rethrow to mark test as failed in reports
        }
       driver.quit();
    }
}
