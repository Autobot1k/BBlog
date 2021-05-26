import org.openqa.selenium.By;

public class Locators {
    //MainPage
    public static final By SIGN_IN_LINK = By.xpath("//a[@href = '#/login']");

    //LoginPage
    public static final By BUTTON_SIGN_IN = By.xpath("//button[@type = 'submit']");
    public static final By ERROR_MESSAGE = By.xpath("//ul[@class = 'error-messages']");
    public static final By TEXT_FIELD_USERNAME = By.xpath("//input[@placeholder = 'Username']");
    public static final By TEXT_FIELD_PASSWORD = By.xpath("//input[@placeholder = 'Password']");

}
