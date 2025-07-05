import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create products of different types

        ExpirableShippableProduct cheese = new ExpirableShippableProduct(
                "Cheese", 100, 10,  200,LocalDate.now().plusDays(5));

        ExpirableBaseProduct biscuits = new ExpirableBaseProduct(
                "Biscuits", 150, 5, LocalDate.now().plusDays(3));

        ShippableBaseProduct tv = new ShippableBaseProduct(
                "TV", 2000, 3, 5000);

        SimpleProduct scratchCard = new SimpleProduct(
                "Scratch Card", 50, 10);

        // Create Cart
        Cart cart = new Cart();
        cart.addProduct(tv, 1);
        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        cart.addProduct(scratchCard, 1);



        Customer customer = new Customer(1000);
        customer.setCart(cart);


        ReceiptService receiptService = new ReceiptService();
        receiptService.generateReceipt(customer);
    }
}
