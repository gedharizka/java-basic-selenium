package org.learnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Alert {
    public static void main(String[] args) {
        String pathChromeDriver = "C:\\myTools\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/alerts");
        System.out.println("Open URL");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        String title = driver.getTitle();
        System.out.println("titpe header:" + title);
        String titlePage = driver.findElement(By.className("main-header")).getText();
        System.out.println(titlePage);

        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.id("timerAlertButton")).click();
        delay(6);
        driver.switchTo().alert().accept();

        //promtButton
        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("Test");





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
