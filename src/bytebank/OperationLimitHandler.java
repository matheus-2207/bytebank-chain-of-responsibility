package bytebank;

import java.math.BigDecimal;

public final class OperationLimitHandler extends ValidationHandler {
    private final BigDecimal limit;

    public OperationLimitHandler(BigDecimal limit) {
        this.limit = limit;
    }

    @Override
    protected String check(OperationRequest request) {
        return request.amount().compareTo(limit) <= 0
                ? null
                : "O valor excede o limite de " + limit.toPlainString();
    }
}
