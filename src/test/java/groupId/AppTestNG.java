package groupId;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppTestNG {

    @Test(dataProvider = "rozprovider")
    public void browserLaunch(String itemToSearch) {
        System.setProperty("webdriver.chrome.driver", ".\\files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
        driver.findElement(By.name("search")).sendKeys(itemToSearch);
        driver.findElement(By.cssSelector("form.search-form button.search-form__submit")).click();
        List<WebElement> searchResults = driver.findElements(By.xpath("//span[contains(.,'"+itemToSearch+"')]"));
        if (searchResults.size() != 0) {
            driver.findElement(By.className("toOrder")).click();
        }

    }
    @DataProvider(name = "rozprovider")
    public Object[] searchItems(){
        return new Object[] {"Airpods", "Bicycle"};
    }
}
