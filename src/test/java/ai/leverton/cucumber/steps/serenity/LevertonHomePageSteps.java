package ai.leverton.cucumber.steps.serenity;


import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

import ai.leverton.cucumber.pages.*;


public class LevertonHomePageSteps extends ScenarioSteps {

    //----------- PageObjects --------------

    LevertonHomePage levertonHP;

    //------------ Test Data ---------------
    String invalidUserName = "leveton", invalidPassword = "leverton";


    @Step
    public void open_leveton_home_page(){
        levertonHP.open();
    }

    @Step
    public void user_tries_to_login_with_invalid_credentials(){
        assertThat(levertonHP.enterUserName(invalidUserName)).isTrue();
        assertThat(levertonHP.enterPassword(invalidPassword)).isTrue();
        assertThat(levertonHP.clickLogIn()).isTrue();
    }

    @Step
    public void verify_invalid_login_error(){
        assertThat(levertonHP.isLoginErrorMessagePresent()).isTrue();
    }

    @Step
    public void verify_language_selection(String language){
        assertThat(levertonHP.selectLanguage(language)).isTrue();
    }

    @Step
    public void verify_page_language(String language){
        assertThat(levertonHP.isCorrectLanaguageSelected(language)).isTrue();
    }
}
