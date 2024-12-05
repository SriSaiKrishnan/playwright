package playwrightpractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUpload {

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://demoqa.com/upload-download");

        page.setInputFiles("#uploadFile", Paths.get("pom.xml"));

        Thread.sleep(4000);

        page.setInputFiles("#uploadFile", new Path[0]);

        page.setInputFiles("#uploadFile", new FilePayload("sai.text", "text/plain", "this is sai".getBytes(StandardCharsets.UTF_8)));

    }

}
