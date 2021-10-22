package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.DriverQA;

public class PageFinalizarComprar extends BasePage {

    @FindBy(css=".with-discount > img")
    private WebElement opcaoBoleto;

    @FindBy(id="radio-cartao")
    private WebElement opcaoCartao;

    @FindBy(id="radio-mercadopagov1-18")
    private WebElement opcaoPix;

    @FindBy(id="cartao_cartao_numero8")
    private WebElement numeroCartaoText;

    @FindBy(id="cartao_cartao_data_expiracao")
    private WebElement dataExpText;

    @FindBy(id="cartao_cartao_nome")
    private WebElement nomeCartaoText;

    @FindBy(id="cartao_cartao_cvv")
    private WebElement codSeguracaoText;

    @FindBy(id="cartao_cartao_parcelas")
    private WebElement parcelaSelect;


    PageFinalizarComprar(DriverQA stepDriver) {
        super(stepDriver);
    }
}
