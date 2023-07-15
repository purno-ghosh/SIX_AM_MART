import org.openqa.selenium.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;

public class Add_Delivery_Man {
    WebDriver driver;

    //Should Run in Laptop

    @Before
    public void Setup_DeliveryMAN() {
        //Disable all the push notifications from Chrome browser
        ChromeOptions ops1 = new ChromeOptions();
        ops1.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(ops1);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test

    public void TEst02() throws InterruptedException {

        driver.get("https://6ammart.sixamtech.com/dev/login/admin");
        driver.findElement(By.id("signinSrEmail")).sendKeys("rafi.6amtech@gmail.com");
        driver.findElement(By.id("signupSrPassword")).sendKeys("6Am@1234");
        driver.findElement(By.xpath("//button[@type='submit'][contains(.,'login')]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-sm btn-secondary'][contains(.,'End tour')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(.,'Users')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='https://6ammart.sixamtech.com/dev/admin/users/delivery-man/add']")).click();

        //Creating Random value for firstName , LastName , Email, Phone Number

        Random random = new Random();
        String firstName = "Test" + random.nextInt(1000); // Random number appended to "Test"
        String lastName = "Last" + random.nextInt(1000); // Random number appended to "Last"
        String email = "test" + random.nextInt(1000) + "@example.com";
        String phoneNumber = "160000" + String.format("%04d", random.nextInt(10000));// Random 4-digit number appended to "123456"
        driver.findElement(By.xpath("//input[contains(@name,'f_name')]")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[contains(@name,'l_name')]")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys(email);
        driver.findElement(By.xpath("//input[contains(@id,'phone')]")).sendKeys(phoneNumber);
        System.out.println(firstName);
        System.out.println(lastName);
        String K = firstName + " " + lastName;
        System.out.println(K);

        Select sel1 = new Select(driver.findElement(By.xpath("//select[contains(@name,'earning')]")));
        sel1.selectByValue("0");
        Thread.sleep(2000);
        Select sel2 = new Select(driver.findElement(By.xpath("(//select[contains(@name,'id')])[1]")));
        sel2.selectByValue("1");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@class='select2-selection__placeholder'][contains(.,'Select Vehicle')]")).click();
        WebElement aa = driver.findElement(By.xpath("//input[contains(@class,'select2-search__field')]"));
        aa.sendKeys("Bicycle");
        aa.sendKeys(ENTER);
        Thread.sleep(2000);
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys("C:\\Users\\Lenovo\\Desktop\\Product_images\\Deliverman\\Delivarmanpic.png");
        driver.findElement(By.xpath("//input[contains(@name,'identity_number')]")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[contains(@id,'signupSrPassword')]")).sendKeys("6Am@1234");
        driver.findElement(By.xpath("//input[contains(@id,'signupSrConfirmPassword')]")).sendKeys("6Am@1234");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Submit')]")).click();
        Thread.sleep(3000);
        WebElement bb = driver.findElement(By.xpath("//input[contains(@id,'datatableSearch_')]"));
        bb.sendKeys(K);
        Thread.sleep(3000);
        bb.sendKeys(ENTER);


    }


}
