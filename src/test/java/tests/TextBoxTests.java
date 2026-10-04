package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.holdBrowserOpen = true; -
        //Используется чтобы оставить браузер открытым, но проблема что не завершает вебдрайвер.
        //Configuration.pageLoadStrategy = "eager";
        //В продакшене не стоит использовать. Используется если есть проблемы с загрузкой страницы.
        Configuration.timeout = 10000;
    }



    @Test
    void successfulFillFormTest() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Rars Test");
        $("[id=userEmail]").setValue("rars.test@nail.com");
        $("[id=currentAddress]").setValue("My current address");
        $("[id=permanentAddress]").setValue("My permanent address - registration");
        $("#submit").click();

        $("[id=output] [id=name]").shouldHave(text("Rars Test"));
        $("[id=output] [id=email]").shouldHave(text("rars.test@nail.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("My current address"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("My permanent address - registration"));

    }
}
