
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;


public class ShippingService {
    private ArrayList<IShippingProduct> ShippedProducts;
    private double totalWeight;

    ShippingService() {
        ShippedProducts = new ArrayList<IShippingProduct>();
    }

    public ArrayList<IShippingProduct> getShippedProducts() {
        if (ShippedProducts.isEmpty()) {
            // throw error that there is no shipped products;
        } else {
            System.out.println("This Shipping Service is shipping the following items:");
            for (var item : ShippedProducts) {
                System.out.println(item.getName() + "   " + item.getWeight() + "g");
            }

        }
        return ShippedProducts;

    }

    public void addShippedProduct(IShippingProduct p) {
        ShippedProducts.add(p);
        totalWeight+= p.getWeight();
    }

    public void removeShippedProduct(IShippingProduct p) {
        ShippedProducts.remove(p);

    }
    public void showShippingDetails(){
        if(ShippedProducts==null||ShippedProducts.isEmpty()){
            System.out.println("No Shipped items with this Service");
        }
        else{
        System.out.println("The Shipping products");
        Map<IShippingProduct, Long> productCounts = ShippedProducts.stream()
                    .collect(Collectors.groupingBy(
                            p -> p,
                            Collectors.counting()
                    ));
        for(IShippingProduct p : ShippedProducts.stream()
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new)) ){
            long count = productCounts.get(p);
            System.out.println(count+"X " +p.getName() +' '+p.getWeight()*count+'g' );

        }
        System.out.println("Total Shipping Weight " + totalWeight +" kg");

        }
    }

    public double getTotalWeight(){
        return totalWeight /1000;
    }

}
