package bytebank;

import java.math.BigDecimal;

public final class OperationProcessor {
    private final ValidationHandler validations;

    public OperationProcessor(BigDecimal operationLimit) {
        SupportedOperationHandler supportedOperation = new SupportedOperationHandler();
        supportedOperation
                .linkWith(new PositiveAmountHandler())
                .linkWith(new ActiveAccountHandler())
                .linkWith(new OperationLimitHandler(operationLimit))
                .linkWith(new SufficientBalanceHandler());
        this.validations = supportedOperation;
    }

    public OperationResult process(OperationRequest request) {
        String error = validations.validate(request);
        if (error != null) {
            return OperationResult.failure(error, request.account().getBalance());
        }

        if (Operation.valueOf(request.operation()) == Operation.DEPOSITO) {
            request.account().deposit(request.amount());
        } else {
            request.account().withdraw(request.amount());
        }
        return OperationResult.success(request.account().getBalance());
    }
}
