package letter;


import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "D:\\documents\\java\\lib\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ukr.net/desktop/login");
    }


    @Test
    public void testMail() throws Exception {
        WebElement loginField = driver.findElement(By.id("id-1"));
        loginField.sendKeys("yuksi_test");
        WebElement passwordField = driver.findElement(By.id("id-2"));
        passwordField.sendKeys("test_yuksi");
        WebElement loginButton = driver.findElement(By.className("button"));
        loginButton.click();
        WebElement profileUser = driver.findElement(By.cssSelector(".login-button__user"));
        String mailUser = profileUser.getText();
        Assert.assertEquals("yuksi_test@ukr.net", mailUser);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
