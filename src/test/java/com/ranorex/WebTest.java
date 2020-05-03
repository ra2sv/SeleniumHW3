package com.ranorex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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
        String category = "Movie";


        Selectors.typeFirstNameField(firstName);
        Selectors.typeLastNameField(lastName);
        Selectors.selectCategory(category);
        if (gender.contains("Male")) {
            Selectors.selectGenderM();
        } else {
            Selectors.selectGenderF();
        }
        Selectors.clickAddButton();

        String getFirstName = driver.findElement(By.xpath(("(//*[@id=\"VIP\"])/following::td[text()=\"" +firstName+ "\"]"))).getText();
        String getLastName = driver.findElement(By.xpath(("((//*[@id=\"VIP\"])/following::td[text()=\"" +firstName+ "\"])/following::td[1]"))).getText();
        String getGender = driver.findElement(By.xpath(("((//*[@id=\"VIP\"])/following::td[text()=\"" +firstName+ "\"])/following::td[2]"))).getText();
        String getCategory = driver.findElement(By.xpath(("((//*[@id=\"VIP\"])/following::td[text()=\"" +firstName+ "\"])/following::td[3]"))).getText();

        Assert.assertEquals(getFirstName+getLastName+getGender+getCategory, firstName+lastName+gender+category);
        Assert.assertEquals(Selectors.getVipCount(), "1");

        System.out.println("Test finished: User was created");
    }
    @Test (description = "Add two users")
    public void t2AddNewUser_two() {
        String firstName = "Michael";
        String lastName = "Jackson";
        String gender = "Male";
        String category = "Music";

        Selectors.typeFirstNameField(firstName);
        Selectors.typeLastNameField(lastName);
        Selectors.selectCategory(category);
        if (gender.contains("Male")) {
            Selectors.selectGenderM();
        } else {
            Selectors.selectGenderF();
        }
        Selectors.clickAddButton();

        String getFirstName = driver.findElement(By.xpath(("(//*[@id=\"VIP\"])/following::td[text()=\"" +firstName+ "\"]"))).getText();
        String getLastName = driver.findElement(By.xpath(("((//*[@id=\"VIP\"])/following::td[text()=\"" +firstName+ "\"])/following::td[1]"))).getText();
        String getGender = driver.findElement(By.xpath(("((//*[@id=\"VIP\"])/following::td[text()=\"" +firstName+ "\"])/following::td[2]"))).getText();
        String getCategory = driver.findElement(By.xpath(("((//*[@id=\"VIP\"])/following::td[text()=\"" +firstName+ "\"])/following::td[3]"))).getText();

        Assert.assertEquals(getFirstName+getLastName+getGender+getCategory, firstName+lastName+gender+category);
        Assert.assertEquals(Selectors.getVipCount(), "2");

        firstName = "Britney";
        lastName = "Spears";
        gender = "Female";
        category = "Music";

        Selectors.typeFirstNameField(firstName);
        Selectors.typeLastNameField(lastName);
        Selectors.selectCategory(category);
        if (gender.contains("Male")) {
            Selectors.selectGenderM();
        } else {
            Selectors.selectGenderF();
        }
        Selectors.clickAddButton();

        getFirstName = driver.findElement(By.xpath(("(//*[@id=\"VIP\"])/following::td[text()=\"" +firstName+ "\"]"))).getText();
        getLastName = driver.findElement(By.xpath(("((//*[@id=\"VIP\"])/following::td[text()=\"" +firstName+ "\"])/following::td[1]"))).getText();
        getGender = driver.findElement(By.xpath(("((//*[@id=\"VIP\"])/following::td[text()=\"" +firstName+ "\"])/following::td[2]"))).getText();
        getCategory = driver.findElement(By.xpath(("((//*[@id=\"VIP\"])/following::td[text()=\"" +firstName+ "\"])/following::td[3]"))).getText();

        Assert.assertEquals(getFirstName+getLastName+getGender+getCategory, firstName+lastName+gender+category);
        Assert.assertEquals(Selectors.getVipCount(), "3");

        System.out.println("Test finished: Users were created");
    }
    @Test (description = "Remove the first user", dependsOnMethods = "t1AddNewUser_one")
    public void t3RemoveUser() {
        String firstName = "James";
        if ((driver.findElement(By.xpath("((//*[@id=\"VIP\"])[1])/following::td[1]")).getText().contains(firstName))){
            driver.findElement(By.xpath("(//*[@id=\"VIP\"])[1]")).click();
            Selectors.clickDeleteButton();
        }
        Assert.assertEquals(Selectors.getVipCount(), "2");
        System.out.println("Test finished: User was deleted");
    }
}
