package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {

    @FindBy(tagName = "a")
    private WebElement resultMsgAnchor;

    private final JavascriptExecutor js;
    public ResultPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        js = (JavascriptExecutor) webDriver;
    }
    public void resultMsgAnchorClick() {
        js.executeScript("arguments[0].click();", resultMsgAnchor);
    }
}
