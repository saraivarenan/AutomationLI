package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parametros.FinalizarCompraElements;
import support.DriverQA;
import support.SuportWeb;

import static java.lang.Integer.parseInt;

public class PageFinalizarComprar extends BasePage {
    SuportWeb suportWeb = new SuportWeb();
    FinalizarCompraElements finalizarCompraElements = new FinalizarCompraElements();

    public PageFinalizarComprar(DriverQA stepDriver) {
        super(stepDriver);
    }

    public void escolherPagamento(String opPagamento, boolean descontoFormPag) {
        String valorSubComprar = driver.getDriver().findElement(By.cssSelector(finalizarCompraElements.valorSubtotal)).getText();
        String valorTotal = driver.getDriver().findElement(By.cssSelector(finalizarCompraElements.valorTotalComprar)).getText();
        double valortotalSemDesconto = Double.parseDouble(valorSubComprar.substring(3,5));

        switch (opPagamento) {
            case "boleto":
                driver.getDriver().findElement(By.cssSelector(finalizarCompraElements.opcaoBoleto)).click();
                if(descontoFormPag ==true){

                    String valordesconto = driver.getDriver().findElement(By.cssSelector(finalizarCompraElements.infoDesconto)).getText();
                    int valorparaDesconto = parseInt(valordesconto.substring(0,2));
                    int valorTotalCompraNumero = parseInt(valorTotal.substring(3,6));
                    int valordoDesconto = (int) ((valortotalSemDesconto * valorparaDesconto)/100);
                    System.out.println("valor do desconto"+valordoDesconto);
                    int valorComparar = valorTotalCompraNumero - valordoDesconto;
                    suportWeb.tempo(3);
                    String valorAposDesconto = driver.getDriver().findElement(By.cssSelector(finalizarCompraElements.valorAposDesconto)).getText();
                     int valorjaComDesconto = parseInt(valorAposDesconto.substring(3,5));
                   // System.out.println(valorjaComDesconto);
                    Assert.assertEquals(93,valorjaComDesconto );

                }


                break;
            case "cartao":
                driver.getDriver().findElement(By.id(finalizarCompraElements.opcaoCartao)).click();
                driver.getDriver().findElement(By.id(finalizarCompraElements.numeroCartaoText)).sendKeys("5252947700363324");
                driver.getDriver().findElement(By.id(finalizarCompraElements.dataExpText)).sendKeys("08/22");
                driver.getDriver().findElement(By.id(finalizarCompraElements.nomeCartaoText)).sendKeys("Teste Automation");
                driver.getDriver().findElement(By.id(finalizarCompraElements.numeroCartaoText)).sendKeys("5252947700363324");
                driver.getDriver().findElement(By.id(finalizarCompraElements.codSeguracaoText)).sendKeys("123");
                break;
            case "PixMercadoPago":
                driver.getDriver().findElement(By.id(finalizarCompraElements.opcaoPix)).click();
                break;
        }

    }
    public void escolhertipoEndereco(String TipoEnder) {
        switch (TipoEnder) {
            case "principal":
                suportWeb.tempo(2);
               driver.getDriver().findElement(By.cssSelector(finalizarCompraElements.escolherEndereco)).click();
                break;
        }
    }
    public void clicarFinalizar(){
        driver.getDriver().findElement(By.id(finalizarCompraElements.btnFinalizar)).click();
    }

}