package ai.leverton.cucumber.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://viewer-dev.lvn.com/")
public class LevertonHomePage extends PageObject {

    @FindBy(xpath="//input[@id='username']")
    WebElement UserNameInputField;

    @FindBy(xpath="//input[@id='password-field']")
    WebElement PasswordInputField;

    @FindBy(xpath="//input[@value='Log In']")
    WebElement LogInButton;

    @FindBy(xpath="//a[@key='de']")
    WebElement DeutschLanguageLink;

    @FindBy(xpath="//a[@key='en']")
    WebElement EnglishLanguageLink;

    @FindBy(xpath="//a[@key='es']")
    WebElement SpanishLanguageLink;


    public boolean enterUserName(String userName){
        try{
            UserNameInputField.sendKeys(userName);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean enterPassword(String password){
        try{
            PasswordInputField.sendKeys(password);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickLogIn(){
        try{
            LogInButton.click();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean isLoginErrorMessagePresent(){
        if(getDriver().getPageSource().contains("Sorry, we were not able to find a user with that username and password.")){
            return true;
        }else{
            return false;
        }
    }

    public boolean selectLanguage(String language){
        try {
            switch (language) {
                case "Deutsch":
                    DeutschLanguageLink.click();
                    return true;
                case "English":
                    EnglishLanguageLink.click();
                    return true;
                case "Spanish":
                    SpanishLanguageLink.click();
                    return true;
                default:
                    System.out.println("WRONG LANGUAGE");
                    return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean isCorrectLanaguageSelected(String language){

        switch (language) {
            case "Deutsch":
                if(DeutschLanguageLink.getAttribute("class").contains("lang_link lang_link_selected") &&
                        getDriver().getPageSource().contains("Benutzername")){
                    return true;
                }else{
                    return false;
                }
            case "English":
                if(EnglishLanguageLink.getAttribute("class").contains("lang_link lang_link_selected") &&
                        getDriver().getPageSource().contains("Username") ){
                    return true;
                }else{
                    return false;
                }
            case "Spanish":
                if(SpanishLanguageLink.getAttribute("class").contains("lang_link lang_link_selected") &&
                        getDriver().getPageSource().contains("Nombre de usuario")){
                    return true;
                }else{
                    return false;
                }
            default:
                System.out.println("WRONG LANGUAGE");
                return false;
        }
    }

}
