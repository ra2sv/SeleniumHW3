package com.ranorex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class WebTest {
    private WebDriver driver;
    protected MainSelectors Selectors;


    @BeforeClass
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        driver.get("https://www.ranorex.com/web-testing-examples/vip/");
        Selectors = PageFactory.initElements(driver, MainSelectors.class);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test (description = "Add first: One user")
    public void t1AddNewUser_one() {
        String firstName = "James";
        String lastName = "Bond";
        String gender = "Male";
        CategoryConstants category = CategoryConstants.Movie;

        Selectors.typeFirstNameField(firstName);
        Selectors.typeLastNameField(lastName);
        Selectors.selectCategory(category);
        Selectors.selectGender(gender);
        Selectors.clickAddButton();

        WebElement element = driver.findElement(By.xpath(("(//*[@id='VIP'])/following::td[text()='" +firstName+ "']")));
        String getLastName = element.findElement(By.xpath("./following::td[1]")).getText();
        String getGender = element.findElement(By.xpath("./following::td[2]")).getText();
        String getCategory = element.findElement(By.xpath("./following::td[3]")).getText();

        assertEquals(getLastName+getGender+getCategory, lastName+gender+category);
        assertEquals(Selectors.getVipCount(), "1");

        System.out.println("Test finished: User was created");
    }
    @Test (description = "Add two users")
    public void t2AddNewUser_two() {
        String firstName = "Michael";
        String lastName = "Jackson";
        String gender = "Male";
        CategoryConstants category = CategoryConstants.Music;

        Selectors.typeFirstNameField(firstName);
        Selectors.typeLastNameField(lastName);
        Selectors.selectCategory(category);
        Selectors.selectGender(gender);
        Selectors.clickAddButton();

        WebElement element = driver.findElement(By.xpath(("(//*[@id='VIP'])/following::td[text()='" +firstName+ "']")));
        String getLastName = element.findElement(By.xpath("./following::td[1]")).getText();
        String getGender = element.findElement(By.xpath("./following::td[2]")).getText();
        String getCategory = element.findElement(By.xpath("./following::td[3]")).getText();

        assertEquals(getLastName+getGender+getCategory, lastName+gender+category);
        assertEquals(Selectors.getVipCount(), "2");

        firstName = "Britney";
        lastName = "Spears";
        gender = "Female";
        category = CategoryConstants.Other;

        Selectors.typeFirstNameField(firstName);
        Selectors.typeLastNameField(lastName);
        Selectors.selectCategory(category);
        Selectors.selectGender(gender);
        Selectors.clickAddButton();

        element = driver.findElement(By.xpath(("(//*[@id='VIP'])/following::td[text()='" +firstName+ "']")));
        getLastName = element.findElement(By.xpath("./following::td[1]")).getText();
        getGender = element.findElement(By.xpath("./following::td[2]")).getText();
        getCategory = element.findElement(By.xpath("./following::td[3]")).getText();

        assertEquals(getLastName+getGender+getCategory, lastName+gender+category);
        assertEquals(Selectors.getVipCount(), "3");

        System.out.println("Test finished: Users were created");
    }
    @Test (description = "Remove the first user", dependsOnMethods = "t1AddNewUser_one")
    public void t3RemoveUser() {
        String firstName = "James";
        if ((driver.findElement(By.xpath("((//*[@id='VIP'])[1])/following::td[1]")).getText().contains(firstName))){
            driver.findElement(By.xpath("(//*[@id='VIP'])[1]")).click();
            Selectors.clickDeleteButton();
        }
        assertEquals(Selectors.getVipCount(), "2");
        System.out.println("Test finished: User was deleted");
    }
}
