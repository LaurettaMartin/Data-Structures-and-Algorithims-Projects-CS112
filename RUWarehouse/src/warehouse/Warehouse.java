package warehouse;

/*
 *
 * This class implements a warehouse on a Hash Table like structure, 
 * where each entry of the table stores a priority queue. 
 * Due to your limited space, you are unable to simply rehash to get more space. 
 * However, you can use your priority queue structure to delete less popular items 
 * and keep the space constant.
 * 
 * @author Ishaan Ivaturi
 */


public class Warehouse {
    private Sector[] sectors;
    
    // Initializes every sector to an empty sector
    public Warehouse() {
        sectors = new Sector[10];

        for (int i = 0; i < 10; i++) {
            sectors[i] = new Sector();
        }
    }
    
    /**
     * Provided method, code the parts to add their behavior
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    public void addProduct(int id, String name, int stock, int day, int demand) {
        evictIfNeeded(id);
        addToEnd(id, name, stock, day, demand);
        fixHeap(id);
    }

    /**
     * Add a new product to the end of the correct sector
     * Requires proper use of the .add() method in the Sector class
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    private void addToEnd(int id, String name, int stock, int day, int demand) {
        // IMPLEMENT THIS METHOD ***********************************************************************************************************************
        //take in id, name, stock, day, demand
        //add new prod to object at end of correct sector
        //index should be last digit of given prod id
        //input file format:
        //   - int n represent num of prod to add
        // read from args[0] to args [1]
        //create new warehouse obj, then add each prod from input file to warehouse USING addProduct() NOT addToEnd()
        //print out warehouse obj to output file
        //mod 10 gives last digit - to find sector from product id
        //need to add a new Product object ot the end of correct sector
        //wrote method in warehouse class that takes in all info from addProduct
        //input file
        //Fill in AddProduct.java to read from args[0] to args[1];
        // private Warehouse Products (Product){


        //TEST CODE
        // Product addProd = new Product(id, name, stock, day, demand);
        // int count;
        // Sector createSector = sectors[id % 10];
        // createSector.add(addProd);
            
        int findIndex = id % 10;
        Sector createSector = sectors[findIndex];
        Product updatedProd = new Product(id, name, stock, day, demand);
        createSector.add(updatedProd);
        
         
    }


    /**
     * Fix the heap structure of the sector, assuming the item was already added
     * Requires proper use of the .swim() and .getSize() methods in the Sector class
     * @param id The id of the item which was added
     */
    private void fixHeap(int id) {
        // IMPLEMENT THIS METHOD ***********************************************************************************************************************
    
        //method in warehouse class that takes id of product and adds to end of sector, and fixes the heap structure of sector
        //Warehouse();
        //Sector();
        //do NOT call addtoEnd() method
        //same input file format as addProduct
        //StdIn.setFile(String filename);

        Sector createSector = sectors[id % 10];
        createSector.swim(createSector.getSize());
    }

    /**
     * Delete the least popular item in the correct sector, only if its size is 5 while maintaining heap
     * Requires proper use of the .swap(), .deleteLast(), and .sink() methods in the Sector class
     * @param id The id of the item which is about to be added
     */
    private void evictIfNeeded(int id) {
       // IMPLEMENT THIS METHOD ***********************************************************************************************************************
    
       //method in warehouse class that takes id of prod and makes room for it in correct sector (only IF it has NOT been added yet)
       //Warehouse();
        //only works IF current sector is at full capaicty (has 5 products already)
        //priority queue - removes least popular item in a full capacity sector

        //ADVICE FROM CAVE: swap 1 and 5, delete last, sink first
        //double Popularity = //initial demand + total amt purchased + date of last purchased
        //initial demand = obtained from survey prior to product release
        //date of last purchase = num of days since store opening that item was purchased
        
        //Sink();

        Sector createSector = sectors[id % 10];
        
        if (createSector.getSize() >= 5){

            createSector.swap(1, 5); 
            createSector.deleteLast(); 
            createSector.sink(1);

        } 
        // else if (createSector.getSize() < 5){
        //     return;
        // }
    }

    /**
     * Update the stock of some item by some amount
     * Requires proper use of the .getSize() and .get() methods in the Sector class
     * Requires proper use of the .updateStock() method in the Product class
     * @param id The id of the item to restock
     * @param amount The amount by which to update the stock
     */
    public void restockProduct(int id, int amount) {
        // IMPLEMENT THIS METHOD ***********************************************************************************************************************
        //update stock
        //use get size
        //use .get

        int idLastNum = id % 10;
        int counter;

        for(counter = 1; counter <= sectors[idLastNum].getSize(); counter++){
            if(sectors[idLastNum].get(counter).getId() == id){

                sectors[idLastNum].get(counter).updateStock(amount);

            } else if(sectors[idLastNum].get(counter).getId() != id){
            }
        }    
    }
    

    
    
    /**
     * Delete some arbitrary product while maintaining the heap structure in O(logn)
     * Requires proper use of the .getSize(), .get(), .swap(), .deleteLast(), .sink() and/or .swim() methods
     * Requires proper use of the .getId() method from the Product class
     * @param id The id of the product to delete
     */
    public void deleteProduct(int id) {
        // IMPLEMENT THIS METHOD ***********************************************************************************************************************
        //delete arbitrary prod
        //maintain O LOG N
        //use .getsize
        //use .get
        //use .swap
        //use .deletelast
        //use .sink
        //or .swim
        //USE .GetID from PRODUCT CLASS

        int counter;
        int idLastNum = id % 10;
        int size = sectors[idLastNum].getSize();
        

        for(counter = 1; counter <= sectors[idLastNum].getSize(); counter++){
            if(sectors[idLastNum].get(counter).getId() == id){

                sectors[idLastNum].swap(counter, sectors[idLastNum].getSize());
                sectors[idLastNum].deleteLast();
                sectors[idLastNum].sink(counter);

            } 
            else if (sectors[idLastNum].get(counter).getId() != id){
            }
        }
    }
    
    /**
     * Simulate a purchase order for some product
     * Requires proper use of the getSize(), sink(), get() methods in the Sector class
     * Requires proper use of the getId(), getStock(), setLastPurchaseDay(), updateStock(), updateDemand() methods
     * @param id The id of the purchased product
     * @param day The current day
     * @param amount The amount purchased
     */
    public void purchaseProduct(int id, int day, int amount) {
        // IMPLEMENT THIS METHOD ***********************************************************************************************************************
        //simulate purchase
        //use get size, sink, and get methods from SECTOR CLASS
        //use getID
        //use getstock
        //use setLastPurchaseDay
        //use updateStock
        //use updateDemand
        int idLastNum = id % 10;
        int counter;

        for(counter = 1; counter <= sectors[idLastNum].getSize(); counter++){
            if(sectors[idLastNum].get(counter).getId() == idLastNum && amount < sectors[idLastNum].get(counter).getStock()){

                sectors[idLastNum].get(counter).updateStock(-(amount));
                sectors[idLastNum].get(counter).setLastPurchaseDay(day);
                sectors[idLastNum].get(counter).updateDemand(amount);
                sectors[idLastNum].sink(counter);

            } 
            else if (sectors[idLastNum].get(counter).getId() != idLastNum && amount < sectors[idLastNum].get(counter).getStock()){
            } else if (sectors[idLastNum].get(counter).getId() == idLastNum && amount > sectors[idLastNum].get(counter).getStock()){
            } else {
            }
            
        }

    }
    
    /**
     * Construct a better scheme to add a product, where empty spaces are always filled
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    public void betterAddProduct(int id, String name, int stock, int day, int demand) {
        // IMPLEMENT THIS METHOD
        int idLastNum = id % 10;
        Sector createSector = sectors[idLastNum];
        int counter = 1;
        int spacer;

       if(sectors[idLastNum].getSize() >= 5){
            spacer = 0;
            if(idLastNum == 9){
                spacer = 0;
            } else if (idLastNum != 9){
                spacer = (1 + idLastNum);
            } 
            
            while (sectors[spacer].getSize() >= 5){
                if(spacer == idLastNum){
                    break;
                } else if (spacer != 9){
                    spacer++;
                } else if (spacer == 9){
                    spacer = 0;
                } else {
                    spacer ++;
                }
            }

            addProduct(spacer, name, stock, day, demand);
        }

        else if(createSector.getSize() < 5) {
                addProduct(id, name, stock, day, demand);
        }

    }
    /*
     * Returns the string representation of the warehouse
     */
    public String toString() {
        String warehouseString = "[\n";

        for (int i = 0; i < 10; i++) {
            warehouseString += "\t" + sectors[i].toString() + "\n";
        }
        
        return warehouseString + "]";
    }

    /*
     * Do not remove this method, it is used by Autolab
     */ 
    public Sector[] getSectors () {
        return sectors;
    }
}