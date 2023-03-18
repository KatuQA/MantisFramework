package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AreYouSurePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy (xpath = "//input[@value='Delete Issues']")
    private WebElement deleteIssues;

    @FindBy (css = ".table tbody tr:nth-child(4) td:nth-child(2)")
    private WebElement actualIssueSummary;

    public AreYouSurePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public String getActualIssueSummary()
    {
        return actualIssueSummary.getText();
    }

    public void pressDeleteIssues()
    {
        deleteIssues.click();
    }
}
