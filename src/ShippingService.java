import java.util.List;

public class ShippingService {

    private static final double COST_PER_KG = 20; // $20 per kg

    public static double calculateTotalWeight(List<CartItem> itemsToShip) {
        if (itemsToShip == null || itemsToShip.isEmpty()) {
            return 0;
        }

        double totalWeight = 0;
        for (CartItem item : itemsToShip) {
            Product product = item.getProduct();
            if (product instanceof Shippable) {
                Shippable shippable = (Shippable) product;
                totalWeight += shippable.getWeight() * item.getQuantity(); // Multiply by quantity
            }
        }

        return totalWeight / 1000;
    }

    public static double calculateShippingCost(List<CartItem> itemsToShip) {
        double totalWeight = calculateTotalWeight(itemsToShip);
        return totalWeight * COST_PER_KG;
    }
}
