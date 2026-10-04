package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserVersion = "145.0";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.holdBrowserOpen = true; -
        //Используется чтобы оставить браузер открытым, но проблема что не завершается вебдрайвер.Для коррктной работы стоит использовать что-то вроде sleep(600_000)
        //Configuration.pageLoadStrategy = "eager";
        //В продакшене не стоит использовать. Используется если есть проблемы с загрузкой страницы.
        Configuration.timeout = 10000;
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }
}
