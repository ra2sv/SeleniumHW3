package com.ranorex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MainSelectors {
    WebDriver driver;
    public MainSelectors(WebDriver driver) {
        this.driver = driver;
    }

    private By FirstNameField = By.id("FirstName");
    private By LastNameField = By.id("LastName");
    private By CategoryField = By.id("Category");
    private By vipCountField = By.id("count");
    private By AddButton = By.id("Add");
    private By DeleteButton = By.id("Delete");
    private By LoadButton = By.id("Load");
    private By SaveButton = By.id("Save");
    private By ClearButton = By.id("Clear");
    private By GenderRadioButtonM = By.xpath("//*[@id=\"Gender\" and @value=\"male\"]");
    private By GenderRadioButtonF = By.xpath("//*[@id=\"Gender\" and @value=\"female\"]");

    //Methods
    public MainSelectors typeFirstNameField(String firstName) {
        this.driver.findElement(FirstNameField).clear();
        this.driver.findElement(FirstNameField).sendKeys(firstName);
        return this;
    }
    public MainSelectors typeLastNameField(String lastName) {
        this.driver.findElement(LastNameField).clear();
        this.driver.findElement(LastNameField).sendKeys(lastName);
        return this;
    }
    public MainSelectors selectCategory(String category) {
        Select selectCategory = new Select(this.driver.findElement(CategoryField));
        selectCategory.selectByVisibleText(category);
        return this;
    }
    public MainSelectors selectGenderM() {
        driver.findElement(GenderRadioButtonM).click();
        return new MainSelectors(driver);
    }
    public String getVipCount() {
        return driver.findElement(vipCountField).getText().replaceAll("[^0-9]", "");
    }
    public MainSelectors selectGenderF() {
        driver.findElement(GenderRadioButtonF).click();
        return new MainSelectors(driver);
    }
    public MainSelectors clickAddButton(){
        driver.findElement(AddButton).click();
        return new MainSelectors(driver);
    }
    public MainSelectors clickDeleteButton(){
        driver.findElement(DeleteButton).click();
        return new MainSelectors(driver);
    }
    public MainSelectors clickLoadButton(){
        driver.findElement(LoadButton).click();
        return new MainSelectors(driver);
    }
    public MainSelectors clickSaveButton(){
        driver.findElement(SaveButton).click();
        return new MainSelectors(driver);
    }
    public MainSelectors clickClearButton(){
        driver.findElement(ClearButton).click();
        return new MainSelectors(driver);
    }
}