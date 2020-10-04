package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {


    @FindBy(id = "inputPassword")
    private WebElement passwordField;

    @FindBy(id = "inputFirstName")
    private WebElement firstNameField;

    @FindBy(id = "inputLastName")
    private WebElement lastNameField;

    @FindBy(id = "inputUsername")
    private WebElement userNameField;

    @FindBy(id = "success_div")
    private WebElement successHeader;

    @FindBy(id = "fail_span")
    private WebElement failHead;

    @FindBy(id = "gotoLogin")
    private WebElement gotoLogin;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void sendData(){
        firstNameField.sendKeys("hassan");
        lastNameField.sendKeys("jamila");
        userNameField.sendKeys("hassan1");
        passwordField.sendKeys("123456");
    }

    public void sendData(String userName, String password, String firstName , String lastName){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
    }

    public void submit(){
        passwordField.submit();
    }

    public String getSuccessMessage(){
        return successHeader.getText();
    }

    public String getFailMessage(){
        return failHead.getText();
    }

    public void gotoLogin(){
        gotoLogin.click();
    }

}
