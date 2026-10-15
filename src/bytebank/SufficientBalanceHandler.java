package bytebank;

public final class SufficientBalanceHandler extends ValidationHandler {
    @Override
    protected String check(OperationRequest request) {
        if (Operation.valueOf(request.operation()) != Operation.SAQUE) {
            return null;
        }
        return request.account().getBalance().compareTo(request.amount()) >= 0
                ? null
                : "Saldo insuficiente para realizar o saque";
    }
}
