import java.util.List;

public class Customer {
    private double balance;
    private Cart cart;

    public Customer(double balance) {
        if(balance <= 0 ) {
            System.out.println("Invalid balance value");
            return;

        }
        this.balance = balance;

    }

    public double getBalance() {
        return balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart){
        this.cart=cart;
    }



    public void reduceBalance(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println( "Can't complete this transaction ----> Insufficient balance.");

        }
    }


}
