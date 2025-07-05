import java.time.LocalDate;
import java.util.ArrayList;

import java.util.stream.Collectors;

public class Cart {
    private ArrayList<Product> ShoppingItems;

    private double itemsTotal;



     Cart(){
         ShoppingItems = new ArrayList<Product>();
     }

    public void AddItemToCart( Product product){
         // when product is not shipped
         try{
             if(Stock.getAvailable(product.getName())==0){
                 throw new Exception("The product is ran out of stock");
             }
             if(product.ExpireDate!=null&&LocalDate.now().isAfter( product.getExpireDate())){
                 Stock.decreaseAvailable(product.getName());

                 Stock.removeExpired();
                 throw new Exception("The product is expired, Sorry for that we have removed it from the stock");
             }
             ShoppingItems.add(product);
            itemsTotal+= product.getPrice();
            Stock.decreaseAvailable(product.getName());
             product.increaseQuantity();
         }
         catch (Exception e){
             System.out.println("Oh NO,"+e.getMessage()+"!!!!!!!!!!!!");

         }
    }
    public void AddItemToCart( ShippingProduct product, ShippingService shippingService){
         // when product is shipped
         try{
             if(Stock.getAvailable(product.getName())==0){
                 throw new Exception("The product is ran out of stock");
             }
             if(product.ExpireDate!=null&& LocalDate.now().isAfter( product.getExpireDate())) {
                 Stock.decreaseAvailable(product.getName());

                // Stock.removeExpired();
                 throw new Exception("The product is expired");
             }
             ShoppingItems.add(product);
             Stock.decreaseAvailable(product.getName());
             shippingService.addShippedProduct(product);
            itemsTotal+= product.getPrice();
             product.increaseQuantity();

         }
         catch (Exception e){
             System.out.println("Oh NO,"+e.getMessage()+"!!!!!!!!!!!!");

         }
    }
    public void RemoveItemfromCart( Product product){
         try{
             if(ShoppingItems.isEmpty()){
                 throw new Exception("Item not found in card");
             }

             ShoppingItems.remove(product);

             Stock.AddAvailable(product.getName());
            itemsTotal-= product.getPrice();
             product.increaseQuantity();
         }
         catch (Exception e){
             System.out.println("Oh NO,"+e.getMessage()+"!!!!!!!!!!!!");

         }
    }
    public void RemoveItemfromCart( ShippingProduct product,ShippingService shippingService)
    {
         try{
             if(ShoppingItems.isEmpty()){
                 throw new Exception("Item not found in card");
             }
           ShoppingItems.remove(product);

             Stock.AddAvailable(product.getName());
             shippingService.removeShippedProduct(product);
             itemsTotal-= product.getPrice();

             product.increaseQuantity();
             if(product.quantity==0){
                 shippingService.removeShippedProduct(product);
             }
         }
         catch (Exception e){

         }
    }

    public void ShowCart(){
         System.out.println("Cart details:");
         for (Product p: ShoppingItems.stream()
                 .distinct()
                 .collect(Collectors.toCollection(ArrayList::new))){
             System.out.println(p.getQuantity() + "X "+ p.getName()+ " "+p.getPrice()* p.getQuantity() );
         }
    }

    public void EmptyCart(){
         for(Product p: ShoppingItems){
             p.clearQuantity();
         }
         itemsTotal =0;
        ShoppingItems.clear();
    }

    public boolean isEmpty(){
         return ShoppingItems.isEmpty();
    }

    public double getItemsTotal(){
         return this.itemsTotal;
    }

}
