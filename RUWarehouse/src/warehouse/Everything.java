package warehouse;

/*
 * Use this class to put it all together.
 */ 
public class Everything {
    public static void main(String[] args) {
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);


                int count = StdIn.readInt();
                Warehouse wh = new Warehouse();
        
                for (int i = 0; i < count; i++){
                    String read = StdIn.readString();
                    if(read.equalsIgnoreCase("add")){
                        int Day = StdIn.readInt();
                        int ID = StdIn.readInt();
                        String Name = StdIn.readString();
                        int ItemStock = StdIn.readInt();
                        int ItemDemand = StdIn.readInt();
                        wh.addProduct(ID, Name, ItemStock, Day, ItemDemand);
                    } else if (read.equalsIgnoreCase("restock")){
                        int ID = StdIn.readInt();
                        int amount = StdIn.readInt();
                        wh.restockProduct(ID, amount);
                    } else if (read.equalsIgnoreCase("delete")){
                        int ID = StdIn.readInt();
                         wh.deleteProduct(ID);
                    }
                    else if (read.equalsIgnoreCase("purchase")){
                        int day = StdIn.readInt();
                        int ID = StdIn.readInt();
                        int amount = StdIn.readInt();
                        wh.purchaseProduct(ID, day, amount);
                    }
                }
                StdOut.print(wh);
        
                }
            }