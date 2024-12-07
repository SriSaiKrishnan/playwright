package playwrightpractice;

import com.microsoft.playwright.*;

public class CommaSeparatorSelectors {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://academy.naveenautomationlabs.com/");
        //CSS Selector with comma seperated
        Locator css = page.locator("a:has-text('Login') " +
                ", a:has-text('Demo Site') " +
                ", a:has-text('Webinars')");
        System.out.println(css.count());
        //Xpath Union
        Locator xpath = page.locator("//a[text()='Login'] | //a[text()='SignIn']");
        System.out.println(xpath.textContent());
        xpath.click();

    }

}
