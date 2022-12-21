package warehouse;

/*
 * Use this class to test to addProduct method.
 */
public class AddProduct {
    public static void main(String[] args) {
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);

        int read = StdIn.readInt();


	// Use this file to test addProduct
        //var that takes in class warehouse
        //for loop
        //set variables to read int/read string
        //add prod to warehouse
        //std out print ln
        Warehouse house = new Warehouse();

        for(int i = 0; i < read; i++){
            int lastPurchase =  StdIn.readInt();
            int id =  StdIn.readInt();
           
            String name = StdIn.readString();
            
            int stock = StdIn.readInt();
            int demand = StdIn.readInt();

        house.addProduct(id, name, stock, lastPurchase, demand);
    }

    StdOut.println(house);
}


}

