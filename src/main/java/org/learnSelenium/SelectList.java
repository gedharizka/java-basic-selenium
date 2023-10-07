package org.learnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SelectList {
    public static void main(String[] args) {
        String pathChromeDriver = "C:\\myTools\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/select-menu");
        System.out.println("Open URL");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        String title = driver.getTitle();
        System.out.println("titpe header:" + title);
        String titlePage = driver.findElement(By.className("main-header")).getText();
        System.out.println(titlePage);

       // Handle Select
        Select pilihWarna = new Select(driver.findElement(By.id("oldSelectMenu")));
        pilihWarna.selectByValue("4");
        pilihWarna.selectByVisibleText("Blue");
        pilihWarna.selectByIndex(8);
        System.out.println("Pilih warna indigo");




        delay(3);
        driver.quit();
        System.out.println("Web driver out");
    }

    static void delay(long detik){
        try {
            Thread.sleep(1000 * detik);

        }catch (InterruptedException e){
            throw  new RuntimeException(e);
        }
    }
}
