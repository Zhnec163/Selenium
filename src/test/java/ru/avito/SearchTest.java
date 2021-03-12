package ru.avito;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDef.Sort;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SearchTest {
    WebDriver driver;
    WebDriverWait wait;

    public byte[] getScreenshot(){ return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES); }

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    public void openSite(){ driver.get("https://www.avito.ru/"); }

    public void setCaregoryName(int category){ driver.findElement(By.cssSelector("option[value='" + category + "']")).click(); }

    public void setItemName(String name){
        driver.findElement(By.id("search")).sendKeys(name);
    }

    public void changeCity(){
        driver.findElement(By.className("main-select-2pf7p")).click();
    }

    public void setCityName(String name){
        driver.findElement(By.className("suggest-input-3p8yi")).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("strong")));
    }

    public void pressShowAdsButton() {
        driver.findElement(By.cssSelector("[data-marker='suggest(0)']")).click();
        driver.findElement(By.cssSelector("[data-marker='popup-location/save-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-marker='search-filters/submit-button']")));
    }

    public void result(String name){
        Assert.assertTrue(driver.findElement(By.id("search")).getAttribute("value").equals(name));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-marker='search-filters/submit-button']")));
    }

    public void isDelivery(){
        WebElement checkBoxDelivery = driver.findElement(By.cssSelector("[data-marker='delivery-filter/input']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBoxDelivery);
        if(!checkBoxDelivery.isSelected()){
            driver.findElement(By.cssSelector("[data-marker='delivery-filter/text']")).click();
            driver.findElement(By.cssSelector("[data-marker='search-filters/submit-button']")).click();
        }
    }

    public void setSort(Sort sort){
        driver.findElement(By.xpath("//div[contains(@class, 'sort-select')]/select/option[@data-marker='option(" + sort.getId() + ")']")).click();
    }

    public void getResults(int count){
        ArrayList<WebElement> names =  (ArrayList)driver.findElements(By.xpath("//h3[contains(@itemprop, 'name')]"));
        ArrayList<WebElement> prices =  (ArrayList)driver.findElements(By.xpath("//span/span/meta[contains(@itemprop, 'price')][2]"));
        for (int i = 0; i < count; i++){
            System.out.println("Наименование: " + names.get(i).getText() + " Цена: " + prices.get(i).getAttribute("content"));
        }
    }

    public void tearDown(){
        driver.quit();
    }
}
