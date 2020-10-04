package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "inputUsername")
    private WebElement userNameField;

    @FindBy(id = "inputPassword")
    private WebElement passwordField;

    @FindBy(id = "error_message")
    private WebElement errorMessage;

    public LoginPage(WebDriver drive) {
        PageFactory.initElements(drive,this);
    }

    public void sendData(String userName , String password){
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
    }

    public void submitLogin(){
        passwordField.submit();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}
