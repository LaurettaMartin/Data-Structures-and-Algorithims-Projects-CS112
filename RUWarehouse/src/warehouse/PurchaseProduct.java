package warehouse;

public class PurchaseProduct {
    public static void main(String[] args) {
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);

        int read = StdIn.readInt();


        Warehouse house = new Warehouse();
         
            for(int i = 0; i < read; i++){
                if (StdIn.readString().equalsIgnoreCase("add") || StdIn.readString().equalsIgnoreCase("add" )) {
                    int lastPurchase =  StdIn.readInt();
                    int id =  StdIn.readInt();
                    
                    String name = StdIn.readString();
                    
                    int stock = StdIn.readInt();
                    int demand = StdIn.readInt();
        
                house.addProduct(id, name, stock, lastPurchase, demand);
        }
            else if (StdIn.readString().equalsIgnoreCase("purchase") || StdIn.readString().equalsIgnoreCase("purchase ")){
            int id =  StdIn.readInt();
            int day = StdIn.readInt();
            int amount= StdIn.readInt();

            house.purchaseProduct(id, day, amount);
        } 
    }
        StdOut.println(house);
    }
}