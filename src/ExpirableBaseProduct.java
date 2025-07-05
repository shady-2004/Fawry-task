import java.time.LocalDate;

public  class ExpirableBaseProduct extends BaseProduct implements ExpirableProduct {
    private final LocalDate expiryDate;

    public ExpirableBaseProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);

        if (expiryDate.isBefore(LocalDate.now())) {
            System.out.println("Invalid expiry date: Date is in the past.");
        }
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }


}
