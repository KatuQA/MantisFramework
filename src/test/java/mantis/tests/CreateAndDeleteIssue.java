package mantis.tests ;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import  org.assertj.core.api.SoftAssertions;

public class CreateAndDeleteIssue extends BaseTest {
    private MantisSite mantisSite;

    String login = "admin";
    String password = "admin20";
    String summary = "Summary 18.03.23";
    String description = "test description";

    @Test
    public void chekDetailsCount() throws InterruptedException {

        SoftAssertions softAssert = new SoftAssertions();

        // логинимся

        mantisSite = new MantisSite(driver);
        mantisSite.login(login, password);

        // идем на страницу Report Issue

        mantisSite.getMainPage().goToReportIssuePage();
        Thread.sleep(1000);

        // Добавляем название и описание, кликаем на кнопку создать
        mantisSite.getReportIssuePage().addSummary(summary);
        mantisSite.getReportIssuePage().addDescription(description);
        mantisSite.getReportIssuePage().pressSubmitIssues();

        // проверяем, что видим страницу с подтверждением создания
        String currentUrlBugReport = driver.getCurrentUrl();

        softAssert.assertThat(currentUrlBugReport).isEqualTo("https://academ-it.ru/mantisbt/bug_report.php?posted=1");

        // ждем пока прогрузится главная страница и проверяем, что issue создалось
        Thread.sleep(3000);
        String currentSummaryIssue = mantisSite.getMainPage().getLastIssueSummary();
        System.out.println("Last Issue is ' " + currentSummaryIssue + " ' ");

        softAssert.assertThat(currentSummaryIssue).isEqualTo(summary);
        Thread.sleep(1000);

        // жмем на ID issue
        mantisSite.getMainPage().goToIssueDetails();

        // проверяем, что видим наше Summary
        String checkIssueSummary =  mantisSite.getViewIssueDetailsPage().getIssueSummary();
        checkIssueSummary.contains(summary);

        //Жмем на кноку удалить
        mantisSite.getViewIssueDetailsPage().pressDeleteButton();

        // снова проверяем, что видим наше Summary
        String isThisOurSummary = mantisSite.getAreYouSure().getActualIssueSummary();

        softAssert.assertThat(isThisOurSummary).isEqualTo(summary);

        Assertions.assertEquals(summary, isThisOurSummary);

        //Жмем на кноку удалить
        mantisSite.getAreYouSure().pressDeleteIssues();

        //смотрим, что нашего issue больше нет в таблице
        String actualSummaryIssue = mantisSite.getMainPage().getLastIssueSummary();
        System.out.println("Actual Summary = " + actualSummaryIssue);

        softAssert.assertThat(actualSummaryIssue).isNotEqualTo(summary);
        Thread.sleep(3000);

        softAssert.assertAll();
    }
}
