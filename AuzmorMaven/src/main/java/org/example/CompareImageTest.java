package org.example;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.image.UnableToCompareImagesException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class CompareImageTest {
    public static void main(String[] args) throws Throwable{

        System.setProperty("web-driver.chrome.driver","C:\\Users\\Public\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();

        driver.get("https://www.judge.com/jobs/");

        driver.findElement(By.xpath("//*[@class='jdg-pagination-item jdg-pagination-item--next']")).click();

//        WebElement elementEmail = driver.findElement(By.xpath("//input[@name='email']"));
//        WebElement elementPassword = driver.findElement(By.xpath("//input[@type='password']"));
//
//        elementEmail.sendKeys("monika.gedam@american-technology.net");
//        elementPassword.sendKeys("Test@123");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//        driver.findElement(By.xpath("//img[@loading='lazy']")).click();
//        driver.findElement(By.xpath("//button[@data-testid='user-menu-profile']")).click();
////        driver.findElement(By.xpath("//div[@class='absolute bg-white rounded-full p-[5px] cursor-pointer top-1 right-1']")).click();
//
//        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
//        fileInput.sendKeys("C:\\Users\\pooji\\Downloads\\mylaptop-wallpaper.jpg");
//        driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div/div[3]/div[3]/div[2]/button[2]")).click();
//        driver.findElement(By.xpath("//*[@id=\"modal\"]/div/div/div/form/div[5]/button[2]")).submit();
        Thread.sleep(1000);


        WebElement logo = driver.findElement(By.xpath("//img[@class='object-cover h-full w-full rounded-full']"));

        String imageSrc = logo.getAttribute("src");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(imageSrc);
        Thread.sleep(6000);
        File image = new File("C:\\Users\\pooji\\Downloads\\mylaptop-wallpaper.jpg");
        BufferedImage expectedImage = ImageIO.read(image);
        String OldImagePath = "C:\\Users\\pooji\\Downloads";
        try {
            boolean isImagesame = Shutterbug.shootPage(driver, Capture.FULL, 500, true).withName("Actual").equalsWithDiff(expectedImage, OldImagePath, 0);
        } catch (UnableToCompareImagesException e) {
            System.out.println("Images dimensions mismatch: " + e.getMessage());

        }
//        driver.quit();
    }
}