import java.time.LocalDate;

public class ShippingProduct extends Product implements IShippingProduct{
    private Double weight;
    ShippingProduct(String name, double price, int quantity,Double weight){
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.weight =weight;

    }ShippingProduct(String name, double price,Double weight){
            this.name = name;
            this.price = price;
            this.quantity = 0;
            this.weight =weight;

    }
    ShippingProduct(String name, double price, int quantity, LocalDate expire, Double weight){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ExpireDate = expire;
        this.weight =weight;

    }ShippingProduct(String name, double price, LocalDate expire, Double weight){
        this.name = name;
        this.price = price;
        this.quantity = 0;
        this.ExpireDate = expire;
        this.weight =weight;

    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
