package bytebank;

import java.math.BigDecimal;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        OperationProcessor processor = new OperationProcessor(new BigDecimal("1000.00"));
        Account account = new Account("0001", new BigDecimal("500.00"), true);

        show(processor.process(new OperationRequest(
                account, "DEPOSITO", new BigDecimal("250.00"))));
        show(processor.process(new OperationRequest(
                account, "SAQUE", new BigDecimal("100.00"))));
        show(processor.process(new OperationRequest(
                account, "SAQUE", new BigDecimal("2000.00"))));
        show(processor.process(new OperationRequest(
                account, "PIX", new BigDecimal("25.00"))));
    }

    private static void show(OperationResult result) {
        String status = result.successful() ? "OK" : "RECUSADA";
        System.out.printf("%s: %s | saldo: %s%n",
                status, result.message(), result.balance().toPlainString());
    }
}
