package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parametros.DetalhesProdElements;
import support.DriverQA;

public class PageDetalheProduto extends BasePage {
    DetalhesProdElements detalhesProdElements = new DetalhesProdElements();

    public PageDetalheProduto(DriverQA stepDriver) {
        super(stepDriver);
    }
    public void clicarComprar(){
        driver.getDriver().findElement(By.linkText(detalhesProdElements.linkComprar)).click();
    }
}
