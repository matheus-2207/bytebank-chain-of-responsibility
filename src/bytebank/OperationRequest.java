package bytebank;

import java.math.BigDecimal;
import java.util.Objects;

public record OperationRequest(Account account, String operation, BigDecimal amount) {
    public OperationRequest {
        Objects.requireNonNull(account, "conta não pode ser nula");
        Objects.requireNonNull(operation, "operação não pode ser nula");
        Objects.requireNonNull(amount, "valor não pode ser nulo");
    }
}
