package bytebank;

import java.math.BigDecimal;
import java.util.Objects;

public final class Account {
    private final String number;
    private BigDecimal balance;
    private boolean active;

    public Account(String number, BigDecimal openingBalance, boolean active) {
        this.number = Objects.requireNonNull(number, "number não pode ser nulo");
        this.balance = Objects.requireNonNull(openingBalance, "saldo inicial não pode ser nulo");
        this.active = active;
    }

    public String getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }
}
