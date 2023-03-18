package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewIssueDetailsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy (css = ".table tbody tr:nth-child(10) td")
    private WebElement issueSummary;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteButton;

    public ViewIssueDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public String getIssueSummary(){
        return issueSummary.getText();
    }

    public void pressDeleteButton(){
        deleteButton.click();
    }
}
