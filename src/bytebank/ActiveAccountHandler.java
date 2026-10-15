package bytebank;

public final class ActiveAccountHandler extends ValidationHandler {
    @Override
    protected String check(OperationRequest request) {
        return request.account().isActive() ? null : "A conta está inativa";
    }
}
