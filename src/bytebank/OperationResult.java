package bytebank;

import java.math.BigDecimal;

public record OperationResult(boolean successful, String message, BigDecimal balance) {
    public static OperationResult success(BigDecimal balance) {
        return new OperationResult(true, "Operação realizada com sucesso", balance);
    }

    public static OperationResult failure(String message, BigDecimal balance) {
        return new OperationResult(false, message, balance);
    }
}
