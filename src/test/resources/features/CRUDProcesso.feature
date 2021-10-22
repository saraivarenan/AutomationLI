#language: pt

  Funcionalidade: Crud do cadastro de processos

    Contexto:
      Dado que o usuário está na pagina inicial
      E  que o usuario clica no menu Processos
      E o usuario clica no botão Novo
      E o usuário preencha os campos obrigatórios
      Quando o usuário clicar no botão salvar

@processo
    Cenario: adicionar um novo Processo
      Então o usuario deveria ver a mensagem "Processo foi criado com sucesso."
@processo
    Cenario: Excluir um novo Processo
      E criado um processo "Processo foi criado com sucesso."
      E clicar em voltar
      E o usuario clicar em excluir no registro criado
      E clicar em confirmar na mensagem de deletar
      Então o registro não dever ser apresentado na lista de processo
@processo
    Cenario: Consultar Processo
      E criado um processo "Processo foi criado com sucesso."
      E clicar em voltar
      E clicar em Mostrar no registro criado
      Entao Deve ser apresentado o registro criado

    @processo
Esquema do Cenário: Editar processo
      E criado um processo "Processo foi criado com sucesso."
      E clicar em editar
      E preencher o campo "processo_vara" com valor "<vara>"
      E preencher o campo "processo_numero_processo" com valor "<numeroProcesso>"
      E preencher o campo "processo_natureza" com valor "<naturezaProcesso>"
      E preencher o campo "processo_partes" com valor "<partesProcesso>"
      E preencher o campo "processo_assistente_social" com valor "<assistenteProcesso>"
      E preencher o campo "processo_status" com valor "<StatusPrcessos>"
      E preencher o campo "processo_observacao" com valor "<observacaoProcesso>"
      E clicar em salvar.
      Entao deve ser apresentando uma "<mensagem>"

  Exemplos:
    | vara   | numeroProcesso | naturezaProcesso | partesProcesso | assistenteProcesso | StatusPrcessos | observacaoProcesso | mensagem |
    |02     | 04857320       | teste editado    | partes editado | assistente editado   | status editado | teste obs editado  | Processo atualizado com sucesso.|
    |       | 04857320       | teste editado    | partes editado | assistente editado   | status editado | teste obs editado  | Vara não pode ser deixado em branco|








