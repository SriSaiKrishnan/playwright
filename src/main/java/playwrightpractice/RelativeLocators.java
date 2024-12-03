package playwrightpractice;

import com.microsoft.playwright.*;

import java.util.List;

public class RelativeLocators {

    static Page page;
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page =browser.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");
        selectUser("Joe.Root");
        selectUser("Jasmine.Morgan");

        System.out.println(getUserRole("Joe.Root"));
        System.out.println(getUserRole("Jasmine.Morgan"));

        //Above
        String aboveUser = page.locator("a:above(:text('Joe.Root'))").first().textContent();
        System.out.println(aboveUser);

        //Below
        String belowUser = page.locator("a:below(:text('Joe.Root'))").first().textContent();
        System.out.println(belowUser);

        //near
        Locator nearElements = page.locator("td:near(:text('Joe.Root'), 400)");
        List<String> nearEleTexts = nearElements.allInnerTexts();
        for (String s : nearEleTexts){
            System.out.println("Near Example");
            System.out.println(s);
        }
    }

    public static void selectUser(String username){
        page.locator("input[type='checkbox']:left-of(:text('" + username + "'))").first().click();
    }

    public static  String getUserRole(String username){
        return page.locator("td:right-of(:text('" + username + "'))").first().textContent();
    }

}
