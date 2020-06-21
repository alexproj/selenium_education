package groupId;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class AppTest {

    @Test
    public void browserLaunch() {
        System.setProperty("webdriver.chrome.driver", ".\\files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
        driver.findElement(By.name("search")).sendKeys("airpods");
        driver.findElement(By.cssSelector("form.search-form button.search-form__submit")).click();
        List<WebElement> searchResults = driver.findElements(By.xpath("//span[contains(.,'Airpods') or contains(.,'AirPods')] "));
        if (searchResults.size() != 0) {

            driver.findElement(By.className("toOrder")).click();
            /*System.out.println(searchResults.size());
            WebElement elem1= ((WebElement)searchResults.get(1));
            System.out.println(elem1);
            System.out.println(elem1.findElement(By.className("buy-button")).getTagName());*/
        }

    }
    //System.out.println(elements.size());


}




