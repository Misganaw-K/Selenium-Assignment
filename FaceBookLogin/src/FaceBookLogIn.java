import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class FaceBookLogIn {


        public static String baseURL = "https://www.facebook.com/";
        static List<WebElement> notification = new ArrayList<>();


    public static void main(String [] args){

        LogIn();

    }


        public  static void LogIn(){

            System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Micky\\IdeaProjects\\RetrevingNews\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();


            driver.navigate().to(baseURL);
            //getting the userName Form
            driver.findElement(By.cssSelector("#email")).sendKeys("username");

            //getting the password textField
            driver.findElement(By.cssSelector("#pass")).sendKeys("password");

            //Getting the Button
            driver.findElement(By.cssSelector("#u_0_2")).click();

            //here we wanna know the Notification
            notification = driver.findElements(By.xpath("//*[@id=\"fbNotificationsJewel\"]"));
            for (int i = 0; i<notification.size(); i ++){

                System.out.print("You have " + notification.get(i).getText());
            }

            driver.close();
            driver.quit();

        }




}
