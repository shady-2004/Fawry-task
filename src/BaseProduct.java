public abstract class BaseProduct implements Product {
    //Using protected to be accessible to child classes
    protected String name;
    protected double price;
    protected int quantity;

    public BaseProduct(String name, double price, int quantity) {

        if (name.isEmpty()) System.out.println("Can't add this product invalid name");
        if (price <= 0) System.out.println("Can't add this product invalid price");
        if (quantity < 0) System.out.println("Can't add this product invalid price");

        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }
    public  String getName(){return name;}
    public  double getPrice(){return price;}
    public  int  getQuantity(){return quantity;}

    public void reduceQuantity(int amount){
        if(amount > quantity){
            System.out.println("Not enough quantity in stock.");
            return ;
        }
        quantity -= amount;
    }

}
