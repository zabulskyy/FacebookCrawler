import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {

        String pwd = Data.pass;

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\vzabulskyy\\Documents\\Crawler\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.facebook.com");

        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("pass"));

        email.sendKeys("v.zabulskyy@gmail.com");
        pass.sendKeys(pwd);

        // Now submit the form. WebDriver will find the form for us from the element
        email.submit();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                return wd.getTitle().toLowerCase().startsWith("facebook");
            }
        });
        try {
            driver.findElement(By.className("layerCancel _4jy0 _4jy3 _517h _51sy _42ft")).click();

        }
        catch (org.openqa.selenium.NoSuchElementException e){

        }

        driver.findElement(By.cssSelector("a[title='Friends']")).click();


//        driver.quit();
    }
}
