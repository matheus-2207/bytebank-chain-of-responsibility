package bytebank;

public abstract class ValidationHandler {
    private ValidationHandler next;

    public ValidationHandler linkWith(ValidationHandler next) {
        this.next = next;
        return next;
    }

    public final String validate(OperationRequest request) {
        String error = check(request);
        if (error != null) {
            return error;
        }
        return next == null ? null : next.validate(request);
    }

    protected abstract String check(OperationRequest request);
}
