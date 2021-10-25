package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.support.PageFactoryFinder;
import pages.*;
import parametros.PedidoElements;
import support.BaseSteps;
import support.SuportWeb;

public class ComprarSteps extends BaseSteps {
    PageHome pageHome = new PageHome(driver);
    PageLogin pageLogin = new PageLogin(driver);
    PageDetalheProduto pageDetalheProduto= new PageDetalheProduto(driver);
    PageCarrinho pageCarrinho = new PageCarrinho(driver);
    PageFinalizarComprar finalizarComprar = new PageFinalizarComprar(driver);
    PagePedido pagePedido = new PagePedido(driver);
    SuportWeb suportWeb = new SuportWeb();
    
    @Dado("^o usuário acessou o sistema$")
    public void queOUsuárioEstáNaPaginaInicial() { pageHome.acessarSistema();
    }

    @E("^Logou no sistema$")
    public void logouNoSistema() {
        pageHome.clicarLogar();
        pageLogin.inserirUsuario();

    }

    @Quando("^escolher o produto com valor \"([^\"]*)\"$")
    public void escolherOProdutoComValor(String produto) throws Throwable {
     pageHome.escolherProduto(produto);
        pageDetalheProduto.clicarComprar();

    }

    @E("^calcular o cep \"([^\"]*)\"$")
    public void calcularOCep(String cep) throws Throwable {
        pageCarrinho.CalcularCep(cep);
    }

    @E("^aplicar o cupom \"([^\"]*)\"$")
    public void aplicarOCupom(String cupom) throws Throwable {
        pageCarrinho.aplicarCupom(cupom);

    }


    @Entao("^o valor total do produto deve ser \"([^\"]*)\"$")
    public void oValorTotalDoProdutoDeveSer(String valorProduto)  {
        suportWeb.tempo(4);
        pageCarrinho.validarValorTotal(valorProduto);

    }

    @E("^clicar em finalizar compra$")
    public void clicarEmFinalizarCompra() {
        pageCarrinho.clicarFinalizarCompra();
    }

    @E("^escolher endereço \"([^\"]*)\"$")
    public void escolherEndereço(String escolherEndereco) {
        finalizarComprar.escolhertipoEndereco(escolherEndereco);
     
    }

    @E("^clicar em finalizar Comprar$")
    public void clicarEmFinalizarComprar() {

        finalizarComprar.clicarFinalizar();
    }

    @Entao("^o pedido deve ser gerado$")
    public void oPedidoDeveSerGerado() {
        pagePedido.validarPedido();
    }

    @E("^escolher a opção de \"([^\"]*)\" desconto na \"([^\"]*)\"$")
    public void escolherAOpçãoDeDescontoNa(String opcaoPag, Boolean descotoforma) throws Throwable {
        finalizarComprar.escolherPagamento(opcaoPag, descotoforma);
        suportWeb.tempo(3);
    }
}
