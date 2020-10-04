package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home1 {

    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css="#logout-submit-button")
    private WebElement logoutSubmitButton;
    @FindBy(css="#nav-notes-tab")
    private WebElement notesTabButton;
    @FindBy(css="#addNoteButton")
    private WebElement addNoteButton;
    @FindBy(xpath="//input[@id='note-title']")
    private WebElement noteTitleInput;
    @FindBy(xpath="//textarea[@id='note-description']")
    private WebElement noteDescriptionInput;
    @FindBy(css="#saveChangesButton")
    private WebElement saveChangesButton;
    @FindBy(id="noteEditButton")
    private WebElement noteEditButton;
    @FindBy(id="noteModalLabel")
    private WebElement noteModalLabel;
    private final JavascriptExecutor js;
    public Home1(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.js = (JavascriptExecutor) webDriver;
        this.wait = new WebDriverWait(webDriver, 5);
        this.driver = webDriver;
    }
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutSubmitButton));
        js.executeScript("arguments[0].click();", logoutSubmitButton);
    }
    // NOTES TAB
    public void clickNotesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(notesTabButton));
        js.executeScript("arguments[0].click();", notesTabButton);
    }
    public void createNote(String noteTitle, String noteDescription) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(addNoteButton)).click();
        js.executeScript("arguments[0].click();", addNoteButton);
        js.executeScript("arguments[0].value='"+ noteTitle +"';", this.noteTitleInput);
        js.executeScript("arguments[0].value='"+ noteDescription +"';", this.noteDescriptionInput);
        js.executeScript("arguments[0].click();", saveChangesButton);
    }
    private String getValueFromInput(String inputId) {
        WebElement input = driver.findElement(By.id(inputId));
        wait.until(ExpectedConditions.elementToBeClickable(input));
        js.executeScript("arguments[0].click();", input);
        return input.getAttribute("value");
    }
    public NoteModel getFirstNote() {
        // Retrieve data and insert it in firstNote object
        String firstNoteTitle = getValueFromInput("note-title");
        String firstNoteDescription = getValueFromInput("note-description");
        //System.out.print("Title: " + noteTitleInput.getText() + " and Description: " + noteDescriptionInput.getText());
        NoteModel firstNote = new NoteModel(null, firstNoteTitle, firstNoteDescription,null);
        return firstNote;
    }
    public void waitNoteModelPage(){
        wait.until(ExpectedConditions.elementToBeClickable(noteModalLabel));
    }
    public void clickEditButton(){
        wait.until(ExpectedConditions.elementToBeClickable(noteEditButton));
        // Open Edit View
        js.executeScript("arguments[0].click();", noteEditButton);
    }
    public void updateNote(NoteModel note) {
        NoteModel newNote = note;
        // Open Edit View
        js.executeScript("arguments[0].click();", noteEditButton);
        // Clear current data
        noteTitleInput.clear();
        noteDescriptionInput.clear();
        // Insert new data
        js.executeScript("arguments[0].value='"+ note.getNoteTitle() +"';", this.noteTitleInput);
        js.executeScript("arguments[0].value='"+ note.getNoteDescription() +"';", this.noteDescriptionInput);
        js.executeScript("arguments[0].click();", saveChangesButton);
    }

}
