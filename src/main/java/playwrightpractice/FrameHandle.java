package playwrightpractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
        Page page = browser.newPage();
        page.navigate("https://www.londonfreelance.org/courses/frames/index.html");

        //Frame
        String header = page.frameLocator("//frame[@name='main']").locator("h2").textContent();
        System.out.println(header);

        String h2 = page.frame("main").locator("h2").textContent();
        System.out.println(h2);

    }

}
