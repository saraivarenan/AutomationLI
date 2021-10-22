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
    E escolher a opção de "<pagamento>"
    E escolher endereço "<tipo>"
    E clicar em finalizar Comprar
    Entao o pedido deve ser gerado

    Exemplos:
    |cep|cupom|valorProduto|valorTotal|pagamento|tipo|
    |04857620|FRETEGRATIS|80    |R$ 80,00     |boleto         |principal|
   # |01210010|10OFF      |89    |R$ 80,10  |MasterCard     |principal|
   # |04857620|30REAIS    |1750 |R$ 21,00     |Pix-MercadoPago|principal|
   # |04857620|null       |80    |93     |boleto         |principal|

