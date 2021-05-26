import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "Login")
    public static Object[][] testLogin() {
        return new Object[][] {
                {Data.email1, Data.password1, true, ""},
                {Data.email1, Data.password2, false,Data.invalidPasswordEmailReq},
                {Data.email2, Data.password1, false, Data.invalidPasswordEmailReq},
                {Data.email2, Data.password1, false,Data.invalidPasswordEmailReq},
                {Data.email1, Data.blankEmail, false,Data.blankPasswordReq},
                {Data.blankEmail, Data.password1, false,Data.blankEmailReq},
        };
    }
}
