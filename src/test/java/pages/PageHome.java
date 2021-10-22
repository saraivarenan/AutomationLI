package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parametros.HomeElements;
import support.DriverQA;

public class PageHome extends BasePage {

    private String url = "https://qastoredesafio.lojaintegrada.com.br/";

   HomeElements homeElements = new HomeElements();

    public PageHome(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void acessarSistema(){
    driver.openURL(url);
}


    public  void clicarLogar(){
        driver.waitElement(homeElements.linkLogar,"css");
        driver.getDriver().findElement(By.cssSelector(homeElements.linkLogar)).click();

    }
    public void escolherProduto(String produto){

        switch (produto){
            case "80":
                driver.getDriver().findElement(By.cssSelector(homeElements.produto80)).click();
                break;
            case "1750":
                driver.getDriver().findElement(By.cssSelector(homeElements.produto1750)).click();
                break;
            case "89":
                driver.getDriver().findElement(By.cssSelector(homeElements.produto89)).click();
                break;
        }
    }





}
