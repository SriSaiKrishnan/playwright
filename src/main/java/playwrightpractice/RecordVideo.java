package playwrightpractice;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class RecordVideo {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("myvideos/"))
                .setRecordVideoSize(640,480));
        Page page = context.newPage();
        page.navigate("https://academy.naveenautomationlabs.com/");
        page.click("a:text('Login')");
        page.close();
        context.close();
        page.close();
        playwright.close();
    }

}
