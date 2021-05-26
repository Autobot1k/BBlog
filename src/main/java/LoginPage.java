import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseActions{

    public LoginPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void clickSignInLink(){
        driver.findElement(Locators.SIGN_IN_LINK).click();
    }

    public void completeLoginPage(String email, String password){
        driver.findElement(Locators.TEXT_FIELD_USERNAME).sendKeys(email);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(password);
    }

    public void clickButtonSignIn(){
        performClick(Locators.BUTTON_SIGN_IN);
    }
}
