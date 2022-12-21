package avengers;

/**
 * Given a Set of Edges representing Vision's Neural Network, identify all of the 
 * vertices that connect to the Mind Stone. 
 * List the names of these neurons in the output file.
 * 
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * MindStoneNeighborNeuronsInputFile name is passed through the command line as args[0]
 * Read from the MindStoneNeighborNeuronsInputFile with the format:
 *    1. v (int): number of neurons (vertices in the graph)
 *    2. v lines, each with a String referring to a neuron's name (vertex name)
 *    3. e (int): number of synapses (edges in the graph)
 *    4. e lines, each line refers to an edge, each line has 2 (two) Strings: from to
 * 
 * Step 2:
 * MindStoneNeighborNeuronsOutputFile name is passed through the command line as args[1]
 * Identify the vertices that connect to the Mind Stone vertex. 
 * Output these vertices, one per line, to the output file.
 * 
 * Note 1: The Mind Stone vertex has out degree 0 (zero), meaning that there are 
 * no edges leaving the vertex.
 * 
 * Note 2: If a vertex v connects to the Mind Stone vertex m then the graph has
 * an edge v -> m
 * 
 * Note 3: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut:
 *     StdOut.setFile(outputfilename);
 *     //Call StdOut.print() for EVERY neuron (vertex) neighboring the Mind Stone neuron (vertex)
 *  
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/MindStoneNeighborNeurons mindstoneneighborneurons.in mindstoneneighborneurons.out
 *
 * @author Yashas Ravi
 * 
 */

public class MindStoneNeighborNeurons {
    

    private static int neuronIndex(String[] vertexArray, String numOfNeuron) {
        int neuronCounter = 0;
        int num = -1;
        int fillArray = 0;
        int calc;

        int[] updatedArray = new int[fillArray];
        boolean completed = false;

        for(neuronCounter = 0; neuronCounter < vertexArray.length; neuronCounter++ ){
            if(vertexArray[neuronCounter] == null){
            }
            if (vertexArray[neuronCounter] != null) {
                if (vertexArray[neuronCounter].equals(numOfNeuron)) {
                    num = neuronCounter;
                }
                else if (!(vertexArray[neuronCounter].equals(numOfNeuron))){
                }
            } else {
            }
        }
        calc = fillArray;
        completed = true;
        return num;
    }

    public static void main (String [] args) {
        
        if ( args.length < 2 ) {
            StdOut.println("Execute: java MindStoneNeighborNeurons <INput file> <OUTput file>");
            return;
        }
        
        // WRITE YOUR CODE HERE
        //if your code does NOT use the vertex inputs (and only uses the edge inputs) then u can still submit and pass 3f
    
        String MindStoneNeighborNeuronsInputFile = args[0];
        String MindStoneNeighborNeuronsOutputFile = args[1];

        StdIn.setFile(MindStoneNeighborNeuronsInputFile);
    
        int numNeuronVertices = StdIn.readInt();
        String[] numOfNeuron = new String[numNeuronVertices];
        int counter;
        int neuronTracker;

        int index;

        int i;
        int j;

        int vertexCounter;
        int edgeCounter;

        int neuronCounter;

        for(i = 0; i < numNeuronVertices; i++){
            numOfNeuron[i] = StdIn.readString();
            //System.out.print(numOfNeuron[i]);
        }

        int edgeInGraph = StdIn.readInt();
        //System.out.println(edge);

        String[][] numOfEdges = new String[edgeInGraph][edgeInGraph];
       //read file into array

        for (i = 0; i < edgeInGraph; i++ ) {
            for(j = 0; j <= 1; j++) {
                numOfEdges[i][j] = StdIn.readString(); 
                //System.out.println(numOfEdges[i][j]);
            }
        }
        
        //long seed = Math.random();

        boolean isConnected = false; //for output

        int row = 0;
        int col = 0;
        int[][] directions = new int[row][col];

        // for(int i = 0; i < numOfNodes; i++){
        //     for(int j = 0; j < numOfNodes; j++){
        //         adjMatrix[i][j] = StdIn.readInt();

        StdOut.setFile(MindStoneNeighborNeuronsOutputFile);

        for (vertexCounter = 0; vertexCounter < numNeuronVertices; vertexCounter++ ) {
            for(edgeCounter = 0; edgeCounter < edgeInGraph; edgeCounter++) {
                index = neuronIndex(numOfNeuron, numOfEdges[edgeCounter][0]);
                int checkIfNull = 0;

                if (index == -1){
                }
                if (index == 1){
                    numOfNeuron[index] = null;
                }
                if (index == 0){
                    numOfNeuron[index] = null;
                }
                if (index != -1){
                    numOfNeuron[index] = null;
                } else {
                }

              
            }
        }

        // WRITE YOUR CODE HERE
        //delete numNeuronVertices psuedocode
       
        for(neuronCounter = 0; neuronCounter < numOfNeuron.length; neuronCounter++ ){
            if (numOfNeuron[neuronCounter] == null){
            }
            else if (numOfNeuron[neuronCounter] != null) {
                for(edgeCounter = 0; edgeCounter < edgeInGraph; edgeCounter++) {
                    if (!(numOfEdges[edgeCounter][1].equals(numOfNeuron[neuronCounter]))){
                    } 
                    else if ((numOfEdges[edgeCounter][0].equals(numOfNeuron[neuronCounter]))){
                    } 
                    else if (numOfEdges[edgeCounter][1].equals(numOfNeuron[neuronCounter])) {
                        StdOut.println(numOfEdges[edgeCounter][0]);
                    } else {
                    }
                }
            }
        }
        
        // // initialize arraylist for neighbors

        // //  for each numOfNeuron in map keyset:
        // //   if numOfNeuron's adjacency list contains mindstone:
        // //     add the numOfNeuron to arraylist

        // //USE DIRECTED GRAPHS

        //hash sets
        //see whats contained in first one and not in second
        //if going through dfs and start at deepest node, it will hit the mindstone
    }

        // Identify the vertices that connect to the Mind Stone numNeuronVertices
        // Output these vertices, one per line, to the output file
        //finding degree of numNeuronVertices in graph G

        // //   for each numOfNeuron in map keyset:
        // //   if numOfNeuron's adjacency list size is 0 
        // //   set mindstone to numOfNeuron

    
}

        

        


        

       

        

