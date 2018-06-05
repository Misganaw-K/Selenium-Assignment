
package newspageautomation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewsPageAutomation {
    private WebDriver driver;
    private String repNewsUrl;
    private String mineUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","/usr/local/share/chromedriver");
        driver = new ChromeDriver();
        repNewsUrl = "https://www.ethiopianreporter.com/zena";
        mineUrl = "http://localhost/form.php";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get(repNewsUrl);
        WebElement newsContener = driver.findElement(
                By.xpath("//div[@class='categories-view-content view-content-wrap layout-list']"));

        List<WebElement> divNewsContener = driver.findElements(
                By.xpath("//html//div[@class='categories-view-content view-content-wrap layout-list']/div"));

        String[][] stringNews = new String[divNewsContener.size()][2];
        int i = 0;

        for(WebElement news: divNewsContener){
            String title = news.findElement(By.xpath("//article/div/div[@class='post-content']/h3/a/span")).getText();
            String content = news.findElement(
                    By.xpath("//article/div/div[@class='post-content']/div[@class='post-body']/div")).getText();
            //use two dimentional array for form manipulation
            stringNews[i][0] = title;
            stringNews[i][1] = content;
            i++;
        }

        driver.get(mineUrl);
        for(i = 0; i < divNewsContener.size(); i++){
            driver.findElement(By.xpath("//input[@type='text']")).sendKeys(stringNews[i][0]);
            driver.findElement(By.xpath("//textarea[@name='content']")).sendKeys(stringNews[i][1]);
            driver.findElement(By.xpath("//input[@type='submit']")).click();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
