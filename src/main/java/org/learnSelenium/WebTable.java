package org.learnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebTable {
    public static void main(String[] args) {
        //scraping
        String pathChromeDriver = "C:\\myTools\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/webtables");
        System.out.println("Open URL");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        String title = driver.getTitle();
        System.out.println("titpe header:" + title);
        String titlePage = driver.findElement(By.className("main-header")).getText();
        System.out.println(titlePage);

        /**
         *firstName
         *lastName
         * userEmail
         *age
         *salary
         *department
         * submit
         */

        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys("Jaka");
        driver.findElement(By.id("lastName")).sendKeys("Tingkir");
        driver.findElement(By.id("userEmail")).sendKeys("jakatingkir@mail.com");
        driver.findElement(By.id("age")).sendKeys("25");
        driver.findElement(By.id("salary")).sendKeys("7500");
        driver.findElement(By.id("department")).sendKeys("IT Development");
        driver.findElement(By.id("submit")).click();


        // handle checkbox

        driver.get("https://demoqa.com/checkbox");
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();
        // Checklist desktop dan downloads
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label/span[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[3]")).click();
        System.out.println("--- Checkbox done ---");

        // Handle radio button
        driver.get("https://demoqa.com/radio-button");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label")).click();
        String textImpresive = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label")).getText();
        System.out.println(textImpresive);
        if(textImpresive.equals("Impressive")){
            System.out.println("find success");
        }else {
            System.out.println("Failed");
        }
        System.out.println("==== Radio button done =====");

        try {
            Thread.sleep(3000);

        }catch (InterruptedException e){
            throw  new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Web driver out");
    }
}
