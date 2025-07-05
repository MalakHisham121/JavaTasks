import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Stock {
    private static HashMap<String, Integer> Available;
    private static ArrayList<Product> ActualProducts;



    public static void  setStock (HashMap<String,Integer> stock){
        if(Available==null){
            Available = new HashMap<String,Integer>();
        }
        if(ActualProducts==null){
            ActualProducts = new ArrayList<Product>();
        }
        Available = stock;

    }
    public static void  setStock ( ArrayList<Product>stock){
        if(Available==null){
            Available = new HashMap<String,Integer>();
        }
        if(ActualProducts==null){
            ActualProducts = new ArrayList<Product>();
        }
        ActualProducts = stock;
        for(Product p:ActualProducts){
          Available.putIfAbsent(p.getName(),0);
          Available.put(p.getName(),getAvailable(p.getName())+p.getQuantity());
        }


    }

    public static void setProductAvailable(String p, int available){
        if(Available==null){
            Available = new HashMap<String,Integer>();
        }
        Available.putIfAbsent(p,0);
        Available.put(p,Available.get(p)+available);
    }


    public static int getAvailable(String productName){
        if(Available==null){
            Available = new HashMap<String,Integer>();
        }
        Available.putIfAbsent(productName,0);

        return Available.get(productName);
    }
    public static void AddAvailable(String productName){
        if(Available==null){
            Available = new HashMap<String,Integer>();
        }
        Available.putIfAbsent(productName,0);
        Available.put(productName,getAvailable(productName)+1);

    }
    public static void decreaseAvailable(String productName){
        if(Available!=null) {
            Available.put(productName,getAvailable(productName)-1) ;
        }

    }
    public static void removeExpired(){
        if(Available==null|| ActualProducts==null) return;
        for (Product p : ActualProducts){
            if(p.getExpireDate()!=null&& LocalDate.now().isAfter(p.ExpireDate)){
                Available.put(p.getName(),Available.get(p)-1);
                ActualProducts.remove(p);


            }
        }

    }

    public static void ShowStock(){

        for(Product p : ActualProducts.stream()
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new)) ){

            System.out.println(Available.get(p.getName())+"X " +p.getName() );

        }
    }

}
