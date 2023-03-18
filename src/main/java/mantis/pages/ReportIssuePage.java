package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ReportIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#summary")
    private WebElement summaryField;

    @FindBy(css = "#description")
    private WebElement descriptionField;

    @FindBy(xpath = "//input[@value='Submit Issue']")
    private WebElement submitIssue;

    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public void addSummary(String summary) {
        summaryField.sendKeys(summary);
    }
    public void addDescription(String description){
            descriptionField.sendKeys(description);
        }

    public void pressSubmitIssues(){
        submitIssue.click();
    }
    }
