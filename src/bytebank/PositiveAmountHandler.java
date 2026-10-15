package bytebank;

public final class PositiveAmountHandler extends ValidationHandler {
    @Override
    protected String check(OperationRequest request) {
        return request.amount().signum() > 0 ? null : "O valor da operação deve ser maior que zero";
    }
}
