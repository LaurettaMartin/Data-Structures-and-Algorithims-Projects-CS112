package warehouse;

/*
 * Use this class to test the deleteProduct method.
 */ 
public class DeleteProduct {
    public static void main(String[] args) {
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);

        int read = StdIn.readInt();

            Warehouse house = new Warehouse();
         
            for(int i = 0; i < read; i++){
                if (StdIn.readString().equalsIgnoreCase("delete") || StdIn.readString().equalsIgnoreCase("delete ")) {
                    int id = StdIn.readInt();

                    house.deleteProduct(id);

            } else if(StdIn.readString().equalsIgnoreCase("add") || StdIn.readString().equalsIgnoreCase("add ")){
                   
                    int id =  StdIn.readInt();
                    int stock = StdIn.readInt();
                    String name = StdIn.readString();
                    int lastPurchase =  StdIn.readInt();
                    int demand = StdIn.readInt();
        
               house.addProduct(id, name, stock, lastPurchase, demand);
        }

        
        }
    StdOut.println(house);
    }
}
    