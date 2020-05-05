package com.ranorex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MainSelectors {
    WebDriver driver;
    public MainSelectors(WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By categoryField = By.id("Category");
    private By vipCountField = By.id("count");
    private By addButton = By.id("Add");
    private By deleteButton = By.id("Delete");
    private By loadButton = By.id("Load");
    private By saveButton = By.id("Save");
    private By clearButton = By.id("Clear");
    private By genderRadioButtonM = By.xpath("//*[@id='Gender' and @value='male']");
    private By genderRadioButtonF = By.xpath("//*[@id='Gender' and @value='female']");

    //Methods
    public MainSelectors typeFirstNameField(String firstName) {
        this.driver.findElement(this.firstNameField).clear();
        this.driver.findElement(this.firstNameField).sendKeys(firstName);
        return this;
    }
    public MainSelectors typeLastNameField(String lastName) {
        this.driver.findElement(this.lastNameField).clear();
        this.driver.findElement(this.lastNameField).sendKeys(lastName);
        return this;
    }
    public MainSelectors selectCategory(CategoryConstants category) {
        Select selectCategory = new Select(this.driver.findElement(categoryField));
        selectCategory.selectByVisibleText(category.toString());
        return this;
    }
    public String getVipCount() {
        return driver.findElement(vipCountField).getText().replaceAll("[^0-9]", "");
    }
    public MainSelectors selectGender(String gender) {
        if (gender.contains("Male")) {
            driver.findElement(genderRadioButtonM).click();
        } else {
            driver.findElement(genderRadioButtonF).click();
        }
        return new MainSelectors(driver);
    }
    public MainSelectors clickAddButton(){
        driver.findElement(addButton).click();
        return new MainSelectors(driver);
    }
    public MainSelectors clickDeleteButton(){
        driver.findElement(deleteButton).click();
        return new MainSelectors(driver);
    }
    public MainSelectors clickLoadButton(){
        driver.findElement(loadButton).click();
        return new MainSelectors(driver);
    }
    public MainSelectors clickSaveButton(){
        driver.findElement(saveButton).click();
        return new MainSelectors(driver);
    }
    public MainSelectors clickClearButton(){
        driver.findElement(clearButton).click();
        return new MainSelectors(driver);
    }
}