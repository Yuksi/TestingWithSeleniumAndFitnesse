package letter;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkWithMail {
    private String login;
    private String psw;
    private WebDriver driver;

    /*
    public void setDriver(String driverName, String path, WebDriver driver) {
        System.setProperty(driverName, path);
        this.driver = new ChromeDriver();
    }
    */
    public void setDriverChrome() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String loginUkrNet() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ukr.net/desktop/login");

        WebElement loginField = driver.findElement(By.id("id-1"));
        loginField.sendKeys(login);
        WebElement passwordField = driver.findElement(By.id("id-2"));
        passwordField.sendKeys(psw);
        WebElement loginButton = driver.findElement(By.className("button"));
        loginButton.click();
        if (driver.getCurrentUrl().equals("https://mail.ukr.net/desktop#msglist/f0/p0")) {
            WebElement profileUser = driver.findElement(By.cssSelector(".login-button__user"));
            return profileUser.getText();
        }
        return "error";
    }

    public void endWork() {
        driver.quit();
    }
}
