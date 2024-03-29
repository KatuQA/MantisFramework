package mantis.pages;

import org.openqa.selenium.WebDriver;

public class MantisSite {
    private final WebDriver driver;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private MainPage mainPage;
    private ReportIssuePage reportIssuePage; // добавили страничку
    private ViewIssueDetailsPage viewIssueDetailsPage; // добавили страничку
    private AreYouSurePage areYouSure;

    public MantisSite(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        passwordPage = new PasswordPage(driver);
        mainPage = new MainPage(driver);
        reportIssuePage = new ReportIssuePage(driver);  // добавили в конструктор
        viewIssueDetailsPage = new ViewIssueDetailsPage(driver); // добавили в конструктор
        areYouSure = new AreYouSurePage(driver);
    }

    public void login(String login, String password) {
        loginPage.login(login);
        passwordPage.login(password);

    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public PasswordPage getPasswordPage() {
        return passwordPage;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public ReportIssuePage getReportIssuePage(){            //добавили геттер
        return reportIssuePage;
    }

    public ViewIssueDetailsPage getViewIssueDetailsPage() {   //добавили геттер
        return viewIssueDetailsPage;
    }

    public AreYouSurePage getAreYouSure(){
        return areYouSure;
    }

}
