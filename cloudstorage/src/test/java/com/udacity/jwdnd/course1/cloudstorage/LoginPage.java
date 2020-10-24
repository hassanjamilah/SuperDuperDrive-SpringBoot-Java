package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.sampled.Port;

public class LoginPage {
    @FindBy(id = "inputUsername")
    private WebElement userNameField;

    @FindBy(id = "inputPassword")
    private WebElement passwordField;

    @FindBy(id = "error_message")
    private WebElement errorMessage;

    WebDriver driver;
    int port ;

    public LoginPage(WebDriver drive , int port) {
        this.driver = drive;
        this.port = port;
        PageFactory.initElements(drive,this);
    }

    public void sendData(String userName , String password){
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
    }

    public void submitLogin(){
        passwordField.submit();
    }

    public void submitLoginAndVerify(){
        passwordField.submit();
       verifyHome();
    }

    public void verifyHome(){
        driver.get("http://localhost:" + this.port + "/home" );
        WebElement navBar = driver.findElement(By.id("nav-tab"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(navBar));

    }

    public void doLogout(){
        driver.get("http://localhost:" + this.port + "/home" );
        WebElement logoutButton = driver.findElement(By.id("logoutbutton"));
        logoutButton.submit();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }


}
