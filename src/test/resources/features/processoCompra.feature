#language: pt

Funcionalidade: : Realizar comprar

  @lojaI
  Esquema do Cenario: : Realizar compra com desconto
    Dado o usuário acessou o sistema
    E Logou no sistema
    Quando escolher o produto com valor "<valorProduto>"
    E calcular o cep "<cep>"
    E aplicar o cupom "<cupom>"
    Entao o valor total do produto deve ser "<valorTotal>"
    E clicar em finalizar compra
    E escolher a opção de "<pagamento>" desconto na "<formaPagamento>"
    E escolher endereço "<tipo>"
    E clicar em finalizar Comprar
    Entao o pedido deve ser gerado

    Exemplos:
    |cep|cupom|valorProduto|valorTotal|pagamento               |tipo    |formaPagamento      |
    |04857620|FRETEGRATIS|80    |R$ 80,00     |boleto        |principal|false                |
   # |04857620|10OFF      |89    |R$ 80,10  |cartao           |principal|false|
    |04857620|30REAIS    |1750 |R$ 21,00     |PixMercadoPago |principal|false                |
    |04857620|null       |80    |R$ 101,00     |boleto        |principal|true                |

