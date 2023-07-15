import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;

public class Employee_Role {

    WebDriver driver;

    @Before
    public void SetupWindow() {

        //Disable all the push notifications from Chrome browser

        ChromeOptions ops1 = new ChromeOptions();
        ops1.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(ops1);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    //Should run in monitor

    @Test

    public void Verify_Employee_Rules() throws InterruptedException {
        driver.get("https://6ammart.sixamtech.com/dev/login/admin");
        driver.findElement(By.id("signinSrEmail")).sendKeys("rafi.6amtech@gmail.com");
        driver.findElement(By.id("signupSrPassword")).sendKeys("6Am@1234");
        driver.findElement(By.xpath("//button[@type='submit'][contains(.,'login')]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-sm btn-secondary'][contains(.,'End tour')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(.,'Users')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='https://6ammart.sixamtech.com/dev/admin/users/custom-role/create']")).click();

        //Creating Random value for Role Name

        Random random = new Random();
        String Rolename = "Role" + random.nextInt(1000);
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[2]")).sendKeys(Rolename);
        driver.findElement(By.xpath("//label[@class='form-check-label qcont text-dark'][contains(.,'Collect Cash')]")).click();
        driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Submit')]")).click();
        System.out.println(Rolename);

        driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'Employees')]")).click();
        driver.findElement(By.xpath("//a[@href='https://6ammart.sixamtech.com/dev/admin/users/employee/add-new']")).click();
        Thread.sleep(2000);

        String firstName = "Test" + random.nextInt(1000);
        String phoneNumber = "160000" + String.format("%04d", random.nextInt(10000));// Random 4-digit number appended to "123456"
        String email = "test" + random.nextInt(1000) + "@example.com";

        driver.findElement(By.xpath("//input[contains(@id,'fname')]")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[contains(@id,'lname')]")).sendKeys("Role");
        driver.findElement(By.xpath("//input[contains(@id,'phone')]")).sendKeys(phoneNumber);

        driver.findElement(By.xpath("(//span[contains(.,'All')])[5]")).click();
        WebElement a1 = driver.findElement(By.xpath("//input[contains(@class,'select2-search__field')]"));
        a1.sendKeys("Main Demo Zone");
        a1.sendKeys(ENTER);
        Thread.sleep(2000);

        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys("C:\\Users\\Lenovo\\Desktop\\Product_images\\Deliverman\\Delivarmanpic.png");

        driver.findElement(By.xpath("//span[@class='select2-selection custom-select'][contains(.,'Select Role')]")).click();
        WebElement a2 = driver.findElement(By.xpath("//input[contains(@class,'select2-search__field')]"));
        a2.sendKeys(Rolename);
        a2.sendKeys(ENTER);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys(email);
        driver.findElement(By.xpath("//input[contains(@id,'signupSrPassword')]")).sendKeys("6Am@1234");
        driver.findElement(By.xpath("//input[contains(@id,'signupSrConfirmPassword')]")).sendKeys("6Am@1234");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Submit')]")).click();
        Thread.sleep(2000);
        WebElement cc = driver.findElement(By.xpath("//input[contains(@id,'')][@type='search']"));
        cc.sendKeys(firstName);
        Thread.sleep(3000);
        cc.sendKeys(ENTER);


    }


}
