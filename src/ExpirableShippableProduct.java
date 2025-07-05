import java.time.LocalDate;

public class ExpirableShippableProduct extends BaseProduct implements ShippableProduct, ExpirableProduct {
    private final double weight;
    private final LocalDate expiryDate;

    public ExpirableShippableProduct(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity);

        if (expiryDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Expiry date cannot be in the past.");
        }

        this.weight = weight;
        this.expiryDate = expiryDate;
    }


    public double getWeight() {
        return weight;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }


}
