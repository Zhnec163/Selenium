package ru.avito;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchTest {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public  void searchTest(){
        driver.get("https://www.avito.ru/");

        driver.findElement(By.cssSelector("option[value='99']")).click();
        driver.findElement(By.id("search")).sendKeys("Принтер");

        driver.findElement(By.className("main-select-2pf7p")).click();
        driver.findElement(By.className("suggest-input-3p8yi")).sendKeys("Владивосток");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("strong")));

        driver.findElement(By.cssSelector("[data-marker='suggest(0)']")).click();
        driver.findElement(By.cssSelector("[data-marker='popup-location/save-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-marker='search-filters/submit-button']")));

        WebElement checkBoxDelivery = driver.findElement(By.cssSelector("[data-marker='delivery-filter/input']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBoxDelivery);
        if(!checkBoxDelivery.isSelected()){
            driver.findElement(By.cssSelector("[data-marker='delivery-filter/text']")).click();
            driver.findElement(By.cssSelector("[data-marker='search-filters/submit-button']")).click();
        }

        driver.findElement(By.xpath("//div[contains(@class, 'sort-select')]/select/option[@data-marker='option(2)']")).click();

        ArrayList<WebElement> names =  (ArrayList)driver.findElements(By.xpath("//h3[contains(@itemprop, 'name')]"));
        ArrayList<WebElement> prices =  (ArrayList)driver.findElements(By.xpath("//span/span/meta[contains(@itemprop, 'price')][2]"));
        for (int i = 0; i < 3; i++){
            System.out.println("Наименование: " + names.get(i).getText() + " Цена: " + prices.get(i).getAttribute("content"));
        }
    }

    @After
    public void close(){
        driver.quit();
    }
}
