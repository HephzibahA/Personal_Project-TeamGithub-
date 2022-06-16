package JumiaWebTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class JumiaWebSignUpTest {

    //Importing the selenium Webdriver
    private WebDriver driver;

    @BeforeTest
    public void setup () throws InterruptedException {
        //locate chromedriver
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        // initiate chrome browser to open chromedriver
        driver = new ChromeDriver();

        //input jumia url to open the web app
        driver.get("https://www.jumia.com.ng/");
        Thread.sleep(4000);

        //maximize the window page
        driver.manage().window().maximize();


        //get page title
        String expectedPageTitle = "Jumia";
        String actualPageTitle = driver.getTitle();
        if (actualPageTitle.contains(expectedPageTitle))
            //pass
            System.out.println("Correct PageTitle");
        else
            //fail
            System.out.println("Wrong PageTitle");
        Thread.sleep(4000);

    }
        @Test (priority = 0)
        public void signup () throws InterruptedException {
            //verify user can create an account with valid details
            //click on the 'Account' button
            driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();

            //click on sign-in
            driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();

            //click on "create an account via email button"
            driver.findElement(By.xpath("//*[@id=\"jm\"]/main/div/div[2]/div/a[1]/span")).click();
            Thread.sleep(4000);

            //on the sign-up page
            //input First name in the firstname field
            driver.findElement(By.id("fi-firstName")).sendKeys("firstName Text");

            //input last name in the last name field
            driver.findElement(By.id("fi-lastName")).sendKeys("lastName Text");

            //input email in the email field
            driver.findElement(By.id("fi-email")).sendKeys("email txt");

            //input password in the password field
            driver.findElement(By.id("fi-password")).sendKeys("password text");

            //tick the terms and condition box
            driver.findElement(By.xpath("//*[@id=\"authForm\"]/div[4]/div/label")).click();

            //click on the 'create account button'
            driver.findElement(By.xpath("//*[@id=\"authForm\"]/div[7]/button")).click();
            Thread.sleep(10000);
        }

   @Test (priority = 1)
   public void logOutSuccessfully () throws InterruptedException {
       //verify user can logout from the weburl successfully
       //click on "hi 'username'"
       driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
       //click on logout
       driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form/button")).click();
       Thread.sleep(4000);
   }


   @AfterTest
       public void quitBrowser () {
       //quit browser
       driver.quit();
   }






}

