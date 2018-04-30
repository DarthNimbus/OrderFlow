import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.*;

import java.util.concurrent.TimeUnit;


        public class OrderFlowTest {

        private WebDriver getDefaultDriver(){

            System.setProperty("webdriver.gecko.driver", "C:/Program Files/WebDrivers/geckodriver.exe");
            WebDriver driver;
            driver = new FirefoxDriver();
            return driver;
        }

        private String webLink; // set link
        private String userName; // set name
        private String userPassword; // set password
        private String searchWord; // set keyword

        public void setLink(String link) {
            this.webLink = link;
        }
        public String getLink(){
            return webLink; //returns link
        }

        public void setName(String name) {
            this.userName = name;
        }
        public String getName(){
            return userName; //returns name
        }

        public void setPassword(String password) {
            this.userPassword = password;
        }
        public String getPassword(){
            return userPassword; //returns password
        }

        public void setKeyword(String keyword) {
            this.searchWord = keyword;
        }
        public String getKeyword(){
            return searchWord; //returns keyword
        }

        @Test
        public void checkTitle() {

            WebDriver driver;
            driver = getDefaultDriver();
            driver.navigate().to("http://gittigidiyor.com");
            assertTrue(driver.getTitle().contains("GittiGidiyor"));

            driver.close();
        }

        @Test
        public void login(){

            WebDriver driver;
            driver = getDefaultDriver();

            OrderFlowTest logincred = new OrderFlowTest();
            logincred.setLink("https://www.gittigidiyor.com/");
            logincred.setName("oxit92");
            logincred.setPassword("Faks7724!?");
            //logincred.setKeyword("cat food");

            driver.manage().window().maximize();

            driver.navigate().to(logincred.getLink());


            WebElement hlogin;
            new WebDriverWait(driver, 10).
                    until(
                            ExpectedConditions.
                                    elementToBeClickable(hlogin = driver.findElement(By.id("H-Login")) ) );
            hlogin.click();

            WebElement username;
            new WebDriverWait(driver, 10).
                    until(
                            ExpectedConditions.
                                    elementToBeClickable(username = driver.findElement(By.id("L-UserNameField")) ) );
            username.click();
            username.sendKeys(logincred.getName());

            WebElement password;
            new WebDriverWait(driver, 10).
                    until(
                            ExpectedConditions.
                                    elementToBeClickable(password = driver.findElement(By.id("L-PasswordField")) ) );
            password.click();
            password.sendKeys(logincred.getPassword());

            WebElement loginbtn;
            new WebDriverWait(driver, 10).
                    until(
                            ExpectedConditions.
                                    elementToBeClickable(loginbtn = driver.findElement(By.id("gg-login-enter")))
                    );
            loginbtn.click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            assertTrue(driver.findElement(By.id("member-nick-container")).getText().contains(logincred.getName()));

            driver.close();
        }

        @Test
        public void orderFlow(){

            WebDriver driver;
            driver = getDefaultDriver();

            OrderFlowTest order = new OrderFlowTest();
            order.setLink("https://www.gittigidiyor.com/");
            order.setName("oxit92");
            order.setPassword("Faks7724!?");
            order.setKeyword("cat food");

            driver.manage().window().maximize();
            
            driver.navigate().to(order.getLink());

            WebElement hlogin;
            new WebDriverWait(driver, 10).
                    until(
                            ExpectedConditions.
                                    elementToBeClickable(hlogin = driver.findElement(By.id("H-Login")) ) );
            hlogin.click();

            WebElement username;
            new WebDriverWait(driver, 10).
                    until(
                            ExpectedConditions.
                                    elementToBeClickable(username = driver.findElement(By.id("L-UserNameField")) ) );
            username.click();
            username.sendKeys(order.getName());

            WebElement password;
            new WebDriverWait(driver, 10).
                    until(
                            ExpectedConditions.
                                    elementToBeClickable(password = driver.findElement(By.id("L-PasswordField")) ) );
            password.click();
            password.sendKeys(order.getPassword());

            WebElement loginbtn;
            new WebDriverWait(driver, 10).
                    until(
                            ExpectedConditions.
                                    elementToBeClickable(loginbtn = driver.findElement(By.id("gg-login-enter")))
                    );
            loginbtn.click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement searchbar;
            new WebDriverWait(driver, 10).
                    until(
                            ExpectedConditions.
                                    elementToBeClickable(searchbar = driver.findElement(By.id("search_word")))
                    );
            searchbar.click();
            searchbar.clear();
            searchbar.sendKeys(order.getKeyword());

            WebElement findbtn;
            new WebDriverWait(driver, 10).
                    until(
                            ExpectedConditions.
                                    elementToBeClickable(findbtn = driver.findElement(By.id("header_find_button")))
                    );
            findbtn.click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement item;
            new WebDriverWait(driver, 10).
                    until(
                            ExpectedConditions.
                                    elementToBeClickable(item = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[2]/div[3]/div[3]/ul/li[1]/a/div/div/div[1]/div[1]/h4/span")))
                    );
            item.click();

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            WebElement addToCart;
            new WebDriverWait(driver, 10).
                    until(
                            ExpectedConditions.
                                    elementToBeClickable(addToCart = driver.findElement(By.id("add-to-basket")))
                    );
            addToCart.click();

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            assertTrue(driver.getTitle().contains("Sepetim"));

            driver.close();
        }

    }

