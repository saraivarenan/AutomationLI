package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import parametros.PedidoElements;
import support.DriverQA;

public class PagePedido extends BasePage {
    PedidoElements pedidoElements = new PedidoElements();
    public PagePedido(DriverQA stepDriver) {
        super(stepDriver);
    }
    public void validarPedido(){
        driver.getDriver().findElement(By.cssSelector(pedidoElements.numeroPedido));
        Assert.assertNotNull(driver.getDriver().findElement(By.cssSelector(pedidoElements.numeroPedido)).getText());
    }
}
