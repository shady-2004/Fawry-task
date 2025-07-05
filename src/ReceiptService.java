import java.util.ArrayList;
import java.util.List;

public class ReceiptService {
    public void generateReceipt(Customer customer){
        Cart cart=customer.getCart();
        List<CartItem> items=cart.getItems();

        if (items.isEmpty()) {
            System.out.println(" Error: Cart is empty.");
            return;
        }

        double subtotal = 0;

        List<CartItem>toBeShipped=new ArrayList<>();

        String shipmentNotice="";
        String checkoutReceipt="";


        System.out.println(" Receipt:");
        System.out.println("--------------------------------------------------");

        for(CartItem item :items){
            Product product = item.getProduct();

            if (product instanceof ExpirableProduct) {
                ExpirableProduct expirable = (ExpirableProduct) product;
                if (expirable.isExpired()) {
                    System.out.println(" Error: Product '" + product.getName() + "' is expired.");
                    return;
                }
            }

            if (item.getQuantity() > product.getQuantity()) {
                System.out.println("Error: Not enough stock for '" + product.getName() + "'.");
                return;
            }

            double price =item.getQuantity() * product.getPrice();

            checkoutReceipt+=(item.getQuantity() + "X " +product.getName() +"           " +price +"\n");


            if (product instanceof Shippable){
                Shippable shippable = (Shippable) product;
                toBeShipped.add(item);
                double weight = shippable.getWeight() * item.getQuantity();
                shipmentNotice+=(item.getQuantity() + "X " +product.getName() +"           " +weight+"\n");
            }
            subtotal+=price;
        }

        double weight =ShippingService.calculateTotalWeight(toBeShipped);
        double shipping=ShippingService.calculateShippingCost(toBeShipped);
        double amount=(subtotal+shipping);
        System.out.println("*** Shipment notice ***");
        System.out.println(shipmentNotice);
        System.out.println("Total package weight "+ weight+"Kg");
        System.out.println("*** Checkout receipt ***");
        System.out.println(checkoutReceipt);
        System.out.println("---------------------------------");
        System.out.println("Subtotal               " + subtotal);
        System.out.println("Shipping               "+shipping);
        System.out.println("Amount                 "+ amount);
        System.out.println("--------------------------------------------------");

        customer.reduceBalance(amount);
    }
}
