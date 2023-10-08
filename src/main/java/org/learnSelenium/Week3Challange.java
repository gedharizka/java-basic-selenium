package org.learnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Week3Challange {
    public static void main(String[] args) {
        String pathChromeDriver = "C:\\myTools\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://juice-shop.herokuapp.com/");
        System.out.println("Open URL");
        String email = "gedharizka@proton.me";
        String password = "JuaraCod1ng@2023";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]")).click();
        delay(2);

        driver.findElement(By.id("navbarAccount")).click();
        delay(1);
        driver.findElement(By.id("navbarLoginButton")).click();
        delay(3);

        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        delay(3);

        driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[2]/button")).click();
        driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[5]/div/mat-card/div[2]/button")).click();

        String item = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[4]/span[1]/span[2]")).getText();

        if (item.equals("2")) {
            System.out.println("Success add item");
        } else {
            System.out.println("Success add item");
        }


        driver.quit();
        System.out.println("Web driver done");

    }

    static void delay(long detik) {
        try {
            Thread.sleep(1000 * detik);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}