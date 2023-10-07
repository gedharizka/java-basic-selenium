package org.learnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Challange {
    public static void main(String[] args) {
        String pathChromeDriver = "C:\\myTools\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Open URL");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


//        String title = driver.getTitle();
//        System.out.println("titpe header:" + title);
//        String titlePage = driver.findElement(By.className("main-header")).getText();
//        System.out.println(titlePage);

       /*
       * By xpath
       * */
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");

        /*
        * By Name
        * */
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

        String isDashboard = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();

        if(isDashboard.equals("Dashboard")){
            System.out.println("Success");
        }else {
            System.out.println("Failded");
        }


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
