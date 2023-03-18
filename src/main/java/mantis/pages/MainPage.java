package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "span.user-info")
    private WebElement userName;

    @FindBy(css = "a[href='/mantisbt/view_all_bug_page.php']")
    private WebElement viewIssuesPageButton;

    @FindBy (css = "a[href='/mantisbt/bug_report_page.php']")      // report Issue
    private WebElement reportIssuePageButton;

    @FindBy (css = "#buglist tbody tr:first-child td:last-child")  // название последнего созданного Issue на Main Page
    private WebElement lastIssueSummary;

    @FindBy (css = "#buglist tbody tr:first-child td:nth-child(4) a")
    private WebElement issueIdClick;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void goToViewIssuesPage() {
        viewIssuesPageButton.click();
    }

    public void goToReportIssuePage() {                 // click on Report Issue
        reportIssuePageButton.click();
    }

    public String getLastIssueSummary() {
        return lastIssueSummary.getText();
    }

    public void goToIssueDetails() {
        issueIdClick.click();
    }
}
