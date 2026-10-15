# ByteBank — validação de operações com Chain of Responsibility

Projeto de estudo em Java puro para demonstrar o padrão **Chain of Responsibility** em um fluxo simples de operações bancárias.

Cada validador trata uma regra e, se a operação continuar válida, encaminha a requisição ao próximo elo da cadeia. Assim, regras podem ser reorganizadas ou adicionadas sem concentrar todas as condições em um único método.

## Regras demonstradas

- O tipo deve ser `DEPOSITO` ou `SAQUE`.
- O valor deve ser positivo.
- A conta precisa estar ativa.
- O valor não pode exceder o limite configurado para uma operação.
- Saques não podem ultrapassar o saldo disponível.

## Executar

Requer Java 17 ou superior. Na pasta do projeto:

```bash
javac -d out src/bytebank/*.java
java -cp out bytebank.Main
```

O programa apresenta exemplos de depósito e saque válidos e de operações recusadas pelas validações.

## Estrutura

```text
src/bytebank/
  Main.java
  Account.java
  Operation.java
  OperationRequest.java
  OperationResult.java
  ValidationHandler.java
  SupportedOperationHandler.java
  PositiveAmountHandler.java
  ActiveAccountHandler.java
  OperationLimitHandler.java
  SufficientBalanceHandler.java
  OperationProcessor.java
```

## Padrão aplicado

`ValidationHandler` define o elo da cadeia. Cada implementação valida uma única responsabilidade; quando não encontra erro, `validate` encaminha a requisição ao próximo validador. `OperationProcessor` monta a ordem dos validadores e só altera o saldo depois que a cadeia inteira aprova a requisição.

## Melhorias possíveis

- Carregar regras e limites de configuração externa.
- Registrar as tentativas em um repositório.
- Criar testes unitários para cada elo.
- Expor o processamento por uma API Spring Boot.
