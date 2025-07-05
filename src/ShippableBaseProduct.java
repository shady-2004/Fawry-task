public  class ShippableBaseProduct extends BaseProduct implements Shippable,ShippableProduct {
    private final double weight;

    public ShippableBaseProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);

        if (weight <= 0) System.out.println("Can't add this product invalid weight");

        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
