package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

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
