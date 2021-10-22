package pages;

import org.openqa.selenium.By;
import parametros.LoginElements;
import support.DriverQA;

public class PageLogin extends BasePage {

LoginElements loginElements = new LoginElements();
    public PageLogin(DriverQA stepDriver) {
        super(stepDriver);
    }
    public void inserirUsuario(){
        driver.waitElement(loginElements.emailText);
        driver.getDriver().findElement(By.id(loginElements.emailText)).sendKeys("fls0094@gmail.com");
        driver.getDriver().findElement(By.id(loginElements.senhaText)).sendKeys("12345");
        driver.getDriver().findElement(By.cssSelector(loginElements.btnEntrar)).click();
        driver.getDriver().findElement(By.linkText(loginElements.home)).click();
    }
}
