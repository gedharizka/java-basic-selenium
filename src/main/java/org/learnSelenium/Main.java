package org.learnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\myTools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("Open URL");

        // search input
        driver.findElement(By.name("q")).sendKeys("tokopedia");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        // delay

        try {
        Thread.sleep(3000);

        }catch (InterruptedException e){
            throw  new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Web driver out");

    }
}