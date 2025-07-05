public class Customer
{

    private Cart MyCart;
    private double Balance;
    private double shippingCost;

    private double wholeReceipt;

    Customer( Cart cart,double balance){
        MyCart = cart;
        Balance = balance;
        shippingCost =0;

    }

    //
    Customer (double shippingCost){
        MyCart = new Cart();
        this.shippingCost = shippingCost;

    }
    public double getWholeReceipt(){
        wholeReceipt = MyCart.getItemsTotal() + shippingCost;
        return wholeReceipt;
    }

    // Use following function when no shopping cost ( Shipping is free)
    public void Checkout( ){
        this.shippingCost =0;
  try {
      if (MyCart.isEmpty()) {
          throw new Exception("The cart is empty");
      }
      if (this.getWholeReceipt() > Balance) {
          throw new Exception("Customer has not enogh money");
      }
      showRecipt();
      Balance -= getWholeReceipt();
      System.out.println("The user balance now is "+ Balance);
      MyCart.EmptyCart();
      wholeReceipt =0;
  }


  catch (Exception e){
      System.out.println("Oh NO,"+e.getMessage()+"!!!!!!!!!!!!");

  }





    }
   // use this function when shipping is not free
    public void Checkout(double shippingCost){
        this.shippingCost = shippingCost;

        try {
            if (MyCart.isEmpty()) {
                throw new Exception("The cart is empty");
            }
            if (this.getWholeReceipt() > Balance) {
                throw new Exception("Customer has not enough money");
            }
            showRecipt();
            Balance -= getWholeReceipt();
            System.out.println("The user balance now is "+ Balance);
            MyCart.EmptyCart();
            wholeReceipt =0;

        }

        catch (Exception e){
            System.out.println("Oh NO,"+e.getMessage()+"!!!!!!!!!!!!");
        }

    }

    public void showRecipt(){
        System.out.println("Recipt Details:");
       MyCart.ShowCart();
       System.out.println("Subtotal: " +MyCart.getItemsTotal() );
       System.out.println("Shipping: "+shippingCost);
       System.out.println("Total: "+ getWholeReceipt());
    }

}
