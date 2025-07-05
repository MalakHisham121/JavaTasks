import java.time.LocalDate;
import java.util.Date;

public class Product {
   protected String name;
   protected double price;
   protected int quantity;
   protected LocalDate ExpireDate;

   Product(){
       name="";
       price=0;
       quantity=0;
       ExpireDate=null;
   }
   Product (String name, double price, int quantity){
       this.name = name;
       this.price = price;
       this.quantity = quantity;

   } Product (String name, double price){
       this.name = name;
       this.price = price;
       this.quantity = 0;

   }
   Product (String name, double price, int quantity,LocalDate expire){
       this.name = name;
       this.price = price;
       this.quantity = quantity;
       this.ExpireDate = expire;

   }
    Product (String name, double price,LocalDate expire){
        this.name = name;
        this.price = price;
        this.quantity = 0;
        this.ExpireDate = expire;

    }

    public String getName() {
        return this.name;
    }
    public void clearQuantity(){
       this.quantity =0;
    }
    public int getQuantity() {
        return quantity;
    }
    public LocalDate getExpireDate(){
       return ExpireDate;
    }
    public double getPrice(){
       return price;
    }

    public void increaseQuantity(){
       this.quantity++;
    }
    public void deccreaseQuantity(){
       if(this.quantity>0)
          this.quantity--;
    }


}


