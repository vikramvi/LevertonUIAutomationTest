package ai.leverton.cucumber.steps.gherkin;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import net.thucydides.core.annotations.Steps;

import ai.leverton.cucumber.steps.serenity.*;


public class LevertonScenarioSteps {

    @Steps
    LevertonHomePageSteps levertonHomePageCucumberSteps;


    //--------------------------- GIVEN -----------------------------------

    @Given("User is on leverton home page")
    public void gotoHomePage(){
        levertonHomePageCucumberSteps.open_leveton_home_page();
    }


    //--------------------------- WHEN -----------------------------------

    @When("User enters invalid credentials")
    public void userEntersInvalidCredentialsAndTriesToLogIn(){
        levertonHomePageCucumberSteps.user_tries_to_login_with_invalid_credentials();
    }

    @When("User selects (.*) language")
    public void userSelectsParticularLanguageLink(String language){
        levertonHomePageCucumberSteps.verify_language_selection(language);
    }


    //--------------------------- THEN -----------------------------------

    @Then("User is shown error message")
    public void isErrorMessageShown(){
        levertonHomePageCucumberSteps.verify_invalid_login_error();
    }

    @Then("User sees page in (.*) language")
    public void verifyPageLanguage(String language){
        levertonHomePageCucumberSteps.verify_page_language(language);
    }

}
