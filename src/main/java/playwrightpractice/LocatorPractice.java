package playwrightpractice;

import com.microsoft.playwright.*;

import java.util.List;

public class LocatorPractice {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");

        Locator countryOption = page.locator("select#Form_getForm_Country option");
        System.out.println(countryOption.count());

        List<String> countryOptions = countryOption.allTextContents();

        countryOptions.forEach(ele -> System.out.println(countryOptions));

    }

}
