package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestSuit {
    protected static WebDriver driver;

//    public static void main(String[] args) {

        @BeforeMethod
        public void openBrowser() {
            System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

        @AfterMethod
        public void closeBrowser(){
            driver.quit();
        }

        @Test
        public void userShouldBeBaleToRegisterSuccessfully(){
            // click on register button
            Clickonelements(By.className("ico-register"));

            // select gender
            driver.findElement(By.xpath("//label[@for='gender-male']")).click();

            // enter firstname
            driver.findElement(By.xpath("//input[@data-val-required=\"First name is required.\"]")).sendKeys("Kk");

            //enter lastname
            //Gettextfrom(By.id("LastName"), "abhdfjg");
             driver.findElement(By.id("LastName")).sendKeys("Panchani");

            // select birthday
            Select birthday = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]")));
            birthday.selectByValue("10");

            //select month
            Select birthmonth = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]")));
            birthmonth.selectByValue("11");

            // select year
            Select birthyear = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]")));
            birthyear.selectByVisibleText("2000");

            // enter Email address
            driver.findElement(By.id("Email")).sendKeys(" abndgshkg"+randomDate()+"@gmail.com");

            // enter password
             driver.findElement(By.id("Password")).sendKeys("Sunday");

            // Confirm password
              driver.findElement(By.id("ConfirmPassword")).sendKeys("Sunday");

            // click register button
            Clickonelements(By.id("register-button"));

            String expectedMessage="Your registration completed";
            String actualMessage=driver.findElement(By.className("result")).getText();
            Assert.assertEquals(actualMessage,expectedMessage, "Registration is not successful");
    }

@Test
    public void userShouldSendAnEmailToFriend(){

        //Click on register button
        Clickonelements(By.xpath("//a[@class='ico-register']"));

        //select gender
        driver.findElement(By.xpath("//input[//label[@for='gender']")).sendKeys("Male");

        //first name
        driver.findElement(By.xpath("//input[@data-val-required=\"First name is required.\"]")).sendKeys("Kk");

        //last name
        driver.findElement(By.xpath("//input[@data-val-required=\"Last name is required.\"]")).sendKeys("Panchani");

        // select birthday
        Select birthday = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]")));
        birthday.selectByValue("29");

        //select month
        Select birthmonth = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]")));
        birthmonth.selectByValue("3");


        // select year
        Select birthyear = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]")));
        birthyear.selectByVisibleText("1989");

        //Enter email address
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("krunalpanchani5@gmail.com");

        //password
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Kk1234");

        //confirm password
        driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("Kk1234");

        //register button
        driver.findElement(By.xpath("//div/button[@type='submit']")).click();

        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.className("result")).getText();
        Assert.assertEquals(expectedMessage,actualMessage,"registration is successful");

            //click on computer
        Clickonelements(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //click on desktop
        Clickonelements(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));

        //click on Build your own computer
        Clickonelements(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']"));

            //click on email a friend
        Clickonelements(By.xpath("//button[normalize-space()='Email a friend']"));

        //enter friend's email address
        driver.findElement(By.xpath("//input[@id='FriendEmail']")).sendKeys("kk@gmail.com");

        //click on send email button
        driver.findElement(By.xpath("//button[@name='send-email']")).click();

        //click the Result
       driver.findElement(By.xpath("//li[contains(text(),'Only registered customers can use email a friend f')]"));
       String expected ="Your message has been sent.";
       String actualMessage =driver.findElement(By.xpath("//li[contains(text(),'Only registered customers can use email a friend f')]")).getText();
       Assert.assertEquals(expected,actualMessage,"Message has not been sent successfully");
    }

    @Test
    public void userShouldBeAbleToSelectCurencyInEuro(){
            //click on currency bar
        Clickonelements(By.id("customerCurrency"));

        //select currency
        Select currency=new Select(driver.findElement(By.id("customerCurrency")));
        currency.selectByVisibleText("Euro");

        //scroll down on homepage,build your own computer to check the price
        Clickonelements(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']"));

        //user should be able to see "€" in front of the price
        Clickonelements(By.xpath("//span[contains(text(),'€1032.00')]"));

        //Expected and Actual check
        String expectedCurrency="€1032.00";
        String actualCurrency=driver.findElement(By.xpath("//span[contains(text(),'€1032.00')]")).getText();
        Assert.assertEquals(actualCurrency,expectedCurrency,"€ sign not in front of the price");
    }

    @Test
    public void userShouldBeAbleToAddProductInTheShoppingBasketSuccessfully(){

            //click on computers
        Clickonelements(By.xpath("//li[@class='active']//a[normalize-space()='Computers']"));

        //click on desktops
        Clickonelements(By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']"));

        //click on build your own computer
        Clickonelements(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']"));

        //click on processer and select 2.2Ghz
        driver.findElement(By.xpath("//select[@id='product_attribute_1']"));
        Select processor = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_1']")));
        processor.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

        //click on Ram and select 2gb
        driver.findElement(By.xpath("//label[normalize-space()='RAM']"));
        Select ram = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_2']")));
        ram.selectByVisibleText("2 GB");

        //select 320gb
        Clickonelements(By.xpath("//label[@for='product_attribute_3_6']"));

        //select vistahome from os
        Clickonelements(By.xpath("//label[@for='product_attribute_4_8']"));

        //select software microsoftoffice
        Clickonelements(By.xpath("//label[@for='product_attribute_5_10']"));

        //select Total commander
        Clickonelements(By.xpath("//label[@for='product_attribute_5_12']"));

        //click on add to cart button
        Clickonelements(By.xpath("//button[@id='add-to-cart-button-1']"));

        //select software Acrobat reader
        Clickonelements(By.xpath("//label[@for='product_attribute_5_11']"));

        //select Total commander
        Clickonelements(By.xpath("//label[@for='product_attribute_5_12']"));

        //click on add to cart button
        Clickonelements(By.xpath("//button[@id='add-to-cart-button-1']"));

        //to verify the product is in the basket
        driver.findElement(By.xpath("//span[@class=\"cart-label\"]")).click();

        String expectedMessage= "The product has been added to your shopping cart";
        String actualMessage= driver.findElement(By.xpath("")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"Product has not been added to your cart");
    }

    public static void Clickonelements(By by) {
        driver.findElement(by).click();}

    public static void TextType(By by, String text) {

        driver.findElement(by).sendKeys(text);}


public static void driverWaituntilURL(int time, String url){
            WebDriverWait wait01 = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait01.until(ExpectedConditions.urlToBe(url));
}
public static void waitForClicabl(By by, int time){
            WebDriverWait wait01 = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait01.until(ExpectedConditions.elementToBeClickable(by));
}
public static void clickOnElements(By by){
        driver.findElement(by).click();
}
public static String getTextFromElement(By by){
        return
                driver.findElement(by).getText();
}
public static void sendKeys(By by){

}
public static String randomDate(){
        Date date = new Date();
        SimpleDateFormat formatter= new SimpleDateFormat("ddMMyyyyHHmmss");
        return formatter.format(date);

}
public static void driverWaitsUntillURLTobe(int time, String url){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds( 10));
}
public static void waitForClickable(int time,WebElement text){
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
            wait.until(ExpectedConditions.elementToBeClickable(text));

        }
}
