package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parametros.CarrinhoElements;
import support.DriverQA;
import support.SuportWeb;

public class PageCarrinho extends BasePage {
    CarrinhoElements carrinhoElements =new CarrinhoElements();
    SuportWeb suportWeb = new SuportWeb();

    public PageCarrinho(DriverQA stepDriver) {
        super(stepDriver);
    }
    public void CalcularCep(String cep){
        driver.waitElement(carrinhoElements.cepText);
        driver.getDriver().findElement(By.id(carrinhoElements.cepText)).sendKeys(cep);
        driver.getDriver().findElement(By.cssSelector(carrinhoElements.calcularFreteBtn)).click();

    }
    public void aplicarCupom(String cupom){

        if(cupom.equals("null")){
            System.out.println("Não será aplicado cupom");
            suportWeb.tempo(2);

        }else {
            driver.waitElement(carrinhoElements.cupomText);
            driver.getDriver().findElement(By.id(carrinhoElements.cupomText)).sendKeys(cupom);
            driver.getDriver().findElement(By.xpath(carrinhoElements.cupomBtn)).click();
        }
        driver.getDriver().findElement(By.cssSelector(carrinhoElements.radioFormaEnvio)).click();
    }
    public void  validarValorTotal(String valor){
String valorApresentado = driver.getDriver().findElement(By.cssSelector(carrinhoElements.valorTotal)).getText();
System.out.println(valorApresentado+" "+valor);
 Assert.assertEquals(valorApresentado,valor);
    }
    public void clicarFinalizarCompra(){
        driver.getDriver().findElement(By.cssSelector(carrinhoElements.finalizarComprarBtn)).click();
    }
}
