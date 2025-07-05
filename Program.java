import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String [] args){

        // My program is assumming that ther is only one stock
        // quantity attributes in product class points to customer baught quantity not the available in stock , available quantity stored in stock class
        // product have expire date attribute which would be null if not applicable to expire
        // I also assume that could be exist many shipping services
        // I assume that the weight given by the program is by (g) and I will output it in (kg)

        ShippingProduct milk = new ShippingProduct("Milk", 3.99, LocalDate.of(2025, 7, 10),400.0);
        ShippingProduct bread = new ShippingProduct("Bread", 2.49, LocalDate.of(2025, 6, 8),25.0);

        ShippingProduct laptop = new ShippingProduct("Laptop", 999.99, 2500.0);
        ShippingProduct headphones = new ShippingProduct("Headphones", 59.99, 100.0);
        Product MobileScratchcard = new Product("scratch card",40);

        // In following line slicing happen but don't affect any part
        ArrayList<Product> products = new ArrayList<Product>(List.of(milk,bread,laptop,headphones,MobileScratchcard));
        Stock.setStock(products);
        Stock.setProductAvailable(milk.getName(),3);
        Stock.setProductAvailable(bread.getName(),6);
        Stock.setProductAvailable(laptop.getName(),2);
        Stock.setProductAvailable(headphones.getName(),1);
        Stock.setProductAvailable(MobileScratchcard.getName(), 4);


        Cart cart1 = new Cart();
        Customer customer1 = new Customer(cart1,2000);
        customer1.Checkout(); // cart is empty
        System.out.println("----------------------------------------------------------------------------------------");


        ShippingService shippingService = new ShippingService();
        cart1.AddItemToCart(MobileScratchcard);
        cart1.AddItemToCart(milk,shippingService);
        cart1.AddItemToCart(milk,shippingService);
        cart1.AddItemToCart(milk,shippingService);
        cart1.AddItemToCart(laptop,shippingService);
        cart1.AddItemToCart(headphones,shippingService);
        shippingService.showShippingDetails(); // show shipping items
        System.out.println("----------------------------------------------------------------------------------------");
        cart1.AddItemToCart(milk,shippingService); // no available milk here
        // show total
        customer1.Checkout();
        System.out.println("-------------------------------------------------------------------------------");
        Stock.ShowStock();// show available in stock
        System.out.println("-------------------------------------------------------------------------------");
        cart1.AddItemToCart(bread,shippingService);// bread is expired
        System.out.println("-------------------------------------------------------------------------------");
        customer1.Checkout(40); // cart is empty
        System.out.println("------------------------------------------------------------------------------");
        cart1.AddItemToCart(milk,shippingService); // product is out of stock
        cart1.AddItemToCart(milk,shippingService); // product is out of stock


        customer1.Checkout(1000);// customer balance is not enough
        System.out.println("------------------------------------------------------------------------------");

        customer1.Checkout(0); // customer balance is enough
    }
}
