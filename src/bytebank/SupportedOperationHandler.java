package bytebank;

public final class SupportedOperationHandler extends ValidationHandler {
    @Override
    protected String check(OperationRequest request) {
        try {
            Operation.valueOf(request.operation());
            return null;
        } catch (IllegalArgumentException exception) {
            return "Tipo de operação inválido: use DEPOSITO ou SAQUE";
        }
    }
}
