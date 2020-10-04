package com.udacity.jwdnd.course1.cloudstorage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    @FindBy(id = "nav-notes-tab")
    private WebElement noteTab;

    @FindBy(id = "addNewNote")
    private WebElement addNoteBtn;

    @FindBy(id = "userTable")
    private WebElement userTable;

    @FindBy(id = "noteModal")
    private WebElement noteModal;

    @FindBy(id = "note-title")
    private WebElement noteTitle;

    @FindBy(id = "note-description")
    private WebElement noteDescription;

    @FindBy(id = "editNote")
    private WebElement editNote;

    @FindBy(id = "deleteNote")
    private WebElement deleteNote;

    @FindBy(id = "closeNote")
    private WebElement closeNote;

    @FindBy(id = "nav-credentials-tab")
    private WebElement credTab;

    @FindBy(id = "addCredButton")
    private WebElement addCredButton;

    @FindBy(id = "credential-url")
    private WebElement credURL;

    @FindBy(id = "credential-username")
    private WebElement credUserName;

    @FindBy(id = "credential-password")
    private WebElement credPassword;

    @FindBy(id = "editCred")
    private WebElement editCred;


    @FindBy(id = "deleteCred")
    private WebElement deleteCred;

    private WebDriverWait wait;
    private JavascriptExecutor js;
    WebDriver driver ;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 5);
        js = (JavascriptExecutor) driver;
    }

    public void createNote(String title, String description) throws InterruptedException {
        noteTab.click();
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", noteTab);
        //addNewNoteButton.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(addNoteBtn)).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(noteTitle)).sendKeys(title);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(noteDescription)).sendKeys(description);
        noteTitle.submit();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(editNote)).click();
        Thread.sleep(1000);
        String title1 = getValueFromInput("note-title");
        Assertions.assertEquals(title1, title);


        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(noteTitle)).sendKeys("1");
        noteTitle.submit();
        Thread.sleep(1000);
        editNote = driver.findElement(By.id("editNote"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(editNote)).click();
        Thread.sleep(1000);
         title1 = getValueFromInput("note-title");
        Assertions.assertEquals(title1, title + "1");

    }

    public void createDeleteNote(String title, String description) throws InterruptedException {
        noteTab.click();
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", noteTab);
        //addNewNoteButton.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(addNoteBtn)).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(noteTitle)).sendKeys(title);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(noteDescription)).sendKeys(description);
        noteTitle.submit();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(deleteNote)).click();
        Thread.sleep(1000);
        Assertions.assertThrows(
                org.openqa.selenium.TimeoutException.class,
                ()->{
                    new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(deleteNote)).click();
                }
        );

        Thread.sleep(1000);

    }

    public String getValueFromInput(String inputId) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement input = driver.findElement(By.id(inputId));
        wait.until(ExpectedConditions.elementToBeClickable(input));
        js.executeScript("arguments[0].click();", input);
        return input.getAttribute("value");
    }


    public void selectCredTab(){
        js.executeScript("arguments[0].click()", credTab);
    }

    public void clickAddCredButton(){
        js.executeScript("arguments[0].click()", addCredButton);
    }

    public void sendCredDataAndSubmit(String url, String userName, String password){
        credURL.sendKeys(url);
        credUserName.sendKeys(userName);
        credPassword.sendKeys(password);
        credPassword.submit();
    }

    public void clickEditCredButton(){
        wait.until(ExpectedConditions.elementToBeClickable(editCred)).click();
        js.executeScript("arguments[0].click()" , editCred);
    }

    public void editCred(){
        wait.until(ExpectedConditions.visibilityOf(credURL)).sendKeys("1");
    }

    public String getURL(){
         wait.until(ExpectedConditions.visibilityOf(credURL)).getText();
        return credURL.getAttribute("value");
    }

    public void clickDeleteCred(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteCred));
        js.executeScript("arguments[0].click()" , deleteCred);
    }

    public void checkIfEditCredButtonExist(){
        wait.until(ExpectedConditions.visibilityOf(editCred));
    }




}
