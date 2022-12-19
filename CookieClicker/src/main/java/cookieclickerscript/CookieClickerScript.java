package cookieclickerscript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CookieClickerScript
{
    static WebDriver driver;

    public static void main (String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://orteil.dashnet.org/cookieclicker/");

        WebElement chooseLanguage = driver.findElement(By.id("langSelect-EN"));

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(chooseLanguage));

        chooseLanguage.click();


        WebElement bigCookie = driver.findElement(By.id("bigCookie"));
        WebElement mouseCursor = driver.findElement(By.id("product0"));

        for(int i = 0; i < 250; i++)
        {
            bigCookie.click();
            mouseCursor.click();
        }

        driver.quit();
    }
}
