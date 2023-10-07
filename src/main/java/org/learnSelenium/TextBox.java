package org.learnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBox {
    public static void main(String[] args) {
        String pathChromeDriver = "C:\\myTools\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/text-box");
        System.out.println("Open URL");

        /*
        * id=userName
        * id=userEmail
        * id=currentAddress
        * id=permanentAddress
        * id=submit
        * */

        driver.findElement(By.id("userName")).sendKeys("Bot jhon");
        driver.findElement(By.id("userEmail")).sendKeys("jhon@mail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Mampang prapatan");
        js.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.id("permanentAddress")).sendKeys("Mampang prapatan XI");
        driver.findElement(By.id("submit")).click();

        try {
            Thread.sleep(3000);

        }catch (InterruptedException e){
            throw  new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Web driver out");
    }
}
